package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class U extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3215h;

    public U(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f3215h = E1.k.B(409, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[7];
        long[] jArr2 = new long[13];
        AbstractC0447b.u(this.f3215h, jArr2);
        AbstractC0447b.a0(jArr2, jArr);
        return new U(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        byte[] bArr = new byte[56];
        for (int i = 0; i < 7; i++) {
            long j6 = this.f3215h[i];
            if (j6 != 0) {
                g5.c.t(bArr, (6 - i) << 3, j6);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[7];
        long[] jArr2 = this.f3215h;
        for (int i = 0; i < 7; i++) {
            if (jArr2[i] != 0) {
                long[] jArr3 = new long[7];
                long[] jArr4 = new long[7];
                long[] jArr5 = new long[7];
                long[] jArr6 = new long[13];
                AbstractC0447b.u(jArr2, jArr6);
                AbstractC0447b.a0(jArr6, jArr3);
                AbstractC0447b.n0(jArr3, 1, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr3);
                AbstractC0447b.n0(jArr4, 1, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr3);
                AbstractC0447b.n0(jArr3, 3, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr3);
                AbstractC0447b.n0(jArr3, 6, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr3);
                AbstractC0447b.n0(jArr3, 12, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr5);
                AbstractC0447b.n0(jArr5, 24, jArr3);
                AbstractC0447b.n0(jArr3, 24, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr3);
                AbstractC0447b.n0(jArr3, 48, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr3);
                AbstractC0447b.n0(jArr3, 96, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr3);
                AbstractC0447b.n0(jArr3, 192, jArr4);
                AbstractC0447b.H(jArr3, jArr4, jArr3);
                AbstractC0447b.H(jArr3, jArr5, jArr);
                return new U(jArr);
            }
        }
        throw new IllegalStateException();
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        long[] jArr = this.f3215h;
        if (jArr[0] == 1) {
            for (int i = 1; i < 7; i++) {
                if (jArr[i] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = ((U) abstractC0246d).f3215h;
        long[] jArr2 = this.f3215h;
        return new U(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3], jArr2[4] ^ jArr[4], jArr2[5] ^ jArr[5], jArr2[6] ^ jArr[6]});
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        long[] jArr = this.f3215h;
        for (int i = 0; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof U)) {
            return false;
        }
        long[] jArr = ((U) obj).f3215h;
        for (int i = 6; i >= 0; i--) {
            if (this.f3215h[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[7];
        AbstractC0447b.H(this.f3215h, ((U) abstractC0246d).f3215h, jArr);
        return new U(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3215h, 7) ^ 4090087;
    }

    public U(long[] jArr) {
        this.f3215h = jArr;
    }
}
