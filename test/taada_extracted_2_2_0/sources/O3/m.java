package o3;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4332a;
    public final /* synthetic */ n b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, U1.c cVar) {
        super(cVar);
        this.b = nVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f4332a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objW = this.b.w(null, 0, 0L, this);
        return objW == T1.a.f1304a ? objW : new v(objW);
    }
}
