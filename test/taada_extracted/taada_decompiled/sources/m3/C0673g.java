package m3;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;

/* JADX INFO: renamed from: m3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0673g extends C0677k {
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(C0673g.class, "_resumed");

    @Volatile
    private volatile int _resumed;

    public C0673g(C0672f c0672f, Throwable th, boolean z6) {
        if (th == null) {
            th = new CancellationException("Continuation " + c0672f + " was cancelled normally");
        }
        super(th, z6);
        this._resumed = 0;
    }
}
