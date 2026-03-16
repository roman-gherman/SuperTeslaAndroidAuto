package w3;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends q0 {
    public int c;
    public int d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5065f;

    public n0(InputStream inputStream, int i) throws IOException {
        super(inputStream, i);
        this.e = false;
        this.f5065f = true;
        this.c = inputStream.read();
        int i3 = inputStream.read();
        this.d = i3;
        if (i3 < 0) {
            throw new EOFException();
        }
        b();
    }

    public final boolean b() {
        if (!this.e && this.f5065f && this.c == 0 && this.d == 0) {
            this.e = true;
            a();
        }
        return this.e;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (b()) {
            return -1;
        }
        int i = this.f5069a.read();
        if (i < 0) {
            throw new EOFException();
        }
        int i3 = this.c;
        this.c = this.d;
        this.d = i;
        return i3;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) throws IOException {
        if (this.f5065f || i3 < 3) {
            return super.read(bArr, i, i3);
        }
        if (this.e) {
            return -1;
        }
        InputStream inputStream = this.f5069a;
        int i4 = inputStream.read(bArr, i + 2, i3 - 2);
        if (i4 < 0) {
            throw new EOFException();
        }
        bArr[i] = (byte) this.c;
        bArr[i + 1] = (byte) this.d;
        this.c = inputStream.read();
        int i5 = inputStream.read();
        this.d = i5;
        if (i5 >= 0) {
            return i4 + 2;
        }
        throw new EOFException();
    }
}
