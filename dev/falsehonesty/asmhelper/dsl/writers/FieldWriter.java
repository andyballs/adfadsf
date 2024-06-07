//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package dev.falsehonesty.asmhelper.dsl.writers;

import dev.falsehonesty.asmhelper.dsl.*;
import kotlin.*;
import org.jetbrains.annotations.*;
import java.util.*;
import kotlin.jvm.internal.*;
import org.objectweb.asm.tree.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/FieldWriter;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "className", "", "fieldName", "fieldDesc", "initialValue", "", "accessTypes", "", "Ldev/falsehonesty/asmhelper/dsl/writers/AccessType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;)V", "toString", "transform", "", "classNode", "Lorg/objectweb/asm/tree/ClassNode;", "Builder", "AsmHelper1.8.9" })
public final class FieldWriter extends AsmWriter
{
    @NotNull
    private final String fieldName;
    @NotNull
    private final String fieldDesc;
    @Nullable
    private final Object initialValue;
    @NotNull
    private final List<AccessType> accessTypes;
    
    public FieldWriter(@NotNull final String className, @NotNull final String fieldName, @NotNull final String fieldDesc, @Nullable final Object initialValue, @NotNull final List<? extends AccessType> accessTypes) {
        Intrinsics.checkNotNullParameter((Object)className, "className");
        Intrinsics.checkNotNullParameter((Object)fieldName, "fieldName");
        Intrinsics.checkNotNullParameter((Object)fieldDesc, "fieldDesc");
        Intrinsics.checkNotNullParameter((Object)accessTypes, "accessTypes");
        super(className);
        this.fieldName = fieldName;
        this.fieldDesc = fieldDesc;
        this.initialValue = initialValue;
        this.accessTypes = (List<AccessType>)accessTypes;
    }
    
    public void transform(@NotNull final ClassNode classNode) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "classNode"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* classNode */
        //     7: getfield        org/objectweb/asm/tree/ClassNode.fields:Ljava/util/List;
        //    10: aload_0         /* this */
        //    11: getfield        dev/falsehonesty/asmhelper/dsl/writers/FieldWriter.accessTypes:Ljava/util/List;
        //    14: checkcast       Ljava/lang/Iterable;
        //    17: astore_2       
        //    18: iconst_0       
        //    19: istore_3       
        //    20: astore          11
        //    22: iconst_0       
        //    23: istore          $i$f$fold
        //    25: iload_3         /* initial$iv */
        //    26: istore          accumulator$iv
        //    28: aload_2         /* $this$fold$iv */
        //    29: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/Iterator.hasNext:()Z
        //    43: ifeq            82
        //    46: aload           6
        //    48: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    53: astore          element$iv
        //    55: iload           accumulator$iv
        //    57: aload           element$iv
        //    59: checkcast       Ldev/falsehonesty/asmhelper/dsl/writers/AccessType;
        //    62: astore          8
        //    64: istore          acc
        //    66: iconst_0       
        //    67: istore          $i$a$-fold-FieldWriter$transform$1
        //    69: iload           acc
        //    71: aload           accessType
        //    73: invokevirtual   dev/falsehonesty/asmhelper/dsl/writers/AccessType.getOpcode:()I
        //    76: ior            
        //    77: istore          accumulator$iv
        //    79: goto            36
        //    82: iload           accumulator$iv
        //    84: istore          14
        //    86: aload           11
        //    88: iload           14
        //    90: aload_0         /* this */
        //    91: getfield        dev/falsehonesty/asmhelper/dsl/writers/FieldWriter.fieldName:Ljava/lang/String;
        //    94: aload_0         /* this */
        //    95: getfield        dev/falsehonesty/asmhelper/dsl/writers/FieldWriter.fieldDesc:Ljava/lang/String;
        //    98: aconst_null    
        //    99: aload_0         /* this */
        //   100: getfield        dev/falsehonesty/asmhelper/dsl/writers/FieldWriter.initialValue:Ljava/lang/Object;
        //   103: astore          15
        //   105: astore          16
        //   107: astore          17
        //   109: astore          18
        //   111: istore          19
        //   113: new             Lorg/objectweb/asm/tree/FieldNode;
        //   116: dup            
        //   117: iload           19
        //   119: aload           18
        //   121: aload           17
        //   123: aload           16
        //   125: aload           15
        //   127: invokespecial   org/objectweb/asm/tree/FieldNode.<init>:(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
        //   130: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   135: pop            
        //   136: return         
        //    StackMapTable: 00 02 FF 00 24 00 0C 07 00 02 07 00 42 07 00 47 01 01 01 07 00 4D 00 00 00 00 07 00 4F 00 00 2D
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public String toString() {
        return "FieldWriter{className=" + this.getClassName() + ", fieldName=" + this.fieldName + '}';
    }
    
