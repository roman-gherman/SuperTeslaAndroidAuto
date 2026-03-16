package p3;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4476a;
    public final /* synthetic */ e b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, Continuation continuation) {
        super(continuation);
        this.b = eVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f4476a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}
