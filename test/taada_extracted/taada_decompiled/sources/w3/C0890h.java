package w3;

import c4.AbstractC0246d;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.BERTags;

/* JADX INFO: renamed from: w3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0890h extends FilterInputStream implements BERTags {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5057a;
    public final boolean b;
    public final byte[][] c;

    public C0890h(ByteArrayInputStream byteArrayInputStream, int i, boolean z6) {
        this(byteArrayInputStream, i, z6, new byte[11][]);
    }

    public static AbstractC0899q b(int i, m0 m0Var, byte[][] bArr) throws IOException {
        try {
            switch (i) {
                case 1:
                    return C0885c.j(d(m0Var, bArr));
                case 2:
                    return new C0891i(m0Var.b());
                case 3:
                    return AbstractC0884b.j(m0Var.b());
                case 4:
                    return new W(m0Var.b());
                case 5:
                    if (m0Var.b().length == 0) {
                        return U.b;
                    }
                    throw new IllegalStateException("malformed NULL encoding encountered");
                case 6:
                    C0896n.k(m0Var.d);
                    return C0896n.l(d(m0Var, bArr), true);
                case 7:
                    return new C0894l(new S(m0Var.b()));
                case 8:
                case 9:
                case 11:
                case 15:
                case 16:
                case 17:
                case 29:
                default:
                    throw new IOException("unknown tag " + i + " encountered");
                case 10:
                    return C0887e.j(d(m0Var, bArr), true);
                case 12:
                    return new c0(m0Var.b());
                case 13:
                    int i3 = m0Var.d;
                    C0883a c0883a = r.c;
                    if (i3 <= 4096) {
                        return r.j(d(m0Var, bArr), true);
                    }
                    throw new IllegalArgumentException("exceeded relative OID contents length limit");
                case 14:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                    throw new IOException("unsupported tag " + i + " encountered");
                case 18:
                    return new V(m0Var.b());
                case 19:
                    return new Y(m0Var.b());
                case 20:
                    return new b0(m0Var.b());
                case 21:
                    return new e0(m0Var.b());
                case 22:
                    return new T(m0Var.b());
                case 23:
                    return new C0905x(m0Var.b());
                case 24:
                    return new C0889g(m0Var.b());
                case 25:
                    return new S(m0Var.b());
                case 26:
                    return new f0(m0Var.b());
                case 27:
                    return new P(m0Var.b());
                case 28:
                    return new d0(m0Var.b());
                case 30:
                    return new L(c(m0Var));
            }
        } catch (IllegalArgumentException e) {
            throw new C0888f(e, e.getMessage());
        } catch (IllegalStateException e6) {
            throw new C0888f(e6, e6.getMessage());
        }
    }

    public static char[] c(m0 m0Var) throws IOException {
        int i = m0Var.d;
        if ((i & 1) != 0) {
            throw new IOException("malformed BMPString encoding encountered");
        }
        int i3 = i / 2;
        char[] cArr = new char[i3];
        byte[] bArr = new byte[8];
        int i4 = 0;
        int i5 = 0;
        while (i >= 8) {
            if (AbstractC0246d.o0(m0Var, bArr, 8) != 8) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            cArr[i5] = (char) ((bArr[0] << 8) | (bArr[1] & 255));
            cArr[i5 + 1] = (char) ((bArr[2] << 8) | (bArr[3] & 255));
            cArr[i5 + 2] = (char) ((bArr[4] << 8) | (bArr[5] & 255));
            cArr[i5 + 3] = (char) ((bArr[6] << 8) | (bArr[7] & 255));
            i5 += 4;
            i -= 8;
        }
        if (i > 0) {
            if (AbstractC0246d.o0(m0Var, bArr, i) != i) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            do {
                int i6 = i4 + 1;
                int i7 = bArr[i4] << 8;
                i4 += 2;
                cArr[i5] = (char) ((bArr[i6] & 255) | i7);
                i5++;
            } while (i4 < i);
        }
        if (m0Var.d == 0 && i3 == i5) {
            return cArr;
        }
        throw new IllegalStateException();
    }

    public static byte[] d(m0 m0Var, byte[][] bArr) throws IOException {
        int i = m0Var.d;
        if (i >= bArr.length) {
            return m0Var.b();
        }
        byte[] bArr2 = bArr[i];
        if (bArr2 == null) {
            bArr2 = new byte[i];
            bArr[i] = bArr2;
        }
        if (i != bArr2.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        }
        if (i == 0) {
            return bArr2;
        }
        int i3 = m0Var.b;
        if (i >= i3) {
            throw new IOException("corrupted stream - out of bounds length found: " + m0Var.d + " >= " + i3);
        }
        int iO0 = i - AbstractC0246d.o0(m0Var.f5069a, bArr2, bArr2.length);
        m0Var.d = iO0;
        if (iO0 == 0) {
            m0Var.a();
            return bArr2;
        }
        throw new EOFException("DEF length " + m0Var.c + " object truncated by " + m0Var.d);
    }

    public static int e(InputStream inputStream, int i, boolean z6) {
        int i3 = inputStream.read();
        if ((i3 >>> 7) == 0) {
            return i3;
        }
        if (128 == i3) {
            return -1;
        }
        if (i3 < 0) {
            throw new EOFException("EOF found when length expected");
        }
        if (255 == i3) {
            throw new IOException("invalid long form definite-length 0xFF");
        }
        int i4 = i3 & 127;
        int i5 = 0;
        int i6 = 0;
        do {
            int i7 = inputStream.read();
            if (i7 < 0) {
                throw new EOFException("EOF found reading length");
            }
            if ((i5 >>> 23) != 0) {
                throw new IOException("long form definite-length more than 31 bits");
            }
            i5 = (i5 << 8) + i7;
            i6++;
        } while (i6 < i4);
        if (i5 < i || z6) {
            return i5;
        }
        throw new IOException(androidx.constraintlayout.core.motion.a.n("corrupted stream - out of bounds length found: ", i5, " >= ", i));
    }

    public static int g(int i, InputStream inputStream) {
        int i3 = i & 31;
        if (i3 != 31) {
            return i3;
        }
        int i4 = inputStream.read();
        if (i4 < 31) {
            if (i4 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            throw new IOException("corrupted stream - high tag number < 31 found");
        }
        int i5 = i4 & 127;
        if (i5 == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        while ((i4 & 128) != 0) {
            if ((i5 >>> 24) != 0) {
                throw new IOException("Tag number more than 31 bits");
            }
            int i6 = i5 << 7;
            int i7 = inputStream.read();
            if (i7 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            i5 = i6 | (i7 & 127);
            i4 = i7;
        }
        return i5;
    }

    public final AbstractC0899q a(int i, int i3, int i4) throws IOException {
        m0 m0Var = new m0(this, i4, this.f5057a);
        if ((i & 224) == 0) {
            return b(i3, m0Var, this.c);
        }
        int i5 = i & 192;
        int i6 = 3;
        int i7 = 0;
        int i8 = 4;
        if (i5 != 0) {
            if ((i & 32) == 0) {
                return new H(i8, i5, i3, new W(m0Var.b()), 2);
            }
            C0886d c0886dH = h(m0Var);
            return c0886dH.b == 1 ? new H(i6, i5, i3, c0886dH.b(0), 2) : new H(i8, i5, i3, i0.a(c0886dH), 2);
        }
        if (i3 == 3) {
            C0886d c0886dH2 = h(m0Var);
            int i9 = c0886dH2.b;
            AbstractC0884b[] abstractC0884bArr = new AbstractC0884b[i9];
            while (i7 != i9) {
                ASN1Encodable aSN1EncodableB = c0886dH2.b(i7);
                if (!(aSN1EncodableB instanceof AbstractC0884b)) {
                    throw new C0888f("unknown object encountered in constructed BIT STRING: " + aSN1EncodableB.getClass());
                }
                abstractC0884bArr[i7] = (AbstractC0884b) aSN1EncodableB;
                i7++;
            }
            return new C0906y(abstractC0884bArr);
        }
        if (i3 == 4) {
            C0886d c0886dH3 = h(m0Var);
            int i10 = c0886dH3.b;
            AbstractC0897o[] abstractC0897oArr = new AbstractC0897o[i10];
            while (i7 != i10) {
                ASN1Encodable aSN1EncodableB2 = c0886dH3.b(i7);
                if (!(aSN1EncodableB2 instanceof AbstractC0897o)) {
                    throw new C0888f("unknown object encountered in constructed OCTET STRING: " + aSN1EncodableB2.getClass());
                }
                abstractC0897oArr[i7] = (AbstractC0897o) aSN1EncodableB2;
                i7++;
            }
            return new B(B.k(abstractC0897oArr), abstractC0897oArr);
        }
        if (i3 == 8) {
            Z zA = i0.a(h(m0Var));
            zA.getClass();
            return new N(zA, 1);
        }
        if (i3 != 16) {
            if (i3 == 17) {
                return i0.b(h(m0Var));
            }
            throw new IOException(B2.b.d(i3, "unknown tag ", " encountered"));
        }
        if (m0Var.d < 1) {
            return i0.f5060a;
        }
        if (!this.b) {
            return i0.a(h(m0Var));
        }
        byte[] bArrB = m0Var.b();
        p0 p0Var = new p0();
        p0Var.c = bArrB;
        return p0Var;
    }

    public final AbstractC0899q f() {
        int i = read();
        if (i <= 0) {
            if (i != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int iG = g(i, this);
        int i3 = this.f5057a;
        int iE = e(this, i3, false);
        if (iE >= 0) {
            try {
                return a(i, iG, iE);
            } catch (IllegalArgumentException e) {
                throw new C0888f(e, "corrupted stream detected");
            }
        }
        if ((i & 32) == 0) {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
        M3.a aVar = new M3.a(new n0(this, i3), i3, this.c);
        int i4 = i & 192;
        if (i4 != 0) {
            return aVar.f(i4, iG);
        }
        if (iG == 3) {
            return C0907z.a(aVar);
        }
        if (iG == 4) {
            return C.a(aVar);
        }
        if (iG == 8) {
            return O.a(aVar);
        }
        if (iG == 16) {
            return new D(aVar.m());
        }
        if (iG == 17) {
            return new F(aVar.m());
        }
        throw new IOException("unknown BER object encountered");
    }

    public final C0886d h(m0 m0Var) {
        C0890h c0890h;
        AbstractC0899q abstractC0899qF;
        int i = m0Var.d;
        if (i >= 1 && (abstractC0899qF = (c0890h = new C0890h(m0Var, i, this.b, this.c)).f()) != null) {
            C0886d c0886d = new C0886d();
            do {
                c0886d.a(abstractC0899qF);
                abstractC0899qF = c0890h.f();
            } while (abstractC0899qF != null);
            return c0886d;
        }
        return new C0886d(0);
    }

    public C0890h(InputStream inputStream, int i, boolean z6, byte[][] bArr) {
        super(inputStream);
        this.f5057a = i;
        this.b = z6;
        this.c = bArr;
    }

    public C0890h(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length, true);
    }
}
