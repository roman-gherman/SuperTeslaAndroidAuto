package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public interface zaq {
    ExecutorService zaa(ThreadFactory threadFactory, int i);

    ExecutorService zab(int i, int i3);

    ExecutorService zac(int i, ThreadFactory threadFactory, int i3);
}
