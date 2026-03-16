package z1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.o;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Set, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f5177a;
    public final kotlin.jvm.internal.i b;
    public final kotlin.jvm.internal.i c;
    public final int d;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Set delegate, Function1 convertTo, Function1 convert) {
        kotlin.jvm.internal.h.f(delegate, "delegate");
        kotlin.jvm.internal.h.f(convertTo, "convertTo");
        kotlin.jvm.internal.h.f(convert, "convert");
        this.f5177a = delegate;
        this.b = (kotlin.jvm.internal.i) convertTo;
        this.c = (kotlin.jvm.internal.i) convert;
        this.d = delegate.size();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    public final ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(o.D(collection));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.c.invoke(it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        return this.f5177a.add(this.c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return this.f5177a.addAll(a(elements));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    public final ArrayList b(Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(o.D(collection));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.b.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f5177a.clear();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5177a.contains(this.c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return this.f5177a.containsAll(a(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        ArrayList arrayListB = b(this.f5177a);
        return ((Set) obj).containsAll(arrayListB) && arrayListB.containsAll((Collection) obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        return this.f5177a.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f5177a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new h(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f5177a.remove(this.c.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return this.f5177a.removeAll(a(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return this.f5177a.retainAll(a(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.d;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.g.a(this);
    }

    public final String toString() {
        return b(this.f5177a).toString();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.h.f(array, "array");
        return kotlin.jvm.internal.g.b(this, array);
    }
}
