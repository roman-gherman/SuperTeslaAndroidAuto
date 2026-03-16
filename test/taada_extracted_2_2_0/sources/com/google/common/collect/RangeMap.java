package com.google.common.collect;

import java.lang.Comparable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface RangeMap<K extends Comparable, V> {
    Map<k, V> asDescendingMapOfRanges();

    Map<k, V> asMapOfRanges();

    void clear();

    boolean equals(@NullableDecl Object obj);

    @NullableDecl
    V get(K k6);

    @NullableDecl
    Map.Entry<k, V> getEntry(K k6);

    int hashCode();

    void put(k kVar, V v6);

    void putAll(RangeMap<K, V> rangeMap);

    void putCoalescing(k kVar, V v6);

    void remove(k kVar);

    k span();

    RangeMap<K, V> subRangeMap(k kVar);

    String toString();
}
