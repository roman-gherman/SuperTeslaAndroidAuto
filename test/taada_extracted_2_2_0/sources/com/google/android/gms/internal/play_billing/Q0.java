package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class Q0 extends R0 {
    public final int d;

    public Q0(byte[] bArr, int i) {
        super(bArr);
        S0.d(0, i, bArr.length);
        this.d = i;
    }

    @Override // com.google.android.gms.internal.play_billing.R0, com.google.android.gms.internal.play_billing.S0
    public final byte a(int i) {
        int i3 = this.d;
        if (((i3 - (i + 1)) | i) >= 0) {
            return this.c[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(B2.b.c(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("Index > length: ", i, ", ", i3));
    }

    @Override // com.google.android.gms.internal.play_billing.R0, com.google.android.gms.internal.play_billing.S0
    public final byte b(int i) {
        return this.c[i];
    }

    @Override // com.google.android.gms.internal.play_billing.R0, com.google.android.gms.internal.play_billing.S0
    public final int c() {
        return this.d;
    }
}
