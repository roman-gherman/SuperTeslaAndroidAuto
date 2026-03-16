package r1;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4694a;
    public final /* synthetic */ j b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, U1.c cVar) {
        super(cVar);
        this.b = jVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f4694a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.c(this);
    }
}
