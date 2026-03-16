package m1;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4066a;
    public final /* synthetic */ v b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(v vVar, U1.c cVar) {
        super(cVar);
        this.b = vVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f4066a = obj;
        this.c |= Integer.MIN_VALUE;
        v.a(this.b, null, null, this);
        return N1.m.f1129a;
    }
}
