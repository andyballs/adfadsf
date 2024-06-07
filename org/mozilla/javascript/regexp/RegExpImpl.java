//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.regexp;

import org.mozilla.javascript.*;

public class RegExpImpl implements RegExpProxy
{
    protected String input;
    protected boolean multiline;
    protected SubString[] parens;
    protected SubString lastMatch;
    protected SubString lastParen;
    protected SubString leftContext;
    protected SubString rightContext;
    protected SubString prevContext;
    
    @Override
    public boolean isRegExp(final Scriptable obj) {
        return obj instanceof NativeRegExp;
    }
    
    @Override
    public Object compileRegExp(final Context cx, final String source, final String flags) {
        return NativeRegExp.compileRE(cx, source, flags, false);
    }
    
    @Override
    public Scriptable wrapRegExp(final Context cx, final Scriptable scope, final Object compiled) {
        final NativeRegExp re = new NativeRegExp(scope, (RECompiled)compiled);
        re.isInstance = true;
        return (Scriptable)re;
    }
    
    @Override
    public Object action(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args, final int actionType) {
        final GlobData data = new GlobData();
        data.mode = actionType;
        data.str = ScriptRuntime.toString(thisObj);
        switch (actionType) {
            case 1: {
                if (args[0] instanceof NativeObject) {
                    final NativeObject arg0 = (NativeObject)args[0];
                    if (ScriptableObject.hasProperty((Scriptable)arg0, SymbolKey.MATCH)) {
                        final Object match = ScriptableObject.getProperty((Scriptable)arg0, SymbolKey.MATCH);
                        if (match instanceof Callable) {
                            return ((Callable)match).call(cx, scope, thisObj, new Object[] { data.str });
                        }
                    }
                }
                int optarg = Integer.MAX_VALUE;
                if (cx.getLanguageVersion() < 160) {
                    optarg = 1;
                }
                final NativeRegExp re = createRegExp(cx, scope, args, optarg, false);
                final Object rval = matchOrReplace(cx, scope, thisObj, args, this, data, re);
                return (data.arrayobj == null) ? rval : data.arrayobj;
            }
            case 4: {
                if (args[0] instanceof NativeObject) {
                    final NativeObject arg0 = (NativeObject)args[0];
                    if (ScriptableObject.hasProperty((Scriptable)arg0, SymbolKey.SEARCH)) {
                        final Object search = ScriptableObject.getProperty((Scriptable)arg0, SymbolKey.SEARCH);
                        if (search instanceof Callable) {
                            return ((Callable)search).call(cx, scope, thisObj, new Object[] { data.str });
                        }
                    }
                }
                int optarg = Integer.MAX_VALUE;
                if (cx.getLanguageVersion() < 160) {
                    optarg = 1;
                }
                final NativeRegExp re = createRegExp(cx, scope, args, optarg, false);
                return matchOrReplace(cx, scope, thisObj, args, this, data, re);
            }
            case 2:
            case 3: {
                final boolean isReplaceAll = actionType == 3;
                boolean useRE = args[0] instanceof NativeRegExp;
                if (args[0] instanceof ScriptableObject) {
                    final ScriptableObject arg2 = (ScriptableObject)args[0];
                    if (isReplaceAll && arg2 instanceof NativeRegExp) {
                        final int flags = ((NativeRegExp)arg2).getFlags();
                        if ((flags & 0x1) == 0x0) {
                            throw ScriptRuntime.typeError("RegExp as first argument to replaceAll must have a global flag");
                        }
                    }
                    if (ScriptableObject.hasProperty(arg2, SymbolKey.REPLACE)) {
                        final Object replace = ScriptableObject.getProperty(arg2, SymbolKey.REPLACE);
                        if (replace instanceof Callable) {
                            return ((Callable)replace).call(cx, scope, thisObj, new Object[] { data.str });
                        }
                        if (!(replace instanceof Undefined) && replace != null) {
                            throw ScriptRuntime.typeError1("msg.object.not.callable", ScriptRuntime.toString(replace));
                        }
                        useRE = false;
                    }
                }
                if (cx.getLanguageVersion() < 160) {
                    useRE |= (args.length > 2);
                }
                NativeRegExp re2 = null;
                String search2 = null;
                if (useRE) {
                    re2 = createRegExp(cx, scope, args, 2, true);
                }
                else {
                    final Object arg3 = args[0];
                    search2 = ScriptRuntime.toString(arg3);
                }
                final Object arg4 = (args.length < 2) ? Undefined.instance : args[1];
                String repstr = null;
                Function lambda = null;
                if (arg4 instanceof Function) {
                    lambda = (Function)arg4;
                }
                else {
                    repstr = ScriptRuntime.toString(arg4);
                }
                this.lastMatch = null;
                this.lastParen = null;
                this.leftContext = null;
                this.rightContext = null;
                data.lambda = lambda;
                data.repstr = repstr;
                data.dollar = ((repstr == null) ? -1 : repstr.indexOf(36));
                data.charBuf = null;
                data.leftIndex = 0;
                data.fromIndex = 0;
                while (true) {
                    final int strLen = data.str.length();
                    Object val;
                    if (useRE) {
                        val = matchOrReplace(cx, scope, thisObj, args, this, data, re2);
                    }
                    else {
                        final String str = data.str;
                        int index = -1;
                        if (data.fromIndex <= strLen) {
                            index = str.indexOf(search2, data.fromIndex);
                        }
                        if (index >= 0) {
                            final int slen = search2.length();
                            this.lastParen = null;
                            if (this.lastMatch != null) {
                                final SubString prevContext = this.prevContext;
                                prevContext.length += index - data.fromIndex + 1;
                            }
                            else {
                                this.prevContext = new SubString(str, 0, index);
                            }
                            this.leftContext = new SubString(str, 0, index);
                            this.lastMatch = new SubString(str, index, slen);
                            this.rightContext = new SubString(str, index + slen, str.length() - index - slen);
                            val = Boolean.TRUE;
                        }
                        else {
                            val = Boolean.FALSE;
                        }
                    }
                    if (data.charBuf == null) {
                        if (data.global || !Boolean.TRUE.equals(val)) {
                            return data.str;
                        }
                        final SubString lc = this.leftContext;
                        replace_glob(data, cx, scope, this, lc.index, lc.length);
                    }
                    final SubString rc = this.rightContext;
                    data.charBuf.append(rc.str, rc.index, rc.index + rc.length);
                    if (!isReplaceAll) {
                        return data.charBuf.toString();
                    }
                    data.str = data.charBuf.toString();
                    data.charBuf = null;
                    data.fromIndex = this.leftContext.length + data.str.length() - strLen + 1;
                }
                break;
            }
            default: {
                throw Kit.codeBug();
            }
        }
    }
    
