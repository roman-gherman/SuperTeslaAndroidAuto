package t3;

import kotlin.coroutines.CoroutineContext;
import m3.T;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f4832a;

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b.c(this.f4832a, runnable, 6);
    }

    @Override // m3.AbstractC0684s
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        b.c(this.f4832a, runnable, 2);
    }
}
