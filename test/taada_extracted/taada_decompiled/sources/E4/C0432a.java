package e4;

import E1.k;
import c4.AbstractC0243a;
import c4.AbstractC0246d;
import c4.i;
import c4.j;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: e4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0432a extends AbstractC0243a {
    public static final BigInteger i = C0434c.i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f3136h;

    static {
        new C0434c(ECConstants.ONE);
    }

    public C0432a() {
        super(i);
        this.f3136h = new i(this, null, null, 1);
        this.b = new C0434c(new BigInteger(1, h5.b.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.c = new C0434c(new BigInteger(1, h5.b.a("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.d = new BigInteger(1, h5.b.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.e = BigInteger.valueOf(1L);
        this.f1778f = 2;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0432a();
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
        return new C0434c(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final j h() {
        return this.f3136h;
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
            } while (k.X(iArr, AbstractC0433b.f3137a, 8) == 0);
            i3 = 0;
            for (int i4 = 0; i4 < 8; i4++) {
                i3 |= iArr[i4];
            }
        } while (((((i3 >>> 1) | (i3 & 1)) - 1) >> 31) != 0);
        return new C0434c(iArr);
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i3) {
        return i3 == 2;
    }
}
