package Q;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes.dex */
public final class d implements ListIterator, Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1230a;
    public int b;
    public final f c;

    public d(f fVar, int i) {
        int size = fVar.size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(l.q0(i, size, "index"));
        }
        this.f1230a = size;
        this.b = i;
        this.c = fVar;
    }

    public final Object a(int i) {
        return this.c.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f1230a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
