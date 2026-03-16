package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0292k0 {
    public static /* synthetic */ boolean a(Unsafe unsafe, AbstractC0286i0 abstractC0286i0, long j6, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(abstractC0286i0, j6, obj, obj2)) {
            if (unsafe.getObject(abstractC0286i0, j6) != obj) {
                return false;
            }
        }
        return true;
    }
}
