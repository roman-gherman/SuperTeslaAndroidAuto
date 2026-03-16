package n3;

import A2.q;
import B.o;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import m3.G;
import m3.p0;
import m3.r0;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: n3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0729d extends AbstractC0730e {

    @Nullable
    private volatile C0729d _immediate;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f4264a;
    public final boolean b;
    public final C0729d c;

    public C0729d(Handler handler, boolean z6) {
        this.f4264a = handler;
        this.b = z6;
        this._immediate = z6 ? this : null;
        C0729d c0729d = this._immediate;
        if (c0729d == null) {
            c0729d = new C0729d(handler, true);
            this._immediate = c0729d;
        }
        this.c = c0729d;
    }

    public final void a(CoroutineContext coroutineContext, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
        G.c.dispatch(coroutineContext, runnable);
    }

    @Override // m3.AbstractC0684s
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.f4264a.post(runnable)) {
            return;
        }
        a(coroutineContext, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0729d) && ((C0729d) obj).f4264a == this.f4264a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f4264a);
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j6, final Runnable runnable, CoroutineContext coroutineContext) {
        if (j6 > 4611686018427387903L) {
            j6 = 4611686018427387903L;
        }
        if (this.f4264a.postDelayed(runnable, j6)) {
            return new DisposableHandle() { // from class: n3.c
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    this.f4263a.f4264a.removeCallbacks(runnable);
                }
            };
        }
        a(coroutineContext, runnable);
        return r0.f4143a;
    }

    @Override // m3.AbstractC0684s
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.b && h.a(Looper.myLooper(), this.f4264a.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j6, CancellableContinuation cancellableContinuation) {
        o oVar = new o(cancellableContinuation, this, 3, false);
        if (j6 > 4611686018427387903L) {
            j6 = 4611686018427387903L;
        }
        if (this.f4264a.postDelayed(oVar, j6)) {
            cancellableContinuation.invokeOnCancellation(new q(10, this, oVar));
        } else {
            a(cancellableContinuation.getContext(), oVar);
        }
    }

    @Override // m3.AbstractC0684s
    public final String toString() {
        C0729d c0729d;
        String str;
        t3.d dVar = G.f4104a;
        p0 p0Var = r3.o.f4718a;
        if (this == p0Var) {
            str = "Dispatchers.Main";
        } else {
            try {
                c0729d = ((C0729d) p0Var).c;
            } catch (UnsupportedOperationException unused) {
                c0729d = null;
            }
            str = this == c0729d ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f4264a.toString();
        return this.b ? B2.b.e(string, ".immediate") : string;
    }
}
