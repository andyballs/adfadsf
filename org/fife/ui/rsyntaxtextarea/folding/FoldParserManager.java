//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea.folding;

import org.fife.ui.rsyntaxtextarea.*;
import java.util.*;

public final class FoldParserManager implements SyntaxConstants
{
    private Map<String, FoldParser> foldParserMap;
    private static final FoldParserManager INSTANCE;
    
    private FoldParserManager() {
        this.foldParserMap = this.createFoldParserMap();
    }
    
    public void addFoldParserMapping(final String syntaxStyle, final FoldParser parser) {
        this.foldParserMap.put(syntaxStyle, parser);
    }
    
    private Map<String, FoldParser> createFoldParserMap() {
        final Map<String, FoldParser> map = new HashMap<String, FoldParser>();
        map.put("text/actionscript", (FoldParser)new CurlyFoldParser());
        map.put("text/asm6502", (FoldParser)new LinesWithContentFoldParser());
        map.put("text/asm", (FoldParser)new LinesWithContentFoldParser());
        map.put("text/c", (FoldParser)new CurlyFoldParser());
        map.put("text/cpp", (FoldParser)new CurlyFoldParser());
        map.put("text/cs", (FoldParser)new CurlyFoldParser());
        map.put("text/clojure", (FoldParser)new LispFoldParser());
        map.put("text/css", (FoldParser)new CurlyFoldParser());
        map.put("text/d", (FoldParser)new CurlyFoldParser());
        map.put("text/dart", (FoldParser)new CurlyFoldParser());
        map.put("text/golang", (FoldParser)new CurlyFoldParser());
        map.put("text/groovy", (FoldParser)new CurlyFoldParser());
        map.put("text/htaccess", (FoldParser)new XmlFoldParser());
        map.put("text/html", (FoldParser)new HtmlFoldParser(-1));
        map.put("text/java", (FoldParser)new CurlyFoldParser(true, true));
        map.put("text/javascript", (FoldParser)new CurlyFoldParser());
        map.put("text/json", (FoldParser)new JsonFoldParser());
        map.put("text/jshintrc", (FoldParser)new JsonFoldParser());
        map.put("text/jsp", (FoldParser)new HtmlFoldParser(1));
        map.put("text/kotlin", (FoldParser)new CurlyFoldParser(true, true));
        map.put("text/latex", (FoldParser)new LatexFoldParser());
        map.put("text/less", (FoldParser)new CurlyFoldParser());
        map.put("text/lisp", (FoldParser)new LispFoldParser());
        map.put("text/mxml", (FoldParser)new XmlFoldParser());
        map.put("text/nsis", (FoldParser)new NsisFoldParser());
        map.put("text/perl", (FoldParser)new CurlyFoldParser());
        map.put("text/php", (FoldParser)new HtmlFoldParser(0));
        map.put("text/python", (FoldParser)new PythonFoldParser());
        map.put("text/scala", (FoldParser)new CurlyFoldParser());
        map.put("text/typescript", (FoldParser)new CurlyFoldParser());
        map.put("text/xml", (FoldParser)new XmlFoldParser());
        map.put("text/yaml", (FoldParser)new YamlFoldParser());
        return map;
    }
    
    public static FoldParserManager get() {
        return FoldParserManager.INSTANCE;
    }
    
    public FoldParser getFoldParser(final String syntaxStyle) {
        return this.foldParserMap.get(syntaxStyle);
    }
    
    static {
        INSTANCE = new FoldParserManager();
    }
}
