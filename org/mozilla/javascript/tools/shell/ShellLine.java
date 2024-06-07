//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.*;
import java.io.*;
import java.nio.charset.*;

@Deprecated
public class ShellLine
{
    @Deprecated
    public static InputStream getStream(final Scriptable scope) {
        final ShellConsole console = ShellConsole.getConsole(scope, Charset.defaultCharset());
        return (console != null) ? console.getIn() : null;
    }
}