    private static NativeRegExp createRegExp(final Context cx, final Scriptable scope, final Object[] args, final int optarg, final boolean forceFlat) {
        final Scriptable topScope = ScriptableObject.getTopLevelScope(scope);
        NativeRegExp re;
        if (args.length == 0 || args[0] == Undefined.instance) {
            final RECompiled compiled = NativeRegExp.compileRE(cx, "", "", false);
            re = new NativeRegExp(topScope, compiled);
            re.isInstance = true;
        }
        else if (args[0] instanceof NativeRegExp) {
            re = (NativeRegExp)args[0];
        }
        else {
            final String src = ScriptRuntime.toString(args[0]);
            String opt;
            if (optarg < args.length) {
                args[0] = src;
                opt = ScriptRuntime.toString(args[optarg]);
            }
            else {
                opt = null;
            }
            final RECompiled compiled2 = NativeRegExp.compileRE(cx, src, opt, forceFlat);
            re = new NativeRegExp(topScope, compiled2);
            re.isInstance = true;
        }
        return re;
    }
    
    private static Object matchOrReplace(final Context cx, final Scriptable scope, final Scriptable thisObj, final Object[] args, final RegExpImpl reImpl, final GlobData data, final NativeRegExp re) {
        final String str = data.str;
        data.global = ((re.getFlags() & 0x1) != 0x0);
        final int[] indexp = { data.fromIndex };
        Object result = null;
        if (data.mode == 4) {
            result = re.executeRegExp(cx, scope, reImpl, str, indexp, 0);
            if (result != null && result.equals(Boolean.TRUE)) {
                result = reImpl.leftContext.length;
            }
            else {
                result = -1;
            }
        }
        else if (data.global) {
            re.lastIndex = 0.0;
            int count = 0;
            while (indexp[0] <= str.length()) {
                result = re.executeRegExp(cx, scope, reImpl, str, indexp, 0);
                if (result == null) {
                    break;
                }
                if (!result.equals(Boolean.TRUE)) {
                    break;
                }
                if (data.mode == 1) {
                    match_glob(data, cx, scope, count, reImpl);
                }
                else {
                    if (data.mode != 2 && data.mode != 3) {
                        Kit.codeBug();
                    }
                    final SubString lastMatch = reImpl.lastMatch;
                    final int leftIndex = data.leftIndex;
                    final int leftlen = lastMatch.index - leftIndex;
                    data.leftIndex = lastMatch.index + lastMatch.length;
                    replace_glob(data, cx, scope, reImpl, leftIndex, leftlen);
                }
                if (reImpl.lastMatch.length == 0) {
                    if (indexp[0] == str.length()) {
                        break;
                    }
                    final int[] array = indexp;
                    final int n = 0;
                    ++array[n];
                }
                ++count;
            }
        }
        else {
            result = re.executeRegExp(cx, scope, reImpl, str, indexp, (int)((data.mode != 2 && data.mode != 3) ? 1 : 0));
        }
        return result;
    }
    
