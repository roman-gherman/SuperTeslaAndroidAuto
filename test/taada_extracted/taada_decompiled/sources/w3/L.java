package w3;

import java.io.IOException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1String;

/* JADX INFO: loaded from: classes2.dex */
public final class L extends AbstractC0899q implements ASN1String {
    public static final C0883a b = new C0883a(L.class, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f5036a;

    public L(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        int length = bArr.length;
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("malformed BMPString encoding encountered");
        }
        int i = length / 2;
        char[] cArr = new char[i];
        for (int i3 = 0; i3 != i; i3++) {
            int i4 = i3 * 2;
            cArr[i3] = (char) ((bArr[i4 + 1] & 255) | (bArr[i4] << 8));
        }
        this.f5036a = cArr;
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof L)) {
            return false;
        }
        return Arrays.equals(this.f5036a, ((L) abstractC0899q).f5036a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        char[] cArr = this.f5036a;
        int length = cArr.length;
        c0898p.p(30, z6);
        c0898p.k(length * 2);
        byte[] bArr = new byte[8];
        int i = length & (-4);
        int i3 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            char c6 = cArr[i3 + 1];
            char c7 = cArr[i3 + 2];
            char c8 = cArr[i3 + 3];
            i3 += 4;
            bArr[0] = (byte) (c >> '\b');
            bArr[1] = (byte) c;
            bArr[2] = (byte) (c6 >> '\b');
            bArr[3] = (byte) c6;
            bArr[4] = (byte) (c7 >> '\b');
            bArr[5] = (byte) c7;
            bArr[6] = (byte) (c8 >> '\b');
            bArr[7] = (byte) c8;
            c0898p.j(bArr, 0, 8);
        }
        if (i3 < length) {
            int i4 = 0;
            do {
                char c9 = cArr[i3];
                i3++;
                int i5 = i4 + 1;
                bArr[i4] = (byte) (c9 >> '\b');
                i4 += 2;
                bArr[i5] = (byte) c9;
            } while (i3 < length);
            c0898p.j(bArr, 0, i4);
        }
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5036a.length * 2, z6);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public final String getString() {
        return new String(this.f5036a);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        char[] cArr = this.f5036a;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }

    public final String toString() {
        return getString();
    }

    public L(char[] cArr) {
        this.f5036a = cArr;
    }
}
