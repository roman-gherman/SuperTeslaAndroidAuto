package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JsonSerializer<T> {
    p serialize(T t6, Type type, JsonSerializationContext jsonSerializationContext);
}
