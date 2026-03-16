package g1;

import A2.C0019a;
import A2.q;
import io.ktor.client.plugins.HttpClientPlugin;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import z1.k;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3301a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final c d = c.c;
    public boolean e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3302f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f3303g = k.f5180a;

    public final void a(HttpClientPlugin httpClientPlugin, Function1 configure) {
        kotlin.jvm.internal.h.f(configure, "configure");
        LinkedHashMap linkedHashMap = this.b;
        linkedHashMap.put(httpClientPlugin.getKey(), new q(6, (Function1) linkedHashMap.get(httpClientPlugin.getKey()), configure));
        LinkedHashMap linkedHashMap2 = this.f3301a;
        if (linkedHashMap2.containsKey(httpClientPlugin.getKey())) {
            return;
        }
        linkedHashMap2.put(httpClientPlugin.getKey(), new C0019a(httpClientPlugin, 15));
    }
}
