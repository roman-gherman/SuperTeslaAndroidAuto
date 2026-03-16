package S1;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext[] f1278a;

    public c(CoroutineContext[] coroutineContextArr) {
        this.f1278a = coroutineContextArr;
    }

    private final Object readResolve() {
        CoroutineContext coroutineContextPlus = g.f1282a;
        for (CoroutineContext coroutineContext : this.f1278a) {
            coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
        }
        return coroutineContextPlus;
    }
}
