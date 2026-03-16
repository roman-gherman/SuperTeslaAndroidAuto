package m3;

import java.util.concurrent.ScheduledFuture;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.NotCompleted;

/* JADX INFO: renamed from: m3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0671e implements NotCompleted, Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4123a;
    public final Object b;

    public /* synthetic */ C0671e(Object obj, int i) {
        this.f4123a = i;
        this.b = obj;
    }

    public final void a(Throwable th) {
        switch (this.f4123a) {
            case 0:
                if (th != null) {
                    ((ScheduledFuture) this.b).cancel(false);
                }
                break;
            case 1:
                ((DisposableHandle) this.b).dispose();
                break;
            default:
                ((Function1) this.b).invoke(th);
                break;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f4123a) {
            case 0:
                a((Throwable) obj);
                break;
            case 1:
                a((Throwable) obj);
                break;
            default:
                a((Throwable) obj);
                break;
        }
        return N1.m.f1129a;
    }

    public final String toString() {
        switch (this.f4123a) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.b) + ']';
            case 1:
                return "DisposeOnCancel[" + ((DisposableHandle) this.b) + ']';
            default:
                return "InvokeOnCancel[" + ((Function1) this.b).getClass().getSimpleName() + '@' + AbstractC0690y.e(this) + ']';
        }
    }
}
