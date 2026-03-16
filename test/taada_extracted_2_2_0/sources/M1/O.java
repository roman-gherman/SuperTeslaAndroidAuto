package m1;

import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.plugins.HttpClientPlugin;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class O implements HttpClientPlugin, HttpClientEngineCapability {
    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final z1.a getKey() {
        return P.e;
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final void install(Object obj, g1.f scope) {
        P plugin = (P) obj;
        kotlin.jvm.internal.h.f(plugin, "plugin");
        kotlin.jvm.internal.h.f(scope, "scope");
        C0632a c0632a = L.b;
        L l6 = (L) y.a(scope);
        l6.f4043a.add(new j1.d(plugin, scope, null, 3));
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final Object prepare(Function1 block) {
        kotlin.jvm.internal.h.f(block, "block");
        M m6 = new M();
        block.invoke(m6);
        return new P(m6.f4044a, m6.b, m6.c);
    }
}
