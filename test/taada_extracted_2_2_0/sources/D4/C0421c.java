package d4;

import C5.f;
import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: d4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0421c extends AbstractC0246d {
    public static final BigInteger i = f.i0(AbstractC0420b.f3124a);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3125h;

    public C0421c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(i) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        int[] iArrB = f.B(bigInteger);
        while (true) {
            int[] iArr = AbstractC0420b.f3124a;
            if (!f.I(iArrB, iArr)) {
                this.f3125h = iArrB;
                return;
            }
            f.h0(iArr, iArrB);
        }
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        f.d0(this.f3125h, iArr2);
        AbstractC0420b.a(iArr2, iArr);
        return new C0421c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        f.i(AbstractC0420b.f3124a, ((C0421c) abstractC0246d).f3125h, iArr);
        int[] iArr2 = new int[16];
        f.W(iArr, this.f3125h, iArr2);
        AbstractC0420b.a(iArr2, iArr);
        return new C0421c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return f.i0(this.f3125h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        int[] iArr = new int[8];
        f.i(AbstractC0420b.f3124a, this.f3125h, iArr);
        return new C0421c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        return f.M(this.f3125h);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        f.d(this.f3125h, ((C0421c) abstractC0246d).f3125h, iArr);
        if (f.I(iArr, AbstractC0420b.f3124a)) {
            AbstractC0420b.b(iArr);
        }
        return new C0421c(iArr);
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        return f.P(this.f3125h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0421c) {
            return f.x(this.f3125h, ((C0421c) obj).f3125h);
        }
        return false;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        int[] iArr = new int[8];
        int[] iArr2 = new int[16];
        f.W(this.f3125h, ((C0421c) abstractC0246d).f3125h, iArr2);
        AbstractC0420b.a(iArr2, iArr);
        return new C0421c(iArr);
    }

    public final int hashCode() {
        return i.hashCode() ^ g5.c.m(this.f3125h, 8);
    }

    public C0421c(int[] iArr) {
        this.f3125h = iArr;
    }
}
