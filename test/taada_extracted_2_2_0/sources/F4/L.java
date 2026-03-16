package f4;

import c4.AbstractC0246d;
import fr.sd.taada.proto.KeyCode;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class L extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3207h;

    public L(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f3207h = E1.k.B(KeyCode.KEYCODE_TV_TELETEXT_VALUE, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[4];
        AbstractC0447b.c0(this.f3207h, jArr);
        return new L(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return C5.f.j0(this.f3207h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[4];
        long[] jArr2 = this.f3207h;
        if (C5.f.Q(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[4];
        long[] jArr4 = new long[4];
        AbstractC0447b.c0(jArr2, jArr3);
        AbstractC0447b.E(jArr3, jArr2, jArr3);
        AbstractC0447b.c0(jArr3, jArr3);
        AbstractC0447b.E(jArr3, jArr2, jArr3);
        AbstractC0447b.k0(jArr3, 3, jArr4);
        AbstractC0447b.E(jArr4, jArr3, jArr4);
        AbstractC0447b.c0(jArr4, jArr4);
        AbstractC0447b.E(jArr4, jArr2, jArr4);
        AbstractC0447b.k0(jArr4, 7, jArr3);
        AbstractC0447b.E(jArr3, jArr4, jArr3);
        AbstractC0447b.k0(jArr3, 14, jArr4);
        AbstractC0447b.E(jArr4, jArr3, jArr4);
        AbstractC0447b.c0(jArr4, jArr4);
        AbstractC0447b.E(jArr4, jArr2, jArr4);
        AbstractC0447b.k0(jArr4, 29, jArr3);
        AbstractC0447b.E(jArr3, jArr4, jArr3);
        AbstractC0447b.k0(jArr3, 58, jArr4);
        AbstractC0447b.E(jArr4, jArr3, jArr4);
        AbstractC0447b.k0(jArr4, 116, jArr3);
        AbstractC0447b.E(jArr3, jArr4, jArr3);
        AbstractC0447b.c0(jArr3, jArr);
        return new L(jArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return C5.f.N(this.f3207h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = ((L) abstractC0246d).f3207h;
        long[] jArr2 = this.f3207h;
        return new L(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3]});
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return C5.f.Q(this.f3207h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof L) {
            return C5.f.y(this.f3207h, ((L) obj).f3207h);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[4];
        AbstractC0447b.E(this.f3207h, ((L) abstractC0246d).f3207h, jArr);
        return new L(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3207h, 4) ^ 2330074;
    }

    public L(long[] jArr) {
        this.f3207h = jArr;
    }
}
