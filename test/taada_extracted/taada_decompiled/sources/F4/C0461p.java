package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0461p extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3242h;

    public C0461p(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        int[] iArrU = kotlin.reflect.l.u(bigInteger);
        if (iArrU[6] == -1) {
            int[] iArr = AbstractC0447b.f3224g;
            if (kotlin.reflect.l.K(iArrU, iArr)) {
                long j6 = (((long) iArrU[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L);
                iArrU[0] = (int) j6;
                long j7 = ((((long) iArrU[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) + (j6 >> 32);
                iArrU[1] = (int) j7;
                long j8 = ((((long) iArrU[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) + (j7 >> 32);
                iArrU[2] = (int) j8;
                long j9 = ((((long) iArrU[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) + (j8 >> 32);
                iArrU[3] = (int) j9;
                long j10 = ((((long) iArrU[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) + (j9 >> 32);
                iArrU[4] = (int) j10;
                long j11 = ((((long) iArrU[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) + (j10 >> 32);
                iArrU[5] = (int) j11;
                iArrU[6] = (int) (((((long) iArrU[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) + (j11 >> 32));
            }
        }
        this.f3242h = iArrU;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[7];
        int[] iArr2 = new int[14];
        kotlin.reflect.l.c0(this.f3242h, iArr2);
        AbstractC0447b.V(iArr2, iArr);
        return new C0461p(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[7];
        C5.f.i(AbstractC0447b.f3224g, ((C0461p) abstractC0246d).f3242h, iArr);
        int[] iArr2 = new int[14];
        kotlin.reflect.l.Q(iArr, this.f3242h, iArr2);
        AbstractC0447b.V(iArr2, iArr);
        return new C0461p(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return kotlin.reflect.l.g0(this.f3242h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[7];
        C5.f.i(AbstractC0447b.f3224g, this.f3242h, iArr);
        return new C0461p(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        int[] iArr = this.f3242h;
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
        if (kotlin.reflect.l.d(this.f3242h, ((C0461p) abstractC0246d).f3242h, iArr) != 0 || (iArr[6] == -1 && kotlin.reflect.l.K(iArr, AbstractC0447b.f3224g))) {
            AbstractC0447b.c(iArr);
        }
        return new C0461p(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        int[] iArr = this.f3242h;
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
        if (!(obj instanceof C0461p)) {
            return false;
        }
        int[] iArr = this.f3242h;
        int[] iArr2 = ((C0461p) obj).f3242h;
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
        kotlin.reflect.l.Q(this.f3242h, ((C0461p) abstractC0246d).f3242h, iArr2);
        AbstractC0447b.V(iArr2, iArr);
        return new C0461p(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3242h, 7);
    }

    public C0461p(int[] iArr) {
        this.f3242h = iArr;
    }
}
