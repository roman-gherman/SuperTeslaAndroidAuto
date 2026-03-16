package com.google.android.gms.internal.play_billing;

import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class T0 extends V0 {
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2053g;

    public T0(byte[] bArr, int i) {
        super(11);
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.n("Array range is invalid. Buffer.length=", length, ", offset=0, length=", i));
        }
        this.e = bArr;
        this.f2053g = 0;
        this.f2052f = i;
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void N(int i, S0 s02) {
        X((i << 3) | 2);
        X(s02.c());
        R0 r02 = (R0) s02;
        c0(r02.c(), r02.c);
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void O(int i, int i3) throws U0 {
        X((i << 3) | 5);
        P(i3);
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void P(int i) throws U0 {
        int i3 = this.f2053g;
        try {
            byte[] bArr = this.e;
            bArr[i3] = (byte) (i & 255);
            bArr[i3 + 1] = (byte) ((i >> 8) & 255);
            bArr[i3 + 2] = (byte) ((i >> 16) & 255);
            bArr[i3 + 3] = (byte) ((i >> 24) & 255);
            this.f2053g = i3 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new U0(i3, this.f2052f, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void Q(int i, long j6) throws U0 {
        X((i << 3) | 1);
        R(j6);
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void R(long j6) throws U0 {
        int i = this.f2053g;
        try {
            byte[] bArr = this.e;
            bArr[i] = (byte) (((int) j6) & 255);
            bArr[i + 1] = (byte) (((int) (j6 >> 8)) & 255);
            bArr[i + 2] = (byte) (((int) (j6 >> 16)) & 255);
            bArr[i + 3] = (byte) (((int) (j6 >> 24)) & 255);
            bArr[i + 4] = (byte) (((int) (j6 >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j6 >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j6 >> 48)) & 255);
            bArr[i + 7] = (byte) (((int) (j6 >> 56)) & 255);
            this.f2053g = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new U0(i, this.f2052f, 8, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void S(int i, int i3) throws U0 {
        X(i << 3);
        T(i3);
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void T(int i) throws U0 {
        if (i >= 0) {
            X(i);
        } else {
            Z(i);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void U(int i, String str) throws U0 {
        X((i << 3) | 2);
        int i3 = this.f2053g;
        try {
            int iB0 = V0.b0(str.length() * 3);
            int iB02 = V0.b0(str.length());
            byte[] bArr = this.e;
            int i4 = this.f2052f;
            if (iB02 != iB0) {
                X(F1.c(str));
                int i5 = this.f2053g;
                this.f2053g = F1.b(i5, i4 - i5, str, bArr);
            } else {
                int i6 = i3 + iB02;
                this.f2053g = i6;
                int iB = F1.b(i6, i4 - i6, str, bArr);
                this.f2053g = i3;
                X((iB - i3) - iB02);
                this.f2053g = iB;
            }
        } catch (E1 e) {
            this.f2053g = i3;
            V0.c.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e);
            byte[] bytes = str.getBytes(AbstractC0278f1.f2076a);
            try {
                int length = bytes.length;
                X(length);
                c0(length, bytes);
            } catch (IndexOutOfBoundsException e6) {
                throw new U0(e6);
            }
        } catch (IndexOutOfBoundsException e7) {
            throw new U0(e7);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void V(int i, int i3) {
        X((i << 3) | i3);
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void W(int i, int i3) {
        X(i << 3);
        X(i3);
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void X(int i) {
        while (true) {
            int i3 = i & (-128);
            byte[] bArr = this.e;
            if (i3 == 0) {
                int i4 = this.f2053g;
                this.f2053g = i4 + 1;
                bArr[i4] = (byte) i;
                return;
            } else {
                try {
                    int i5 = this.f2053g;
                    this.f2053g = i5 + 1;
                    bArr[i5] = (byte) ((i | 128) & 255);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new U0(this.f2053g, this.f2052f, 1, e);
                }
            }
            throw new U0(this.f2053g, this.f2052f, 1, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void Y(int i, long j6) throws U0 {
        X(i << 3);
        Z(j6);
    }

    @Override // com.google.android.gms.internal.play_billing.V0
    public final void Z(long j6) throws U0 {
        byte[] bArr = this.e;
        boolean z6 = V0.d;
        int i = this.f2052f;
        if (!z6 || i - this.f2053g < 10) {
            while ((j6 & (-128)) != 0) {
                try {
                    int i3 = this.f2053g;
                    this.f2053g = i3 + 1;
                    bArr[i3] = (byte) ((((int) j6) | 128) & 255);
                    j6 >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new U0(this.f2053g, i, 1, e);
                }
            }
            int i4 = this.f2053g;
            this.f2053g = i4 + 1;
            bArr[i4] = (byte) j6;
            return;
        }
        while (true) {
            int i5 = (int) j6;
            if ((j6 & (-128)) == 0) {
                int i6 = this.f2053g;
                this.f2053g = i6 + 1;
                D1.c.d(bArr, D1.f2026f + ((long) i6), (byte) i5);
                return;
            }
            int i7 = this.f2053g;
            this.f2053g = i7 + 1;
            D1.c.d(bArr, D1.f2026f + i7, (byte) ((i5 | 128) & 255));
            j6 >>>= 7;
        }
    }

    public final void c0(int i, byte[] bArr) throws U0 {
        try {
            System.arraycopy(bArr, 0, this.e, this.f2053g, i);
            this.f2053g += i;
        } catch (IndexOutOfBoundsException e) {
            throw new U0(this.f2053g, this.f2052f, i, e);
        }
    }
}
