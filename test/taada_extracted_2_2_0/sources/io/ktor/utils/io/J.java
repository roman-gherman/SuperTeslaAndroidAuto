package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3504a;
    public byte[] b;
    public int c;
    public int d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ U f3505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3506g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(U u, Continuation continuation) {
        super(continuation);
        this.f3505f = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f3506g |= Integer.MIN_VALUE;
        return this.f3505f.d0(null, 0, 0, this);
    }
}
