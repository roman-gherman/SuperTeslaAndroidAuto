package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class W extends G {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final W f2061f;
    public final transient A e;

    static {
        C0329x c0329x = A.b;
        f2061f = new W(O.e, K.b);
    }

    public W(A a6, Comparator comparator) {
        super(comparator);
        this.e = a6;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int a(Object[] objArr) {
        return this.e.a(objArr);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int b() {
        return this.e.b();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int c() {
        return this.e.c();
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        int iK = k(obj, true);
        A a6 = this.e;
        if (iK == a6.size()) {
            return null;
        }
        return a6.get(iK);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.e, obj, this.c) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzdb) {
            collection = ((zzdb) collection).zza();
        }
        Comparator comparator = this.c;
        if (!AbstractC0263a1.i(comparator, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        C0329x c0329xListIterator = this.e.listIterator(0);
        Iterator it = collection.iterator();
        if (c0329xListIterator.hasNext()) {
            Object next = it.next();
            Object next2 = c0329xListIterator.next();
            while (true) {
                try {
                    int iCompare = comparator.compare(next2, next);
                    if (iCompare >= 0) {
                        if (iCompare != 0) {
                            break;
                        }
                        if (!it.hasNext()) {
                            return true;
                        }
                        next = it.next();
                    } else {
                        if (!c0329xListIterator.hasNext()) {
                            break;
                        }
                        next2 = c0329xListIterator.next();
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.F, com.google.android.gms.internal.play_billing.AbstractC0323v
    public final A d() {
        return this.e;
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return this.e.g().listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.F, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            A a6 = this.e;
            if (a6.size() == set.size()) {
                if (isEmpty()) {
                    return true;
                }
                Comparator comparator = this.c;
                if (!AbstractC0263a1.i(comparator, set)) {
                    return containsAll(set);
                }
                Iterator it = set.iterator();
                try {
                    C0329x c0329xListIterator = a6.listIterator(0);
                    while (c0329xListIterator.hasNext()) {
                        Object next = c0329xListIterator.next();
                        Object next2 = it.next();
                        if (next2 == null || comparator.compare(next, next2) != 0) {
                        }
                    }
                    return true;
                } catch (ClassCastException | NoSuchElementException unused) {
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final Object[] f() {
        return this.e.f();
    }

    @Override // com.google.android.gms.internal.play_billing.G, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.e.get(0);
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        int iJ = j(obj, true) - 1;
        if (iJ == -1) {
            return null;
        }
        return this.e.get(iJ);
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        int iK = k(obj, false);
        A a6 = this.e;
        if (iK == a6.size()) {
            return null;
        }
        return a6.get(iK);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public final /* synthetic */ Iterator iterator() {
        return this.e.listIterator(0);
    }

    public final int j(Object obj, boolean z6) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.e, obj, this.c);
        return iBinarySearch >= 0 ? z6 ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    public final int k(Object obj, boolean z6) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.e, obj, this.c);
        return iBinarySearch >= 0 ? z6 ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }

    public final W l(int i, int i3) {
        A a6 = this.e;
        if (i == 0) {
            if (i3 == a6.size()) {
                return this;
            }
            i = 0;
        }
        Comparator comparator = this.c;
        if (i < i3) {
            return new W(a6.subList(i, i3), comparator);
        }
        if (K.b.equals(comparator)) {
            return f2061f;
        }
        C0329x c0329x = A.b;
        return new W(O.e, comparator);
    }

    @Override // com.google.android.gms.internal.play_billing.G, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.e.get(r0.size() - 1);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        int iJ = j(obj, false) - 1;
        if (iJ == -1) {
            return null;
        }
        return this.e.get(iJ);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e.size();
    }
}
