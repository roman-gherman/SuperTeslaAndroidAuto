package androidx.work;

import C5.f;
import N1.m;
import T1.a;
import U1.g;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0684s;
import m3.AbstractC0689x;
import m3.AbstractC0690y;
import m3.C0672f;
import m3.G;
import m3.d0;
import net.bytebuddy.description.method.MethodDescription;
import r3.C0804e;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u001b\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\u0018\u0010\u000bJ\r\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010!\u001a\b\u0012\u0004\u0012\u00020\t0 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R \u0010&\u001a\u00020%8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010\u001a\u001a\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ListenableWorker$Result;", "startWork", "()Lcom/google/common/util/concurrent/ListenableFuture;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/ForegroundInfo;", "getForegroundInfo", "Landroidx/work/Data;", "data", "LN1/m;", "setProgress", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foregroundInfo", "setForeground", "(Landroidx/work/ForegroundInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForegroundInfoAsync", "onStopped", "()V", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob$work_runtime_release", "()Lkotlinx/coroutines/CompletableJob;", "Landroidx/work/impl/utils/futures/SettableFuture;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "getFuture$work_runtime_release", "()Landroidx/work/impl/utils/futures/SettableFuture;", "Lm3/s;", "coroutineContext", "Lm3/s;", "getCoroutineContext", "()Lm3/s;", "getCoroutineContext$annotations", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CoroutineWorker extends ListenableWorker {
    private final AbstractC0684s coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final CompletableJob job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
        final /* synthetic */ JobListenableFuture<ForegroundInfo> $jobFuture;
        Object L$0;
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(JobListenableFuture<ForegroundInfo> jobListenableFuture, CoroutineWorker coroutineWorker, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$jobFuture = jobListenableFuture;
            this.this$0 = coroutineWorker;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$jobFuture, this.this$0, continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            JobListenableFuture jobListenableFuture;
            a aVar = a.f1304a;
            int i = this.label;
            if (i == 0) {
                l.e0(obj);
                JobListenableFuture<ForegroundInfo> jobListenableFuture2 = this.$jobFuture;
                CoroutineWorker coroutineWorker = this.this$0;
                this.L$0 = jobListenableFuture2;
                this.label = 1;
                Object foregroundInfo = coroutineWorker.getForegroundInfo(this);
                if (foregroundInfo == aVar) {
                    return aVar;
                }
                jobListenableFuture = jobListenableFuture2;
                obj = foregroundInfo;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jobListenableFuture = (JobListenableFuture) this.L$0;
                l.e0(obj);
            }
            jobListenableFuture.complete(obj);
            return m.f1129a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02261 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
        int label;

        public C02261(Continuation<? super C02261> continuation) {
            super(2, continuation);
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            return CoroutineWorker.this.new C02261(continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            try {
                if (i == 0) {
                    l.e0(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.label = 1;
                    obj = coroutineWorker.doWork(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                }
                CoroutineWorker.this.getFuture$work_runtime_release().set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.getFuture$work_runtime_release().setException(th);
            }
            return m.f1129a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
            return ((C02261) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        h.f(appContext, "appContext");
        h.f(params, "params");
        this.job = AbstractC0690y.a();
        SettableFuture<ListenableWorker.Result> settableFutureCreate = SettableFuture.create();
        h.e(settableFutureCreate, "create()");
        this.future = settableFutureCreate;
        settableFutureCreate.addListener(new androidx.constraintlayout.helper.widget.a(this, 4), getTaskExecutor().getSerialTaskExecutor());
        this.coroutineContext = G.f4104a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CoroutineWorker this$0) {
        h.f(this$0, "this$0");
        if (this$0.future.isCancelled()) {
            this$0.job.cancel((CancellationException) null);
        }
    }

    @Deprecated(message = "use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, Continuation<? super ForegroundInfo> continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(Continuation<? super ListenableWorker.Result> continuation);

    public AbstractC0684s getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(Continuation<? super ForegroundInfo> continuation) {
        return getForegroundInfo$suspendImpl(this, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        d0 d0VarA = AbstractC0690y.a();
        C0804e c0804eA = AbstractC0689x.a(getCoroutineContext().plus(d0VarA));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(d0VarA, null, 2, 0 == true ? 1 : 0);
        AbstractC0690y.g(c0804eA, null, new AnonymousClass1(jobListenableFuture, this, null), 3);
        return jobListenableFuture;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_release() {
        return this.future;
    }

    /* JADX INFO: renamed from: getJob$work_runtime_release, reason: from getter */
    public final CompletableJob getJob() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, Continuation<? super m> continuation) throws Throwable {
        ListenableFuture<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        h.e(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                foregroundAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        } else {
            C0672f c0672f = new C0672f(1, f.J(continuation));
            c0672f.initCancellability();
            foregroundAsync.addListener(new ListenableFutureKt$await$2$1(c0672f, foregroundAsync), DirectExecutor.INSTANCE);
            c0672f.invokeOnCancellation(new ListenableFutureKt$await$2$2(foregroundAsync));
            Object objM = c0672f.m();
            if (objM == a.f1304a) {
                return objM;
            }
        }
        return m.f1129a;
    }

    public final Object setProgress(Data data, Continuation<? super m> continuation) throws Throwable {
        ListenableFuture<Void> progressAsync = setProgressAsync(data);
        h.e(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        } else {
            C0672f c0672f = new C0672f(1, f.J(continuation));
            c0672f.initCancellability();
            progressAsync.addListener(new ListenableFutureKt$await$2$1(c0672f, progressAsync), DirectExecutor.INSTANCE);
            c0672f.invokeOnCancellation(new ListenableFutureKt$await$2$2(progressAsync));
            Object objM = c0672f.m();
            if (objM == a.f1304a) {
                return objM;
            }
        }
        return m.f1129a;
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        AbstractC0690y.g(AbstractC0689x.a(getCoroutineContext().plus(this.job)), null, new C02261(null), 3);
        return this.future;
    }
}
