//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

import org.mozilla.javascript.*;

class NativeRegExpCtor extends BaseFunction
{
    private static final long serialVersionUID = -5733330028285400526L;
    private static final int Id_multiline = 1;
    private static final int Id_STAR = 2;
    private static final int Id_input = 3;
    private static final int Id_UNDERSCORE = 4;
    private static final int Id_lastMatch = 5;
    private static final int Id_AMPERSAND = 6;
    private static final int Id_lastParen = 7;
    private static final int Id_PLUS = 8;
    private static final int Id_leftContext = 9;
    private static final int Id_BACK_QUOTE = 10;
    private static final int Id_rightContext = 11;
    private static final int Id_QUOTE = 12;
    private static final int DOLLAR_ID_BASE = 12;
    private static final int Id_DOLLAR_1 = 13;
    private static final int Id_DOLLAR_2 = 14;
    private static final int Id_DOLLAR_3 = 15;
    private static final int Id_DOLLAR_4 = 16;
    private static final int Id_DOLLAR_5 = 17;
    private static final int Id_DOLLAR_6 = 18;
    private static final int Id_DOLLAR_7 = 19;
    private static final int Id_DOLLAR_8 = 20;
    private static final int Id_DOLLAR_9 = 21;
    private static final int MAX_INSTANCE_ID = 21;
    private int multilineAttr;
    private int starAttr;
    private int inputAttr;
    private int underscoreAttr;
    
    NativeRegExpCtor() {
        this.multilineAttr = 4;
        this.starAttr = 4;
        this.inputAttr = 4;
        this.underscoreAttr = 4;
    }
    
    public String getFunctionName() {
        return "RegExp";
    }
    
    public int getLength() {
        return 2;
    }
    
    public int getArity() {
        return 2;
    }
    
    public Object call(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        if (args.length > 0 && args[0] instanceof NativeRegExp && (args.length == 1 || args[1] == Undefined.instance)) {
            return args[0];
        }
        return this.construct(cx, scope, args);
    }
    
    public Scriptable construct(final Context cx, final Scriptable scope, final Object[] args) {
        final NativeRegExp re = new NativeRegExp();
        re.isInstance = true;
        re.compile(cx, scope, args);
        ScriptRuntime.setBuiltinProtoAndParent((ScriptableObject)re, scope, TopLevel.Builtins.RegExp);
        return (Scriptable)re;
    }
    
    private static RegExpImpl getImpl() {
        final Context cx = Context.getCurrentContext();
        return (RegExpImpl)ScriptRuntime.getRegExpProxy(cx);
    }
    
    protected int getMaxInstanceId() {
        return super.getMaxInstanceId() + 21;
    }
    
