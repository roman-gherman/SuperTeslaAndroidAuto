package H3;

import org.bouncycastle.asn1.ASN1Encodable;
import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0883a;
import w3.C0886d;
import w3.C0896n;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0896n f747a;
    public ASN1Encodable b;

    public a(C0896n c0896n) {
        this.f747a = c0896n;
    }

    public static a b(Object obj) {
        C0896n c0896n;
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj == null) {
            return null;
        }
        AbstractC0902u abstractC0902uL = AbstractC0902u.l(obj);
        a aVar = new a();
        if (abstractC0902uL.size() < 1 || abstractC0902uL.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + abstractC0902uL.size());
        }
        ASN1Encodable aSN1EncodableM = abstractC0902uL.m(0);
        C0883a c0883a = C0896n.c;
        if (aSN1EncodableM == null || (aSN1EncodableM instanceof C0896n)) {
            c0896n = (C0896n) aSN1EncodableM;
        } else {
            AbstractC0899q aSN1Primitive = aSN1EncodableM.toASN1Primitive();
            if (!(aSN1Primitive instanceof C0896n)) {
                throw new IllegalArgumentException("illegal object in getInstance: ".concat(aSN1EncodableM.getClass().getName()));
            }
            c0896n = (C0896n) aSN1Primitive;
        }
        aVar.f747a = c0896n;
        if (abstractC0902uL.size() == 2) {
            aVar.b = abstractC0902uL.m(1);
            return aVar;
        }
        aVar.b = null;
        return aVar;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d(2);
        c0886d.a(this.f747a);
        ASN1Encodable aSN1Encodable = this.b;
        if (aSN1Encodable != null) {
            c0886d.a(aSN1Encodable);
        }
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }

    public a(C0896n c0896n, AbstractC0893k abstractC0893k) {
        this.f747a = c0896n;
        this.b = abstractC0893k;
    }
}
