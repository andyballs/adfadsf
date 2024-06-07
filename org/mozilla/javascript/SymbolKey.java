//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;

public class SymbolKey implements Symbol, Serializable
{
    private static final long serialVersionUID = -6019782713330994754L;
    public static final SymbolKey ITERATOR;
    public static final SymbolKey TO_STRING_TAG;
    public static final SymbolKey SPECIES;
    public static final SymbolKey HAS_INSTANCE;
    public static final SymbolKey IS_CONCAT_SPREADABLE;
    public static final SymbolKey IS_REGEXP;
    public static final SymbolKey TO_PRIMITIVE;
    public static final SymbolKey MATCH;
    public static final SymbolKey REPLACE;
    public static final SymbolKey SEARCH;
    public static final SymbolKey SPLIT;
    public static final SymbolKey UNSCOPABLES;
    private String name;
    
    public SymbolKey(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof SymbolKey) {
            return o == this;
        }
        return o instanceof NativeSymbol && ((NativeSymbol)o).getKey() == this;
    }
    
    public String toSymbolString() {
        if (this.name == null || this.name.equals("")) {
            return "";
        }
        return "[" + this.name + "]";
    }
    
    @Override
    public String toString() {
        if (this.name == null) {
            return "Symbol()";
        }
        return "Symbol(" + this.name + ')';
    }
    
    static {
        ITERATOR = new SymbolKey("Symbol.iterator");
        TO_STRING_TAG = new SymbolKey("Symbol.toStringTag");
        SPECIES = new SymbolKey("Symbol.species");
        HAS_INSTANCE = new SymbolKey("Symbol.hasInstance");
        IS_CONCAT_SPREADABLE = new SymbolKey("Symbol.isConcatSpreadable");
        IS_REGEXP = new SymbolKey("Symbol.isRegExp");
        TO_PRIMITIVE = new SymbolKey("Symbol.toPrimitive");
        MATCH = new SymbolKey("Symbol.match");
        REPLACE = new SymbolKey("Symbol.replace");
        SEARCH = new SymbolKey("Symbol.search");
        SPLIT = new SymbolKey("Symbol.split");
        UNSCOPABLES = new SymbolKey("Symbol.unscopables");
    }
}
