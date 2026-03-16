package k3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f3785a;
    public Iterator b;
    public final /* synthetic */ h c;

    public g(h hVar) {
        this.c = hVar;
        this.f3785a = hVar.f3786a.iterator();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    public final boolean a() {
        Iterator it = this.b;
        if (it != null && !it.hasNext()) {
            this.b = null;
        }
        while (true) {
            if (this.b != null) {
                break;
            }
            Iterator it2 = this.f3785a;
            if (!it2.hasNext()) {
                return false;
            }
            Object next = it2.next();
            h hVar = this.c;
            Iterator it3 = (Iterator) hVar.c.invoke(hVar.b.invoke(next));
            if (it3.hasNext()) {
                this.b = it3;
                break;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        Iterator it = this.b;
        kotlin.jvm.internal.h.c(it);
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
