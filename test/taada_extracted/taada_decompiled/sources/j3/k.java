package j3;

import java.util.Iterator;
import kotlin.collections.C0595b;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Iterator, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0595b f3670a;

    public k(Object[] array) {
        kotlin.jvm.internal.h.f(array, "array");
        this.f3670a = kotlin.jvm.internal.h.j(array);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3670a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f3670a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
