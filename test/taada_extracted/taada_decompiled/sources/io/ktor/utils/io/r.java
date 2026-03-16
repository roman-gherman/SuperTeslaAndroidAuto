package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3627a;
    public byte[] b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ U f3629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3630h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(U u, Continuation continuation) {
        super(continuation);
        this.f3629g = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3628f = obj;
        this.f3630h |= Integer.MIN_VALUE;
        return this.f3629g.A(null, 0, 0, this);
    }
}
