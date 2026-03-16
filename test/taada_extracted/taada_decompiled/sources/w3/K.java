package w3;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetStringParser;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M3.a f5035a;
    public boolean b = true;
    public InputStream c;

    public K(M3.a aVar) {
        this.f5035a = aVar;
    }

    public final ASN1OctetStringParser a() throws IOException {
        ASN1Encodable aSN1EncodableL = this.f5035a.l();
        if (aSN1EncodableL == null) {
            return null;
        }
        if (aSN1EncodableL instanceof ASN1OctetStringParser) {
            return (ASN1OctetStringParser) aSN1EncodableL;
        }
        throw new IOException("unknown object encountered: " + aSN1EncodableL.getClass());
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        ASN1OctetStringParser aSN1OctetStringParserA;
        if (this.c == null) {
            if (!this.b || (aSN1OctetStringParserA = a()) == null) {
                return -1;
            }
            this.b = false;
            this.c = aSN1OctetStringParserA.getOctetStream();
        }
        while (true) {
            int i = this.c.read();
            if (i >= 0) {
                return i;
            }
            ASN1OctetStringParser aSN1OctetStringParserA2 = a();
            if (aSN1OctetStringParserA2 == null) {
                this.c = null;
                return -1;
            }
            this.c = aSN1OctetStringParserA2.getOctetStream();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) throws IOException {
        ASN1OctetStringParser aSN1OctetStringParserA;
        int i4 = 0;
        if (this.c == null) {
            if (!this.b || (aSN1OctetStringParserA = a()) == null) {
                return -1;
            }
            this.b = false;
            this.c = aSN1OctetStringParserA.getOctetStream();
        }
        while (true) {
            int i5 = this.c.read(bArr, i + i4, i3 - i4);
            if (i5 >= 0) {
                i4 += i5;
                if (i4 == i3) {
                    return i4;
                }
            } else {
                ASN1OctetStringParser aSN1OctetStringParserA2 = a();
                if (aSN1OctetStringParserA2 == null) {
                    this.c = null;
                    if (i4 < 1) {
                        return -1;
                    }
                    return i4;
                }
                this.c = aSN1OctetStringParserA2.getOctetStream();
            }
        }
    }
}