    @Override
    public int find_split(final Context cx, final Scriptable scope, final String target, final String separator, final Scriptable reObj, final int[] ip, final int[] matchlen, final boolean[] matched, final String[][] parensp) {
        int i = ip[0];
        final int length = target.length();
        final int version = cx.getLanguageVersion();
        final NativeRegExp re = (NativeRegExp)reObj;
        int result;
        while (true) {
            final int ipsave = ip[0];
            ip[0] = i;
            final Object ret = re.executeRegExp(cx, scope, this, target, ip, 0);
            if (ret != Boolean.TRUE) {
                ip[0] = ipsave;
                matchlen[0] = 1;
                matched[0] = false;
                return length;
            }
            i = ip[0];
            ip[0] = ipsave;
            matched[0] = true;
            final SubString sep = this.lastMatch;
            matchlen[0] = sep.length;
            if (matchlen[0] != 0 || i != ip[0]) {
                result = i - matchlen[0];
                break;
            }
            if (i == length) {
                if (version == 120) {
                    matchlen[0] = 1;
                    result = i;
                    break;
                }
                result = -1;
                break;
            }
            else {
                ++i;
            }
        }
        final int size = (this.parens == null) ? 0 : this.parens.length;
        parensp[0] = new String[size];
        for (int num = 0; num < size; ++num) {
            final SubString parsub = this.getParenSubString(num);
            parensp[0][num] = parsub.toString();
        }
        return result;
    }
    
    SubString getParenSubString(final int i) {
        if (this.parens != null && i < this.parens.length) {
            final SubString parsub = this.parens[i];
            if (parsub != null) {
                return parsub;
            }
        }
        return new SubString();
    }
    
    private static void match_glob(final GlobData mdata, final Context cx, final Scriptable scope, final int count, final RegExpImpl reImpl) {
        if (mdata.arrayobj == null) {
            mdata.arrayobj = cx.newArray(scope, 0);
        }
        final SubString matchsub = reImpl.lastMatch;
        final String matchstr = matchsub.toString();
        mdata.arrayobj.put(count, mdata.arrayobj, matchstr);
    }
    
