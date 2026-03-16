package com.google.android.gms.internal.play_billing;

import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class D1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f2025a;
    public static final Class b;
    public static final C1 c;
    public static final boolean d;
    public static final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f2026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f2027g;

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0168 A[PHI: r0
      0x0168: PHI (r0v41 java.lang.reflect.Field) = (r0v34 java.lang.reflect.Field), (r0v36 java.lang.reflect.Field) binds: [B:44:0x0158, B:50:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.D1.<clinit>():void");
    }

    public static void a(Class cls) {
        if (e) {
            c.f2023a.arrayIndexScale(cls);
        }
    }

    public static void b(Object obj, long j6, byte b2) {
        C1 c12 = c;
        long j7 = (-4) & j6;
        int i = c12.f2023a.getInt(obj, j7);
        int i3 = ((~((int) j6)) & 3) << 3;
        c12.f2023a.putInt(obj, j7, ((255 & b2) << i3) | (i & (~(255 << i3))));
    }

    public static void c(Object obj, long j6, byte b2) {
        C1 c12 = c;
        long j7 = (-4) & j6;
        int i = (((int) j6) & 3) << 3;
        c12.f2023a.putInt(obj, j7, ((255 & b2) << i) | (c12.f2023a.getInt(obj, j7) & (~(255 << i))));
    }

    public static int d(Object obj, long j6) {
        return c.f2023a.getInt(obj, j6);
    }

    public static long e(Object obj, long j6) {
        return c.f2023a.getLong(obj, j6);
    }

    public static Object f(Class cls) {
        try {
            return f2025a.allocateInstance(cls);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(e6);
        }
    }

    public static Object g(Object obj, long j6) {
        return c.f2023a.getObject(obj, j6);
    }

    public static Unsafe h() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C0337z1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void i(Object obj, long j6, int i) {
        c.f2023a.putInt(obj, j6, i);
    }

    public static void j(Object obj, long j6, long j7) {
        c.f2023a.putLong(obj, j6, j7);
    }

    public static void k(long j6, Object obj, Object obj2) {
        c.f2023a.putObject(obj, j6, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean l(Object obj, long j6) {
        return ((byte) ((c.f2023a.getInt(obj, (-4) & j6) >>> ((int) (((~j6) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean m(Object obj, long j6) {
        return ((byte) ((c.f2023a.getInt(obj, (-4) & j6) >>> ((int) ((j6 & 3) << 3))) & 255)) != 0;
    }

    public static boolean n(Class cls) {
        int i = M0.f2045a;
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int o(Class cls) {
        if (e) {
            return c.f2023a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
