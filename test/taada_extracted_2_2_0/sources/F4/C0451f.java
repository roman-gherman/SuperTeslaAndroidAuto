package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0451f extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3232h;

    public C0451f(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        int[] iArrM = AbstractC0246d.M(bigInteger);
        if (iArrM[4] == -1) {
            int[] iArr = AbstractC0447b.b;
            if (AbstractC0246d.U(iArrM, iArr)) {
                AbstractC0246d.E0(iArr, iArrM);
            }
        }
        this.f3232h = iArrM;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[5];
        int[] iArr2 = new int[10];
        AbstractC0246d.D0(this.f3232h, iArr2);
        AbstractC0447b.K(iArr2, iArr);
        return new C0451f(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[5];
        C5.f.i(AbstractC0447b.b, ((C0451f) abstractC0246d).f3232h, iArr);
        int[] iArr2 = new int[10];
        AbstractC0246d.g0(iArr, this.f3232h, iArr2);
        AbstractC0447b.K(iArr2, iArr);
        return new C0451f(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return AbstractC0246d.H0(this.f3232h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[5];
        C5.f.i(AbstractC0447b.b, this.f3232h, iArr);
        return new C0451f(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        int[] iArr = this.f3232h;
        if (iArr[0] == 1) {
            for (int i3 = 1; i3 < 5; i3++) {
                if (iArr[i3] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[5];
        if (AbstractC0246d.a(this.f3232h, ((C0451f) abstractC0246d).f3232h, iArr) != 0 || (iArr[4] == -1 && AbstractC0246d.U(iArr, AbstractC0447b.b))) {
            E1.k.f(5, -2147483647, iArr);
        }
        return new C0451f(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        int[] iArr = this.f3232h;
        for (int i3 = 0; i3 < 5; i3++) {
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
        if (!(obj instanceof C0451f)) {
            return false;
        }
        int[] iArr = this.f3232h;
        int[] iArr2 = ((C0451f) obj).f3232h;
        for (int i3 = 4; i3 >= 0; i3--) {
            if (iArr[i3] != iArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[5];
        int[] iArr2 = new int[10];
        AbstractC0246d.g0(this.f3232h, ((C0451f) abstractC0246d).f3232h, iArr2);
        AbstractC0447b.K(iArr2, iArr);
        return new C0451f(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3232h, 5);
    }

    public C0451f(int[] iArr) {
        this.f3232h = iArr;
    }
}
