package com.google.crypto.tink.subtle;

import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes.dex */
public abstract class r implements StreamingAead {
    public abstract int a();

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public abstract int e();

    public abstract StreamSegmentDecrypter f();

    public abstract StreamSegmentEncrypter g(byte[] bArr);

    @Override // com.google.crypto.tink.StreamingAead
    public final ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) {
        return new x(this, readableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public final InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) {
        return new y(this, inputStream, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public final WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) throws IOException {
        z zVar = new z();
        zVar.f2988f = true;
        zVar.f2987a = writableByteChannel;
        StreamSegmentEncrypter streamSegmentEncrypterG = g(bArr);
        zVar.b = streamSegmentEncrypterG;
        int iE = e();
        zVar.e = iE;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iE);
        zVar.c = byteBufferAllocate;
        byteBufferAllocate.limit(iE - a());
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(c());
        zVar.d = byteBufferAllocate2;
        byteBufferAllocate2.put(streamSegmentEncrypterG.getHeader());
        byteBufferAllocate2.flip();
        writableByteChannel.write(byteBufferAllocate2);
        return zVar;
    }

    @Override // com.google.crypto.tink.StreamingAead
    public final OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) {
        return new A(this, outputStream, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public final SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        return new B(this, seekableByteChannel, bArr);
    }
}
