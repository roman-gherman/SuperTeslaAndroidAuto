package j3;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3669a;
    public final int b;
    public final /* synthetic */ j c;

    public i(j jVar) {
        this.c = jVar;
        this.b = ((AbstractList) jVar).modCount;
    }

    public final void a() {
        j jVar = this.c;
        int i = ((AbstractList) jVar).modCount;
        int i3 = this.b;
        if (i == i3) {
            return;
        }
        throw new ConcurrentModificationException("ModCount: " + ((AbstractList) jVar).modCount + "; expected: " + i3);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f3669a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3669a) {
            throw new NoSuchElementException();
        }
        this.f3669a = true;
        a();
        return this.c.b;
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        this.c.clear();
    }
}
