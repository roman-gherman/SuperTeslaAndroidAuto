package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3204h;

    public I(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.f3204h = E1.k.B(193, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f3204h;
        long[] jArr3 = new long[8];
        kotlin.reflect.l.t(jArr2, 3, jArr3);
        jArr3[6] = jArr2[3] & 1;
        AbstractC0447b.S(jArr3, jArr);
        return new I(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return C5.f.j0(this.f3204h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f3204h;
        if (C5.f.Q(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[4];
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[8];
        kotlin.reflect.l.t(jArr2, 3, jArr5);
        jArr5[6] = jArr2[3] & 1;
        AbstractC0447b.S(jArr5, jArr3);
        AbstractC0447b.j0(jArr3, 1, jArr4);
        AbstractC0447b.D(jArr3, jArr4, jArr3);
        AbstractC0447b.j0(jArr4, 1, jArr4);
        AbstractC0447b.D(jArr3, jArr4, jArr3);
        AbstractC0447b.j0(jArr3, 3, jArr4);
        AbstractC0447b.D(jArr3, jArr4, jArr3);
        AbstractC0447b.j0(jArr3, 6, jArr4);
        AbstractC0447b.D(jArr3, jArr4, jArr3);
        AbstractC0447b.j0(jArr3, 12, jArr4);
        AbstractC0447b.D(jArr3, jArr4, jArr3);
        AbstractC0447b.j0(jArr3, 24, jArr4);
        AbstractC0447b.D(jArr3, jArr4, jArr3);
        AbstractC0447b.j0(jArr3, 48, jArr4);
        AbstractC0447b.D(jArr3, jArr4, jArr3);
        AbstractC0447b.j0(jArr3, 96, jArr4);
        AbstractC0447b.D(jArr3, jArr4, jArr);
        return new I(jArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return C5.f.N(this.f3204h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = ((I) abstractC0246d).f3204h;
        long[] jArr2 = this.f3204h;
        return new I(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3]});
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return C5.f.Q(this.f3204h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof I) {
            return C5.f.y(this.f3204h, ((I) obj).f3204h);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[4];
        AbstractC0447b.D(this.f3204h, ((I) abstractC0246d).f3204h, jArr);
        return new I(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3204h, 4) ^ 1930015;
    }

    public I(long[] jArr) {
        this.f3204h = jArr;
    }
}
