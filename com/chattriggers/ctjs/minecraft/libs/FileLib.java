//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.chattriggers.ctjs.minecraft.libs;

import kotlin.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.*;
import kotlin.io.*;
import java.nio.charset.*;
import org.jetbrains.annotations.*;
import java.net.*;
import java.util.zip.*;
import java.io.*;
import com.chattriggers.ctjs.utils.*;
import java.util.*;
import kotlin.text.*;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u001c\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u0011H\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0007J\"\u0010\"\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u000eH\u0007J*\u0010\"\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u000eH\u0007¨\u0006%" }, d2 = { "Lcom/chattriggers/ctjs/minecraft/libs/FileLib;", "", "()V", "absoluteLocation", "", "importName", "fileLocation", "append", "", "toAppend", "fileName", "decodeBase64", "toDecode", "delete", "", "deleteDirectory", "dir", "Ljava/io/File;", "encodeBase64", "toEncode", "exists", "extractFile", "zipIn", "Ljava/util/zip/ZipInputStream;", "filePath", "getUrlContent", "theUrl", "userAgent", "isDirectory", "read", "file", "unzip", "zipFilePath", "destDirectory", "write", "toWrite", "recursive", "ctjs" })
public final class FileLib
{
    @NotNull
    public static final FileLib INSTANCE;
    
