package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class N extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f3516a;
    public io.ktor.utils.io.internal.r b;
    public U c;
    public ByteBuffer d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ U f3518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3519h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(U u, Continuation continuation) {
        super(continuation);
        this.f3518g = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3517f = obj;
        this.f3519h |= Integer.MIN_VALUE;
        return U.h0(this.f3518g, (short) 0, this);
    }
}
