package t3;

import kotlin.coroutines.CoroutineContext;
import m3.AbstractC0684s;
import r3.AbstractC0800a;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends AbstractC0684s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f4839a = new l();

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        d dVar = d.b;
        dVar.f4832a.b(runnable, k.f4838h, false);
    }

    @Override // m3.AbstractC0684s
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        d dVar = d.b;
        dVar.f4832a.b(runnable, k.f4838h, true);
    }

    @Override // m3.AbstractC0684s
    public final AbstractC0684s limitedParallelism(int i) {
        AbstractC0800a.a(i);
        return i >= k.d ? this : super.limitedParallelism(i);
    }
}
