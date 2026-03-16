package com.google.common.cache;

import com.google.common.collect.e;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface Cache<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K k6, Callable<? extends V> callable);

    e getAllPresent(Iterable<?> iterable);

    @NullableDecl
    V getIfPresent(Object obj);

    void invalidate(Object obj);

    void invalidateAll();

    void invalidateAll(Iterable<?> iterable);

    void put(K k6, V v6);

    void putAll(Map<? extends K, ? extends V> map);

    long size();

    b stats();
}
