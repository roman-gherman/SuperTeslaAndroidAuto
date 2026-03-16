package k3;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f3794a;
    public final /* synthetic */ u b;

    public t(u uVar) {
        this.b = uVar;
        this.f3794a = uVar.f3795a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3794a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.b.b.invoke(this.f3794a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
