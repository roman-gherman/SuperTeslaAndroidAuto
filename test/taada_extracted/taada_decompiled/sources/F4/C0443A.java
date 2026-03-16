package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: f4.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0443A extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3196h;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        E1.k.B(113, bigInteger);
    }

    public C0443A() {
        super(113, 9, 0, 0);
        AbstractC0246d abstractC0246d = null;
        this.f3196h = new c4.h(this, abstractC0246d, abstractC0246d, 2);
        this.b = new C0469y(new BigInteger(1, h5.b.a("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.c = new C0469y(new BigInteger(1, h5.b.a("0095E9A9EC9B297BD4BF36E059184F")));
        this.d = new BigInteger(1, h5.b.a("010000000000000108789B2496AF93"));
        this.e = BigInteger.valueOf(2L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0443A();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 2);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 2);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        return new C0469y(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final int g() {
        return 113;
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3196h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 6;
    }
}
