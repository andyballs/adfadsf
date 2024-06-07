//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript;

public class ContinuationPending extends RuntimeException
{
    private static final long serialVersionUID = 4956008116771118856L;
    private NativeContinuation continuationState;
    private Object applicationState;
    
    protected ContinuationPending(final NativeContinuation continuationState) {
        this.continuationState = continuationState;
    }
    
    public Object getContinuation() {
        return this.continuationState;
    }
    
    public void setContinuation(final NativeContinuation continuation) {
        this.continuationState = continuation;
    }
    
    NativeContinuation getContinuationState() {
        return this.continuationState;
    }
    
    public void setApplicationState(final Object applicationState) {
        this.applicationState = applicationState;
    }
    
    public Object getApplicationState() {
        return this.applicationState;
    }
}
