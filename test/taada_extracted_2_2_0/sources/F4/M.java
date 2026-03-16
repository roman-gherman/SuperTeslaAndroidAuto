package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import fr.sd.taada.proto.KeyCode;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3208h;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        E1.k.B(KeyCode.KEYCODE_TV_TELETEXT_VALUE, bigInteger);
    }

    public M() {
        super(KeyCode.KEYCODE_TV_TELETEXT_VALUE, 74, 0, 0);
        AbstractC0246d abstractC0246d = null;
        this.f3208h = new c4.h(this, abstractC0246d, abstractC0246d, 10);
        this.b = new L(BigInteger.valueOf(0L));
        this.c = new L(BigInteger.valueOf(1L));
        this.d = new BigInteger(1, h5.b.a("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
        this.e = BigInteger.valueOf(4L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new M();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 10);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 10);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        return new L(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final int g() {
        return KeyCode.KEYCODE_TV_TELETEXT_VALUE;
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3208h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 6;
    }
}
