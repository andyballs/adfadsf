//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package org.mozilla.classfile;

final class TypeInfo
{
    static final int TOP = 0;
    static final int INTEGER = 1;
    static final int FLOAT = 2;
    static final int DOUBLE = 3;
    static final int LONG = 4;
    static final int NULL = 5;
    static final int UNINITIALIZED_THIS = 6;
    static final int OBJECT_TAG = 7;
    static final int UNINITIALIZED_VAR_TAG = 8;
    
    private TypeInfo() {
    }
    
    static final int OBJECT(final int constantPoolIndex) {
        return (constantPoolIndex & 0xFFFF) << 8 | 0x7;
    }
    
    static final int OBJECT(final String type, final ConstantPool pool) {
        return OBJECT(pool.addClass(type));
    }
    
    static final int UNINITIALIZED_VARIABLE(final int bytecodeOffset) {
        return (bytecodeOffset & 0xFFFF) << 8 | 0x8;
    }
    
    static final int getTag(final int typeInfo) {
        return typeInfo & 0xFF;
    }
    
    static final int getPayload(final int typeInfo) {
        return typeInfo >>> 8;
    }
    
    static final String getPayloadAsType(final int typeInfo, final ConstantPool pool) {
        if (getTag(typeInfo) == 7) {
            return (String)pool.getConstantData(getPayload(typeInfo));
        }
        throw new IllegalArgumentException("expecting object type");
    }
    
    static final int fromType(final String type, final ConstantPool pool) {
        if (type.length() != 1) {
            return OBJECT(type, pool);
        }
        switch (type.charAt(0)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z': {
                return 1;
            }
            case 'D': {
                return 3;
            }
            case 'F': {
                return 2;
            }
            case 'J': {
                return 4;
            }
            default: {
                throw new IllegalArgumentException("bad type");
            }
        }
    }
    
    static boolean isTwoWords(final int type) {
        return type == 3 || type == 4;
    }
    
    static int merge(final int current, final int incoming, final ConstantPool pool) {
        final int currentTag = getTag(current);
        final int incomingTag = getTag(incoming);
        final boolean currentIsObject = currentTag == 7;
        final boolean incomingIsObject = incomingTag == 7;
        if (current == incoming || (currentIsObject && incoming == 5)) {
            return current;
        }
        if (currentTag == 0 || incomingTag == 0) {
            return 0;
        }
        if (current == 5 && incomingIsObject) {
            return incoming;
        }
        if (currentIsObject && incomingIsObject) {
            String currentName = getPayloadAsType(current, pool);
            String incomingName = getPayloadAsType(incoming, pool);
            final String currentlyGeneratedName = (String)pool.getConstantData(2);
            final String currentlyGeneratedSuperName = (String)pool.getConstantData(4);
            if (currentName.equals(currentlyGeneratedName)) {
                currentName = currentlyGeneratedSuperName;
            }
            if (incomingName.equals(currentlyGeneratedName)) {
                incomingName = currentlyGeneratedSuperName;
            }
            final Class<?> currentClass = getClassFromInternalName(currentName);
            final Class<?> incomingClass = getClassFromInternalName(incomingName);
            if (currentClass.isAssignableFrom(incomingClass)) {
                return current;
            }
            if (incomingClass.isAssignableFrom(currentClass)) {
                return incoming;
            }
            if (incomingClass.isInterface() || currentClass.isInterface()) {
                return OBJECT("java/lang/Object", pool);
            }
            for (Class<?> commonClass = incomingClass.getSuperclass(); commonClass != null; commonClass = commonClass.getSuperclass()) {
                if (commonClass.isAssignableFrom(currentClass)) {
                    String name = commonClass.getName();
                    name = ClassFileWriter.getSlashedForm(name);
                    return OBJECT(name, pool);
                }
            }
        }
        throw new IllegalArgumentException("bad merge attempt between " + toString(current, pool) + " and " + toString(incoming, pool));
    }
    
    static String toString(final int type, final ConstantPool pool) {
        final int tag = getTag(type);
        switch (tag) {
            case 0: {
                return "top";
            }
            case 1: {
                return "int";
            }
            case 2: {
                return "float";
            }
            case 3: {
                return "double";
            }
            case 4: {
                return "long";
            }
            case 5: {
                return "null";
            }
            case 6: {
                return "uninitialized_this";
            }
            default: {
                if (tag == 7) {
                    return getPayloadAsType(type, pool);
                }
                if (tag == 8) {
                    return "uninitialized";
                }
                throw new IllegalArgumentException("bad type");
            }
        }
    }
    
    private static Class<?> getClassFromInternalName(final String internalName) {
        try {
            return Class.forName(internalName.replace('/', '.'));
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static String toString(final int[] types, final int typesTop, final ConstantPool pool) {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < typesTop; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(toString(types[i], pool));
        }
        sb.append("]");
        return sb.toString();
    }
    
    static void print(final int[] locals, final int[] stack, final ConstantPool pool) {
        print(locals, locals.length, stack, stack.length, pool);
    }
    
    static void print(final int[] locals, final int localsTop, final int[] stack, final int stackTop, final ConstantPool pool) {
        System.out.print("locals: ");
        System.out.println(toString(locals, localsTop, pool));
        System.out.print("stack: ");
        System.out.println(toString(stack, stackTop, pool));
        System.out.println();
    }
}
