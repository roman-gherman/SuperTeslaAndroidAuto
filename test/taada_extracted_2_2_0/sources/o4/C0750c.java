package o4;

import org.bouncycastle.asn1.ASN1Encodable;
import w3.AbstractC0893k;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0886d;
import w3.C0891i;
import w3.W;
import w3.Z;

/* JADX INFO: renamed from: o4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0750c extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4363a = 0;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public d e;

    public C0750c(byte[] bArr, byte[] bArr2, byte[] bArr3, d dVar) {
        this.b = bArr;
        this.c = bArr2;
        this.d = bArr3;
        this.e = dVar;
    }

    public static C0750c b(AbstractC0899q abstractC0899q) {
        d dVar = null;
        if (abstractC0899q == null) {
            return null;
        }
        AbstractC0902u abstractC0902uL = AbstractC0902u.l(abstractC0899q);
        C0750c c0750c = new C0750c();
        int iM = C0891i.j(abstractC0902uL.m(0)).m();
        c0750c.f4363a = iM;
        if (iM != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        c0750c.b = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(1)).f5067a);
        c0750c.c = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(2)).f5067a);
        c0750c.d = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(3)).f5067a);
        if (abstractC0902uL.size() == 5) {
            ASN1Encodable aSN1EncodableM = abstractC0902uL.m(4);
            if (aSN1EncodableM instanceof d) {
                dVar = (d) aSN1EncodableM;
            } else if (aSN1EncodableM != null) {
                AbstractC0902u abstractC0902uL2 = AbstractC0902u.l(aSN1EncodableM);
                dVar = new d();
                dVar.f4364a = g5.c.c(AbstractC0897o.j(abstractC0902uL2.m(0)).f5067a);
            }
            c0750c.e = dVar;
        }
        return c0750c;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new C0891i(this.f4363a));
        c0886d.a(new W(this.b));
        c0886d.a(new W(this.c));
        c0886d.a(new W(this.d));
        d dVar = this.e;
        if (dVar != null) {
            c0886d.a(new d(dVar.f4364a));
        }
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }
}
