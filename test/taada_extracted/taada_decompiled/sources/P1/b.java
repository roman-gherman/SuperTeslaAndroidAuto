package P1;

import a.AbstractC0132a;
import io.ktor.utils.io.jvm.javaio.q;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.collections.f implements List, RandomAccess, Serializable, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f1200a;
    public final int b;
    public int c;
    public boolean d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f1201f;

    public b(Object[] objArr, int i, int i3, boolean z6, b bVar, b bVar2) {
        this.f1200a = objArr;
        this.b = i;
        this.c = i3;
        this.d = z6;
        this.e = bVar;
        this.f1201f = bVar2;
    }

    private final Object writeReplace() throws NotSerializableException {
        b bVar;
        if (this.d || ((bVar = this.f1201f) != null && bVar.d)) {
            return new h(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.f
    public final int a() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        e();
        d(this.b + this.c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        e();
        int size = elements.size();
        c(this.b + this.c, elements, size);
        return size > 0;
    }

    @Override // kotlin.collections.f
    public final Object b(int i) {
        e();
        int i3 = this.c;
        if (i < 0 || i >= i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
        }
        return g(this.b + i);
    }

    public final void c(int i, Collection collection, int i3) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.c(i, collection, i3);
            this.f1200a = bVar.f1200a;
            this.c += i3;
        } else {
            f(i, i3);
            Iterator it = collection.iterator();
            for (int i4 = 0; i4 < i3; i4++) {
                this.f1200a[i + i4] = it.next();
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        h(this.b, this.c);
    }

    public final void d(int i, Object obj) {
        b bVar = this.e;
        if (bVar == null) {
            f(i, 1);
            this.f1200a[i] = obj;
        } else {
            bVar.d(i, obj);
            this.f1200a = bVar.f1200a;
            this.c++;
        }
    }

    public final void e() {
        b bVar;
        if (this.d || ((bVar = this.f1201f) != null && bVar.d)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f1200a;
            int i = this.c;
            if (i == list.size()) {
                for (int i3 = 0; i3 < i; i3++) {
                    if (kotlin.jvm.internal.h.a(objArr[this.b + i3], list.get(i3))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i, int i3) {
        int i4 = this.c + i3;
        if (this.e != null) {
            throw new IllegalStateException();
        }
        if (i4 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f1200a;
        if (i4 > objArr.length) {
            int length = objArr.length;
            int i5 = length + (length >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            if (i5 - 2147483639 > 0) {
                i5 = i4 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i5);
            kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f1200a = objArrCopyOf;
        }
        Object[] objArr2 = this.f1200a;
        kotlin.collections.j.w(i + i3, i, objArr2, this.b + this.c, objArr2);
        this.c += i3;
    }

    public final Object g(int i) {
        b bVar = this.e;
        if (bVar != null) {
            this.c--;
            return bVar.g(i);
        }
        Object[] objArr = this.f1200a;
        Object obj = objArr[i];
        int i3 = this.c;
        int i4 = this.b;
        kotlin.collections.j.w(i, i + 1, objArr, i3 + i4, objArr);
        Object[] objArr2 = this.f1200a;
        int i5 = (i4 + this.c) - 1;
        kotlin.jvm.internal.h.f(objArr2, "<this>");
        objArr2[i5] = null;
        this.c--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i3 = this.c;
        if (i < 0 || i >= i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
        }
        return this.f1200a[this.b + i];
    }

    public final void h(int i, int i3) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.h(i, i3);
        } else {
            Object[] objArr = this.f1200a;
            kotlin.collections.j.w(i, i + i3, objArr, this.c, objArr);
            Object[] objArr2 = this.f1200a;
            int i4 = this.c;
            AbstractC0132a.c0(objArr2, i4 - i3, i4);
        }
        this.c -= i3;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f1200a;
        int i = this.c;
        int iHashCode = 1;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[this.b + i3];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final int i(int i, int i3, Collection collection, boolean z6) {
        b bVar = this.e;
        if (bVar != null) {
            int i4 = bVar.i(i, i3, collection, z6);
            this.c -= i4;
            return i4;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            int i7 = i + i5;
            if (collection.contains(this.f1200a[i7]) == z6) {
                Object[] objArr = this.f1200a;
                i5++;
                objArr[i6 + i] = objArr[i7];
                i6++;
            } else {
                i5++;
            }
        }
        int i8 = i3 - i6;
        Object[] objArr2 = this.f1200a;
        kotlin.collections.j.w(i + i6, i3 + i, objArr2, this.c, objArr2);
        Object[] objArr3 = this.f1200a;
        int i9 = this.c;
        AbstractC0132a.c0(objArr3, i9 - i8, i9);
        this.c -= i8;
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.c; i++) {
            if (kotlin.jvm.internal.h.a(this.f1200a[this.b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.c - 1; i >= 0; i--) {
            if (kotlin.jvm.internal.h.a(this.f1200a[this.b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        e();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        e();
        return i(this.b, this.c, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        e();
        return i(this.b, this.c, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        e();
        int i3 = this.c;
        if (i < 0 || i >= i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
        }
        Object[] objArr = this.f1200a;
        int i4 = this.b;
        Object obj2 = objArr[i4 + i];
        objArr[i4 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i3) {
        q.d(i, i3, this.c);
        Object[] objArr = this.f1200a;
        int i4 = this.b + i;
        int i5 = i3 - i;
        boolean z6 = this.d;
        b bVar = this.f1201f;
        return new b(objArr, i4, i5, z6, this, bVar == null ? this : bVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] destination) {
        kotlin.jvm.internal.h.f(destination, "destination");
        int length = destination.length;
        int i = this.c;
        int i3 = this.b;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f1200a, i3, i + i3, destination.getClass());
            kotlin.jvm.internal.h.e(objArrCopyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return objArrCopyOfRange;
        }
        kotlin.collections.j.w(0, i3, this.f1200a, i + i3, destination);
        int length2 = destination.length;
        int i4 = this.c;
        if (length2 > i4) {
            destination[i4] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        Object[] objArr = this.f1200a;
        int i = this.c;
        StringBuilder sb = new StringBuilder((i * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(objArr[this.b + i3]);
        }
        sb.append("]");
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "sb.toString()");
        return string;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i3 = this.c;
        if (i < 0 || i > i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
        }
        return new a(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        e();
        int i3 = this.c;
        if (i >= 0 && i <= i3) {
            d(this.b + i, obj);
            return;
        }
        throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        e();
        int i3 = this.c;
        if (i >= 0 && i <= i3) {
            int size = elements.size();
            c(this.b + i, elements, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        Object[] objArr = this.f1200a;
        int i = this.c;
        int i3 = this.b;
        return kotlin.collections.j.x(objArr, i3, i + i3);
    }

    public b() {
        this(10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(int i) {
        this(new Object[i], 0, 0, false, null, null);
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }
}
