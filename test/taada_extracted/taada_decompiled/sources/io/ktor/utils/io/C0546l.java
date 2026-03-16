package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0546l extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3618a;
    public final /* synthetic */ U b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0546l(U u, Continuation continuation) {
        super(continuation);
        this.b = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3618a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.readBoolean(this);
    }
}
