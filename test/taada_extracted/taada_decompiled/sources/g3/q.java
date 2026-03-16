package g3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3318a = true;
    public final /* synthetic */ r b;

    public q(r rVar) {
        this.b = rVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3318a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f3318a) {
            throw new NoSuchElementException();
        }
        this.f3318a = false;
        return this.b.f3319a;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
