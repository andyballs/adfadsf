//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.*;
import java.io.*;

class TokenStream
{
    private static final int EOF_CHAR = -1;
    private static final char BYTE_ORDER_MARK = '\ufeff';
    private boolean dirtyLine;
    String regExpFlags;
    private String string;
    private double number;
    private boolean isBinary;
    private boolean isOldOctal;
    private boolean isOctal;
    private boolean isHex;
    private boolean inTemplateLiteral;
    private boolean inTemplateExpr;
    private boolean endOfTemplate;
    private boolean justBeganTemplateExpr;
    private final StringBuilder currRawLiteral;
    private final List<String> rawLiterals;
    private int quoteChar;
    private char[] stringBuffer;
    private int stringBufferTop;
    private ObjToIntMap allStrings;
    private final int[] ungetBuffer;
    private int ungetCursor;
    private boolean hitEOF;
    private int lineStart;
    private int lineEndChar;
    int lineno;
    private String sourceString;
    private Reader sourceReader;
    private char[] sourceBuffer;
    private int sourceEnd;
    int sourceCursor;
    int cursor;
    int tokenBeg;
    int tokenEnd;
    Token.CommentType commentType;
    private Parser parser;
    private String commentPrefix;
    private int commentCursor;
    
    TokenStream(final Parser parser, final Reader sourceReader, final String sourceString, final int lineno) {
        this.string = "";
        this.inTemplateLiteral = false;
        this.inTemplateExpr = false;
        this.endOfTemplate = false;
        this.justBeganTemplateExpr = false;
        this.currRawLiteral = new StringBuilder();
        this.rawLiterals = new ArrayList<String>();
        this.stringBuffer = new char[128];
        this.allStrings = new ObjToIntMap(50);
        this.ungetBuffer = new int[3];
        this.hitEOF = false;
        this.lineStart = 0;
        this.lineEndChar = -1;
        this.commentPrefix = "";
        this.commentCursor = -1;
        this.parser = parser;
        this.lineno = lineno;
        if (sourceReader != null) {
            if (sourceString != null) {
                Kit.codeBug();
            }
            this.sourceReader = sourceReader;
            this.sourceBuffer = new char[512];
            this.sourceEnd = 0;
        }
        else {
            if (sourceString == null) {
                Kit.codeBug();
            }
            this.sourceString = sourceString;
            this.sourceEnd = sourceString.length();
        }
        final int n = 0;
        this.cursor = n;
        this.sourceCursor = n;
    }
    
    String tokenToString(final int token) {
        return "";
    }
    
    static boolean isKeyword(final String s, final int version, final boolean isStrict) {
        return 0 != stringToKeyword(s, version, isStrict);
    }
    
    private static int stringToKeyword(final String name, final int version, final boolean isStrict) {
        if (version < 200) {
            return stringToKeywordForJS(name);
        }
        return stringToKeywordForES(name, isStrict);
    }
    
