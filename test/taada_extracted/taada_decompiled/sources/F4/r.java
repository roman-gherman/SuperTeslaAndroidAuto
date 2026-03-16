package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3244h;

    public r(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        int[] iArrB = C5.f.B(bigInteger);
        if (iArrB[7] == -1) {
            int[] iArr = AbstractC0447b.f3225h;
            if (C5.f.I(iArrB, iArr)) {
                C5.f.h0(iArr, iArrB);
            }
        }
        this.f3244h = iArrB;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        C5.f.d0(this.f3244h, iArr2);
        AbstractC0447b.X(iArr2, iArr);
        return new r(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        C5.f.i(AbstractC0447b.f3225h, ((r) abstractC0246d).f3244h, iArr);
        int[] iArr2 = new int[16];
        C5.f.W(iArr, this.f3244h, iArr2);
        AbstractC0447b.X(iArr2, iArr);
        return new r(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return C5.f.i0(this.f3244h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[8];
        C5.f.i(AbstractC0447b.f3225h, this.f3244h, iArr);
        return new r(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return C5.f.M(this.f3244h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        if (C5.f.d(this.f3244h, ((r) abstractC0246d).f3244h, iArr) != 0 || (iArr[7] == -1 && C5.f.I(iArr, AbstractC0447b.f3225h))) {
            E1.k.c(8, 977, iArr);
        }
        return new r(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return C5.f.P(this.f3244h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            return C5.f.x(this.f3244h, ((r) obj).f3244h);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        C5.f.W(this.f3244h, ((r) abstractC0246d).f3244h, iArr2);
        AbstractC0447b.X(iArr2, iArr);
        return new r(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3244h, 8);
    }

    public r(int[] iArr) {
        this.f3244h = iArr;
    }
}
