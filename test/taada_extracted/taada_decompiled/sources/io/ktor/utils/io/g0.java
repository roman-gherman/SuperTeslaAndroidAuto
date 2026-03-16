package io.ktor.utils.io;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0684s;
import m3.AbstractC0690y;
import m3.s0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g0 {
    public static final c0 a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, U u, boolean z6, Function2 function2) {
        s0 s0VarG = AbstractC0690y.g(coroutineScope, coroutineContext, new f0(z6, u, function2, (AbstractC0684s) coroutineScope.getCoroutineContext().get(AbstractC0684s.Key), null), 2);
        s0VarG.invokeOnCompletion(new S(u, 2));
        return new c0(s0VarG, u);
    }

    public static final c0 b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z6, Function2 function2) {
        kotlin.jvm.internal.h.f(coroutineScope, "<this>");
        kotlin.jvm.internal.h.f(coroutineContext, "coroutineContext");
        return a(coroutineScope, coroutineContext, new U(z6), true, function2);
    }
}
