package m1;

import h1.C0494b;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: m1.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0648q extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.ktor.utils.io.jvm.javaio.i f4063a;
    public final /* synthetic */ E1.f b;

    public C0648q(io.ktor.utils.io.jvm.javaio.i iVar, E1.f fVar) {
        this.f4063a = iVar;
        this.b = fVar;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f4063a.f3605a.getAvailableForRead();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.f4063a.close();
        r1.e.b(((C0494b) this.b.f289a).d());
    }

    @Override // java.io.InputStream
    public final int read() {
        return this.f4063a.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] b, int i, int i3) {
        kotlin.jvm.internal.h.f(b, "b");
        return this.f4063a.read(b, i, i3);
    }
}
