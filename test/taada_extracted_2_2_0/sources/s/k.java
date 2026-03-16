package s;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f4753a;
    public final EventStore b;
    public final WorkScheduler c;
    public final SynchronizationGuard d;

    public k(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f4753a = executor;
        this.b = eventStore;
        this.c = workScheduler;
        this.d = synchronizationGuard;
    }
}
