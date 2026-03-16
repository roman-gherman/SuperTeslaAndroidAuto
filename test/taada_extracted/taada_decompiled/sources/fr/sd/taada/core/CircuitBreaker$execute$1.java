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
@DebugMetadata(c = "fr.sd.taada.core.CircuitBreaker", f = "CircuitBreaker.kt", i = {0, 0, 0, 1, 2, 3}, l = {190, 56, 63, 66}, m = "execute-gIAlu-s", n = {"this", "block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$0", "L$0"})
public final class CircuitBreaker$execute$1<T> extends c {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CircuitBreaker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircuitBreaker$execute$1(CircuitBreaker circuitBreaker, Continuation<? super CircuitBreaker$execute$1> continuation) {
        super(continuation);
        this.this$0 = circuitBreaker;
    }

    @Override // U1.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM94executegIAlus = this.this$0.m94executegIAlus(null, this);
        return objM94executegIAlus == T1.a.f1304a ? objM94executegIAlus : new h(objM94executegIAlus);
    }
}
