package w3;

import java.util.Arrays;
import org.bouncycastle.asn1.ASN1String;

/* JADX INFO: loaded from: classes2.dex */
public final class Y extends AbstractC0899q implements ASN1String {
    public static final C0883a b = new C0883a(Y.class, 15);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5046a;

    public Y(byte[] bArr) {
        this.f5046a = bArr;
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof Y)) {
            return false;
        }
        return Arrays.equals(this.f5046a, ((Y) abstractC0899q).f5046a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5046a, 19, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5046a.length, z6);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        return g5.e.a(this.f5046a);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5046a);
    }

    public final String toString() {
        return g5.e.a(this.f5046a);
    }
}
