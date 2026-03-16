package H0;

import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class d implements SeekableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SeekableByteChannel f732a;
    public SeekableByteChannel b;
    public SeekableByteChannel c;
    public long d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayDeque f733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f734g;

    public final synchronized SeekableByteChannel a() {
        SeekableByteChannel seekableByteChannelNewSeekableDecryptingChannel;
        while (!this.f733f.isEmpty()) {
            this.c.position(this.e);
            try {
                seekableByteChannelNewSeekableDecryptingChannel = ((StreamingAead) this.f733f.removeFirst()).newSeekableDecryptingChannel(this.c, this.f734g);
                long j6 = this.d;
                if (j6 >= 0) {
                    seekableByteChannelNewSeekableDecryptingChannel.position(j6);
                }
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return seekableByteChannelNewSeekableDecryptingChannel;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.c.close();
    }

    @Override // java.nio.channels.Channel
    public final synchronized boolean isOpen() {
        return this.c.isOpen();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public final synchronized SeekableByteChannel position(long j6) {
        try {
            SeekableByteChannel seekableByteChannel = this.b;
            if (seekableByteChannel != null) {
                seekableByteChannel.position(j6);
            } else {
                if (j6 < 0) {
                    throw new IllegalArgumentException("Position must be non-negative");
                }
                this.d = j6;
                SeekableByteChannel seekableByteChannel2 = this.f732a;
                if (seekableByteChannel2 != null) {
                    seekableByteChannel2.position(j6);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public final synchronized int read(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return 0;
        }
        SeekableByteChannel seekableByteChannel = this.b;
        if (seekableByteChannel != null) {
            return seekableByteChannel.read(byteBuffer);
        }
        if (this.f732a == null) {
            this.f732a = a();
        }
        while (true) {
            try {
                int i = this.f732a.read(byteBuffer);
                if (i == 0) {
                    return 0;
                }
                this.b = this.f732a;
                this.f732a = null;
                return i;
            } catch (IOException unused) {
                this.f732a = a();
            }
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public final synchronized long size() {
        SeekableByteChannel seekableByteChannel;
        seekableByteChannel = this.b;
        if (seekableByteChannel == null) {
            throw new IOException("Cannot determine size before first read()-call.");
        }
        return seekableByteChannel.size();
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
    public final synchronized long position() {
        SeekableByteChannel seekableByteChannel = this.b;
        if (seekableByteChannel != null) {
            return seekableByteChannel.position();
        }
        return this.d;
    }
}
