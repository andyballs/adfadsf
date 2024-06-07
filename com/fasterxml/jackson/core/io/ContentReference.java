//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.io;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class ContentReference implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected static final ContentReference UNKNOWN_CONTENT;
    public static final int DEFAULT_MAX_CONTENT_SNIPPET = 500;
    protected final transient Object _rawContent;
    protected final int _offset;
    protected final int _length;
    protected final boolean _isContentTextual;
    
    protected ContentReference(final boolean isContentTextual, final Object rawContent) {
        this(isContentTextual, rawContent, -1, -1);
    }
    
    protected ContentReference(final boolean isContentTextual, final Object rawContent, final int offset, final int length) {
        this._isContentTextual = isContentTextual;
        this._rawContent = rawContent;
        this._offset = offset;
        this._length = length;
    }
    
    public static ContentReference unknown() {
        return ContentReference.UNKNOWN_CONTENT;
    }
    
    public static ContentReference construct(final boolean isContentTextual, final Object rawContent) {
        return new ContentReference(isContentTextual, rawContent);
    }
    
    public static ContentReference construct(final boolean isContentTextual, final Object rawContent, final int offset, final int length) {
        return new ContentReference(isContentTextual, rawContent, offset, length);
    }
    
    public static ContentReference rawReference(final boolean isContentTextual, final Object rawContent) {
        if (rawContent instanceof ContentReference) {
            return (ContentReference)rawContent;
        }
        return new ContentReference(isContentTextual, rawContent);
    }
    
    public static ContentReference rawReference(final Object rawContent) {
        return rawReference(false, rawContent);
    }
    
    private void readObject(final ObjectInputStream in) throws IOException {
    }
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
    }
    
    protected Object readResolve() {
        return ContentReference.UNKNOWN_CONTENT;
    }
    
    public boolean hasTextualContent() {
        return this._isContentTextual;
    }
    
    public Object getRawContent() {
        return this._rawContent;
    }
    
    public int contentOffset() {
        return this._offset;
    }
    
    public int contentLength() {
        return this._length;
    }
    
    protected int maxContentSnippetLength() {
        return 500;
    }
    
    public String buildSourceDescription() {
        return this.appendSourceDescription(new StringBuilder(200)).toString();
    }
    
    public StringBuilder appendSourceDescription(final StringBuilder sb) {
        final Object srcRef = this.getRawContent();
        if (srcRef == null) {
            sb.append("UNKNOWN");
            return sb;
        }
        final Class<?> srcType = (Class<?>)((srcRef instanceof Class) ? ((Class)srcRef) : srcRef.getClass());
        String tn = srcType.getName();
        if (tn.startsWith("java.")) {
            tn = srcType.getSimpleName();
        }
        else if (srcRef instanceof byte[]) {
            tn = "byte[]";
        }
        else if (srcRef instanceof char[]) {
            tn = "char[]";
        }
        sb.append('(').append(tn).append(')');
        if (this.hasTextualContent()) {
            String unitStr = " chars";
            final int maxLen = this.maxContentSnippetLength();
            final int[] offsets = { this.contentOffset(), this.contentLength() };
            String trimmed;
            if (srcRef instanceof CharSequence) {
                trimmed = this._truncate((CharSequence)srcRef, offsets, maxLen);
            }
            else if (srcRef instanceof char[]) {
                trimmed = this._truncate((char[])srcRef, offsets, maxLen);
            }
            else if (srcRef instanceof byte[]) {
                trimmed = this._truncate((byte[])srcRef, offsets, maxLen);
                unitStr = " bytes";
            }
            else {
                trimmed = null;
            }
            if (trimmed != null) {
                this._append(sb, trimmed);
                if (offsets[1] > maxLen) {
                    sb.append("[truncated ").append(offsets[1] - maxLen).append(unitStr).append(']');
                }
            }
        }
        else if (srcRef instanceof byte[]) {
            int length = this.contentLength();
            if (length < 0) {
                length = ((byte[])srcRef).length;
            }
            sb.append('[').append(length).append(" bytes]");
        }
        return sb;
    }
    
    protected String _truncate(final CharSequence cs, final int[] offsets, final int maxSnippetLen) {
        this._truncateOffsets(offsets, cs.length());
        final int start = offsets[0];
        final int length = Math.min(offsets[1], maxSnippetLen);
        return cs.subSequence(start, start + length).toString();
    }
    
    protected String _truncate(final char[] cs, final int[] offsets, final int maxSnippetLen) {
        this._truncateOffsets(offsets, cs.length);
        final int start = offsets[0];
        final int length = Math.min(offsets[1], maxSnippetLen);
        return new String(cs, start, length);
    }
    
    protected String _truncate(final byte[] b, final int[] offsets, final int maxSnippetLen) {
        this._truncateOffsets(offsets, b.length);
        final int start = offsets[0];
        final int length = Math.min(offsets[1], maxSnippetLen);
        return new String(b, start, length, Charset.forName("UTF-8"));
    }
    
    protected void _truncateOffsets(final int[] offsets, final int actualLength) {
        int start = offsets[0];
        if (start < 0) {
            start = 0;
        }
        else if (start >= actualLength) {
            start = actualLength;
        }
        offsets[0] = start;
        final int length = offsets[1];
        final int maxLength = actualLength - start;
        if (length < 0 || length > maxLength) {
            offsets[1] = maxLength;
        }
    }
    
    protected int _append(final StringBuilder sb, final String content) {
        sb.append('\"');
        for (int i = 0, end = content.length(); i < end; ++i) {
            final char ch = content.charAt(i);
            if (!Character.isISOControl(ch) || !this._appendEscaped(sb, ch)) {
                sb.append(ch);
            }
        }
        sb.append('\"');
        return content.length();
    }
    
    protected boolean _appendEscaped(final StringBuilder sb, final int ctrlChar) {
        if (ctrlChar == 13 || ctrlChar == 10) {
            return false;
        }
        sb.append('\\');
        sb.append('u');
        sb.append(CharTypes.hexToChar(ctrlChar >> 12 & 0xF));
        sb.append(CharTypes.hexToChar(ctrlChar >> 8 & 0xF));
        sb.append(CharTypes.hexToChar(ctrlChar >> 4 & 0xF));
        sb.append(CharTypes.hexToChar(ctrlChar & 0xF));
        return true;
    }
    
    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof ContentReference)) {
            return false;
        }
        final ContentReference otherSrc = (ContentReference)other;
        return this._rawContent == otherSrc._rawContent;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this._rawContent);
    }
    
    static {
        UNKNOWN_CONTENT = new ContentReference(false, null);
    }
}
