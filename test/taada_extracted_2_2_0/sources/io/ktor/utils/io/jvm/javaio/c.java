package io.ktor.utils.io.jvm.javaio;

import A2.C0019a;
import C0.x;
import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import m3.K;
import m3.u0;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3597f = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "state");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f3598a;
    public final b b;
    public final DisposableHandle c;
    public int d;
    public int e;

    @NotNull
    volatile /* synthetic */ int result;

    @NotNull
    volatile /* synthetic */ Object state;

    public c(Job job) {
        this.f3598a = job;
        b bVar = new b(this);
        this.b = bVar;
        this.state = this;
        this.result = 0;
        this.c = job != null ? job.invokeOnCompletion(new C0019a(this, 18)) : null;
        a aVar = new a(this, null);
        z.d(1, aVar);
        aVar.invoke(bVar);
        if (this.state == this) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public static final void a(c cVar, U1.c cVar2) {
        Object obj;
        Continuation continuationJ;
        Object obj2 = null;
        while (true) {
            Object obj3 = cVar.state;
            if (obj3 instanceof Thread) {
                continuationJ = C5.f.J(cVar2);
                obj = obj3;
            } else {
                if (!kotlin.jvm.internal.h.a(obj3, cVar)) {
                    throw new IllegalStateException("Already suspended or in finished state");
                }
                obj = obj2;
                continuationJ = C5.f.J(cVar2);
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3597f;
            while (!atomicReferenceFieldUpdater.compareAndSet(cVar, obj3, continuationJ)) {
                if (atomicReferenceFieldUpdater.get(cVar) != obj3) {
                    break;
                }
            }
            if (obj != null) {
                Parking parking = (Parking) l.f3608a.get();
                if (parking == null) {
                    parking = f.b;
                }
                parking.unpark(obj);
                return;
            }
            return;
            obj2 = obj;
        }
    }

    public abstract Object b(U1.c cVar);

    public final int c(Object jobToken) throws Throwable {
        Object xVar;
        kotlin.jvm.internal.h.f(jobToken, "jobToken");
        Thread thread = Thread.currentThread();
        Continuation continuation = null;
        while (true) {
            Object obj = this.state;
            if (obj instanceof Continuation) {
                kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any>");
                continuation = (Continuation) obj;
                xVar = thread;
            } else {
                if (obj instanceof N1.m) {
                    return this.result;
                }
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                if (obj instanceof Thread) {
                    throw new IllegalStateException("There is already thread owning adapter");
                }
                if (kotlin.jvm.internal.h.a(obj, this)) {
                    throw new IllegalStateException("Not yet started");
                }
                xVar = new x();
            }
            kotlin.jvm.internal.h.e(xVar, "when (value) {\n         …Exception()\n            }");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3597f;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, xVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            kotlin.jvm.internal.h.c(continuation);
            continuation.resumeWith(jobToken);
            kotlin.jvm.internal.h.e(thread, "thread");
            if (this.state == thread) {
                Parking parking = (Parking) l.f3608a.get();
                f fVar = f.b;
                if (parking == null) {
                    parking = fVar;
                }
                if (parking == f.c) {
                    ((Logger) e.f3600a.getValue()).warn("Blocking network thread detected. \nIt can possible lead to a performance decline or even a deadlock.\nPlease make sure you're using blocking IO primitives like InputStream and OutputStream only in \nthe context of Dispatchers.IO:\n```\nwithContext(Dispatchers.IO) {\n    myInputStream.read()\n}\n```");
                }
                while (true) {
                    K k6 = (K) u0.f4146a.get();
                    long jD = k6 != null ? k6.d() : LocationRequestCompat.PASSIVE_INTERVAL;
                    if (this.state != thread) {
                        break;
                    }
                    if (jD > 0) {
                        Parking parking2 = (Parking) l.f3608a.get();
                        if (parking2 == null) {
                            parking2 = fVar;
                        }
                        parking2.park(jD);
                    }
                }
            }
            Object obj2 = this.state;
            if (obj2 instanceof Throwable) {
                throw ((Throwable) obj2);
            }
            return this.result;
        }
    }

    public final int d(byte[] bArr, int i, int i3) {
        this.d = i;
        this.e = i3;
        return c(bArr);
    }
}
