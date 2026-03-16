package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class A extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f3480a;
    public /* synthetic */ Object b;
    public final /* synthetic */ U c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(U u, Continuation continuation) {
        super(continuation);
        this.c = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return U.G(this.c, 0, this);
    }
}
