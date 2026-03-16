package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: f4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0450e extends AbstractC0243a {
    public static final BigInteger i = C0451f.i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.i f3231h;

    static {
        new C0451f(ECConstants.ONE);
    }

    public C0450e() {
        super(i);
        this.f3231h = new c4.i(this, null, null, 1);
        this.b = new C0451f(new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.c = new C0451f(new BigInteger(1, h5.b.a("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.d = new BigInteger(1, h5.b.a("0100000000000000000001F4C8F927AED3CA752257"));
        this.e = BigInteger.valueOf(1L);
        this.f1778f = 2;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0450e();
    }

    @Override // c4.AbstractC0243a
    public final c4.j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new c4.i(this, abstractC0246d, abstractC0246d2, 1);
    }

    @Override // c4.AbstractC0243a
    public final c4.j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new c4.i(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 1);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        return new C0451f(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3231h;
    }

    @Override // c4.AbstractC0243a
    public final BigInteger i() {
        return i;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d k(SecureRandom secureRandom) {
        int i3;
        int[] iArr = new int[5];
        do {
            byte[] bArr = new byte[20];
            do {
                secureRandom.nextBytes(bArr);
                g5.c.r(bArr, iArr, 5);
            } while (E1.k.X(iArr, AbstractC0447b.b, 5) == 0);
            i3 = 0;
            for (int i4 = 0; i4 < 5; i4++) {
                i3 |= iArr[i4];
            }
        } while (((((i3 >>> 1) | (i3 & 1)) - 1) >> 31) != 0);
        return new C0451f(iArr);
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i3) {
        return i3 == 2;
    }
}
