package m3;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends e0 {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4106f;

    public /* synthetic */ I(Object obj, int i) {
        this.e = i;
        this.f4106f = obj;
    }

    @Override // m3.e0
    public final void g(Throwable th) {
        switch (this.e) {
            case 0:
                ((DisposableHandle) this.f4106f).dispose();
                break;
            case 1:
                ((Function1) this.f4106f).invoke(th);
                break;
            case 2:
                Object objP = f().p();
                boolean z6 = objP instanceof C0677k;
                f0 f0Var = (f0) this.f4106f;
                if (!z6) {
                    f0Var.resumeWith(AbstractC0690y.l(objP));
                } else {
                    f0Var.resumeWith(kotlin.reflect.l.n(((C0677k) objP).f4133a));
                }
                break;
            default:
                ((C0672f) this.f4106f).resumeWith(N1.m.f1129a);
                break;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.e) {
            case 0:
                g((Throwable) obj);
                break;
            case 1:
                g((Throwable) obj);
                break;
            case 2:
                g((Throwable) obj);
                break;
            default:
                g((Throwable) obj);
                break;
        }
        return N1.m.f1129a;
    }
}
