package f4;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3200h;

    public E(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f3200h = E1.k.B(163, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[3];
        long[] jArr2 = new long[6];
        kotlin.reflect.l.t(this.f3200h, 3, jArr2);
        AbstractC0447b.Q(jArr2, jArr);
        return new E(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return AbstractC0132a.h0(this.f3200h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[3];
        long[] jArr2 = this.f3200h;
        if (AbstractC0132a.K(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[3];
        long[] jArr4 = new long[3];
        long[] jArr5 = new long[6];
        kotlin.reflect.l.t(jArr2, 3, jArr5);
        AbstractC0447b.Q(jArr5, jArr3);
        AbstractC0447b.i0(jArr3, 1, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr3);
        AbstractC0447b.i0(jArr4, 1, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr3);
        AbstractC0447b.i0(jArr3, 3, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr3);
        AbstractC0447b.i0(jArr4, 3, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr3);
        AbstractC0447b.i0(jArr3, 9, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr3);
        AbstractC0447b.i0(jArr4, 9, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr3);
        AbstractC0447b.i0(jArr3, 27, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr3);
        AbstractC0447b.i0(jArr4, 27, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr3);
        AbstractC0447b.i0(jArr3, 81, jArr4);
        AbstractC0447b.C(jArr3, jArr4, jArr);
        return new E(jArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return AbstractC0132a.J(this.f3200h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = ((E) abstractC0246d).f3200h;
        long[] jArr2 = this.f3200h;
        return new E(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2]});
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return AbstractC0132a.K(this.f3200h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        long[] jArr = this.f3200h;
        long[] jArr2 = ((E) obj).f3200h;
        for (int i = 2; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[3];
        AbstractC0447b.C(this.f3200h, ((E) abstractC0246d).f3200h, jArr);
        return new E(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3200h, 3) ^ 163763;
    }

    public E(long[] jArr) {
        this.f3200h = jArr;
    }
}
