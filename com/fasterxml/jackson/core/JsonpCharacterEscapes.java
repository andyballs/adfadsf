//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.*;

public class JsonpCharacterEscapes extends CharacterEscapes
{
    private static final long serialVersionUID = 1L;
    private static final int[] asciiEscapes;
    private static final SerializedString escapeFor2028;
    private static final SerializedString escapeFor2029;
    private static final JsonpCharacterEscapes sInstance;
    
    public static JsonpCharacterEscapes instance() {
        return JsonpCharacterEscapes.sInstance;
    }
    
    public SerializableString getEscapeSequence(final int ch) {
        switch (ch) {
            case 8232: {
                return (SerializableString)JsonpCharacterEscapes.escapeFor2028;
            }
            case 8233: {
                return (SerializableString)JsonpCharacterEscapes.escapeFor2029;
            }
            default: {
                return null;
            }
        }
    }
    
    public int[] getEscapeCodesForAscii() {
        return JsonpCharacterEscapes.asciiEscapes;
    }
    
    static {
        asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
        escapeFor2028 = new SerializedString("\\u2028");
        escapeFor2029 = new SerializedString("\\u2029");
        sInstance = new JsonpCharacterEscapes();
    }
}
