//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.*;
import java.io.*;
import java.math.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.core.util.*;
import java.util.concurrent.atomic.*;

public abstract class JsonGenerator implements Closeable, Flushable, Versioned
{
    protected static final JacksonFeatureSet<StreamWriteCapability> DEFAULT_WRITE_CAPABILITIES;
    protected static final JacksonFeatureSet<StreamWriteCapability> DEFAULT_TEXTUAL_WRITE_CAPABILITIES;
    protected static final JacksonFeatureSet<StreamWriteCapability> DEFAULT_BINARY_WRITE_CAPABILITIES;
    protected PrettyPrinter _cfgPrettyPrinter;
    
    protected JsonGenerator() {
    }
    
    public abstract JsonGenerator setCodec(final ObjectCodec p0);
    
    public abstract ObjectCodec getCodec();
    
    @Override
    public abstract Version version();
    
    public abstract JsonStreamContext getOutputContext();
    
    public Object getOutputTarget() {
        return null;
    }
    
    public Object currentValue() {
        return this.getCurrentValue();
    }
    
    public void assignCurrentValue(final Object v) {
        this.setCurrentValue(v);
    }
    
    public Object getCurrentValue() {
        final JsonStreamContext ctxt = this.getOutputContext();
        return (ctxt == null) ? null : ctxt.getCurrentValue();
    }
    
    public void setCurrentValue(final Object v) {
        final JsonStreamContext ctxt = this.getOutputContext();
        if (ctxt != null) {
            ctxt.setCurrentValue(v);
        }
    }
    
    public abstract JsonGenerator enable(final Feature p0);
    
    public abstract JsonGenerator disable(final Feature p0);
    
    public final JsonGenerator configure(final Feature f, final boolean state) {
        if (state) {
            this.enable(f);
        }
        else {
            this.disable(f);
        }
        return this;
    }
    
    public abstract boolean isEnabled(final Feature p0);
    
    public boolean isEnabled(final StreamWriteFeature f) {
        return this.isEnabled(f.mappedFeature());
    }
    
    public abstract int getFeatureMask();
    
    @Deprecated
    public abstract JsonGenerator setFeatureMask(final int p0);
    
    public JsonGenerator overrideStdFeatures(final int values, final int mask) {
        final int oldState = this.getFeatureMask();
        final int newState = (oldState & ~mask) | (values & mask);
        return this.setFeatureMask(newState);
    }
    
    public int getFormatFeatures() {
        return 0;
    }
    
    public JsonGenerator overrideFormatFeatures(final int values, final int mask) {
        return this;
    }
    
    public void setSchema(final FormatSchema schema) {
        throw new UnsupportedOperationException(String.format("Generator of type %s does not support schema of type '%s'", this.getClass().getName(), schema.getSchemaType()));
    }
    
    public FormatSchema getSchema() {
        return null;
    }
    
    public JsonGenerator setPrettyPrinter(final PrettyPrinter pp) {
        this._cfgPrettyPrinter = pp;
        return this;
    }
    
    public PrettyPrinter getPrettyPrinter() {
        return this._cfgPrettyPrinter;
    }
    
    public abstract JsonGenerator useDefaultPrettyPrinter();
    
    public JsonGenerator setHighestNonEscapedChar(final int charCode) {
        return this;
    }
    
    public int getHighestEscapedChar() {
        return 0;
    }
    
    public CharacterEscapes getCharacterEscapes() {
        return null;
    }
    
    public JsonGenerator setCharacterEscapes(final CharacterEscapes esc) {
        return this;
    }
    
    public JsonGenerator setRootValueSeparator(final SerializableString sep) {
        throw new UnsupportedOperationException();
    }
    
    public int getOutputBuffered() {
        return -1;
    }
    
    public boolean canUseSchema(final FormatSchema schema) {
        return false;
    }
    
    public boolean canWriteObjectId() {
        return false;
    }
    
    public boolean canWriteTypeId() {
        return false;
    }
    
    public boolean canWriteBinaryNatively() {
        return false;
    }
    
