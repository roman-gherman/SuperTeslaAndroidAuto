package w3;

import c4.AbstractC0246d;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1BitStringParser;

/* JADX INFO: renamed from: w3.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0907z implements ASN1BitStringParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M3.a f5077a;
    public J b;

    public C0907z(M3.a aVar) {
        this.f5077a = aVar;
    }

    public static C0906y a(M3.a aVar) {
        J j6 = new J(aVar, false);
        return new C0906y(AbstractC0246d.k0(j6), j6.d);
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final InputStream getBitStream() {
        J j6 = new J(this.f5077a, false);
        this.b = j6;
        return j6;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        return a(this.f5077a);
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final InputStream getOctetStream() {
        J j6 = new J(this.f5077a, true);
        this.b = j6;
        return j6;
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final int getPadBits() {
        return this.b.d;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        try {
            return a(this.f5077a);
        } catch (IOException e) {
            throw new h5.a("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }
}
