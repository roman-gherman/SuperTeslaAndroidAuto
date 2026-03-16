package w3;

import java.util.Arrays;

/* JADX INFO: renamed from: w3.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0905x extends AbstractC0899q {
    public static final C0883a b = new C0883a(C0905x.class, 20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5077a;

    public C0905x(byte[] bArr) {
        byte b2;
        byte b6;
        if (bArr.length < 2) {
            throw new IllegalArgumentException("UTCTime string too short");
        }
        this.f5077a = bArr;
        if (bArr.length <= 0 || (b2 = bArr[0]) < 48 || b2 > 57 || bArr.length <= 1 || (b6 = bArr[1]) < 48 || b6 > 57) {
            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof C0905x)) {
            return false;
        }
        return Arrays.equals(this.f5077a, ((C0905x) abstractC0899q).f5077a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5077a, 23, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5077a.length, z6);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5077a);
    }

    public final String toString() {
        return g5.e.a(this.f5077a);
    }
}
