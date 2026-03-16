package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3522a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ U d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(U u, Continuation continuation) {
        super(continuation);
        this.d = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.i0(0, this);
    }
}
