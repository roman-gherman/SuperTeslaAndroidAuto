package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class z implements WritableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WritableByteChannel f2987a;
    public StreamSegmentEncrypter b;
    public ByteBuffer c;
    public ByteBuffer d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2988f;

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f2988f) {
            while (this.d.remaining() > 0) {
                if (this.f2987a.write(this.d) <= 0) {
                    throw new IOException("Failed to write ciphertext before closing");
                }
            }
            try {
                this.d.clear();
                this.c.flip();
                this.b.encryptSegment(this.c, true, this.d);
                this.d.flip();
                while (this.d.remaining() > 0) {
                    if (this.f2987a.write(this.d) <= 0) {
                        throw new IOException("Failed to write ciphertext before closing");
                    }
                }
                this.f2987a.close();
                this.f2988f = false;
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.f2988f;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final synchronized int write(ByteBuffer byteBuffer) {
        try {
            if (!this.f2988f) {
                throw new ClosedChannelException();
            }
            if (this.d.remaining() > 0) {
                this.f2987a.write(this.d);
            }
            int iPosition = byteBuffer.position();
            while (byteBuffer.remaining() > this.c.remaining()) {
                if (this.d.remaining() > 0) {
                    return byteBuffer.position() - iPosition;
                }
                int iRemaining = this.c.remaining();
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBufferSlice.limit(iRemaining);
                byteBuffer.position(byteBuffer.position() + iRemaining);
                try {
                    this.c.flip();
                    this.d.clear();
                    if (byteBufferSlice.remaining() != 0) {
                        this.b.encryptSegment(this.c, byteBufferSlice, false, this.d);
                    } else {
                        this.b.encryptSegment(this.c, false, this.d);
                    }
                    this.d.flip();
                    this.f2987a.write(this.d);
                    this.c.clear();
                    this.c.limit(this.e);
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }
            }
            this.c.put(byteBuffer);
            return byteBuffer.position() - iPosition;
        } catch (Throwable th) {
            throw th;
        }
    }
}
