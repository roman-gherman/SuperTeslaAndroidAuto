package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0274e0 extends AbstractC0263a1 {
    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean C(AbstractC0286i0 abstractC0286i0, Object obj, Object obj2) {
        synchronized (abstractC0286i0) {
            try {
                if (abstractC0286i0.f2083a != obj) {
                    return false;
                }
                abstractC0286i0.f2083a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean E(AbstractC0286i0 abstractC0286i0, C0283h0 c0283h0, C0283h0 c0283h02) {
        synchronized (abstractC0286i0) {
            try {
                if (abstractC0286i0.c != c0283h0) {
                    return false;
                }
                abstractC0286i0.c = c0283h02;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final C0265b0 c(AbstractC0286i0 abstractC0286i0) {
        C0265b0 c0265b0;
        C0265b0 c0265b02 = C0265b0.d;
        synchronized (abstractC0286i0) {
            c0265b0 = abstractC0286i0.b;
            if (c0265b0 != c0265b02) {
                abstractC0286i0.b = c0265b02;
            }
        }
        return c0265b0;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final C0283h0 n(AbstractC0286i0 abstractC0286i0) {
        C0283h0 c0283h0;
        C0283h0 c0283h02 = C0283h0.c;
        synchronized (abstractC0286i0) {
            c0283h0 = abstractC0286i0.c;
            if (c0283h0 != c0283h02) {
                abstractC0286i0.c = c0283h02;
            }
        }
        return c0283h0;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void r(C0283h0 c0283h0, C0283h0 c0283h02) {
        c0283h0.b = c0283h02;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void t(C0283h0 c0283h0, Thread thread) {
        c0283h0.f2080a = thread;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean y(AbstractC0286i0 abstractC0286i0, C0265b0 c0265b0, C0265b0 c0265b02) {
        synchronized (abstractC0286i0) {
            try {
                if (abstractC0286i0.b != c0265b0) {
                    return false;
                }
                abstractC0286i0.b = c0265b02;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
