package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.f;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
interface MapMakerInternalMap$InternalEntryHelper<K, V, E extends MapMakerInternalMap$InternalEntry<K, V, E>, S extends f> {
    E copy(S s3, E e, @NullableDecl E e6);

    i keyStrength();

    E newEntry(S s3, K k6, int i, @NullableDecl E e);

    S newSegment(j jVar, int i, int i3);

    void setValue(S s3, E e, V v6);

    i valueStrength();
}
