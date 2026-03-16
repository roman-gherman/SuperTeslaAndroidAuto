package w3;

import c4.AbstractC0246d;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1OctetStringParser;

/* JADX INFO: loaded from: classes2.dex */
public final class C implements ASN1OctetStringParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5029a = 1;
    public Object b;

    public /* synthetic */ C() {
    }

    public static B a(M3.a aVar) {
        return new B(AbstractC0246d.k0(new K(aVar)), null);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        switch (this.f5029a) {
            case 0:
                return a((M3.a) this.b);
            default:
                return new W(((m0) this.b).b());
        }
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    public final InputStream getOctetStream() {
        switch (this.f5029a) {
            case 0:
                return new K((M3.a) this.b);
            default:
                return (m0) this.b;
        }
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        switch (this.f5029a) {
            case 0:
                try {
                    return a((M3.a) this.b);
                } catch (IOException e) {
                    throw new h5.a("IOException converting stream to byte array: " + e.getMessage(), e);
                }
            default:
                try {
                    return getLoadedObject();
                } catch (IOException e6) {
                    throw new h5.a("IOException converting stream to byte array: " + e6.getMessage(), e6);
                }
        }
    }

    public C(M3.a aVar) {
        this.b = aVar;
    }
}