    private static void replace_glob(final GlobData rdata, final Context cx, final Scriptable scope, final RegExpImpl reImpl, final int leftIndex, final int leftlen) {
        String lambdaStr;
        int replen;
        if (rdata.lambda != null) {
            final SubString[] parens = reImpl.parens;
            final int parenCount = (parens == null) ? 0 : parens.length;
            final Object[] args = new Object[parenCount + 3];
            args[0] = reImpl.lastMatch.toString();
            for (int i = 0; i < parenCount; ++i) {
                final SubString sub = parens[i];
                if (sub != null) {
                    args[i + 1] = sub.toString();
                }
                else {
                    args[i + 1] = Undefined.instance;
                }
            }
            args[parenCount + 1] = reImpl.leftContext.length;
            args[parenCount + 2] = rdata.str;
            if (reImpl != ScriptRuntime.getRegExpProxy(cx)) {
                throw Kit.codeBug();
            }
            final RegExpImpl re2 = new RegExpImpl();
            re2.multiline = reImpl.multiline;
            re2.input = reImpl.input;
            ScriptRuntime.setRegExpProxy(cx, re2);
            try {
                final Scriptable parent = ScriptableObject.getTopLevelScope(scope);
                final Object result = rdata.lambda.call(cx, parent, parent, args);
                lambdaStr = ScriptRuntime.toString(result);
            }
            finally {
                ScriptRuntime.setRegExpProxy(cx, reImpl);
            }
            replen = lambdaStr.length();
        }
        else {
            lambdaStr = null;
            replen = rdata.repstr.length();
            if (rdata.dollar >= 0) {
                final int[] skip = { 0 };
                int dollarPos = rdata.dollar;
                do {
                    final SubString sub2 = interpretDollar(cx, reImpl, rdata.repstr, dollarPos, skip);
                    if (sub2 != null) {
                        replen += sub2.length - skip[0];
                        dollarPos += skip[0];
                    }
                    else {
                        ++dollarPos;
                    }
                    dollarPos = rdata.repstr.indexOf(36, dollarPos);
                } while (dollarPos >= 0);
            }
        }
        final int growth = leftlen + replen + reImpl.rightContext.length;
        StringBuilder charBuf = rdata.charBuf;
        if (charBuf == null) {
            charBuf = new StringBuilder(growth);
            rdata.charBuf = charBuf;
        }
        else {
            charBuf.ensureCapacity(rdata.charBuf.length() + growth);
        }
        charBuf.append(reImpl.leftContext.str, leftIndex, leftIndex + leftlen);
        if (rdata.lambda != null) {
            charBuf.append(lambdaStr);
        }
        else {
            do_replace(rdata, cx, reImpl);
        }
    }
    
    private static SubString interpretDollar(final Context cx, final RegExpImpl res, final String repstr, final int dollarPos, final int[] skip) {
        if (repstr.charAt(dollarPos) != '$') {
            throw Kit.codeBug();
        }
        final int version = cx.getLanguageVersion();
        if (version != 0 && version <= 140 && dollarPos > 0 && repstr.charAt(dollarPos - 1) == '\\') {
            return null;
        }
        final int repstrLen = repstr.length();
        if (dollarPos + 1 >= repstrLen) {
            return null;
        }
        char dollarChar = repstr.charAt(dollarPos + 1);
        if (NativeRegExp.isDigit(dollarChar)) {
            int num;
            int cp;
            if (version != 0 && version <= 140) {
                if (dollarChar == '0') {
                    return null;
                }
                num = 0;
                cp = dollarPos;
                while (++cp < repstrLen && NativeRegExp.isDigit(dollarChar = repstr.charAt(cp))) {
                    final int tmp = 10 * num + (dollarChar - '0');
                    if (tmp < num) {
                        break;
                    }
                    num = tmp;
                }
            }
            else {
                final int parenCount = (res.parens == null) ? 0 : res.parens.length;
                num = dollarChar - '0';
                if (num > parenCount) {
                    return null;
                }
                cp = dollarPos + 2;
                if (dollarPos + 2 < repstrLen) {
                    dollarChar = repstr.charAt(dollarPos + 2);
                    if (NativeRegExp.isDigit(dollarChar)) {
                        final int tmp = 10 * num + (dollarChar - '0');
                        if (tmp <= parenCount) {
                            ++cp;
                            num = tmp;
                        }
                    }
                }
                if (num == 0) {
                    return null;
                }
            }
            --num;
            skip[0] = cp - dollarPos;
            return res.getParenSubString(num);
        }
        skip[0] = 2;
        switch (dollarChar) {
            case '$': {
                return new SubString("$");
            }
            case '&': {
                return res.lastMatch;
            }
            case '+': {
                return res.lastParen;
            }
            case '`': {
                if (version == 120) {
                    res.prevContext.index = 0;
                    res.prevContext.length = res.lastMatch.index;
                }
                return res.prevContext;
            }
            case '\'': {
                return res.rightContext;
            }
            default: {
                return null;
            }
        }
    }
    
    private static void do_replace(final GlobData rdata, final Context cx, final RegExpImpl regExpImpl) {
        final StringBuilder charBuf = rdata.charBuf;
        int cp = 0;
        final String da = rdata.repstr;
        int dp = rdata.dollar;
        if (dp != -1) {
            final int[] skip = { 0 };
            do {
                charBuf.append(da, cp, dp);
                cp = dp;
                final SubString sub = interpretDollar(cx, regExpImpl, da, dp, skip);
                if (sub != null) {
                    final int len = sub.length;
                    if (len > 0) {
                        charBuf.append(sub.str, sub.index, sub.index + len);
                    }
                    cp += skip[0];
                    dp += skip[0];
                }
                else {
                    ++dp;
                }
                dp = da.indexOf(36, dp);
            } while (dp >= 0);
        }
        final int daL = da.length();
        if (daL > cp) {
            charBuf.append(da, cp, daL);
        }
    }
    
