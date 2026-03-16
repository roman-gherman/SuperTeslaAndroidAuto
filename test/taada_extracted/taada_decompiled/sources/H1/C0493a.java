package h1;

/* JADX INFO: renamed from: h1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0493a extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0494b f3351a;
    public F1.a b;
    public /* synthetic */ Object c;
    public final /* synthetic */ C0494b d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0493a(C0494b c0494b, U1.c cVar) {
        super(cVar);
        this.d = c0494b;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, this);
    }
}
