//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.fife.ui.rsyntaxtextarea;

import java.security.*;
import org.fife.ui.rsyntaxtextarea.modes.*;
import java.util.*;

public abstract class TokenMakerFactory
{
    public static final String PROPERTY_DEFAULT_TOKEN_MAKER_FACTORY = "TokenMakerFactory";
    private static TokenMakerFactory DEFAULT_INSTANCE;
    
    public static synchronized TokenMakerFactory getDefaultInstance() {
        if (TokenMakerFactory.DEFAULT_INSTANCE == null) {
            String clazz;
            try {
                clazz = System.getProperty("TokenMakerFactory");
            }
            catch (AccessControlException ace) {
                clazz = null;
            }
            if (clazz == null) {
                clazz = "org.fife.ui.rsyntaxtextarea.DefaultTokenMakerFactory";
            }
            try {
                TokenMakerFactory.DEFAULT_INSTANCE = (TokenMakerFactory)Class.forName(clazz).getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            }
            catch (RuntimeException re) {
                throw re;
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new InternalError("Cannot find TokenMakerFactory: " + clazz);
            }
        }
        return TokenMakerFactory.DEFAULT_INSTANCE;
    }
    
    public final TokenMaker getTokenMaker(final String key) {
        TokenMaker tm = this.getTokenMakerImpl(key);
        if (tm == null) {
            tm = (TokenMaker)new PlainTextTokenMaker();
        }
        return tm;
    }
    
    protected abstract TokenMaker getTokenMakerImpl(final String p0);
    
    public abstract Set<String> keySet();
    
    public static synchronized void setDefaultInstance(final TokenMakerFactory tmf) {
        if (tmf == null) {
            throw new IllegalArgumentException("tmf cannot be null");
        }
        TokenMakerFactory.DEFAULT_INSTANCE = tmf;
    }
}
