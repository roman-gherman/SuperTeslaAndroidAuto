package m3;

import java.util.concurrent.ScheduledFuture;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: loaded from: classes2.dex */
public final class H implements DisposableHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f4105a;

    public H(ScheduledFuture scheduledFuture) {
        this.f4105a = scheduledFuture;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        this.f4105a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f4105a + ']';
    }
}
