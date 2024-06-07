//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import javax.swing.event.*;
import javax.swing.plaf.*;
import java.text.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.beans.*;
import org.fife.ui.rsyntaxtextarea.parser.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ErrorStrip extends JPanel
{
    private RSyntaxTextArea textArea;
    private transient Listener listener;
    private boolean showMarkedOccurrences;
    private boolean showMarkAll;
    private Map<Color, Color> brighterColors;
    private ParserNotice.Level levelThreshold;
    private boolean followCaret;
    private Color caretMarkerColor;
    private int caretLineY;
    private int lastLineY;
    private transient ErrorStripMarkerToolTipProvider markerToolTipProvider;
    private static final int PREFERRED_WIDTH = 14;
    private static final ResourceBundle MSG;
    
    public ErrorStrip(final RSyntaxTextArea textArea) {
        this.textArea = textArea;
        this.listener = new Listener();
        ToolTipManager.sharedInstance().registerComponent(this);
        this.setLayout(null);
        this.addMouseListener(this.listener);
        this.setShowMarkedOccurrences(true);
        this.setShowMarkAll(true);
        this.setLevelThreshold(ParserNotice.Level.WARNING);
        this.setFollowCaret(true);
        this.setCaretMarkerColor(this.getDefaultCaretMarkerColor());
        this.setMarkerToolTipProvider(null);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        this.textArea.addCaretListener(this.listener);
        this.textArea.addPropertyChangeListener("RSTA.parserNotices", this.listener);
        this.textArea.addPropertyChangeListener("RSTA.markOccurrences", this.listener);
        this.textArea.addPropertyChangeListener("RSTA.markedOccurrencesChanged", this.listener);
        this.textArea.addPropertyChangeListener("RTA.markAllOccurrencesChanged", this.listener);
        this.refreshMarkers();
    }
    
    @Override
    public void doLayout() {
        for (int i = 0; i < this.getComponentCount(); ++i) {
            final Marker m = (Marker)this.getComponent(i);
            m.updateLocation();
        }
        this.listener.caretUpdate(null);
    }
    
    private Color getBrighterColor(final Color c) {
        if (this.brighterColors == null) {
            this.brighterColors = new HashMap<Color, Color>(5);
        }
        Color brighter = this.brighterColors.get(c);
        if (brighter == null) {
            final int r = possiblyBrighter(c.getRed());
            final int g = possiblyBrighter(c.getGreen());
            final int b = possiblyBrighter(c.getBlue());
            brighter = new Color(r, g, b);
            this.brighterColors.put(c, brighter);
        }
        return brighter;
    }
    
    public Color getCaretMarkerColor() {
        return this.caretMarkerColor;
    }
    
    private ColorUIResource getDefaultCaretMarkerColor() {
        if (RSyntaxUtilities.isLightForeground(this.getForeground())) {
            return new ColorUIResource(this.textArea.getCaretColor());
        }
        return new ColorUIResource(Color.BLACK);
    }
    
    public boolean getFollowCaret() {
        return this.followCaret;
    }
    
    @Override
    public Dimension getPreferredSize() {
        final int height = this.textArea.getPreferredScrollableViewportSize().height;
        return new Dimension(14, height);
    }
    
    public ParserNotice.Level getLevelThreshold() {
        return this.levelThreshold;
    }
    
    public boolean getShowMarkAll() {
        return this.showMarkAll;
    }
    
    public boolean getShowMarkedOccurrences() {
        return this.showMarkedOccurrences;
    }
    
    @Override
    public String getToolTipText(final MouseEvent e) {
        String text = null;
        final int line = this.yToLine(e.getY());
        if (line > -1) {
            text = ErrorStrip.MSG.getString("Line");
            text = MessageFormat.format(text, line + 1);
        }
        return text;
    }
    
    private int lineToY(final int line) {
        final int h = this.textArea.getVisibleRect().height;
        final float lineCount = (float)this.textArea.getLineCount();
        return (int)((line - 1) / (lineCount - 1.0f) * (h - 2));
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (this.caretLineY > -1) {
            g.setColor(this.getCaretMarkerColor());
            g.fillRect(0, this.caretLineY, this.getWidth(), 2);
        }
    }
    
    private static int possiblyBrighter(int i) {
        if (i < 255) {
            i += (int)((255 - i) * 0.8f);
        }
        return i;
    }
    
    private void refreshMarkers() {
        this.removeAll();
        final Map<Integer, Marker> markerMap = new HashMap<Integer, Marker>();
        final List<ParserNotice> notices = this.textArea.getParserNotices();
        for (final ParserNotice notice : notices) {
            if (notice.getLevel().isEqualToOrWorseThan(this.levelThreshold) || notice instanceof TaskTagParser.TaskNotice) {
                final Integer key = notice.getLine();
                Marker m = markerMap.get(key);
                if (m == null) {
                    m = new Marker(notice);
                    m.addMouseListener(this.listener);
                    markerMap.put(key, m);
                    this.add(m);
                }
                else {
                    m.addNotice(notice);
                }
            }
        }
        if (this.getShowMarkedOccurrences() && this.textArea.getMarkOccurrences()) {
            final List<DocumentRange> occurrences = this.textArea.getMarkedOccurrences();
            this.addMarkersForRanges(occurrences, markerMap, this.textArea.getMarkOccurrencesColor());
        }
        if (this.getShowMarkAll()) {
            final Color markAllColor = this.textArea.getMarkAllHighlightColor();
            final List<DocumentRange> ranges = this.textArea.getMarkAllHighlightRanges();
            this.addMarkersForRanges(ranges, markerMap, markAllColor);
        }
        this.revalidate();
        this.repaint();
    }
    
    private void addMarkersForRanges(final List<DocumentRange> ranges, final Map<Integer, Marker> markerMap, final Color color) {
        for (final DocumentRange range : ranges) {
            int line = 0;
            try {
                line = this.textArea.getLineOfOffset(range.getStartOffset());
            }
            catch (BadLocationException ble) {
                continue;
            }
            final ParserNotice notice = new MarkedOccurrenceNotice(range, color);
            final Integer key = line;
            Marker m = markerMap.get(key);
            if (m == null) {
                m = new Marker(notice);
                m.addMouseListener(this.listener);
                markerMap.put(key, m);
                this.add(m);
            }
            else {
                if (m.containsMarkedOccurence()) {
                    continue;
                }
                m.addNotice(notice);
            }
        }
    }
    
    @Override
    public void removeNotify() {
        super.removeNotify();
        this.textArea.removeCaretListener(this.listener);
        this.textArea.removePropertyChangeListener("RSTA.parserNotices", this.listener);
        this.textArea.removePropertyChangeListener("RSTA.markOccurrences", this.listener);
        this.textArea.removePropertyChangeListener("RSTA.markedOccurrencesChanged", this.listener);
        this.textArea.removePropertyChangeListener("RTA.markAllOccurrencesChanged", this.listener);
    }
    
    public void setCaretMarkerColor(final Color color) {
        if (color != null) {
            this.caretMarkerColor = color;
            this.listener.caretUpdate(null);
        }
    }
    
    public void setFollowCaret(final boolean follow) {
        if (this.followCaret != follow) {
            if (this.followCaret) {
                this.repaint(0, this.caretLineY, this.getWidth(), 2);
            }
            this.caretLineY = -1;
            this.lastLineY = -1;
            this.followCaret = follow;
            this.listener.caretUpdate(null);
        }
    }
    
    public void setLevelThreshold(final ParserNotice.Level level) {
        this.levelThreshold = level;
        if (this.isDisplayable()) {
            this.refreshMarkers();
        }
    }
    
    public void setMarkerToolTipProvider(final ErrorStripMarkerToolTipProvider provider) {
        this.markerToolTipProvider = ((provider != null) ? provider : new DefaultErrorStripMarkerToolTipProvider());
    }
    
    public void setShowMarkAll(final boolean show) {
        if (show != this.showMarkAll) {
            this.showMarkAll = show;
            if (this.isDisplayable()) {
                this.refreshMarkers();
            }
        }
    }
    
    public void setShowMarkedOccurrences(final boolean show) {
        if (show != this.showMarkedOccurrences) {
            this.showMarkedOccurrences = show;
            if (this.isDisplayable()) {
                this.refreshMarkers();
            }
        }
    }
    
    @Override
    public void updateUI() {
        super.updateUI();
        if (this.caretMarkerColor instanceof ColorUIResource) {
            this.setCaretMarkerColor(this.getDefaultCaretMarkerColor());
        }
    }
    
    private int yToLine(final int y) {
        int line = -1;
        final int h = this.textArea.getVisibleRect().height;
        if (y < h) {
            final float at = y / (float)h;
            line = Math.round((this.textArea.getLineCount() - 1) * at);
        }
        return line;
    }
    
    static {
        MSG = ResourceBundle.getBundle("org.fife.ui.rsyntaxtextarea.ErrorStrip");
    }
    
    private static class DefaultErrorStripMarkerToolTipProvider implements ErrorStripMarkerToolTipProvider
    {
        @Override
        public String getToolTipText(final List<ParserNotice> notices) {
            String text;
            if (notices.size() == 1) {
                text = notices.get(0).getMessage();
            }
            else {
                final StringBuilder sb = new StringBuilder("<html>");
                sb.append(ErrorStrip.MSG.getString("MultipleMarkers"));
                sb.append("<br>");
                for (final ParserNotice pn : notices) {
                    sb.append("&nbsp;&nbsp;&nbsp;- ");
                    sb.append(pn.getMessage());
                    sb.append("<br>");
                }
                text = sb.toString();
            }
            return text;
        }
    }
    
    private class Listener extends MouseAdapter implements PropertyChangeListener, CaretListener
    {
        private Rectangle visibleRect;
        
        private Listener() {
            this.visibleRect = new Rectangle();
        }
        
        @Override
        public void caretUpdate(final CaretEvent e) {
            if (ErrorStrip.this.getFollowCaret()) {
                final int line = ErrorStrip.this.textArea.getCaretLineNumber();
                final float percent = line / (float)(ErrorStrip.this.textArea.getLineCount() - 1);
                ErrorStrip.this.textArea.computeVisibleRect(this.visibleRect);
                ErrorStrip.this.caretLineY = (int)(this.visibleRect.height * percent);
                if (ErrorStrip.this.caretLineY != ErrorStrip.this.lastLineY) {
                    ErrorStrip.this.repaint(0, ErrorStrip.this.lastLineY, ErrorStrip.this.getWidth(), 2);
                    ErrorStrip.this.repaint(0, ErrorStrip.this.caretLineY, ErrorStrip.this.getWidth(), 2);
                    ErrorStrip.this.lastLineY = ErrorStrip.this.caretLineY;
                }
            }
        }
        
        @Override
        public void mouseClicked(final MouseEvent e) {
            final Component source = (Component)e.getSource();
            if (source instanceof Marker) {
                ((Marker)source).mouseClicked(e);
                return;
            }
            final int line = ErrorStrip.this.yToLine(e.getY());
            if (line > -1) {
                try {
                    final int offs = ErrorStrip.this.textArea.getLineStartOffset(line);
                    ErrorStrip.this.textArea.setCaretPosition(offs);
                }
                catch (BadLocationException ble) {
                    UIManager.getLookAndFeel().provideErrorFeedback(ErrorStrip.this.textArea);
                }
            }
        }
        
        @Override
        public void propertyChange(final PropertyChangeEvent e) {
            final String propName = e.getPropertyName();
            if ("RSTA.markOccurrences".equals(propName)) {
                if (ErrorStrip.this.getShowMarkedOccurrences()) {
                    ErrorStrip.this.refreshMarkers();
                }
            }
            else if ("RSTA.parserNotices".equals(propName)) {
                ErrorStrip.this.refreshMarkers();
            }
            else if ("RSTA.markedOccurrencesChanged".equals(propName)) {
                if (ErrorStrip.this.getShowMarkedOccurrences()) {
                    ErrorStrip.this.refreshMarkers();
                }
            }
            else if ("RTA.markAllOccurrencesChanged".equals(propName) && ErrorStrip.this.getShowMarkAll()) {
                ErrorStrip.this.refreshMarkers();
            }
        }
    }
    
    private class MarkedOccurrenceNotice implements ParserNotice
    {
        private DocumentRange range;
        private Color color;
        
        MarkedOccurrenceNotice(final DocumentRange range, final Color color) {
            this.range = range;
            this.color = color;
        }
        
        @Override
        public int compareTo(final ParserNotice other) {
            return 0;
        }
        
        @Override
        public boolean containsPosition(final int pos) {
            return pos >= this.range.getStartOffset() && pos < this.range.getEndOffset();
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof ParserNotice && this.compareTo((ParserNotice)o) == 0;
        }
        
        @Override
        public Color getColor() {
            return this.color;
        }
        
        @Override
        public boolean getKnowsOffsetAndLength() {
            return true;
        }
        
        @Override
        public int getLength() {
            return this.range.getEndOffset() - this.range.getStartOffset();
        }
        
        @Override
        public Level getLevel() {
            return Level.INFO;
        }
        
        @Override
        public int getLine() {
            try {
                return ErrorStrip.this.textArea.getLineOfOffset(this.range.getStartOffset()) + 1;
            }
            catch (BadLocationException ble) {
                return 0;
            }
        }
        
        @Override
        public String getMessage() {
            String text = null;
            try {
                final String word = ErrorStrip.this.textArea.getText(this.range.getStartOffset(), this.getLength());
                text = ErrorStrip.MSG.getString("OccurrenceOf");
                text = MessageFormat.format(text, word);
            }
            catch (BadLocationException ble) {
                UIManager.getLookAndFeel().provideErrorFeedback(ErrorStrip.this.textArea);
            }
            return text;
        }
        
        @Override
        public int getOffset() {
            return this.range.getStartOffset();
        }
        
        @Override
        public Parser getParser() {
            return null;
        }
        
        @Override
        public boolean getShowInEditor() {
            return false;
        }
        
        @Override
        public String getToolTipText() {
            return null;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
    }
    
    private class Marker extends JComponent
    {
        private List<ParserNotice> notices;
        
        Marker(final ParserNotice notice) {
            this.notices = new ArrayList<ParserNotice>(1);
            this.addNotice(notice);
            this.setCursor(Cursor.getPredefinedCursor(12));
            this.setSize(this.getPreferredSize());
            ToolTipManager.sharedInstance().registerComponent(this);
        }
        
        public void addNotice(final ParserNotice notice) {
            this.notices.add(notice);
        }
        
        public boolean containsMarkedOccurence() {
            boolean result = false;
            for (final ParserNotice notice : this.notices) {
                if (notice instanceof MarkedOccurrenceNotice) {
                    result = true;
                    break;
                }
            }
            return result;
        }
        
        public Color getColor() {
            Color c = null;
            int lowestLevel = Integer.MAX_VALUE;
            for (final ParserNotice notice : this.notices) {
                if (notice.getLevel().getNumericValue() < lowestLevel) {
                    lowestLevel = notice.getLevel().getNumericValue();
                    c = notice.getColor();
                }
            }
            return c;
        }
        
        @Override
        public Dimension getPreferredSize() {
            final int w = 10;
            return new Dimension(w, 5);
        }
        
        @Override
        public String getToolTipText() {
            return ErrorStrip.this.markerToolTipProvider.getToolTipText(Collections.unmodifiableList((List<? extends ParserNotice>)this.notices));
        }
        
        protected void mouseClicked(final MouseEvent e) {
            final ParserNotice pn = this.notices.get(0);
            int offs = pn.getOffset();
            final int len = pn.getLength();
            if (offs > -1 && len > -1) {
                final DocumentRange range = new DocumentRange(offs, offs + len);
                RSyntaxUtilities.selectAndPossiblyCenter(ErrorStrip.this.textArea, range, true);
            }
            else {
                final int line = pn.getLine();
                try {
                    offs = ErrorStrip.this.textArea.getLineStartOffset(line);
                    ErrorStrip.this.textArea.getFoldManager().ensureOffsetNotInClosedFold(offs);
                    ErrorStrip.this.textArea.setCaretPosition(offs);
                }
                catch (BadLocationException ble) {
                    UIManager.getLookAndFeel().provideErrorFeedback(ErrorStrip.this.textArea);
                }
            }
        }
        
        @Override
        protected void paintComponent(final Graphics g) {
            Color borderColor = this.getColor();
            if (borderColor == null) {
                borderColor = Color.DARK_GRAY;
            }
            final Color fillColor = ErrorStrip.this.getBrighterColor(borderColor);
            final int w = this.getWidth();
            final int h = this.getHeight();
            g.setColor(fillColor);
            g.fillRect(0, 0, w, h);
            g.setColor(borderColor);
            g.drawRect(0, 0, w - 1, h - 1);
        }
        
        @Override
        public void removeNotify() {
            super.removeNotify();
            ToolTipManager.sharedInstance().unregisterComponent(this);
            this.removeMouseListener(ErrorStrip.this.listener);
        }
        
        public void updateLocation() {
            final int line = this.notices.get(0).getLine();
            final int y = ErrorStrip.this.lineToY(line);
            this.setLocation(2, y);
        }
    }
    
    public interface ErrorStripMarkerToolTipProvider
    {
        String getToolTipText(final List<ParserNotice> p0);
    }
}
