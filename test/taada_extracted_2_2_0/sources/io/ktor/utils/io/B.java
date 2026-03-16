package io.ktor.utils.io;

import java.io.Serializable;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class B extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3482a;
    public Object b;
    public Serializable c;
    public Serializable d;
    public kotlin.jvm.internal.s e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public kotlin.jvm.internal.s f3483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f3484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kotlin.jvm.internal.v f3485h;
    public kotlin.jvm.internal.t i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f3487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ U f3488l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3489m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(U u, Continuation continuation) {
        super(continuation);
        this.f3488l = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3487k = obj;
        this.f3489m |= Integer.MIN_VALUE;
        return this.f3488l.H(null, 0, this);
    }
}
