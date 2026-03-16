package f4;

import androidx.core.app.FrameMetricsAggregator;
import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: f4.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0467w extends AbstractC0243a {
    public static final BigInteger i = C0468x.i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.i f3249h;

    static {
        new C0468x(ECConstants.ONE);
    }

    public C0467w() {
        super(i);
        this.f3249h = new c4.i(this, null, null, 1);
        this.b = new C0468x(new BigInteger(1, h5.b.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.c = new C0468x(new BigInteger(1, h5.b.a("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.d = new BigInteger(1, h5.b.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.e = BigInteger.valueOf(1L);
        this.f1778f = 2;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0467w();
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
        return new C0468x(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3249h;
    }

    @Override // c4.AbstractC0243a
    public final BigInteger i() {
        return i;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d k(SecureRandom secureRandom) {
        int i3;
        int[] iArr = new int[17];
        do {
            byte[] bArr = new byte[68];
            do {
                secureRandom.nextBytes(bArr);
                g5.c.r(bArr, iArr, 17);
                iArr[16] = iArr[16] & FrameMetricsAggregator.EVERY_DURATION;
            } while (E1.k.X(iArr, AbstractC0447b.f3227k, 17) == 0);
            i3 = 0;
            for (int i4 = 0; i4 < 17; i4++) {
                i3 |= iArr[i4];
            }
        } while (((((i3 >>> 1) | (i3 & 1)) - 1) >> 31) != 0);
        return new C0468x(iArr);
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i3) {
        return i3 == 2;
    }
}
