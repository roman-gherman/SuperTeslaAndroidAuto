package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
interface SortedIterable<T> extends Iterable<T> {
    Comparator<? super T> comparator();

    @Override // java.lang.Iterable
    Iterator<T> iterator();
}
