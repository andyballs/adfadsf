//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.util.*;
import com.fasterxml.jackson.core.*;
import java.io.*;
import java.math.*;

public class FilteringGeneratorDelegate extends JsonGeneratorDelegate
{
    protected TokenFilter rootFilter;
    protected boolean _allowMultipleMatches;
    protected TokenFilter.Inclusion _inclusion;
    protected TokenFilterContext _filterContext;
    protected TokenFilter _itemFilter;
    protected int _matchCount;
    
    @Deprecated
    public FilteringGeneratorDelegate(final JsonGenerator d, final TokenFilter f, final boolean includePath, final boolean allowMultipleMatches) {
        this(d, f, includePath ? TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH : TokenFilter.Inclusion.ONLY_INCLUDE_ALL, allowMultipleMatches);
    }
    
    public FilteringGeneratorDelegate(final JsonGenerator d, final TokenFilter f, final TokenFilter.Inclusion inclusion, final boolean allowMultipleMatches) {
        super(d, false);
        this.rootFilter = f;
        this._itemFilter = f;
        this._filterContext = TokenFilterContext.createRootContext(f);
        this._inclusion = inclusion;
        this._allowMultipleMatches = allowMultipleMatches;
    }
    
    public TokenFilter getFilter() {
        return this.rootFilter;
    }
    
    public JsonStreamContext getFilterContext() {
        return this._filterContext;
    }
    
    public int getMatchCount() {
        return this._matchCount;
    }
    
    @Override
    public JsonStreamContext getOutputContext() {
        return this._filterContext;
    }
    
