package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* JADX INFO: loaded from: classes2.dex */
public class I implements ASN1TaggedObjectParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5032a;
    public final int b;
    public final M3.a c;

    public I(int i, int i3, M3.a aVar) {
        this.f5032a = i;
        this.b = i3;
        this.c = aVar;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public AbstractC0899q getLoadedObject() {
        return this.c.f(this.f5032a, this.b);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final int getTagClass() {
        return this.f5032a;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final int getTagNo() {
        return this.b;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final boolean hasContextTag() {
        return this.f5032a == 128;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final boolean hasTag(int i, int i3) {
        return this.f5032a == i && this.b == i3;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final boolean hasTagClass(int i) {
        return this.f5032a == i;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseBaseUniversal(boolean z6, int i) {
        M3.a aVar = this.c;
        return z6 ? aVar.j(i) : aVar.h(i);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseExplicitBaseObject() {
        return this.c.l();
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseExplicitBaseTagged() {
        return this.c.k();
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i, int i3) {
        return new I(i, i3, this.c);
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new h5.a(e.getMessage(), 2);
        }
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final boolean hasContextTag(int i) {
        return this.f5032a == 128 && this.b == i;
    }
}
