package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class Q extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3212h;

    public Q(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.f3212h = E1.k.B(283, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[5];
        AbstractC0447b.e0(this.f3212h, jArr);
        return new Q(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        byte[] bArr = new byte[40];
        for (int i = 0; i < 5; i++) {
            long j6 = this.f3212h[i];
            if (j6 != 0) {
                g5.c.t(bArr, (4 - i) << 3, j6);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[5];
        long[] jArr2 = this.f3212h;
        for (int i = 0; i < 5; i++) {
            if (jArr2[i] != 0) {
                long[] jArr3 = new long[5];
                long[] jArr4 = new long[5];
                AbstractC0447b.e0(jArr2, jArr3);
                AbstractC0447b.G(jArr3, jArr2, jArr3);
                AbstractC0447b.m0(jArr3, 2, jArr4);
                AbstractC0447b.G(jArr4, jArr3, jArr4);
                AbstractC0447b.m0(jArr4, 4, jArr3);
                AbstractC0447b.G(jArr3, jArr4, jArr3);
                AbstractC0447b.m0(jArr3, 8, jArr4);
                AbstractC0447b.G(jArr4, jArr3, jArr4);
                AbstractC0447b.e0(jArr4, jArr4);
                AbstractC0447b.G(jArr4, jArr2, jArr4);
                AbstractC0447b.m0(jArr4, 17, jArr3);
                AbstractC0447b.G(jArr3, jArr4, jArr3);
                AbstractC0447b.e0(jArr3, jArr3);
                AbstractC0447b.G(jArr3, jArr2, jArr3);
                AbstractC0447b.m0(jArr3, 35, jArr4);
                AbstractC0447b.G(jArr4, jArr3, jArr4);
                AbstractC0447b.m0(jArr4, 70, jArr3);
                AbstractC0447b.G(jArr3, jArr4, jArr3);
                AbstractC0447b.e0(jArr3, jArr3);
                AbstractC0447b.G(jArr3, jArr2, jArr3);
                AbstractC0447b.m0(jArr3, 141, jArr4);
                AbstractC0447b.G(jArr4, jArr3, jArr4);
                AbstractC0447b.e0(jArr4, jArr);
                return new Q(jArr);
            }
        }
        throw new IllegalStateException();
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        long[] jArr = this.f3212h;
        if (jArr[0] == 1) {
            for (int i = 1; i < 5; i++) {
                if (jArr[i] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = ((Q) abstractC0246d).f3212h;
        long[] jArr2 = this.f3212h;
        return new Q(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3], jArr2[4] ^ jArr[4]});
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        long[] jArr = this.f3212h;
        for (int i = 0; i < 5; i++) {
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
        if (!(obj instanceof Q)) {
            return false;
        }
        long[] jArr = ((Q) obj).f3212h;
        for (int i = 4; i >= 0; i--) {
            if (this.f3212h[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[5];
        AbstractC0447b.G(this.f3212h, ((Q) abstractC0246d).f3212h, jArr);
        return new Q(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3212h, 5) ^ 2831275;
    }

    public Q(long[] jArr) {
        this.f3212h = jArr;
    }
}
