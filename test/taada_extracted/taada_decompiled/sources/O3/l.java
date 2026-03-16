package o3;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4330a;
    public final /* synthetic */ n b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar, Continuation continuation) {
        super(continuation);
        this.b = nVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f4330a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objV = n.v(this.b, this);
        return objV == T1.a.f1304a ? objV : new v(objV);
    }
}
