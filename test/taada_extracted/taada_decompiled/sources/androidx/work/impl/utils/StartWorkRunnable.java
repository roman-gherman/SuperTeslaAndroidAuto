package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/work/impl/utils/StartWorkRunnable;", "Ljava/lang/Runnable;", "Landroidx/work/impl/Processor;", "processor", "Landroidx/work/impl/StartStopToken;", "startStopToken", "Landroidx/work/WorkerParameters$RuntimeExtras;", "runtimeExtras", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/work/impl/Processor;Landroidx/work/impl/StartStopToken;Landroidx/work/WorkerParameters$RuntimeExtras;)V", "LN1/m;", "run", "()V", "Landroidx/work/impl/Processor;", "Landroidx/work/impl/StartStopToken;", "Landroidx/work/WorkerParameters$RuntimeExtras;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StartWorkRunnable implements Runnable {
    private final Processor processor;
    private final WorkerParameters.RuntimeExtras runtimeExtras;
    private final StartStopToken startStopToken;

    public StartWorkRunnable(Processor processor, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        h.f(processor, "processor");
        h.f(startStopToken, "startStopToken");
        this.processor = processor;
        this.startStopToken = startStopToken;
        this.runtimeExtras = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        this.processor.startWork(this.startStopToken, this.runtimeExtras);
    }
}
