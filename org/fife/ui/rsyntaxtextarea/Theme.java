//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import org.fife.ui.rtextarea.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.*;
import javax.swing.text.*;
import javax.xml.transform.dom.*;
import org.fife.io.*;
import java.io.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.lang.reflect.*;
import javax.xml.transform.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class Theme
{
    public Font baseFont;
    public Color bgColor;
    public Color caretColor;
    public boolean useSelectionFG;
    public Color selectionFG;
    public Color selectionBG;
    public boolean selectionRoundedEdges;
    public Color currentLineHighlight;
    public boolean fadeCurrentLineHighlight;
    public Color tabLineColor;
    public Color marginLineColor;
    public Color markAllHighlightColor;
    public Color markOccurrencesColor;
    public boolean markOccurrencesBorder;
    public Color matchedBracketFG;
    public Color matchedBracketBG;
    public boolean matchedBracketHighlightBoth;
    public boolean matchedBracketAnimate;
    public Color hyperlinkFG;
    public Color[] secondaryLanguages;
    public SyntaxScheme scheme;
    public Color gutterBackgroundColor;
    public Color gutterBorderColor;
    public Color activeLineRangeColor;
    public boolean iconRowHeaderInheritsGutterBG;
    public Color lineNumberColor;
    public String lineNumberFont;
    public int lineNumberFontSize;
    public Color foldIndicatorFG;
    public Color foldBG;
    public Color armedFoldBG;
    
    private Theme(final Font baseFont) {
        this.baseFont = ((baseFont != null) ? baseFont : RTextAreaBase.getDefaultFont());
        this.secondaryLanguages = new Color[3];
        this.activeLineRangeColor = Gutter.DEFAULT_ACTIVE_LINE_RANGE_COLOR;
    }
    
    public Theme(final RSyntaxTextArea textArea) {
        this.baseFont = textArea.getFont();
        this.bgColor = textArea.getBackground();
        this.caretColor = textArea.getCaretColor();
        this.useSelectionFG = textArea.getUseSelectedTextColor();
        this.selectionFG = textArea.getSelectedTextColor();
        this.selectionBG = textArea.getSelectionColor();
        this.selectionRoundedEdges = textArea.getRoundedSelectionEdges();
        this.currentLineHighlight = textArea.getCurrentLineHighlightColor();
        this.fadeCurrentLineHighlight = textArea.getFadeCurrentLineHighlight();
        this.tabLineColor = textArea.getTabLineColor();
        this.marginLineColor = textArea.getMarginLineColor();
        this.markAllHighlightColor = textArea.getMarkAllHighlightColor();
        this.markOccurrencesColor = textArea.getMarkOccurrencesColor();
        this.markOccurrencesBorder = textArea.getPaintMarkOccurrencesBorder();
        this.matchedBracketBG = textArea.getMatchedBracketBGColor();
        this.matchedBracketFG = textArea.getMatchedBracketBorderColor();
        this.matchedBracketHighlightBoth = textArea.getPaintMatchedBracketPair();
        this.matchedBracketAnimate = textArea.getAnimateBracketMatching();
        this.hyperlinkFG = textArea.getHyperlinkForeground();
        final int count = textArea.getSecondaryLanguageCount();
        this.secondaryLanguages = new Color[count];
        for (int i = 0; i < count; ++i) {
            this.secondaryLanguages[i] = textArea.getSecondaryLanguageBackground(i + 1);
        }
        this.scheme = textArea.getSyntaxScheme();
        final Gutter gutter = RSyntaxUtilities.getGutter((RTextArea)textArea);
        if (gutter != null) {
            this.gutterBackgroundColor = gutter.getBackground();
            this.gutterBorderColor = gutter.getBorderColor();
            this.activeLineRangeColor = gutter.getActiveLineRangeColor();
            this.iconRowHeaderInheritsGutterBG = gutter.getIconRowHeaderInheritsGutterBackground();
            this.lineNumberColor = gutter.getLineNumberColor();
            this.lineNumberFont = gutter.getLineNumberFont().getFamily();
            this.lineNumberFontSize = gutter.getLineNumberFont().getSize();
            this.foldIndicatorFG = gutter.getFoldIndicatorForeground();
            this.foldBG = gutter.getFoldBackground();
            this.armedFoldBG = gutter.getArmedFoldBackground();
        }
    }
    
    public void apply(final RSyntaxTextArea textArea) {
        textArea.setFont(this.baseFont);
        textArea.setBackground(this.bgColor);
        textArea.setCaretColor(this.caretColor);
        textArea.setUseSelectedTextColor(this.useSelectionFG);
        textArea.setSelectedTextColor(this.selectionFG);
        textArea.setSelectionColor(this.selectionBG);
        textArea.setRoundedSelectionEdges(this.selectionRoundedEdges);
        textArea.setCurrentLineHighlightColor(this.currentLineHighlight);
        textArea.setFadeCurrentLineHighlight(this.fadeCurrentLineHighlight);
        textArea.setTabLineColor(this.tabLineColor);
        textArea.setMarginLineColor(this.marginLineColor);
        textArea.setMarkAllHighlightColor(this.markAllHighlightColor);
        textArea.setMarkOccurrencesColor(this.markOccurrencesColor);
        textArea.setPaintMarkOccurrencesBorder(this.markOccurrencesBorder);
        textArea.setMatchedBracketBGColor(this.matchedBracketBG);
        textArea.setMatchedBracketBorderColor(this.matchedBracketFG);
        textArea.setPaintMatchedBracketPair(this.matchedBracketHighlightBoth);
        textArea.setAnimateBracketMatching(this.matchedBracketAnimate);
        textArea.setHyperlinkForeground(this.hyperlinkFG);
        for (int count = this.secondaryLanguages.length, i = 0; i < count; ++i) {
            textArea.setSecondaryLanguageBackground(i + 1, this.secondaryLanguages[i]);
        }
        textArea.setSyntaxScheme(this.scheme);
        final Gutter gutter = RSyntaxUtilities.getGutter((RTextArea)textArea);
        if (gutter != null) {
            gutter.setBackground(this.gutterBackgroundColor);
            gutter.setBorderColor(this.gutterBorderColor);
            gutter.setActiveLineRangeColor(this.activeLineRangeColor);
            gutter.setIconRowHeaderInheritsGutterBackground(this.iconRowHeaderInheritsGutterBG);
            gutter.setLineNumberColor(this.lineNumberColor);
            final String fontName = (this.lineNumberFont != null) ? this.lineNumberFont : this.baseFont.getFamily();
            final int fontSize = (this.lineNumberFontSize > 0) ? this.lineNumberFontSize : this.baseFont.getSize();
            final Font font = getFont(fontName, 0, fontSize);
            gutter.setLineNumberFont(font);
            gutter.setFoldIndicatorForeground(this.foldIndicatorFG);
            gutter.setFoldBackground(this.foldBG);
            gutter.setArmedFoldBackground(this.armedFoldBG);
        }
    }
    
    private static String colorToString(final Color c) {
        final int color = c.getRGB() & 0xFFFFFF;
        final StringBuilder stringBuilder = new StringBuilder(Integer.toHexString(color));
        while (stringBuilder.length() < 6) {
            stringBuilder.insert(0, "0");
        }
        return stringBuilder.toString();
    }
    
    private static Color getDefaultBG() {
        Color c = UIManager.getColor("nimbusLightBackground");
        if (c == null) {
            c = UIManager.getColor("TextArea.background");
            if (c == null) {
                c = new ColorUIResource(SystemColor.text);
            }
        }
        return c;
    }
    
    private static Color getDefaultSelectionBG() {
        Color c = UIManager.getColor("TextArea.selectionBackground");
        if (c == null) {
            c = UIManager.getColor("textHighlight");
            if (c == null) {
                c = UIManager.getColor("nimbusSelectionBackground");
                if (c == null) {
                    c = new ColorUIResource(SystemColor.textHighlight);
                }
            }
        }
        return c;
    }
    
    private static Color getDefaultSelectionFG() {
        Color c = UIManager.getColor("TextArea.selectionForeground");
        if (c == null) {
            c = UIManager.getColor("textHighlightText");
            if (c == null) {
                c = UIManager.getColor("nimbusSelectedText");
                if (c == null) {
                    c = new ColorUIResource(SystemColor.textHighlightText);
                }
            }
        }
        return c;
    }
    
    private static Font getFont(final String family, final int style, final int size) {
        final StyleContext sc = StyleContext.getDefaultStyleContext();
        return sc.getFont(family, style, size);
    }
    
    public static Theme load(final InputStream in) throws IOException {
        return load(in, null);
    }
    
    public static Theme load(final InputStream in, final Font baseFont) throws IOException {
        final Theme theme = new Theme(baseFont);
        try (final BufferedInputStream bin = new BufferedInputStream(in)) {
            XmlHandler.load(theme, bin);
        }
        return theme;
    }
    
    public void save(final OutputStream out) throws IOException {
        try (final BufferedOutputStream bout = new BufferedOutputStream(out)) {
            final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            final DOMImplementation impl = db.getDOMImplementation();
            final Document doc = impl.createDocument(null, "RSyntaxTheme", null);
            final Element root = doc.getDocumentElement();
            root.setAttribute("version", "1.0");
            Element elem = doc.createElement("baseFont");
            if (!this.baseFont.getFamily().equals(RSyntaxTextArea.getDefaultFont().getFamily())) {
                elem.setAttribute("family", this.baseFont.getFamily());
            }
            elem.setAttribute("size", Integer.toString(this.baseFont.getSize()));
            root.appendChild(elem);
            elem = doc.createElement("background");
            elem.setAttribute("color", colorToString(this.bgColor));
            root.appendChild(elem);
            elem = doc.createElement("caret");
            elem.setAttribute("color", colorToString(this.caretColor));
            root.appendChild(elem);
            elem = doc.createElement("selection");
            elem.setAttribute("useFG", Boolean.toString(this.useSelectionFG));
            elem.setAttribute("fg", colorToString(this.selectionFG));
            elem.setAttribute("bg", colorToString(this.selectionBG));
            elem.setAttribute("roundedEdges", Boolean.toString(this.selectionRoundedEdges));
            root.appendChild(elem);
            elem = doc.createElement("currentLineHighlight");
            elem.setAttribute("color", colorToString(this.currentLineHighlight));
            elem.setAttribute("fade", Boolean.toString(this.fadeCurrentLineHighlight));
            root.appendChild(elem);
            elem = doc.createElement("tabLine");
            elem.setAttribute("color", colorToString(this.tabLineColor));
            root.appendChild(elem);
            elem = doc.createElement("marginLine");
            elem.setAttribute("fg", colorToString(this.marginLineColor));
            root.appendChild(elem);
            elem = doc.createElement("markAllHighlight");
            elem.setAttribute("color", colorToString(this.markAllHighlightColor));
            root.appendChild(elem);
            elem = doc.createElement("markOccurrencesHighlight");
            elem.setAttribute("color", colorToString(this.markOccurrencesColor));
            elem.setAttribute("border", Boolean.toString(this.markOccurrencesBorder));
            root.appendChild(elem);
            elem = doc.createElement("matchedBracket");
            elem.setAttribute("fg", colorToString(this.matchedBracketFG));
            elem.setAttribute("bg", colorToString(this.matchedBracketBG));
            elem.setAttribute("highlightBoth", Boolean.toString(this.matchedBracketHighlightBoth));
            elem.setAttribute("animate", Boolean.toString(this.matchedBracketAnimate));
            root.appendChild(elem);
            elem = doc.createElement("hyperlinks");
            elem.setAttribute("fg", colorToString(this.hyperlinkFG));
            root.appendChild(elem);
            elem = doc.createElement("secondaryLanguages");
            for (int i = 0; i < this.secondaryLanguages.length; ++i) {
                final Color color = this.secondaryLanguages[i];
                final Element elem2 = doc.createElement("language");
                elem2.setAttribute("index", Integer.toString(i + 1));
                elem2.setAttribute("bg", (color == null) ? "" : colorToString(color));
                elem.appendChild(elem2);
            }
            root.appendChild(elem);
            elem = doc.createElement("gutterBackground");
            elem.setAttribute("color", colorToString(this.gutterBackgroundColor));
            root.appendChild(elem);
            elem = doc.createElement("gutterBorder");
            elem.setAttribute("color", colorToString(this.gutterBorderColor));
            root.appendChild(elem);
            elem = doc.createElement("lineNumbers");
            elem.setAttribute("fg", colorToString(this.lineNumberColor));
            if (this.lineNumberFont != null) {
                elem.setAttribute("fontFamily", this.lineNumberFont);
            }
            if (this.lineNumberFontSize > 0) {
                elem.setAttribute("fontSize", Integer.toString(this.lineNumberFontSize));
            }
            root.appendChild(elem);
            elem = doc.createElement("foldIndicator");
            elem.setAttribute("fg", colorToString(this.foldIndicatorFG));
            elem.setAttribute("iconBg", colorToString(this.foldBG));
            elem.setAttribute("iconArmedBg", colorToString(this.armedFoldBG));
            root.appendChild(elem);
            elem = doc.createElement("iconRowHeader");
            elem.setAttribute("activeLineRange", colorToString(this.activeLineRangeColor));
            elem.setAttribute("inheritsGutterBG", Boolean.toString(this.iconRowHeaderInheritsGutterBG));
            root.appendChild(elem);
            elem = doc.createElement("tokenStyles");
            final Field[] fields2;
            final Field[] fields = fields2 = TokenTypes.class.getFields();
            for (final Field field : fields2) {
                final int value = field.getInt(null);
                if (value != 39) {
                    final Style style = this.scheme.getStyle(value);
                    if (style != null) {
                        final Element elem3 = doc.createElement("style");
                        elem3.setAttribute("token", field.getName());
                        final Color fg = style.foreground;
                        if (fg != null) {
                            elem3.setAttribute("fg", colorToString(fg));
                        }
                        final Color bg = style.background;
                        if (bg != null) {
                            elem3.setAttribute("bg", colorToString(bg));
                        }
                        final Font font = style.font;
                        if (font != null) {
                            if (!font.getFamily().equals(this.baseFont.getFamily())) {
                                elem3.setAttribute("fontFamily", font.getFamily());
                            }
                            if (font.getSize() != this.baseFont.getSize()) {
                                elem3.setAttribute("fontSize", Integer.toString(font.getSize()));
                            }
                            if (font.isBold()) {
                                elem3.setAttribute("bold", "true");
                            }
                            if (font.isItalic()) {
                                elem3.setAttribute("italic", "true");
                            }
                        }
                        if (style.underline) {
                            elem3.setAttribute("underline", "true");
                        }
                        elem.appendChild(elem3);
                    }
                }
            }
            root.appendChild(elem);
            final DOMSource source = new DOMSource(doc);
            final StreamResult result = new StreamResult(new PrintWriter((Writer)new UnicodeWriter((OutputStream)bout, "UTF-8")));
            final TransformerFactory transFac = TransformerFactory.newInstance();
            final Transformer transformer = transFac.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty("encoding", "UTF-8");
            transformer.setOutputProperty("doctype-system", "theme.dtd");
            transformer.transform(source, result);
        }
        catch (RuntimeException re) {
            throw re;
        }
        catch (Exception e) {
            throw new IOException("Error generating XML: " + e.getMessage(), e);
        }
    }
    
    private static Color stringToColor(final String s) {
        return stringToColor(s, null);
    }
    
    private static Color stringToColor(String s, final Color defaultVal) {
        if (s == null || "default".equalsIgnoreCase(s)) {
            return defaultVal;
        }
        if (s.length() == 6 || s.length() == 7) {
            if (s.charAt(0) == '$') {
                s = s.substring(1);
            }
            return new Color(Integer.parseInt(s, 16));
        }
        return null;
    }
    
    private static class XmlHandler extends DefaultHandler
    {
        private Theme theme;
        
        @Override
        public void error(final SAXParseException e) throws SAXException {
            throw e;
        }
        
        @Override
        public void fatalError(final SAXParseException e) throws SAXException {
            throw e;
        }
        
        public static void load(final Theme theme, final InputStream in) throws IOException {
            final SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setValidating(true);
            try {
                final SAXParser parser = spf.newSAXParser();
                final XMLReader reader = parser.getXMLReader();
                final XmlHandler handler = new XmlHandler();
                handler.theme = theme;
                reader.setEntityResolver(handler);
                reader.setContentHandler(handler);
                reader.setDTDHandler(handler);
                reader.setErrorHandler(handler);
                final InputSource is = new InputSource(in);
                is.setEncoding("UTF-8");
                reader.parse(is);
            }
            catch (Exception se) {
                throw new IOException(se.toString());
            }
        }
        
        private static int parseInt(final Attributes attrs, final String attr, final int def) {
            int value = def;
            final String temp = attrs.getValue(attr);
            if (temp != null) {
                try {
                    value = Integer.parseInt(temp);
                }
                catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
            }
            return value;
        }
        
        @Override
        public InputSource resolveEntity(final String publicID, final String systemID) {
            return new InputSource(this.getClass().getResourceAsStream("themes/theme.dtd"));
        }
        
        @Override
        public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) {
            if ("background".equals(qName)) {
                final String color = attrs.getValue("color");
                if (color != null) {
                    this.theme.bgColor = stringToColor(color, getDefaultBG());
                    this.theme.gutterBackgroundColor = this.theme.bgColor;
                }
                else {
                    final String img = attrs.getValue("image");
                    if (img != null) {
                        throw new IllegalArgumentException("Not yet implemented");
                    }
                }
            }
            else if ("baseFont".equals(qName)) {
                int size = this.theme.baseFont.getSize();
                final String sizeStr = attrs.getValue("size");
                if (sizeStr != null) {
                    size = Integer.parseInt(sizeStr);
                }
                final String family = attrs.getValue("family");
                if (family != null) {
                    this.theme.baseFont = getFont(family, 0, size);
                }
                else if (sizeStr != null) {
                    this.theme.baseFont = this.theme.baseFont.deriveFont(size * 1.0f);
                }
            }
            else if ("caret".equals(qName)) {
                final String color = attrs.getValue("color");
                this.theme.caretColor = stringToColor(color);
            }
            else if ("currentLineHighlight".equals(qName)) {
                final String color = attrs.getValue("color");
                this.theme.currentLineHighlight = stringToColor(color);
                final String fadeStr = attrs.getValue("fade");
                final boolean fade = Boolean.parseBoolean(fadeStr);
                this.theme.fadeCurrentLineHighlight = fade;
            }
            else if ("tabLine".equals(qName)) {
                final String color = attrs.getValue("color");
                this.theme.tabLineColor = stringToColor(color);
            }
            else if ("foldIndicator".equals(qName)) {
                String color = attrs.getValue("fg");
                this.theme.foldIndicatorFG = stringToColor(color);
                color = attrs.getValue("iconBg");
                this.theme.foldBG = stringToColor(color);
                color = attrs.getValue("iconArmedBg");
                this.theme.armedFoldBG = stringToColor(color, this.theme.foldBG);
            }
            else if ("gutterBackground".equals(qName)) {
                final String color = attrs.getValue("color");
                if (color != null) {
                    this.theme.gutterBackgroundColor = stringToColor(color);
                }
            }
            else if ("gutterBorder".equals(qName)) {
                final String color = attrs.getValue("color");
                this.theme.gutterBorderColor = stringToColor(color);
            }
            else if ("iconRowHeader".equals(qName)) {
                final String color = attrs.getValue("activeLineRange");
                this.theme.activeLineRangeColor = stringToColor(color);
                final String inheritBGStr = attrs.getValue("inheritsGutterBG");
                this.theme.iconRowHeaderInheritsGutterBG = Boolean.parseBoolean(inheritBGStr);
            }
            else if ("lineNumbers".equals(qName)) {
                final String color = attrs.getValue("fg");
                this.theme.lineNumberColor = stringToColor(color);
                this.theme.lineNumberFont = attrs.getValue("fontFamily");
                this.theme.lineNumberFontSize = parseInt(attrs, "fontSize", -1);
            }
            else if ("marginLine".equals(qName)) {
                final String color = attrs.getValue("fg");
                this.theme.marginLineColor = stringToColor(color);
            }
            else if ("markAllHighlight".equals(qName)) {
                final String color = attrs.getValue("color");
                this.theme.markAllHighlightColor = stringToColor(color);
            }
            else if ("markOccurrencesHighlight".equals(qName)) {
                final String color = attrs.getValue("color");
                this.theme.markOccurrencesColor = stringToColor(color);
                final String border = attrs.getValue("border");
                this.theme.markOccurrencesBorder = Boolean.parseBoolean(border);
            }
            else if ("matchedBracket".equals(qName)) {
                final String fg = attrs.getValue("fg");
                this.theme.matchedBracketFG = stringToColor(fg);
                final String bg = attrs.getValue("bg");
                this.theme.matchedBracketBG = stringToColor(bg);
                final String highlightBoth = attrs.getValue("highlightBoth");
                this.theme.matchedBracketHighlightBoth = Boolean.parseBoolean(highlightBoth);
                final String animate = attrs.getValue("animate");
                this.theme.matchedBracketAnimate = Boolean.parseBoolean(animate);
            }
            else if ("hyperlinks".equals(qName)) {
                final String fg = attrs.getValue("fg");
                this.theme.hyperlinkFG = stringToColor(fg);
            }
            else if ("language".equals(qName)) {
                final String indexStr = attrs.getValue("index");
                final int index = Integer.parseInt(indexStr) - 1;
                if (this.theme.secondaryLanguages.length > index) {
                    final Color bg2 = stringToColor(attrs.getValue("bg"));
                    this.theme.secondaryLanguages[index] = bg2;
                }
            }
            else if ("selection".equals(qName)) {
                final String useStr = attrs.getValue("useFG");
                this.theme.useSelectionFG = Boolean.parseBoolean(useStr);
                String color2 = attrs.getValue("fg");
                this.theme.selectionFG = stringToColor(color2, getDefaultSelectionFG());
                color2 = attrs.getValue("bg");
                this.theme.selectionBG = stringToColor(color2, getDefaultSelectionBG());
                final String roundedStr = attrs.getValue("roundedEdges");
                this.theme.selectionRoundedEdges = Boolean.parseBoolean(roundedStr);
            }
            else if ("tokenStyles".equals(qName)) {
                this.theme.scheme = new SyntaxScheme(this.theme.baseFont, false);
            }
            else if ("style".equals(qName)) {
                final String type = attrs.getValue("token");
                Field field = null;
                try {
                    field = Token.class.getField(type);
                }
                catch (RuntimeException re) {
                    throw re;
                }
                catch (Exception e2) {
                    System.err.println("Invalid token type: " + type);
                    return;
                }
                if (field.getType() == Integer.TYPE) {
                    int index2 = 0;
                    try {
                        index2 = field.getInt(this.theme.scheme);
                    }
                    catch (IllegalArgumentException | IllegalAccessException ex2) {
                        final Exception ex;
                        final Exception e = ex;
                        e.printStackTrace();
                        return;
                    }
                    final String fgStr = attrs.getValue("fg");
                    final Color fg2 = stringToColor(fgStr);
                    this.theme.scheme.getStyle(index2).foreground = fg2;
                    final String bgStr = attrs.getValue("bg");
                    final Color bg3 = stringToColor(bgStr);
                    this.theme.scheme.getStyle(index2).background = bg3;
                    Font font = this.theme.baseFont;
                    final String familyName = attrs.getValue("fontFamily");
                    if (familyName != null) {
                        font = getFont(familyName, font.getStyle(), font.getSize());
                    }
                    final String sizeStr2 = attrs.getValue("fontSize");
                    if (sizeStr2 != null) {
                        try {
                            float size2 = Float.parseFloat(sizeStr2);
                            size2 = Math.max(size2, 1.0f);
                            font = font.deriveFont(size2);
                        }
                        catch (NumberFormatException nfe) {
                            nfe.printStackTrace();
                        }
                    }
                    this.theme.scheme.getStyle(index2).font = font;
                    boolean styleSpecified = false;
                    boolean bold = false;
                    boolean italic = false;
                    final String boldStr = attrs.getValue("bold");
                    if (boldStr != null) {
                        bold = Boolean.parseBoolean(boldStr);
                        styleSpecified = true;
                    }
                    final String italicStr = attrs.getValue("italic");
                    if (italicStr != null) {
                        italic = Boolean.parseBoolean(italicStr);
                        styleSpecified = true;
                    }
                    if (styleSpecified) {
                        int style = 0;
                        if (bold) {
                            style |= 0x1;
                        }
                        if (italic) {
                            style |= 0x2;
                        }
                        final Font orig = this.theme.scheme.getStyle(index2).font;
                        this.theme.scheme.getStyle(index2).font = orig.deriveFont(style);
                    }
                    final String ulineStr = attrs.getValue("underline");
                    if (ulineStr != null) {
                        final boolean uline = Boolean.parseBoolean(ulineStr);
                        this.theme.scheme.getStyle(index2).underline = uline;
                    }
                }
            }
        }
        
        @Override
        public void warning(final SAXParseException e) throws SAXException {
            throw e;
        }
    }
}
