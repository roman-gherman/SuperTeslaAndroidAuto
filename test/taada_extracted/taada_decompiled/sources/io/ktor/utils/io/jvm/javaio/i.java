package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import m3.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteReadChannel f3604a;
    public final CompletableJob b;
    public final h c;
    public byte[] d;

    public i(Job job, ByteReadChannel channel) {
        kotlin.jvm.internal.h.f(channel, "channel");
        this.f3604a = channel;
        this.b = new d0(job);
        this.c = new h(job, this);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f3604a.getAvailableForRead();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            super.close();
            ByteReadChannel byteReadChannel = this.f3604a;
            kotlin.jvm.internal.h.f(byteReadChannel, "<this>");
            byteReadChannel.cancel(null);
            if (!this.b.isCompleted()) {
                this.b.cancel((CancellationException) null);
            }
            h hVar = this.c;
            DisposableHandle disposableHandle = hVar.c;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
            hVar.b.resumeWith(kotlin.reflect.l.n(new CancellationException("Stream closed")));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        try {
            byte[] bArr = this.d;
            if (bArr == null) {
                bArr = new byte[1];
                this.d = bArr;
            }
            int iD = this.c.d(bArr, 0, 1);
            if (iD == -1) {
                return -1;
            }
            if (iD == 1) {
                return bArr[0] & 255;
            }
            throw new IllegalStateException(("Expected a single byte or EOF. Got " + iD + " bytes.").toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i3) {
        h hVar;
        hVar = this.c;
        kotlin.jvm.internal.h.c(bArr);
        return hVar.d(bArr, i, i3);
    }
}
