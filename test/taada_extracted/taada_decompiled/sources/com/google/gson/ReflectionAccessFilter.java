package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = new x(0);
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = new x(1);
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = new x(2);
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = new x(3);

    y check(Class<?> cls);
}
