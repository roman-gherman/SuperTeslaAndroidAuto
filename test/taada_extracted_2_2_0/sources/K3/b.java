package k3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.x;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3780a = 2;
    public int b;
    public final Iterator c;

    public b(Iterator iterator) {
        kotlin.jvm.internal.h.f(iterator, "iterator");
        this.c = iterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f3780a) {
            case 0:
                break;
            case 1:
                return this.b > 0 && this.c.hasNext();
            default:
                return this.c.hasNext();
        }
        while (true) {
            int i = this.b;
            it = this.c;
            if (i > 0 && it.hasNext()) {
                it.next();
                this.b--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f3780a) {
            case 0:
                break;
            case 1:
                int i = this.b;
                if (i == 0) {
                    throw new NoSuchElementException();
                }
                this.b = i - 1;
                return this.c.next();
            default:
                int i3 = this.b;
                this.b = i3 + 1;
                if (i3 >= 0) {
                    return new x(i3, this.c.next());
                }
                kotlin.collections.n.C();
                throw null;
        }
        while (true) {
            int i4 = this.b;
            it = this.c;
            if (i4 > 0 && it.hasNext()) {
                it.next();
                this.b--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3780a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(c cVar, byte b) {
        this.b = cVar.b;
        this.c = new b((c) cVar.c);
    }

    public b(c cVar) {
        this.c = cVar.c.iterator();
        this.b = cVar.b;
    }
}
