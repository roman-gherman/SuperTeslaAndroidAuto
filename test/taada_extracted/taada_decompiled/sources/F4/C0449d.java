package f4;

import c4.AbstractC0243a;
import c4.AbstractC0246d;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: f4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0449d extends AbstractC0243a {
    public static final BigInteger i = C0453h.i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.i f3230h;

    static {
        new C0453h(ECConstants.ONE);
    }

    public C0449d() {
        super(i);
        this.f3230h = new c4.i(this, null, null, 1);
        this.b = new C0453h(ECConstants.ZERO);
        this.c = new C0453h(BigInteger.valueOf(7L));
        this.d = new BigInteger(1, h5.b.a("0100000000000000000001B8FA16DFAB9ACA16B6B3"));
        this.e = BigInteger.valueOf(1L);
        this.f1778f = 2;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        return new C0449d();
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
        return new C0453h(bigInteger);
    }

    @Override // c4.AbstractC0243a
    public final c4.j h() {
        return this.f3230h;
    }

    @Override // c4.AbstractC0243a
    public final BigInteger i() {
        return i;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d k(SecureRandom secureRandom) {
        int[] iArr = new int[5];
        do {
            byte[] bArr = new byte[20];
            do {
                secureRandom.nextBytes(bArr);
                g5.c.r(bArr, iArr, 5);
            } while (E1.k.X(iArr, AbstractC0447b.c, 5) == 0);
        } while (AbstractC0447b.v(iArr) != 0);
        return new C0453h(iArr);
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i3) {
        return i3 == 2;
    }
}
