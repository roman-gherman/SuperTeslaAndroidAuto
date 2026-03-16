package com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
interface LocalCache$ValueReference<K, V> {
    LocalCache$ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v6, ReferenceEntry<K, V> referenceEntry);

    @NullableDecl
    V get();

    @NullableDecl
    ReferenceEntry<K, V> getEntry();

    int getWeight();

    boolean isActive();

    boolean isLoading();

    void notifyNewValue(@NullableDecl V v6);

    V waitForValue();
}
