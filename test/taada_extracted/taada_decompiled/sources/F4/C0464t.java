package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0464t extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3246h;

    public C0464t(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        int[] iArrB = C5.f.B(bigInteger);
        if (iArrB[7] == -1) {
            int[] iArr = AbstractC0447b.i;
            if (C5.f.I(iArrB, iArr)) {
                C5.f.h0(iArr, iArrB);
            }
        }
        this.f3246h = iArrB;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        C5.f.d0(this.f3246h, iArr2);
        AbstractC0447b.Z(iArr2, iArr);
        return new C0464t(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        C5.f.i(AbstractC0447b.i, ((C0464t) abstractC0246d).f3246h, iArr);
        int[] iArr2 = new int[16];
        C5.f.W(iArr, this.f3246h, iArr2);
        AbstractC0447b.Z(iArr2, iArr);
        return new C0464t(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return C5.f.i0(this.f3246h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[8];
        C5.f.i(AbstractC0447b.i, this.f3246h, iArr);
        return new C0464t(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return C5.f.M(this.f3246h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        if (C5.f.d(this.f3246h, ((C0464t) abstractC0246d).f3246h, iArr) != 0 || (iArr[7] == -1 && C5.f.I(iArr, AbstractC0447b.i))) {
            AbstractC0447b.d(iArr);
        }
        return new C0464t(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return C5.f.P(this.f3246h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0464t) {
            return C5.f.x(this.f3246h, ((C0464t) obj).f3246h);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        C5.f.W(this.f3246h, ((C0464t) abstractC0246d).f3246h, iArr2);
        AbstractC0447b.Z(iArr2, iArr);
        return new C0464t(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3246h, 8);
    }

    public C0464t(int[] iArr) {
        this.f3246h = iArr;
    }
}
