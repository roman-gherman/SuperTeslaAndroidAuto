package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3199h;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        E1.k.B(131, bigInteger);
    }

    public D() {
        super(131, 2, 3, 8);
        AbstractC0246d abstractC0246d = null;
        this.f3199h = new c4.h(this, abstractC0246d, abstractC0246d, 4);
        this.b = new C0444B(new BigInteger(1, h5.b.a("03E5A88919D7CAFCBF415F07C2176573B2")));
        this.c = new C0444B(new BigInteger(1, h5.b.a("04B8266A46C55657AC734CE38F018F2192")));
        this.d = new BigInteger(1, h5.b.a("0400000000000000016954A233049BA98F"));
        this.e = BigInteger.valueOf(2L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new D();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 4);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 4);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        return new C0444B(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final int g() {
        return 131;
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3199h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 6;
    }
}
