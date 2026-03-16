package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0539e extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3567a;
    public Object b;
    public kotlin.jvm.internal.v c;
    public U d;
    public kotlin.jvm.internal.v e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ U f3569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3570h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0539e(U u, Continuation continuation) {
        super(continuation);
        this.f3569g = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3568f = obj;
        this.f3570h |= Integer.MIN_VALUE;
        return U.n(this.f3569g, this, null);
    }
}
