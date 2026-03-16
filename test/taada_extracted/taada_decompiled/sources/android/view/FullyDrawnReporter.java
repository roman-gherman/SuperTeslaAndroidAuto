package android.view;

import N1.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\nJ\u001b\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/activity/FullyDrawnReporter;", "", "Ljava/util/concurrent/Executor;", "executor", "Lkotlin/Function0;", "LN1/m;", "reportFullyDrawn", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;)V", "postWhenReportersAreDone", "()V", "addReporter", "removeReporter", "callback", "addOnReportDrawnListener", "(Lkotlin/jvm/functions/Function0;)V", "removeOnReportDrawnListener", "fullyDrawnReported", "Ljava/util/concurrent/Executor;", "Lkotlin/jvm/functions/Function0;", "lock", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, "", "reporterCount", "I", "", "reportPosted", "Z", "reportedFullyDrawn", "", "onReportCallbacks", "Ljava/util/List;", "Ljava/lang/Runnable;", "reportRunnable", "Ljava/lang/Runnable;", "isFullyDrawnReported", "()Z", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock;
    private final List<Function0<m>> onReportCallbacks;
    private final Function0<m> reportFullyDrawn;
    private boolean reportPosted;
    private final Runnable reportRunnable;
    private boolean reportedFullyDrawn;
    private int reporterCount;

    public FullyDrawnReporter(Executor executor, Function0<m> reportFullyDrawn) {
        h.f(executor, "executor");
        h.f(reportFullyDrawn, "reportFullyDrawn");
        this.executor = executor;
        this.reportFullyDrawn = reportFullyDrawn;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
        this.reportRunnable = new d(this, 3);
    }

    private final void postWhenReportersAreDone() {
        if (this.reportPosted || this.reporterCount != 0) {
            return;
        }
        this.reportPosted = true;
        this.executor.execute(this.reportRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter this$0) {
        h.f(this$0, "this$0");
        synchronized (this$0.lock) {
            this$0.reportPosted = false;
            if (this$0.reporterCount == 0 && !this$0.reportedFullyDrawn) {
                this$0.reportFullyDrawn.invoke();
                this$0.fullyDrawnReported();
            }
        }
    }

    public final void addOnReportDrawnListener(Function0<m> callback) {
        boolean z6;
        h.f(callback, "callback");
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                z6 = true;
            } else {
                this.onReportCallbacks.add(callback);
                z6 = false;
            }
        }
        if (z6) {
            callback.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn) {
                this.reporterCount++;
            }
        }
    }

    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            try {
                this.reportedFullyDrawn = true;
                Iterator<T> it = this.onReportCallbacks.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.onReportCallbacks.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z6;
        synchronized (this.lock) {
            z6 = this.reportedFullyDrawn;
        }
        return z6;
    }

    public final void removeOnReportDrawnListener(Function0<m> callback) {
        h.f(callback, "callback");
        synchronized (this.lock) {
            this.onReportCallbacks.remove(callback);
        }
    }

    public final void removeReporter() {
        int i;
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn && (i = this.reporterCount) > 0) {
                this.reporterCount = i - 1;
                postWhenReportersAreDone();
            }
        }
    }
}
