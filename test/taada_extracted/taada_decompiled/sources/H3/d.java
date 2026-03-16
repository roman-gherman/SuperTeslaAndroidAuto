package H3;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import w3.AbstractC0884b;
import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.M;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f748a;
    public AbstractC0884b b;

    public d(a aVar, AbstractC0893k abstractC0893k) {
        this.b = new M(abstractC0893k.toASN1Primitive().a(), 0);
        this.f748a = aVar;
    }

    public static d b(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj == null) {
            return null;
        }
        AbstractC0902u abstractC0902uL = AbstractC0902u.l(obj);
        d dVar = new d();
        if (abstractC0902uL.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + abstractC0902uL.size());
        }
        Enumeration enumerationN = abstractC0902uL.n();
        dVar.f748a = a.b(enumerationN.nextElement());
        dVar.b = AbstractC0884b.m(enumerationN.nextElement());
        return dVar;
    }

    public final AbstractC0899q c() {
        return AbstractC0899q.g(this.b.n());
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        Z z6 = new Z(0);
        a aVar = this.f748a;
        if (aVar == null) {
            throw new NullPointerException("'element1' cannot be null");
        }
        AbstractC0884b abstractC0884b = this.b;
        if (abstractC0884b == null) {
            throw new NullPointerException("'element2' cannot be null");
        }
        z6.f5073a = new ASN1Encodable[]{aVar, abstractC0884b};
        z6.d = -1;
        return z6;
    }

    public d(a aVar, byte[] bArr) {
        this.b = new M(bArr, 0);
        this.f748a = aVar;
    }
}
