package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3206h;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        E1.k.B(193, bigInteger);
    }

    public K() {
        super(193, 15, 0, 0);
        AbstractC0246d abstractC0246d = null;
        this.f3206h = new c4.h(this, abstractC0246d, abstractC0246d, 9);
        this.b = new I(new BigInteger(1, h5.b.a("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.c = new I(new BigInteger(1, h5.b.a("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.d = new BigInteger(1, h5.b.a("010000000000000000000000015AAB561B005413CCD4EE99D5"));
        this.e = BigInteger.valueOf(2L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new K();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 9);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 9);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        return new I(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final int g() {
        return 193;
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3206h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 6;
    }
}
