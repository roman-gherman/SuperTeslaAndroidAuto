package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ExternalParser;

/* JADX INFO: loaded from: classes2.dex */
public final class O implements ASN1ExternalParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M3.a f5041a;

    public O(M3.a aVar) {
        this.f5041a = aVar;
    }

    public static N a(M3.a aVar) throws C0888f {
        try {
            Z z6 = new Z(aVar.m(), 1);
            z6.d = -1;
            return new N(z6, 1);
        } catch (IllegalArgumentException e) {
            throw new C0888f(e, e.getMessage());
        }
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        return a(this.f5041a);
    }

    @Override // org.bouncycastle.asn1.ASN1ExternalParser
    public final ASN1Encodable readObject() {
        return this.f5041a.l();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        try {
            return a(this.f5041a);
        } catch (IOException e) {
            throw new h5.a("unable to get DER object", e);
        } catch (IllegalArgumentException e6) {
            throw new h5.a("unable to get DER object", e6);
        }
    }
}
