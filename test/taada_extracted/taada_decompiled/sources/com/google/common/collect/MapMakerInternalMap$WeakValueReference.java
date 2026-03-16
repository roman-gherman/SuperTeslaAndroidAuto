package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import java.lang.ref.ReferenceQueue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
interface MapMakerInternalMap$WeakValueReference<K, V, E extends MapMakerInternalMap$InternalEntry<K, V, E>> {
    void clear();

    MapMakerInternalMap$WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e);

    @NullableDecl
    V get();

    E getEntry();
}
