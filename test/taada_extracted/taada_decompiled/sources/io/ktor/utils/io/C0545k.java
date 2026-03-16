package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: io.ktor.utils.io.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0545k extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3616a;
    public Function1 b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ U e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3617f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0545k(U u, Continuation continuation) {
        super(continuation);
        this.e = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f3617f |= Integer.MIN_VALUE;
        return this.e.x(0, null, this);
    }
}
