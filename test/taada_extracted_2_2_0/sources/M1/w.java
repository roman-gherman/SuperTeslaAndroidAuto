package m1;

import h1.C0494b;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.Headers;
import io.ktor.util.Attributes;
import java.util.Map;
import kotlin.coroutines.CoroutineContext;
import u1.C0835D;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1.r f4069a;
    public final C0835D b;
    public final z1.f c;
    public final u1.n d;
    public final /* synthetic */ q1.c e;

    public w(q1.c cVar) {
        this.e = cVar;
        this.f4069a = cVar.b;
        this.b = cVar.f4513a.b();
        this.c = cVar.f4514f;
        this.d = new u1.n((Map) cVar.c.f4280a);
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Attributes getAttributes() {
        return this.c;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final C0494b getCall() {
        throw new IllegalStateException("Call is not initialized");
    }

    @Override // io.ktor.client.request.HttpRequest
    public final v1.g getContent() {
        q1.c cVar = this.e;
        Object obj = cVar.d;
        v1.g gVar = obj instanceof v1.g ? (v1.g) obj : null;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException(("Content was not transformed to OutgoingContent yet. Current body is " + cVar.d).toString());
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        getCall();
        throw null;
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.d;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final u1.r getMethod() {
        return this.f4069a;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final C0835D getUrl() {
        return this.b;
    }
}
