package o4;

import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.C0886d;
import w3.W;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f4369a;
    public byte[] b;

    public final byte[] b() {
        return g5.c.c(this.b);
    }

    public final byte[] c() {
        return g5.c.c(this.f4369a);
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new W(this.f4369a));
        c0886d.a(new W(this.b));
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }
}
