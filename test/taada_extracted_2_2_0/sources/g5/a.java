package g5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f3343a;
    public int b = 0;

    public a(Object[] objArr) {
        this.f3343a = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f3343a.length;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        Object[] objArr = this.f3343a;
        if (i != objArr.length) {
            this.b = i + 1;
            return objArr[i];
        }
        throw new NoSuchElementException("Out of elements: " + this.b);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove element from an Array.");
    }
}
