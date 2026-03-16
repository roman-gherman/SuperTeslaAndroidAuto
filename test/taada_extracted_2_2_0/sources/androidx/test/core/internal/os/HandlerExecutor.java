package androidx.test.core.internal.os;

import android.os.Handler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/test/core/internal/os/HandlerExecutor;", "Ljava/util/concurrent/Executor;", "Landroid/os/Handler;", "handler", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/os/Handler;)V", "Ljava/lang/Runnable;", "command", "LN1/m;", "execute", "(Ljava/lang/Runnable;)V", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "androidx.test.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HandlerExecutor implements Executor {
    private final Handler handler;

    public HandlerExecutor(Handler handler) {
        h.f(handler, "handler");
        this.handler = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        h.f(command, "command");
        if (Thread.currentThread().equals(this.handler.getLooper().getThread())) {
            command.run();
        } else {
            this.handler.post(command);
        }
    }

    public final Handler getHandler() {
        return this.handler;
    }
}
