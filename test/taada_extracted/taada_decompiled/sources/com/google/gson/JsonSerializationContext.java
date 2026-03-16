package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JsonSerializationContext {
    p serialize(Object obj);

    p serialize(Object obj, Type type);
}
