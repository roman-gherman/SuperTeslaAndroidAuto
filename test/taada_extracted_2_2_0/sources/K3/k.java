package k3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends l implements Iterator, Continuation, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3789a;
    public Object b;
    public Iterator c;
    public Continuation d;

    @Override // k3.l
    public final void a(Object obj, U1.f fVar) {
        this.b = obj;
        this.f3789a = 3;
        this.d = fVar;
    }

    public final RuntimeException c() {
        int i = this.f3789a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f3789a);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return S1.g.f1282a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f3789a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator it = this.c;
                kotlin.jvm.internal.h.c(it);
                if (it.hasNext()) {
                    this.f3789a = 2;
                    return true;
                }
                this.c = null;
            }
            this.f3789a = 5;
            Continuation continuation = this.d;
            kotlin.jvm.internal.h.c(continuation);
            this.d = null;
            continuation.resumeWith(N1.m.f1129a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f3789a;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.f3789a = 1;
            Iterator it = this.c;
            kotlin.jvm.internal.h.c(it);
            return it.next();
        }
        if (i != 3) {
            throw c();
        }
        this.f3789a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        kotlin.reflect.l.e0(obj);
        this.f3789a = 4;
    }
}
