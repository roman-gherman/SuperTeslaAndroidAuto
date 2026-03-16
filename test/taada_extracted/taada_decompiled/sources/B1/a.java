package B1;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.v;
import kotlin.jvm.internal.h;
import org.jetbrains.annotations.NotNull;
import z.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    @NotNull
    private volatile /* synthetic */ Object current = v.f3805a;

    static {
        AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "current");
    }

    public final Object a(e key) {
        h.f(key, "key");
        return ((Map) this.current).get(key);
    }
}
