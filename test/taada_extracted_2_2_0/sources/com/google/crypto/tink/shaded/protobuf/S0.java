package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class S0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f2845a;
    public static final Class b;
    public static final R0 c;
    public static final boolean d;
    public static final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f2846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f2847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f2848h;

    static {
        Unsafe unsafeJ = j();
        f2845a = unsafeJ;
        b = AbstractC0361e.f2875a;
        boolean zF = f(Long.TYPE);
        boolean zF2 = f(Integer.TYPE);
        R0 q02 = null;
        if (unsafeJ != null) {
            if (!AbstractC0361e.a()) {
                q02 = new Q0(unsafeJ);
            } else if (zF) {
                q02 = new P0(unsafeJ, 1);
            } else if (zF2) {
                q02 = new P0(unsafeJ, 0);
            }
        }
        c = q02;
        d = q02 == null ? false : q02.u();
        e = q02 == null ? false : q02.t();
        f2846f = c(byte[].class);
        c(boolean[].class);
        d(boolean[].class);
        c(int[].class);
        d(int[].class);
        c(long[].class);
        d(long[].class);
        c(float[].class);
        d(float[].class);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field fieldE = e();
        f2847g = (fieldE == null || q02 == null) ? -1L : q02.l(fieldE);
        f2848h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(S0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static Object b(Class cls) {
        try {
            return f2845a.allocateInstance(cls);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(e6);
        }
    }

    public static int c(Class cls) {
        if (e) {
            return c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (e) {
            c.b(cls);
        }
    }

    public static Field e() {
        Field declaredField;
        Field declaredField2;
        if (AbstractC0361e.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean f(Class cls) {
        if (!AbstractC0361e.a()) {
            return false;
        }
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

    public static byte g(byte[] bArr, long j6) {
        return c.f(bArr, f2846f + j6);
    }

    public static byte h(Object obj, long j6) {
        return (byte) ((c.i(obj, (-4) & j6) >>> ((int) (((~j6) & 3) << 3))) & 255);
    }

    public static byte i(Object obj, long j6) {
        return (byte) ((c.i(obj, (-4) & j6) >>> ((int) ((j6 & 3) << 3))) & 255);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new O0());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(byte[] bArr, long j6, byte b2) {
        c.n(bArr, f2846f + j6, b2);
    }

    public static void l(Object obj, long j6, byte b2) {
        long j7 = (-4) & j6;
        int i = c.i(obj, j7);
        int i3 = ((~((int) j6)) & 3) << 3;
        n(obj, j7, ((255 & b2) << i3) | (i & (~(255 << i3))));
    }

    public static void m(Object obj, long j6, byte b2) {
        long j7 = (-4) & j6;
        int i = (((int) j6) & 3) << 3;
        n(obj, j7, ((255 & b2) << i) | (c.i(obj, j7) & (~(255 << i))));
    }

    public static void n(Object obj, long j6, int i) {
        c.q(obj, j6, i);
    }

    public static void o(Object obj, long j6, long j7) {
        c.r(obj, j6, j7);
    }

    public static void p(Object obj, long j6, Object obj2) {
        c.s(obj, j6, obj2);
    }
}