    private FileLib() {
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void write(@NotNull final String importName, @NotNull final String fileName, @NotNull final String toWrite, final boolean recursive) {
        Intrinsics.checkNotNullParameter((Object)importName, "importName");
        Intrinsics.checkNotNullParameter((Object)fileName, "fileName");
        Intrinsics.checkNotNullParameter((Object)toWrite, "toWrite");
        final FileLib instance = FileLib.INSTANCE;
        write(FileLib.INSTANCE.absoluteLocation(importName, fileName), toWrite, recursive);
    }
    
    public static /* synthetic */ void write$default(final String importName, final String fileName, final String toWrite, boolean recursive, final int n, final Object o) {
        if ((n & 0x8) != 0x0) {
            recursive = false;
        }
        write(importName, fileName, toWrite, recursive);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void write(@NotNull final String fileLocation, @NotNull final String toWrite, final boolean recursive) {
        Intrinsics.checkNotNullParameter((Object)fileLocation, "fileLocation");
        Intrinsics.checkNotNullParameter((Object)toWrite, "toWrite");
        final File $this$write_u24lambda_u2d0;
        final File file = $this$write_u24lambda_u2d0 = new File(fileLocation);
        final int n = 0;
        if (recursive && !$this$write_u24lambda_u2d0.exists()) {
            $this$write_u24lambda_u2d0.getParentFile().mkdirs();
        }
        FilesKt.writeText$default(file, toWrite, (Charset)null, 2, (Object)null);
    }
    
    public static /* synthetic */ void write$default(final String fileLocation, final String toWrite, boolean recursive, final int n, final Object o) {
        if ((n & 0x4) != 0x0) {
            recursive = false;
        }
        write(fileLocation, toWrite, recursive);
    }
    
    @JvmStatic
    public static final void append(@NotNull final String importName, @NotNull final String fileName, @NotNull final String toAppend) {
        Intrinsics.checkNotNullParameter((Object)importName, "importName");
        Intrinsics.checkNotNullParameter((Object)fileName, "fileName");
        Intrinsics.checkNotNullParameter((Object)toAppend, "toAppend");
        final FileLib instance = FileLib.INSTANCE;
        append(FileLib.INSTANCE.absoluteLocation(importName, fileName), toAppend);
    }
    
    @JvmStatic
    public static final void append(@NotNull final String fileLocation, @NotNull final String toAppend) {
        Intrinsics.checkNotNullParameter((Object)fileLocation, "fileLocation");
        Intrinsics.checkNotNullParameter((Object)toAppend, "toAppend");
        FilesKt.appendText$default(new File(fileLocation), toAppend, (Charset)null, 2, (Object)null);
    }
    
    @JvmStatic
    @Nullable
    public static final String read(@NotNull final String importName, @NotNull final String fileName) {
        Intrinsics.checkNotNullParameter((Object)importName, "importName");
        Intrinsics.checkNotNullParameter((Object)fileName, "fileName");
        final FileLib instance = FileLib.INSTANCE;
        return read(new File(FileLib.INSTANCE.absoluteLocation(importName, fileName)));
    }
    
    @JvmStatic
    @Nullable
    public static final String read(@NotNull final String fileLocation) {
        Intrinsics.checkNotNullParameter((Object)fileLocation, "fileLocation");
        final FileLib instance = FileLib.INSTANCE;
        return read(new File(fileLocation));
    }
    
    @JvmStatic
    @Nullable
    public static final String read(@NotNull final File file) {
        Intrinsics.checkNotNullParameter((Object)file, "file");
        String text$default;
        try {
            text$default = FilesKt.readText$default(file, (Charset)null, 1, (Object)null);
        }
        catch (Exception e) {
            text$default = null;
        }
        return text$default;
    }
    
    @JvmStatic
    public static final boolean exists(@NotNull final String importName, @NotNull final String fileName) {
        Intrinsics.checkNotNullParameter((Object)importName, "importName");
        Intrinsics.checkNotNullParameter((Object)fileName, "fileName");
        final FileLib instance = FileLib.INSTANCE;
        return exists(FileLib.INSTANCE.absoluteLocation(importName, fileName));
    }
    
    @JvmStatic
    public static final boolean exists(@NotNull final String fileLocation) {
        Intrinsics.checkNotNullParameter((Object)fileLocation, "fileLocation");
        return new File(fileLocation).exists();
    }
    
    @JvmStatic
    public static final boolean isDirectory(@NotNull final String importName, @NotNull final String fileName) {
        Intrinsics.checkNotNullParameter((Object)importName, "importName");
        Intrinsics.checkNotNullParameter((Object)fileName, "fileName");
        final FileLib instance = FileLib.INSTANCE;
        return isDirectory(FileLib.INSTANCE.absoluteLocation(importName, fileName));
    }
    
    @JvmStatic
    public static final boolean isDirectory(@NotNull final String fileLocation) {
        Intrinsics.checkNotNullParameter((Object)fileLocation, "fileLocation");
        return new File(fileLocation).isDirectory();
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String getUrlContent(@NotNull final String theUrl, @Nullable final String userAgent) throws UnknownHostException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "theUrl"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: getstatic       com/chattriggers/ctjs/CTJS.INSTANCE:Lcom/chattriggers/ctjs/CTJS;
        //     9: aload_0         /* theUrl */
        //    10: invokevirtual   com/chattriggers/ctjs/CTJS.makeWebRequest:(Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
        //    13: astore_2        /* conn */
        //    14: aload_2         /* conn */
        //    15: invokevirtual   javax/net/ssl/HttpsURLConnection.getInputStream:()Ljava/io/InputStream;
        //    18: checkcast       Ljava/io/Closeable;
        //    21: astore_3       
        //    22: aconst_null    
        //    23: astore          4
        //    25: nop            
        //    26: aload_3        
        //    27: checkcast       Ljava/io/InputStream;
        //    30: astore          it
        //    32: iconst_0       
        //    33: istore          $i$a$-use-FileLib$getUrlContent$1
        //    35: aload           it
        //    37: ldc             "it"
        //    39: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    42: aload           it
        //    44: invokestatic    kotlin/io/ByteStreamsKt.readBytes:(Ljava/io/InputStream;)[B
        //    47: astore          null
        //    49: aload_3        
        //    50: aload           4
        //    52: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    55: aload           5
        //    57: goto            80
        //    60: astore          5
        //    62: aload           5
        //    64: astore          4
        //    66: aload           5
        //    68: athrow         
        //    69: astore          5
        //    71: aload_3        
        //    72: aload           4
        //    74: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    77: aload           5
        //    79: athrow         
        //    80: ldc             "UTF-8"
        //    82: invokestatic    java/nio/charset/Charset.forName:(Ljava/lang/String;)Ljava/nio/charset/Charset;
        //    85: astore          4
        //    87: aload           4
        //    89: ldc             "forName(\"UTF-8\")"
        //    91: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    94: aload           4
        //    96: astore          7
        //    98: astore          8
        //   100: new             Ljava/lang/String;
        //   103: dup            
        //   104: aload           8
        //   106: aload           7
        //   108: invokespecial   java/lang/String.<init>:([BLjava/nio/charset/Charset;)V
        //   111: areturn        
        //    Exceptions:
        //  throws java.net.UnknownHostException
        //    StackMapTable: 00 03 FF 00 3C 00 05 07 00 83 07 00 83 07 00 9D 07 00 A3 05 00 01 07 00 91 FF 00 08 00 05 07 00 83 07 00 83 07 00 9D 07 00 A3 07 00 91 00 01 07 00 91 FF 00 0A 00 07 07 00 83 07 00 83 07 00 9D 07 00 A3 05 07 00 B8 01 00 01 07 00 B8
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  25     49     60     69     Ljava/lang/Throwable;
        //  25     49     69     80     Any
        //  60     69     69     80     Any
        //  69     71     69     80     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:359)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:504)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visitVariable(StackMappingVisitor.java:470)
        //     at com.strobel.assembler.ir.Instruction.accept(Instruction.java:556)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:403)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.Decompiler.decompile(Decompiler.java:70)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompile(Deobfuscator3000.java:538)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompileAndDeobfuscate(Deobfuscator3000.java:552)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.processMod(Deobfuscator3000.java:510)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.lambda$21(Deobfuscator3000.java:329)
        //     at java.base/java.lang.Thread.run(Thread.java:842)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static /* synthetic */ String getUrlContent$default(final String theUrl, String userAgent, final int n, final Object o) throws UnknownHostException {
        if ((n & 0x2) != 0x0) {
            userAgent = "Mozilla/5.0";
        }
        return getUrlContent(theUrl, userAgent);
    }
    
    @JvmStatic
    public static final boolean delete(@NotNull final String importName, @NotNull final String fileName) {
        Intrinsics.checkNotNullParameter((Object)importName, "importName");
        Intrinsics.checkNotNullParameter((Object)fileName, "fileName");
        final FileLib instance = FileLib.INSTANCE;
        return delete(FileLib.INSTANCE.absoluteLocation(importName, fileName));
    }
    
    @JvmStatic
    public static final boolean delete(@NotNull final String fileLocation) {
        Intrinsics.checkNotNullParameter((Object)fileLocation, "fileLocation");
        return new File(fileLocation).delete();
    }
    
    @JvmStatic
    public static final boolean deleteDirectory(@NotNull final String dir) {
        Intrinsics.checkNotNullParameter((Object)dir, "dir");
        final FileLib instance = FileLib.INSTANCE;
        return deleteDirectory(new File(dir));
    }
    
    @JvmStatic
    public static final boolean deleteDirectory(@NotNull final File dir) {
        Intrinsics.checkNotNullParameter((Object)dir, "dir");
        return FilesKt.deleteRecursively(dir);
    }
    
    @JvmStatic
    public static final void unzip(@NotNull final String zipFilePath, @NotNull final String destDirectory) throws IOException {
        Intrinsics.checkNotNullParameter((Object)zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter((Object)destDirectory, "destDirectory");
        final File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        final ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        for (ZipEntry entry = zipIn.getNextEntry(); entry != null; entry = zipIn.getNextEntry()) {
            final String filePath = destDirectory + (Object)File.separator + (Object)entry.getName();
            if (!entry.isDirectory()) {
                FileLib.INSTANCE.extractFile(zipIn, filePath);
            }
            else {
                final File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
        }
        zipIn.close();
    }
    
    private final void extractFile(final ZipInputStream zipIn, final String filePath) throws IOException {
        final File toWrite = new File(filePath);
        toWrite.getParentFile().mkdirs();
        toWrite.createNewFile();
        final BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        final byte[] bytesIn = new byte[4096];
        for (int read = zipIn.read(bytesIn); read != -1; read = zipIn.read(bytesIn)) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
    
    private final String absoluteLocation(final String importName, final String fileLocation) {
        return Config.INSTANCE.getModulesFolder() + (Object)File.separator + importName + (Object)File.separator + fileLocation;
    }
    
    @JvmStatic
    @NotNull
    public static final String encodeBase64(@NotNull final String toEncode) {
        Intrinsics.checkNotNullParameter((Object)toEncode, "toEncode");
        final Base64.Encoder encoder = Base64.getEncoder();
        final byte[] bytes = toEncode.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)bytes, "this as java.lang.String).getBytes(charset)");
        final String encodeToString = encoder.encodeToString(bytes);
        Intrinsics.checkNotNullExpressionValue((Object)encodeToString, "getEncoder().encodeToStr\u2026g(toEncode.toByteArray())");
        return encodeToString;
    }
    
    @JvmStatic
    @NotNull
    public static final String decodeBase64(@NotNull final String toDecode) {
        Intrinsics.checkNotNullParameter((Object)toDecode, "toDecode");
        final byte[] decode = Base64.getDecoder().decode(toDecode);
        Intrinsics.checkNotNullExpressionValue((Object)decode, "getDecoder().decode(toDecode)");
        return new String(decode, Charsets.UTF_8);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void write(@NotNull final String importName, @NotNull final String fileName, @NotNull final String toWrite) {
        Intrinsics.checkNotNullParameter((Object)importName, "importName");
        Intrinsics.checkNotNullParameter((Object)fileName, "fileName");
        Intrinsics.checkNotNullParameter((Object)toWrite, "toWrite");
        write$default(importName, fileName, toWrite, false, 8, null);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void write(@NotNull final String fileLocation, @NotNull final String toWrite) {
        Intrinsics.checkNotNullParameter((Object)fileLocation, "fileLocation");
        Intrinsics.checkNotNullParameter((Object)toWrite, "toWrite");
        write$default(fileLocation, toWrite, false, 4, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String getUrlContent(@NotNull final String theUrl) throws UnknownHostException {
        Intrinsics.checkNotNullParameter((Object)theUrl, "theUrl");
        return getUrlContent$default(theUrl, null, 2, null);
    }
    
    static {
        INSTANCE = new FileLib();
    }
}
