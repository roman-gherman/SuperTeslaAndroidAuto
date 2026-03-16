package r1;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4692a;
    public Object b;
    public /* synthetic */ Object c;
    public final /* synthetic */ j d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(j jVar, U1.c cVar) {
        super(cVar);
        this.d = jVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.b(null, this);
    }
}
