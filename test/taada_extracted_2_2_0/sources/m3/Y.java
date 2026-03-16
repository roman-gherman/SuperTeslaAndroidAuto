package m3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class Y extends c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f4118f = AtomicIntegerFieldUpdater.newUpdater(Y.class, "_invoked");

    @Volatile
    private volatile int _invoked;
    public final Function1 e;

    public Y(Function1 function1) {
        this.e = function1;
    }

    @Override // m3.e0
    public final void g(Throwable th) {
        if (f4118f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return N1.m.f1129a;
    }
}
