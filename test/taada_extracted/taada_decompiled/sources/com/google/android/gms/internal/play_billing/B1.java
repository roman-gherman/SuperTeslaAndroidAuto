package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class B1 extends C1 {
    @Override // com.google.android.gms.internal.play_billing.C1
    public final double a(Object obj, long j6) {
        return Double.longBitsToDouble(this.f2023a.getLong(obj, j6));
    }

    @Override // com.google.android.gms.internal.play_billing.C1
    public final float b(Object obj, long j6) {
        return Float.intBitsToFloat(this.f2023a.getInt(obj, j6));
    }

    @Override // com.google.android.gms.internal.play_billing.C1
    public final void c(Object obj, long j6, boolean z6) {
        if (D1.f2027g) {
            D1.b(obj, j6, z6 ? (byte) 1 : (byte) 0);
        } else {
            D1.c(obj, j6, z6 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.C1
    public final void d(Object obj, long j6, byte b) {
        if (D1.f2027g) {
            D1.b(obj, j6, b);
        } else {
            D1.c(obj, j6, b);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.C1
    public final void e(Object obj, long j6, double d) {
        this.f2023a.putLong(obj, j6, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.C1
    public final void f(Object obj, long j6, float f6) {
        this.f2023a.putInt(obj, j6, Float.floatToIntBits(f6));
    }

    @Override // com.google.android.gms.internal.play_billing.C1
    public final boolean g(Object obj, long j6) {
        return D1.f2027g ? D1.l(obj, j6) : D1.m(obj, j6);
    }
}
