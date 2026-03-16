package m3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: renamed from: m3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0677k {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(C0677k.class, "_handled");

    @Volatile
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f4134a;

    public C0677k(Throwable th, boolean z6) {
        this.f4134a = th;
        this._handled = z6 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH + this.f4134a + ']';
    }
}
