package o4;

import w3.AbstractC0893k;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0886d;
import w3.C0891i;
import w3.W;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f4382a;
    public final byte[] b;

    public o(AbstractC0902u abstractC0902u) {
        if (!C0891i.j(abstractC0902u.m(0)).k(0)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f4382a = g5.c.c(AbstractC0897o.j(abstractC0902u.m(1)).f5067a);
        this.b = g5.c.c(AbstractC0897o.j(abstractC0902u.m(2)).f5067a);
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new C0891i(0L));
        c0886d.a(new W(this.f4382a));
        c0886d.a(new W(this.b));
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }

    public o(byte[] bArr, byte[] bArr2) {
        this.f4382a = g5.c.c(bArr);
        this.b = g5.c.c(bArr2);
    }
}
