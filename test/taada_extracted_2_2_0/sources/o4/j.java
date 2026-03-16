package o4;

import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0886d;
import w3.C0891i;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0891i f4371a;
    public final int b;
    public final H3.a c;

    public j(int i, H3.a aVar) {
        this.f4371a = new C0891i(0L);
        this.b = i;
        this.c = aVar;
    }

    public static j b(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(AbstractC0902u.l(obj));
        }
        return null;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(this.f4371a);
        c0886d.a(new C0891i(this.b));
        c0886d.a(this.c);
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }

    public j(AbstractC0902u abstractC0902u) {
        this.f4371a = C0891i.j(abstractC0902u.m(0));
        this.b = C0891i.j(abstractC0902u.m(1)).m();
        this.c = H3.a.b(abstractC0902u.m(2));
    }
}
