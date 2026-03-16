package p1;

import h1.C0494b;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import u1.s;
import u1.t;

/* JADX INFO: renamed from: p1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0755b extends r1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0754a f4470a;
    public final ByteChannel b;
    public final r1.b c;
    public final CoroutineContext d;

    public C0755b(C0754a c0754a, ByteChannel byteChannel, r1.b bVar) {
        this.f4470a = c0754a;
        this.b = byteChannel;
        this.c = bVar;
        this.d = bVar.getCoroutineContext();
    }

    @Override // r1.b
    public final ByteReadChannel a() {
        return this.b;
    }

    @Override // r1.b
    public final C1.b b() {
        return this.c.b();
    }

    @Override // r1.b
    public final C1.b c() {
        return this.c.c();
    }

    @Override // r1.b
    public final t d() {
        return this.c.d();
    }

    @Override // r1.b
    public final s e() {
        return this.c.e();
    }

    @Override // r1.b
    public final C0494b getCall() {
        return this.f4470a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.d;
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.c.getHeaders();
    }
}
