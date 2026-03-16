package org.mockito.internal.util.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class GenericMaster {
    public Class<?> getGenericType(Field field) {
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type = ((ParameterizedType) genericType).getActualTypeArguments()[0];
        return type instanceof Class ? (Class) type : type instanceof ParameterizedType ? (Class) ((ParameterizedType) type).getRawType() : Object.class;
    }
}
