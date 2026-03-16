package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3507a;
    public int b;
    public io.ktor.utils.io.internal.r c;
    public U d;
    public ByteBuffer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ U f3509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3510h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(U u, Continuation continuation) {
        super(continuation);
        this.f3509g = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3508f = obj;
        this.f3510h |= Integer.MIN_VALUE;
        return U.e0(this.f3509g, 0, this);
    }
}
