package fr.sd.taada.core;

import N1.h;
import U1.c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "fr.sd.taada.core.CircuitBreaker", f = "CircuitBreaker.kt", i = {0}, l = {102}, m = "attemptExecution-gIAlu-s", n = {"this"}, s = {"L$0"})
public final class CircuitBreaker$attemptExecution$1<T> extends c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CircuitBreaker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircuitBreaker$attemptExecution$1(CircuitBreaker circuitBreaker, Continuation<? super CircuitBreaker$attemptExecution$1> continuation) {
        super(continuation);
        this.this$0 = circuitBreaker;
    }

    @Override // U1.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM93attemptExecutiongIAlus = this.this$0.m93attemptExecutiongIAlus(null, this);
        return objM93attemptExecutiongIAlus == T1.a.f1304a ? objM93attemptExecutiongIAlus : new h(objM93attemptExecutiongIAlus);
    }
}
