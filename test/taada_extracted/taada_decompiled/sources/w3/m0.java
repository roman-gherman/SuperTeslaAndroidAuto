package w3;

import c4.AbstractC0246d;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends q0 {
    public static final byte[] e = new byte[0];
    public final int c;
    public int d;

    public m0(InputStream inputStream, int i, int i3) {
        super(inputStream, i3);
        if (i <= 0) {
            if (i < 0) {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
            a();
        }
        this.c = i;
        this.d = i;
    }

    public final byte[] b() {
        int i = this.d;
        if (i == 0) {
            return e;
        }
        int i3 = this.b;
        if (i >= i3) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.d + " >= " + i3);
        }
        byte[] bArr = new byte[i];
        int iO0 = i - AbstractC0246d.o0(this.f5069a, bArr, i);
        this.d = iO0;
        if (iO0 == 0) {
            a();
            return bArr;
        }
        throw new EOFException("DEF length " + this.c + " object truncated by " + this.d);
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.d == 0) {
            return -1;
        }
        int i = this.f5069a.read();
        if (i >= 0) {
            int i3 = this.d - 1;
            this.d = i3;
            if (i3 == 0) {
                a();
            }
            return i;
        }
        throw new EOFException("DEF length " + this.c + " object truncated by " + this.d);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) throws IOException {
        int i4 = this.d;
        if (i4 == 0) {
            return -1;
        }
        int i5 = this.f5069a.read(bArr, i, Math.min(i3, i4));
        if (i5 >= 0) {
            int i6 = this.d - i5;
            this.d = i6;
            if (i6 == 0) {
                a();
            }
            return i5;
        }
        throw new EOFException("DEF length " + this.c + " object truncated by " + this.d);
    }
}
