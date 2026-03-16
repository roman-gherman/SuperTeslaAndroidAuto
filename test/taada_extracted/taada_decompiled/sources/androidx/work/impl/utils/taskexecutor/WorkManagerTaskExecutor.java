package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;
import m3.AbstractC0684s;
import m3.U;

/* JADX INFO: loaded from: classes.dex */
public class WorkManagerTaskExecutor implements TaskExecutor {
    private final SerialExecutorImpl mBackgroundExecutor;
    private final AbstractC0684s mTaskDispatcher;
    final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private final Executor mMainThreadExecutor = new Executor() { // from class: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.mMainThreadHandler.post(runnable);
        }
    };

    public WorkManagerTaskExecutor(Executor executor) {
        SerialExecutorImpl serialExecutorImpl = new SerialExecutorImpl(executor);
        this.mBackgroundExecutor = serialExecutorImpl;
        this.mTaskDispatcher = new U(serialExecutorImpl);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public AbstractC0684s getTaskCoroutineDispatcher() {
        return this.mTaskDispatcher;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public SerialExecutorImpl getSerialTaskExecutor() {
        return this.mBackgroundExecutor;
    }
}
