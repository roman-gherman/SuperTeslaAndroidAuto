package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.helper.widget.a;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.Job;
import m3.AbstractC0684s;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR8\u0010 \u001a&\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\r0\r \u001f*\u0012\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\r0\r\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R(\u0010#\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u00018G@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/ListenableWorker;", "Landroidx/work/impl/constraints/OnConstraintsStateChangedListener;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParameters", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "LN1/m;", "setupAndRunConstraintTrackingWork", "()V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ListenableWorker$Result;", "startWork", "()Lcom/google/common/util/concurrent/ListenableFuture;", "onStopped", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "Landroidx/work/impl/constraints/ConstraintsState;", "state", "onConstraintsStateChanged", "(Landroidx/work/impl/model/WorkSpec;Landroidx/work/impl/constraints/ConstraintsState;)V", "Landroidx/work/WorkerParameters;", "", "lock", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, "", "areConstraintsUnmet", "Z", "Landroidx/work/impl/utils/futures/SettableFuture;", "kotlin.jvm.PlatformType", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "<set-?>", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "Landroidx/work/ListenableWorker;", "getDelegate", "()Landroidx/work/ListenableWorker;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {
    private volatile boolean areConstraintsUnmet;
    private ListenableWorker delegate;
    private final SettableFuture<ListenableWorker.Result> future;
    private final Object lock;
    private final WorkerParameters workerParameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context appContext, WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        h.f(appContext, "appContext");
        h.f(workerParameters, "workerParameters");
        this.workerParameters = workerParameters;
        this.lock = new Object();
        this.future = SettableFuture.create();
    }

    private final void setupAndRunConstraintTrackingWork() {
        if (this.future.isCancelled()) {
            return;
        }
        String string = getInputData().getString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME);
        Logger logger = Logger.get();
        h.e(logger, "get()");
        if (string == null || string.length() == 0) {
            logger.error(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
            SettableFuture<ListenableWorker.Result> future = this.future;
            h.e(future, "future");
            ConstraintTrackingWorkerKt.setFailed(future);
            return;
        }
        ListenableWorker listenableWorkerCreateWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), string, this.workerParameters);
        this.delegate = listenableWorkerCreateWorkerWithDefaultFallback;
        if (listenableWorkerCreateWorkerWithDefaultFallback == null) {
            logger.debug(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
            SettableFuture<ListenableWorker.Result> future2 = this.future;
            h.e(future2, "future");
            ConstraintTrackingWorkerKt.setFailed(future2);
            return;
        }
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
        h.e(workManagerImpl, "getInstance(applicationContext)");
        WorkSpecDao workSpecDao = workManagerImpl.getWorkDatabase().workSpecDao();
        String string2 = getId().toString();
        h.e(string2, "id.toString()");
        WorkSpec workSpec = workSpecDao.getWorkSpec(string2);
        if (workSpec == null) {
            SettableFuture<ListenableWorker.Result> future3 = this.future;
            h.e(future3, "future");
            ConstraintTrackingWorkerKt.setFailed(future3);
            return;
        }
        Trackers trackers = workManagerImpl.getTrackers();
        h.e(trackers, "workManagerImpl.trackers");
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(trackers);
        AbstractC0684s taskCoroutineDispatcher = workManagerImpl.getWorkTaskExecutor().getTaskCoroutineDispatcher();
        h.e(taskCoroutineDispatcher, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
        this.future.addListener(new a(WorkConstraintsTrackerKt.listen(workConstraintsTracker, workSpec, taskCoroutineDispatcher, this), 9), new SynchronousExecutor());
        if (!workConstraintsTracker.areAllConstraintsMet(workSpec)) {
            logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints not met for delegate " + string + ". Requesting retry.");
            SettableFuture<ListenableWorker.Result> future4 = this.future;
            h.e(future4, "future");
            ConstraintTrackingWorkerKt.setRetry(future4);
            return;
        }
        logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints met for delegate ".concat(string));
        try {
            ListenableWorker listenableWorker = this.delegate;
            h.c(listenableWorker);
            ListenableFuture<ListenableWorker.Result> listenableFutureStartWork = listenableWorker.startWork();
            h.e(listenableFutureStartWork, "delegate!!.startWork()");
            listenableFutureStartWork.addListener(new X0.h(16, this, listenableFutureStartWork), getBackgroundExecutor());
        } catch (Throwable th) {
            logger.debug(ConstraintTrackingWorkerKt.TAG, androidx.constraintlayout.core.motion.a.q("Delegated worker ", string, " threw exception in startWork."), th);
            synchronized (this.lock) {
                try {
                    if (!this.areConstraintsUnmet) {
                        SettableFuture<ListenableWorker.Result> future5 = this.future;
                        h.e(future5, "future");
                        ConstraintTrackingWorkerKt.setFailed(future5);
                    } else {
                        logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints were unmet, Retrying.");
                        SettableFuture<ListenableWorker.Result> future6 = this.future;
                        h.e(future6, "future");
                        ConstraintTrackingWorkerKt.setRetry(future6);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$1(Job job) {
        h.f(job, "$job");
        job.cancel((CancellationException) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$3(ConstraintTrackingWorker this$0, ListenableFuture innerFuture) {
        h.f(this$0, "this$0");
        h.f(innerFuture, "$innerFuture");
        synchronized (this$0.lock) {
            try {
                if (this$0.areConstraintsUnmet) {
                    SettableFuture<ListenableWorker.Result> future = this$0.future;
                    h.e(future, "future");
                    ConstraintTrackingWorkerKt.setRetry(future);
                } else {
                    this$0.future.setFuture(innerFuture);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWork$lambda$0(ConstraintTrackingWorker this$0) {
        h.f(this$0, "this$0");
        this$0.setupAndRunConstraintTrackingWork();
    }

    public final ListenableWorker getDelegate() {
        return this.delegate;
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState state) {
        h.f(workSpec, "workSpec");
        h.f(state, "state");
        Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Constraints changed for " + workSpec);
        if (state instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.lock) {
                this.areConstraintsUnmet = true;
            }
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.delegate;
        if (listenableWorker == null || listenableWorker.isStopped()) {
            return;
        }
        listenableWorker.stop(Build.VERSION.SDK_INT >= 31 ? getStopReason() : 0);
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new a(this, 8));
        SettableFuture<ListenableWorker.Result> future = this.future;
        h.e(future, "future");
        return future;
    }
}