    protected int findInstanceIdInfo(final String s) {
        int id = 0;
        String X = null;
        Label_0663: {
            Label_0644: {
                switch (s.length()) {
                    case 2: {
                        switch (s.charAt(1)) {
                            case '&': {
                                if (s.charAt(0) == '$') {
                                    id = 6;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '\'': {
                                if (s.charAt(0) == '$') {
                                    id = 12;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '*': {
                                if (s.charAt(0) == '$') {
                                    id = 2;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '+': {
                                if (s.charAt(0) == '$') {
                                    id = 8;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '1': {
                                if (s.charAt(0) == '$') {
                                    id = 13;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '2': {
                                if (s.charAt(0) == '$') {
                                    id = 14;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '3': {
                                if (s.charAt(0) == '$') {
                                    id = 15;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '4': {
                                if (s.charAt(0) == '$') {
                                    id = 16;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '5': {
                                if (s.charAt(0) == '$') {
                                    id = 17;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '6': {
                                if (s.charAt(0) == '$') {
                                    id = 18;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '7': {
                                if (s.charAt(0) == '$') {
                                    id = 19;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '8': {
                                if (s.charAt(0) == '$') {
                                    id = 20;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '9': {
                                if (s.charAt(0) == '$') {
                                    id = 21;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '_': {
                                if (s.charAt(0) == '$') {
                                    id = 4;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            case '`': {
                                if (s.charAt(0) == '$') {
                                    id = 10;
                                    break Label_0663;
                                }
                                break Label_0644;
                            }
                            default: {
                                break Label_0644;
                            }
                        }
                        break;
                    }
                    case 5: {
                        X = "input";
                        id = 3;
                        break;
                    }
                    case 9: {
                        final int c = s.charAt(4);
                        if (c == 77) {
                            X = "lastMatch";
                            id = 5;
                            break;
                        }
                        if (c == 80) {
                            X = "lastParen";
                            id = 7;
                            break;
                        }
                        if (c == 105) {
                            X = "multiline";
                            id = 1;
                            break;
                        }
                        break;
                    }
                    case 11: {
                        X = "leftContext";
                        id = 9;
                        break;
                    }
                    case 12: {
                        X = "rightContext";
                        id = 11;
                        break;
                    }
                }
            }
            if (X != null && X != s && !X.equals(s)) {
                id = 0;
            }
        }
        if (id == 0) {
            return super.findInstanceIdInfo(s);
        }
        int attr = 0;
        switch (id) {
            case 1: {
                attr = this.multilineAttr;
                break;
            }
            case 2: {
                attr = this.starAttr;
                break;
            }
            case 3: {
                attr = this.inputAttr;
                break;
            }
            case 4: {
                attr = this.underscoreAttr;
                break;
            }
            default: {
                attr = 5;
                break;
            }
        }
        return instanceIdInfo(attr, super.getMaxInstanceId() + id);
    }
    
    protected String getInstanceIdName(final int id) {
        final int shifted = id - super.getMaxInstanceId();
        if (1 > shifted || shifted > 21) {
            return super.getInstanceIdName(id);
        }
        switch (shifted) {
            case 1: {
                return "multiline";
            }
            case 2: {
                return "$*";
            }
            case 3: {
                return "input";
            }
            case 4: {
                return "$_";
            }
            case 5: {
                return "lastMatch";
            }
            case 6: {
                return "$&";
            }
            case 7: {
                return "lastParen";
            }
            case 8: {
                return "$+";
            }
            case 9: {
                return "leftContext";
            }
            case 10: {
                return "$`";
            }
            case 11: {
                return "rightContext";
            }
            case 12: {
                return "$'";
            }
            default: {
                final int substring_number = shifted - 12 - 1;
                final char[] buf = { '$', (char)(49 + substring_number) };
                return new String(buf);
            }
        }
    }
    
    protected Object getInstanceIdValue(final int id) {
        final int shifted = id - super.getMaxInstanceId();
        if (1 <= shifted && shifted <= 21) {
            final RegExpImpl impl = getImpl();
            Object stringResult = null;
            switch (shifted) {
                case 1:
                case 2: {
                    return ScriptRuntime.wrapBoolean(impl.multiline);
                }
                case 3:
                case 4: {
                    stringResult = impl.input;
                    break;
                }
                case 5:
                case 6: {
                    stringResult = impl.lastMatch;
                    break;
                }
                case 7:
                case 8: {
                    stringResult = impl.lastParen;
                    break;
                }
                case 9:
                case 10: {
                    stringResult = impl.leftContext;
                    break;
                }
                case 11:
                case 12: {
                    stringResult = impl.rightContext;
                    break;
                }
                default: {
                    final int substring_number = shifted - 12 - 1;
                    stringResult = impl.getParenSubString(substring_number);
                    break;
                }
            }
            return (stringResult == null) ? "" : stringResult.toString();
        }
        return super.getInstanceIdValue(id);
    }
    
    protected void setInstanceIdValue(final int id, final Object value) {
        final int shifted = id - super.getMaxInstanceId();
        switch (shifted) {
            case 1:
            case 2: {
                getImpl().multiline = ScriptRuntime.toBoolean(value);
            }
            case 3:
            case 4: {
                getImpl().input = ScriptRuntime.toString(value);
            }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12: {}
            default: {
                final int substring_number = shifted - 12 - 1;
                if (0 <= substring_number && substring_number <= 8) {
                    return;
                }
                super.setInstanceIdValue(id, value);
            }
        }
    }
    
    protected void setInstanceIdAttributes(final int id, final int attr) {
        final int shifted = id - super.getMaxInstanceId();
        switch (shifted) {
            case 1: {
                this.multilineAttr = attr;
            }
            case 2: {
                this.starAttr = attr;
            }
            case 3: {
                this.inputAttr = attr;
            }
            case 4: {
                this.underscoreAttr = attr;
            }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12: {}
            default: {
                final int substring_number = shifted - 12 - 1;
                if (0 <= substring_number && substring_number <= 8) {
                    return;
                }
                super.setInstanceIdAttributes(id, attr);
            }
        }
    }
}