    public boolean canOmitFields() {
        return true;
    }
    
    public boolean canWriteFormattedNumbers() {
        return false;
    }
    
    public JacksonFeatureSet<StreamWriteCapability> getWriteCapabilities() {
        return JsonGenerator.DEFAULT_WRITE_CAPABILITIES;
    }
    
    public abstract void writeStartArray() throws IOException;
    
    @Deprecated
    public void writeStartArray(final int size) throws IOException {
        this.writeStartArray();
    }
    
    public void writeStartArray(final Object forValue) throws IOException {
        this.writeStartArray();
        this.setCurrentValue(forValue);
    }
    
    public void writeStartArray(final Object forValue, final int size) throws IOException {
        this.writeStartArray(size);
        this.setCurrentValue(forValue);
    }
    
    public abstract void writeEndArray() throws IOException;
    
    public abstract void writeStartObject() throws IOException;
    
    public void writeStartObject(final Object forValue) throws IOException {
        this.writeStartObject();
        this.setCurrentValue(forValue);
    }
    
    public void writeStartObject(final Object forValue, final int size) throws IOException {
        this.writeStartObject();
        this.setCurrentValue(forValue);
    }
    
    public abstract void writeEndObject() throws IOException;
    
    public abstract void writeFieldName(final String p0) throws IOException;
    
    public abstract void writeFieldName(final SerializableString p0) throws IOException;
    
    public void writeFieldId(final long id) throws IOException {
        this.writeFieldName(Long.toString(id));
    }
    
    public void writeArray(final int[] array, final int offset, final int length) throws IOException {
        if (array == null) {
            throw new IllegalArgumentException("null array");
        }
        this._verifyOffsets(array.length, offset, length);
        this.writeStartArray(array, length);
        for (int i = offset, end = offset + length; i < end; ++i) {
            this.writeNumber(array[i]);
        }
        this.writeEndArray();
    }
    
    public void writeArray(final long[] array, final int offset, final int length) throws IOException {
        if (array == null) {
            throw new IllegalArgumentException("null array");
        }
        this._verifyOffsets(array.length, offset, length);
        this.writeStartArray(array, length);
        for (int i = offset, end = offset + length; i < end; ++i) {
            this.writeNumber(array[i]);
        }
        this.writeEndArray();
    }
    
    public void writeArray(final double[] array, final int offset, final int length) throws IOException {
        if (array == null) {
            throw new IllegalArgumentException("null array");
        }
        this._verifyOffsets(array.length, offset, length);
        this.writeStartArray(array, length);
        for (int i = offset, end = offset + length; i < end; ++i) {
            this.writeNumber(array[i]);
        }
        this.writeEndArray();
    }
    
    public void writeArray(final String[] array, final int offset, final int length) throws IOException {
        if (array == null) {
            throw new IllegalArgumentException("null array");
        }
        this._verifyOffsets(array.length, offset, length);
        this.writeStartArray(array, length);
        for (int i = offset, end = offset + length; i < end; ++i) {
            this.writeString(array[i]);
        }
        this.writeEndArray();
    }
    
    public abstract void writeString(final String p0) throws IOException;
    
    public void writeString(final Reader reader, final int len) throws IOException {
        this._reportUnsupportedOperation();
    }
    
    public abstract void writeString(final char[] p0, final int p1, final int p2) throws IOException;
    
    public abstract void writeString(final SerializableString p0) throws IOException;
    
    public abstract void writeRawUTF8String(final byte[] p0, final int p1, final int p2) throws IOException;
    
    public abstract void writeUTF8String(final byte[] p0, final int p1, final int p2) throws IOException;
    
    public abstract void writeRaw(final String p0) throws IOException;
    
    public abstract void writeRaw(final String p0, final int p1, final int p2) throws IOException;
    
    public abstract void writeRaw(final char[] p0, final int p1, final int p2) throws IOException;
    
    public abstract void writeRaw(final char p0) throws IOException;
    
    public void writeRaw(final SerializableString raw) throws IOException {
        this.writeRaw(raw.getValue());
    }
    
