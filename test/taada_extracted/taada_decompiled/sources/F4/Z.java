package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class Z extends AbstractC0243a {
    public static final X i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3220h;

    static {
        long[] jArr;
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        E1.k.B(571, bigInteger);
        X x = new X(new BigInteger(1, h5.b.a("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
        i = x;
        long[] jArr2 = new long[9];
        long[] jArr3 = new long[9];
        long[] jArr4 = new long[9];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            jArr = x.f3218h;
            if (i3 >= 4) {
                break;
            }
            int i5 = i4 + 1;
            long jJ0 = kotlin.reflect.l.j0(jArr[i4]);
            i4 += 2;
            long jJ02 = kotlin.reflect.l.j0(jArr[i5]);
            jArr3[i3] = (jJ0 & 4294967295L) | (jJ02 << 32);
            jArr4[i3] = (jJ0 >>> 32) | ((-4294967296L) & jJ02);
            i3++;
        }
        long jJ03 = kotlin.reflect.l.j0(jArr[i4]);
        jArr3[4] = jJ03 & 4294967295L;
        jArr4[4] = jJ03 >>> 32;
        AbstractC0447b.x(jArr4, AbstractC0447b.f3228l, jArr2);
        for (int i6 = 0; i6 < 9; i6++) {
            jArr2[i6] = jArr2[i6] ^ jArr3[i6];
        }
    }

    public Z() {
        super(571, 2, 5, 10);
        AbstractC0246d abstractC0246d = null;
        this.f3220h = new c4.h(this, abstractC0246d, abstractC0246d, 18);
        this.b = new X(BigInteger.valueOf(1L));
        this.c = i;
        this.d = new BigInteger(1, h5.b.a("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
        this.e = BigInteger.valueOf(2L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new Z();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 18);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 18);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        return new X(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final int g() {
        return 571;
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3220h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i3) {
        return i3 == 6;
    }
}
