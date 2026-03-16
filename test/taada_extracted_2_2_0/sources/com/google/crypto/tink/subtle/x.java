package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class x implements ReadableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadableByteChannel f2972a;
    public final ByteBuffer b;
    public final ByteBuffer c;
    public final ByteBuffer d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2975h;
    public final byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final StreamSegmentDecrypter f2977k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f2978l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f2979m;

    public x(r rVar, ReadableByteChannel readableByteChannel, byte[] bArr) {
        this.f2977k = rVar.f();
        this.f2972a = readableByteChannel;
        this.d = ByteBuffer.allocate(rVar.d());
        this.i = Arrays.copyOf(bArr, bArr.length);
        int iC = rVar.c();
        this.f2978l = iC;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iC + 1);
        this.b = byteBufferAllocate;
        byteBufferAllocate.limit(0);
        this.f2979m = iC - rVar.a();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(rVar.e() + 16);
        this.c = byteBufferAllocate2;
        byteBufferAllocate2.limit(0);
        this.e = false;
        this.f2973f = false;
        this.f2974g = false;
        this.f2976j = 0;
        this.f2975h = true;
    }

    public final boolean a() throws IOException {
        byte b;
        int i;
        boolean z6 = this.f2973f;
        ByteBuffer byteBuffer = this.b;
        if (!z6) {
            do {
                i = this.f2972a.read(byteBuffer);
                if (i <= 0) {
                    break;
                }
            } while (byteBuffer.remaining() > 0);
            if (i == -1) {
                this.f2973f = true;
            }
        }
        if (byteBuffer.remaining() > 0 && !this.f2973f) {
            return false;
        }
        if (this.f2973f) {
            b = 0;
        } else {
            b = byteBuffer.get(byteBuffer.position() - 1);
            byteBuffer.position(byteBuffer.position() - 1);
        }
        byteBuffer.flip();
        ByteBuffer byteBuffer2 = this.c;
        byteBuffer2.clear();
        try {
            this.f2977k.decryptSegment(byteBuffer, this.f2976j, this.f2973f, byteBuffer2);
            this.f2976j++;
            byteBuffer2.flip();
            byteBuffer.clear();
            if (!this.f2973f) {
                byteBuffer.clear();
                byteBuffer.limit(this.f2978l + 1);
                byteBuffer.put(b);
            }
            return true;
        } catch (GeneralSecurityException e) {
            this.f2975h = false;
            this.c.limit(0);
            throw new IOException(e.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.f2976j + " endOfCiphertext:" + this.f2973f, e);
        }
    }

    public final boolean b() throws IOException {
        int i;
        if (this.f2973f) {
            throw new IOException("Ciphertext is too short");
        }
        ByteBuffer byteBuffer = this.d;
        do {
            i = this.f2972a.read(byteBuffer);
            if (i <= 0) {
                break;
            }
        } while (byteBuffer.remaining() > 0);
        if (i == -1) {
            this.f2973f = true;
        }
        if (byteBuffer.remaining() > 0) {
            return false;
        }
        byteBuffer.flip();
        try {
            this.f2977k.init(byteBuffer, this.i);
            this.e = true;
            return true;
        } catch (GeneralSecurityException e) {
            this.f2975h = false;
            this.c.limit(0);
            throw new IOException(e);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f2972a.close();
    }

    @Override // java.nio.channels.Channel
    public final synchronized boolean isOpen() {
        return this.f2972a.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final synchronized int read(ByteBuffer byteBuffer) {
        try {
            if (!this.f2975h) {
                throw new IOException("This StreamingAeadDecryptingChannel is in an undefined state");
            }
            if (!this.e) {
                if (!b()) {
                    return 0;
                }
                this.b.clear();
                this.b.limit(this.f2979m + 1);
            }
            if (this.f2974g) {
                return -1;
            }
            int iPosition = byteBuffer.position();
            while (true) {
                if (byteBuffer.remaining() <= 0) {
                    break;
                }
                if (this.c.remaining() == 0) {
                    if (!this.f2973f) {
                        if (!a()) {
                            break;
                        }
                    } else {
                        this.f2974g = true;
                        break;
                    }
                }
                if (this.c.remaining() <= byteBuffer.remaining()) {
                    byteBuffer.put(this.c);
                } else {
                    int iRemaining = byteBuffer.remaining();
                    ByteBuffer byteBufferDuplicate = this.c.duplicate();
                    byteBufferDuplicate.limit(byteBufferDuplicate.position() + iRemaining);
                    byteBuffer.put(byteBufferDuplicate);
                    ByteBuffer byteBuffer2 = this.c;
                    byteBuffer2.position(byteBuffer2.position() + iRemaining);
                }
            }
            int iPosition2 = byteBuffer.position() - iPosition;
            if (iPosition2 == 0 && this.f2974g) {
                return -1;
            }
            return iPosition2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized String toString() {
        return "StreamingAeadDecryptingChannel\nsegmentNr:" + this.f2976j + "\nciphertextSegmentSize:" + this.f2978l + "\nheaderRead:" + this.e + "\nendOfCiphertext:" + this.f2973f + "\nendOfPlaintext:" + this.f2974g + "\ndefinedState:" + this.f2975h + "\nHeader position:" + this.d.position() + " limit:" + this.d.position() + "\nciphertextSgement position:" + this.b.position() + " limit:" + this.b.limit() + "\nplaintextSegment position:" + this.c.position() + " limit:" + this.c.limit();
    }
}
