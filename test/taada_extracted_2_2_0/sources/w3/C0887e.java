package w3;

import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: renamed from: w3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0887e extends AbstractC0899q {
    public static final C0883a b = new C0883a(C0887e.class, 3);
    public static final C0887e[] c = new C0887e[12];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5053a;

    public C0887e(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f5053a = BigInteger.valueOf(i).toByteArray();
    }

    public static C0887e j(byte[] bArr, boolean z6) {
        if (bArr.length > 1) {
            return new C0887e(bArr, z6);
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i = bArr[0] & 255;
        if (i >= 12) {
            return new C0887e(bArr, z6);
        }
        C0887e[] c0887eArr = c;
        C0887e c0887e = c0887eArr[i];
        if (c0887e != null) {
            return c0887e;
        }
        C0887e c0887e2 = new C0887e(bArr, z6);
        c0887eArr[i] = c0887e2;
        return c0887e2;
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof C0887e)) {
            return false;
        }
        return Arrays.equals(this.f5053a, ((C0887e) abstractC0899q).f5053a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5053a, 10, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5053a.length, z6);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5053a);
    }

    public C0887e(byte[] bArr, boolean z6) {
        if (C0891i.n(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        }
        int i = 0;
        if ((bArr[0] & 128) == 0) {
            this.f5053a = z6 ? g5.c.c(bArr) : bArr;
            int length = bArr.length - 1;
            while (i < length) {
                byte b2 = bArr[i];
                i++;
                if (b2 != (bArr[i] >> 7)) {
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("enumerated must be non-negative");
    }
}
