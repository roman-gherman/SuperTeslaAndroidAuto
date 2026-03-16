package io.ktor.utils.io;

import java.io.Serializable;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class B extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3481a;
    public Object b;
    public Serializable c;
    public Serializable d;
    public kotlin.jvm.internal.s e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public kotlin.jvm.internal.s f3482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f3483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kotlin.jvm.internal.v f3484h;
    public kotlin.jvm.internal.t i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f3486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ U f3487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3488m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(U u, Continuation continuation) {
        super(continuation);
        this.f3487l = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3486k = obj;
        this.f3488m |= Integer.MIN_VALUE;
        return this.f3487l.H(null, 0, this);
    }
}
