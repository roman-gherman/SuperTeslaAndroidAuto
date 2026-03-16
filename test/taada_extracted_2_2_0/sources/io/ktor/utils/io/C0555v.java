package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0555v extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3637a;
    public I1.c b;
    public kotlin.jvm.internal.u c;
    public I1.c d;
    public J1.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ U f3639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3640h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0555v(U u, Continuation continuation) {
        super(continuation);
        this.f3639g = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3638f = obj;
        this.f3640h |= Integer.MIN_VALUE;
        return this.f3639g.C(0L, this);
    }
}
