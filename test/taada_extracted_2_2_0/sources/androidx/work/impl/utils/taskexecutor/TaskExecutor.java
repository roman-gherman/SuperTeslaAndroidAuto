package androidx.work.impl.utils.taskexecutor;

import java.util.concurrent.Executor;
import m3.AbstractC0684s;
import m3.U;

/* JADX INFO: loaded from: classes.dex */
public interface TaskExecutor {
    default void executeOnTaskThread(Runnable runnable) {
        getSerialTaskExecutor().execute(runnable);
    }

    Executor getMainThreadExecutor();

    SerialExecutor getSerialTaskExecutor();

    default AbstractC0684s getTaskCoroutineDispatcher() {
        return new U(getSerialTaskExecutor());
    }
}
