package X0;

import C0.t;
import android.app.job.JobParameters;
import android.content.Context;
import android.graphics.Typeface;
import android.view.DispatchQueue;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.profileinstaller.ProfileInstallerInitializer;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$callback$1;
import androidx.room.TransactionExecutor;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.layout.SidecarWindowBackend;
import androidx.window.layout.WindowLayoutInfo;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.background.greedy.TimeLimiter;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.material.datepicker.AbstractC0346i;
import com.google.android.material.datepicker.L;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.util.concurrent.ListenableFuture;
import com.tenjin.android.store.QueueEventDao;
import fr.sd.taada.R;
import fr.sd.taada.helpers.MemoryTestRunner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.eventbus.util.AsyncExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1410a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ h(int i, Object obj, Object obj2) {
        this.f1410a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.c;
        Object obj2 = this.b;
        switch (this.f1410a) {
            case 0:
                t tVar = (t) obj2;
                Date date = (Date) tVar.e;
                QueueEventDao queueEventDao = (QueueEventDao) tVar.b;
                List<a> allEvents = queueEventDao.getAllEvents(date);
                queueEventDao.deleteOldEvents(date);
                ((R0.a) obj).onEventsLoaded(allEvents);
                break;
            case 1:
                ((ViewTransition) obj2).lambda$applyTransition$0((View[]) obj);
                break;
            case 2:
                ((ResourcesCompat.FontCallback) obj2).lambda$callbackSuccessAsync$0((Typeface) obj);
                break;
            case 3:
                DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1((DispatchQueue) obj2, (Runnable) obj);
                break;
            case 4:
                ((ProfileInstallerInitializer) obj2).lambda$delayAfterFirstFrame$0((Context) obj);
                break;
            case 5:
                MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0((MultiInstanceInvalidationClient) obj2, (String[]) obj);
                break;
            case 6:
                TransactionExecutor.execute$lambda$1$lambda$0((Runnable) obj2, (TransactionExecutor) obj);
                break;
            case 7:
                ExtensionEmbeddingBackend.SplitListenerWrapper.m74accept$lambda1((ExtensionEmbeddingBackend.SplitListenerWrapper) obj2, (ArrayList) obj);
                break;
            case 8:
                SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m75accept$lambda0((SidecarWindowBackend.WindowLayoutChangeCallbackWrapper) obj2, (WindowLayoutInfo) obj);
                break;
            case 9:
                ((WorkerWrapper) obj2).lambda$runWorker$0((ListenableFuture) obj);
                break;
            case 10:
                TimeLimiter.track$lambda$0((TimeLimiter) obj2, (StartStopToken) obj);
                break;
            case 11:
                ConstraintTracker._set_state_$lambda$4$lambda$3((List) obj2, (ConstraintTracker) obj);
                break;
            case 12:
                ((WorkForegroundRunnable) obj2).lambda$run$0((SettableFuture) obj);
                break;
            case 13:
                FragmentStrictMode.handlePolicyViolation$lambda$0((FragmentStrictMode.Policy) obj2, (Violation) obj);
                break;
            case 14:
                FragmentStrictMode.handlePolicyViolation$lambda$1((String) obj2, (Violation) obj);
                break;
            case 15:
                AbstractC0346i abstractC0346i = (AbstractC0346i) obj2;
                TextInputLayout textInputLayout = abstractC0346i.f2420a;
                Context context = textInputLayout.getContext();
                textInputLayout.setError(context.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), ((String) obj).replace(' ', (char) 160)) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), abstractC0346i.b.format(new Date(L.f().getTimeInMillis())).replace(' ', (char) 160)));
                abstractC0346i.a();
                break;
            case 16:
                ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$3((ConstraintTrackingWorker) obj2, (ListenableFuture) obj);
                break;
            case 17:
                ((MemoryTestRunner.TestCallback) obj2).onTestComplete((String) obj);
                break;
            case 18:
                ((AsyncExecutor) obj2).lambda$execute$0((AsyncExecutor.RunnableEx) obj);
                break;
            default:
                int i = JobInfoSchedulerService.f1894a;
                ((JobInfoSchedulerService) obj2).jobFinished((JobParameters) obj, false);
                break;
        }
    }
}
