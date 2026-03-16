package e4;

import C5.f;
import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: e4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0434c extends AbstractC0246d {
    public static final BigInteger i = new BigInteger(1, h5.b.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3138h;

    public C0434c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        int[] iArrB = f.B(bigInteger);
        if ((iArrB[7] >>> 1) >= Integer.MAX_VALUE) {
            int[] iArr = AbstractC0433b.f3137a;
            if (f.I(iArrB, iArr)) {
                f.h0(iArr, iArrB);
            }
        }
        this.f3138h = iArrB;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        f.d0(this.f3138h, iArr2);
        AbstractC0433b.b(iArr2, iArr);
        return new C0434c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        f.i(AbstractC0433b.f3137a, ((C0434c) abstractC0246d).f3138h, iArr);
        int[] iArr2 = new int[16];
        f.W(iArr, this.f3138h, iArr2);
        AbstractC0433b.b(iArr2, iArr);
        return new C0434c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return f.i0(this.f3138h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[8];
        f.i(AbstractC0433b.f3137a, this.f3138h, iArr);
        return new C0434c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return f.M(this.f3138h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        if (f.d(this.f3138h, ((C0434c) abstractC0246d).f3138h, iArr) != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && f.I(iArr, AbstractC0433b.f3137a))) {
            AbstractC0433b.a(iArr);
        }
        return new C0434c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return f.P(this.f3138h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0434c) {
            return f.x(this.f3138h, ((C0434c) obj).f3138h);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        f.W(this.f3138h, ((C0434c) abstractC0246d).f3138h, iArr2);
        AbstractC0433b.b(iArr2, iArr);
        return new C0434c(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3138h, 8);
    }

    public C0434c(int[] iArr) {
        this.f3138h = iArr;
    }
}
