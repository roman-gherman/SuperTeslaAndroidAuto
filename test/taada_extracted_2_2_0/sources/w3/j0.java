package w3;

import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public class j0 extends C0898p {
    @Override // w3.C0898p
    public final j0 d() {
        return this;
    }

    @Override // w3.C0898p
    public void l(ASN1Encodable[] aSN1EncodableArr) {
        for (ASN1Encodable aSN1Encodable : aSN1EncodableArr) {
            aSN1Encodable.toASN1Primitive().i().c(this, true);
        }
    }

    @Override // w3.C0898p
    public void q(AbstractC0899q abstractC0899q) {
        abstractC0899q.i().c(this, true);
    }

    @Override // w3.C0898p
    public void r(AbstractC0899q[] abstractC0899qArr) {
        for (AbstractC0899q abstractC0899q : abstractC0899qArr) {
            abstractC0899q.i().c(this, true);
        }
    }
}
