package H0;

import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.w;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ReadableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReadableByteChannel f731a;
    public ReadableByteChannel b;
    public w c;
    public ArrayDeque d;
    public byte[] e;

    public final synchronized ReadableByteChannel a() {
        while (!this.d.isEmpty()) {
            try {
            } catch (GeneralSecurityException unused) {
                this.c.a();
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return ((StreamingAead) this.d.removeFirst()).newDecryptingChannel(this.c, this.e);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.c.close();
    }

    @Override // java.nio.channels.Channel
    public final synchronized boolean isOpen() {
        return this.c.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final synchronized int read(ByteBuffer byteBuffer) {
        int i;
        if (byteBuffer.remaining() == 0) {
            return 0;
        }
        ReadableByteChannel readableByteChannel = this.b;
        if (readableByteChannel != null) {
            return readableByteChannel.read(byteBuffer);
        }
        if (this.f731a == null) {
            this.f731a = a();
        }
        while (true) {
            try {
                i = this.f731a.read(byteBuffer);
                break;
            } catch (IOException unused) {
                this.c.a();
                this.f731a = a();
            }
        }
        if (i == 0) {
            return 0;
        }
        this.b = this.f731a;
        this.f731a = null;
        w wVar = this.c;
        synchronized (wVar) {
            wVar.c = false;
        }
        return i;
    }
}
