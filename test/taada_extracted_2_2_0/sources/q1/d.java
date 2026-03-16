package q1;

import java.util.Map;
import java.util.Set;
import kotlin.collections.w;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.CompletableJob;
import m1.O;
import m1.P;
import u1.C0835D;
import u1.n;
import u1.r;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0835D f4515a;
    public final r b;
    public final n c;
    public final v1.g d;
    public final CompletableJob e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z1.f f4516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f4517g;

    public d(C0835D c0835d, r method, n nVar, v1.g gVar, CompletableJob executionContext, z1.f attributes) {
        Set setKeySet;
        h.f(method, "method");
        h.f(executionContext, "executionContext");
        h.f(attributes, "attributes");
        this.f4515a = c0835d;
        this.b = method;
        this.c = nVar;
        this.d = gVar;
        this.e = executionContext;
        this.f4516f = attributes;
        Map map = (Map) attributes.getOrNull(j1.f.f3652a);
        this.f4517g = (map == null || (setKeySet = map.keySet()) == null) ? w.f3807a : setKeySet;
    }

    public final Object a() {
        O o6 = P.d;
        Map map = (Map) this.f4516f.getOrNull(j1.f.f3652a);
        if (map != null) {
            return map.get(o6);
        }
        return null;
    }

    public final String toString() {
        return "HttpRequestData(url=" + this.f4515a + ", method=" + this.b + ')';
    }
}
