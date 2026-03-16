package w3;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1BitStringParser;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements ASN1BitStringParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f5059a;
    public int b = 0;

    public h0(m0 m0Var) {
        this.f5059a = m0Var;
    }

    public final m0 a(boolean z6) throws IOException {
        m0 m0Var = this.f5059a;
        int i = m0Var.d;
        if (i < 1) {
            throw new IllegalStateException("content octets cannot be empty");
        }
        int i3 = m0Var.read();
        this.b = i3;
        if (i3 > 0) {
            if (i < 2) {
                throw new IllegalStateException("zero length data with non-zero pad bits");
            }
            if (i3 > 7) {
                throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
            }
            if (z6) {
                throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.b);
            }
        }
        return m0Var;
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final InputStream getBitStream() {
        return a(false);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        return AbstractC0884b.j(this.f5059a.b());
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final InputStream getOctetStream() {
        return a(true);
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final int getPadBits() {
        return this.b;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new h5.a("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }
}
