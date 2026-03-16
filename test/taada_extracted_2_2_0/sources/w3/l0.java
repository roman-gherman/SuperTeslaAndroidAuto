package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 extends I {
    public final boolean d;

    public l0(int i, int i3, boolean z6, M3.a aVar) {
        super(i, i3, aVar);
        this.d = z6;
    }

    @Override // w3.I, org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() throws IOException {
        M3.a aVar = this.c;
        boolean z6 = this.d;
        int i = 4;
        int i3 = this.f5033a;
        int i4 = this.b;
        if (!z6) {
            return new H(i, i3, i4, new W(((m0) ((q0) aVar.d)).b()), 2);
        }
        C0886d c0886dM = aVar.m();
        if (c0886dM.b != 1) {
            return new H(i, i3, i4, i0.a(c0886dM), 2);
        }
        return new H(3, i3, i4, c0886dM.b(0), 2);
    }

    @Override // w3.I, org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final ASN1Encodable parseBaseUniversal(boolean z6, int i) throws IOException {
        M3.a aVar = this.c;
        boolean z7 = this.d;
        if (!z6) {
            return z7 ? aVar.g(i) : aVar.i(i, (m0) ((q0) aVar.d));
        }
        if (z7) {
            return aVar.j(i);
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // w3.I, org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final ASN1Encodable parseExplicitBaseObject() throws IOException {
        if (this.d) {
            return this.c.l();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // w3.I, org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException {
        if (this.d) {
            return this.c.k();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // w3.I, org.bouncycastle.asn1.ASN1TaggedObjectParser
    public final ASN1TaggedObjectParser parseImplicitBaseTagged(int i, int i3) {
        return new l0(i, i3, this.d, this.c);
    }
}
