package androidx.work.impl;

import X0.g;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u000f\u0010\u0015\u001a#\u0010\u0018\u001a\u00020\u0017*\u00020\u00112\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001b\u0010\u001d\u001a\u00020\u001c*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/work/impl/Processor;", "processor", "Landroidx/work/impl/WorkDatabase;", "workDatabase", "Landroidx/work/Configuration;", "configuration", "", "Landroidx/work/impl/Scheduler;", "schedulers", "Landroidx/work/impl/model/WorkSpec;", "newWorkSpec", "", "", "tags", "Landroidx/work/WorkManager$UpdateResult;", "updateWorkImpl", "(Landroidx/work/impl/Processor;Landroidx/work/impl/WorkDatabase;Landroidx/work/Configuration;Ljava/util/List;Landroidx/work/impl/model/WorkSpec;Ljava/util/Set;)Landroidx/work/WorkManager$UpdateResult;", "Landroidx/work/impl/WorkManagerImpl;", "Landroidx/work/WorkRequest;", "workRequest", "Lcom/google/common/util/concurrent/ListenableFuture;", "(Landroidx/work/impl/WorkManagerImpl;Landroidx/work/WorkRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "name", "Landroidx/work/Operation;", "enqueueUniquelyNamedPeriodic", "(Landroidx/work/impl/WorkManagerImpl;Ljava/lang/String;Landroidx/work/WorkRequest;)Landroidx/work/Operation;", "Landroidx/work/impl/OperationImpl;", "message", "LN1/m;", "failWorkTypeChanged", "(Landroidx/work/impl/OperationImpl;Ljava/lang/String;)V", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WorkerUpdater {
    public static final Operation enqueueUniquelyNamedPeriodic(final WorkManagerImpl workManagerImpl, final String name, final WorkRequest workRequest) {
        h.f(workManagerImpl, "<this>");
        h.f(name, "name");
        h.f(workRequest, "workRequest");
        final OperationImpl operationImpl = new OperationImpl();
        final WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1 workerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1 = new WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1(workRequest, workManagerImpl, name, operationImpl);
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new Runnable() { // from class: androidx.work.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$4(workManagerImpl, name, operationImpl, workerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1, workRequest);
            }
        });
        return operationImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueueUniquelyNamedPeriodic$lambda$4(WorkManagerImpl this_enqueueUniquelyNamedPeriodic, String name, OperationImpl operation, Function0 enqueueNew, WorkRequest workRequest) {
        h.f(this_enqueueUniquelyNamedPeriodic, "$this_enqueueUniquelyNamedPeriodic");
        h.f(name, "$name");
        h.f(operation, "$operation");
        h.f(enqueueNew, "$enqueueNew");
        h.f(workRequest, "$workRequest");
        WorkSpecDao workSpecDao = this_enqueueUniquelyNamedPeriodic.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workSpecDao.getWorkSpecIdAndStatesForName(name);
        if (workSpecIdAndStatesForName.size() > 1) {
            failWorkTypeChanged(operation, "Can't apply UPDATE policy to the chains of work.");
            return;
        }
        WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) m.R(workSpecIdAndStatesForName);
        if (idAndState == null) {
            enqueueNew.invoke();
            return;
        }
        WorkSpec workSpec = workSpecDao.getWorkSpec(idAndState.id);
        if (workSpec == null) {
            operation.markState(new Operation.State.FAILURE(new IllegalStateException("WorkSpec with " + idAndState.id + ", that matches a name \"" + name + "\", wasn't found")));
            return;
        }
        if (!workSpec.isPeriodic()) {
            failWorkTypeChanged(operation, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            return;
        }
        if (idAndState.state == WorkInfo.State.CANCELLED) {
            workSpecDao.delete(idAndState.id);
            enqueueNew.invoke();
            return;
        }
        WorkSpec workSpecCopy$default = WorkSpec.copy$default(workRequest.getWorkSpec(), idAndState.id, null, null, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388606, null);
        try {
            Processor processor = this_enqueueUniquelyNamedPeriodic.getProcessor();
            h.e(processor, "processor");
            WorkDatabase workDatabase = this_enqueueUniquelyNamedPeriodic.getWorkDatabase();
            h.e(workDatabase, "workDatabase");
            Configuration configuration = this_enqueueUniquelyNamedPeriodic.getConfiguration();
            h.e(configuration, "configuration");
            List<Scheduler> schedulers = this_enqueueUniquelyNamedPeriodic.getSchedulers();
            h.e(schedulers, "schedulers");
            updateWorkImpl(processor, workDatabase, configuration, schedulers, workSpecCopy$default, workRequest.getTags());
            operation.markState(Operation.SUCCESS);
        } catch (Throwable th) {
            operation.markState(new Operation.State.FAILURE(th));
        }
    }

    private static final void failWorkTypeChanged(OperationImpl operationImpl, String str) {
        operationImpl.markState(new Operation.State.FAILURE(new UnsupportedOperationException(str)));
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor processor, final WorkDatabase workDatabase, Configuration configuration, final List<? extends Scheduler> list, final WorkSpec workSpec, final Set<String> set) {
        final String str = workSpec.id;
        final WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.q("Worker with ", str, " doesn't exist"));
        }
        if (workSpec2.state.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        }
        if (workSpec2.isPeriodic() ^ workSpec.isPeriodic()) {
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = WorkerUpdater$updateWorkImpl$type$1.INSTANCE;
            StringBuilder sb = new StringBuilder("Can't update ");
            sb.append(workerUpdater$updateWorkImpl$type$1.invoke(workSpec2));
            sb.append(" Worker to ");
            throw new UnsupportedOperationException(B2.b.h(sb, workerUpdater$updateWorkImpl$type$1.invoke(workSpec), " Worker. Update operation must preserve worker's type."));
        }
        final boolean zIsEnqueued = processor.isEnqueued(str);
        if (!zIsEnqueued) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Scheduler) it.next()).cancel(str);
            }
        }
        workDatabase.runInTransaction(new Runnable() { // from class: androidx.work.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.updateWorkImpl$lambda$2(workDatabase, workSpec2, workSpec, list, str, set, zIsEnqueued);
            }
        });
        if (!zIsEnqueued) {
            Schedulers.schedule(configuration, workDatabase, list);
        }
        return zIsEnqueued ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$2(WorkDatabase workDatabase, WorkSpec oldWorkSpec, WorkSpec newWorkSpec, List schedulers, String workSpecId, Set tags, boolean z6) {
        h.f(workDatabase, "$workDatabase");
        h.f(oldWorkSpec, "$oldWorkSpec");
        h.f(newWorkSpec, "$newWorkSpec");
        h.f(schedulers, "$schedulers");
        h.f(workSpecId, "$workSpecId");
        h.f(tags, "$tags");
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        WorkSpec workSpecCopy$default = WorkSpec.copy$default(newWorkSpec, null, oldWorkSpec.state, null, null, null, null, 0L, 0L, 0L, null, oldWorkSpec.runAttemptCount, null, 0L, oldWorkSpec.lastEnqueueTime, 0L, 0L, false, null, oldWorkSpec.getPeriodCount(), oldWorkSpec.getGeneration() + 1, oldWorkSpec.getNextScheduleTimeOverride(), oldWorkSpec.getNextScheduleTimeOverrideGeneration(), 0, 4447229, null);
        if (newWorkSpec.getNextScheduleTimeOverrideGeneration() == 1) {
            workSpecCopy$default.setNextScheduleTimeOverride(newWorkSpec.getNextScheduleTimeOverride());
            workSpecCopy$default.setNextScheduleTimeOverrideGeneration(workSpecCopy$default.getNextScheduleTimeOverrideGeneration() + 1);
        }
        workSpecDao.updateWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(schedulers, workSpecCopy$default));
        workTagDao.deleteByWorkSpecId(workSpecId);
        workTagDao.insertTags(workSpecId, tags);
        if (z6) {
            return;
        }
        workSpecDao.markWorkSpecScheduled(workSpecId, -1L);
        workDatabase.workProgressDao().delete(workSpecId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$3(SettableFuture settableFuture, WorkManagerImpl this_updateWorkImpl, WorkRequest workRequest) {
        h.f(this_updateWorkImpl, "$this_updateWorkImpl");
        h.f(workRequest, "$workRequest");
        if (settableFuture.isCancelled()) {
            return;
        }
        try {
            Processor processor = this_updateWorkImpl.getProcessor();
            h.e(processor, "processor");
            WorkDatabase workDatabase = this_updateWorkImpl.getWorkDatabase();
            h.e(workDatabase, "workDatabase");
            Configuration configuration = this_updateWorkImpl.getConfiguration();
            h.e(configuration, "configuration");
            List<Scheduler> schedulers = this_updateWorkImpl.getSchedulers();
            h.e(schedulers, "schedulers");
            settableFuture.set(updateWorkImpl(processor, workDatabase, configuration, schedulers, workRequest.getWorkSpec(), workRequest.getTags()));
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    public static final ListenableFuture<WorkManager.UpdateResult> updateWorkImpl(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        h.f(workManagerImpl, "<this>");
        h.f(workRequest, "workRequest");
        SettableFuture future = SettableFuture.create();
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new g(future, workManagerImpl, workRequest, 4));
        h.e(future, "future");
        return future;
    }
}
