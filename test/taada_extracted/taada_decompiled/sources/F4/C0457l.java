package f4;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0457l extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3238h;

    public C0457l(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        int[] iArrV = AbstractC0132a.v(bigInteger);
        if (iArrV[5] == -1) {
            int[] iArr = AbstractC0447b.e;
            if (AbstractC0132a.F(iArrV, iArr)) {
                AbstractC0132a.f0(iArr, iArrV);
            }
        }
        this.f3238h = iArrV;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[6];
        int[] iArr2 = new int[12];
        AbstractC0132a.d0(this.f3238h, iArr2);
        AbstractC0447b.R(iArr2, iArr);
        return new C0457l(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[6];
        C5.f.i(AbstractC0447b.e, ((C0457l) abstractC0246d).f3238h, iArr);
        int[] iArr2 = new int[12];
        AbstractC0132a.U(iArr, this.f3238h, iArr2);
        AbstractC0447b.R(iArr2, iArr);
        return new C0457l(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return AbstractC0132a.g0(this.f3238h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[6];
        C5.f.i(AbstractC0447b.e, this.f3238h, iArr);
        return new C0457l(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        int[] iArr = this.f3238h;
        if (iArr[0] == 1) {
            for (int i3 = 1; i3 < 6; i3++) {
                if (iArr[i3] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[6];
        if (AbstractC0132a.c(this.f3238h, ((C0457l) abstractC0246d).f3238h, iArr) != 0 || (iArr[5] == -1 && AbstractC0132a.F(iArr, AbstractC0447b.e))) {
            AbstractC0447b.b(iArr);
        }
        return new C0457l(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        int[] iArr = this.f3238h;
        for (int i3 = 0; i3 < 6; i3++) {
            if (iArr[i3] != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0457l)) {
            return false;
        }
        int[] iArr = this.f3238h;
        int[] iArr2 = ((C0457l) obj).f3238h;
        for (int i3 = 5; i3 >= 0; i3--) {
            if (iArr[i3] != iArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[6];
        int[] iArr2 = new int[12];
        AbstractC0132a.U(this.f3238h, ((C0457l) abstractC0246d).f3238h, iArr2);
        AbstractC0447b.R(iArr2, iArr);
        return new C0457l(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3238h, 6);
    }

    public C0457l(int[] iArr) {
        this.f3238h = iArr;
    }
}
