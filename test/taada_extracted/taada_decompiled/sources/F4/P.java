package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import fr.sd.taada.proto.KeyCode;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3211h;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        E1.k.B(KeyCode.KEYCODE_TV_SATELLITE_CS_VALUE, bigInteger);
    }

    public P() {
        super(KeyCode.KEYCODE_TV_SATELLITE_CS_VALUE, 158, 0, 0);
        AbstractC0246d abstractC0246d = null;
        this.f3211h = new c4.h(this, abstractC0246d, abstractC0246d, 12);
        this.b = new O(BigInteger.valueOf(0L));
        this.c = new O(BigInteger.valueOf(1L));
        this.d = new BigInteger(1, h5.b.a("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
        this.e = BigInteger.valueOf(4L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new P();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 12);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 12);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        return new O(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final int g() {
        return KeyCode.KEYCODE_TV_SATELLITE_CS_VALUE;
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3211h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 6;
    }
}
