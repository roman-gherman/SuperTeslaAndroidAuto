package h1;

import io.ktor.client.request.HttpRequest;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: h1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0494b implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1.f f3353a;
    public HttpRequest b;
    public r1.b c;

    @NotNull
    private volatile /* synthetic */ int received = 0;
    public static final z1.a e = new z1.a("CustomResponse");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(C0494b.class, "received");

    public C0494b(g1.f fVar) {
        this.f3353a = fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:
    
        if (r8 == r1) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c9 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:13:0x002c, B:49:0x00b9, B:54:0x00c9, B:57:0x00d9, B:58:0x00ee), top: B:66:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(F1.a r7, U1.c r8) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.C0494b.a(F1.a, U1.c):java.lang.Object");
    }

    public boolean b() {
        return false;
    }

    public final HttpRequest c() {
        HttpRequest httpRequest = this.b;
        if (httpRequest != null) {
            return httpRequest;
        }
        h.n("request");
        throw null;
    }

    public final r1.b d() {
        r1.b bVar = this.c;
        if (bVar != null) {
            return bVar;
        }
        h.n("response");
        throw null;
    }

    public Object e() {
        return d().a();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return d().getCoroutineContext();
    }

    public final String toString() {
        return "HttpClientCall[" + c().getUrl() + ", " + d().d() + ']';
    }
}
