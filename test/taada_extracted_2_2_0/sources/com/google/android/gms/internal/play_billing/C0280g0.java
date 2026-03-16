package com.google.android.gms.internal.play_billing;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0280g0 extends AbstractC0263a1 {
    public static final Unsafe b;
    public static final long c;
    public static final long d;
    public static final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f2078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f2079g;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e6) {
                throw new RuntimeException("Could not initialize intrinsics", e6.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new C0277f0());
        }
        try {
            d = unsafe.objectFieldOffset(AbstractC0286i0.class.getDeclaredField("c"));
            c = unsafe.objectFieldOffset(AbstractC0286i0.class.getDeclaredField("b"));
            e = unsafe.objectFieldOffset(AbstractC0286i0.class.getDeclaredField("a"));
            f2078f = unsafe.objectFieldOffset(C0283h0.class.getDeclaredField("a"));
            f2079g = unsafe.objectFieldOffset(C0283h0.class.getDeclaredField("b"));
            b = unsafe;
        } catch (NoSuchFieldException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean C(AbstractC0286i0 abstractC0286i0, Object obj, Object obj2) {
        return AbstractC0295l0.a(b, abstractC0286i0, e, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean E(AbstractC0286i0 abstractC0286i0, C0283h0 c0283h0, C0283h0 c0283h02) {
        return AbstractC0295l0.a(b, abstractC0286i0, d, c0283h0, c0283h02);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final C0265b0 c(AbstractC0286i0 abstractC0286i0) {
        C0265b0 c0265b0;
        C0265b0 c0265b02 = C0265b0.d;
        do {
            c0265b0 = abstractC0286i0.b;
            if (c0265b02 == c0265b0) {
                break;
            }
        } while (!y(abstractC0286i0, c0265b0, c0265b02));
        return c0265b0;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final C0283h0 n(AbstractC0286i0 abstractC0286i0) {
        C0283h0 c0283h0;
        C0283h0 c0283h02 = C0283h0.c;
        do {
            c0283h0 = abstractC0286i0.c;
            if (c0283h02 == c0283h0) {
                break;
            }
        } while (!E(abstractC0286i0, c0283h0, c0283h02));
        return c0283h0;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void r(C0283h0 c0283h0, C0283h0 c0283h02) {
        b.putObject(c0283h0, f2079g, c0283h02);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void t(C0283h0 c0283h0, Thread thread) {
        b.putObject(c0283h0, f2078f, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean y(AbstractC0286i0 abstractC0286i0, C0265b0 c0265b0, C0265b0 c0265b02) {
        return AbstractC0295l0.a(b, abstractC0286i0, c, c0265b0, c0265b02);
    }
}
