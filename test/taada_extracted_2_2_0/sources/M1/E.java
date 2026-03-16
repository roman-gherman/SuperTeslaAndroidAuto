package m1;

import java.util.Set;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f4036a;
    public static final Logger b;

    static {
        u1.r rVar = u1.r.b;
        f4036a = kotlin.collections.E.x(u1.r.b, u1.r.d);
        b = C5.f.b("io.ktor.client.plugins.HttpRedirect");
    }

    public static final boolean a(u1.t tVar) {
        int i = tVar.f4876a;
        return i == u1.t.c.f4876a || i == u1.t.d.f4876a || i == u1.t.f4873f.f4876a || i == u1.t.f4874g.f4876a || i == u1.t.e.f4876a;
    }
}
