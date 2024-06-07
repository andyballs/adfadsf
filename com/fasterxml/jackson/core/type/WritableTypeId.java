//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\murra\Downloads\Minecraft-Deobfuscator3000-1.2.3(1)\conf"!

//Decompiled by Procyon!

package com.fasterxml.jackson.core.type;

import com.fasterxml.jackson.core.*;

public class WritableTypeId
{
    public Object forValue;
    public Class<?> forValueType;
    public Object id;
    public String asProperty;
    public Inclusion include;
    public JsonToken valueShape;
    public boolean wrapperWritten;
    public Object extra;
    
    public WritableTypeId() {
    }
    
    public WritableTypeId(final Object value, final JsonToken valueShape) {
        this(value, valueShape, null);
    }
    
    public WritableTypeId(final Object value, final Class<?> valueType, final JsonToken valueShape) {
        this(value, valueShape, null);
        this.forValueType = valueType;
    }
    
    public WritableTypeId(final Object value, final JsonToken valueShape, final Object id) {
        this.forValue = value;
        this.id = id;
        this.valueShape = valueShape;
    }
    
    public enum Inclusion
    {
        WRAPPER_ARRAY, 
        WRAPPER_OBJECT, 
        METADATA_PROPERTY, 
        PAYLOAD_PROPERTY, 
        PARENT_PROPERTY;
        
        public boolean requiresObjectContext() {
            return this == Inclusion.METADATA_PROPERTY || this == Inclusion.PAYLOAD_PROPERTY;
        }
    }
}
