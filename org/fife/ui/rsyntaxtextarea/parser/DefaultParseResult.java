//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.parser;

import java.util.*;

public class DefaultParseResult implements ParseResult
{
    private Parser parser;
    private int firstLineParsed;
    private int lastLineParsed;
    private List<ParserNotice> notices;
    private long parseTime;
    private Exception error;
    
    public DefaultParseResult(final Parser parser) {
        this.parser = parser;
        this.notices = new ArrayList<ParserNotice>();
    }
    
    public void addNotice(final ParserNotice notice) {
        this.notices.add(notice);
    }
    
    public void clearNotices() {
        this.notices.clear();
    }
    
    @Override
    public Exception getError() {
        return this.error;
    }
    
    @Override
    public int getFirstLineParsed() {
        return this.firstLineParsed;
    }
    
    @Override
    public int getLastLineParsed() {
        return this.lastLineParsed;
    }
    
    @Override
    public List<ParserNotice> getNotices() {
        return this.notices;
    }
    
    @Override
    public Parser getParser() {
        return this.parser;
    }
    
    @Override
    public long getParseTime() {
        return this.parseTime;
    }
    
    public void setError(final Exception e) {
        this.error = e;
    }
    
    public void setParsedLines(final int first, final int last) {
        this.firstLineParsed = first;
        this.lastLineParsed = last;
    }
    
    public void setParseTime(final long time) {
        this.parseTime = time;
    }
}
