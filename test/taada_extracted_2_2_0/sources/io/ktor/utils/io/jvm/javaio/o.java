package io.ktor.utils.io.jvm.javaio;

import kotlin.coroutines.CoroutineContext;
import m3.AbstractC0684s;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends AbstractC0684s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f3611a = new o();

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext context, Runnable block) {
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(block, "block");
        block.run();
    }

    @Override // m3.AbstractC0684s
    public final boolean isDispatchNeeded(CoroutineContext context) {
        kotlin.jvm.internal.h.f(context, "context");
        return true;
    }
}
