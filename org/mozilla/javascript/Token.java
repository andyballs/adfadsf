//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class Token
{
    public static final boolean printTrees = false;
    static final boolean printICode = false;
    static final boolean printNames = false;
    public static final int ERROR = -1;
    public static final int EOF = 0;
    public static final int EOL = 1;
    public static final int FIRST_BYTECODE_TOKEN = 2;
    public static final int ENTERWITH = 2;
    public static final int LEAVEWITH = 3;
    public static final int RETURN = 4;
    public static final int GOTO = 5;
    public static final int IFEQ = 6;
    public static final int IFNE = 7;
    public static final int SETNAME = 8;
    public static final int BITOR = 9;
    public static final int BITXOR = 10;
    public static final int BITAND = 11;
    public static final int EQ = 12;
    public static final int NE = 13;
    public static final int LT = 14;
    public static final int LE = 15;
    public static final int GT = 16;
    public static final int GE = 17;
    public static final int LSH = 18;
    public static final int RSH = 19;
    public static final int URSH = 20;
    public static final int ADD = 21;
    public static final int SUB = 22;
    public static final int MUL = 23;
    public static final int DIV = 24;
    public static final int MOD = 25;
    public static final int EXP = 26;
    public static final int NOT = 27;
    public static final int BITNOT = 28;
    public static final int POS = 29;
    public static final int NEG = 30;
    public static final int NEW = 31;
    public static final int DELPROP = 32;
    public static final int TYPEOF = 33;
    public static final int GETPROP = 34;
    public static final int GETPROPNOWARN = 35;
    public static final int SETPROP = 36;
    public static final int GETELEM = 37;
    public static final int SETELEM = 38;
    public static final int CALL = 39;
    public static final int NAME = 40;
    public static final int NUMBER = 41;
    public static final int STRING = 42;
    public static final int TEMPLATE = 43;
    public static final int TEMPLATE_EXPR = 44;
    public static final int NULL = 45;
    public static final int THIS = 46;
    public static final int FALSE = 47;
    public static final int TRUE = 48;
    public static final int SHEQ = 49;
    public static final int SHNE = 50;
    public static final int REGEXP = 51;
    public static final int BINDNAME = 52;
    public static final int THROW = 53;
    public static final int RETHROW = 54;
    public static final int IN = 55;
    public static final int INSTANCEOF = 56;
    public static final int LOCAL_LOAD = 57;
    public static final int GETVAR = 58;
    public static final int SETVAR = 59;
    public static final int CATCH_SCOPE = 60;
    public static final int ENUM_INIT_KEYS = 61;
    public static final int ENUM_INIT_VALUES = 62;
    public static final int ENUM_INIT_ARRAY = 63;
    public static final int ENUM_INIT_VALUES_IN_ORDER = 64;
    public static final int ENUM_NEXT = 65;
    public static final int ENUM_ID = 66;
    public static final int THISFN = 67;
    public static final int RETURN_RESULT = 68;
    public static final int ARRAYLIT = 69;
    public static final int OBJECTLIT = 70;
    public static final int GET_REF = 71;
    public static final int SET_REF = 72;
    public static final int DEL_REF = 73;
    public static final int REF_CALL = 74;
    public static final int REF_SPECIAL = 75;
    public static final int YIELD = 76;
    public static final int STRICT_SETNAME = 77;
    public static final int LAST_BYTECODE_TOKEN = 77;
    public static final int TRY = 78;
    public static final int SEMI = 79;
    public static final int LB = 80;
    public static final int RB = 81;
    public static final int LC = 82;
    public static final int RC = 83;
    public static final int LP = 84;
    public static final int RP = 85;
    public static final int COMMA = 86;
    public static final int ASSIGN = 87;
    public static final int ASSIGN_BITOR = 88;
    public static final int ASSIGN_BITXOR = 89;
    public static final int ASSIGN_BITAND = 90;
    public static final int ASSIGN_LSH = 91;
    public static final int ASSIGN_RSH = 92;
    public static final int ASSIGN_URSH = 93;
    public static final int ASSIGN_ADD = 94;
    public static final int ASSIGN_SUB = 95;
    public static final int ASSIGN_MUL = 96;
    public static final int ASSIGN_DIV = 97;
    public static final int ASSIGN_MOD = 98;
    public static final int ASSIGN_EXP = 99;
    public static final int ASSIGN_OR = 100;
    public static final int ASSIGN_AND = 101;
    public static final int ASSIGN_NULLISH = 102;
    public static final int FIRST_ASSIGN = 87;
    public static final int LAST_ASSIGN = 102;
    public static final int HOOK = 103;
    public static final int COLON = 104;
    public static final int OR = 105;
    public static final int AND = 106;
    public static final int INC = 107;
    public static final int DEC = 108;
    public static final int DOT = 109;
    public static final int SPREAD = 110;
    public static final int OPTIONAL_CHAINING = 111;
    public static final int PIPELINE = 112;
    public static final int NULLISH_COALESCING = 113;
    public static final int FUNCTION = 114;
    public static final int CLASS = 115;
    public static final int EXTENDS = 116;
    public static final int STATIC = 117;
    public static final int SUPER = 118;
    public static final int EXPORT = 119;
    public static final int IMPORT = 120;
    public static final int IF = 121;
    public static final int ELSE = 122;
    public static final int SWITCH = 123;
    public static final int CASE = 124;
    public static final int DEFAULT = 125;
    public static final int WHILE = 126;
    public static final int DO = 127;
    public static final int FOR = 128;
    public static final int BREAK = 129;
    public static final int CONTINUE = 130;
    public static final int VAR = 131;
    public static final int WITH = 132;
    public static final int CATCH = 133;
    public static final int FINALLY = 134;
    public static final int DECORATOR = 135;
    public static final int VOID = 136;
    public static final int RESERVED = 137;
    public static final int EMPTY = 138;
    public static final int BLOCK = 139;
    public static final int LABEL = 140;
    public static final int TARGET = 141;
    public static final int LOOP = 142;
    public static final int EXPR_VOID = 143;
    public static final int EXPR_RESULT = 144;
    public static final int JSR = 145;
    public static final int SCRIPT = 146;
    public static final int TYPEOFNAME = 147;
    public static final int USE_STACK = 148;
    public static final int SETPROP_OP = 149;
    public static final int SETELEM_OP = 150;
    public static final int LOCAL_BLOCK = 151;
    public static final int SET_REF_OP = 152;
    public static final int AT = 153;
    public static final int TO_OBJECT = 154;
    public static final int TO_DOUBLE = 155;
    public static final int GET = 156;
    public static final int SET = 157;
    public static final int LET = 158;
    public static final int CONST = 159;
    public static final int SETCONST = 160;
    public static final int SETCONSTVAR = 161;
    public static final int ARRAYCOMP = 162;
    public static final int LETEXPR = 163;
    public static final int WITHEXPR = 164;
    public static final int DEBUGGER = 165;
    public static final int COMMENT = 166;
    public static final int GENEXPR = 167;
    public static final int METHOD = 168;
    public static final int ARROW = 169;
    public static final int HASHTAG = 170;
    public static final int LAST_TOKEN = 170;
    
    public static String name(final int token) {
        if (!Context.getContext().hasFeature(19)) {
            return String.valueOf(token);
        }
        return typeToName(token);
    }
    
    public static String typeToName(final int token) {
        switch (token) {
            case -1: {
                return "ERROR";
            }
            case 0: {
                return "EOF";
            }
            case 1: {
                return "EOL";
            }
            case 2: {
                return "ENTERWITH";
            }
            case 3: {
                return "LEAVEWITH";
            }
            case 4: {
                return "RETURN";
            }
            case 5: {
                return "GOTO";
            }
            case 6: {
                return "IFEQ";
            }
            case 7: {
                return "IFNE";
            }
            case 8: {
                return "SETNAME";
            }
            case 9: {
                return "BITOR";
            }
            case 10: {
                return "BITXOR";
            }
            case 11: {
                return "BITAND";
            }
            case 12: {
                return "EQ";
            }
            case 13: {
                return "NE";
            }
            case 14: {
                return "LT";
            }
            case 15: {
                return "LE";
            }
            case 16: {
                return "GT";
            }
            case 17: {
                return "GE";
            }
            case 18: {
                return "LSH";
            }
            case 19: {
                return "RSH";
            }
            case 20: {
                return "URSH";
            }
            case 21: {
                return "ADD";
            }
            case 22: {
                return "SUB";
            }
            case 23: {
                return "MUL";
            }
            case 24: {
                return "DIV";
            }
            case 25: {
                return "MOD";
            }
            case 26: {
                return "EXP";
            }
            case 27: {
                return "NOT";
            }
            case 28: {
                return "BITNOT";
            }
            case 29: {
                return "POS";
            }
            case 30: {
                return "NEG";
            }
            case 31: {
                return "NEW";
            }
            case 32: {
                return "DELPROP";
            }
            case 33: {
                return "TYPEOF";
            }
            case 34: {
                return "GETPROP";
            }
            case 35: {
                return "GETPROPNOWARN";
            }
            case 36: {
                return "SETPROP";
            }
            case 37: {
                return "GETELEM";
            }
            case 38: {
                return "SETELEM";
            }
            case 39: {
                return "CALL";
            }
            case 40: {
                return "NAME";
            }
            case 41: {
                return "NUMBER";
            }
            case 42: {
                return "STRING";
            }
            case 43: {
                return "TEMPLATE";
            }
            case 44: {
                return "TEMPLATE_EXPR";
            }
            case 45: {
                return "NULL";
            }
            case 46: {
                return "THIS";
            }
            case 47: {
                return "FALSE";
            }
            case 48: {
                return "TRUE";
            }
            case 49: {
                return "SHEQ";
            }
            case 50: {
                return "SHNE";
            }
            case 51: {
                return "REGEXP";
            }
            case 52: {
                return "BINDNAME";
            }
            case 53: {
                return "THROW";
            }
            case 54: {
                return "RETHROW";
            }
            case 55: {
                return "IN";
            }
            case 56: {
                return "INSTANCEOF";
            }
            case 57: {
                return "LOCAL_LOAD";
            }
            case 58: {
                return "GETVAR";
            }
            case 59: {
                return "SETVAR";
            }
            case 60: {
                return "CATCH_SCOPE";
            }
            case 61: {
                return "ENUM_INIT_KEYS";
            }
            case 62: {
                return "ENUM_INIT_VALUES";
            }
            case 63: {
                return "ENUM_INIT_ARRAY";
            }
            case 64: {
                return "ENUM_INIT_VALUES_IN_ORDER";
            }
            case 65: {
                return "ENUM_NEXT";
            }
            case 66: {
                return "ENUM_ID";
            }
            case 67: {
                return "THISFN";
            }
            case 68: {
                return "RETURN_RESULT";
            }
            case 69: {
                return "ARRAYLIT";
            }
            case 70: {
                return "OBJECTLIT";
            }
            case 71: {
                return "GET_REF";
            }
            case 72: {
                return "SET_REF";
            }
            case 73: {
                return "DEL_REF";
            }
            case 74: {
                return "REF_CALL";
            }
            case 75: {
                return "REF_SPECIAL";
            }
            case 76: {
                return "YIELD";
            }
            case 77: {
                return "STRICT_SETNAME";
            }
            case 78: {
                return "TRY";
            }
            case 79: {
                return "SEMI";
            }
            case 80: {
                return "LB";
            }
            case 81: {
                return "RB";
            }
            case 82: {
                return "LC";
            }
            case 83: {
                return "RC";
            }
            case 84: {
                return "LP";
            }
            case 85: {
                return "RP";
            }
            case 86: {
                return "COMMA";
            }
            case 87: {
                return "ASSIGN";
            }
            case 88: {
                return "ASSIGN_BITOR";
            }
            case 89: {
                return "ASSIGN_BITXOR";
            }
            case 90: {
                return "ASSIGN_BITAND";
            }
            case 91: {
                return "ASSIGN_LSH";
            }
            case 92: {
                return "ASSIGN_RSH";
            }
            case 93: {
                return "ASSIGN_URSH";
            }
            case 94: {
                return "ASSIGN_ADD";
            }
            case 95: {
                return "ASSIGN_SUB";
            }
            case 96: {
                return "ASSIGN_MUL";
            }
            case 99: {
                return "ASSIGN_EXP";
            }
            case 97: {
                return "ASSIGN_DIV";
            }
            case 98: {
                return "ASSIGN_MOD";
            }
            case 101: {
                return "ASSIGN_AND";
            }
            case 100: {
                return "ASSIGN_OR";
            }
            case 102: {
                return "ASSIGN_NULLISH";
            }
            case 103: {
                return "HOOK";
            }
            case 104: {
                return "COLON";
            }
            case 105: {
                return "OR";
            }
            case 106: {
                return "AND";
            }
            case 107: {
                return "INC";
            }
            case 108: {
                return "DEC";
            }
            case 109: {
                return "DOT";
            }
            case 110: {
                return "SPREAD";
            }
            case 111: {
                return "OPTIONAL CHAINING";
            }
            case 112: {
                return "PIPELINE";
            }
            case 113: {
                return "NULLISH_COALESCING";
            }
            case 114: {
                return "FUNCTION";
            }
            case 115: {
                return "CLASS";
            }
            case 116: {
                return "EXTENDS";
            }
            case 117: {
                return "STATIC";
            }
            case 118: {
                return "SUPER";
            }
            case 119: {
                return "EXPORT";
            }
            case 120: {
                return "IMPORT";
            }
            case 121: {
                return "IF";
            }
            case 122: {
                return "ELSE";
            }
            case 123: {
                return "SWITCH";
            }
            case 124: {
                return "CASE";
            }
            case 125: {
                return "DEFAULT";
            }
            case 126: {
                return "WHILE";
            }
            case 127: {
                return "DO";
            }
            case 128: {
                return "FOR";
            }
            case 129: {
                return "BREAK";
            }
            case 130: {
                return "CONTINUE";
            }
            case 131: {
                return "VAR";
            }
            case 132: {
                return "WITH";
            }
            case 133: {
                return "CATCH";
            }
            case 134: {
                return "FINALLY";
            }
            case 135: {
                return "DECORATOR";
            }
            case 136: {
                return "VOID";
            }
            case 137: {
                return "RESERVED";
            }
            case 138: {
                return "EMPTY";
            }
            case 139: {
                return "BLOCK";
            }
            case 140: {
                return "LABEL";
            }
            case 141: {
                return "TARGET";
            }
            case 142: {
                return "LOOP";
            }
            case 143: {
                return "EXPR_VOID";
            }
            case 144: {
                return "EXPR_RESULT";
            }
            case 145: {
                return "JSR";
            }
            case 146: {
                return "SCRIPT";
            }
            case 147: {
                return "TYPEOFNAME";
            }
            case 148: {
                return "USE_STACK";
            }
            case 149: {
                return "SETPROP_OP";
            }
            case 150: {
                return "SETELEM_OP";
            }
            case 151: {
                return "LOCAL_BLOCK";
            }
            case 152: {
                return "SET_REF_OP";
            }
            case 153: {
                return "AT";
            }
            case 154: {
                return "TO_OBJECT";
            }
            case 155: {
                return "TO_DOUBLE";
            }
            case 156: {
                return "GET";
            }
            case 157: {
                return "SET";
            }
            case 158: {
                return "LET";
            }
            case 159: {
                return "CONST";
            }
            case 160: {
                return "SETCONST";
            }
            case 161: {
                return "SETCONSTVAR";
            }
            case 162: {
                return "ARRAYCOMP";
            }
            case 163: {
                return "LETEXPR";
            }
            case 164: {
                return "WITHEXPR";
            }
            case 165: {
                return "DEBUGGER";
            }
            case 166: {
                return "COMMENT";
            }
            case 167: {
                return "GENEXPR";
            }
            case 168: {
                return "METHOD";
            }
            case 169: {
                return "ARROW";
            }
            case 170: {
                return "HASHTAG";
            }
            default: {
                throw new IllegalStateException(String.valueOf(token));
            }
        }
    }
    
    public static String keywordToName(final int token) {
        switch (token) {
            case 129: {
                return "break";
            }
            case 124: {
                return "case";
            }
            case 130: {
                return "continue";
            }
            case 125: {
                return "default";
            }
            case 32: {
                return "delete";
            }
            case 127: {
                return "do";
            }
            case 122: {
                return "else";
            }
            case 47: {
                return "false";
            }
            case 128: {
                return "for";
            }
            case 114: {
                return "function";
            }
            case 121: {
                return "if";
            }
            case 55: {
                return "in";
            }
            case 158: {
                return "let";
            }
            case 31: {
                return "new";
            }
            case 45: {
                return "null";
            }
            case 4: {
                return "return";
            }
            case 123: {
                return "switch";
            }
            case 46: {
                return "this";
            }
            case 48: {
                return "true";
            }
            case 33: {
                return "typeof";
            }
            case 131: {
                return "var";
            }
            case 136: {
                return "void";
            }
            case 126: {
                return "while";
            }
            case 132: {
                return "with";
            }
            case 76: {
                return "yield";
            }
            case 133: {
                return "catch";
            }
            case 159: {
                return "const";
            }
            case 165: {
                return "debugger";
            }
            case 134: {
                return "finally";
            }
            case 56: {
                return "instanceof";
            }
            case 53: {
                return "throw";
            }
            case 78: {
                return "try";
            }
            case 115: {
                return "class";
            }
            case 117: {
                return "static";
            }
            case 118: {
                return "super";
            }
            case 116: {
                return "extends";
            }
            case 135: {
                return "decorator";
            }
            default: {
                return null;
            }
        }
    }
    
    public static boolean isValidToken(final int code) {
        return code >= -1 && code <= 170;
    }
    
    public enum CommentType
    {
        LINE, 
        BLOCK_COMMENT, 
        JSDOC, 
        HTML;
    }
}
