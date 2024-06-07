//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import org.mozilla.javascript.*;
import java.io.*;
import java.net.*;

public abstract class ModuleSourceProviderBase implements ModuleSourceProvider, Serializable
{
    private static final long serialVersionUID = 1L;
    
    public ModuleSource loadSource(final String moduleId, final Scriptable paths, final Object validator) throws IOException, URISyntaxException {
        if (!this.entityNeedsRevalidation(validator)) {
            return ModuleSourceProviderBase.NOT_MODIFIED;
        }
        ModuleSource moduleSource = this.loadFromPrivilegedLocations(moduleId, validator);
        if (moduleSource != null) {
            return moduleSource;
        }
        if (paths != null) {
            moduleSource = this.loadFromPathArray(moduleId, paths, validator);
            if (moduleSource != null) {
                return moduleSource;
            }
        }
        return this.loadFromFallbackLocations(moduleId, validator);
    }
    
    public ModuleSource loadSource(final URI uri, final URI base, final Object validator) throws IOException, URISyntaxException {
        return this.loadFromUri(uri, base, validator);
    }
    
    private ModuleSource loadFromPathArray(final String moduleId, final Scriptable paths, final Object validator) throws IOException {
        final long llength = ScriptRuntime.toUint32(ScriptableObject.getProperty(paths, "length"));
        for (int ilength = (llength > 2147483647L) ? Integer.MAX_VALUE : ((int)llength), i = 0; i < ilength; ++i) {
            final String path = ensureTrailingSlash(ScriptableObject.getTypedProperty(paths, i, String.class));
            try {
                URI uri = new URI(path);
                if (!uri.isAbsolute()) {
                    uri = new File(path).toURI().resolve("");
                }
                final ModuleSource moduleSource = this.loadFromUri(uri.resolve(moduleId), uri, validator);
                if (moduleSource != null) {
                    return moduleSource;
                }
            }
            catch (URISyntaxException e) {
                throw new MalformedURLException(e.getMessage());
            }
        }
        return null;
    }
    
    private static String ensureTrailingSlash(final String path) {
        return path.endsWith("/") ? path : path.concat("/");
    }
    
    protected boolean entityNeedsRevalidation(final Object validator) {
        return true;
    }
    
    protected abstract ModuleSource loadFromUri(final URI p0, final URI p1, final Object p2) throws IOException, URISyntaxException;
    
    protected ModuleSource loadFromPrivilegedLocations(final String moduleId, final Object validator) throws IOException, URISyntaxException {
        return null;
    }
    
    protected ModuleSource loadFromFallbackLocations(final String moduleId, final Object validator) throws IOException, URISyntaxException {
        return null;
    }
}
