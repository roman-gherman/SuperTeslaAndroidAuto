package w3;

import java.util.Arrays;
import org.bouncycastle.asn1.ASN1String;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends AbstractC0899q implements ASN1String {
    public static final C0883a b = new C0883a(P.class, 5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5041a;

    public P(byte[] bArr) {
        this.f5041a = bArr;
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof P)) {
            return false;
        }
        return Arrays.equals(this.f5041a, ((P) abstractC0899q).f5041a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5041a, 27, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5041a.length, z6);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        return g5.e.a(this.f5041a);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5041a);
    }

    public final String toString() {
        return g5.e.a(this.f5041a);
    }
}
