package L0;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f948a;

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f948a++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f948a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i3) {
        int i4;
        if (i >= 0 && i <= bArr.length && i3 >= 0 && (i4 = i + i3) <= bArr.length && i4 >= 0) {
            this.f948a += (long) i3;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
