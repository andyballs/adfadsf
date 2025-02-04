//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.*;
import com.fasterxml.jackson.core.async.*;
import java.io.*;
import com.fasterxml.jackson.core.exc.*;
import java.math.*;
import com.fasterxml.jackson.core.type.*;
import java.util.*;

public abstract class JsonParser implements Closeable, Versioned
{
    private static final int MIN_BYTE_I = -128;
    private static final int MAX_BYTE_I = 255;
    private static final int MIN_SHORT_I = -32768;
    private static final int MAX_SHORT_I = 32767;
    protected static final JacksonFeatureSet<StreamReadCapability> DEFAULT_READ_CAPABILITIES;
    protected int _features;
    protected transient RequestPayload _requestPayload;
    
    protected JsonParser() {
    }
    
    protected JsonParser(final int features) {
        this._features = features;
    }
    
    public abstract ObjectCodec getCodec();
    
    public abstract void setCodec(final ObjectCodec p0);
    
    public Object getInputSource() {
        return null;
    }
    
    public void setRequestPayloadOnError(final RequestPayload payload) {
        this._requestPayload = payload;
    }
    
    public void setRequestPayloadOnError(final byte[] payload, final String charset) {
        this._requestPayload = ((payload == null) ? null : new RequestPayload(payload, charset));
    }
    
    public void setRequestPayloadOnError(final String payload) {
        this._requestPayload = ((payload == null) ? null : new RequestPayload(payload));
    }
    
    public void setSchema(final FormatSchema schema) {
        throw new UnsupportedOperationException("Parser of type " + this.getClass().getName() + " does not support schema of type '" + schema.getSchemaType() + "'");
    }
    
    public FormatSchema getSchema() {
        return null;
    }
    
    public boolean canUseSchema(final FormatSchema schema) {
        return false;
    }
    
    public boolean requiresCustomCodec() {
        return false;
    }
    
    public boolean canParseAsync() {
        return false;
    }
    
