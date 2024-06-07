//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.commonjs.module.provider;

import java.nio.file.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class UrlModuleSourceProvider extends ModuleSourceProviderBase
{
    private static final long serialVersionUID = 1L;
    private final Iterable<URI> privilegedUris;
    private final Iterable<URI> fallbackUris;
    private final UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider;
    private final UrlConnectionExpiryCalculator urlConnectionExpiryCalculator;
    
    public UrlModuleSourceProvider(final Iterable<URI> privilegedUris, final Iterable<URI> fallbackUris) {
        this(privilegedUris, fallbackUris, (UrlConnectionExpiryCalculator)new DefaultUrlConnectionExpiryCalculator(), null);
    }
    
    public UrlModuleSourceProvider(final Iterable<URI> privilegedUris, final Iterable<URI> fallbackUris, final UrlConnectionExpiryCalculator urlConnectionExpiryCalculator, final UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider) {
        this.privilegedUris = privilegedUris;
        this.fallbackUris = fallbackUris;
        this.urlConnectionExpiryCalculator = urlConnectionExpiryCalculator;
        this.urlConnectionSecurityDomainProvider = urlConnectionSecurityDomainProvider;
    }
    
    protected ModuleSource loadFromPrivilegedLocations(final String moduleId, final Object validator) throws IOException, URISyntaxException {
        return this.loadFromPathList(moduleId, validator, this.privilegedUris);
    }
    
    protected ModuleSource loadFromFallbackLocations(final String moduleId, final Object validator) throws IOException, URISyntaxException {
        return this.loadFromPathList(moduleId, validator, this.fallbackUris);
    }
    
    private ModuleSource loadFromPathList(final String moduleId, final Object validator, final Iterable<URI> paths) throws IOException, URISyntaxException {
        if (paths == null) {
            return null;
        }
        for (final URI path : paths) {
            final ModuleSource moduleSource = this.loadFromUri(path.resolve(moduleId), path, validator);
            if (moduleSource != null) {
                return moduleSource;
            }
        }
        return null;
    }
    
    protected ModuleSource loadFromUri(URI uri, final URI base, final Object validator) throws IOException, URISyntaxException {
        final URI fullUri = new URI(uri + ".js");
        final ModuleSource source = this.loadFromActualUri(fullUri, base, validator);
        if (source != null) {
            return source;
        }
        try {
            final Path path = Paths.get(uri);
            if (Files.isDirectory(path, new LinkOption[0])) {
                uri = new File(new File(uri), "index.js").toURI();
            }
        }
        catch (Exception ex) {}
        return this.loadFromActualUri(uri, base, validator);
    }
    
    protected ModuleSource loadFromActualUri(final URI uri, final URI base, final Object validator) throws IOException {
        final URL url = new URL((base == null) ? null : base.toURL(), uri.toString());
        final long request_time = System.currentTimeMillis();
        final URLConnection urlConnection = this.openUrlConnection(url);
        URLValidator applicableValidator;
        if (validator instanceof URLValidator) {
            final URLValidator uriValidator = (URLValidator)validator;
            applicableValidator = (uriValidator.appliesTo(uri) ? uriValidator : null);
        }
        else {
            applicableValidator = null;
        }
        if (applicableValidator != null) {
            applicableValidator.applyConditionals(urlConnection);
        }
        try {
            urlConnection.connect();
            if (applicableValidator != null && !applicableValidator.updateValidator(urlConnection, request_time, this.urlConnectionExpiryCalculator)) {
                this.close(urlConnection);
                return UrlModuleSourceProvider.NOT_MODIFIED;
            }
            return new ModuleSource(getReader(urlConnection), this.getSecurityDomain(urlConnection), uri, base, (Object)new URLValidator(uri, urlConnection, request_time, this.urlConnectionExpiryCalculator));
        }
        catch (FileNotFoundException e3) {
            return null;
        }
        catch (RuntimeException e) {
            this.close(urlConnection);
            throw e;
        }
        catch (IOException e2) {
            this.close(urlConnection);
            throw e2;
        }
    }
    
    private static Reader getReader(final URLConnection urlConnection) throws IOException {
        return new InputStreamReader(urlConnection.getInputStream(), getCharacterEncoding(urlConnection));
    }
    
    private static String getCharacterEncoding(final URLConnection urlConnection) {
        final ParsedContentType pct = new ParsedContentType(urlConnection.getContentType());
        final String encoding = pct.getEncoding();
        if (encoding != null) {
            return encoding;
        }
        final String contentType = pct.getContentType();
        if (contentType != null && contentType.startsWith("text/")) {
            return "8859_1";
        }
        return "utf-8";
    }
    
    private Object getSecurityDomain(final URLConnection urlConnection) {
        return (this.urlConnectionSecurityDomainProvider == null) ? null : this.urlConnectionSecurityDomainProvider.getSecurityDomain(urlConnection);
    }
    
    private void close(final URLConnection urlConnection) {
        try {
            urlConnection.getInputStream().close();
        }
        catch (IOException e) {
            this.onFailedClosingUrlConnection(urlConnection, e);
        }
    }
    
    protected void onFailedClosingUrlConnection(final URLConnection urlConnection, final IOException cause) {
    }
    
    protected URLConnection openUrlConnection(final URL url) throws IOException {
        return url.openConnection();
    }
    
    protected boolean entityNeedsRevalidation(final Object validator) {
        return !(validator instanceof URLValidator) || ((URLValidator)validator).entityNeedsRevalidation();
    }
    
    private static class URLValidator implements Serializable
    {
        private static final long serialVersionUID = 1L;
        private final URI uri;
        private final long lastModified;
        private final String entityTags;
        private long expiry;
        
        public URLValidator(final URI uri, final URLConnection urlConnection, final long request_time, final UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) {
            this.uri = uri;
            this.lastModified = urlConnection.getLastModified();
            this.entityTags = this.getEntityTags(urlConnection);
            this.expiry = this.calculateExpiry(urlConnection, request_time, urlConnectionExpiryCalculator);
        }
        
        boolean updateValidator(final URLConnection urlConnection, final long request_time, final UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) throws IOException {
            final boolean isResourceChanged = this.isResourceChanged(urlConnection);
            if (!isResourceChanged) {
                this.expiry = this.calculateExpiry(urlConnection, request_time, urlConnectionExpiryCalculator);
            }
            return isResourceChanged;
        }
        
        private boolean isResourceChanged(final URLConnection urlConnection) throws IOException {
            if (urlConnection instanceof HttpURLConnection) {
                return ((HttpURLConnection)urlConnection).getResponseCode() == 304;
            }
            return this.lastModified != urlConnection.getLastModified();
        }
        
        private long calculateExpiry(final URLConnection urlConnection, final long request_time, final UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) {
            if ("no-cache".equals(urlConnection.getHeaderField("Pragma"))) {
                return 0L;
            }
            final String cacheControl = urlConnection.getHeaderField("Cache-Control");
            if (cacheControl != null) {
                if (cacheControl.indexOf("no-cache") != -1) {
                    return 0L;
                }
                final int max_age = this.getMaxAge(cacheControl);
                if (-1 != max_age) {
                    final long response_time = System.currentTimeMillis();
                    final long apparent_age = Math.max(0L, response_time - urlConnection.getDate());
                    final long corrected_received_age = Math.max(apparent_age, urlConnection.getHeaderFieldInt("Age", 0) * 1000L);
                    final long response_delay = response_time - request_time;
                    final long corrected_initial_age = corrected_received_age + response_delay;
                    final long creation_time = response_time - corrected_initial_age;
                    return max_age * 1000L + creation_time;
                }
            }
            final long explicitExpiry = urlConnection.getHeaderFieldDate("Expires", -1L);
            if (explicitExpiry != -1L) {
                return explicitExpiry;
            }
            return (urlConnectionExpiryCalculator == null) ? 0L : urlConnectionExpiryCalculator.calculateExpiry(urlConnection);
        }
        
        private int getMaxAge(final String cacheControl) {
            final int maxAgeIndex = cacheControl.indexOf("max-age");
            if (maxAgeIndex == -1) {
                return -1;
            }
            final int eq = cacheControl.indexOf(61, maxAgeIndex + 7);
            if (eq == -1) {
                return -1;
            }
            final int comma = cacheControl.indexOf(44, eq + 1);
            String strAge;
            if (comma == -1) {
                strAge = cacheControl.substring(eq + 1);
            }
            else {
                strAge = cacheControl.substring(eq + 1, comma);
            }
            try {
                return Integer.parseInt(strAge);
            }
            catch (NumberFormatException e) {
                return -1;
            }
        }
        
        private String getEntityTags(final URLConnection urlConnection) {
            final List<String> etags = urlConnection.getHeaderFields().get("ETag");
            if (etags == null || etags.isEmpty()) {
                return null;
            }
            final StringBuilder b = new StringBuilder();
            final Iterator<String> it = etags.iterator();
            b.append(it.next());
            while (it.hasNext()) {
                b.append(", ").append(it.next());
            }
            return b.toString();
        }
        
        boolean appliesTo(final URI uri) {
            return this.uri.equals(uri);
        }
        
        void applyConditionals(final URLConnection urlConnection) {
            if (this.lastModified != 0L) {
                urlConnection.setIfModifiedSince(this.lastModified);
            }
            if (this.entityTags != null && this.entityTags.length() > 0) {
                urlConnection.addRequestProperty("If-None-Match", this.entityTags);
            }
        }
        
        boolean entityNeedsRevalidation() {
            return System.currentTimeMillis() > this.expiry;
        }
    }
}
