package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3506a;
    public int b;
    public io.ktor.utils.io.internal.r c;
    public U d;
    public ByteBuffer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ U f3508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3509h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(U u, Continuation continuation) {
        super(continuation);
        this.f3508g = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3507f = obj;
        this.f3509h |= Integer.MIN_VALUE;
        return U.e0(this.f3508g, 0, this);
    }
}
