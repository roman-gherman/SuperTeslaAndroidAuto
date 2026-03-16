package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class h2 extends AbstractC0263a1 {
    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void h(i2 i2Var, i2 i2Var2) {
        i2Var.b = i2Var2;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void q(i2 i2Var, Thread thread) {
        i2Var.f2090a = thread;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean s(j2 j2Var, C0328w1 c0328w1, C0328w1 c0328w12) {
        synchronized (j2Var) {
            try {
                if (j2Var.b != c0328w1) {
                    return false;
                }
                j2Var.b = c0328w12;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean u(j2 j2Var, Object obj, Object obj2) {
        synchronized (j2Var) {
            try {
                if (j2Var.f2096a != obj) {
                    return false;
                }
                j2Var.f2096a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean z(j2 j2Var, i2 i2Var, i2 i2Var2) {
        synchronized (j2Var) {
            try {
                if (j2Var.c != i2Var) {
                    return false;
                }
                j2Var.c = i2Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
