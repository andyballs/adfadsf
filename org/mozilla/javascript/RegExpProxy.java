//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public interface RegExpProxy
{
    public static final int RA_MATCH = 1;
    public static final int RA_REPLACE = 2;
    public static final int RA_REPLACE_ALL = 3;
    public static final int RA_SEARCH = 4;
    
    boolean isRegExp(final Scriptable p0);
    
    Object compileRegExp(final Context p0, final String p1, final String p2);
    
    Scriptable wrapRegExp(final Context p0, final Scriptable p1, final Object p2);
    
    Object action(final Context p0, final Scriptable p1, final Scriptable p2, final Object[] p3, final int p4);
    
    int find_split(final Context p0, final Scriptable p1, final String p2, final String p3, final Scriptable p4, final int[] p5, final int[] p6, final boolean[] p7, final String[][] p8);
    
    Object js_split(final Context p0, final Scriptable p1, final String p2, final Object[] p3);
}
