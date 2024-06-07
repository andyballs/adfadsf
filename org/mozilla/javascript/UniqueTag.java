//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

import java.io.*;

public final class UniqueTag implements Serializable
{
    private static final long serialVersionUID = -4320556826714577259L;
    private static final int ID_NOT_FOUND = 1;
    private static final int ID_NULL_VALUE = 2;
    private static final int ID_DOUBLE_MARK = 3;
    public static final UniqueTag NOT_FOUND;
    public static final UniqueTag NULL_VALUE;
    public static final UniqueTag DOUBLE_MARK;
    private final int tagId;
    
    private UniqueTag(final int tagId) {
        this.tagId = tagId;
    }
    
    public Object readResolve() {
        switch (this.tagId) {
            case 1: {
                return UniqueTag.NOT_FOUND;
            }
            case 2: {
                return UniqueTag.NULL_VALUE;
            }
            case 3: {
                return UniqueTag.DOUBLE_MARK;
            }
            default: {
                throw new IllegalStateException(String.valueOf(this.tagId));
            }
        }
    }
    
    @Override
    public String toString() {
        String name = null;
        switch (this.tagId) {
            case 1: {
                name = "NOT_FOUND";
                break;
            }
            case 2: {
                name = "NULL_VALUE";
                break;
            }
            case 3: {
                name = "DOUBLE_MARK";
                break;
            }
            default: {
                throw Kit.codeBug();
            }
        }
        return super.toString() + ": " + name;
    }
    
    static {
        NOT_FOUND = new UniqueTag(1);
        NULL_VALUE = new UniqueTag(2);
        DOUBLE_MARK = new UniqueTag(3);
    }
}
