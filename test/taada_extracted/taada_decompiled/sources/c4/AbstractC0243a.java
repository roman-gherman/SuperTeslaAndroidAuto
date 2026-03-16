package c4;

import h4.AbstractC0523a;
import h4.C0524b;
import h4.C0525c;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.field.FiniteField;

/* JADX INFO: renamed from: c4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0243a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FiniteField f1777a;
    public AbstractC0246d b;
    public AbstractC0246d c;
    public BigInteger d;
    public BigInteger e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1779g;

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC0243a(int i, int i3, int i4, int i5) {
        this.f1779g = 0;
        String strA = g5.d.a("org.bouncycastle.ec.max_f2m_field_size");
        if (i > (strA != null ? Integer.parseInt(strA) : 1142)) {
            throw new IllegalArgumentException(B2.b.c(i, "field size out of range: "));
        }
        int[] iArr = (i4 | i5) == 0 ? new int[]{0, i3, i} : new int[]{0, i3, i4, i5, i};
        h4.d dVar = AbstractC0523a.f3454a;
        if (iArr[0] != 0) {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i6 = 1; i6 < iArr.length; i6++) {
            if (iArr[i6] <= iArr[i6 - 1]) {
                throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
            }
        }
        this(new C0525c(AbstractC0523a.f3454a, new C0524b(iArr)));
        if (g5.d.b("org.bouncycastle.ec.disable")) {
            throw new UnsupportedOperationException("F2M disabled by \"org.bouncycastle.ec.disable\"");
        }
        if (g5.d.b("org.bouncycastle.ec.disable_f2m")) {
            throw new UnsupportedOperationException("F2M disabled by \"org.bouncycastle.ec.disable_f2m\"");
        }
    }

    public abstract AbstractC0243a a();

    public j b(BigInteger bigInteger, BigInteger bigInteger2) {
        switch (this.f1779g) {
            case 0:
                AbstractC0246d abstractC0246dF = f(bigInteger);
                AbstractC0246d abstractC0246dF2 = f(bigInteger2);
                int i = this.f1778f;
                if (i == 5 || i == 6) {
                    if (!abstractC0246dF.c0()) {
                        abstractC0246dF2 = abstractC0246dF2.G(abstractC0246dF).b(abstractC0246dF);
                    } else if (!abstractC0246dF2.C0().equals(this.c)) {
                        throw new IllegalArgumentException();
                    }
                }
                return c(abstractC0246dF, abstractC0246dF2);
            default:
                return c(f(bigInteger), f(bigInteger2));
        }
    }

    public abstract j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2);

    public abstract j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr);

    public final boolean e(AbstractC0243a abstractC0243a) {
        if (this == abstractC0243a) {
            return true;
        }
        if (abstractC0243a != null) {
            return this.f1777a.equals(abstractC0243a.f1777a) && this.b.G0().equals(abstractC0243a.b.G0()) && this.c.G0().equals(abstractC0243a.c.G0());
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AbstractC0243a) && e((AbstractC0243a) obj);
        }
        return true;
    }

    public abstract AbstractC0246d f(BigInteger bigInteger);

    public abstract int g();

    public abstract j h();

    public final int hashCode() {
        return (this.f1777a.hashCode() ^ Integer.rotateLeft(this.b.G0().hashCode(), 8)) ^ Integer.rotateLeft(this.c.G0().hashCode(), 16);
    }

    public abstract BigInteger i();

    public j j(j jVar) {
        if (this == jVar.f1798a) {
            return jVar;
        }
        if (jVar.e()) {
            return h();
        }
        j jVarF = jVar.f();
        return b(jVarF.b.G0(), jVarF.c().G0());
    }

    public AbstractC0246d k(SecureRandom secureRandom) {
        BigInteger bigIntegerA;
        BigInteger bigIntegerA2;
        switch (this.f1779g) {
            case 0:
                int iG = g();
                do {
                    bigIntegerA = g5.b.a(iG, secureRandom);
                } while (bigIntegerA.signum() <= 0);
                AbstractC0246d abstractC0246dF = f(bigIntegerA);
                do {
                    bigIntegerA2 = g5.b.a(iG, secureRandom);
                } while (bigIntegerA2.signum() <= 0);
                return abstractC0246dF.h0(f(bigIntegerA2));
            default:
                BigInteger bigIntegerI = i();
                while (true) {
                    BigInteger bigIntegerA3 = g5.b.a(bigIntegerI.bitLength(), secureRandom);
                    if (bigIntegerA3.signum() > 0 && bigIntegerA3.compareTo(bigIntegerI) < 0) {
                        AbstractC0246d abstractC0246dF2 = f(bigIntegerA3);
                        while (true) {
                            BigInteger bigIntegerA4 = g5.b.a(bigIntegerI.bitLength(), secureRandom);
                            if (bigIntegerA4.signum() > 0 && bigIntegerA4.compareTo(bigIntegerI) < 0) {
                                return abstractC0246dF2.h0(f(bigIntegerA4));
                            }
                        }
                    }
                }
                break;
        }
    }

    public abstract boolean l(int i);

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AbstractC0243a(java.math.BigInteger r5) {
        /*
            r4 = this;
            r0 = 1
            r4.f1779g = r0
            h4.d r0 = h4.AbstractC0523a.f3454a
            int r0 = r5.bitLength()
            int r1 = r5.signum()
            if (r1 <= 0) goto L40
            r1 = 2
            if (r0 < r1) goto L40
            r2 = 3
            if (r0 >= r2) goto L36
            java.math.BigInteger r0 = g5.b.f3343a
            int r0 = r5.bitLength()
            r3 = 31
            if (r0 > r3) goto L2e
            int r0 = r5.intValue()
            if (r0 == r1) goto L2b
            if (r0 == r2) goto L28
            goto L36
        L28:
            h4.d r5 = h4.AbstractC0523a.b
            goto L3c
        L2b:
            h4.d r5 = h4.AbstractC0523a.f3454a
            goto L3c
        L2e:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r0 = "BigInteger out of int range"
            r5.<init>(r0)
            throw r5
        L36:
            h4.d r0 = new h4.d
            r0.<init>(r5)
            r5 = r0
        L3c:
            r4.<init>(r5)
            return
        L40:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "'characteristic' must be >= 2"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.AbstractC0243a.<init>(java.math.BigInteger):void");
    }

    public AbstractC0243a(FiniteField finiteField) {
        this.f1778f = 0;
        this.f1777a = finiteField;
    }
}
