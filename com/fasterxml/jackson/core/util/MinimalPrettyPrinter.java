//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.*;
import java.io.*;

public class MinimalPrettyPrinter implements PrettyPrinter, Serializable
{
    private static final long serialVersionUID = 1L;
    protected String _rootValueSeparator;
    protected Separators _separators;
    
    public MinimalPrettyPrinter() {
        this(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.toString());
    }
    
    public MinimalPrettyPrinter(final String rootValueSeparator) {
        this._rootValueSeparator = rootValueSeparator;
        this._separators = MinimalPrettyPrinter.DEFAULT_SEPARATORS;
    }
    
    public void setRootValueSeparator(final String sep) {
        this._rootValueSeparator = sep;
    }
    
    public MinimalPrettyPrinter setSeparators(final Separators separators) {
        this._separators = separators;
        return this;
    }
    
    public void writeRootValueSeparator(final JsonGenerator g) throws IOException {
        if (this._rootValueSeparator != null) {
            g.writeRaw(this._rootValueSeparator);
        }
    }
    
    public void writeStartObject(final JsonGenerator g) throws IOException {
        g.writeRaw('{');
    }
    
    public void beforeObjectEntries(final JsonGenerator g) throws IOException {
    }
    
    public void writeObjectFieldValueSeparator(final JsonGenerator g) throws IOException {
        g.writeRaw(this._separators.getObjectFieldValueSeparator());
    }
    
    public void writeObjectEntrySeparator(final JsonGenerator g) throws IOException {
        g.writeRaw(this._separators.getObjectEntrySeparator());
    }
    
    public void writeEndObject(final JsonGenerator g, final int nrOfEntries) throws IOException {
        g.writeRaw('}');
    }
    
    public void writeStartArray(final JsonGenerator g) throws IOException {
        g.writeRaw('[');
    }
    
    public void beforeArrayValues(final JsonGenerator g) throws IOException {
    }
    
    public void writeArrayValueSeparator(final JsonGenerator g) throws IOException {
        g.writeRaw(this._separators.getArrayValueSeparator());
    }
    
    public void writeEndArray(final JsonGenerator g, final int nrOfValues) throws IOException {
        g.writeRaw(']');
    }
}
