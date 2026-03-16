package j1;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableJob;
import m1.H;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3655a;
    public final /* synthetic */ CompletableJob b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(CompletableJob completableJob, int i) {
        super(1);
        this.f3655a = i;
        this.b = completableJob;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f3655a) {
            case 0:
                Throwable th = (Throwable) obj;
                if (th != null) {
                    this.b.cancel(new CancellationException(th.getMessage()));
                }
                break;
            case 1:
                this.b.complete();
                break;
            default:
                Throwable th2 = (Throwable) obj;
                CompletableJob completableJob = this.b;
                if (th2 != null) {
                    H.f4038a.trace("Cancelling request because engine Job failed with error: " + th2);
                    CancellationException cancellationException = new CancellationException("Engine failed");
                    cancellationException.initCause(th2);
                    completableJob.cancel(cancellationException);
                } else {
                    H.f4038a.trace("Cancelling request because engine Job completed");
                    completableJob.complete();
                }
                break;
        }
        return N1.m.f1129a;
    }
}
