package P1;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ListIterator, KMutableListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1199a;
    public int b;
    public int c = -1;

    public a(b bVar, int i) {
        this.f1199a = bVar;
        this.b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i = this.b;
        this.b = i + 1;
        this.f1199a.add(i, obj);
        this.c = -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f1199a.c;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i = this.b;
        b bVar = this.f1199a;
        if (i >= bVar.c) {
            throw new NoSuchElementException();
        }
        this.b = i + 1;
        this.c = i;
        return bVar.f1200a[bVar.b + i];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        int i = this.b;
        if (i <= 0) {
            throw new NoSuchElementException();
        }
        int i3 = i - 1;
        this.b = i3;
        this.c = i3;
        b bVar = this.f1199a;
        return bVar.f1200a[bVar.b + i3];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }
        this.f1199a.b(i);
        this.b = this.c;
        this.c = -1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
        this.f1199a.set(i, obj);
    }
}
