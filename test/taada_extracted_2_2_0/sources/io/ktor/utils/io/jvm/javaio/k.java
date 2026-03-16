package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import java.io.OutputStream;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteWriteChannel f3607a;
    public final h b;
    public byte[] c;

    public k(ByteWriteChannel channel) {
        kotlin.jvm.internal.h.f(channel, "channel");
        this.f3607a = channel;
        this.b = new h(this);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            this.b.c(e.b);
            h hVar = this.b;
            DisposableHandle disposableHandle = hVar.c;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
            hVar.b.resumeWith(kotlin.reflect.l.n(new CancellationException("Stream closed")));
        } finally {
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final synchronized void flush() {
        this.b.c(e.c);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i) {
        try {
            byte[] bArr = this.c;
            if (bArr == null) {
                bArr = new byte[1];
                this.c = bArr;
            }
            bArr[0] = (byte) i;
            this.b.d(bArr, 0, 1);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i3) {
        h hVar = this.b;
        kotlin.jvm.internal.h.c(bArr);
        hVar.d(bArr, i, i3);
    }
}
