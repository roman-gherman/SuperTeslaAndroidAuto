package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: f4.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0462q extends AbstractC0243a {
    public static final BigInteger i = r.i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.i f3243h;

    static {
        new r(ECConstants.ONE);
    }

    public C0462q() {
        super(i);
        this.f3243h = new c4.i(this, null, null, 1);
        this.b = new r(ECConstants.ZERO);
        this.c = new r(BigInteger.valueOf(7L));
        this.d = new BigInteger(1, h5.b.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.e = BigInteger.valueOf(1L);
        this.f1778f = 2;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0462q();
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
        return new r(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3243h;
    }

    @Override // c4.AbstractC0243a
    public final BigInteger i() {
        return i;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d k(SecureRandom secureRandom) {
        int i3;
        int[] iArr = new int[8];
        do {
            byte[] bArr = new byte[32];
            do {
                secureRandom.nextBytes(bArr);
                g5.c.r(bArr, iArr, 8);
            } while (E1.k.X(iArr, AbstractC0447b.f3225h, 8) == 0);
            i3 = 0;
            for (int i4 = 0; i4 < 8; i4++) {
                i3 |= iArr[i4];
            }
        } while (((((i3 >>> 1) | (i3 & 1)) - 1) >> 31) != 0);
        return new r(iArr);
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i3) {
        return i3 == 2;
    }
}
