package androidx.work;

import N1.m;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.Job;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t2\u000e\u0010\r\u001a\n \n*\u0004\u0018\u00010\f0\fH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\n \n*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0014\u001a\n \n*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\u000b\u001a\u00020\u00162\u000e\u0010\r\u001a\n \n*\u0004\u0018\u00010\u00170\u0017H\u0096\u0003¢\u0006\u0004\b\u0014\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 ¨\u0006!"}, d2 = {"Landroidx/work/JobListenableFuture;", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lkotlinx/coroutines/Job;", "job", "Landroidx/work/impl/utils/futures/SettableFuture;", "underlying", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lkotlinx/coroutines/Job;Landroidx/work/impl/utils/futures/SettableFuture;)V", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "p0", "Ljava/util/concurrent/Executor;", "p1", "LN1/m;", "addListener", "(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V", "", "cancel", "(Z)Z", "get", "()Ljava/lang/Object;", "", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "()Z", "isDone", "result", "complete", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/Job;", "Landroidx/work/impl/utils/futures/SettableFuture;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JobListenableFuture<R> implements ListenableFuture<R> {
    private final Job job;
    private final SettableFuture<R> underlying;

    /* JADX INFO: renamed from: androidx.work.JobListenableFuture$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", "throwable", "LN1/m;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends i implements Function1<Throwable, m> {
        final /* synthetic */ JobListenableFuture<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(JobListenableFuture<R> jobListenableFuture) {
            super(1);
            this.this$0 = jobListenableFuture;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(Throwable th) {
            invoke2(th);
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (th == null) {
                if (!((JobListenableFuture) this.this$0).underlying.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            } else {
                if (th instanceof CancellationException) {
                    ((JobListenableFuture) this.this$0).underlying.cancel(true);
                    return;
                }
                SettableFuture settableFuture = ((JobListenableFuture) this.this$0).underlying;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                settableFuture.setException(th);
            }
        }
    }

    public JobListenableFuture(Job job, SettableFuture<R> underlying) {
        h.f(job, "job");
        h.f(underlying, "underlying");
        this.job = job;
        this.underlying = underlying;
        job.invokeOnCompletion(new AnonymousClass1(this));
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable p02, Executor p12) {
        this.underlying.addListener(p02, p12);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean p02) {
        return this.underlying.cancel(p02);
    }

    public final void complete(R result) {
        this.underlying.set(result);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.underlying.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.underlying.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.underlying.isDone();
    }

    @Override // java.util.concurrent.Future
    public R get(long p02, TimeUnit p12) {
        return this.underlying.get(p02, p12);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ JobListenableFuture(Job job, SettableFuture settableFuture, int i, d dVar) {
        if ((i & 2) != 0) {
            settableFuture = SettableFuture.create();
            h.e(settableFuture, "create()");
        }
        this(job, settableFuture);
    }
}
