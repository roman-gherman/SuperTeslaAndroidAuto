package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1SetParser;

/* JADX INFO: loaded from: classes2.dex */
public final class G implements ASN1SetParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5031a;
    public M3.a b;

    public /* synthetic */ G(int i) {
        this.f5031a = i;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        switch (this.f5031a) {
            case 0:
                return new F(this.b.m());
            default:
                return i0.b(this.b.m());
        }
    }

    @Override // org.bouncycastle.asn1.ASN1SetParser
    public final ASN1Encodable readObject() {
        switch (this.f5031a) {
        }
        return this.b.l();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        switch (this.f5031a) {
            case 0:
                try {
                    return new F(this.b.m());
                } catch (IOException e) {
                    throw new h5.a(e.getMessage(), e);
                }
            default:
                try {
                    return getLoadedObject();
                } catch (IOException e6) {
                    throw new h5.a(e6.getMessage(), e6);
                }
        }
    }
}
