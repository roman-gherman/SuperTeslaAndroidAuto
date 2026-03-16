package m3;

import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends e0 {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SelectInstance f4130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ o0 f4131g;

    public /* synthetic */ i0(o0 o0Var, SelectInstance selectInstance, int i) {
        this.e = i;
        this.f4131g = o0Var;
        this.f4130f = selectInstance;
    }

    @Override // m3.e0
    public final void g(Throwable th) {
        switch (this.e) {
            case 0:
                o0 o0Var = this.f4131g;
                Object objP = o0Var.p();
                if (!(objP instanceof C0677k)) {
                    objP = AbstractC0690y.l(objP);
                }
                this.f4130f.trySelect(o0Var, objP);
                break;
            default:
                this.f4130f.trySelect(this.f4131g, N1.m.f1129a);
                break;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.e) {
            case 0:
                g((Throwable) obj);
                break;
            default:
                g((Throwable) obj);
                break;
        }
        return N1.m.f1129a;
    }
}
