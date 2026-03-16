package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.collect.e;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
    @Override // com.google.common.base.Function
    @Deprecated
    V apply(K k6);

    @Override // com.google.common.cache.Cache
    ConcurrentMap<K, V> asMap();

    V get(K k6);

    e getAll(Iterable<? extends K> iterable);

    V getUnchecked(K k6);

    void refresh(K k6);
}
