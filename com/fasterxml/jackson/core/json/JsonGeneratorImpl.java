//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.base.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import java.io.*;
import com.fasterxml.jackson.core.io.*;

public abstract class JsonGeneratorImpl extends GeneratorBase
{
    protected static final int[] sOutputEscapes;
    protected static final JacksonFeatureSet<StreamWriteCapability> JSON_WRITE_CAPABILITIES;
    protected final IOContext _ioContext;
    protected int[] _outputEscapes;
    protected int _maximumNonEscapedChar;
    protected CharacterEscapes _characterEscapes;
    protected SerializableString _rootValueSeparator;
    protected boolean _cfgUnqNames;
    
    public JsonGeneratorImpl(final IOContext ctxt, final int features, final ObjectCodec codec) {
        super(features, codec);
        this._outputEscapes = JsonGeneratorImpl.sOutputEscapes;
        this._rootValueSeparator = (SerializableString)DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        this._ioContext = ctxt;
        if (JsonGenerator.Feature.ESCAPE_NON_ASCII.enabledIn(features)) {
            this._maximumNonEscapedChar = 127;
        }
        this._cfgUnqNames = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(features);
    }
    
    public Version version() {
        return VersionUtil.versionFor(this.getClass());
    }
    
    public JsonGenerator enable(final JsonGenerator.Feature f) {
        super.enable(f);
        if (f == JsonGenerator.Feature.QUOTE_FIELD_NAMES) {
            this._cfgUnqNames = false;
        }
        return (JsonGenerator)this;
    }
    
    public JsonGenerator disable(final JsonGenerator.Feature f) {
        super.disable(f);
        if (f == JsonGenerator.Feature.QUOTE_FIELD_NAMES) {
            this._cfgUnqNames = true;
        }
        return (JsonGenerator)this;
    }
    
    protected void _checkStdFeatureChanges(final int newFeatureFlags, final int changedFeatures) {
        super._checkStdFeatureChanges(newFeatureFlags, changedFeatures);
        this._cfgUnqNames = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(newFeatureFlags);
    }
    
    public JsonGenerator setHighestNonEscapedChar(final int charCode) {
        this._maximumNonEscapedChar = ((charCode < 0) ? 0 : charCode);
        return (JsonGenerator)this;
    }
    
    public int getHighestEscapedChar() {
        return this._maximumNonEscapedChar;
    }
    
    public JsonGenerator setCharacterEscapes(final CharacterEscapes esc) {
        this._characterEscapes = esc;
        if (esc == null) {
            this._outputEscapes = JsonGeneratorImpl.sOutputEscapes;
        }
        else {
            this._outputEscapes = esc.getEscapeCodesForAscii();
        }
        return (JsonGenerator)this;
    }
    
    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }
    
    public JsonGenerator setRootValueSeparator(final SerializableString sep) {
        this._rootValueSeparator = sep;
        return (JsonGenerator)this;
    }
    
    public JacksonFeatureSet<StreamWriteCapability> getWriteCapabilities() {
        return JsonGeneratorImpl.JSON_WRITE_CAPABILITIES;
    }
    
    protected void _verifyPrettyValueWrite(final String typeMsg, final int status) throws IOException {
        switch (status) {
            case 1: {
                this._cfgPrettyPrinter.writeArrayValueSeparator((JsonGenerator)this);
                break;
            }
            case 2: {
                this._cfgPrettyPrinter.writeObjectFieldValueSeparator((JsonGenerator)this);
                break;
            }
            case 3: {
                this._cfgPrettyPrinter.writeRootValueSeparator((JsonGenerator)this);
                break;
            }
            case 0: {
                if (this._writeContext.inArray()) {
                    this._cfgPrettyPrinter.beforeArrayValues((JsonGenerator)this);
                    break;
                }
                if (this._writeContext.inObject()) {
                    this._cfgPrettyPrinter.beforeObjectEntries((JsonGenerator)this);
                    break;
                }
                break;
            }
            case 5: {
                this._reportCantWriteValueExpectName(typeMsg);
                break;
            }
            default: {
                this._throwInternal();
                break;
            }
        }
    }
    
    protected void _reportCantWriteValueExpectName(final String typeMsg) throws IOException {
        this._reportError(String.format("Can not %s, expecting field name (context: %s)", typeMsg, this._writeContext.typeDesc()));
    }
    
    static {
        sOutputEscapes = CharTypes.get7BitOutputEscapes();
        JSON_WRITE_CAPABILITIES = JsonGeneratorImpl.DEFAULT_TEXTUAL_WRITE_CAPABILITIES;
    }
}
