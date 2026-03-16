package h1;

import io.ktor.client.request.HttpRequest;
import io.ktor.http.Headers;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.h;
import p1.C0754a;
import u1.C0835D;
import u1.r;
import v1.g;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3357a = 0;
    public final /* synthetic */ HttpRequest b;
    public final C0494b c;

    public e(d call, HttpRequest httpRequest) {
        h.f(call, "call");
        this.c = call;
        this.b = httpRequest;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Attributes getAttributes() {
        switch (this.f3357a) {
        }
        return this.b.getAttributes();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final C0494b getCall() {
        switch (this.f3357a) {
            case 0:
                return (d) this.c;
            default:
                return (C0754a) this.c;
        }
    }

    @Override // io.ktor.client.request.HttpRequest
    public final g getContent() {
        switch (this.f3357a) {
        }
        return this.b.getContent();
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        switch (this.f3357a) {
        }
        return this.b.getCoroutineContext();
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        switch (this.f3357a) {
        }
        return this.b.getHeaders();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final r getMethod() {
        switch (this.f3357a) {
        }
        return this.b.getMethod();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final C0835D getUrl() {
        switch (this.f3357a) {
        }
        return this.b.getUrl();
    }

    public e(C0754a c0754a, HttpRequest httpRequest) {
        this.c = c0754a;
        this.b = httpRequest;
    }
}
