package q1;

import h1.C0494b;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.Headers;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import u1.C0835D;
import u1.n;
import u1.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0494b f4510a;
    public final r b;
    public final C0835D c;
    public final v1.g d;
    public final n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z1.f f4511f;

    public a(C0494b c0494b, d dVar) {
        this.f4510a = c0494b;
        this.b = dVar.b;
        this.c = dVar.f4515a;
        this.d = dVar.d;
        this.e = dVar.c;
        this.f4511f = dVar.f4516f;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Attributes getAttributes() {
        return this.f4511f;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final C0494b getCall() {
        return this.f4510a;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final v1.g getContent() {
        return this.d;
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f4510a.getCoroutineContext();
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.e;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final r getMethod() {
        return this.b;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final C0835D getUrl() {
        return this.c;
    }
}
