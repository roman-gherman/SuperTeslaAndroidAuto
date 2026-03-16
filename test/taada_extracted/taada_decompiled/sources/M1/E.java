package m1;

import java.util.Set;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f4035a;
    public static final Logger b;

    static {
        u1.r rVar = u1.r.b;
        f4035a = kotlin.collections.E.x(u1.r.b, u1.r.d);
        b = C5.f.b("io.ktor.client.plugins.HttpRedirect");
    }

    public static final boolean a(u1.t tVar) {
        int i = tVar.f4875a;
        return i == u1.t.c.f4875a || i == u1.t.d.f4875a || i == u1.t.f4872f.f4875a || i == u1.t.f4873g.f4875a || i == u1.t.e.f4875a;
    }
}
