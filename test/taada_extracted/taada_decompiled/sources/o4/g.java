package o4;

import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0886d;
import w3.C0891i;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0891i f4367a;
    public final H3.a b;

    public g(H3.a aVar) {
        this.f4367a = new C0891i(0L);
        this.b = aVar;
    }

    public static final g b(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(AbstractC0902u.l(obj));
        }
        return null;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(this.f4367a);
        c0886d.a(this.b);
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }

    public g(AbstractC0902u abstractC0902u) {
        this.f4367a = C0891i.j(abstractC0902u.m(0));
        this.b = H3.a.b(abstractC0902u.m(1));
    }
}