    private static int stringToKeywordForJS(final String name) {
        final int Id_break = 129;
        final int Id_case = 124;
        final int Id_continue = 130;
        final int Id_default = 125;
        final int Id_delete = 32;
        final int Id_do = 127;
        final int Id_else = 122;
        final int Id_export = 137;
        final int Id_false = 47;
        final int Id_for = 128;
        final int Id_function = 114;
        final int Id_class = 115;
        final int Id_extends = 116;
        final int Id_static = 117;
        final int Id_super = 118;
        final int Id_if = 121;
        final int Id_in = 55;
        final int Id_let = 158;
        final int Id_new = 31;
        final int Id_null = 45;
        final int Id_return = 4;
        final int Id_switch = 123;
        final int Id_this = 46;
        final int Id_true = 48;
        final int Id_typeof = 33;
        final int Id_var = 131;
        final int Id_void = 136;
        final int Id_while = 126;
        final int Id_with = 132;
        final int Id_yield = 76;
        final int Id_abstract = 137;
        final int Id_boolean = 137;
        final int Id_byte = 137;
        final int Id_catch = 133;
        final int Id_char = 137;
        final int Id_const = 159;
        final int Id_debugger = 165;
        final int Id_double = 137;
        final int Id_enum = 137;
        final int Id_final = 137;
        final int Id_finally = 134;
        final int Id_float = 137;
        final int Id_goto = 137;
        final int Id_implements = 137;
        final int Id_import = 137;
        final int Id_instanceof = 56;
        final int Id_int = 137;
        final int Id_interface = 137;
        final int Id_long = 137;
        final int Id_native = 137;
        final int Id_package = 137;
        final int Id_private = 137;
        final int Id_protected = 137;
        final int Id_public = 137;
        final int Id_short = 137;
        final int Id_synchronized = 137;
        final int Id_throw = 53;
        final int Id_throws = 137;
        final int Id_transient = 137;
        final int Id_try = 78;
        final int Id_volatile = 137;
        final String s = name;
        int id = 0;
        String X = null;
        Label_2114: {
            Label_2086: {
                switch (s.length()) {
                    case 2: {
                        final int c = s.charAt(1);
                        if (c == 102) {
                            if (s.charAt(0) == 'i') {
                                id = 121;
                                break Label_2114;
                            }
                            break;
                        }
                        else if (c == 110) {
                            if (s.charAt(0) == 'i') {
                                id = 55;
                                break Label_2114;
                            }
                            break;
                        }
                        else {
                            if (c == 111 && s.charAt(0) == 'd') {
                                id = 127;
                                break Label_2114;
                            }
                            break;
                        }
                        break;
                    }
                    case 3: {
                        switch (s.charAt(0)) {
                            case 'f': {
                                if (s.charAt(2) == 'r' && s.charAt(1) == 'o') {
                                    id = 128;
                                    break Label_2114;
                                }
                                break Label_2086;
                            }
                            case 'i': {
                                if (s.charAt(2) == 't' && s.charAt(1) == 'n') {
                                    id = 137;
                                    break Label_2114;
                                }
                                break Label_2086;
                            }
                            case 'l': {
                                if (s.charAt(2) == 't' && s.charAt(1) == 'e') {
                                    id = 158;
                                    break Label_2114;
                                }
                                break Label_2086;
                            }
                            case 'n': {
                                if (s.charAt(2) == 'w' && s.charAt(1) == 'e') {
                                    id = 31;
                                    break Label_2114;
                                }
                                break Label_2086;
                            }
                            case 't': {
                                if (s.charAt(2) == 'y' && s.charAt(1) == 'r') {
                                    id = 78;
                                    break Label_2114;
                                }
                                break Label_2086;
                            }
                            case 'v': {
                                if (s.charAt(2) == 'r' && s.charAt(1) == 'a') {
                                    id = 131;
                                    break Label_2114;
                                }
                                break Label_2086;
                            }
                            default: {
                                break Label_2086;
                            }
                        }
                        break;
                    }
                    case 4: {
                        switch (s.charAt(0)) {
                            case 'b': {
                                X = "byte";
                                id = 137;
                                break Label_2086;
                            }
                            case 'c': {
                                final int c = s.charAt(3);
                                if (c == 101) {
                                    if (s.charAt(2) == 's' && s.charAt(1) == 'a') {
                                        id = 124;
                                        break Label_2114;
                                    }
                                    break Label_2086;
                                }
                                else {
                                    if (c == 114 && s.charAt(2) == 'a' && s.charAt(1) == 'h') {
                                        id = 137;
                                        break Label_2114;
                                    }
                                    break Label_2086;
                                }
                                break;
                            }
                            case 'e': {
                                final int c = s.charAt(3);
                                if (c == 101) {
                                    if (s.charAt(2) == 's' && s.charAt(1) == 'l') {
                                        id = 122;
                                        break Label_2114;
                                    }
                                    break Label_2086;
                                }
                                else {
                                    if (c == 109 && s.charAt(2) == 'u' && s.charAt(1) == 'n') {
                                        id = 137;
                                        break Label_2114;
                                    }
                                    break Label_2086;
                                }
                                break;
                            }
                            case 'g': {
                                X = "goto";
                                id = 137;
                                break Label_2086;
                            }
                            case 'l': {
                                X = "long";
                                id = 137;
                                break Label_2086;
                            }
                            case 'n': {
                                X = "null";
                                id = 45;
                                break Label_2086;
                            }
                            case 't': {
                                final int c = s.charAt(3);
                                if (c == 101) {
                                    if (s.charAt(2) == 'u' && s.charAt(1) == 'r') {
                                        id = 48;
                                        break Label_2114;
                                    }
                                    break Label_2086;
                                }
                                else {
                                    if (c == 115 && s.charAt(2) == 'i' && s.charAt(1) == 'h') {
                                        id = 46;
                                        break Label_2114;
                                    }
                                    break Label_2086;
                                }
                                break;
                            }
                            case 'v': {
                                X = "void";
                                id = 136;
                                break Label_2086;
                            }
                            case 'w': {
                                X = "with";
                                id = 132;
                                break Label_2086;
                            }
                            default: {
                                break Label_2086;
                            }
                        }
                        break;
                    }
                    case 5: {
                        switch (s.charAt(2)) {
                            case 'a': {
                                X = "class";
                                id = 115;
                                break Label_2086;
                            }
                            case 'e': {
                                final int c = s.charAt(0);
                                if (c == 98) {
                                    X = "break";
                                    id = 129;
                                    break Label_2086;
                                }
                                if (c == 121) {
                                    X = "yield";
                                    id = 76;
                                    break Label_2086;
                                }
                                break Label_2086;
                            }
                            case 'i': {
                                X = "while";
                                id = 126;
                                break Label_2086;
                            }
                            case 'l': {
                                X = "false";
                                id = 47;
                                break Label_2086;
                            }
                            case 'n': {
                                final int c = s.charAt(0);
                                if (c == 99) {
                                    X = "const";
                                    id = 159;
                                    break Label_2086;
                                }
                                if (c == 102) {
                                    X = "final";
                                    id = 137;
                                    break Label_2086;
                                }
                                break Label_2086;
                            }
                            case 'o': {
                                final int c = s.charAt(0);
                                if (c == 102) {
                                    X = "float";
                                    id = 137;
                                    break Label_2086;
                                }
                                if (c == 115) {
                                    X = "short";
                                    id = 137;
                                    break Label_2086;
                                }
                                break Label_2086;
                            }
                            case 'p': {
                                X = "super";
                                id = 118;
                                break Label_2086;
                            }
                            case 'r': {
                                X = "throw";
                                id = 53;
                                break Label_2086;
                            }
                            case 't': {
                                X = "catch";
                                id = 133;
                                break Label_2086;
                            }
                            default: {
                                break Label_2086;
                            }
                        }
                        break;
                    }
                    case 6: {
                        switch (s.charAt(1)) {
                            case 'a': {
                                X = "native";
                                id = 137;
                                break Label_2086;
                            }
                            case 'e': {
                                final int c = s.charAt(0);
                                if (c == 100) {
                                    X = "delete";
                                    id = 32;
                                    break Label_2086;
                                }
                                if (c == 114) {
                                    X = "return";
                                    id = 4;
                                    break Label_2086;
                                }
                                break Label_2086;
                            }
                            case 'h': {
                                X = "throws";
                                id = 137;
                                break Label_2086;
                            }
                            case 'm': {
                                X = "import";
                                id = 137;
                                break Label_2086;
                            }
                            case 'o': {
                                X = "double";
                                id = 137;
                                break Label_2086;
                            }
                            case 't': {
                                X = "static";
                                id = 117;
                                break Label_2086;
                            }
                            case 'u': {
                                X = "public";
                                id = 137;
                                break Label_2086;
                            }
                            case 'w': {
                                X = "switch";
                                id = 123;
                                break Label_2086;
                            }
                            case 'x': {
                                X = "export";
                                id = 137;
                                break Label_2086;
                            }
                            case 'y': {
                                X = "typeof";
                                id = 33;
                                break Label_2086;
                            }
                            default: {
                                break Label_2086;
                            }
                        }
                        break;
                    }
                    case 7: {
                        switch (s.charAt(1)) {
                            case 'a': {
                                X = "package";
                                id = 137;
                                break Label_2086;
                            }
                            case 'e': {
                                X = "default";
                                id = 125;
                                break Label_2086;
                            }
                            case 'i': {
                                X = "finally";
                                id = 134;
                                break Label_2086;
                            }
                            case 'o': {
                                X = "boolean";
                                id = 137;
                                break Label_2086;
                            }
                            case 'r': {
                                X = "private";
                                id = 137;
                                break Label_2086;
                            }
                            case 'x': {
                                X = "extends";
                                id = 116;
                                break Label_2086;
                            }
                            default: {
                                break Label_2086;
                            }
                        }
                        break;
                    }
                    case 8: {
                        switch (s.charAt(0)) {
                            case 'a': {
                                X = "abstract";
                                id = 137;
                                break Label_2086;
                            }
                            case 'c': {
                                X = "continue";
                                id = 130;
                                break Label_2086;
                            }
                            case 'd': {
                                X = "debugger";
                                id = 165;
                                break Label_2086;
                            }
                            case 'f': {
                                X = "function";
                                id = 114;
                                break Label_2086;
                            }
                            case 'v': {
                                X = "volatile";
                                id = 137;
                                break Label_2086;
                            }
                            default: {
                                break Label_2086;
                            }
                        }
                        break;
                    }
                    case 9: {
                        final int c = s.charAt(0);
                        if (c == 105) {
                            X = "interface";
                            id = 137;
                            break;
                        }
                        if (c == 112) {
                            X = "protected";
                            id = 137;
                            break;
                        }
                        if (c == 116) {
                            X = "transient";
                            id = 137;
                            break;
                        }
                        break;
                    }
                    case 10: {
                        final int c = s.charAt(1);
                        if (c == 109) {
                            X = "implements";
                            id = 137;
                            break;
                        }
                        if (c == 110) {
                            X = "instanceof";
                            id = 56;
                            break;
                        }
                        break;
                    }
                    case 12: {
                        X = "synchronized";
                        id = 137;
                        break;
                    }
                }
            }
            if (X != null && X != s && !X.equals(s)) {
                id = 0;
            }
        }
        if (id == 0) {
            return 0;
        }
        return id & 0xFF;
    }
    
