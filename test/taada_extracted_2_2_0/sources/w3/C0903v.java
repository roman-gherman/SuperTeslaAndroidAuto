package w3;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1SetParser;

/* JADX INFO: renamed from: w3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0903v implements ASN1SetParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5075a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ AbstractC0904w c;

    public C0903v(AbstractC0904w abstractC0904w, int i) {
        this.c = abstractC0904w;
        this.b = i;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        return this.c;
    }

    @Override // org.bouncycastle.asn1.ASN1SetParser
    public final ASN1Encodable readObject() {
        int i = this.f5075a;
        if (this.b == i) {
            return null;
        }
        ASN1Encodable[] aSN1EncodableArr = this.c.f5076a;
        this.f5075a = i + 1;
        ASN1Encodable aSN1Encodable = aSN1EncodableArr[i];
        if (aSN1Encodable instanceof AbstractC0902u) {
            AbstractC0902u abstractC0902u = (AbstractC0902u) aSN1Encodable;
            return new C0901t(abstractC0902u, abstractC0902u.size());
        }
        if (!(aSN1Encodable instanceof AbstractC0904w)) {
            return aSN1Encodable;
        }
        AbstractC0904w abstractC0904w = (AbstractC0904w) aSN1Encodable;
        return new C0903v(abstractC0904w, abstractC0904w.f5076a.length);
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        return this.c;
    }
}
