package q1;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.h;
import u1.n;
import u1.s;
import u1.t;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f4527a;
    public final C1.b b;
    public final n c;
    public final s d;
    public final ByteReadChannel e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineContext f4528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1.b f4529g;

    public f(t tVar, C1.b requestTime, n nVar, s version, ByteReadChannel body, CoroutineContext callContext) {
        h.f(requestTime, "requestTime");
        h.f(version, "version");
        h.f(body, "body");
        h.f(callContext, "callContext");
        this.f4527a = tVar;
        this.b = requestTime;
        this.c = nVar;
        this.d = version;
        this.e = body;
        this.f4528f = callContext;
        this.f4529g = C1.a.a(null);
    }

    public final String toString() {
        return "HttpResponseData=(statusCode=" + this.f4527a + ')';
    }
}
