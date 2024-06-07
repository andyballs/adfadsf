//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.awt.datatransfer.*;
import java.io.*;

class StyledTextTransferable implements Transferable
{
    private String html;
    private byte[] rtfBytes;
    private static final DataFlavor[] FLAVORS;
    
    StyledTextTransferable(final String html, final byte[] rtfBytes) {
        this.html = html;
        this.rtfBytes = rtfBytes;
    }
    
    @Override
    public Object getTransferData(final DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(StyledTextTransferable.FLAVORS[0])) {
            return this.html;
        }
        if (flavor.equals(StyledTextTransferable.FLAVORS[1])) {
            return new ByteArrayInputStream((this.rtfBytes == null) ? new byte[0] : this.rtfBytes);
        }
        if (flavor.equals(StyledTextTransferable.FLAVORS[2])) {
            return (this.rtfBytes == null) ? "" : RtfToText.getPlainText(this.rtfBytes);
        }
        if (flavor.equals(StyledTextTransferable.FLAVORS[3])) {
            String text = "";
            if (this.rtfBytes != null) {
                text = RtfToText.getPlainText(this.rtfBytes);
            }
            return new StringReader(text);
        }
        throw new UnsupportedFlavorException(flavor);
    }
    
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return StyledTextTransferable.FLAVORS.clone();
    }
    
    @Override
    public boolean isDataFlavorSupported(final DataFlavor flavor) {
        for (final DataFlavor flavor2 : StyledTextTransferable.FLAVORS) {
            if (flavor.equals(flavor2)) {
                return true;
            }
        }
        return false;
    }
    
    static {
        FLAVORS = new DataFlavor[] { DataFlavor.fragmentHtmlFlavor, new DataFlavor("text/rtf", "RTF"), DataFlavor.stringFlavor, DataFlavor.plainTextFlavor };
    }
}
