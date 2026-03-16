package h5;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.encoders.Encoder;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Encoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3460a;
    public final byte[] b;

    public c() {
        byte[] bArr;
        this.f3460a = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        this.b = new byte[128];
        int i = 0;
        int i3 = 0;
        while (true) {
            bArr = this.b;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        while (true) {
            byte[] bArr2 = this.f3460a;
            if (i >= bArr2.length) {
                bArr[65] = bArr[97];
                bArr[66] = bArr[98];
                bArr[67] = bArr[99];
                bArr[68] = bArr[100];
                bArr[69] = bArr[101];
                bArr[70] = bArr[102];
                return;
            }
            bArr[bArr2[i]] = (byte) i;
            i++;
        }
    }

    public static boolean b(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    public byte[] a(int i, String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("'str' cannot be null");
        }
        if (i < 0 || str.length() - i < 0) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        }
        if ((i & 1) != 0) {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        int i3 = i >>> 1;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            char cCharAt = str.charAt(i4);
            byte[] bArr2 = this.b;
            i4 += 2;
            int i6 = bArr2[str.charAt(i4 + 1)] | (bArr2[cCharAt] << 4);
            if (i6 < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            bArr[i5] = (byte) i6;
        }
        return bArr;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[36];
        int length = str.length();
        while (length > 0 && b(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            while (i < length && b(str.charAt(i))) {
                i++;
            }
            int i5 = i + 1;
            char cCharAt = str.charAt(i);
            byte[] bArr2 = this.b;
            byte b = bArr2[cCharAt];
            while (i5 < length && b(str.charAt(i5))) {
                i5++;
            }
            int i6 = i5 + 1;
            byte b2 = bArr2[str.charAt(i5)];
            if ((b | b2) < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            int i7 = i3 + 1;
            bArr[i3] = (byte) ((b << 4) | b2);
            if (i7 == 36) {
                outputStream.write(bArr);
                i3 = 0;
            } else {
                i3 = i7;
            }
            i4++;
            i = i6;
        }
        if (i3 > 0) {
            outputStream.write(bArr, 0, i3);
        }
        return i4;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int encode(byte[] bArr, int i, int i3, OutputStream outputStream) throws IOException {
        if (i3 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i4 = i3;
        while (i4 > 0) {
            int iMin = Math.min(36, i4);
            int i5 = i + iMin;
            int i6 = 0;
            while (i < i5) {
                int i7 = i + 1;
                byte b = bArr[i];
                int i8 = i6 + 1;
                byte[] bArr3 = this.f3460a;
                bArr2[i6] = bArr3[(b & 255) >>> 4];
                i6 += 2;
                bArr2[i8] = bArr3[b & 15];
                i = i7;
            }
            outputStream.write(bArr2, 0, i6);
            i4 -= iMin;
            i = i5;
        }
        return i3 * 2;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getEncodedLength(int i) {
        return i * 2;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getMaxDecodedLength(int i) {
        return i / 2;
    }

    public /* synthetic */ c(byte[] bArr, byte[] bArr2) {
        this.f3460a = bArr;
        this.b = bArr2;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] bArr, int i, int i3, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[36];
        int i4 = i3 + i;
        while (i4 > i && b((char) bArr[i4 - 1])) {
            i4--;
        }
        int i5 = 0;
        int i6 = 0;
        while (i < i4) {
            while (i < i4 && b((char) bArr[i])) {
                i++;
            }
            int i7 = i + 1;
            byte b = bArr[i];
            byte[] bArr3 = this.b;
            byte b2 = bArr3[b];
            while (i7 < i4 && b((char) bArr[i7])) {
                i7++;
            }
            int i8 = i7 + 1;
            byte b6 = bArr3[bArr[i7]];
            if ((b2 | b6) < 0) {
                throw new IOException("invalid characters encountered in Hex data");
            }
            int i9 = i5 + 1;
            bArr2[i5] = (byte) ((b2 << 4) | b6);
            if (i9 == 36) {
                outputStream.write(bArr2);
                i5 = 0;
            } else {
                i5 = i9;
            }
            i6++;
            i = i8;
        }
        if (i5 > 0) {
            outputStream.write(bArr2, 0, i5);
        }
        return i6;
    }
}
