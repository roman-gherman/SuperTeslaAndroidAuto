package f4;

import c4.AbstractC0246d;
import fr.sd.taada.proto.KeyCode;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class O extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3210h;

    public O(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f3210h = E1.k.B(KeyCode.KEYCODE_TV_SATELLITE_CS_VALUE, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[4];
        AbstractC0447b.d0(this.f3210h, jArr);
        return new O(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return C5.f.j0(this.f3210h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f3210h;
        if (C5.f.Q(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[4];
        long[] jArr4 = new long[4];
        AbstractC0447b.d0(jArr2, jArr3);
        AbstractC0447b.F(jArr3, jArr2, jArr3);
        AbstractC0447b.d0(jArr3, jArr3);
        AbstractC0447b.F(jArr3, jArr2, jArr3);
        AbstractC0447b.l0(jArr3, 3, jArr4);
        AbstractC0447b.F(jArr4, jArr3, jArr4);
        AbstractC0447b.d0(jArr4, jArr4);
        AbstractC0447b.F(jArr4, jArr2, jArr4);
        AbstractC0447b.l0(jArr4, 7, jArr3);
        AbstractC0447b.F(jArr3, jArr4, jArr3);
        AbstractC0447b.l0(jArr3, 14, jArr4);
        AbstractC0447b.F(jArr4, jArr3, jArr4);
        AbstractC0447b.d0(jArr4, jArr4);
        AbstractC0447b.F(jArr4, jArr2, jArr4);
        AbstractC0447b.l0(jArr4, 29, jArr3);
        AbstractC0447b.F(jArr3, jArr4, jArr3);
        AbstractC0447b.d0(jArr3, jArr3);
        AbstractC0447b.F(jArr3, jArr2, jArr3);
        AbstractC0447b.l0(jArr3, 59, jArr4);
        AbstractC0447b.F(jArr4, jArr3, jArr4);
        AbstractC0447b.d0(jArr4, jArr4);
        AbstractC0447b.F(jArr4, jArr2, jArr4);
        AbstractC0447b.l0(jArr4, 119, jArr3);
        AbstractC0447b.F(jArr3, jArr4, jArr3);
        AbstractC0447b.d0(jArr3, jArr);
        return new O(jArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return C5.f.N(this.f3210h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = ((O) abstractC0246d).f3210h;
        long[] jArr2 = this.f3210h;
        return new O(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3]});
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return C5.f.Q(this.f3210h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof O) {
            return C5.f.y(this.f3210h, ((O) obj).f3210h);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[4];
        AbstractC0447b.F(this.f3210h, ((O) abstractC0246d).f3210h, jArr);
        return new O(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3210h, 4) ^ 23900158;
    }

    public O(long[] jArr) {
        this.f3210h = jArr;
    }
}
