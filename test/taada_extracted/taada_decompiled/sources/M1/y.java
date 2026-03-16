package m1;

import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.util.Attributes;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z1.a f4070a = new z1.a("ApplicationPluginRegistry");

    public static final Object a(g1.f fVar) {
        C0632a c0632a = L.b;
        Object objB = b(fVar, c0632a);
        if (objB != null) {
            return objB;
        }
        throw new IllegalStateException("Plugin " + c0632a + " is not installed. Consider using `install(" + L.c + ")` in client config first.");
    }

    public static final Object b(g1.f fVar, HttpClientPlugin plugin) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        kotlin.jvm.internal.h.f(plugin, "plugin");
        Attributes attributes = (Attributes) fVar.i.getOrNull(f4070a);
        if (attributes != null) {
            return attributes.getOrNull(plugin.getKey());
        }
        return null;
    }
}
