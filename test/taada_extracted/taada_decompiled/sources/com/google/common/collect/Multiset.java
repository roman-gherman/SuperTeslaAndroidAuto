package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    int add(@NullableDecl E e, int i);

    @Override // java.util.Collection
    boolean add(E e);

    @Override // java.util.Collection
    boolean contains(@NullableDecl Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@NullableDecl Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    @Override // java.util.Collection
    boolean equals(@NullableDecl Object obj);

    @Override // java.util.Collection
    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    int remove(@NullableDecl Object obj, int i);

    @Override // java.util.Collection
    boolean remove(@NullableDecl Object obj);

    @Override // java.util.Collection
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection
    boolean retainAll(Collection<?> collection);

    int setCount(E e, int i);

    boolean setCount(E e, int i, int i3);

    @Override // java.util.Collection
    int size();

    String toString();
}
