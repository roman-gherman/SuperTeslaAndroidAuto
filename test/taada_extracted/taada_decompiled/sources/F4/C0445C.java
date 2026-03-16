package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: f4.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0445C extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3198h;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        E1.k.B(131, bigInteger);
    }

    public C0445C() {
        super(131, 2, 3, 8);
        AbstractC0246d abstractC0246d = null;
        this.f3198h = new c4.h(this, abstractC0246d, abstractC0246d, 3);
        this.b = new C0444B(new BigInteger(1, h5.b.a("07A11B09A76B562144418FF3FF8C2570B8")));
        this.c = new C0444B(new BigInteger(1, h5.b.a("0217C05610884B63B9C6C7291678F9D341")));
        this.d = new BigInteger(1, h5.b.a("0400000000000000023123953A9464B54D"));
        this.e = BigInteger.valueOf(2L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0445C();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 3);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 3);
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
        return this.f3198h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 6;
    }
}
