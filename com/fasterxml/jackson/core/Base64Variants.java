//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

public final class Base64Variants
{
    static final String STD_BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static final Base64Variant MIME;
    public static final Base64Variant MIME_NO_LINEFEEDS;
    public static final Base64Variant PEM;
    public static final Base64Variant MODIFIED_FOR_URL;
    
    public static Base64Variant getDefaultVariant() {
        return Base64Variants.MIME_NO_LINEFEEDS;
    }
    
    public static Base64Variant valueOf(String name) throws IllegalArgumentException {
        if (Base64Variants.MIME._name.equals(name)) {
            return Base64Variants.MIME;
        }
        if (Base64Variants.MIME_NO_LINEFEEDS._name.equals(name)) {
            return Base64Variants.MIME_NO_LINEFEEDS;
        }
        if (Base64Variants.PEM._name.equals(name)) {
            return Base64Variants.PEM;
        }
        if (Base64Variants.MODIFIED_FOR_URL._name.equals(name)) {
            return Base64Variants.MODIFIED_FOR_URL;
        }
        if (name == null) {
            name = "<null>";
        }
        else {
            name = "'" + name + "'";
        }
        throw new IllegalArgumentException("No Base64Variant with name " + name);
    }
    
    static {
        MIME = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        MIME_NO_LINEFEEDS = new Base64Variant(Base64Variants.MIME, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        PEM = new Base64Variant(Base64Variants.MIME, "PEM", true, '=', 64);
        final StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf("+"), '-');
        sb.setCharAt(sb.indexOf("/"), '_');
        MODIFIED_FOR_URL = new Base64Variant("MODIFIED-FOR-URL", sb.toString(), false, '\0', Integer.MAX_VALUE);
    }
}
