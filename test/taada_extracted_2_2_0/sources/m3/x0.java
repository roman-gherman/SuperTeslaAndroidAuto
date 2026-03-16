package m3;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 extends AbstractC0684s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f4149a = new x0();

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        B0 b02 = (B0) coroutineContext.get(B0.b);
        if (b02 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        b02.f4103a = true;
    }

    @Override // m3.AbstractC0684s
    public final AbstractC0684s limitedParallelism(int i) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // m3.AbstractC0684s
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
