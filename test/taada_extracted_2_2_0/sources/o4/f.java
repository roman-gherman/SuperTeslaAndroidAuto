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
public final class f extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4367a;
    public final int b;
    public final f5.a c;
    public final H3.a d;

    public f(int i, int i3, f5.a aVar, H3.a aVar2) {
        this.f4367a = i;
        this.b = i3;
        this.c = new f5.a(aVar.a());
        this.d = aVar2;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new C0891i(this.f4367a));
        c0886d.a(new C0891i(this.b));
        c0886d.a(new W(this.c.a()));
        c0886d.a(this.d);
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }

    public f(AbstractC0902u abstractC0902u) {
        this.f4367a = ((C0891i) abstractC0902u.m(0)).m();
        this.b = ((C0891i) abstractC0902u.m(1)).m();
        this.c = new f5.a(((AbstractC0897o) abstractC0902u.m(2)).f5067a);
        this.d = H3.a.b(abstractC0902u.m(3));
    }
}