    private static int stringToKeywordForES(final String name, final boolean isStrict) {
        final int Id_break = 129;
        final int Id_case = 124;
        final int Id_catch = 133;
        final int Id_class = 115;
        final int Id_const = 159;
        final int Id_continue = 130;
        final int Id_debugger = 165;
        final int Id_decorator = 135;
        final int Id_default = 125;
        final int Id_delete = 32;
        final int Id_do = 127;
        final int Id_else = 122;
        final int Id_export = 119;
        final int Id_extends = 116;
        final int Id_finally = 134;
        final int Id_for = 128;
        final int Id_function = 114;
        final int Id_if = 121;
        final int Id_import = 120;
        final int Id_in = 55;
        final int Id_instanceof = 56;
        final int Id_new = 31;
        final int Id_return = 4;
        final int Id_static = 117;
        final int Id_super = 118;
        final int Id_switch = 123;
        final int Id_this = 46;
        final int Id_throw = 53;
        final int Id_try = 78;
        final int Id_typeof = 33;
        final int Id_var = 131;
        final int Id_void = 136;
        final int Id_while = 126;
        final int Id_with = 132;
        final int Id_yield = 76;
        final int Id_await = 137;
        final int Id_enum = 137;
        final int Id_implements = 137;
        final int Id_interface = 137;
        final int Id_package = 137;
        final int Id_private = 137;
        final int Id_protected = 137;
        final int Id_public = 137;
        final int Id_false = 47;
        final int Id_null = 45;
        final int Id_true = 48;
        final int Id_let = 158;
        final String s = name;
        int id = 0;
        String X = null;
        Label_1556: {
            Label_1528: {
                switch (s.length()) {
                    case 2: {
                        final int c = s.charAt(1);
                        if (c == 102) {
                            if (s.charAt(0) == 'i') {
                                id = 121;
                                break Label_1556;
                            }
                            break;
                        }
                        else if (c == 110) {
                            if (s.charAt(0) == 'i') {
                                id = 55;
                                break Label_1556;
                            }
                            break;
                        }
                        else {
                            if (c == 111 && s.charAt(0) == 'd') {
                                id = 127;
                                break Label_1556;
                            }
                            break;
                        }
                        break;
                    }
                    case 3: {
                        switch (s.charAt(0)) {
                            case 'f': {
                                if (s.charAt(2) == 'r' && s.charAt(1) == 'o') {
                                    id = 128;
                                    break Label_1556;
                                }
                                break Label_1528;
                            }
                            case 'l': {
                                if (s.charAt(2) == 't' && s.charAt(1) == 'e') {
                                    id = 158;
                                    break Label_1556;
                                }
                                break Label_1528;
                            }
                            case 'n': {
                                if (s.charAt(2) == 'w' && s.charAt(1) == 'e') {
                                    id = 31;
                                    break Label_1556;
                                }
                                break Label_1528;
                            }
                            case 't': {
                                if (s.charAt(2) == 'y' && s.charAt(1) == 'r') {
                                    id = 78;
                                    break Label_1556;
                                }
                                break Label_1528;
                            }
                            case 'v': {
                                if (s.charAt(2) == 'r' && s.charAt(1) == 'a') {
                                    id = 131;
                                    break Label_1556;
                                }
                                break Label_1528;
                            }
                            default: {
                                break Label_1528;
                            }
                        }
                        break;
                    }
                    case 4: {
                        switch (s.charAt(1)) {
                            case 'a': {
                                X = "case";
                                id = 124;
                                break Label_1528;
                            }
                            case 'h': {
                                X = "this";
                                id = 46;
                                break Label_1528;
                            }
                            case 'i': {
                                X = "with";
                                id = 132;
                                break Label_1528;
                            }
                            case 'l': {
                                X = "else";
                                id = 122;
                                break Label_1528;
                            }
                            case 'n': {
                                X = "enum";
                                id = 137;
                                break Label_1528;
                            }
                            case 'o': {
                                X = "void";
                                id = 136;
                                break Label_1528;
                            }
                            case 'r': {
                                X = "true";
                                id = 48;
                                break Label_1528;
                            }
                            case 'u': {
                                X = "null";
                                id = 45;
                                break Label_1528;
                            }
                            default: {
                                break Label_1528;
                            }
                        }
                        break;
                    }
                    case 5: {
                        switch (s.charAt(0)) {
                            case 'a': {
                                X = "await";
                                id = 137;
                                break Label_1528;
                            }
                            case 'b': {
                                X = "break";
                                id = 129;
                                break Label_1528;
                            }
                            case 'c': {
                                final int c = s.charAt(4);
                                if (c == 104) {
                                    X = "catch";
                                    id = 133;
                                    break Label_1528;
                                }
                                if (c == 115) {
                                    X = "class";
                                    id = 115;
                                    break Label_1528;
                                }
                                if (c == 116) {
                                    X = "const";
                                    id = 159;
                                    break Label_1528;
                                }
                                break Label_1528;
                            }
                            case 'f': {
                                X = "false";
                                id = 47;
                                break Label_1528;
                            }
                            case 's': {
                                X = "super";
                                id = 118;
                                break Label_1528;
                            }
                            case 't': {
                                X = "throw";
                                id = 53;
                                break Label_1528;
                            }
                            case 'w': {
                                X = "while";
                                id = 126;
                                break Label_1528;
                            }
                            case 'y': {
                                X = "yield";
                                id = 76;
                                break Label_1528;
                            }
                            default: {
                                break Label_1528;
                            }
                        }
                        break;
                    }
                    case 6: {
                        switch (s.charAt(0)) {
                            case 'd': {
                                X = "delete";
                                id = 32;
                                break Label_1528;
                            }
                            case 'e': {
                                X = "export";
                                id = 119;
                                break Label_1528;
                            }
                            case 'i': {
                                X = "import";
                                id = 120;
                                break Label_1528;
                            }
                            case 'p': {
                                X = "public";
                                id = 137;
                                break Label_1528;
                            }
                            case 'r': {
                                X = "return";
                                id = 4;
                                break Label_1528;
                            }
                            case 's': {
                                final int c = s.charAt(5);
                                if (c == 99) {
                                    X = "static";
                                    id = 117;
                                    break Label_1528;
                                }
                                if (c == 104) {
                                    X = "switch";
                                    id = 123;
                                    break Label_1528;
                                }
                                break Label_1528;
                            }
                            case 't': {
                                X = "typeof";
                                id = 33;
                                break Label_1528;
                            }
                            default: {
                                break Label_1528;
                            }
                        }
                        break;
                    }
                    case 7: {
                        switch (s.charAt(1)) {
                            case 'a': {
                                X = "package";
                                id = 137;
                                break Label_1528;
                            }
                            case 'e': {
                                X = "default";
                                id = 125;
                                break Label_1528;
                            }
                            case 'i': {
                                X = "finally";
                                id = 134;
                                break Label_1528;
                            }
                            case 'r': {
                                X = "private";
                                id = 137;
                                break Label_1528;
                            }
                            case 'x': {
                                X = "extends";
                                id = 116;
                                break Label_1528;
                            }
                            default: {
                                break Label_1528;
                            }
                        }
                        break;
                    }
                    case 8: {
                        final int c = s.charAt(0);
                        if (c == 99) {
                            X = "continue";
                            id = 130;
                            break;
                        }
                        if (c == 100) {
                            X = "debugger";
                            id = 165;
                            break;
                        }
                        if (c == 102) {
                            X = "function";
                            id = 114;
                            break;
                        }
                        break;
                    }
                    case 9: {
                        final int c = s.charAt(0);
                        if (c == 100) {
                            X = "decorator";
                            id = 135;
                            break;
                        }
                        if (c == 105) {
                            X = "interface";
                            id = 137;
                            break;
                        }
                        if (c == 112) {
                            X = "protected";
                            id = 137;
                            break;
                        }
                        break;
                    }
                    case 10: {
                        final int c = s.charAt(1);
                        if (c == 109) {
                            X = "implements";
                            id = 137;
                            break;
                        }
                        if (c == 110) {
                            X = "instanceof";
                            id = 56;
                            break;
                        }
                        break;
                    }
                }
            }
            if (X != null && X != s && !X.equals(s)) {
                id = 0;
            }
        }
        if (id == 0) {
            return 0;
        }
        return id & 0xFF;
    }
    
