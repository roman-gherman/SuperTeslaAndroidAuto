package o1;

import io.ktor.utils.io.ByteReadChannel;
import java.util.Set;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KClass;
import org.slf4j.Logger;
import u1.t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f4277a;
    public static final Set b;

    static {
        Logger loggerE = A5.a.e("io.ktor.client.plugins.contentnegotiation.ContentNegotiation");
        kotlin.jvm.internal.h.e(loggerE, "getLogger(name)");
        f4277a = loggerE;
        x xVar = w.f3818a;
        b = kotlin.collections.j.N(new KClass[]{xVar.b(byte[].class), xVar.b(String.class), xVar.b(t.class), xVar.b(ByteReadChannel.class), xVar.b(v1.g.class)});
    }
}
