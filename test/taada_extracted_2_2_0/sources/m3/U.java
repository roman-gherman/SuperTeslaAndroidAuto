package m3;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import r3.AbstractC0802c;

/* JADX INFO: loaded from: classes2.dex */
public final class U extends T implements Delay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f4114a;

    public U(Executor executor) {
        Method method;
        this.f4114a = executor;
        Method method2 = AbstractC0802c.f4703a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = AbstractC0802c.f4703a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f4114a;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final Object delay(long j6, Continuation continuation) {
        return AbstractC0690y.c(this, j6, continuation);
    }

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            this.f4114a.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            Job job = (Job) coroutineContext.get(Job.Key);
            if (job != null) {
                job.cancel(cancellationException);
            }
            G.c.dispatch(coroutineContext, runnable);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof U) && ((U) obj).f4114a == this.f4114a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f4114a);
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j6, Runnable runnable, CoroutineContext coroutineContext) {
        Executor executor = this.f4114a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j6, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                Job job = (Job) coroutineContext.get(Job.Key);
                if (job != null) {
                    job.cancel(cancellationException);
                }
            }
        }
        return scheduledFutureSchedule != null ? new H(scheduledFutureSchedule) : RunnableC0691z.f4155h.invokeOnTimeout(j6, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j6, CancellableContinuation cancellableContinuation) {
        Executor executor = this.f4114a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            B.o oVar = new B.o(this, cancellableContinuation, 2, false);
            CoroutineContext context = cancellableContinuation.getContext();
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(oVar, j6, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                Job job = (Job) context.get(Job.Key);
                if (job != null) {
                    job.cancel(cancellationException);
                }
            }
        }
        if (scheduledFutureSchedule != null) {
            cancellableContinuation.invokeOnCancellation(new C0671e(scheduledFutureSchedule, 0));
        } else {
            RunnableC0691z.f4155h.scheduleResumeAfterDelay(j6, cancellableContinuation);
        }
    }

    @Override // m3.AbstractC0684s
    public final String toString() {
        return this.f4114a.toString();
    }
}