    final String getSourceString() {
        return this.sourceString;
    }
    
    final int getLineno() {
        return this.lineno;
    }
    
    final String getString() {
        return this.string;
    }
    
    final char getQuoteChar() {
        return (char)this.quoteChar;
    }
    
    final double getNumber() {
        return this.number;
    }
    
    final boolean isNumberBinary() {
        return this.isBinary;
    }
    
    final boolean isNumberOldOctal() {
        return this.isOldOctal;
    }
    
    final boolean isNumberOctal() {
        return this.isOctal;
    }
    
    final boolean isNumberHex() {
        return this.isHex;
    }
    
    final boolean eof() {
        return this.hitEOF;
    }
    
    final int getToken() throws IOException {
        if (this.inTemplateLiteral && !this.inTemplateExpr && !this.endOfTemplate) {
            int character = this.getChar(false);
            boolean wasJustEscape = false;
            this.stringBufferTop = 0;
            while (character != 96) {
                this.currRawLiteral.append((char)character);
                if (character == -1) {
                    throw new EvaluatorException("Unfinished template literal");
                }
                if (character == 92) {
                    character = this.getChar();
                    this.currRawLiteral.append((char)character);
                    switch (character) {
                        case 98: {
                            character = 8;
                            break;
                        }
                        case 102: {
                            character = 12;
                            break;
                        }
                        case 110: {
                            character = 10;
                            break;
                        }
                        case 114: {
                            character = 13;
                            break;
                        }
                        case 116: {
                            character = 9;
                            break;
                        }
                        case 118: {
                            character = 11;
                            break;
                        }
                        case 117: {
                            final int escapeStart = this.stringBufferTop;
                            int escapeVal = 0;
                            if (!this.matchChar(123)) {
                                this.addToString(117);
                                for (int i = 0; i != 4; ++i) {
                                    final int c = this.getChar();
                                    escapeVal = Kit.xDigitToInt(c, escapeVal);
                                    if (escapeVal < 0) {
                                        this.parser.addError("msg.invalid.escape");
                                        return -1;
                                    }
                                    this.addToString(c);
                                }
                                final int c = escapeVal;
                                this.stringBufferTop = escapeStart;
                                break;
                            }
                            for (int i = 0; i < 6; ++i) {
                                final int c = this.getChar();
                                if (c == 125) {
                                    this.ungetChar(c);
                                    break;
                                }
                                escapeVal = Kit.xDigitToInt(c, escapeVal);
                                if (escapeVal < 0) {
                                    break;
                                }
                            }
                            int c = this.getChar();
                            if (c != 125) {
                                this.parser.addError("msg.invalid.escape");
                                return -1;
                            }
                            final int high = (escapeVal - 65536) / 1024 + 55296;
                            this.addToString(high);
                            c = (char)(escapeVal - 65536) % '\u0400' + 56320;
                            break;
                        }
                        case 120: {
                            character = this.getChar();
                            int escapeVal = Kit.xDigitToInt(character, 0);
                            if (escapeVal < 0) {
                                this.addToString(120);
                                continue;
                            }
                            final int c2 = character;
                            character = this.getChar();
                            escapeVal = Kit.xDigitToInt(character, escapeVal);
                            if (escapeVal < 0) {
                                this.addToString(120);
                                this.addToString(c2);
                                continue;
                            }
                            character = escapeVal;
                            break;
                        }
                        case 10: {
                            character = this.getChar();
                            continue;
                        }
                        default: {
                            if (48 <= character && character < 56) {
                                int val = character - 48;
                                character = this.getChar();
                                if (48 <= character && character < 56) {
                                    val = 8 * val + character - 48;
                                    character = this.getChar();
                                    if (48 <= character && character < 56 && val <= 31) {
                                        val = 8 * val + character - 48;
                                        character = this.getChar();
                                    }
                                }
                                this.ungetChar(character);
                                character = val;
                                break;
                            }
                            break;
                        }
                    }
                }
                if (character == 36 && !wasJustEscape) {
                    final int aChar = this.getChar(false);
                    if (aChar == 123) {
                        this.justBeganTemplateExpr = true;
                        this.inTemplateExpr = true;
                        this.currRawLiteral.deleteCharAt(this.currRawLiteral.length() - 1);
                        this.rawLiterals.add(this.currRawLiteral.toString());
                        this.currRawLiteral.setLength(0);
                        this.ungetChar(aChar);
                        this.ungetChar(character);
                        break;
                    }
                    this.ungetChar(aChar);
                }
                wasJustEscape = (character == 92);
                this.addToString(character);
                character = this.getChar(false);
            }
            if (character == 96) {
                this.ungetChar(96);
                this.endOfTemplate = true;
            }
            final String str = this.getStringFromBuffer();
            this.string = (String)this.allStrings.intern((Object)str);
            return 42;
        }
        if (this.justBeganTemplateExpr) {
            this.justBeganTemplateExpr = false;
            this.getChar();
            this.getChar();
            return 44;
        }
        int c;
        do {
            c = this.getChar();
            if (c == -1) {
                this.tokenBeg = this.cursor - 1;
                this.tokenEnd = this.cursor;
                return 0;
            }
            if (c == 10) {
                this.dirtyLine = false;
                this.tokenBeg = this.cursor - 1;
                this.tokenEnd = this.cursor;
                return 1;
            }
        } while (isJSSpace(c));
        if (c != 45) {
            this.dirtyLine = true;
        }
        this.tokenBeg = this.cursor - 1;
        this.tokenEnd = this.cursor;
        if (c == 64) {
            return 153;
        }
        boolean isUnicodeEscapeStart = false;
        boolean identifierStart;
        if (c == 92) {
            c = this.getChar();
            if (c == 117) {
                identifierStart = true;
                isUnicodeEscapeStart = true;
                this.stringBufferTop = 0;
            }
            else {
                identifierStart = false;
                this.ungetChar(c);
                c = 92;
            }
        }
        else {
            identifierStart = Character.isJavaIdentifierStart((char)c);
            if (identifierStart) {
                this.stringBufferTop = 0;
                this.addToString(c);
            }
        }
        if (identifierStart) {
            boolean containsEscape = isUnicodeEscapeStart;
            while (true) {
                if (isUnicodeEscapeStart) {
                    int escapeVal2 = 0;
                    if (this.matchChar(123)) {
                        for (int i = 0; i < 6; ++i) {
                            c = this.getChar();
                            if (c == 125) {
                                this.ungetChar(c);
                                break;
                            }
                            escapeVal2 = Kit.xDigitToInt(c, escapeVal2);
                            if (escapeVal2 < 0) {
                                break;
                            }
                        }
                        c = this.getChar();
                        if (c != 125) {
                            this.parser.addError("msg.invalid.escape");
                            return -1;
                        }
                        this.addToString((escapeVal2 - 65536) / 1024 + 55296);
                        this.addToString((escapeVal2 - 65536) % 1024 + 56320);
                        isUnicodeEscapeStart = false;
                        break;
                    }
                    else {
                        for (int i = 0; i != 4; ++i) {
                            c = this.getChar();
                            escapeVal2 = Kit.xDigitToInt(c, escapeVal2);
                            if (escapeVal2 < 0) {
                                break;
                            }
                        }
                        if (escapeVal2 < 0) {
                            this.parser.addError("msg.invalid.escape");
                            return -1;
                        }
                        this.addToString(escapeVal2);
                        isUnicodeEscapeStart = false;
                    }
                }
                else {
                    c = this.getChar();
                    if (c == 92) {
                        c = this.getChar();
                        if (c != 117) {
                            this.parser.addError("msg.illegal.character", c);
                            return -1;
                        }
                        isUnicodeEscapeStart = true;
                        containsEscape = true;
                    }
                    else {
                        if (c == -1 || c == 65279) {
                            break;
                        }
                        if (!Character.isJavaIdentifierPart((char)c)) {
                            break;
                        }
                        this.addToString(c);
                    }
                }
            }
            if (!containsEscape) {
                this.ungetChar(c);
            }
            String str2 = this.getStringFromBuffer();
            if (!containsEscape) {
                int result = stringToKeyword(str2, this.parser.compilerEnv.getLanguageVersion(), this.parser.inUseStrictDirective());
                if (result != 0) {
                    if ((result == 158 || result == 76) && this.parser.compilerEnv.getLanguageVersion() < 170) {
                        this.string = ((result == 158) ? "let" : "yield");
                        result = 40;
                    }
                    this.string = (String)this.allStrings.intern((Object)str2);
                    if (result != 137) {
                        return result;
                    }
                    if (this.parser.compilerEnv.getLanguageVersion() >= 200) {
                        return result;
                    }
                    if (!this.parser.compilerEnv.isReservedKeywordAsIdentifier()) {
                        return result;
                    }
                }
            }
            else if (isKeyword(str2, this.parser.compilerEnv.getLanguageVersion(), this.parser.inUseStrictDirective())) {
                str2 = this.convertLastCharToHex(str2);
            }
            this.string = (String)this.allStrings.intern((Object)str2);
            return 40;
        }
        if (isDigit(c) || (c == 46 && isDigit(this.peekChar()))) {
            this.stringBufferTop = 0;
            int base = 10;
            final boolean b = false;
            this.isBinary = b;
            this.isOctal = b;
            this.isOldOctal = b;
            this.isHex = b;
            final boolean es6 = this.parser.compilerEnv.getLanguageVersion() >= 200;
            if (c == 48) {
                c = this.getChar();
                if (c == 120 || c == 88) {
                    base = 16;
                    this.isHex = true;
                    c = this.getChar();
                }
                else if (es6 && (c == 111 || c == 79)) {
                    base = 8;
                    this.isOctal = true;
                    c = this.getChar();
                }
                else if (es6 && (c == 98 || c == 66)) {
                    base = 2;
                    this.isBinary = true;
                    c = this.getChar();
                }
                else if (isDigit(c)) {
                    base = 8;
                    this.isOldOctal = true;
                }
                else {
                    this.addToString(48);
                }
            }
            boolean isEmpty = true;
            if (base == 16) {
                while (0 <= Kit.xDigitToInt(c, 0)) {
                    this.addToString(c);
                    c = this.getChar();
                    isEmpty = false;
                }
            }
            else {
                while ((48 <= c && c <= 57) || c == 95) {
                    if (c == 95) {
                        c = this.getChar();
                        if (c == 101 || c == 69 || c == 46 || !isDigit(c)) {
                            this.parser.addError("msg.caught.nfe");
                            return -1;
                        }
                        continue;
                    }
                    else {
                        if (base == 8 && c >= 56) {
                            if (!this.isOldOctal) {
                                this.parser.addError("msg.caught.nfe");
                                return -1;
                            }
                            this.parser.addWarning("msg.bad.octal.literal", (c == 56) ? "8" : "9");
                            base = 10;
                        }
                        else if (base == 2 && c >= 50) {
                            this.parser.addError("msg.caught.nfe");
                            return -1;
                        }
                        this.addToString(c);
                        c = this.getChar();
                        isEmpty = false;
                    }
                }
            }
            if (isEmpty && (this.isBinary || this.isOctal || this.isHex)) {
                this.parser.addError("msg.caught.nfe");
                return -1;
            }
            boolean isInteger = true;
            if (base == 10 && (c == 46 || c == 101 || c == 69)) {
                isInteger = false;
                if (c == 46) {
                    if (this.peekChar() == 95) {
                        this.parser.addError("msg.caught.nfe");
                        return -1;
                    }
                    do {
                        if (c == 95) {
                            c = this.getChar();
                            if (!isDigit(c) && c != 95) {
                                this.parser.addError("msg.caught.nfe");
                                return -1;
                            }
                            continue;
                        }
                        else {
                            this.addToString(c);
                            c = this.getChar();
                        }
                    } while (isDigit(c) || c == 95);
                }
                if (c == 101 || c == 69) {
                    if (this.peekChar() == 95) {
                        this.parser.addError("msg.caught.nfe");
                        return -1;
                    }
                    this.addToString(c);
                    c = this.getChar();
                    if (c == 43 || c == 45) {
                        this.addToString(c);
                        c = this.getChar();
                    }
                    if (!isDigit(c)) {
                        this.parser.addError("msg.missing.exponent");
                        return -1;
                    }
                    do {
                        if (c == 95) {
                            c = this.getChar();
                            if (!isDigit(c) && c != 95) {
                                this.parser.addError("msg.caught.nfe");
                                return -1;
                            }
                            continue;
                        }
                        else {
                            this.addToString(c);
                            c = this.getChar();
                        }
                    } while (isDigit(c) || c == 95);
                }
            }
            this.ungetChar(c);
            final String numString = this.getStringFromBuffer();
            this.string = numString;
            double dval = 0.0;
            Label_2214: {
                if (base == 10 && !isInteger) {
                    try {
                        dval = Double.parseDouble(numString);
                        break Label_2214;
                    }
                    catch (NumberFormatException ex) {
                        this.parser.addError("msg.caught.nfe");
                        return -1;
                    }
                }
                dval = ScriptRuntime.stringPrefixToNumber(numString, 0, base);
            }
            this.number = dval;
            return 41;
        }
        else {
            if (c == 96) {
                this.inTemplateLiteral = !this.inTemplateLiteral;
                if (this.inTemplateLiteral) {
                    this.currRawLiteral.setLength(0);
                    this.rawLiterals.clear();
                }
                else {
                    this.rawLiterals.add(this.currRawLiteral.toString());
                }
                this.endOfTemplate = false;
                return 43;
            }
            if (c == 34 || c == 39) {
                this.quoteChar = c;
                this.stringBufferTop = 0;
                c = this.getChar(false);
                while (c != this.quoteChar) {
                    if (c == 10 || c == -1) {
                        this.ungetChar(c);
                        this.tokenEnd = this.cursor;
                        this.parser.addError("msg.unterminated.string.lit");
                        return -1;
                    }
                    if (c == 92) {
                        c = this.getChar();
                        switch (c) {
                            case 98: {
                                c = 8;
                                break;
                            }
                            case 102: {
                                c = 12;
                                break;
                            }
                            case 110: {
                                c = 10;
                                break;
                            }
                            case 114: {
                                c = 13;
                                break;
                            }
                            case 116: {
                                c = 9;
                                break;
                            }
                            case 118: {
                                c = 11;
                                break;
                            }
                            case 117: {
                                final int escapeStart = this.stringBufferTop;
                                int escapeVal = 0;
                                if (!this.matchChar(123)) {
                                    this.addToString(117);
                                    for (int i = 0; i != 4; ++i) {
                                        c = this.getChar();
                                        escapeVal = Kit.xDigitToInt(c, escapeVal);
                                        if (escapeVal < 0) {
                                            this.parser.addError("msg.invalid.escape");
                                            return -1;
                                        }
                                        this.addToString(c);
                                    }
                                    c = escapeVal;
                                    this.stringBufferTop = escapeStart;
                                    break;
                                }
                                for (int i = 0; i < 6; ++i) {
                                    c = this.getChar();
                                    if (c == 125) {
                                        this.ungetChar(c);
                                        break;
                                    }
                                    escapeVal = Kit.xDigitToInt(c, escapeVal);
                                    if (escapeVal < 0) {
                                        break;
                                    }
                                }
                                c = this.getChar();
                                if (c != 125) {
                                    this.parser.addError("msg.invalid.escape");
                                    return -1;
                                }
                                final int high = (escapeVal - 65536) / 1024 + 55296;
                                this.addToString(high);
                                c = (char)(escapeVal - 65536) % '\u0400' + 56320;
                                break;
                            }
                            case 120: {
                                c = this.getChar();
                                int escapeVal = Kit.xDigitToInt(c, 0);
                                if (escapeVal < 0) {
                                    this.addToString(120);
                                    continue;
                                }
                                final int c2 = c;
                                c = this.getChar();
                                escapeVal = Kit.xDigitToInt(c, escapeVal);
                                if (escapeVal < 0) {
                                    this.addToString(120);
                                    this.addToString(c2);
                                    continue;
                                }
                                c = escapeVal;
                                break;
                            }
                            case 10: {
                                c = this.getChar();
                                continue;
                            }
                            default: {
                                if (48 <= c && c < 56) {
                                    int val = c - 48;
                                    c = this.getChar();
                                    if (48 <= c && c < 56) {
                                        val = 8 * val + c - 48;
                                        c = this.getChar();
                                        if (48 <= c && c < 56 && val <= 31) {
                                            val = 8 * val + c - 48;
                                            c = this.getChar();
                                        }
                                    }
                                    this.ungetChar(c);
                                    c = val;
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    this.addToString(c);
                    c = this.getChar(false);
                }
                final String str = this.getStringFromBuffer();
                this.string = (String)this.allStrings.intern((Object)str);
                return 42;
            }
            switch (c) {
                case 59: {
                    return 79;
                }
                case 91: {
                    return 80;
                }
                case 93: {
                    return 81;
                }
                case 123: {
                    return 82;
                }
                case 125: {
                    return 83;
                }
                case 40: {
                    return 84;
                }
                case 41: {
                    return 85;
                }
                case 44: {
                    return 86;
                }
                case 63: {
                    if (this.matchChar(63)) {
                        if (this.matchChar(61)) {
                            return 102;
                        }
                        return 113;
                    }
                    else {
                        if (this.matchChar(46)) {
                            return 111;
                        }
                        return 103;
                    }
                    break;
                }
                case 35: {
                    return 170;
                }
                case 58: {
                    return 104;
                }
                case 46: {
                    if (this.matchChar(46)) {
                        if (this.matchChar(46)) {
                            return 110;
                        }
                        this.ungetChar(46);
                    }
                    return 109;
                }
                case 124: {
                    if (this.matchChar(124)) {
                        if (this.matchChar(61)) {
                            return 100;
                        }
                        return 105;
                    }
                    else {
                        if (this.matchChar(61)) {
                            return 88;
                        }
                        if (this.matchChar(62)) {
                            return 112;
                        }
                        return 9;
                    }
                    break;
                }
                case 94: {
                    if (this.matchChar(61)) {
                        return 89;
                    }
                    return 10;
                }
                case 38: {
                    if (this.matchChar(38)) {
                        if (this.matchChar(61)) {
                            return 101;
                        }
                        return 106;
                    }
                    else {
                        if (this.matchChar(61)) {
                            return 90;
                        }
                        return 11;
                    }
                    break;
                }
                case 61: {
                    if (this.matchChar(61)) {
                        if (this.matchChar(61)) {
                            return 49;
                        }
                        return 12;
                    }
                    else {
                        if (this.matchChar(62)) {
                            return 169;
                        }
                        return 87;
                    }
                    break;
                }
                case 33: {
                    if (!this.matchChar(61)) {
                        return 27;
                    }
                    if (this.matchChar(61)) {
                        return 50;
                    }
                    return 13;
                }
                case 60: {
                    if (this.matchChar(33)) {
                        if (this.matchChar(45)) {
                            if (this.matchChar(45)) {
                                this.tokenBeg = this.cursor - 4;
                                this.skipLine();
                                this.commentType = Token.CommentType.HTML;
                                return 166;
                            }
                            this.ungetCharIgnoreLineEnd(45);
                        }
                        this.ungetCharIgnoreLineEnd(33);
                    }
                    if (this.matchChar(60)) {
                        if (this.matchChar(61)) {
                            return 91;
                        }
                        return 18;
                    }
                    else {
                        if (this.matchChar(61)) {
                            return 15;
                        }
                        return 14;
                    }
                    break;
                }
                case 62: {
                    if (this.matchChar(62)) {
                        if (this.matchChar(62)) {
                            if (this.matchChar(61)) {
                                return 93;
                            }
                            return 20;
                        }
                        else {
                            if (this.matchChar(61)) {
                                return 92;
                            }
                            return 19;
                        }
                    }
                    else {
                        if (this.matchChar(61)) {
                            return 17;
                        }
                        return 16;
                    }
                    break;
                }
                case 42: {
                    if (this.matchChar(61)) {
                        return 96;
                    }
                    if (!this.matchChar(42)) {
                        return 23;
                    }
                    if (this.matchChar(61)) {
                        return 99;
                    }
                    return 26;
                }
                case 8233: {
                    return 1;
                }
                case 47: {
                    this.markCommentStart();
                    if (this.matchChar(47)) {
                        this.tokenBeg = this.cursor - 2;
                        this.skipLine();
                        this.commentType = Token.CommentType.LINE;
                        return 166;
                    }
                    if (this.matchChar(42)) {
                        boolean lookForSlash = false;
                        this.tokenBeg = this.cursor - 2;
                        if (this.matchChar(42)) {
                            lookForSlash = true;
                            this.commentType = Token.CommentType.JSDOC;
                        }
                        else {
                            this.commentType = Token.CommentType.BLOCK_COMMENT;
                        }
                        while (true) {
                            c = this.getChar();
                            if (c == -1) {
                                this.tokenEnd = this.cursor - 1;
                                this.parser.addError("msg.unterminated.comment");
                                return 166;
                            }
                            if (c == 42) {
                                lookForSlash = true;
                            }
                            else if (c == 47) {
                                if (lookForSlash) {
                                    this.tokenEnd = this.cursor;
                                    return 166;
                                }
                                continue;
                            }
                            else {
                                lookForSlash = false;
                                this.tokenEnd = this.cursor;
                            }
                        }
                    }
                    else {
                        if (this.matchChar(61)) {
                            return 97;
                        }
                        return 24;
                    }
                    break;
                }
                case 37: {
                    if (this.matchChar(61)) {
                        return 98;
                    }
                    return 25;
                }
                case 126: {
                    return 28;
                }
                case 43: {
                    if (this.matchChar(61)) {
                        return 94;
                    }
                    if (this.matchChar(43)) {
                        return 107;
                    }
                    return 21;
                }
                case 45: {
                    if (this.matchChar(45)) {
                        if (this.matchChar(62)) {
                            this.tokenBeg = this.cursor - 3;
                            this.skipLine();
                            this.commentType = Token.CommentType.HTML;
                            return 166;
                        }
                        this.ungetCharIgnoreLineEnd(45);
                    }
                    if (this.matchChar(61)) {
                        c = 95;
                    }
                    else if (this.matchChar(45)) {
                        if (!this.dirtyLine && this.matchChar(62)) {
                            this.markCommentStart("--");
                            this.skipLine();
                            this.commentType = Token.CommentType.HTML;
                            return 166;
                        }
                        c = 108;
                    }
                    else {
                        c = 22;
                    }
                    this.dirtyLine = true;
                    return c;
                }
                default: {
                    this.parser.addError("msg.illegal.character", c);
                    return -1;
                }
            }
        }
    }
    
    private static boolean isAlpha(final int c) {
        if (c <= 90) {
            return 65 <= c;
        }
        return 97 <= c && c <= 122;
    }
    
    static boolean isDigit(final int c) {
        return 48 <= c && c <= 57;
    }
    
    static boolean isJSSpace(final int c) {
        if (c <= 127) {
            return c == 32 || c == 9 || c == 12 || c == 11;
        }
        return c == 160 || c == 65279 || Character.getType((char)c) == 12;
    }
    
    private static boolean isJSFormatChar(final int c) {
        return c > 127 && Character.getType((char)c) == 16;
    }
    
    void readRegExp(final int startToken) throws IOException {
        final int start = this.tokenBeg;
        this.stringBufferTop = 0;
        if (startToken == 97) {
            this.addToString(61);
        }
        else if (startToken != 24) {
            Kit.codeBug();
        }
        boolean inCharSet = false;
        int c;
        while ((c = this.getChar()) != 47 || inCharSet) {
            if (c == 10 || c == -1) {
                this.ungetChar(c);
                this.tokenEnd = this.cursor - 1;
                this.string = new String(this.stringBuffer, 0, this.stringBufferTop);
                this.parser.reportError("msg.unterminated.re.lit");
                return;
            }
            if (c == 92) {
                this.addToString(c);
                c = this.getChar();
            }
            else if (c == 91) {
                inCharSet = true;
            }
            else if (c == 93) {
                inCharSet = false;
            }
            this.addToString(c);
        }
        final int reEnd = this.stringBufferTop;
        while (true) {
            if (this.matchChar(103)) {
                this.addToString(103);
            }
            else if (this.matchChar(105)) {
                this.addToString(105);
            }
            else if (this.matchChar(109)) {
                this.addToString(109);
            }
            else if (this.matchChar(121)) {
                this.addToString(121);
            }
            else {
                if (!this.matchChar(115)) {
                    break;
                }
                this.addToString(115);
            }
        }
        this.tokenEnd = start + this.stringBufferTop + 2;
        if (isAlpha(this.peekChar())) {
            this.parser.reportError("msg.invalid.re.flag");
        }
        this.string = new String(this.stringBuffer, 0, reEnd);
        this.regExpFlags = new String(this.stringBuffer, reEnd, this.stringBufferTop - reEnd);
    }
    
    String readAndClearRegExpFlags() {
        final String flags = this.regExpFlags;
        this.regExpFlags = null;
        return flags;
    }
    
    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }
    
    private void addToString(final int c) {
        final int N = this.stringBufferTop;
        if (N == this.stringBuffer.length) {
            final char[] tmp = new char[this.stringBuffer.length * 2];
            System.arraycopy(this.stringBuffer, 0, tmp, 0, N);
            this.stringBuffer = tmp;
        }
        this.stringBuffer[N] = (char)c;
        this.stringBufferTop = N + 1;
    }
    
    private boolean canUngetChar() {
        return this.ungetCursor == 0 || this.ungetBuffer[this.ungetCursor - 1] != 10;
    }
    
    private void ungetChar(final int c) {
        if (this.ungetCursor != 0 && this.ungetBuffer[this.ungetCursor - 1] == 10) {
            Kit.codeBug();
        }
        this.ungetBuffer[this.ungetCursor++] = c;
        --this.cursor;
    }
    
    private boolean matchChar(final int test) throws IOException {
        final int c = this.getCharIgnoreLineEnd();
        if (c == test) {
            this.tokenEnd = this.cursor;
            return true;
        }
        this.ungetCharIgnoreLineEnd(c);
        return false;
    }
    
    private int peekChar() throws IOException {
        final int c = this.getChar();
        this.ungetChar(c);
        return c;
    }
    
    private int getChar() throws IOException {
        return this.getChar(true);
    }
    
    private int getChar(final boolean skipFormattingChars) throws IOException {
        if (this.ungetCursor != 0) {
            ++this.cursor;
            final int[] ungetBuffer = this.ungetBuffer;
            final int ungetCursor = this.ungetCursor - 1;
            this.ungetCursor = ungetCursor;
            return ungetBuffer[ungetCursor];
        }
        int c;
        while (true) {
            if (this.sourceString != null) {
                if (this.sourceCursor == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                ++this.cursor;
                c = this.sourceString.charAt(this.sourceCursor++);
            }
            else {
                if (this.sourceCursor == this.sourceEnd && !this.fillSourceBuffer()) {
                    this.hitEOF = true;
                    return -1;
                }
                ++this.cursor;
                c = this.sourceBuffer[this.sourceCursor++];
            }
            if (this.lineEndChar >= 0) {
                if (this.lineEndChar == 13 && c == 10) {
                    this.lineEndChar = 10;
                    continue;
                }
                this.lineEndChar = -1;
                this.lineStart = this.sourceCursor - 1;
                ++this.lineno;
            }
            if (c <= 127) {
                if (c == 10 || c == 13) {
                    this.lineEndChar = c;
                    c = 10;
                    break;
                }
                break;
            }
            else {
                if (c == 65279) {
                    return c;
                }
                if (skipFormattingChars && isJSFormatChar(c)) {
                    continue;
                }
                if (ScriptRuntime.isJSLineTerminator(c)) {
                    this.lineEndChar = c;
                    c = 10;
                    break;
                }
                break;
            }
        }
        return c;
    }
    
    private int getCharIgnoreLineEnd() throws IOException {
        if (this.ungetCursor != 0) {
            ++this.cursor;
            final int[] ungetBuffer = this.ungetBuffer;
            final int ungetCursor = this.ungetCursor - 1;
            this.ungetCursor = ungetCursor;
            return ungetBuffer[ungetCursor];
        }
        int c;
        while (true) {
            if (this.sourceString != null) {
                if (this.sourceCursor == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                ++this.cursor;
                c = this.sourceString.charAt(this.sourceCursor++);
            }
            else {
                if (this.sourceCursor == this.sourceEnd && !this.fillSourceBuffer()) {
                    this.hitEOF = true;
                    return -1;
                }
                ++this.cursor;
                c = this.sourceBuffer[this.sourceCursor++];
            }
            if (c <= 127) {
                if (c == 10 || c == 13) {
                    this.lineEndChar = c;
                    c = 10;
                    break;
                }
                break;
            }
            else {
                if (c == 65279) {
                    return c;
                }
                if (isJSFormatChar(c)) {
                    continue;
                }
                if (ScriptRuntime.isJSLineTerminator(c)) {
                    this.lineEndChar = c;
                    c = 10;
                    break;
                }
                break;
            }
        }
        return c;
    }
    
    private void ungetCharIgnoreLineEnd(final int c) {
        this.ungetBuffer[this.ungetCursor++] = c;
        --this.cursor;
    }
    
    private void skipLine() throws IOException {
        int c;
        while ((c = this.getChar()) != -1 && c != 10) {}
        this.ungetChar(c);
        this.tokenEnd = this.cursor;
    }
    
    final int getOffset() {
        int n = this.sourceCursor - this.lineStart;
        if (this.lineEndChar >= 0) {
            --n;
        }
        return n;
    }
    
    private final int charAt(int index) {
        if (index < 0) {
            return -1;
        }
        if (this.sourceString == null) {
            if (index >= this.sourceEnd) {
                final int oldSourceCursor = this.sourceCursor;
                try {
                    if (!this.fillSourceBuffer()) {
                        return -1;
                    }
                }
                catch (IOException ioe) {
                    return -1;
                }
                index -= oldSourceCursor - this.sourceCursor;
            }
            return this.sourceBuffer[index];
        }
        if (index >= this.sourceEnd) {
            return -1;
        }
        return this.sourceString.charAt(index);
    }
    
    private final String substring(final int beginIndex, final int endIndex) {
        if (this.sourceString != null) {
            return this.sourceString.substring(beginIndex, endIndex);
        }
        final int count = endIndex - beginIndex;
        return new String(this.sourceBuffer, beginIndex, count);
    }
    
    final String getLine() {
        int lineEnd = this.sourceCursor;
        if (this.lineEndChar >= 0) {
            --lineEnd;
            if (this.lineEndChar == 10 && this.charAt(lineEnd - 1) == 13) {
                --lineEnd;
            }
        }
        else {
            int lineLength = lineEnd - this.lineStart;
            while (true) {
                final int c = this.charAt(this.lineStart + lineLength);
                if (c == -1 || ScriptRuntime.isJSLineTerminator(c)) {
                    break;
                }
                ++lineLength;
            }
            lineEnd = this.lineStart + lineLength;
        }
        return this.substring(this.lineStart, lineEnd);
    }
    
    final String getLine(final int position, final int[] linep) {
        assert position >= 0 && position <= this.cursor;
        assert linep.length == 2;
        int delta = this.cursor + this.ungetCursor - position;
        int cur = this.sourceCursor;
        if (delta > cur) {
            return null;
        }
        int end = 0;
        int lines = 0;
        while (delta > 0) {
            assert cur > 0;
            final int c = this.charAt(cur - 1);
            if (ScriptRuntime.isJSLineTerminator(c)) {
                if (c == 10 && this.charAt(cur - 2) == 13) {
                    --delta;
                    --cur;
                }
                ++lines;
                end = cur - 1;
            }
            --delta;
            --cur;
        }
        int start = 0;
        int offset;
        for (offset = 0; cur > 0; --cur, ++offset) {
            final int c2 = this.charAt(cur - 1);
            if (ScriptRuntime.isJSLineTerminator(c2)) {
                start = cur;
                break;
            }
        }
        linep[0] = this.lineno - lines + ((this.lineEndChar >= 0) ? 1 : 0);
        linep[1] = offset;
        if (lines == 0) {
            return this.getLine();
        }
        return this.substring(start, end);
    }
    
    private boolean fillSourceBuffer() throws IOException {
        if (this.sourceString != null) {
            Kit.codeBug();
        }
        if (this.sourceEnd == this.sourceBuffer.length) {
            if (this.lineStart != 0 && !this.isMarkingComment()) {
                System.arraycopy(this.sourceBuffer, this.lineStart, this.sourceBuffer, 0, this.sourceEnd - this.lineStart);
                this.sourceEnd -= this.lineStart;
                this.sourceCursor -= this.lineStart;
                this.lineStart = 0;
            }
            else {
                final char[] tmp = new char[this.sourceBuffer.length * 2];
                System.arraycopy(this.sourceBuffer, 0, tmp, 0, this.sourceEnd);
                this.sourceBuffer = tmp;
            }
        }
        final int n = this.sourceReader.read(this.sourceBuffer, this.sourceEnd, this.sourceBuffer.length - this.sourceEnd);
        if (n < 0) {
            return false;
        }
        this.sourceEnd += n;
        return true;
    }
    
    public void setTemplateExprFinished() {
        this.inTemplateExpr = false;
    }
    
    public int getCursor() {
        return this.cursor;
    }
    
    public int getTokenBeg() {
        return this.tokenBeg;
    }
    
    public int getTokenEnd() {
        return this.tokenEnd;
    }
    
    public int getTokenLength() {
        return this.tokenEnd - this.tokenBeg;
    }
    
    public Token.CommentType getCommentType() {
        return this.commentType;
    }
    
    private void markCommentStart() {
        this.markCommentStart("");
    }
    
    private void markCommentStart(final String prefix) {
        if (this.parser.compilerEnv.isRecordingComments() && this.sourceReader != null) {
            this.commentPrefix = prefix;
            this.commentCursor = this.sourceCursor - 1;
        }
    }
    
    private boolean isMarkingComment() {
        return this.commentCursor != -1;
    }
    
    final String getAndResetCurrentComment() {
        if (this.sourceString != null) {
            if (this.isMarkingComment()) {
                Kit.codeBug();
            }
            return this.sourceString.substring(this.tokenBeg, this.tokenEnd);
        }
        if (!this.isMarkingComment()) {
            Kit.codeBug();
        }
        final StringBuilder comment = new StringBuilder(this.commentPrefix);
        comment.append(this.sourceBuffer, this.commentCursor, this.getTokenLength() - this.commentPrefix.length());
        this.commentCursor = -1;
        return comment.toString();
    }
    
    private String convertLastCharToHex(final String str) {
        final int lastIndex = str.length() - 1;
        final StringBuilder buf = new StringBuilder(str.substring(0, lastIndex));
        buf.append("\\u");
        final String hexCode = Integer.toHexString(str.charAt(lastIndex));
        for (int i = 0; i < 4 - hexCode.length(); ++i) {
            buf.append('0');
        }
        buf.append(hexCode);
        return buf.toString();
    }
    
    public String[] getRawLiterals() {
        return this.rawLiterals.toArray(new String[0]);
    }
    
    public TokenPosition getPosition() {
        return new TokenPosition(this.getTokenBeg(), this.getOffset(), this.getLine(), this.getLineno(), this.getTokenLength());
    }
    
    static class TokenPosition
    {
        int start;
        int lineno;
        String line;
        int colno;
        int length;
        
        public TokenPosition(final int start, final int colno, final String line, final int lineno, final int length) {
            this.start = start;
            this.colno = colno;
            this.line = line;
            this.lineno = lineno;
            this.length = length;
        }
    }
}
