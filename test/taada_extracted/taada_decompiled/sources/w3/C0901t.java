package w3;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1SequenceParser;

/* JADX INFO: renamed from: w3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0901t implements ASN1SequenceParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5072a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ AbstractC0902u c;

    public C0901t(AbstractC0902u abstractC0902u, int i) {
        this.c = abstractC0902u;
        this.b = i;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        return this.c;
    }

    @Override // org.bouncycastle.asn1.ASN1SequenceParser
    public final ASN1Encodable readObject() {
        int i = this.f5072a;
        if (this.b == i) {
            return null;
        }
        ASN1Encodable[] aSN1EncodableArr = this.c.f5073a;
        this.f5072a = i + 1;
        ASN1Encodable aSN1Encodable = aSN1EncodableArr[i];
        if (aSN1Encodable instanceof AbstractC0902u) {
            AbstractC0902u abstractC0902u = (AbstractC0902u) aSN1Encodable;
            return new C0901t(abstractC0902u, abstractC0902u.size());
        }
        if (!(aSN1Encodable instanceof AbstractC0904w)) {
            return aSN1Encodable;
        }
        AbstractC0904w abstractC0904w = (AbstractC0904w) aSN1Encodable;
        return new C0903v(abstractC0904w, abstractC0904w.f5075a.length);
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        return this.c;
    }
}
