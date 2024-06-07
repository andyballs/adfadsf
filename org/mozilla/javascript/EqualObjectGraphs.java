//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.util.function.*;
import java.util.*;
import org.mozilla.javascript.debug.*;

final class EqualObjectGraphs
{
    private static final ThreadLocal<EqualObjectGraphs> instance;
    private final Map<Object, Object> knownEquals;
    private final Map<Object, Object> currentlyCompared;
    
    EqualObjectGraphs() {
        this.knownEquals = new IdentityHashMap<Object, Object>();
        this.currentlyCompared = new IdentityHashMap<Object, Object>();
    }
    
    static <T> T withThreadLocal(final Function<EqualObjectGraphs, T> action) {
        final EqualObjectGraphs currEq = EqualObjectGraphs.instance.get();
        if (currEq == null) {
            final EqualObjectGraphs eq = new EqualObjectGraphs();
            EqualObjectGraphs.instance.set(eq);
            try {
                return action.apply(eq);
            }
            finally {
                EqualObjectGraphs.instance.set(null);
            }
        }
        return action.apply(currEq);
    }
    
    boolean equalGraphs(final Object o1, final Object o2) {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        final Object curr2 = this.currentlyCompared.get(o1);
        if (curr2 == o2) {
            return true;
        }
        if (curr2 != null) {
            return false;
        }
        final Object prev2 = this.knownEquals.get(o1);
        if (prev2 == o2) {
            return true;
        }
        if (prev2 != null) {
            return false;
        }
        final Object prev3 = this.knownEquals.get(o2);
        assert prev3 != o1;
        if (prev3 != null) {
            return false;
        }
        this.currentlyCompared.put(o1, o2);
        final boolean eq = this.equalGraphsNoMemo(o1, o2);
        if (eq) {
            this.knownEquals.put(o1, o2);
            this.knownEquals.put(o2, o1);
        }
        this.currentlyCompared.remove(o1);
        return eq;
    }
    
    private boolean equalGraphsNoMemo(final Object o1, final Object o2) {
        if (o1 instanceof Wrapper) {
            return o2 instanceof Wrapper && this.equalGraphs(((Wrapper)o1).unwrap(), ((Wrapper)o2).unwrap());
        }
        if (o1 instanceof Scriptable) {
            return o2 instanceof Scriptable && this.equalScriptables((Scriptable)o1, (Scriptable)o2);
        }
        if (o1 instanceof ConsString) {
            return ((ConsString)o1).toString().equals(o2);
        }
        if (o2 instanceof ConsString) {
            return o1.equals(((ConsString)o2).toString());
        }
        if (o1 instanceof SymbolKey) {
            return o2 instanceof SymbolKey && this.equalGraphs(((SymbolKey)o1).getName(), ((SymbolKey)o2).getName());
        }
        if (o1 instanceof Object[]) {
            return o2 instanceof Object[] && this.equalObjectArrays((Object[])o1, (Object[])o2);
        }
        if (o1.getClass().isArray()) {
            return Objects.deepEquals(o1, o2);
        }
        if (o1 instanceof List) {
            return o2 instanceof List && this.equalLists((List<?>)o1, (List<?>)o2);
        }
        if (o1 instanceof Map) {
            return o2 instanceof Map && this.equalMaps((Map<?, ?>)o1, (Map<?, ?>)o2);
        }
        if (o1 instanceof Set) {
            return o2 instanceof Set && this.equalSets((Set<?>)o1, (Set<?>)o2);
        }
        if (o1 instanceof NativeGlobal) {
            return o2 instanceof NativeGlobal;
        }
        if (o1 instanceof JavaAdapter) {
            return o2 instanceof JavaAdapter;
        }
        if (o1 instanceof NativeJavaTopPackage) {
            return o2 instanceof NativeJavaTopPackage;
        }
        return o1.equals(o2);
    }
    
    private boolean equalScriptables(final Scriptable s1, final Scriptable s2) {
        final Object[] ids1 = getSortedIds(s1);
        final Object[] ids2 = getSortedIds(s2);
        if (!this.equalObjectArrays(ids1, ids2)) {
            return false;
        }
        for (int l = ids1.length, i = 0; i < l; ++i) {
            if (!this.equalGraphs(getValue(s1, ids1[i]), getValue(s2, ids2[i]))) {
                return false;
            }
        }
        if (!this.equalGraphs(s1.getPrototype(), s2.getPrototype())) {
            return false;
        }
        if (!this.equalGraphs(s1.getParentScope(), s2.getParentScope())) {
            return false;
        }
        if (s1 instanceof NativeContinuation) {
            return s2 instanceof NativeContinuation && NativeContinuation.equalImplementations((NativeContinuation)s1, (NativeContinuation)s2);
        }
        if (s1 instanceof NativeJavaPackage) {
            return s1.equals(s2);
        }
        if (s1 instanceof IdFunctionObject) {
            return s2 instanceof IdFunctionObject && IdFunctionObject.equalObjectGraphs((IdFunctionObject)s1, (IdFunctionObject)s2, this);
        }
        if (s1 instanceof InterpretedFunction) {
            return s2 instanceof InterpretedFunction && equalInterpretedFunctions((InterpretedFunction)s1, (InterpretedFunction)s2);
        }
        if (s1 instanceof ArrowFunction) {
            return s2 instanceof ArrowFunction && ArrowFunction.equalObjectGraphs((ArrowFunction)s1, (ArrowFunction)s2, this);
        }
        if (s1 instanceof BoundFunction) {
            return s2 instanceof BoundFunction && BoundFunction.equalObjectGraphs((BoundFunction)s1, (BoundFunction)s2, this);
        }
        return !(s1 instanceof NativeSymbol) || (s2 instanceof NativeSymbol && this.equalGraphs(((NativeSymbol)s1).getKey(), ((NativeSymbol)s2).getKey()));
    }
    
