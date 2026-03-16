package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import fr.sd.taada.proto.KeyCode;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class N extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.h f3209h;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        E1.k.B(KeyCode.KEYCODE_TV_TELETEXT_VALUE, bigInteger);
    }

    public N() {
        super(KeyCode.KEYCODE_TV_TELETEXT_VALUE, 74, 0, 0);
        AbstractC0246d abstractC0246d = null;
        this.f3209h = new c4.h(this, abstractC0246d, abstractC0246d, 11);
        this.b = new L(BigInteger.valueOf(1L));
        this.c = new L(new BigInteger(1, h5.b.a("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD")));
        this.d = new BigInteger(1, h5.b.a("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7"));
        this.e = BigInteger.valueOf(2L);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new N();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, 11);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 11);
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
        return this.f3209h;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 6;
    }
}
