package H0;

import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.j;
import com.google.crypto.tink.l;
import com.google.crypto.tink.subtle.w;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class f implements StreamingAead {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f735a;

    @Override // com.google.crypto.tink.StreamingAead
    public final ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) {
        c cVar = new c();
        cVar.f731a = null;
        cVar.b = null;
        cVar.d = new ArrayDeque();
        Iterator it = this.f735a.a(com.google.crypto.tink.a.f2791a).iterator();
        while (it.hasNext()) {
            cVar.d.add((StreamingAead) ((j) it.next()).b);
        }
        cVar.c = new w(readableByteChannel);
        cVar.e = (byte[]) bArr.clone();
        return cVar;
    }

    @Override // com.google.crypto.tink.StreamingAead
    public final InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) {
        b bVar = new b();
        bVar.f730a = false;
        bVar.b = null;
        bVar.d = this.f735a;
        if (inputStream.markSupported()) {
            bVar.c = inputStream;
        } else {
            bVar.c = new BufferedInputStream(inputStream);
        }
        bVar.c.mark(Integer.MAX_VALUE);
        bVar.e = (byte[]) bArr.clone();
        return bVar;
    }

    @Override // com.google.crypto.tink.StreamingAead
    public final WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) {
        return ((StreamingAead) this.f735a.b.b).newEncryptingChannel(writableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public final OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) {
        return ((StreamingAead) this.f735a.b.b).newEncryptingStream(outputStream, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public final SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        d dVar = new d();
        dVar.f732a = null;
        dVar.b = null;
        dVar.f733f = new ArrayDeque();
        Iterator it = this.f735a.a(com.google.crypto.tink.a.f2791a).iterator();
        while (it.hasNext()) {
            dVar.f733f.add((StreamingAead) ((j) it.next()).b);
        }
        dVar.c = seekableByteChannel;
        dVar.d = -1L;
        dVar.e = seekableByteChannel.position();
        dVar.f734g = (byte[]) bArr.clone();
        return dVar;
    }
}
