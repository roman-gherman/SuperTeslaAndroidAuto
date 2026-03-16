package com.google.common.reflect;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface TypeToInstanceMap<B> extends Map<a, B> {
    @NullableDecl
    <T extends B> T getInstance(a aVar);

    @NullableDecl
    <T extends B> T getInstance(Class<T> cls);

    @NullableDecl
    <T extends B> T putInstance(a aVar, @NullableDecl T t6);

    @NullableDecl
    <T extends B> T putInstance(Class<T> cls, @NullableDecl T t6);
}
