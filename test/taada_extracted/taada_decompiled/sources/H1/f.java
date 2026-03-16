package h1;

import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.U;
import io.ktor.utils.io.X;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import m3.AbstractC0690y;
import m3.d0;
import u1.n;
import u1.s;
import u1.t;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends r1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3357a = 1;
    public final CoroutineContext b;
    public final t c;
    public final s d;
    public final C1.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1.b f3358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0494b f3359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f3360h;
    public final Object i;

    public f(C0494b c0494b, q1.f fVar) {
        this.f3359g = c0494b;
        this.b = fVar.f4528f;
        this.c = fVar.f4527a;
        this.d = fVar.d;
        this.e = fVar.b;
        this.f3358f = fVar.f4529g;
        ByteReadChannel byteReadChannel = fVar.e;
        byteReadChannel = byteReadChannel == null ? null : byteReadChannel;
        if (byteReadChannel == null) {
            ByteReadChannel.Companion.getClass();
            byteReadChannel = (ByteReadChannel) X.b.getValue();
        }
        this.f3360h = byteReadChannel;
        this.i = fVar.c;
    }

    @Override // r1.b
    public final ByteReadChannel a() {
        switch (this.f3357a) {
            case 0:
                return (U) this.i;
            default:
                return (ByteReadChannel) this.f3360h;
        }
    }

    @Override // r1.b
    public final C1.b b() {
        switch (this.f3357a) {
        }
        return this.e;
    }

    @Override // r1.b
    public final C1.b c() {
        switch (this.f3357a) {
        }
        return this.f3358f;
    }

    @Override // r1.b
    public final t d() {
        switch (this.f3357a) {
        }
        return this.c;
    }

    @Override // r1.b
    public final s e() {
        switch (this.f3357a) {
        }
        return this.d;
    }

    @Override // r1.b
    public final C0494b getCall() {
        switch (this.f3357a) {
            case 0:
                return (d) this.f3359g;
            default:
                return this.f3359g;
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        switch (this.f3357a) {
        }
        return this.b;
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        switch (this.f3357a) {
            case 0:
                return (Headers) this.f3360h;
            default:
                return (n) this.i;
        }
    }

    public f(d call, byte[] bArr, r1.b bVar) {
        h.f(call, "call");
        this.f3359g = call;
        d0 d0VarA = AbstractC0690y.a();
        this.c = bVar.d();
        this.d = bVar.e();
        this.e = bVar.b();
        this.f3358f = bVar.c();
        this.f3360h = bVar.getHeaders();
        this.b = bVar.getCoroutineContext().plus(d0VarA);
        this.i = l.a(bArr);
    }
}
