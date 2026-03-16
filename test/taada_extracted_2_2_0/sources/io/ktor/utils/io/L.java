package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class L extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3511a;
    public io.ktor.utils.io.internal.r b;
    public U c;
    public ByteBuffer d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ U f3513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3514h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(U u, Continuation continuation) {
        super(continuation);
        this.f3513g = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3512f = obj;
        this.f3514h |= Integer.MIN_VALUE;
        return U.f0(this.f3513g, 0L, this);
    }
}
