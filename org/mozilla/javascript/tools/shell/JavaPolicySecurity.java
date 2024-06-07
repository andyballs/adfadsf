//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import java.security.cert.*;
import java.io.*;
import java.net.*;
import org.mozilla.javascript.*;
import java.security.*;
import java.util.*;

public class JavaPolicySecurity extends SecurityProxy
{
    public Class<?> getStaticSecurityDomainClassInternal() {
        return ProtectionDomain.class;
    }
    
    public JavaPolicySecurity() {
        new CodeSource(null, (Certificate[])null);
    }
    
    @Override
    protected void callProcessFileSecure(final Context cx, final Scriptable scope, final String filename) {
        AccessController.doPrivileged((PrivilegedAction<Object>)new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                final URL url = JavaPolicySecurity.this.getUrlObj(filename);
                final ProtectionDomain staticDomain = JavaPolicySecurity.this.getUrlDomain(url);
                try {
                    Main.processFileSecure(cx, scope, url.toExternalForm(), staticDomain);
                }
                catch (IOException ioex) {
                    throw new RuntimeException(ioex);
                }
                return null;
            }
        });
    }
    
    private URL getUrlObj(final String url) {
        URL urlObj;
        try {
            urlObj = new URL(url);
        }
        catch (MalformedURLException ex3) {
            String curDir = System.getProperty("user.dir");
            curDir = curDir.replace('\\', '/');
            if (!curDir.endsWith("/")) {
                curDir += '/';
            }
            try {
                final URL curDirURL = new URL("file:" + curDir);
                urlObj = new URL(curDirURL, url);
            }
            catch (MalformedURLException ex2) {
                throw new RuntimeException("Can not construct file URL for '" + url + "':" + ex2.getMessage());
            }
        }
        return urlObj;
    }
    
    private ProtectionDomain getUrlDomain(final URL url) {
        final CodeSource cs = new CodeSource(url, (Certificate[])null);
        final PermissionCollection pc = Policy.getPolicy().getPermissions(cs);
        return new ProtectionDomain(cs, pc);
    }
    
    public GeneratedClassLoader createClassLoader(final ClassLoader parentLoader, final Object securityDomain) {
        final ProtectionDomain domain = (ProtectionDomain)securityDomain;
        return AccessController.doPrivileged((PrivilegedAction<GeneratedClassLoader>)new PrivilegedAction<Loader>() {
            @Override
            public Loader run() {
                return new Loader(parentLoader, domain);
            }
        });
    }
    
    public Object getDynamicSecurityDomain(final Object securityDomain) {
        final ProtectionDomain staticDomain = (ProtectionDomain)securityDomain;
        return this.getDynamicDomain(staticDomain);
    }
    
    private ProtectionDomain getDynamicDomain(final ProtectionDomain staticDomain) {
        final ContextPermissions p = new ContextPermissions(staticDomain);
        final ProtectionDomain contextDomain = new ProtectionDomain(null, p);
        return contextDomain;
    }
    
    public Object callWithDomain(final Object securityDomain, final Context cx, final Callable callable, final Scriptable scope, final Scriptable thisObj, final Object[] args) {
        final ProtectionDomain staticDomain = (ProtectionDomain)securityDomain;
        final ProtectionDomain dynamicDomain = this.getDynamicDomain(staticDomain);
        final ProtectionDomain[] tmp = { dynamicDomain };
        final AccessControlContext restricted = new AccessControlContext(tmp);
        final PrivilegedAction<Object> action = new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                return callable.call(cx, scope, thisObj, args);
            }
        };
        return AccessController.doPrivileged(action, restricted);
    }
    
    private static class Loader extends ClassLoader implements GeneratedClassLoader
    {
        private ProtectionDomain domain;
        
        Loader(final ClassLoader parent, final ProtectionDomain domain) {
            super((parent != null) ? parent : ClassLoader.getSystemClassLoader());
            this.domain = domain;
        }
        
        public Class<?> defineClass(final String name, final byte[] data) {
            return super.defineClass(name, data, 0, data.length, this.domain);
        }
        
        public void linkClass(final Class<?> cl) {
            this.resolveClass(cl);
        }
    }
    
    private static class ContextPermissions extends PermissionCollection
    {
        static final long serialVersionUID = -1721494496320750721L;
        AccessControlContext _context;
        PermissionCollection _statisPermissions;
        
        ContextPermissions(final ProtectionDomain staticDomain) {
            this._context = AccessController.getContext();
            if (staticDomain != null) {
                this._statisPermissions = staticDomain.getPermissions();
            }
            this.setReadOnly();
        }
        
        @Override
        public void add(final Permission permission) {
            throw new RuntimeException("NOT IMPLEMENTED");
        }
        
        @Override
        public boolean implies(final Permission permission) {
            if (this._statisPermissions != null && !this._statisPermissions.implies(permission)) {
                return false;
            }
            try {
                this._context.checkPermission(permission);
                return true;
            }
            catch (AccessControlException ex) {
                return false;
            }
        }
        
        @Override
        public Enumeration<Permission> elements() {
            return new Enumeration<Permission>() {
                @Override
                public boolean hasMoreElements() {
                    return false;
                }
                
                @Override
                public Permission nextElement() {
                    return null;
                }
            };
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" (context=");
            sb.append(this._context);
            sb.append(", static_permitions=");
            sb.append(this._statisPermissions);
            sb.append(')');
            return sb.toString();
        }
    }
}
