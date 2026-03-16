package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3493a;
    public Function1 b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ U e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3494f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(U u, Continuation continuation) {
        super(continuation);
        this.e = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f3494f |= Integer.MIN_VALUE;
        return U.U(this.e, 0, null, this);
    }
}
