package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class T extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3525a;
    public Function1 b;
    public kotlin.jvm.internal.s c;
    public U d;
    public U e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public io.ktor.utils.io.internal.r f3526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public io.ktor.utils.io.internal.r f3527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteBuffer f3528h;
    public U i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f3530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ U f3531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3532m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(U u, Continuation continuation) {
        super(continuation);
        this.f3531l = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3530k = obj;
        this.f3532m |= Integer.MIN_VALUE;
        return this.f3531l.n0(null, this);
    }
}
