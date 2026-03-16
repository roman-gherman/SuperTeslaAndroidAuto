package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class X extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3218h;

    public X(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.f3218h = E1.k.B(571, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[9];
        long[] jArr2 = new long[18];
        kotlin.reflect.l.t(this.f3218h, 9, jArr2);
        AbstractC0447b.J(jArr2, jArr);
        return new X(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        byte[] bArr = new byte[72];
        for (int i = 0; i < 9; i++) {
            long j6 = this.f3218h[i];
            if (j6 != 0) {
                g5.c.t(bArr, (8 - i) << 3, j6);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[9];
        long[] jArr2 = this.f3218h;
        for (int i = 0; i < 9; i++) {
            if (jArr2[i] != 0) {
                long[] jArr3 = new long[9];
                long[] jArr4 = new long[9];
                long[] jArr5 = new long[9];
                long[] jArr6 = new long[18];
                kotlin.reflect.l.t(jArr2, 9, jArr6);
                AbstractC0447b.J(jArr6, jArr5);
                long[] jArr7 = new long[18];
                kotlin.reflect.l.t(jArr5, 9, jArr7);
                AbstractC0447b.J(jArr7, jArr3);
                long[] jArr8 = new long[18];
                kotlin.reflect.l.t(jArr3, 9, jArr8);
                AbstractC0447b.J(jArr8, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.f0(jArr3, 2, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.x(jArr3, jArr5, jArr3);
                AbstractC0447b.f0(jArr3, 5, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.f0(jArr4, 5, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.f0(jArr3, 15, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr5);
                AbstractC0447b.f0(jArr5, 30, jArr3);
                AbstractC0447b.f0(jArr3, 30, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.f0(jArr3, 60, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.f0(jArr4, 60, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.f0(jArr3, 180, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.f0(jArr4, 180, jArr4);
                AbstractC0447b.x(jArr3, jArr4, jArr3);
                AbstractC0447b.x(jArr3, jArr5, jArr);
                return new X(jArr);
            }
        }
        throw new IllegalStateException();
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        long[] jArr = this.f3218h;
        if (jArr[0] == 1) {
            for (int i = 1; i < 9; i++) {
                if (jArr[i] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[9];
        long[] jArr2 = ((X) abstractC0246d).f3218h;
        long[] jArr3 = this.f3218h;
        for (int i = 0; i < 9; i++) {
            jArr[i] = jArr3[i] ^ jArr2[i];
        }
        return new X(jArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        long[] jArr = this.f3218h;
        for (int i = 0; i < 9; i++) {
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
        if (!(obj instanceof X)) {
            return false;
        }
        long[] jArr = ((X) obj).f3218h;
        for (int i = 8; i >= 0; i--) {
            if (this.f3218h[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[9];
        AbstractC0447b.x(this.f3218h, ((X) abstractC0246d).f3218h, jArr);
        return new X(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3218h, 9) ^ 5711052;
    }

    public X(long[] jArr) {
        this.f3218h = jArr;
    }
}
