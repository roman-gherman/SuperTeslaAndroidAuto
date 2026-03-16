package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0459n extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3240h;

    public C0459n(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        int[] iArrU = kotlin.reflect.l.u(bigInteger);
        if (iArrU[6] == -1 && kotlin.reflect.l.K(iArrU, AbstractC0447b.f3223f)) {
            E1.k.c(7, 6803, iArrU);
        }
        this.f3240h = iArrU;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[7];
        int[] iArr2 = new int[14];
        kotlin.reflect.l.c0(this.f3240h, iArr2);
        AbstractC0447b.T(iArr2, iArr);
        return new C0459n(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[7];
        C5.f.i(AbstractC0447b.f3223f, ((C0459n) abstractC0246d).f3240h, iArr);
        int[] iArr2 = new int[14];
        kotlin.reflect.l.Q(iArr, this.f3240h, iArr2);
        AbstractC0447b.T(iArr2, iArr);
        return new C0459n(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return kotlin.reflect.l.g0(this.f3240h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[7];
        C5.f.i(AbstractC0447b.f3223f, this.f3240h, iArr);
        return new C0459n(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        int[] iArr = this.f3240h;
        if (iArr[0] == 1) {
            for (int i3 = 1; i3 < 7; i3++) {
                if (iArr[i3] == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[7];
        if (kotlin.reflect.l.d(this.f3240h, ((C0459n) abstractC0246d).f3240h, iArr) != 0 || (iArr[6] == -1 && kotlin.reflect.l.K(iArr, AbstractC0447b.f3223f))) {
            E1.k.c(7, 6803, iArr);
        }
        return new C0459n(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        int[] iArr = this.f3240h;
        for (int i3 = 0; i3 < 7; i3++) {
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
        if (!(obj instanceof C0459n)) {
            return false;
        }
        int[] iArr = this.f3240h;
        int[] iArr2 = ((C0459n) obj).f3240h;
        for (int i3 = 6; i3 >= 0; i3--) {
            if (iArr[i3] != iArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[7];
        int[] iArr2 = new int[14];
        kotlin.reflect.l.Q(this.f3240h, ((C0459n) abstractC0246d).f3240h, iArr2);
        AbstractC0447b.T(iArr2, iArr);
        return new C0459n(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3240h, 7);
    }

    public C0459n(int[] iArr) {
        this.f3240h = iArr;
    }
}
