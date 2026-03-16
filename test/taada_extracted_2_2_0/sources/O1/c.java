package o1;

import g1.C0478b;
import io.ktor.client.plugins.HttpClientPlugin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import r1.C0793a;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements HttpClientPlugin {
    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final z1.a getKey() {
        return g.d;
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final void install(Object obj, g1.f scope) {
        g plugin = (g) obj;
        kotlin.jvm.internal.h.f(plugin, "plugin");
        kotlin.jvm.internal.h.f(scope, "scope");
        Continuation continuation = null;
        scope.e.f(q1.e.i, new g1.d(plugin, continuation, 2));
        scope.f3295f.f(C0793a.f4685l, new C0478b(plugin, continuation, 4));
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final Object prepare(Function1 block) {
        kotlin.jvm.internal.h.f(block, "block");
        C0736b c0736b = new C0736b();
        block.invoke(c0736b);
        return new g(c0736b.b, c0736b.f4269a);
    }
}
