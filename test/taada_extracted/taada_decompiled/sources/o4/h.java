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

/* JADX INFO: loaded from: classes2.dex */
public final class h extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4368a;
    public byte[] b;
    public byte[] c;
    public i d;

    public static h b(AbstractC0902u abstractC0902u) {
        i iVar = null;
        if (abstractC0902u == null) {
            return null;
        }
        AbstractC0902u abstractC0902uL = AbstractC0902u.l(abstractC0902u);
        h hVar = new h();
        int iM = C0891i.j(abstractC0902uL.m(0)).m();
        hVar.f4368a = iM;
        if (iM != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        hVar.b = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(1)).f5066a);
        hVar.c = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(2)).f5066a);
        if (abstractC0902uL.size() == 4) {
            ASN1Encodable aSN1EncodableM = abstractC0902uL.m(3);
            if (aSN1EncodableM instanceof i) {
                iVar = (i) aSN1EncodableM;
            } else if (aSN1EncodableM != null) {
                AbstractC0902u abstractC0902uL2 = AbstractC0902u.l(aSN1EncodableM);
                iVar = new i();
                iVar.f4369a = g5.c.c(AbstractC0897o.j(abstractC0902uL2.m(0)).f5066a);
                iVar.b = g5.c.c(AbstractC0897o.j(abstractC0902uL2.m(1)).f5066a);
            }
            hVar.d = iVar;
        }
        return hVar;
    }

    public final i c() {
        return this.d;
    }

    public final byte[] d() {
        return g5.c.c(this.c);
    }

    public final byte[] e() {
        return g5.c.c(this.b);
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new C0891i(this.f4368a));
        c0886d.a(new W(this.b));
        c0886d.a(new W(this.c));
        i iVar = this.d;
        if (iVar != null) {
            byte[] bArrC = g5.c.c(iVar.f4369a);
            byte[] bArrC2 = g5.c.c(iVar.b);
            i iVar2 = new i();
            iVar2.f4369a = bArrC;
            iVar2.b = bArrC2;
            c0886d.a(iVar2);
        }
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }
}
