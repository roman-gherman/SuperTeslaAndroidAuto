package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class T extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3526a;
    public Function1 b;
    public kotlin.jvm.internal.s c;
    public U d;
    public U e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public io.ktor.utils.io.internal.r f3527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public io.ktor.utils.io.internal.r f3528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteBuffer f3529h;
    public U i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f3531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ U f3532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3533m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(U u, Continuation continuation) {
        super(continuation);
        this.f3532l = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3531k = obj;
        this.f3533m |= Integer.MIN_VALUE;
        return this.f3532l.n0(null, this);
    }
}
