package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends AbstractList implements RandomAccess, LazyStringList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f3847a;

    public H(s sVar) {
        this.f3847a = sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public final void add(AbstractC0604e abstractC0604e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (String) this.f3847a.get(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public final AbstractC0604e getByteString(int i) {
        return this.f3847a.getByteString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f3847a.f3875a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public final LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        G g6 = new G();
        g6.f3846a = this.f3847a.iterator();
        return g6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        F f6 = new F();
        f6.f3845a = this.f3847a.listIterator(i);
        return f6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3847a.size();
    }
}
