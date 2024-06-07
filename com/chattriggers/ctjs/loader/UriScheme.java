//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.loader;

import net.minecraftforge.fml.common.*;
import java.util.stream.*;
import com.chattriggers.ctjs.engine.module.*;
import java.net.*;
import java.io.*;

public class UriScheme
{
    private static final String PROTOCOL = "chattriggers://";
    private static final int PORT = 21965;
    private static final String QUOTE = "\"";
    
    public static void main(final String[] args) {
        if (args.length < 1) {
            System.out.println("No URL found, aborting...");
            return;
        }
        if (!args[0].startsWith("chattriggers://")) {
            System.out.println("URL found is not supported, aborting...");
            System.out.println(args[0]);
            return;
        }
        final String url = args[0];
        System.out.println("Trying to work with URL: " + url);
        final String module = url.substring("chattriggers://".length()).replace("/", "");
        try {
            connectWithSockets(module);
        }
        catch (Exception e) {
            copyModuleIn(module);
        }
    }
    
    public static void installUriScheme() {
        try {
            regAdd(" /f /ve /d " + quote("URL:chattriggers Protocol"));
            regAdd(" /f /v " + quote("URL Protocol") + " /d " + quote(""));
            final ModContainer container = Loader.instance().getIndexedModList().get("chattriggers");
            final String modJar = container.getSource().getAbsolutePath();
            final String sep = File.separator;
            final String javaProgram = System.getProperty("java.home") + sep + "bin" + sep + "javaw.exe";
            final String value = ("\"" + javaProgram + "\" -cp \"" + modJar + "\" com.chattriggers.ctjs.loader.UriScheme \"%1\"").replace("\"", "\\\"");
            regAdd("\\shell\\open\\command /f /ve /d \"" + value + "\"");
        }
        catch (Exception e) {
            System.err.println("Unable to install chattriggers URI scheme, disregard if OS is not Windows");
        }
    }
    
    public static void createSocketListener() {
        new Thread(UriScheme::socketListener, "CTJSSocketListener").start();
    }
    
    private static String quote(final String toQuote) {
        return "\"" + toQuote + "\"";
    }
    
    private static void regAdd(final String args) throws IOException, InterruptedException {
        final Process process = Runtime.getRuntime().exec("REG ADD HKCU\\Software\\Classes\\chattriggers" + args);
        if (process.waitFor() != 0) {
            throw new IOException("Error editing registry!");
        }
    }
    
    private static void socketListener() {
        try (final ServerSocket serverSocket = new ServerSocket(21965)) {
            while (!Thread.interrupted()) {
                try (final Socket clientSocket = serverSocket.accept()) {
                    final InputStream inputStream = clientSocket.getInputStream();
                    final String module = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
                    ModuleManager.INSTANCE.importModule(module);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    
    private static void connectWithSockets(final String module) throws Exception {
        final Socket socket = new Socket(InetAddress.getLocalHost(), 21965);
        socket.getOutputStream().write(module.getBytes());
        socket.close();
    }
    
    private static void copyModuleIn(final String module) {
        System.out.println("Adding module named " + module + " to the to download list!");
        final String dataFolder = System.getenv("APPDATA");
        final File modulesDir = new File(dataFolder + "\\.minecraft\\config\\ChatTriggers\\modules");
        final File toDownload = new File(modulesDir, ".to_download.txt");
        try {
            final PrintWriter pw = new PrintWriter(new FileWriter(toDownload, true));
            pw.append(module).append(",");
            pw.close();
        }
        catch (Exception e) {
            System.out.println("Error writing to file.");
        }
    }
}
