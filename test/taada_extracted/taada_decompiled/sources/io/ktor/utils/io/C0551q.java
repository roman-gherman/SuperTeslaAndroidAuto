package io.ktor.utils.io;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0551q extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3624a;
    public J1.b b;
    public int c;
    public int d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ U f3625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3626g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0551q(U u, Continuation continuation) {
        super(continuation);
        this.f3625f = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f3626g |= Integer.MIN_VALUE;
        return this.f3625f.y(null, 0, this);
    }
}
