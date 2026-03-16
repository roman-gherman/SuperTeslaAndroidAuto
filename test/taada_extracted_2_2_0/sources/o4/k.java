package o4;

import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0886d;
import w3.C0891i;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0891i f4372a;
    public final int b;
    public final int c;
    public final H3.a d;

    public k(int i, H3.a aVar, int i3) {
        this.f4372a = new C0891i(0L);
        this.b = i;
        this.c = i3;
        this.d = aVar;
    }

    public static k b(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(AbstractC0902u.l(obj));
        }
        return null;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(this.f4372a);
        c0886d.a(new C0891i(this.b));
        c0886d.a(new C0891i(this.c));
        c0886d.a(this.d);
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }

    public k(AbstractC0902u abstractC0902u) {
        this.f4372a = C0891i.j(abstractC0902u.m(0));
        this.b = C0891i.j(abstractC0902u.m(1)).m();
        this.c = C0891i.j(abstractC0902u.m(2)).m();
        this.d = H3.a.b(abstractC0902u.m(3));
    }
}
