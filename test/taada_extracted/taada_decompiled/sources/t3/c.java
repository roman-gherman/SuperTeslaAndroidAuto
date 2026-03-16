package t3;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import m3.AbstractC0684s;
import m3.T;
import r3.AbstractC0800a;
import r3.w;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends T implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4830a = new c();
    public static final AbstractC0684s b;

    static {
        l lVar = l.f4839a;
        int i = w.f4721a;
        if (64 >= i) {
            i = 64;
        }
        b = lVar.limitedParallelism(AbstractC0800a.j(i, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b.dispatch(coroutineContext, runnable);
    }

    @Override // m3.AbstractC0684s
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        b.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(S1.g.f1282a, runnable);
    }

    @Override // m3.AbstractC0684s
    public final AbstractC0684s limitedParallelism(int i) {
        return l.f4839a.limitedParallelism(i);
    }

    @Override // m3.AbstractC0684s
    public final String toString() {
        return "Dispatchers.IO";
    }
}
