package g1;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3291a;
    public final /* synthetic */ f b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, U1.c cVar) {
        super(cVar);
        this.b = fVar;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3291a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.a(null, this);
    }
}