    public abstract void writeRawValue(final String p0) throws IOException;
    
    public abstract void writeRawValue(final String p0, final int p1, final int p2) throws IOException;
    
    public abstract void writeRawValue(final char[] p0, final int p1, final int p2) throws IOException;
    
    public void writeRawValue(final SerializableString raw) throws IOException {
        this.writeRawValue(raw.getValue());
    }
    
    public abstract void writeBinary(final Base64Variant p0, final byte[] p1, final int p2, final int p3) throws IOException;
    
    public void writeBinary(final byte[] data, final int offset, final int len) throws IOException {
        this.writeBinary(Base64Variants.getDefaultVariant(), data, offset, len);
    }
    
    public void writeBinary(final byte[] data) throws IOException {
        this.writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
    }
    
    public int writeBinary(final InputStream data, final int dataLength) throws IOException {
        return this.writeBinary(Base64Variants.getDefaultVariant(), data, dataLength);
    }
    
    public abstract int writeBinary(final Base64Variant p0, final InputStream p1, final int p2) throws IOException;
    
    public void writeNumber(final short v) throws IOException {
        this.writeNumber((int)v);
    }
    
    public abstract void writeNumber(final int p0) throws IOException;
    
    public abstract void writeNumber(final long p0) throws IOException;
    
    public abstract void writeNumber(final BigInteger p0) throws IOException;
    
    public abstract void writeNumber(final double p0) throws IOException;
    
    public abstract void writeNumber(final float p0) throws IOException;
    
    public abstract void writeNumber(final BigDecimal p0) throws IOException;
    
    public abstract void writeNumber(final String p0) throws IOException;
    
    public void writeNumber(final char[] encodedValueBuffer, final int offset, final int len) throws IOException {
        this.writeNumber(new String(encodedValueBuffer, offset, len));
    }
    
    public abstract void writeBoolean(final boolean p0) throws IOException;
    
    public abstract void writeNull() throws IOException;
    
    public void writeEmbeddedObject(final Object object) throws IOException {
        if (object == null) {
            this.writeNull();
            return;
        }
        if (object instanceof byte[]) {
            this.writeBinary((byte[])object);
            return;
        }
        throw new JsonGenerationException("No native support for writing embedded objects of type " + object.getClass().getName(), this);
    }
    
    public void writeObjectId(final Object id) throws IOException {
        throw new JsonGenerationException("No native support for writing Object Ids", this);
    }
    
    public void writeObjectRef(final Object referenced) throws IOException {
        throw new JsonGenerationException("No native support for writing Object Ids", this);
    }
    
    public void writeTypeId(final Object id) throws IOException {
        throw new JsonGenerationException("No native support for writing Type Ids", this);
    }
    
    public WritableTypeId writeTypePrefix(final WritableTypeId typeIdDef) throws IOException {
        final Object id = typeIdDef.id;
        final JsonToken valueShape = typeIdDef.valueShape;
        if (this.canWriteTypeId()) {
            typeIdDef.wrapperWritten = false;
            this.writeTypeId(id);
        }
        else {
            final String idStr = (String)((id instanceof String) ? id : String.valueOf(id));
            typeIdDef.wrapperWritten = true;
            WritableTypeId.Inclusion incl = typeIdDef.include;
            if (valueShape != JsonToken.START_OBJECT && incl.requiresObjectContext()) {
                incl = (typeIdDef.include = WritableTypeId.Inclusion.WRAPPER_ARRAY);
            }
            switch (incl) {
                case PARENT_PROPERTY: {
                    break;
                }
                case PAYLOAD_PROPERTY: {
                    break;
                }
                case METADATA_PROPERTY: {
                    this.writeStartObject(typeIdDef.forValue);
                    this.writeStringField(typeIdDef.asProperty, idStr);
                    return typeIdDef;
                }
                case WRAPPER_OBJECT: {
                    this.writeStartObject();
                    this.writeFieldName(idStr);
                    break;
                }
                default: {
                    this.writeStartArray();
                    this.writeString(idStr);
                    break;
                }
            }
        }
        if (valueShape == JsonToken.START_OBJECT) {
            this.writeStartObject(typeIdDef.forValue);
        }
        else if (valueShape == JsonToken.START_ARRAY) {
            this.writeStartArray();
        }
        return typeIdDef;
    }
    
