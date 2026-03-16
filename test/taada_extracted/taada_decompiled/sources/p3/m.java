package p3;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f4486a;
    public /* synthetic */ Object b;
    public int c;
    public final /* synthetic */ n d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, Continuation continuation) {
        super(continuation);
        this.d = nVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
