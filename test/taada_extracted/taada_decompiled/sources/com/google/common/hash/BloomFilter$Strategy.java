package com.google.common.hash;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
interface BloomFilter$Strategy extends Serializable {
    <T> boolean mightContain(T t6, Funnel<? super T> funnel, int i, a aVar);

    int ordinal();

    <T> boolean put(T t6, Funnel<? super T> funnel, int i, a aVar);
}
