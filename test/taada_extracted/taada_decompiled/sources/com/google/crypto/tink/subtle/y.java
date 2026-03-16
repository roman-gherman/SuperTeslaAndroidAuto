package com.google.crypto.tink.subtle;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class y extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f2980a;
    public final ByteBuffer b;
    public final int c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f2983h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StreamSegmentDecrypter f2984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f2986l;

    public y(r rVar, InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f2984j = rVar.f();
        this.c = rVar.d();
        this.f2983h = Arrays.copyOf(bArr, bArr.length);
        int iC = rVar.c();
        this.f2985k = iC;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iC + 1);
        this.f2980a = byteBufferAllocate;
        byteBufferAllocate.limit(0);
        this.f2986l = iC - rVar.a();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(rVar.e() + 16);
        this.b = byteBufferAllocate2;
        byteBufferAllocate2.limit(0);
        this.d = false;
        this.e = false;
        this.f2981f = false;
        this.i = 0;
        this.f2982g = false;
    }

    public final void a() throws IOException {
        byte b;
        while (!this.e && this.f2980a.remaining() > 0) {
            int i = ((FilterInputStream) this).in.read(this.f2980a.array(), this.f2980a.position(), this.f2980a.remaining());
            if (i > 0) {
                ByteBuffer byteBuffer = this.f2980a;
                byteBuffer.position(byteBuffer.position() + i);
            } else if (i == -1) {
                this.e = true;
            } else if (i == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
        }
        if (this.e) {
            b = 0;
        } else {
            ByteBuffer byteBuffer2 = this.f2980a;
            b = byteBuffer2.get(byteBuffer2.position() - 1);
            ByteBuffer byteBuffer3 = this.f2980a;
            byteBuffer3.position(byteBuffer3.position() - 1);
        }
        this.f2980a.flip();
        this.b.clear();
        try {
            this.f2984j.decryptSegment(this.f2980a, this.i, this.e, this.b);
            this.i++;
            this.b.flip();
            this.f2980a.clear();
            if (this.e) {
                return;
            }
            this.f2980a.clear();
            this.f2980a.limit(this.f2985k + 1);
            this.f2980a.put(b);
        } catch (GeneralSecurityException e) {
            this.f2982g = true;
            this.b.limit(0);
            throw new IOException(e.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.i + " endOfCiphertext:" + this.e, e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return this.b.remaining();
    }

    public final void b() throws IOException {
        if (this.d) {
            this.f2982g = true;
            this.b.limit(0);
            throw new IOException("Decryption failed.");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.c);
        while (byteBufferAllocate.remaining() > 0) {
            int i = ((FilterInputStream) this).in.read(byteBufferAllocate.array(), byteBufferAllocate.position(), byteBufferAllocate.remaining());
            if (i == -1) {
                this.f2982g = true;
                this.b.limit(0);
                throw new IOException("Ciphertext is too short");
            }
            if (i == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
            byteBufferAllocate.position(byteBufferAllocate.position() + i);
        }
        byteBufferAllocate.flip();
        try {
            this.f2984j.init(byteBufferAllocate, this.f2983h);
            this.d = true;
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        byte[] bArr = new byte[1];
        int i = read(bArr, 0, 1);
        if (i == 1) {
            return bArr[0] & 255;
        }
        if (i == -1) {
            return i;
        }
        throw new IOException("Reading failed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j6) {
        int i;
        long j7 = this.f2985k;
        if (j6 <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(j7, j6);
        byte[] bArr = new byte[iMin];
        long j8 = j6;
        while (j8 > 0 && (i = read(bArr, 0, (int) Math.min(iMin, j8))) > 0) {
            j8 -= (long) i;
        }
        return j6 - j8;
    }

    public final synchronized String toString() {
        return "StreamingAeadDecryptingStream\nsegmentNr:" + this.i + "\nciphertextSegmentSize:" + this.f2985k + "\nheaderRead:" + this.d + "\nendOfCiphertext:" + this.e + "\nendOfPlaintext:" + this.f2981f + "\ndecryptionErrorOccured:" + this.f2982g + "\nciphertextSgement position:" + this.f2980a.position() + " limit:" + this.f2980a.limit() + "\nplaintextSegment position:" + this.b.position() + " limit:" + this.b.limit();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i3) {
        try {
            if (!this.f2982g) {
                if (!this.d) {
                    b();
                    this.f2980a.clear();
                    this.f2980a.limit(this.f2986l + 1);
                }
                if (this.f2981f) {
                    return -1;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        break;
                    }
                    if (this.b.remaining() == 0) {
                        if (this.e) {
                            this.f2981f = true;
                            break;
                        }
                        a();
                    }
                    int iMin = Math.min(this.b.remaining(), i3 - i4);
                    this.b.get(bArr, i4 + i, iMin);
                    i4 += iMin;
                }
                if (i4 == 0 && this.f2981f) {
                    return -1;
                }
                return i4;
            }
            throw new IOException("Decryption failed.");
        } catch (Throwable th) {
            throw th;
        }
    }
}
