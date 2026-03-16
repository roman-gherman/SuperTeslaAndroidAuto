package androidx.work.impl.utils;

import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u0010\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0015\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "workDatabase", "Landroidx/work/Configuration;", "configuration", "Landroidx/work/impl/WorkContinuationImpl;", "continuation", "LN1/m;", "checkContentUriTriggerWorkerLimits", "(Landroidx/work/impl/WorkDatabase;Landroidx/work/Configuration;Landroidx/work/impl/WorkContinuationImpl;)V", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "tryDelegateConstrainedWorkSpec", "(Landroidx/work/impl/model/WorkSpec;)Landroidx/work/impl/model/WorkSpec;", "", "Landroidx/work/impl/Scheduler;", "schedulers", "wrapInConstraintTrackingWorkerIfNeeded", "(Ljava/util/List;Landroidx/work/impl/model/WorkSpec;)Landroidx/work/impl/model/WorkSpec;", "", "className", "", "usesScheduler", "(Ljava/util/List;Ljava/lang/String;)Z", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EnqueueUtilsKt {
    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl continuation) {
        int i;
        h.f(workDatabase, "workDatabase");
        h.f(configuration, "configuration");
        h.f(continuation, "continuation");
        ArrayList arrayListA = n.A(continuation);
        int i3 = 0;
        while (!arrayListA.isEmpty()) {
            WorkContinuationImpl workContinuationImpl = (WorkContinuationImpl) s.I(arrayListA);
            List<? extends WorkRequest> work = workContinuationImpl.getWork();
            h.e(work, "current.work");
            if (work.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = work.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((WorkRequest) it.next()).getWorkSpec().constraints.hasContentUriTriggers() && (i = i + 1) < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
            }
            i3 += i;
            List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
            if (parents != null) {
                arrayListA.addAll(parents);
            }
        }
        if (i3 == 0) {
            return;
        }
        int iCountNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
        int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
        if (iCountNonFinishedContentUriTriggerWorkers + i3 <= contentUriTriggerWorkersLimit) {
            return;
        }
        StringBuilder sb = new StringBuilder("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ");
        sb.append(contentUriTriggerWorkersLimit);
        sb.append(";\nalready enqueued count: ");
        sb.append(iCountNonFinishedContentUriTriggerWorkers);
        sb.append(";\ncurrent enqueue operation count: ");
        throw new IllegalArgumentException(B2.b.g(sb, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.", i3));
    }

    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec) throws Throwable {
        h.f(workSpec, "workSpec");
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (h.a(str, ConstraintTrackingWorker.class.getName()) || !(constraints.getRequiresBatteryNotLow() || constraints.getRequiresStorageNotLow())) {
            return workSpec;
        }
        Data dataBuild = new Data.Builder().putAll(workSpec.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build();
        h.e(dataBuild, "Builder().putAll(workSpe…ame)\n            .build()");
        return WorkSpec.copy$default(workSpec, null, null, ConstraintTrackingWorker.class.getName(), null, dataBuild, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388587, null);
    }

    private static final boolean usesScheduler(List<? extends Scheduler> list, String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (list != null && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(((Scheduler) it.next()).getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(List<? extends Scheduler> schedulers, WorkSpec workSpec) {
        h.f(schedulers, "schedulers");
        h.f(workSpec, "workSpec");
        return workSpec;
    }
}