    private boolean equalObjectArrays(final Object[] a1, final Object[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; ++i) {
            if (!this.equalGraphs(a1[i], a2[i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean equalLists(final List<?> l1, final List<?> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }
        final Iterator<?> i1 = l1.iterator();
        final Iterator<?> i2 = l2.iterator();
        while (i1.hasNext() && i2.hasNext()) {
            if (!this.equalGraphs(i1.next(), i2.next())) {
                return false;
            }
        }
        assert !i1.hasNext() && !i2.hasNext();
        return true;
    }
    
    private boolean equalMaps(final Map<?, ?> m1, final Map<?, ?> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }
        final Iterator<Map.Entry> i1 = sortedEntries(m1);
        final Iterator<Map.Entry> i2 = sortedEntries(m2);
        while (i1.hasNext() && i2.hasNext()) {
            final Map.Entry kv1 = i1.next();
            final Map.Entry kv2 = i2.next();
            if (!this.equalGraphs(kv1.getKey(), kv2.getKey()) || !this.equalGraphs(kv1.getValue(), kv2.getValue())) {
                return false;
            }
        }
        assert !i1.hasNext() && !i2.hasNext();
        return true;
    }
    
    private static Iterator<Map.Entry> sortedEntries(final Map m) {
        final Map sortedMap = (m instanceof SortedMap) ? m : new TreeMap(m);
        return (Iterator<Map.Entry>)sortedMap.entrySet().iterator();
    }
    
    private boolean equalSets(final Set<?> s1, final Set<?> s2) {
        return this.equalObjectArrays(sortedSet(s1), sortedSet(s2));
    }
    
    private static Object[] sortedSet(final Set<?> s) {
        final Object[] a = s.toArray();
        Arrays.sort(a);
        return a;
    }
    
    private static boolean equalInterpretedFunctions(final InterpretedFunction f1, final InterpretedFunction f2) {
        return Objects.equals(f1.getEncodedSource(), f2.getEncodedSource());
    }
    
    private static Object[] getSortedIds(final Scriptable s) {
        final Object[] ids = getIds(s);
        Arrays.sort(ids, (a, b) -> {
            if (a instanceof Integer) {
                if (b instanceof Integer) {
                    return ((Integer)a).compareTo((Integer)b);
                }
                else if (b instanceof String || b instanceof Symbol) {
                    return -1;
                }
            }
            else if (a instanceof String) {
                if (b instanceof String) {
                    return ((String)a).compareTo((String)b);
                }
                else if (b instanceof Integer) {
                    return 1;
                }
                else if (b instanceof Symbol) {
                    return -1;
                }
            }
            else if (a instanceof Symbol) {
                if (b instanceof Symbol) {
                    return getSymbolName(a).compareTo(getSymbolName(b));
                }
                else if (b instanceof Integer || b instanceof String) {
                    return 1;
                }
            }
            throw new ClassCastException();
        });
        return ids;
    }
    
    private static String getSymbolName(final Symbol s) {
        if (s instanceof SymbolKey) {
            return ((SymbolKey)s).getName();
        }
        if (s instanceof NativeSymbol) {
            return ((NativeSymbol)s).getKey().getName();
        }
        throw new ClassCastException();
    }
    
    private static Object[] getIds(final Scriptable s) {
        if (s instanceof ScriptableObject) {
            return ((ScriptableObject)s).getIds(true, true);
        }
        if (s instanceof DebuggableObject) {
            return ((DebuggableObject)s).getAllIds();
        }
        return s.getIds();
    }
    
    private static Object getValue(final Scriptable s, final Object id) {
        if (id instanceof Symbol) {
            return ScriptableObject.getProperty(s, (Symbol)id);
        }
        if (id instanceof Integer) {
            return ScriptableObject.getProperty(s, id);
        }
        if (id instanceof String) {
            return ScriptableObject.getProperty(s, (String)id);
        }
        throw new ClassCastException();
    }
    
    static {
        instance = new ThreadLocal<EqualObjectGraphs>();
    }
}
