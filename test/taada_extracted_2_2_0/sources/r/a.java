package r;

import androidx.work.impl.d;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.u;
import com.google.android.datatransport.runtime.v;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Scheduler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f4678f = Logger.getLogger(v.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkScheduler f4679a;
    public final Executor b;
    public final BackendRegistry c;
    public final EventStore d;
    public final SynchronizationGuard e;

    public a(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.b = executor;
        this.c = backendRegistry;
        this.f4679a = workScheduler;
        this.d = eventStore;
        this.e = synchronizationGuard;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public final void schedule(u uVar, o oVar, TransportScheduleCallback transportScheduleCallback) {
        this.b.execute(new d(this, uVar, transportScheduleCallback, oVar, 4));
    }
}
