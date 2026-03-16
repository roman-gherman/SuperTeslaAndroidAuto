package io.ktor.utils.io;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: io.ktor.utils.io.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0536b extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3552a;
    public Function1 b;
    public /* synthetic */ Object c;
    public final /* synthetic */ U d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0536b(U u, U1.c cVar) {
        super(cVar);
        this.d = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.e(0, null, this);
    }
}