    public WritableTypeId writeTypeSuffix(final WritableTypeId typeIdDef) throws IOException {
        final JsonToken valueShape = typeIdDef.valueShape;
        if (valueShape == JsonToken.START_OBJECT) {
            this.writeEndObject();
        }
        else if (valueShape == JsonToken.START_ARRAY) {
            this.writeEndArray();
        }
        if (typeIdDef.wrapperWritten) {
            switch (typeIdDef.include) {
                case WRAPPER_ARRAY: {
                    this.writeEndArray();
                    break;
                }
                case PARENT_PROPERTY: {
                    final Object id = typeIdDef.id;
                    final String idStr = (String)((id instanceof String) ? id : String.valueOf(id));
                    this.writeStringField(typeIdDef.asProperty, idStr);
                    break;
                }
                case PAYLOAD_PROPERTY:
                case METADATA_PROPERTY: {
                    break;
                }
                default: {
                    this.writeEndObject();
                    break;
                }
            }
        }
        return typeIdDef;
    }
    
    public void writePOJO(final Object pojo) throws IOException {
        this.writeObject(pojo);
    }
    
    public abstract void writeObject(final Object p0) throws IOException;
    
    public abstract void writeTree(final TreeNode p0) throws IOException;
    
    public void writeBinaryField(final String fieldName, final byte[] data) throws IOException {
        this.writeFieldName(fieldName);
        this.writeBinary(data);
    }
    
    public void writeBooleanField(final String fieldName, final boolean value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeBoolean(value);
    }
    
    public void writeNullField(final String fieldName) throws IOException {
        this.writeFieldName(fieldName);
        this.writeNull();
    }
    
    public void writeStringField(final String fieldName, final String value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeString(value);
    }
    
    public void writeNumberField(final String fieldName, final short value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeNumber(value);
    }
    
    public void writeNumberField(final String fieldName, final int value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeNumber(value);
    }
    
    public void writeNumberField(final String fieldName, final long value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeNumber(value);
    }
    
    public void writeNumberField(final String fieldName, final BigInteger value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeNumber(value);
    }
    
    public void writeNumberField(final String fieldName, final float value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeNumber(value);
    }
    
    public void writeNumberField(final String fieldName, final double value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeNumber(value);
    }
    
    public void writeNumberField(final String fieldName, final BigDecimal value) throws IOException {
        this.writeFieldName(fieldName);
        this.writeNumber(value);
    }
    
    public void writeArrayFieldStart(final String fieldName) throws IOException {
        this.writeFieldName(fieldName);
        this.writeStartArray();
    }
    
    public void writeObjectFieldStart(final String fieldName) throws IOException {
        this.writeFieldName(fieldName);
        this.writeStartObject();
    }
    
    public void writePOJOField(final String fieldName, final Object pojo) throws IOException {
        this.writeObjectField(fieldName, pojo);
    }
    
    public void writeObjectField(final String fieldName, final Object pojo) throws IOException {
        this.writeFieldName(fieldName);
        this.writeObject(pojo);
    }
    
    public void writeOmittedField(final String fieldName) throws IOException {
    }
    
