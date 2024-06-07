//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.*;
import java.io.*;
import java.math.*;
import com.fasterxml.jackson.core.*;

public class JsonGeneratorDelegate extends JsonGenerator
{
    protected JsonGenerator delegate;
    protected boolean delegateCopyMethods;
    
    public JsonGeneratorDelegate(final JsonGenerator d) {
        this(d, true);
    }
    
    public JsonGeneratorDelegate(final JsonGenerator d, final boolean delegateCopyMethods) {
        this.delegate = d;
        this.delegateCopyMethods = delegateCopyMethods;
    }
    
    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }
    
    public JsonGenerator setCodec(final ObjectCodec oc) {
        this.delegate.setCodec(oc);
        return this;
    }
    
    public void setSchema(final FormatSchema schema) {
        this.delegate.setSchema(schema);
    }
    
    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }
    
    public Version version() {
        return this.delegate.version();
    }
    
    public Object getOutputTarget() {
        return this.delegate.getOutputTarget();
    }
    
    public int getOutputBuffered() {
        return this.delegate.getOutputBuffered();
    }
    
    public void assignCurrentValue(final Object v) {
        this.delegate.assignCurrentValue(v);
    }
    
    public Object currentValue() {
        return this.delegate.currentValue();
    }
    
    public void setCurrentValue(final Object v) {
        this.delegate.setCurrentValue(v);
    }
    
    public Object getCurrentValue() {
        return this.delegate.getCurrentValue();
    }
    
    public boolean canUseSchema(final FormatSchema schema) {
        return this.delegate.canUseSchema(schema);
    }
    
    public boolean canWriteTypeId() {
        return this.delegate.canWriteTypeId();
    }
    
    public boolean canWriteObjectId() {
        return this.delegate.canWriteObjectId();
    }
    
    public boolean canWriteBinaryNatively() {
        return this.delegate.canWriteBinaryNatively();
    }
    
    public boolean canOmitFields() {
        return this.delegate.canOmitFields();
    }
    
    public boolean canWriteFormattedNumbers() {
        return this.delegate.canWriteFormattedNumbers();
    }
    
    public JacksonFeatureSet<StreamWriteCapability> getWriteCapabilities() {
        return (JacksonFeatureSet<StreamWriteCapability>)this.delegate.getWriteCapabilities();
    }
    
    public JsonGenerator enable(final JsonGenerator.Feature f) {
        this.delegate.enable(f);
        return this;
    }
    
    public JsonGenerator disable(final JsonGenerator.Feature f) {
        this.delegate.disable(f);
        return this;
    }
    
    public boolean isEnabled(final JsonGenerator.Feature f) {
        return this.delegate.isEnabled(f);
    }
    
    public int getFeatureMask() {
        return this.delegate.getFeatureMask();
    }
    
    @Deprecated
    public JsonGenerator setFeatureMask(final int mask) {
        this.delegate.setFeatureMask(mask);
        return this;
    }
    
    public JsonGenerator overrideStdFeatures(final int values, final int mask) {
        this.delegate.overrideStdFeatures(values, mask);
        return this;
    }
    
    public JsonGenerator overrideFormatFeatures(final int values, final int mask) {
        this.delegate.overrideFormatFeatures(values, mask);
        return this;
    }
    
    public JsonGenerator setPrettyPrinter(final PrettyPrinter pp) {
        this.delegate.setPrettyPrinter(pp);
        return this;
    }
    
    public PrettyPrinter getPrettyPrinter() {
        return this.delegate.getPrettyPrinter();
    }
    
    public JsonGenerator useDefaultPrettyPrinter() {
        this.delegate.useDefaultPrettyPrinter();
        return this;
    }
    
    public JsonGenerator setHighestNonEscapedChar(final int charCode) {
        this.delegate.setHighestNonEscapedChar(charCode);
        return this;
    }
    
    public int getHighestEscapedChar() {
        return this.delegate.getHighestEscapedChar();
    }
    
    public CharacterEscapes getCharacterEscapes() {
        return this.delegate.getCharacterEscapes();
    }
    
    public JsonGenerator setCharacterEscapes(final CharacterEscapes esc) {
        this.delegate.setCharacterEscapes(esc);
        return this;
    }
    
    public JsonGenerator setRootValueSeparator(final SerializableString sep) {
        this.delegate.setRootValueSeparator(sep);
        return this;
    }
    
    public void writeStartArray() throws IOException {
        this.delegate.writeStartArray();
    }
    
    public void writeStartArray(final int size) throws IOException {
        this.delegate.writeStartArray(size);
    }
    
    public void writeStartArray(final Object forValue) throws IOException {
        this.delegate.writeStartArray(forValue);
    }
    
    public void writeStartArray(final Object forValue, final int size) throws IOException {
        this.delegate.writeStartArray(forValue, size);
    }
    
    public void writeEndArray() throws IOException {
        this.delegate.writeEndArray();
    }
    
    public void writeStartObject() throws IOException {
        this.delegate.writeStartObject();
    }
    
    public void writeStartObject(final Object forValue) throws IOException {
        this.delegate.writeStartObject(forValue);
    }
    
    public void writeStartObject(final Object forValue, final int size) throws IOException {
        this.delegate.writeStartObject(forValue, size);
    }
    
    public void writeEndObject() throws IOException {
        this.delegate.writeEndObject();
    }
    
    public void writeFieldName(final String name) throws IOException {
        this.delegate.writeFieldName(name);
    }
    
    public void writeFieldName(final SerializableString name) throws IOException {
        this.delegate.writeFieldName(name);
    }
    
    public void writeFieldId(final long id) throws IOException {
        this.delegate.writeFieldId(id);
    }
    
    public void writeArray(final int[] array, final int offset, final int length) throws IOException {
        this.delegate.writeArray(array, offset, length);
    }
    
    public void writeArray(final long[] array, final int offset, final int length) throws IOException {
        this.delegate.writeArray(array, offset, length);
    }
    
    public void writeArray(final double[] array, final int offset, final int length) throws IOException {
        this.delegate.writeArray(array, offset, length);
    }
    
    public void writeArray(final String[] array, final int offset, final int length) throws IOException {
        this.delegate.writeArray(array, offset, length);
    }
    
    public void writeString(final String text) throws IOException {
        this.delegate.writeString(text);
    }
    
    public void writeString(final Reader reader, final int len) throws IOException {
        this.delegate.writeString(reader, len);
    }
    
    public void writeString(final char[] text, final int offset, final int len) throws IOException {
        this.delegate.writeString(text, offset, len);
    }
    
    public void writeString(final SerializableString text) throws IOException {
        this.delegate.writeString(text);
    }
    
    public void writeRawUTF8String(final byte[] text, final int offset, final int length) throws IOException {
        this.delegate.writeRawUTF8String(text, offset, length);
    }
    
    public void writeUTF8String(final byte[] text, final int offset, final int length) throws IOException {
        this.delegate.writeUTF8String(text, offset, length);
    }
    
    public void writeRaw(final String text) throws IOException {
        this.delegate.writeRaw(text);
    }
    
    public void writeRaw(final String text, final int offset, final int len) throws IOException {
        this.delegate.writeRaw(text, offset, len);
    }
    
    public void writeRaw(final SerializableString raw) throws IOException {
        this.delegate.writeRaw(raw);
    }
    
    public void writeRaw(final char[] text, final int offset, final int len) throws IOException {
        this.delegate.writeRaw(text, offset, len);
    }
    
    public void writeRaw(final char c) throws IOException {
        this.delegate.writeRaw(c);
    }
    
    public void writeRawValue(final String text) throws IOException {
        this.delegate.writeRawValue(text);
    }
    
    public void writeRawValue(final String text, final int offset, final int len) throws IOException {
        this.delegate.writeRawValue(text, offset, len);
    }
    
    public void writeRawValue(final char[] text, final int offset, final int len) throws IOException {
        this.delegate.writeRawValue(text, offset, len);
    }
    
    public void writeBinary(final Base64Variant b64variant, final byte[] data, final int offset, final int len) throws IOException {
        this.delegate.writeBinary(b64variant, data, offset, len);
    }
    
    public int writeBinary(final Base64Variant b64variant, final InputStream data, final int dataLength) throws IOException {
        return this.delegate.writeBinary(b64variant, data, dataLength);
    }
    
    public void writeNumber(final short v) throws IOException {
        this.delegate.writeNumber(v);
    }
    
    public void writeNumber(final int v) throws IOException {
        this.delegate.writeNumber(v);
    }
    
    public void writeNumber(final long v) throws IOException {
        this.delegate.writeNumber(v);
    }
    
    public void writeNumber(final BigInteger v) throws IOException {
        this.delegate.writeNumber(v);
    }
    
    public void writeNumber(final double v) throws IOException {
        this.delegate.writeNumber(v);
    }
    
    public void writeNumber(final float v) throws IOException {
        this.delegate.writeNumber(v);
    }
    
    public void writeNumber(final BigDecimal v) throws IOException {
        this.delegate.writeNumber(v);
    }
    
    public void writeNumber(final String encodedValue) throws IOException, UnsupportedOperationException {
        this.delegate.writeNumber(encodedValue);
    }
    
    public void writeNumber(final char[] encodedValueBuffer, final int offset, final int length) throws IOException, UnsupportedOperationException {
        this.delegate.writeNumber(encodedValueBuffer, offset, length);
    }
    
    public void writeBoolean(final boolean state) throws IOException {
        this.delegate.writeBoolean(state);
    }
    
    public void writeNull() throws IOException {
        this.delegate.writeNull();
    }
    
    public void writeOmittedField(final String fieldName) throws IOException {
        this.delegate.writeOmittedField(fieldName);
    }
    
    public void writeObjectId(final Object id) throws IOException {
        this.delegate.writeObjectId(id);
    }
    
    public void writeObjectRef(final Object id) throws IOException {
        this.delegate.writeObjectRef(id);
    }
    
    public void writeTypeId(final Object id) throws IOException {
        this.delegate.writeTypeId(id);
    }
    
    public void writeEmbeddedObject(final Object object) throws IOException {
        this.delegate.writeEmbeddedObject(object);
    }
    
    public void writePOJO(final Object pojo) throws IOException {
        this.writeObject(pojo);
    }
    
    public void writeObject(final Object pojo) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeObject(pojo);
            return;
        }
        if (pojo == null) {
            this.writeNull();
        }
        else {
            final ObjectCodec c = this.getCodec();
            if (c != null) {
                c.writeValue((JsonGenerator)this, pojo);
                return;
            }
            this._writeSimpleObject(pojo);
        }
    }
    
    public void writeTree(final TreeNode tree) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeTree(tree);
            return;
        }
        if (tree == null) {
            this.writeNull();
        }
        else {
            final ObjectCodec c = this.getCodec();
            if (c == null) {
                throw new IllegalStateException("No ObjectCodec defined");
            }
            c.writeTree((JsonGenerator)this, tree);
        }
    }
    
    public void copyCurrentEvent(final JsonParser p) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentEvent(p);
        }
        else {
            super.copyCurrentEvent(p);
        }
    }
    
    public void copyCurrentStructure(final JsonParser p) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentStructure(p);
        }
        else {
            super.copyCurrentStructure(p);
        }
    }
    
    public JsonStreamContext getOutputContext() {
        return this.delegate.getOutputContext();
    }
    
    public void flush() throws IOException {
        this.delegate.flush();
    }
    
    public void close() throws IOException {
        this.delegate.close();
    }
    
    public boolean isClosed() {
        return this.delegate.isClosed();
    }
    
    @Deprecated
    public JsonGenerator getDelegate() {
        return this.delegate;
    }
    
    public JsonGenerator delegate() {
        return this.delegate;
    }
}
