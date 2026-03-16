package w3;

import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class X extends j0 {
    @Override // w3.C0898p
    public final X c() {
        return this;
    }

    @Override // w3.j0, w3.C0898p
    public final void l(ASN1Encodable[] aSN1EncodableArr) {
        for (ASN1Encodable aSN1Encodable : aSN1EncodableArr) {
            aSN1Encodable.toASN1Primitive().h().c(this, true);
        }
    }

    @Override // w3.j0, w3.C0898p
    public final void q(AbstractC0899q abstractC0899q) {
        abstractC0899q.h().c(this, true);
    }

    @Override // w3.j0, w3.C0898p
    public final void r(AbstractC0899q[] abstractC0899qArr) {
        for (AbstractC0899q abstractC0899q : abstractC0899qArr) {
            abstractC0899q.h().c(this, true);
        }
    }
}
