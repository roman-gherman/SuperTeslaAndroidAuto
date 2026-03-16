package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes.dex */
interface CycleDetectingLockFactory$CycleDetectingLock {
    a getLockGraphNode();

    boolean isAcquiredByCurrentThread();
}