    public void copyCurrentEvent(final JsonParser p) throws IOException {
        final JsonToken t = p.currentToken();
        final int token = (t == null) ? -1 : t.id();
        switch (token) {
            case -1: {
                this._reportError("No current event to copy");
                break;
            }
            case 1: {
                this.writeStartObject();
                break;
            }
            case 2: {
                this.writeEndObject();
                break;
            }
            case 3: {
                this.writeStartArray();
                break;
            }
            case 4: {
                this.writeEndArray();
                break;
            }
            case 5: {
                this.writeFieldName(p.getCurrentName());
                break;
            }
            case 6: {
                if (p.hasTextCharacters()) {
                    this.writeString(p.getTextCharacters(), p.getTextOffset(), p.getTextLength());
                    break;
                }
                this.writeString(p.getText());
                break;
            }
            case 7: {
                final JsonParser.NumberType n = p.getNumberType();
                if (n == JsonParser.NumberType.INT) {
                    this.writeNumber(p.getIntValue());
                    break;
                }
                if (n == JsonParser.NumberType.BIG_INTEGER) {
                    this.writeNumber(p.getBigIntegerValue());
                    break;
                }
                this.writeNumber(p.getLongValue());
                break;
            }
            case 8: {
                final JsonParser.NumberType n = p.getNumberType();
                if (n == JsonParser.NumberType.BIG_DECIMAL) {
                    this.writeNumber(p.getDecimalValue());
                    break;
                }
                if (n == JsonParser.NumberType.FLOAT) {
                    this.writeNumber(p.getFloatValue());
                    break;
                }
                this.writeNumber(p.getDoubleValue());
                break;
            }
            case 9: {
                this.writeBoolean(true);
                break;
            }
            case 10: {
                this.writeBoolean(false);
                break;
            }
            case 11: {
                this.writeNull();
                break;
            }
            case 12: {
                this.writeObject(p.getEmbeddedObject());
                break;
            }
            default: {
                throw new IllegalStateException("Internal error: unknown current token, " + t);
            }
        }
    }
    
    public void copyCurrentStructure(final JsonParser p) throws IOException {
        JsonToken t = p.currentToken();
        int id = (t == null) ? -1 : t.id();
        if (id == 5) {
            this.writeFieldName(p.getCurrentName());
            t = p.nextToken();
            id = ((t == null) ? -1 : t.id());
        }
        switch (id) {
            case 1: {
                this.writeStartObject();
                this._copyCurrentContents(p);
            }
            case 3: {
                this.writeStartArray();
                this._copyCurrentContents(p);
            }
            default: {
                this.copyCurrentEvent(p);
            }
        }
    }
    
    protected void _copyCurrentContents(final JsonParser p) throws IOException {
        int depth = 1;
        JsonToken t;
        while ((t = p.nextToken()) != null) {
            switch (t.id()) {
                case 5: {
                    this.writeFieldName(p.getCurrentName());
                    continue;
                }
                case 3: {
                    this.writeStartArray();
                    ++depth;
                    continue;
                }
                case 1: {
                    this.writeStartObject();
                    ++depth;
                    continue;
                }
                case 4: {
                    this.writeEndArray();
                    if (--depth == 0) {
                        return;
                    }
                    continue;
                }
                case 2: {
                    this.writeEndObject();
                    if (--depth == 0) {
                        return;
                    }
                    continue;
                }
                case 6: {
                    if (p.hasTextCharacters()) {
                        this.writeString(p.getTextCharacters(), p.getTextOffset(), p.getTextLength());
                        continue;
                    }
                    this.writeString(p.getText());
                    continue;
                }
                case 7: {
                    final JsonParser.NumberType n = p.getNumberType();
                    if (n == JsonParser.NumberType.INT) {
                        this.writeNumber(p.getIntValue());
                        continue;
                    }
                    if (n == JsonParser.NumberType.BIG_INTEGER) {
                        this.writeNumber(p.getBigIntegerValue());
                        continue;
                    }
                    this.writeNumber(p.getLongValue());
                    continue;
                }
                case 8: {
                    final JsonParser.NumberType n = p.getNumberType();
                    if (n == JsonParser.NumberType.BIG_DECIMAL) {
                        this.writeNumber(p.getDecimalValue());
                        continue;
                    }
                    if (n == JsonParser.NumberType.FLOAT) {
                        this.writeNumber(p.getFloatValue());
                        continue;
                    }
                    this.writeNumber(p.getDoubleValue());
                    continue;
                }
                case 9: {
                    this.writeBoolean(true);
                    continue;
                }
                case 10: {
                    this.writeBoolean(false);
                    continue;
                }
                case 11: {
                    this.writeNull();
                    continue;
                }
                case 12: {
                    this.writeObject(p.getEmbeddedObject());
                    continue;
                }
                default: {
                    throw new IllegalStateException("Internal error: unknown current token, " + t);
                }
            }
        }
    }
    
