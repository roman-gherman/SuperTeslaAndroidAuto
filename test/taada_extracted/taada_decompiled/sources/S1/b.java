package S1;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements CoroutineContext.Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1277a;
    public final CoroutineContext.Key b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(CoroutineContext.Key baseKey, Function1 safeCast) {
        h.f(baseKey, "baseKey");
        h.f(safeCast, "safeCast");
        this.f1277a = (i) safeCast;
        this.b = baseKey instanceof b ? ((b) baseKey).b : baseKey;
    }
}
