package w3;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1BitStringParser;
import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M3.a f5033a;
    public final boolean b;
    public boolean c = true;
    public int d = 0;
    public ASN1BitStringParser e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InputStream f5034f;

    public J(M3.a aVar, boolean z6) {
        this.f5033a = aVar;
        this.b = z6;
    }

    public final ASN1BitStringParser a() throws IOException {
        ASN1Encodable aSN1EncodableL = this.f5033a.l();
        if (aSN1EncodableL == null) {
            if (!this.b || this.d == 0) {
                return null;
            }
            throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.d);
        }
        if (aSN1EncodableL instanceof ASN1BitStringParser) {
            if (this.d == 0) {
                return (ASN1BitStringParser) aSN1EncodableL;
            }
            throw new IOException("only the last nested bitstring can have padding");
        }
        throw new IOException("unknown object encountered: " + aSN1EncodableL.getClass());
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f5034f == null) {
            if (this.c) {
                ASN1BitStringParser aSN1BitStringParserA = a();
                this.e = aSN1BitStringParserA;
                if (aSN1BitStringParserA != null) {
                    this.c = false;
                    this.f5034f = aSN1BitStringParserA.getBitStream();
                }
            }
            return -1;
        }
        while (true) {
            int i = this.f5034f.read();
            if (i >= 0) {
                return i;
            }
            this.d = this.e.getPadBits();
            ASN1BitStringParser aSN1BitStringParserA2 = a();
            this.e = aSN1BitStringParserA2;
            if (aSN1BitStringParserA2 == null) {
                this.f5034f = null;
                return -1;
            }
            this.f5034f = aSN1BitStringParserA2.getBitStream();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) throws IOException {
        int i4 = 0;
        if (this.f5034f == null) {
            if (!this.c) {
                return -1;
            }
            ASN1BitStringParser aSN1BitStringParserA = a();
            this.e = aSN1BitStringParserA;
            if (aSN1BitStringParserA == null) {
                return -1;
            }
            this.c = false;
            this.f5034f = aSN1BitStringParserA.getBitStream();
        }
        while (true) {
            int i5 = this.f5034f.read(bArr, i + i4, i3 - i4);
            if (i5 >= 0) {
                i4 += i5;
                if (i4 == i3) {
                    return i4;
                }
            } else {
                this.d = this.e.getPadBits();
                ASN1BitStringParser aSN1BitStringParserA2 = a();
                this.e = aSN1BitStringParserA2;
                if (aSN1BitStringParserA2 == null) {
                    this.f5034f = null;
                    if (i4 < 1) {
                        return -1;
                    }
                    return i4;
                }
                this.f5034f = aSN1BitStringParserA2.getBitStream();
            }
        }
    }
}