    @Override
    public Object js_split(final Context cx, final Scriptable scope, final String target, final Object[] args) {
        if (args[0] instanceof NativeObject) {
            final NativeObject arg0 = (NativeObject)args[0];
            if (ScriptableObject.hasProperty((Scriptable)arg0, SymbolKey.SPLIT)) {
                final Object split = ScriptableObject.getProperty((Scriptable)arg0, SymbolKey.SPLIT);
                if (split instanceof Callable) {
                    return ((Callable)split).call(cx, scope, (Scriptable)null, new Object[] { target });
                }
            }
        }
        final Scriptable result = cx.newArray(scope, 0);
        final boolean limited = args.length > 1 && args[1] != Undefined.instance;
        long limit = 0L;
        if (limited) {
            limit = ScriptRuntime.toUint32(args[1]);
            if (limit > target.length()) {
                limit = 1 + target.length();
            }
        }
        if (args[0] == Undefined.instance) {
            result.put(0, result, target);
            return result;
        }
        String separator = null;
        final int[] matchlen = { 0 };
        Scriptable re = null;
        RegExpProxy reProxy = null;
        if (args[0] instanceof Scriptable) {
            reProxy = ScriptRuntime.getRegExpProxy(cx);
            if (reProxy != null) {
                final Scriptable test = (Scriptable)args[0];
                if (reProxy.isRegExp(test)) {
                    re = test;
                }
            }
        }
        if (re == null) {
            separator = ScriptRuntime.toString(args[0]);
            matchlen[0] = separator.length();
        }
        final int[] ip = { 0 };
        int len = 0;
        final boolean[] matched = { false };
        final String[][] parens = { null };
        final int version = cx.getLanguageVersion();
        int match;
        while ((match = find_split(cx, scope, target, separator, version, reProxy, re, ip, matchlen, matched, parens)) >= 0 && (!limited || len < limit)) {
            if (match > target.length()) {
                break;
            }
            String substr;
            if (target.length() == 0) {
                substr = target;
            }
            else {
                substr = target.substring(ip[0], match);
            }
            result.put(len, result, substr);
            ++len;
            if (re != null && matched[0]) {
                for (int size = parens[0].length, num = 0; num < size && (!limited || len < limit); ++len, ++num) {
                    result.put(len, result, parens[0][num]);
                }
                matched[0] = false;
            }
            ip[0] = match + matchlen[0];
            if (version < 130 && version != 0 && !limited && ip[0] == target.length()) {
                break;
            }
        }
        return result;
    }
    
    private static int find_split(final Context cx, final Scriptable scope, final String target, final String separator, final int version, final RegExpProxy reProxy, final Scriptable re, final int[] ip, final int[] matchlen, final boolean[] matched, final String[][] parensp) {
        int i = ip[0];
        final int length = target.length();
        if (version == 120 && re == null && separator.length() == 1 && separator.charAt(0) == ' ') {
            if (i == 0) {
                while (i < length && Character.isWhitespace(target.charAt(i))) {
                    ++i;
                }
                ip[0] = i;
            }
            if (i == length) {
                return -1;
            }
            while (i < length && !Character.isWhitespace(target.charAt(i))) {
                ++i;
            }
            int j;
            for (j = i; j < length && Character.isWhitespace(target.charAt(j)); ++j) {}
            matchlen[0] = j - i;
            return i;
        }
        else {
            if (i > length) {
                return -1;
            }
            if (re != null) {
                return reProxy.find_split(cx, scope, target, separator, re, ip, matchlen, matched, parensp);
            }
            if (version != 0 && version < 130 && length == 0) {
                return -1;
            }
            if (separator.length() == 0) {
                if (version != 120) {
                    return (i == length) ? -1 : (i + 1);
                }
                if (i == length) {
                    matchlen[0] = 1;
                    return i;
                }
                return i + 1;
            }
            else {
                if (ip[0] >= length) {
                    return length;
                }
                i = target.indexOf(separator, ip[0]);
                return (i != -1) ? i : length;
            }
        }
    }
}
