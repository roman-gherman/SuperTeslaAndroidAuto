package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0320u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f2127a;
    public int b;
    public boolean c;

    public AbstractC0320u() {
        AbstractC0263a1.g(4, "initialCapacity");
        this.f2127a = new Object[4];
        this.b = 0;
    }

    public static int b(int i, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i3 <= i) {
            return i;
        }
        int i4 = i + (i >> 1) + 1;
        if (i4 < i3) {
            int iHighestOneBit = Integer.highestOneBit(i3 - 1);
            i4 = iHighestOneBit + iHighestOneBit;
        }
        if (i4 < 0) {
            return Integer.MAX_VALUE;
        }
        return i4;
    }

    public final void a(Object obj) {
        obj.getClass();
        c(1);
        Object[] objArr = this.f2127a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
    }

    public final void c(int i) {
        int length = this.f2127a.length;
        int iB = b(length, this.b + i);
        if (iB > length || this.c) {
            this.f2127a = Arrays.copyOf(this.f2127a, iB);
            this.c = false;
        }
    }
}
