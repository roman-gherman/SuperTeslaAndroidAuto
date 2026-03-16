package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0553t extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3632a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ U d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0553t(U u, Continuation continuation) {
        super(continuation);
        this.d = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.readLong(this);
    }
}
