//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.json;

import org.mozilla.javascript.*;
import java.util.*;

public class JsonParser
{
    private Context cx;
    private Scriptable scope;
    private int pos;
    private int length;
    private String src;
    
    public JsonParser(final Context cx, final Scriptable scope) {
        this.cx = cx;
        this.scope = scope;
    }
    
    public synchronized Object parseValue(final String json) throws ParseException {
        if (json == null) {
            throw new ParseException("Input string may not be null");
        }
        this.pos = 0;
        this.length = json.length();
        this.src = json;
        final Object value = this.readValue();
        this.consumeWhitespace();
        if (this.pos < this.length) {
            throw new ParseException("Expected end of stream at char " + this.pos);
        }
        return value;
    }
    
    private Object readValue() throws ParseException {
        this.consumeWhitespace();
        if (this.pos >= this.length) {
            throw new ParseException("Empty JSON string");
        }
        final char c = this.src.charAt(this.pos++);
        switch (c) {
            case '{': {
                return this.readObject();
            }
            case '[': {
                return this.readArray();
            }
            case 't': {
                return this.readTrue();
            }
            case 'f': {
                return this.readFalse();
            }
            case '\"': {
                return this.readString();
            }
            case 'n': {
                return this.readNull();
            }
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9': {
                return this.readNumber(c);
            }
            default: {
                throw new ParseException("Unexpected token: " + c);
            }
        }
    }
    
    private Object readObject() throws ParseException {
        this.consumeWhitespace();
        final Scriptable object = (Scriptable)this.cx.newObject(this.scope);
        if (this.pos < this.length && this.src.charAt(this.pos) == '}') {
            ++this.pos;
            return object;
        }
        boolean needsComma = false;
        while (this.pos < this.length) {
            final char c = this.src.charAt(this.pos++);
            switch (c) {
                case '}': {
                    if (!needsComma) {
                        throw new ParseException("Unexpected comma in object literal");
                    }
                    return object;
                }
                case ',': {
                    if (!needsComma) {
                        throw new ParseException("Unexpected comma in object literal");
                    }
                    needsComma = false;
                    break;
                }
                case '\"': {
                    if (needsComma) {
                        throw new ParseException("Missing comma in object literal");
                    }
                    final String id = this.readString();
                    this.consume(':');
                    final Object value = this.readValue();
                    final long index = ScriptRuntime.indexFromString(id);
                    if (index < 0L) {
                        object.put(id, object, value);
                    }
                    else {
                        object.put((int)index, object, value);
                    }
                    needsComma = true;
                    break;
                }
                default: {
                    throw new ParseException("Unexpected token in object literal");
                }
            }
            this.consumeWhitespace();
        }
        throw new ParseException("Unterminated object literal");
    }
    
    private Object readArray() throws ParseException {
        this.consumeWhitespace();
        if (this.pos < this.length && this.src.charAt(this.pos) == ']') {
            ++this.pos;
            return this.cx.newArray(this.scope, 0);
        }
        final List<Object> list = new ArrayList<Object>();
        boolean needsComma = false;
        while (this.pos < this.length) {
            final char c = this.src.charAt(this.pos);
            switch (c) {
                case ']': {
                    if (!needsComma) {
                        throw new ParseException("Unexpected comma in array literal");
                    }
                    ++this.pos;
                    return this.cx.newArray(this.scope, list.toArray());
                }
                case ',': {
                    if (!needsComma) {
                        throw new ParseException("Unexpected comma in array literal");
                    }
                    needsComma = false;
                    ++this.pos;
                    break;
                }
                default: {
                    if (needsComma) {
                        throw new ParseException("Missing comma in array literal");
                    }
                    list.add(this.readValue());
                    needsComma = true;
                    break;
                }
            }
            this.consumeWhitespace();
        }
        throw new ParseException("Unterminated array literal");
    }
    
    private String readString() throws ParseException {
        int stringStart = this.pos;
        while (this.pos < this.length) {
            final char c = this.src.charAt(this.pos++);
            if (c <= '\u001f') {
                throw new ParseException("String contains control character");
            }
            if (c == '\\') {
                break;
            }
            if (c == '\"') {
                return this.src.substring(stringStart, this.pos - 1);
            }
        }
        final StringBuilder b = new StringBuilder();
        while (this.pos < this.length) {
            assert this.src.charAt(this.pos - 1) == '\\';
            b.append(this.src, stringStart, this.pos - 1);
            if (this.pos >= this.length) {
                throw new ParseException("Unterminated string");
            }
            char c2 = this.src.charAt(this.pos++);
            switch (c2) {
                case '\"': {
                    b.append('\"');
                    break;
                }
                case '\\': {
                    b.append('\\');
                    break;
                }
                case '/': {
                    b.append('/');
                    break;
                }
                case 'b': {
                    b.append('\b');
                    break;
                }
                case 'f': {
                    b.append('\f');
                    break;
                }
                case 'n': {
                    b.append('\n');
                    break;
                }
                case 'r': {
                    b.append('\r');
                    break;
                }
                case 't': {
                    b.append('\t');
                    break;
                }
                case 'u': {
                    if (this.length - this.pos < 5) {
                        throw new ParseException("Invalid character code: \\u" + this.src.substring(this.pos));
                    }
                    final int code = this.fromHex(this.src.charAt(this.pos + 0)) << 12 | this.fromHex(this.src.charAt(this.pos + 1)) << 8 | this.fromHex(this.src.charAt(this.pos + 2)) << 4 | this.fromHex(this.src.charAt(this.pos + 3));
                    if (code < 0) {
                        throw new ParseException("Invalid character code: " + this.src.substring(this.pos, this.pos + 4));
                    }
                    this.pos += 4;
                    b.append((char)code);
                    break;
                }
                default: {
                    throw new ParseException("Unexpected character in string: '\\" + c2 + "'");
                }
            }
            stringStart = this.pos;
            while (this.pos < this.length) {
                c2 = this.src.charAt(this.pos++);
                if (c2 <= '\u001f') {
                    throw new ParseException("String contains control character");
                }
                if (c2 == '\\') {
                    break;
                }
                if (c2 == '\"') {
                    b.append(this.src, stringStart, this.pos - 1);
                    return b.toString();
                }
            }
        }
        throw new ParseException("Unterminated string literal");
    }
    
    private int fromHex(final char c) {
        return (c >= '0' && c <= '9') ? (c - '0') : ((c >= 'A' && c <= 'F') ? (c - 'A' + 10) : ((c >= 'a' && c <= 'f') ? (c - 'a' + 10) : -1));
    }
    
    private Number readNumber(char c) throws ParseException {
        assert c >= '0' && c <= '9';
        final int numberStart = this.pos - 1;
        if (c == '-') {
            c = this.nextOrNumberError(numberStart);
            if (c < '0' || c > '9') {
                throw this.numberError(numberStart, this.pos);
            }
        }
        if (c != '0') {
            this.readDigits();
        }
        if (this.pos < this.length) {
            c = this.src.charAt(this.pos);
            if (c == '.') {
                ++this.pos;
                c = this.nextOrNumberError(numberStart);
                if (c < '0' || c > '9') {
                    throw this.numberError(numberStart, this.pos);
                }
                this.readDigits();
            }
        }
        if (this.pos < this.length) {
            c = this.src.charAt(this.pos);
            if (c == 'e' || c == 'E') {
                ++this.pos;
                c = this.nextOrNumberError(numberStart);
                if (c == '-' || c == '+') {
                    c = this.nextOrNumberError(numberStart);
                }
                if (c < '0' || c > '9') {
                    throw this.numberError(numberStart, this.pos);
                }
                this.readDigits();
            }
        }
        final String num = this.src.substring(numberStart, this.pos);
        final double dval = Double.parseDouble(num);
        final int ival = (int)dval;
        if (ival == dval) {
            return ival;
        }
        return dval;
    }
    
    private ParseException numberError(final int start, final int end) {
        return new ParseException("Unsupported number format: " + this.src.substring(start, end));
    }
    
    private char nextOrNumberError(final int numberStart) throws ParseException {
        if (this.pos >= this.length) {
            throw this.numberError(numberStart, this.length);
        }
        return this.src.charAt(this.pos++);
    }
    
    private void readDigits() {
        while (this.pos < this.length) {
            final char c = this.src.charAt(this.pos);
            if (c < '0') {
                break;
            }
            if (c > '9') {
                break;
            }
            ++this.pos;
        }
    }
    
    private Boolean readTrue() throws ParseException {
        if (this.length - this.pos < 3 || this.src.charAt(this.pos) != 'r' || this.src.charAt(this.pos + 1) != 'u' || this.src.charAt(this.pos + 2) != 'e') {
            throw new ParseException("Unexpected token: t");
        }
        this.pos += 3;
        return Boolean.TRUE;
    }
    
    private Boolean readFalse() throws ParseException {
        if (this.length - this.pos < 4 || this.src.charAt(this.pos) != 'a' || this.src.charAt(this.pos + 1) != 'l' || this.src.charAt(this.pos + 2) != 's' || this.src.charAt(this.pos + 3) != 'e') {
            throw new ParseException("Unexpected token: f");
        }
        this.pos += 4;
        return Boolean.FALSE;
    }
    
    private Object readNull() throws ParseException {
        if (this.length - this.pos < 3 || this.src.charAt(this.pos) != 'u' || this.src.charAt(this.pos + 1) != 'l' || this.src.charAt(this.pos + 2) != 'l') {
            throw new ParseException("Unexpected token: n");
        }
        this.pos += 3;
        return null;
    }
    
    private void consumeWhitespace() {
        while (this.pos < this.length) {
            final char c = this.src.charAt(this.pos);
            switch (c) {
                case '\t':
                case '\n':
                case '\r':
                case ' ': {
                    ++this.pos;
                    continue;
                }
                default: {}
            }
        }
    }
    
    private void consume(final char token) throws ParseException {
        this.consumeWhitespace();
        if (this.pos >= this.length) {
            throw new ParseException("Expected " + token + " but reached end of stream");
        }
        final char c = this.src.charAt(this.pos++);
        if (c == token) {
            return;
        }
        throw new ParseException("Expected " + token + " found " + c);
    }
    
    public static class ParseException extends Exception
    {
        private static final long serialVersionUID = 4804542791749920772L;
        
        ParseException(final String message) {
            super(message);
        }
        
        ParseException(final Exception cause) {
            super(cause);
        }
    }
}
