package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public interface RunnableScheduler {
    void cancel(Runnable runnable);

    void scheduleWithDelay(long j6, Runnable runnable);
}
