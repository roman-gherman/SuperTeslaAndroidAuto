package E1;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f285a;
    public /* synthetic */ Object b;
    public final /* synthetic */ b c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, Continuation continuation) {
        super(continuation);
        this.c = bVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.e(this);
    }
}