    @Override
    public void writeStartArray() throws IOException {
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
            return;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray();
            return;
        }
        this._itemFilter = this._filterContext.checkValue(this._itemFilter);
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            this._itemFilter = this._itemFilter.filterStartArray();
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._checkParentPath();
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray();
        }
        else if (this._itemFilter != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
            this._checkParentPath(false);
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray();
        }
        else {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, false);
        }
    }
    
    @Override
    public void writeStartArray(final int size) throws IOException {
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
            return;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(size);
            return;
        }
        this._itemFilter = this._filterContext.checkValue(this._itemFilter);
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            this._itemFilter = this._itemFilter.filterStartArray();
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._checkParentPath();
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(size);
        }
        else if (this._itemFilter != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
            this._checkParentPath(false);
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(size);
        }
        else {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, false);
        }
    }
    
    @Override
    public void writeStartArray(final Object forValue) throws IOException {
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
            return;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(forValue);
            return;
        }
        this._itemFilter = this._filterContext.checkValue(this._itemFilter);
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            this._itemFilter = this._itemFilter.filterStartArray();
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._checkParentPath();
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(forValue);
        }
        else {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, false);
        }
    }
    
    @Override
    public void writeStartArray(final Object forValue, final int size) throws IOException {
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
            return;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(forValue, size);
            return;
        }
        this._itemFilter = this._filterContext.checkValue(this._itemFilter);
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildArrayContext(null, false);
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            this._itemFilter = this._itemFilter.filterStartArray();
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._checkParentPath();
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, true);
            this.delegate.writeStartArray(forValue, size);
        }
        else {
            this._filterContext = this._filterContext.createChildArrayContext(this._itemFilter, false);
        }
    }
    
    @Override
    public void writeEndArray() throws IOException {
        this._filterContext = this._filterContext.closeArray(this.delegate);
        if (this._filterContext != null) {
            this._itemFilter = this._filterContext.getFilter();
        }
    }
    
    @Override
    public void writeStartObject() throws IOException {
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, false);
            return;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, true);
            this.delegate.writeStartObject();
            return;
        }
        TokenFilter f = this._filterContext.checkValue(this._itemFilter);
        if (f == null) {
            return;
        }
        if (f != TokenFilter.INCLUDE_ALL) {
            f = f.filterStartObject();
        }
        if (f == TokenFilter.INCLUDE_ALL) {
            this._checkParentPath();
            this._filterContext = this._filterContext.createChildObjectContext(f, true);
            this.delegate.writeStartObject();
        }
        else if (f != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
            this._checkParentPath(false);
            this._filterContext = this._filterContext.createChildObjectContext(f, true);
            this.delegate.writeStartObject();
        }
        else {
            this._filterContext = this._filterContext.createChildObjectContext(f, false);
        }
    }
    
    @Override
    public void writeStartObject(final Object forValue) throws IOException {
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, false);
            return;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, true);
            this.delegate.writeStartObject(forValue);
            return;
        }
        TokenFilter f = this._filterContext.checkValue(this._itemFilter);
        if (f == null) {
            return;
        }
        if (f != TokenFilter.INCLUDE_ALL) {
            f = f.filterStartObject();
        }
        if (f == TokenFilter.INCLUDE_ALL) {
            this._checkParentPath();
            this._filterContext = this._filterContext.createChildObjectContext(f, true);
            this.delegate.writeStartObject(forValue);
        }
        else if (f != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
            this._checkParentPath(false);
            this._filterContext = this._filterContext.createChildObjectContext(f, true);
            this.delegate.writeStartObject(forValue);
        }
        else {
            this._filterContext = this._filterContext.createChildObjectContext(f, false);
        }
    }
    
    @Override
    public void writeStartObject(final Object forValue, final int size) throws IOException {
        if (this._itemFilter == null) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, false);
            return;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._filterContext = this._filterContext.createChildObjectContext(this._itemFilter, true);
            this.delegate.writeStartObject(forValue, size);
            return;
        }
        TokenFilter f = this._filterContext.checkValue(this._itemFilter);
        if (f == null) {
            return;
        }
        if (f != TokenFilter.INCLUDE_ALL) {
            f = f.filterStartObject();
        }
        if (f == TokenFilter.INCLUDE_ALL) {
            this._checkParentPath();
            this._filterContext = this._filterContext.createChildObjectContext(f, true);
            this.delegate.writeStartObject(forValue, size);
        }
        else {
            this._filterContext = this._filterContext.createChildObjectContext(f, false);
        }
    }
    
    @Override
    public void writeEndObject() throws IOException {
        this._filterContext = this._filterContext.closeObject(this.delegate);
        if (this._filterContext != null) {
            this._itemFilter = this._filterContext.getFilter();
        }
    }
    
    @Override
    public void writeFieldName(final String name) throws IOException {
        TokenFilter state = this._filterContext.setFieldName(name);
        if (state == null) {
            this._itemFilter = null;
            return;
        }
        if (state == TokenFilter.INCLUDE_ALL) {
            this._itemFilter = state;
            this.delegate.writeFieldName(name);
            return;
        }
        state = state.includeProperty(name);
        if ((this._itemFilter = state) == TokenFilter.INCLUDE_ALL) {
            this._checkPropertyParentPath();
        }
    }
    
    @Override
    public void writeFieldName(final SerializableString name) throws IOException {
        TokenFilter state = this._filterContext.setFieldName(name.getValue());
        if (state == null) {
            this._itemFilter = null;
            return;
        }
        if (state == TokenFilter.INCLUDE_ALL) {
            this._itemFilter = state;
            this.delegate.writeFieldName(name);
            return;
        }
        state = state.includeProperty(name.getValue());
        if ((this._itemFilter = state) == TokenFilter.INCLUDE_ALL) {
            this._checkPropertyParentPath();
        }
    }
    
    @Override
    public void writeFieldId(final long id) throws IOException {
        this.writeFieldName(Long.toString(id));
    }
    
    @Override
    public void writeString(final String value) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeString(value)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeString(value);
    }
    
    @Override
    public void writeString(final char[] text, final int offset, final int len) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final String value = new String(text, offset, len);
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeString(value)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeString(text, offset, len);
    }
    
    @Override
    public void writeString(final SerializableString value) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeString(value.getValue())) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeString(value);
    }
    
    @Override
    public void writeString(final Reader reader, final int len) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeString(reader, len)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeString(reader, len);
    }
    
    @Override
    public void writeRawUTF8String(final byte[] text, final int offset, final int length) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRawUTF8String(text, offset, length);
        }
    }
    
    @Override
    public void writeUTF8String(final byte[] text, final int offset, final int length) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeUTF8String(text, offset, length);
        }
    }
    
    @Override
    public void writeRaw(final String text) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRaw(text);
        }
    }
    
    @Override
    public void writeRaw(final String text, final int offset, final int len) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRaw(text, offset, len);
        }
    }
    
    @Override
    public void writeRaw(final SerializableString text) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRaw(text);
        }
    }
    
    @Override
    public void writeRaw(final char[] text, final int offset, final int len) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRaw(text, offset, len);
        }
    }
    
    @Override
    public void writeRaw(final char c) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRaw(c);
        }
    }
    
    @Override
    public void writeRawValue(final String text) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRawValue(text);
        }
    }
    
    @Override
    public void writeRawValue(final String text, final int offset, final int len) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRawValue(text, offset, len);
        }
    }
    
    @Override
    public void writeRawValue(final char[] text, final int offset, final int len) throws IOException {
        if (this._checkRawValueWrite()) {
            this.delegate.writeRawValue(text, offset, len);
        }
    }
    
    @Override
    public void writeBinary(final Base64Variant b64variant, final byte[] data, final int offset, final int len) throws IOException {
        if (this._checkBinaryWrite()) {
            this.delegate.writeBinary(b64variant, data, offset, len);
        }
    }
    
    @Override
    public int writeBinary(final Base64Variant b64variant, final InputStream data, final int dataLength) throws IOException {
        if (this._checkBinaryWrite()) {
            return this.delegate.writeBinary(b64variant, data, dataLength);
        }
        return -1;
    }
    
    @Override
    public void writeNumber(final short v) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeNumber(v)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(v);
    }
    
    @Override
    public void writeNumber(final int v) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeNumber(v)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(v);
    }
    
    @Override
    public void writeNumber(final long v) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeNumber(v)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(v);
    }
    
    @Override
    public void writeNumber(final BigInteger v) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeNumber(v)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(v);
    }
    
    @Override
    public void writeNumber(final double v) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeNumber(v)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(v);
    }
    
    @Override
    public void writeNumber(final float v) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeNumber(v)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(v);
    }
    
    @Override
    public void writeNumber(final BigDecimal v) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeNumber(v)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(v);
    }
    
    @Override
    public void writeNumber(final String encodedValue) throws IOException, UnsupportedOperationException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeRawValue()) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(encodedValue);
    }
    
    @Override
    public void writeNumber(final char[] encodedValueBuffer, final int offset, final int length) throws IOException, UnsupportedOperationException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeRawValue()) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNumber(encodedValueBuffer, offset, length);
    }
    
    @Override
    public void writeBoolean(final boolean v) throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeBoolean(v)) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeBoolean(v);
    }
    
    @Override
    public void writeNull() throws IOException {
        if (this._itemFilter == null) {
            return;
        }
        if (this._itemFilter != TokenFilter.INCLUDE_ALL) {
            final TokenFilter state = this._filterContext.checkValue(this._itemFilter);
            if (state == null) {
                return;
            }
            if (state != TokenFilter.INCLUDE_ALL && !state.includeNull()) {
                return;
            }
            this._checkParentPath();
        }
        this.delegate.writeNull();
    }
    
    @Override
    public void writeOmittedField(final String fieldName) throws IOException {
        if (this._itemFilter != null) {
            this.delegate.writeOmittedField(fieldName);
        }
    }
    
    @Override
    public void writeObjectId(final Object id) throws IOException {
        if (this._itemFilter != null) {
            this.delegate.writeObjectId(id);
        }
    }
    
    @Override
    public void writeObjectRef(final Object id) throws IOException {
        if (this._itemFilter != null) {
            this.delegate.writeObjectRef(id);
        }
    }
    
    @Override
    public void writeTypeId(final Object id) throws IOException {
        if (this._itemFilter != null) {
            this.delegate.writeTypeId(id);
        }
    }
    
    protected void _checkParentPath() throws IOException {
        this._checkParentPath(true);
    }
    
    protected void _checkParentPath(final boolean isMatch) throws IOException {
        if (isMatch) {
            ++this._matchCount;
        }
        if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
            this._filterContext.writePath(this.delegate);
        }
        else if (this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
            this._filterContext.ensureFieldNameWritten(this.delegate);
        }
        if (isMatch && !this._allowMultipleMatches) {
            this._filterContext.skipParentChecks();
        }
    }
    
    protected void _checkPropertyParentPath() throws IOException {
        ++this._matchCount;
        if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
            this._filterContext.writePath(this.delegate);
        }
        else if (this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
            this._filterContext.ensureFieldNameWritten(this.delegate);
        }
        if (!this._allowMultipleMatches) {
            this._filterContext.skipParentChecks();
        }
    }
    
    protected boolean _checkBinaryWrite() throws IOException {
        if (this._itemFilter == null) {
            return false;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            return true;
        }
        if (this._itemFilter.includeBinary()) {
            this._checkParentPath();
            return true;
        }
        return false;
    }
    
    protected boolean _checkRawValueWrite() throws IOException {
        if (this._itemFilter == null) {
            return false;
        }
        if (this._itemFilter == TokenFilter.INCLUDE_ALL) {
            return true;
        }
        if (this._itemFilter.includeRawValue()) {
            this._checkParentPath();
            return true;
        }
        return false;
    }
}