    @Metadata(mv = { 1, 5, 1 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e" }, d2 = { "Ldev/falsehonesty/asmhelper/dsl/writers/FieldWriter$Builder;", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter$AsmWriterBuilder;", "()V", "accessTypes", "", "Ldev/falsehonesty/asmhelper/dsl/writers/AccessType;", "getAccessTypes", "()Ljava/util/List;", "setAccessTypes", "(Ljava/util/List;)V", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "fieldDesc", "getFieldDesc", "setFieldDesc", "fieldName", "getFieldName", "setFieldName", "initialValue", "", "getInitialValue", "()Ljava/lang/Object;", "setInitialValue", "(Ljava/lang/Object;)V", "build", "Ldev/falsehonesty/asmhelper/dsl/AsmWriter;", "AsmHelper1.8.9" })
    public static final class Builder extends AsmWriterBuilder
    {
        @Nullable
        private String className;
        @NotNull
        private List<? extends AccessType> accessTypes;
        @Nullable
        private String fieldName;
        @Nullable
        private String fieldDesc;
        @Nullable
        private Object initialValue;
        
        public Builder() {
            this.accessTypes = (List<? extends AccessType>)CollectionsKt.emptyList();
        }
        
        @Nullable
        public final String getClassName() {
            return this.className;
        }
        
        public final void setClassName(@Nullable final String <set-?>) {
            this.className = <set-?>;
        }
        
        @NotNull
        public final List<AccessType> getAccessTypes() {
            return (List<AccessType>)this.accessTypes;
        }
        
        public final void setAccessTypes(@NotNull final List<? extends AccessType> <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.accessTypes = <set-?>;
        }
        
        @Nullable
        public final String getFieldName() {
            return this.fieldName;
        }
        
        public final void setFieldName(@Nullable final String <set-?>) {
            this.fieldName = <set-?>;
        }
        
        @Nullable
        public final String getFieldDesc() {
            return this.fieldDesc;
        }
        
        public final void setFieldDesc(@Nullable final String <set-?>) {
            this.fieldDesc = <set-?>;
        }
        
        @Nullable
        public final Object getInitialValue() {
            return this.initialValue;
        }
        
        public final void setInitialValue(@Nullable final Object <set-?>) {
            this.initialValue = <set-?>;
        }
        
        @NotNull
        public final AsmWriter build() throws IllegalStateException {
            final String className = this.className;
            if (className == null) {
                throw new IllegalStateException("className must not be null");
            }
            final String className2 = className;
            final String fieldName = this.fieldName;
            if (fieldName == null) {
                throw new IllegalStateException("fieldName must not be null");
            }
            final String fieldName2 = fieldName;
            final String fieldDesc = this.fieldDesc;
            if (fieldDesc == null) {
                throw new IllegalStateException("fieldDesc must not be null");
            }
            return new FieldWriter(className2, fieldName2, fieldDesc, this.initialValue, this.accessTypes);
        }
    }
}
