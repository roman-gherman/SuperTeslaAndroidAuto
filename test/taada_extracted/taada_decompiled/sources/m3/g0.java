package m3;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends e0 {
    public final o0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f4126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0675i f4127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f4128h;

    public g0(o0 o0Var, h0 h0Var, C0675i c0675i, Object obj) {
        this.e = o0Var;
        this.f4126f = h0Var;
        this.f4127g = c0675i;
        this.f4128h = obj;
    }

    @Override // m3.e0
    public final void g(Throwable th) {
        C0675i c0675i = this.f4127g;
        o0 o0Var = this.e;
        o0Var.getClass();
        C0675i c0675iW = o0.w(c0675i);
        h0 h0Var = this.f4126f;
        Object obj = this.f4128h;
        if (c0675iW != null) {
            while (c0675iW.e.invokeOnCompletion((1 & 1) == 0, (1 & 2) != 0, new g0(o0Var, h0Var, c0675iW, obj)) == r0.f4143a) {
                c0675iW = o0.w(c0675iW);
                if (c0675iW == null) {
                }
            }
            return;
        }
        o0Var.b(o0Var.k(h0Var, obj));
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return N1.m.f1129a;
    }
}
