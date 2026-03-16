package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0557x extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3642a;
    public /* synthetic */ Object b;
    public final /* synthetic */ U c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0557x(U u, Continuation continuation) {
        super(continuation);
        this.c = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.E(0, this);
    }
}
