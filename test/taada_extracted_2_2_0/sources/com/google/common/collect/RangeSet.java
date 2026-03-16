package com.google.common.collect;

import java.lang.Comparable;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface RangeSet<C extends Comparable> {
    void add(k kVar);

    void addAll(RangeSet<C> rangeSet);

    void addAll(Iterable<k> iterable);

    Set<k> asDescendingSetOfRanges();

    Set<k> asRanges();

    void clear();

    RangeSet<C> complement();

    boolean contains(C c);

    boolean encloses(k kVar);

    boolean enclosesAll(RangeSet<C> rangeSet);

    boolean enclosesAll(Iterable<k> iterable);

    boolean equals(@NullableDecl Object obj);

    int hashCode();

    boolean intersects(k kVar);

    boolean isEmpty();

    k rangeContaining(C c);

    void remove(k kVar);

    void removeAll(RangeSet<C> rangeSet);

    void removeAll(Iterable<k> iterable);

    k span();

    RangeSet<C> subRangeSet(k kVar);

    String toString();
}
