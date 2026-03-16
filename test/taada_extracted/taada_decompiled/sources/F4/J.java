package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3205h;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        E1.k.B(193, bigInteger);
    }

    public J() {
        super(193, 15, 0, 0);
        AbstractC0246d abstractC0246d = null;
        this.f3205h = new c4.h(this, abstractC0246d, abstractC0246d, 8);
        this.b = new I(new BigInteger(1, h5.b.a("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
        this.c = new I(new BigInteger(1, h5.b.a("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
        this.d = new BigInteger(1, h5.b.a("01000000000000000000000000C7F34A778F443ACC920EBA49"));
        this.e = BigInteger.valueOf(2L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new J();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 8);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 8);
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
        return this.f3205h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 6;
    }
}
