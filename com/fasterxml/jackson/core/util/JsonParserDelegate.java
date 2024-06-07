//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.util;

import java.math.*;
import com.fasterxml.jackson.core.*;
import java.io.*;

public class JsonParserDelegate extends JsonParser
{
    protected JsonParser delegate;
    
    public JsonParserDelegate(final JsonParser d) {
        this.delegate = d;
    }
    
    public void setCodec(final ObjectCodec c) {
        this.delegate.setCodec(c);
    }
    
    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }
    
    public JsonParser enable(final JsonParser.Feature f) {
        this.delegate.enable(f);
        return this;
    }
    
    public JsonParser disable(final JsonParser.Feature f) {
        this.delegate.disable(f);
        return this;
    }
    
    public boolean isEnabled(final JsonParser.Feature f) {
        return this.delegate.isEnabled(f);
    }
    
    public int getFeatureMask() {
        return this.delegate.getFeatureMask();
    }
    
    @Deprecated
    public JsonParser setFeatureMask(final int mask) {
        this.delegate.setFeatureMask(mask);
        return this;
    }
    
    public JsonParser overrideStdFeatures(final int values, final int mask) {
        this.delegate.overrideStdFeatures(values, mask);
        return this;
    }
    
    public JsonParser overrideFormatFeatures(final int values, final int mask) {
        this.delegate.overrideFormatFeatures(values, mask);
        return this;
    }
    
    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }
    
    public void setSchema(final FormatSchema schema) {
        this.delegate.setSchema(schema);
    }
    
    public boolean canUseSchema(final FormatSchema schema) {
        return this.delegate.canUseSchema(schema);
    }
    
    public Version version() {
        return this.delegate.version();
    }
    
    public Object getInputSource() {
        return this.delegate.getInputSource();
    }
    
    public boolean requiresCustomCodec() {
        return this.delegate.requiresCustomCodec();
    }
    
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return (JacksonFeatureSet<StreamReadCapability>)this.delegate.getReadCapabilities();
    }
    
    public void close() throws IOException {
        this.delegate.close();
    }
    
    public boolean isClosed() {
        return this.delegate.isClosed();
    }
    
    public void clearCurrentToken() {
        this.delegate.clearCurrentToken();
    }
    
    public JsonToken getLastClearedToken() {
        return this.delegate.getLastClearedToken();
    }
    
    public void overrideCurrentName(final String name) {
        this.delegate.overrideCurrentName(name);
    }
    
    public void assignCurrentValue(final Object v) {
        this.delegate.assignCurrentValue(v);
    }
    
    public void setCurrentValue(final Object v) {
        this.delegate.setCurrentValue(v);
    }
    
    public JsonStreamContext getParsingContext() {
        return this.delegate.getParsingContext();
    }
    
    public JsonToken currentToken() {
        return this.delegate.currentToken();
    }
    
    public int currentTokenId() {
        return this.delegate.currentTokenId();
    }
    
    public String currentName() throws IOException {
        return this.delegate.currentName();
    }
    
    public Object currentValue() {
        return this.delegate.currentValue();
    }
    
    public JsonLocation currentLocation() {
        return this.delegate.getCurrentLocation();
    }
    
    public JsonLocation currentTokenLocation() {
        return this.delegate.getTokenLocation();
    }
    
    public JsonToken getCurrentToken() {
        return this.delegate.getCurrentToken();
    }
    
    @Deprecated
    public int getCurrentTokenId() {
        return this.delegate.getCurrentTokenId();
    }
    
    public String getCurrentName() throws IOException {
        return this.delegate.getCurrentName();
    }
    
    public Object getCurrentValue() {
        return this.delegate.getCurrentValue();
    }
    
    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }
    
    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }
    
    public boolean hasCurrentToken() {
        return this.delegate.hasCurrentToken();
    }
    
    public boolean hasTokenId(final int id) {
        return this.delegate.hasTokenId(id);
    }
    
    public boolean hasToken(final JsonToken t) {
        return this.delegate.hasToken(t);
    }
    
    public boolean isExpectedStartArrayToken() {
        return this.delegate.isExpectedStartArrayToken();
    }
    
    public boolean isExpectedStartObjectToken() {
        return this.delegate.isExpectedStartObjectToken();
    }
    
    public boolean isExpectedNumberIntToken() {
        return this.delegate.isExpectedNumberIntToken();
    }
    
    public boolean isNaN() throws IOException {
        return this.delegate.isNaN();
    }
    
    public String getText() throws IOException {
        return this.delegate.getText();
    }
    
    public boolean hasTextCharacters() {
        return this.delegate.hasTextCharacters();
    }
    
    public char[] getTextCharacters() throws IOException {
        return this.delegate.getTextCharacters();
    }
    
    public int getTextLength() throws IOException {
        return this.delegate.getTextLength();
    }
    
    public int getTextOffset() throws IOException {
        return this.delegate.getTextOffset();
    }
    
    public int getText(final Writer writer) throws IOException, UnsupportedOperationException {
        return this.delegate.getText(writer);
    }
    
    public BigInteger getBigIntegerValue() throws IOException {
        return this.delegate.getBigIntegerValue();
    }
    
    public boolean getBooleanValue() throws IOException {
        return this.delegate.getBooleanValue();
    }
    
    public byte getByteValue() throws IOException {
        return this.delegate.getByteValue();
    }
    
    public short getShortValue() throws IOException {
        return this.delegate.getShortValue();
    }
    
    public BigDecimal getDecimalValue() throws IOException {
        return this.delegate.getDecimalValue();
    }
    
    public double getDoubleValue() throws IOException {
        return this.delegate.getDoubleValue();
    }
    
    public float getFloatValue() throws IOException {
        return this.delegate.getFloatValue();
    }
    
    public int getIntValue() throws IOException {
        return this.delegate.getIntValue();
    }
    
    public long getLongValue() throws IOException {
        return this.delegate.getLongValue();
    }
    
    public JsonParser.NumberType getNumberType() throws IOException {
        return this.delegate.getNumberType();
    }
    
    public Number getNumberValue() throws IOException {
        return this.delegate.getNumberValue();
    }
    
    public Number getNumberValueExact() throws IOException {
        return this.delegate.getNumberValueExact();
    }
    
    public int getValueAsInt() throws IOException {
        return this.delegate.getValueAsInt();
    }
    
    public int getValueAsInt(final int defaultValue) throws IOException {
        return this.delegate.getValueAsInt(defaultValue);
    }
    
    public long getValueAsLong() throws IOException {
        return this.delegate.getValueAsLong();
    }
    
    public long getValueAsLong(final long defaultValue) throws IOException {
        return this.delegate.getValueAsLong(defaultValue);
    }
    
    public double getValueAsDouble() throws IOException {
        return this.delegate.getValueAsDouble();
    }
    
    public double getValueAsDouble(final double defaultValue) throws IOException {
        return this.delegate.getValueAsDouble(defaultValue);
    }
    
    public boolean getValueAsBoolean() throws IOException {
        return this.delegate.getValueAsBoolean();
    }
    
    public boolean getValueAsBoolean(final boolean defaultValue) throws IOException {
        return this.delegate.getValueAsBoolean(defaultValue);
    }
    
    public String getValueAsString() throws IOException {
        return this.delegate.getValueAsString();
    }
    
    public String getValueAsString(final String defaultValue) throws IOException {
        return this.delegate.getValueAsString(defaultValue);
    }
    
    public Object getEmbeddedObject() throws IOException {
        return this.delegate.getEmbeddedObject();
    }
    
    public byte[] getBinaryValue(final Base64Variant b64variant) throws IOException {
        return this.delegate.getBinaryValue(b64variant);
    }
    
    public int readBinaryValue(final Base64Variant b64variant, final OutputStream out) throws IOException {
        return this.delegate.readBinaryValue(b64variant, out);
    }
    
    public JsonToken nextToken() throws IOException {
        return this.delegate.nextToken();
    }
    
    public JsonToken nextValue() throws IOException {
        return this.delegate.nextValue();
    }
    
    public void finishToken() throws IOException {
        this.delegate.finishToken();
    }
    
    public JsonParser skipChildren() throws IOException {
        this.delegate.skipChildren();
        return this;
    }
    
    public boolean canReadObjectId() {
        return this.delegate.canReadObjectId();
    }
    
    public boolean canReadTypeId() {
        return this.delegate.canReadTypeId();
    }
    
    public Object getObjectId() throws IOException {
        return this.delegate.getObjectId();
    }
    
    public Object getTypeId() throws IOException {
        return this.delegate.getTypeId();
    }
    
    public JsonParser delegate() {
        return this.delegate;
    }
}
