package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class C1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f2023a;

    public C1(Unsafe unsafe) {
        this.f2023a = unsafe;
    }

    public abstract double a(Object obj, long j6);

    public abstract float b(Object obj, long j6);

    public abstract void c(Object obj, long j6, boolean z6);

    public abstract void d(Object obj, long j6, byte b);

    public abstract void e(Object obj, long j6, double d);

    public abstract void f(Object obj, long j6, float f6);

    public abstract boolean g(Object obj, long j6);
}
