package j1;

import A2.C0022d;
import a.AbstractC0132a;
import io.ktor.client.engine.HttpClientEngine;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.collections.w;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import m3.AbstractC0684s;
import m3.G;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements HttpClientEngine {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(e.class, "closed");

    @NotNull
    private volatile /* synthetic */ int closed = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t3.c f3651a = G.c;
    public final N1.j b = AbstractC0132a.M(new C0022d(this, 21));

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (c.compareAndSet(this, 0, 1)) {
            CoroutineContext.Element element = getCoroutineContext().get(Job.Key);
            CompletableJob completableJob = element instanceof CompletableJob ? (CompletableJob) element : null;
            if (completableJob == null) {
                return;
            }
            completableJob.complete();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.b.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public final AbstractC0684s getDispatcher() {
        return this.f3651a;
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public Set getSupportedCapabilities() {
        return w.f3807a;
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public final void install(g1.f client) {
        kotlin.jvm.internal.h.f(client, "client");
        client.f3296g.f(q1.e.f4525o, new d(client, this, null));
    }
}
