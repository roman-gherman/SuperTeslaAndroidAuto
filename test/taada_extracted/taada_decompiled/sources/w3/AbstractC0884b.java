package w3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1BitStringParser;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1String;

/* JADX INFO: renamed from: w3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0884b extends AbstractC0899q implements ASN1String, ASN1BitStringParser {
    public static final C0883a b = new C0883a(AbstractC0884b.class, 1);
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5046a;

    public AbstractC0884b(byte[] bArr) {
        this.f5046a = bArr;
    }

    public static AbstractC0884b j(byte[] bArr) {
        int length = bArr.length;
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i = bArr[0] & 255;
        if (i > 0) {
            if (i > 7 || length < 2) {
                throw new IllegalArgumentException("invalid pad bits detected");
            }
            byte b2 = bArr[length - 1];
            if (b2 != ((byte) ((255 << i) & b2))) {
                return new g0(bArr);
            }
        }
        return new M(bArr);
    }

    public static byte[] l(int i) {
        if (i == 0) {
            return new byte[0];
        }
        int i3 = 4;
        for (int i4 = 3; i4 >= 1 && ((255 << (i4 * 8)) & i) == 0; i4--) {
            i3--;
        }
        byte[] bArr = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) ((i >> (i5 * 8)) & 255);
        }
        return bArr;
    }

    public static AbstractC0884b m(Object obj) {
        if (obj == null || (obj instanceof AbstractC0884b)) {
            return (AbstractC0884b) obj;
        }
        if (obj instanceof ASN1Encodable) {
            AbstractC0899q aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof AbstractC0884b) {
                return (AbstractC0884b) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (AbstractC0884b) b.d((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(obj.getClass().getName()));
    }

    public static int o(int i) {
        int i3;
        int i4 = 3;
        while (true) {
            if (i4 < 0) {
                i3 = 0;
                break;
            }
            if (i4 != 0) {
                int i5 = i >> (i4 * 8);
                if (i5 != 0) {
                    i3 = i5 & 255;
                    break;
                }
                i4--;
            } else {
                if (i != 0) {
                    i3 = i & 255;
                    break;
                }
                i4--;
            }
        }
        if (i3 == 0) {
            return 0;
        }
        int i6 = 1;
        while (true) {
            i3 <<= 1;
            if ((i3 & 255) == 0) {
                return 8 - i6;
            }
            i6++;
        }
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof AbstractC0884b)) {
            return false;
        }
        byte[] bArr = ((AbstractC0884b) abstractC0899q).f5046a;
        byte[] bArr2 = this.f5046a;
        int length = bArr2.length;
        if (bArr.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i = length - 1;
        for (int i3 = 0; i3 < i; i3++) {
            if (bArr2[i3] != bArr[i3]) {
                return false;
            }
        }
        int i4 = 255 << (bArr2[0] & 255);
        return ((byte) (bArr2[i] & i4)) == ((byte) (bArr[i] & i4));
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final InputStream getBitStream() {
        byte[] bArr = this.f5046a;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final AbstractC0899q getLoadedObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final InputStream getOctetStream() throws IOException {
        int i = this.f5046a[0] & 255;
        if (i == 0) {
            return getBitStream();
        }
        throw new IOException(B2.b.c(i, "expected octet-aligned bitstring, but found padBits: "));
    }

    @Override // org.bouncycastle.asn1.ASN1BitStringParser
    public final int getPadBits() {
        return this.f5046a[0] & 255;
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        try {
            byte[] encoded = getEncoded();
            StringBuffer stringBuffer = new StringBuffer((encoded.length * 2) + 1);
            stringBuffer.append('#');
            for (int i = 0; i != encoded.length; i++) {
                byte b2 = encoded[i];
                char[] cArr = c;
                stringBuffer.append(cArr[(b2 >>> 4) & 15]);
                stringBuffer.append(cArr[b2 & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new h5.a("Internal error encoding BitString: " + e.getMessage(), e);
        }
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q h() {
        return new M(this.f5046a);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        byte[] bArr = this.f5046a;
        if (bArr.length < 2) {
            return 1;
        }
        int i = 0;
        int i3 = bArr[0] & 255;
        int length = bArr.length;
        int i4 = length - 1;
        byte b2 = (byte) ((255 << i3) & bArr[i4]);
        if (bArr != null) {
            i = length;
            while (true) {
                i4--;
                if (i4 < 0) {
                    break;
                }
                i = (i * 257) ^ bArr[i4];
            }
        }
        return (i * 257) ^ b2;
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q i() {
        return new g0(this.f5046a);
    }

    public final byte[] k() {
        byte[] bArr = this.f5046a;
        if (bArr.length == 1) {
            return AbstractC0897o.c;
        }
        int i = bArr[0] & 255;
        byte[] bArrH = g5.c.h(bArr, 1, bArr.length);
        int length = bArrH.length - 1;
        bArrH[length] = (byte) (((byte) (255 << i)) & bArrH[length]);
        return bArrH;
    }

    public final byte[] n() {
        byte[] bArr = this.f5046a;
        if (bArr[0] == 0) {
            return g5.c.h(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public final String toString() {
        return getString();
    }

    public AbstractC0884b(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 1];
        System.arraycopy(bArr, 0, bArr2, 1, length);
        bArr2[0] = (byte) i;
        this.f5046a = bArr2;
    }
}
