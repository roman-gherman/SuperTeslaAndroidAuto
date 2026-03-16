package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: f4.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0460o extends AbstractC0243a {
    public static final BigInteger i = C0461p.i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.i f3241h;

    static {
        new C0461p(ECConstants.ONE);
    }

    public C0460o() {
        super(i);
        this.f3241h = new c4.i(this, null, null, 1);
        this.b = new C0461p(new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.c = new C0461p(new BigInteger(1, h5.b.a("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.d = new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.e = BigInteger.valueOf(1L);
        this.f1778f = 2;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0460o();
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
        return new C0461p(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3241h;
    }

    @Override // c4.AbstractC0243a
    public final BigInteger i() {
        return i;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d k(SecureRandom secureRandom) {
        int i3;
        int[] iArr = new int[7];
        do {
            byte[] bArr = new byte[28];
            do {
                secureRandom.nextBytes(bArr);
                g5.c.r(bArr, iArr, 7);
            } while (E1.k.X(iArr, AbstractC0447b.f3224g, 7) == 0);
            i3 = 0;
            for (int i4 = 0; i4 < 7; i4++) {
                i3 |= iArr[i4];
            }
        } while (((((i3 >>> 1) | (i3 & 1)) - 1) >> 31) != 0);
        return new C0461p(iArr);
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i3) {
        return i3 == 2;
    }
}
