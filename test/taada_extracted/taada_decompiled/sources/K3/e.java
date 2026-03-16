package k3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Iterator, KMappedMarker {
    public final Iterator b;
    public Object d;
    public final /* synthetic */ Sequence e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3782a = 0;
    public int c = -1;

    public e(f fVar) {
        this.e = fVar;
        this.b = fVar.f3783a.iterator();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    public void a() {
        Object next;
        f fVar;
        do {
            Iterator it = this.b;
            if (!it.hasNext()) {
                this.c = 0;
                return;
            } else {
                next = it.next();
                fVar = (f) this.e;
            }
        } while (((Boolean) fVar.c.invoke(next)).booleanValue() != fVar.b);
        this.d = next;
        this.c = 1;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    public void b() {
        Iterator it = this.b;
        if (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) ((j) this.e).b.invoke(next)).booleanValue()) {
                this.c = 1;
                this.d = next;
                return;
            }
        }
        this.c = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3782a) {
            case 0:
                if (this.c == -1) {
                    a();
                }
                if (this.c == 1) {
                }
                break;
            default:
                if (this.c == -1) {
                    b();
                }
                if (this.c == 1) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3782a) {
            case 0:
                if (this.c == -1) {
                    a();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.d;
                this.d = null;
                this.c = -1;
                return obj;
            default:
                if (this.c == -1) {
                    b();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj2 = this.d;
                this.d = null;
                this.c = -1;
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3782a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(j jVar) {
        this.e = jVar;
        this.b = ((Sequence) jVar.c).iterator();
    }
}
