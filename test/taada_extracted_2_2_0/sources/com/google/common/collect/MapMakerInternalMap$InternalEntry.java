package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;

/* JADX INFO: loaded from: classes.dex */
interface MapMakerInternalMap$InternalEntry<K, V, E extends MapMakerInternalMap$InternalEntry<K, V, E>> {
    int getHash();

    K getKey();

    E getNext();

    V getValue();
}
