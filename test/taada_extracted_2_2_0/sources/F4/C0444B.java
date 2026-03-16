package f4;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0444B extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3197h;

    public C0444B(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.f3197h = E1.k.B(131, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[3];
        long[] jArr2 = new long[5];
        AbstractC0447b.t(this.f3197h, jArr2);
        AbstractC0447b.O(jArr2, jArr);
        return new C0444B(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return AbstractC0132a.h0(this.f3197h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[3];
        long[] jArr2 = this.f3197h;
        if (AbstractC0132a.K(jArr2)) {
            throw new IllegalStateException();
        }
        long[] jArr3 = new long[3];
        long[] jArr4 = new long[3];
        long[] jArr5 = new long[5];
        AbstractC0447b.t(jArr2, jArr5);
        AbstractC0447b.O(jArr5, jArr3);
        AbstractC0447b.B(jArr3, jArr2, jArr3);
        AbstractC0447b.h0(jArr3, 2, jArr4);
        AbstractC0447b.B(jArr4, jArr3, jArr4);
        AbstractC0447b.h0(jArr4, 4, jArr3);
        AbstractC0447b.B(jArr3, jArr4, jArr3);
        AbstractC0447b.h0(jArr3, 8, jArr4);
        AbstractC0447b.B(jArr4, jArr3, jArr4);
        AbstractC0447b.h0(jArr4, 16, jArr3);
        AbstractC0447b.B(jArr3, jArr4, jArr3);
        AbstractC0447b.h0(jArr3, 32, jArr4);
        AbstractC0447b.B(jArr4, jArr3, jArr4);
        long[] jArr6 = new long[5];
        AbstractC0447b.t(jArr4, jArr6);
        AbstractC0447b.O(jArr6, jArr4);
        AbstractC0447b.B(jArr4, jArr2, jArr4);
        AbstractC0447b.h0(jArr4, 65, jArr3);
        AbstractC0447b.B(jArr3, jArr4, jArr3);
        long[] jArr7 = new long[5];
        AbstractC0447b.t(jArr3, jArr7);
        AbstractC0447b.O(jArr7, jArr);
        return new C0444B(jArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return AbstractC0132a.J(this.f3197h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = ((C0444B) abstractC0246d).f3197h;
        long[] jArr2 = this.f3197h;
        return new C0444B(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2]});
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return AbstractC0132a.K(this.f3197h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0444B)) {
            return false;
        }
        long[] jArr = this.f3197h;
        long[] jArr2 = ((C0444B) obj).f3197h;
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
        AbstractC0447b.B(this.f3197h, ((C0444B) abstractC0246d).f3197h, jArr);
        return new C0444B(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3197h, 3) ^ 131832;
    }

    public C0444B(long[] jArr) {
        this.f3197h = jArr;
    }
}
