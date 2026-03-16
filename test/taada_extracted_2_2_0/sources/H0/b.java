package H0;

import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.j;
import com.google.crypto.tink.l;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f730a;
    public InputStream b;
    public InputStream c;
    public l d;
    public byte[] e;

    @Override // java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream = this.b;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.c.close();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) != 1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i3) {
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = this.b;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i3);
        }
        if (!this.f730a) {
            this.f730a = true;
            Iterator it = this.d.a(com.google.crypto.tink.a.f2791a).iterator();
            while (it.hasNext()) {
                try {
                    try {
                        InputStream inputStreamNewDecryptingStream = ((StreamingAead) ((j) it.next()).b).newDecryptingStream(this.c, this.e);
                        int i4 = inputStreamNewDecryptingStream.read(bArr, i, i3);
                        if (i4 != 0) {
                            this.b = inputStreamNewDecryptingStream;
                            this.c.mark(0);
                            return i4;
                        }
                        throw new IOException("Could not read bytes from the ciphertext stream");
                    } catch (IOException unused) {
                        this.c.reset();
                    }
                } catch (GeneralSecurityException unused2) {
                    this.c.reset();
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
    }
}