    public NonBlockingInputFeeder getNonBlockingInputFeeder() {
        return null;
    }
    
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return JsonParser.DEFAULT_READ_CAPABILITIES;
    }
    
    @Override
    public abstract Version version();
    
    @Override
    public abstract void close() throws IOException;
    
    public abstract boolean isClosed();
    
    public abstract JsonStreamContext getParsingContext();
    
    public JsonLocation currentLocation() {
        return this.getCurrentLocation();
    }
    
    public JsonLocation currentTokenLocation() {
        return this.getTokenLocation();
    }
    
    public abstract JsonLocation getCurrentLocation();
    
    public abstract JsonLocation getTokenLocation();
    
    public Object currentValue() {
        return this.getCurrentValue();
    }
    
    public void assignCurrentValue(final Object v) {
        this.setCurrentValue(v);
    }
    
    public Object getCurrentValue() {
        final JsonStreamContext ctxt = this.getParsingContext();
        return (ctxt == null) ? null : ctxt.getCurrentValue();
    }
    
    public void setCurrentValue(final Object v) {
        final JsonStreamContext ctxt = this.getParsingContext();
        if (ctxt != null) {
            ctxt.setCurrentValue(v);
        }
    }
    
    public int releaseBuffered(final OutputStream out) throws IOException {
        return -1;
    }
    
    public int releaseBuffered(final Writer w) throws IOException {
        return -1;
    }
    
    public JsonParser enable(final Feature f) {
        this._features |= f.getMask();
        return this;
    }
    
    public JsonParser disable(final Feature f) {
        this._features &= ~f.getMask();
        return this;
    }
    
    public JsonParser configure(final Feature f, final boolean state) {
        if (state) {
            this.enable(f);
        }
        else {
            this.disable(f);
        }
        return this;
    }
    
    public boolean isEnabled(final Feature f) {
        return f.enabledIn(this._features);
    }
    
    public boolean isEnabled(final StreamReadFeature f) {
        return f.mappedFeature().enabledIn(this._features);
    }
    
    public int getFeatureMask() {
        return this._features;
    }
    
    @Deprecated
    public JsonParser setFeatureMask(final int mask) {
        this._features = mask;
        return this;
    }
    
    public JsonParser overrideStdFeatures(final int values, final int mask) {
        final int newState = (this._features & ~mask) | (values & mask);
        return this.setFeatureMask(newState);
    }
    
    public int getFormatFeatures() {
        return 0;
    }
    
    public JsonParser overrideFormatFeatures(final int values, final int mask) {
        return this;
    }
    
    public abstract JsonToken nextToken() throws IOException;
    
    public abstract JsonToken nextValue() throws IOException;
    
    public boolean nextFieldName(final SerializableString str) throws IOException {
        return this.nextToken() == JsonToken.FIELD_NAME && str.getValue().equals(this.getCurrentName());
    }
    
    public String nextFieldName() throws IOException {
        return (this.nextToken() == JsonToken.FIELD_NAME) ? this.getCurrentName() : null;
    }
    
    public String nextTextValue() throws IOException {
        return (this.nextToken() == JsonToken.VALUE_STRING) ? this.getText() : null;
    }
    
    public int nextIntValue(final int defaultValue) throws IOException {
        return (this.nextToken() == JsonToken.VALUE_NUMBER_INT) ? this.getIntValue() : defaultValue;
    }
    
    public long nextLongValue(final long defaultValue) throws IOException {
        return (this.nextToken() == JsonToken.VALUE_NUMBER_INT) ? this.getLongValue() : defaultValue;
    }
    
    public Boolean nextBooleanValue() throws IOException {
        final JsonToken t = this.nextToken();
        if (t == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (t == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        return null;
    }
    
    public abstract JsonParser skipChildren() throws IOException;
    
    public void finishToken() throws IOException {
    }
    
    public JsonToken currentToken() {
        return this.getCurrentToken();
    }
    
    public int currentTokenId() {
        return this.getCurrentTokenId();
    }
    
    public abstract JsonToken getCurrentToken();
    
    @Deprecated
    public abstract int getCurrentTokenId();
    
    public abstract boolean hasCurrentToken();
    
    public abstract boolean hasTokenId(final int p0);
    
    public abstract boolean hasToken(final JsonToken p0);
    
    public boolean isExpectedStartArrayToken() {
        return this.currentToken() == JsonToken.START_ARRAY;
    }
    
    public boolean isExpectedStartObjectToken() {
        return this.currentToken() == JsonToken.START_OBJECT;
    }
    
    public boolean isExpectedNumberIntToken() {
        return this.currentToken() == JsonToken.VALUE_NUMBER_INT;
    }
    
    public boolean isNaN() throws IOException {
        return false;
    }
    
    public abstract void clearCurrentToken();
    
    public abstract JsonToken getLastClearedToken();
    
    public abstract void overrideCurrentName(final String p0);
    
    public abstract String getCurrentName() throws IOException;
    
    public String currentName() throws IOException {
        return this.getCurrentName();
    }
    
    public abstract String getText() throws IOException;
    
    public int getText(final Writer writer) throws IOException, UnsupportedOperationException {
        final String str = this.getText();
        if (str == null) {
            return 0;
        }
        writer.write(str);
        return str.length();
    }
    
    public abstract char[] getTextCharacters() throws IOException;
    
    public abstract int getTextLength() throws IOException;
    
    public abstract int getTextOffset() throws IOException;
    
    public abstract boolean hasTextCharacters();
    
    public abstract Number getNumberValue() throws IOException;
    
    public Number getNumberValueExact() throws IOException {
        return this.getNumberValue();
    }
    
    public abstract NumberType getNumberType() throws IOException;
    
    public byte getByteValue() throws IOException {
        final int value = this.getIntValue();
        if (value < -128 || value > 255) {
            throw new InputCoercionException(this, String.format("Numeric value (%s) out of range of Java byte", this.getText()), JsonToken.VALUE_NUMBER_INT, (Class)Byte.TYPE);
        }
        return (byte)value;
    }
    
    public short getShortValue() throws IOException {
        final int value = this.getIntValue();
        if (value < -32768 || value > 32767) {
            throw new InputCoercionException(this, String.format("Numeric value (%s) out of range of Java short", this.getText()), JsonToken.VALUE_NUMBER_INT, (Class)Short.TYPE);
        }
        return (short)value;
    }
    
    public abstract int getIntValue() throws IOException;
    
    public abstract long getLongValue() throws IOException;
    
    public abstract BigInteger getBigIntegerValue() throws IOException;
    
    public abstract float getFloatValue() throws IOException;
    
    public abstract double getDoubleValue() throws IOException;
    
    public abstract BigDecimal getDecimalValue() throws IOException;
    
    public boolean getBooleanValue() throws IOException {
        final JsonToken t = this.currentToken();
        if (t == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (t == JsonToken.VALUE_FALSE) {
            return false;
        }
        throw new JsonParseException(this, String.format("Current token (%s) not of boolean type", t)).withRequestPayload(this._requestPayload);
    }
    
    public Object getEmbeddedObject() throws IOException {
        return null;
    }
    
    public abstract byte[] getBinaryValue(final Base64Variant p0) throws IOException;
    
    public byte[] getBinaryValue() throws IOException {
        return this.getBinaryValue(Base64Variants.getDefaultVariant());
    }
    
    public int readBinaryValue(final OutputStream out) throws IOException {
        return this.readBinaryValue(Base64Variants.getDefaultVariant(), out);
    }
    
    public int readBinaryValue(final Base64Variant bv, final OutputStream out) throws IOException {
        this._reportUnsupportedOperation();
        return 0;
    }
    
    public int getValueAsInt() throws IOException {
        return this.getValueAsInt(0);
    }
    
    public int getValueAsInt(final int def) throws IOException {
        return def;
    }
    
    public long getValueAsLong() throws IOException {
        return this.getValueAsLong(0L);
    }
    
    public long getValueAsLong(final long def) throws IOException {
        return def;
    }
    
    public double getValueAsDouble() throws IOException {
        return this.getValueAsDouble(0.0);
    }
    
    public double getValueAsDouble(final double def) throws IOException {
        return def;
    }
    
    public boolean getValueAsBoolean() throws IOException {
        return this.getValueAsBoolean(false);
    }
    
    public boolean getValueAsBoolean(final boolean def) throws IOException {
        return def;
    }
    
    public String getValueAsString() throws IOException {
        return this.getValueAsString(null);
    }
    
    public abstract String getValueAsString(final String p0) throws IOException;
    
    public boolean canReadObjectId() {
        return false;
    }
    
    public boolean canReadTypeId() {
        return false;
    }
    
    public Object getObjectId() throws IOException {
        return null;
    }
    
    public Object getTypeId() throws IOException {
        return null;
    }
    
    public <T> T readValueAs(final Class<T> valueType) throws IOException {
        return this._codec().readValue(this, valueType);
    }
    
    public <T> T readValueAs(final TypeReference<?> valueTypeRef) throws IOException {
        return this._codec().readValue(this, valueTypeRef);
    }
    
    public <T> Iterator<T> readValuesAs(final Class<T> valueType) throws IOException {
        return this._codec().readValues(this, valueType);
    }
    
    public <T> Iterator<T> readValuesAs(final TypeReference<T> valueTypeRef) throws IOException {
        return this._codec().readValues(this, valueTypeRef);
    }
    
    public <T extends TreeNode> T readValueAsTree() throws IOException {
        return this._codec().readTree(this);
    }
    
    protected ObjectCodec _codec() {
        final ObjectCodec c = this.getCodec();
        if (c == null) {
            throw new IllegalStateException("No ObjectCodec defined for parser, needed for deserialization");
        }
        return c;
    }
    
    protected JsonParseException _constructError(final String msg) {
        return new JsonParseException(this, msg).withRequestPayload(this._requestPayload);
    }
    
    protected void _reportUnsupportedOperation() {
        throw new UnsupportedOperationException("Operation not supported by parser of type " + this.getClass().getName());
    }
    
    protected JsonParseException _constructReadException(final String msg) {
        return this._constructError(msg);
    }
    
    protected JsonParseException _constructReadException(final String msg, final Object arg) {
        return this._constructReadException(String.format(msg, arg));
    }
    
    protected JsonParseException _constructReadException(final String msg, final Object arg1, final Object arg2) {
        return this._constructReadException(String.format(msg, arg1, arg2));
    }
    
    protected JsonParseException _constructReadException(final String msg, final Object arg1, final Object arg2, final Object arg3) {
        return this._constructReadException(String.format(msg, arg1, arg2, arg3));
    }
    
    protected JsonParseException _constructReadException(final String msg, final Throwable t) {
        JsonParseException e = new JsonParseException(this, msg, t);
        if (this._requestPayload != null) {
            e = e.withRequestPayload(this._requestPayload);
        }
        return e;
    }
    
    static {
        DEFAULT_READ_CAPABILITIES = JacksonFeatureSet.fromDefaults(StreamReadCapability.values());
    }
    
    public enum NumberType
    {
        INT, 
        LONG, 
        BIG_INTEGER, 
        FLOAT, 
        DOUBLE, 
        BIG_DECIMAL;
    }
    
    public enum Feature
    {
        AUTO_CLOSE_SOURCE(true), 
        ALLOW_COMMENTS(false), 
        ALLOW_YAML_COMMENTS(false), 
        ALLOW_UNQUOTED_FIELD_NAMES(false), 
        ALLOW_SINGLE_QUOTES(false), 
        @Deprecated
        ALLOW_UNQUOTED_CONTROL_CHARS(false), 
        @Deprecated
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false), 
        @Deprecated
        ALLOW_NUMERIC_LEADING_ZEROS(false), 
        @Deprecated
        ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false), 
        @Deprecated
        ALLOW_NON_NUMERIC_NUMBERS(false), 
        @Deprecated
        ALLOW_MISSING_VALUES(false), 
        @Deprecated
        ALLOW_TRAILING_COMMA(false), 
        STRICT_DUPLICATE_DETECTION(false), 
        IGNORE_UNDEFINED(false), 
        INCLUDE_SOURCE_IN_LOCATION(true);
        
        private final boolean _defaultState;
        private final int _mask;
        
        public static int collectDefaults() {
            int flags = 0;
            for (final Feature f : values()) {
                if (f.enabledByDefault()) {
                    flags |= f.getMask();
                }
            }
            return flags;
        }
        
        private Feature(final boolean defaultState) {
            this._mask = 1 << this.ordinal();
            this._defaultState = defaultState;
        }
        
        public boolean enabledByDefault() {
            return this._defaultState;
        }
        
        public boolean enabledIn(final int flags) {
            return (flags & this._mask) != 0x0;
        }
        
        public int getMask() {
            return this._mask;
        }
    }
}
