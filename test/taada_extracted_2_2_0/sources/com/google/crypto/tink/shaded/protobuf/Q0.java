package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class Q0 extends R0 {
    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void c(long j6, byte[] bArr, long j7) {
        this.f2844a.copyMemory((Object) null, j6, bArr, S0.f2846f, j7);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final boolean d(Object obj, long j6) {
        return this.f2844a.getBoolean(obj, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final byte e(long j6) {
        return this.f2844a.getByte(j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final byte f(Object obj, long j6) {
        return this.f2844a.getByte(obj, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final double g(Object obj, long j6) {
        return this.f2844a.getDouble(obj, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final float h(Object obj, long j6) {
        return this.f2844a.getFloat(obj, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void m(Object obj, long j6, boolean z6) {
        this.f2844a.putBoolean(obj, j6, z6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void n(Object obj, long j6, byte b) {
        this.f2844a.putByte(obj, j6, b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void o(Object obj, long j6, double d) {
        this.f2844a.putDouble(obj, j6, d);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void p(Object obj, long j6, float f6) {
        this.f2844a.putFloat(obj, j6, f6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final boolean t() {
        if (!super.t()) {
            return false;
        }
        try {
            Class<?> cls = this.f2844a.getClass();
            Class cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            S0.a(th);
            return false;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final boolean u() {
        Unsafe unsafe = this.f2844a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (S0.e() != null) {
                    try {
                        Class<?> cls3 = this.f2844a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        S0.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                S0.a(th2);
            }
        }
        return false;
    }
}
