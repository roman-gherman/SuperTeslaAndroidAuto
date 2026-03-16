package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0538d extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3564a;
    public kotlin.jvm.internal.u b;
    public long c;
    public /* synthetic */ Object d;
    public final /* synthetic */ U e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3565f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0538d(U u, Continuation continuation) {
        super(continuation);
        this.e = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f3565f |= Integer.MIN_VALUE;
        return this.e.l(0L, 0L, this);
    }
}
