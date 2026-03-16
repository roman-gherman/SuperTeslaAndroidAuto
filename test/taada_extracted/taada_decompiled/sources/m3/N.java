package m3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class N implements Runnable, Comparable, DisposableHandle, ThreadSafeHeapNode {

    @Nullable
    private volatile Object _heap;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4109a;
    public int b = -1;

    public N(long j6) {
        this.f4109a = j6;
    }

    public final int a(long j6, O o6, P p5) {
        synchronized (this) {
            if (this._heap == AbstractC0690y.b) {
                return 2;
            }
            synchronized (o6) {
                try {
                    ThreadSafeHeapNode[] threadSafeHeapNodeArr = o6.f4698a;
                    N n6 = (N) (threadSafeHeapNodeArr != null ? threadSafeHeapNodeArr[0] : null);
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = P.e;
                    p5.getClass();
                    if (P.f4111g.get(p5) != 0) {
                        return 1;
                    }
                    if (n6 == null) {
                        o6.c = j6;
                    } else {
                        long j7 = n6.f4109a;
                        if (j7 - j6 < 0) {
                            j6 = j7;
                        }
                        if (j6 - o6.c > 0) {
                            o6.c = j6;
                        }
                    }
                    long j8 = this.f4109a;
                    long j9 = o6.c;
                    if (j8 - j9 < 0) {
                        this.f4109a = j9;
                    }
                    o6.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j6 = this.f4109a - ((N) obj).f4109a;
        if (j6 > 0) {
            return 1;
        }
        return j6 < 0 ? -1 : 0;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                E1.h hVar = AbstractC0690y.b;
                if (obj == hVar) {
                    return;
                }
                O o6 = obj instanceof O ? (O) obj : null;
                if (o6 != null) {
                    synchronized (o6) {
                        if (getHeap() != null) {
                            o6.b(getIndex());
                        }
                    }
                }
                this._heap = hVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public final r3.D getHeap() {
        Object obj = this._heap;
        if (obj instanceof r3.D) {
            return (r3.D) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public final int getIndex() {
        return this.b;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public final void setHeap(r3.D d) {
        if (this._heap == AbstractC0690y.b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = d;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public final void setIndex(int i) {
        this.b = i;
    }

    public String toString() {
        return "Delayed[nanos=" + this.f4109a + ']';
    }
}
