package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface Maps$EntryTransformer<K, V1, V2> {
    V2 transformEntry(@NullableDecl K k6, @NullableDecl V1 v12);
}
