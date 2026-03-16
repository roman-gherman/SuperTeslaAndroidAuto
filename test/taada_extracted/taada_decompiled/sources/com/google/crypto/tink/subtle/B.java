package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class B implements SeekableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SeekableByteChannel f2931a;
    public final ByteBuffer b;
    public final ByteBuffer c;
    public final ByteBuffer d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f2934h;
    public final StreamSegmentDecrypter i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f2941p;
    public final int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f2942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f2943s;

    public B(r rVar, SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        this.i = rVar.f();
        this.f2931a = seekableByteChannel;
        this.d = ByteBuffer.allocate(rVar.d());
        int iC = rVar.c();
        this.q = iC;
        this.b = ByteBuffer.allocate(iC);
        int iE = rVar.e();
        this.f2941p = iE;
        this.c = ByteBuffer.allocate(iE + 16);
        this.f2935j = 0L;
        this.f2937l = false;
        this.f2939n = -1;
        this.f2938m = false;
        long size = seekableByteChannel.size();
        this.e = size;
        this.f2934h = Arrays.copyOf(bArr, bArr.length);
        this.f2940o = seekableByteChannel.isOpen();
        long j6 = iC;
        int i = (int) (size / j6);
        int i3 = (int) (size % j6);
        int iB = rVar.b();
        if (i3 > 0) {
            this.f2932f = i + 1;
            if (i3 < iB) {
                throw new IOException("Invalid ciphertext size");
            }
            this.f2933g = i3;
        } else {
            this.f2932f = i;
            this.f2933g = iC;
        }
        int iA = rVar.a();
        this.f2942r = iA;
        int iD = iA - rVar.d();
        this.f2943s = iD;
        if (iD < 0) {
            throw new IOException("Invalid ciphertext offset or header length");
        }
        long j7 = (((long) this.f2932f) * ((long) iB)) + ((long) iA);
        if (j7 > size) {
            throw new IOException("Ciphertext is too short");
        }
        this.f2936k = size - j7;
    }

    public final boolean a(int i) throws IOException {
        int i3;
        if (i < 0 || i >= (i3 = this.f2932f)) {
            throw new IOException("Invalid position");
        }
        boolean z6 = i == i3 - 1;
        int i4 = this.f2939n;
        SeekableByteChannel seekableByteChannel = this.f2931a;
        ByteBuffer byteBuffer = this.b;
        if (i != i4) {
            int i5 = this.q;
            long j6 = ((long) i) * ((long) i5);
            if (z6) {
                i5 = this.f2933g;
            }
            if (i == 0) {
                int i6 = this.f2942r;
                i5 -= i6;
                j6 = i6;
            }
            seekableByteChannel.position(j6);
            byteBuffer.clear();
            byteBuffer.limit(i5);
            this.f2939n = i;
            this.f2938m = false;
        } else if (this.f2938m) {
            return true;
        }
        if (byteBuffer.remaining() > 0) {
            seekableByteChannel.read(byteBuffer);
        }
        if (byteBuffer.remaining() > 0) {
            return false;
        }
        byteBuffer.flip();
        ByteBuffer byteBuffer2 = this.c;
        byteBuffer2.clear();
        try {
            this.i.decryptSegment(byteBuffer, i, z6, byteBuffer2);
            byteBuffer2.flip();
            this.f2938m = true;
            return true;
        } catch (GeneralSecurityException e) {
            this.f2939n = -1;
            throw new IOException("Failed to decrypt", e);
        }
    }

    public final boolean b() throws IOException {
        ByteBuffer byteBuffer = this.d;
        long jPosition = byteBuffer.position() + this.f2943s;
        SeekableByteChannel seekableByteChannel = this.f2931a;
        seekableByteChannel.position(jPosition);
        seekableByteChannel.read(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            return false;
        }
        byteBuffer.flip();
        try {
            this.i.init(byteBuffer, this.f2934h);
            this.f2937l = true;
            return true;
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f2931a.close();
        this.f2940o = false;
    }

    @Override // java.nio.channels.Channel
    public final synchronized boolean isOpen() {
        return this.f2940o;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public final synchronized long position() {
        return this.f2935j;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public final synchronized int read(ByteBuffer byteBuffer) {
        if (!this.f2940o) {
            throw new ClosedChannelException();
        }
        if (!this.f2937l && !b()) {
            return 0;
        }
        int iPosition = byteBuffer.position();
        while (byteBuffer.remaining() > 0) {
            long j6 = this.f2935j;
            if (j6 >= this.f2936k) {
                break;
            }
            long j7 = ((long) this.f2942r) + j6;
            long j8 = this.f2941p;
            int i = (int) (j7 / j8);
            int i3 = i == 0 ? (int) j6 : (int) (j7 % j8);
            if (!a(i)) {
                break;
            }
            this.c.position(i3);
            if (this.c.remaining() <= byteBuffer.remaining()) {
                this.f2935j += (long) this.c.remaining();
                byteBuffer.put(this.c);
            } else {
                int iRemaining = byteBuffer.remaining();
                ByteBuffer byteBufferDuplicate = this.c.duplicate();
                byteBufferDuplicate.limit(byteBufferDuplicate.position() + iRemaining);
                byteBuffer.put(byteBufferDuplicate);
                this.f2935j += (long) iRemaining;
                ByteBuffer byteBuffer2 = this.c;
                byteBuffer2.position(byteBuffer2.position() + iRemaining);
            }
        }
        int iPosition2 = byteBuffer.position() - iPosition;
        if (iPosition2 == 0 && this.f2938m && this.f2939n == this.f2932f - 1 && this.c.remaining() == 0) {
            return -1;
        }
        return iPosition2;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public final long size() {
        return this.f2936k;
    }

    public final synchronized String toString() {
        StringBuilder sb;
        String str;
        sb = new StringBuilder("StreamingAeadSeekableDecryptingChannel\nciphertextChannel");
        try {
            str = "position:" + this.f2931a.position();
        } catch (IOException unused) {
            str = "position: n/a";
        }
        sb.append(str);
        sb.append("\nciphertextChannelSize:");
        sb.append(this.e);
        sb.append("\nplaintextSize:");
        sb.append(this.f2936k);
        sb.append("\nciphertextSegmentSize:");
        sb.append(this.q);
        sb.append("\nnumberOfSegments:");
        sb.append(this.f2932f);
        sb.append("\nheaderRead:");
        sb.append(this.f2937l);
        sb.append("\nplaintextPosition:");
        sb.append(this.f2935j);
        sb.append("\nHeader position:");
        sb.append(this.d.position());
        sb.append(" limit:");
        sb.append(this.d.position());
        sb.append("\ncurrentSegmentNr:");
        sb.append(this.f2939n);
        sb.append("\nciphertextSgement position:");
        sb.append(this.b.position());
        sb.append(" limit:");
        sb.append(this.b.limit());
        sb.append("\nisCurrentSegmentDecrypted:");
        sb.append(this.f2938m);
        sb.append("\nplaintextSegment position:");
        sb.append(this.c.position());
        sb.append(" limit:");
        sb.append(this.c.limit());
        return sb.toString();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public final SeekableByteChannel truncate(long j6) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public final synchronized SeekableByteChannel position(long j6) {
        this.f2935j = j6;
        return this;
    }
}
