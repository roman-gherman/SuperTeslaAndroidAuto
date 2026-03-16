package com.google.crypto.tink.subtle;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class A extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StreamSegmentEncrypter f2930a;
    public final int b;
    public final ByteBuffer c;
    public final ByteBuffer d;
    public boolean e;

    public A(r rVar, OutputStream outputStream, byte[] bArr) throws IOException {
        super(outputStream);
        StreamSegmentEncrypter streamSegmentEncrypterG = rVar.g(bArr);
        this.f2930a = streamSegmentEncrypterG;
        int iE = rVar.e();
        this.b = iE;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iE);
        this.c = byteBufferAllocate;
        this.d = ByteBuffer.allocate(rVar.c());
        byteBufferAllocate.limit(iE - rVar.a());
        ByteBuffer header = streamSegmentEncrypterG.getHeader();
        byte[] bArr2 = new byte[header.remaining()];
        header.get(bArr2);
        ((FilterOutputStream) this).out.write(bArr2);
        this.e = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.e) {
            try {
                this.c.flip();
                this.d.clear();
                this.f2930a.encryptSegment(this.c, true, this.d);
                this.d.flip();
                ((FilterOutputStream) this).out.write(this.d.array(), this.d.position(), this.d.remaining());
                this.e = false;
                super.close();
            } catch (GeneralSecurityException e) {
                throw new IOException("ptBuffer.remaining():" + this.c.remaining() + " ctBuffer.remaining():" + this.d.remaining(), e);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i3) {
        try {
            if (this.e) {
                while (i3 > this.c.remaining()) {
                    int iRemaining = this.c.remaining();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, iRemaining);
                    i += iRemaining;
                    i3 -= iRemaining;
                    try {
                        this.c.flip();
                        this.d.clear();
                        this.f2930a.encryptSegment(this.c, byteBufferWrap, false, this.d);
                        this.d.flip();
                        ((FilterOutputStream) this).out.write(this.d.array(), this.d.position(), this.d.remaining());
                        this.c.clear();
                        this.c.limit(this.b);
                    } catch (GeneralSecurityException e) {
                        throw new IOException(e);
                    }
                }
                this.c.put(bArr, i, i3);
            } else {
                throw new IOException("Trying to write to closed stream");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
