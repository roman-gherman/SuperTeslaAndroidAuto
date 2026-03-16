package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class R0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f2844a;

    public R0(Unsafe unsafe) {
        this.f2844a = unsafe;
    }

    public final int a(Class cls) {
        return this.f2844a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f2844a.arrayIndexScale(cls);
    }

    public abstract void c(long j6, byte[] bArr, long j7);

    public abstract boolean d(Object obj, long j6);

    public abstract byte e(long j6);

    public abstract byte f(Object obj, long j6);

    public abstract double g(Object obj, long j6);

    public abstract float h(Object obj, long j6);

    public final int i(Object obj, long j6) {
        return this.f2844a.getInt(obj, j6);
    }

    public final long j(Object obj, long j6) {
        return this.f2844a.getLong(obj, j6);
    }

    public final Object k(Object obj, long j6) {
        return this.f2844a.getObject(obj, j6);
    }

    public final long l(Field field) {
        return this.f2844a.objectFieldOffset(field);
    }

    public abstract void m(Object obj, long j6, boolean z6);

    public abstract void n(Object obj, long j6, byte b);

    public abstract void o(Object obj, long j6, double d);

    public abstract void p(Object obj, long j6, float f6);

    public final void q(Object obj, long j6, int i) {
        this.f2844a.putInt(obj, j6, i);
    }

    public final void r(Object obj, long j6, long j7) {
        this.f2844a.putLong(obj, j6, j7);
    }

    public final void s(Object obj, long j6, Object obj2) {
        this.f2844a.putObject(obj, j6, obj2);
    }

    public boolean t() {
        Unsafe unsafe = this.f2844a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            return true;
        } catch (Throwable th) {
            S0.a(th);
            return false;
        }
    }

    public abstract boolean u();
}
