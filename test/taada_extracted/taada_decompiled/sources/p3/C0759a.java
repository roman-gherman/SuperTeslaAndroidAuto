package p3;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: p3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0759a extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q3.s f4474a;
    public /* synthetic */ Object b;
    public final /* synthetic */ r c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0759a(r rVar, Continuation continuation) {
        super(continuation);
        this.c = rVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