    @Override
    public abstract void flush() throws IOException;
    
    public abstract boolean isClosed();
    
    @Override
    public abstract void close() throws IOException;
    
    protected void _reportError(final String msg) throws JsonGenerationException {
        throw new JsonGenerationException(msg, this);
    }
    
    protected final void _throwInternal() {
        VersionUtil.throwInternal();
    }
    
    protected void _reportUnsupportedOperation() {
        throw new UnsupportedOperationException("Operation not supported by generator of type " + this.getClass().getName());
    }
    
    protected final void _verifyOffsets(final int arrayLength, final int offset, final int length) {
        if (offset < 0 || offset + length > arrayLength) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", offset, length, arrayLength));
        }
    }
    
    protected void _writeSimpleObject(final Object value) throws IOException {
        if (value == null) {
            this.writeNull();
            return;
        }
        if (value instanceof String) {
            this.writeString((String)value);
            return;
        }
        if (value instanceof Number) {
            final Number n = (Number)value;
            if (n instanceof Integer) {
                this.writeNumber(n.intValue());
                return;
            }
            if (n instanceof Long) {
                this.writeNumber(n.longValue());
                return;
            }
            if (n instanceof Double) {
                this.writeNumber(n.doubleValue());
                return;
            }
            if (n instanceof Float) {
                this.writeNumber(n.floatValue());
                return;
            }
            if (n instanceof Short) {
                this.writeNumber(n.shortValue());
                return;
            }
            if (n instanceof Byte) {
                this.writeNumber(n.byteValue());
                return;
            }
            if (n instanceof BigInteger) {
                this.writeNumber((BigInteger)n);
                return;
            }
            if (n instanceof BigDecimal) {
                this.writeNumber((BigDecimal)n);
                return;
            }
            if (n instanceof AtomicInteger) {
                this.writeNumber(((AtomicInteger)n).get());
                return;
            }
            if (n instanceof AtomicLong) {
                this.writeNumber(((AtomicLong)n).get());
                return;
            }
        }
        else {
            if (value instanceof byte[]) {
                this.writeBinary((byte[])value);
                return;
            }
            if (value instanceof Boolean) {
                this.writeBoolean((boolean)value);
                return;
            }
            if (value instanceof AtomicBoolean) {
                this.writeBoolean(((AtomicBoolean)value).get());
                return;
            }
        }
        throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + value.getClass().getName() + ")");
    }
    
    static {
        DEFAULT_WRITE_CAPABILITIES = JacksonFeatureSet.fromDefaults(StreamWriteCapability.values());
        DEFAULT_TEXTUAL_WRITE_CAPABILITIES = JsonGenerator.DEFAULT_WRITE_CAPABILITIES.with(StreamWriteCapability.CAN_WRITE_FORMATTED_NUMBERS);
        DEFAULT_BINARY_WRITE_CAPABILITIES = JsonGenerator.DEFAULT_WRITE_CAPABILITIES.with(StreamWriteCapability.CAN_WRITE_BINARY_NATIVELY);
    }
    
    public enum Feature
    {
        AUTO_CLOSE_TARGET(true), 
        AUTO_CLOSE_JSON_CONTENT(true), 
        FLUSH_PASSED_TO_STREAM(true), 
        @Deprecated
        QUOTE_FIELD_NAMES(true), 
        @Deprecated
        QUOTE_NON_NUMERIC_NUMBERS(true), 
        @Deprecated
        ESCAPE_NON_ASCII(false), 
        @Deprecated
        WRITE_NUMBERS_AS_STRINGS(false), 
        WRITE_BIGDECIMAL_AS_PLAIN(false), 
        STRICT_DUPLICATE_DETECTION(false), 
        IGNORE_UNKNOWN(false);
        
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
            this._defaultState = defaultState;
            this._mask = 1 << this.ordinal();
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
