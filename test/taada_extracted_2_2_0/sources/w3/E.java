package w3;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1SequenceParser;

/* JADX INFO: loaded from: classes2.dex */
public final class E implements ASN1SequenceParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5030a;
    public M3.a b;

    public /* synthetic */ E(int i) {
        this.f5030a = i;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        switch (this.f5030a) {
            case 0:
                return new D(this.b.m());
            default:
                return i0.a(this.b.m());
        }
    }

    @Override // org.bouncycastle.asn1.ASN1SequenceParser
    public final ASN1Encodable readObject() {
        switch (this.f5030a) {
        }
        return this.b.l();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        switch (this.f5030a) {
            case 0:
                try {
                    return new D(this.b.m());
                } catch (IOException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            default:
                try {
                    return getLoadedObject();
                } catch (IOException e6) {
                    throw new IllegalStateException(e6.getMessage());
                }
        }
    }
}
