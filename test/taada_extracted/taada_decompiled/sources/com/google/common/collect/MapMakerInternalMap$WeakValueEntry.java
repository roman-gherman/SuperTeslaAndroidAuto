package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;

/* JADX INFO: loaded from: classes.dex */
interface MapMakerInternalMap$WeakValueEntry<K, V, E extends MapMakerInternalMap$InternalEntry<K, V, E>> extends MapMakerInternalMap$InternalEntry<K, V, E> {
    void clearValue();

    MapMakerInternalMap$WeakValueReference<K, V, E> getValueReference();
}
