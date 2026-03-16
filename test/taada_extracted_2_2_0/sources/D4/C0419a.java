package d4;

import E1.k;
import c4.AbstractC0243a;
import c4.AbstractC0246d;
import c4.i;
import c4.j;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: d4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0419a extends AbstractC0243a {
    public static final BigInteger i = C0421c.i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final BigInteger f3121j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final BigInteger f3122k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f3123h;

    static {
        BigInteger bigInteger = new BigInteger(1, h5.b.a("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144"));
        f3121j = bigInteger;
        f3122k = new BigInteger(1, h5.b.a("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864"));
        new C0421c(ECConstants.ONE);
        new C0421c(bigInteger);
    }

    public C0419a() {
        super(i);
        this.f3123h = new i(this, null, null, 1);
        this.b = new C0421c(f3121j);
        this.c = new C0421c(f3122k);
        this.d = new BigInteger(1, h5.b.a("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.e = BigInteger.valueOf(8L);
        this.f1778f = 4;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0419a();
    }

    @Override // c4.AbstractC0243a
    public final j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new i(this, abstractC0246d, abstractC0246d2, 1);
    }

    @Override // c4.AbstractC0243a
    public final j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new i(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 1);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        return new C0421c(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final j h() {
        return this.f3123h;
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
                iArr[7] = iArr[7] & Integer.MAX_VALUE;
            } while (k.X(iArr, AbstractC0420b.f3124a, 8) == 0);
            i3 = 0;
            for (int i4 = 0; i4 < 8; i4++) {
                i3 |= iArr[i4];
            }
        } while (((((i3 >>> 1) | (i3 & 1)) - 1) >> 31) != 0);
        return new C0421c(iArr);
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i3) {
        return i3 == 4;
    }
}
