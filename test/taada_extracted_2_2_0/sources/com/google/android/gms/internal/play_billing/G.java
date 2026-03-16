package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class G extends F implements NavigableSet, zzdu {
    public final transient Comparator c;
    public transient G d;

    public G(Comparator comparator) {
        this.c = comparator;
    }

    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet, com.google.android.gms.internal.play_billing.zzdu
    public final Comparator comparator() {
        return this.c;
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        G w5 = this.d;
        if (w5 == null) {
            W w6 = (W) this;
            Comparator comparatorReverseOrder = Collections.reverseOrder(w6.c);
            if (!w6.isEmpty()) {
                w5 = new W(w6.e.g(), comparatorReverseOrder);
            } else if (K.b.equals(comparatorReverseOrder)) {
                w5 = W.f2061f;
            } else {
                C0329x c0329x = A.b;
                w5 = new W(O.e, comparatorReverseOrder);
            }
            this.d = w5;
            w5.d = this;
        }
        return w5;
    }

    @Override // java.util.SortedSet
    public abstract Object first();

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        obj.getClass();
        W w5 = (W) this;
        return w5.l(0, w5.j(obj, false));
    }

    @Override // java.util.SortedSet
    public abstract Object last();

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z6, Object obj2, boolean z7) {
        obj.getClass();
        obj2.getClass();
        if (this.c.compare(obj, obj2) > 0) {
            throw new IllegalArgumentException();
        }
        W w5 = (W) this;
        W wL = w5.l(w5.k(obj, z6), w5.e.size());
        return wL.l(0, wL.j(obj2, z7));
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        obj.getClass();
        W w5 = (W) this;
        return w5.l(w5.k(obj, true), w5.e.size());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z6) {
        obj.getClass();
        W w5 = (W) this;
        return w5.l(0, w5.j(obj, z6));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z6) {
        obj.getClass();
        W w5 = (W) this;
        return w5.l(w5.k(obj, z6), w5.e.size());
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        if (this.c.compare(obj, obj2) <= 0) {
            W w5 = (W) this;
            W wL = w5.l(w5.k(obj, true), w5.e.size());
            return wL.l(0, wL.j(obj2, false));
        }
        throw new IllegalArgumentException();
    }
}
