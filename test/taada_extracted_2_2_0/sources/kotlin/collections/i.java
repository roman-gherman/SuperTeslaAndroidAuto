package kotlin.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends f {
    public static final Object[] d = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3802a;
    public Object[] b;
    public int c;

    public i() {
        this.b = d;
    }

    @Override // kotlin.collections.f
    public final int a() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i3 = this.c;
        if (i < 0 || i > i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
        }
        if (i == i3) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        d(i3 + 1);
        int iH = h(this.f3802a + i);
        int i4 = this.c;
        if (i < ((i4 + 1) >> 1)) {
            if (iH == 0) {
                Object[] objArr = this.b;
                kotlin.jvm.internal.h.f(objArr, "<this>");
                iH = objArr.length;
            }
            int i5 = iH - 1;
            int i6 = this.f3802a;
            if (i6 == 0) {
                Object[] objArr2 = this.b;
                kotlin.jvm.internal.h.f(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i6 - 1;
            }
            int i7 = this.f3802a;
            if (i5 >= i7) {
                Object[] objArr3 = this.b;
                objArr3[length] = objArr3[i7];
                j.w(i7, i7 + 1, objArr3, i5 + 1, objArr3);
            } else {
                Object[] objArr4 = this.b;
                j.w(i7 - 1, i7, objArr4, objArr4.length, objArr4);
                Object[] objArr5 = this.b;
                objArr5[objArr5.length - 1] = objArr5[0];
                j.w(0, 1, objArr5, i5 + 1, objArr5);
            }
            this.b[i5] = obj;
            this.f3802a = length;
        } else {
            int iH2 = h(i4 + this.f3802a);
            if (iH < iH2) {
                Object[] objArr6 = this.b;
                j.w(iH + 1, iH, objArr6, iH2, objArr6);
            } else {
                Object[] objArr7 = this.b;
                j.w(1, 0, objArr7, iH2, objArr7);
                Object[] objArr8 = this.b;
                objArr8[0] = objArr8[objArr8.length - 1];
                j.w(iH + 1, iH, objArr8, objArr8.length - 1, objArr8);
            }
            this.b[iH] = obj;
        }
        this.c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        int i3 = this.c;
        if (i < 0 || i > i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
        }
        if (elements.isEmpty()) {
            return false;
        }
        int i4 = this.c;
        if (i == i4) {
            return addAll(elements);
        }
        d(elements.size() + i4);
        int iH = h(this.c + this.f3802a);
        int iH2 = h(this.f3802a + i);
        int size = elements.size();
        if (i >= ((this.c + 1) >> 1)) {
            int i5 = iH2 + size;
            if (iH2 < iH) {
                int i6 = size + iH;
                Object[] objArr = this.b;
                if (i6 <= objArr.length) {
                    j.w(i5, iH2, objArr, iH, objArr);
                } else if (i5 >= objArr.length) {
                    j.w(i5 - objArr.length, iH2, objArr, iH, objArr);
                } else {
                    int length = iH - (i6 - objArr.length);
                    j.w(0, length, objArr, iH, objArr);
                    Object[] objArr2 = this.b;
                    j.w(i5, iH2, objArr2, length, objArr2);
                }
            } else {
                Object[] objArr3 = this.b;
                j.w(size, 0, objArr3, iH, objArr3);
                Object[] objArr4 = this.b;
                if (i5 >= objArr4.length) {
                    j.w(i5 - objArr4.length, iH2, objArr4, objArr4.length, objArr4);
                } else {
                    j.w(0, objArr4.length - size, objArr4, objArr4.length, objArr4);
                    Object[] objArr5 = this.b;
                    j.w(i5, iH2, objArr5, objArr5.length - size, objArr5);
                }
            }
            c(iH2, elements);
            return true;
        }
        int i7 = this.f3802a;
        int length2 = i7 - size;
        if (iH2 < i7) {
            Object[] objArr6 = this.b;
            j.w(length2, i7, objArr6, objArr6.length, objArr6);
            if (size >= iH2) {
                Object[] objArr7 = this.b;
                j.w(objArr7.length - size, 0, objArr7, iH2, objArr7);
            } else {
                Object[] objArr8 = this.b;
                j.w(objArr8.length - size, 0, objArr8, size, objArr8);
                Object[] objArr9 = this.b;
                j.w(0, size, objArr9, iH2, objArr9);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.b;
            j.w(length2, i7, objArr10, iH2, objArr10);
        } else {
            Object[] objArr11 = this.b;
            length2 += objArr11.length;
            int i8 = iH2 - i7;
            int length3 = objArr11.length - length2;
            if (length3 >= i8) {
                j.w(length2, i7, objArr11, iH2, objArr11);
            } else {
                j.w(length2, i7, objArr11, i7 + length3, objArr11);
                Object[] objArr12 = this.b;
                j.w(0, this.f3802a + length3, objArr12, iH2, objArr12);
            }
        }
        this.f3802a = length2;
        int length4 = iH2 - size;
        if (length4 < 0) {
            length4 += this.b.length;
        }
        c(length4, elements);
        return true;
    }

    public final void addFirst(Object obj) {
        d(this.c + 1);
        int length = this.f3802a;
        if (length == 0) {
            Object[] objArr = this.b;
            kotlin.jvm.internal.h.f(objArr, "<this>");
            length = objArr.length;
        }
        int i = length - 1;
        this.f3802a = i;
        this.b[i] = obj;
        this.c++;
    }

    public final void addLast(Object obj) {
        d(a() + 1);
        this.b[h(a() + this.f3802a)] = obj;
        this.c = a() + 1;
    }

    @Override // kotlin.collections.f
    public final Object b(int i) {
        int i3 = this.c;
        if (i < 0 || i >= i3) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", i3));
        }
        if (i == n.x(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        int iH = h(this.f3802a + i);
        Object[] objArr = this.b;
        Object obj = objArr[iH];
        if (i < (this.c >> 1)) {
            int i4 = this.f3802a;
            if (iH >= i4) {
                j.w(i4 + 1, i4, objArr, iH, objArr);
            } else {
                j.w(1, 0, objArr, iH, objArr);
                Object[] objArr2 = this.b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i5 = this.f3802a;
                j.w(i5 + 1, i5, objArr2, objArr2.length - 1, objArr2);
            }
            Object[] objArr3 = this.b;
            int i6 = this.f3802a;
            objArr3[i6] = null;
            this.f3802a = f(i6);
        } else {
            int iH2 = h(n.x(this) + this.f3802a);
            if (iH <= iH2) {
                Object[] objArr4 = this.b;
                j.w(iH, iH + 1, objArr4, iH2 + 1, objArr4);
            } else {
                Object[] objArr5 = this.b;
                j.w(iH, iH + 1, objArr5, objArr5.length, objArr5);
                Object[] objArr6 = this.b;
                objArr6[objArr6.length - 1] = objArr6[0];
                j.w(0, 1, objArr6, iH2 + 1, objArr6);
            }
            this.b[iH2] = null;
        }
        this.c--;
        return obj;
    }

    public final void c(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i3 = this.f3802a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.b[i4] = it.next();
        }
        this.c = collection.size() + this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int iH = h(this.c + this.f3802a);
        int i = this.f3802a;
        if (i < iH) {
            j.y(this.b, null, i, iH);
        } else if (!isEmpty()) {
            Object[] objArr = this.b;
            Arrays.fill(objArr, this.f3802a, objArr.length, (Object) null);
            j.y(this.b, null, 0, iH);
        }
        this.f3802a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == d) {
            if (i < 10) {
                i = 10;
            }
            this.b = new Object[i];
            return;
        }
        int length = objArr.length;
        int i3 = length + (length >> 1);
        if (i3 - i < 0) {
            i3 = i;
        }
        if (i3 - 2147483639 > 0) {
            i3 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i3];
        j.w(0, this.f3802a, objArr, objArr.length, objArr2);
        Object[] objArr3 = this.b;
        int length2 = objArr3.length;
        int i4 = this.f3802a;
        j.w(length2 - i4, 0, objArr3, i4, objArr2);
        this.f3802a = 0;
        this.b = objArr2;
    }

    public final Object e() {
        if (isEmpty()) {
            return null;
        }
        return this.b[this.f3802a];
    }

    public final int f(int i) {
        kotlin.jvm.internal.h.f(this.b, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[this.f3802a];
    }

    public final Object g() {
        if (isEmpty()) {
            return null;
        }
        return this.b[h(n.x(this) + this.f3802a)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", iA));
        }
        return this.b[h(this.f3802a + i)];
    }

    public final int h(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iH = h(a() + this.f3802a);
        int length = this.f3802a;
        if (length < iH) {
            while (length < iH) {
                if (kotlin.jvm.internal.h.a(obj, this.b[length])) {
                    i = this.f3802a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iH) {
            return -1;
        }
        int length2 = this.b.length;
        while (true) {
            if (length >= length2) {
                for (int i3 = 0; i3 < iH; i3++) {
                    if (kotlin.jvm.internal.h.a(obj, this.b[i3])) {
                        length = i3 + this.b.length;
                        i = this.f3802a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.h.a(obj, this.b[length])) {
                i = this.f3802a;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[h(n.x(this) + this.f3802a)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iH = h(this.c + this.f3802a);
        int i3 = this.f3802a;
        if (i3 < iH) {
            length = iH - 1;
            if (i3 <= length) {
                while (!kotlin.jvm.internal.h.a(obj, this.b[length])) {
                    if (length != i3) {
                        length--;
                    }
                }
                i = this.f3802a;
                return length - i;
            }
            return -1;
        }
        if (i3 > iH) {
            int i4 = iH - 1;
            while (true) {
                if (-1 >= i4) {
                    Object[] objArr = this.b;
                    kotlin.jvm.internal.h.f(objArr, "<this>");
                    length = objArr.length - 1;
                    int i5 = this.f3802a;
                    if (i5 <= length) {
                        while (!kotlin.jvm.internal.h.a(obj, this.b[length])) {
                            if (length != i5) {
                                length--;
                            }
                        }
                        i = this.f3802a;
                    }
                } else {
                    if (kotlin.jvm.internal.h.a(obj, this.b[i4])) {
                        length = i4 + this.b.length;
                        i = this.f3802a;
                        break;
                    }
                    i4--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int iH;
        kotlin.jvm.internal.h.f(elements, "elements");
        boolean z6 = false;
        z6 = false;
        z6 = false;
        if (!isEmpty() && this.b.length != 0) {
            int iH2 = h(this.c + this.f3802a);
            int i = this.f3802a;
            if (i < iH2) {
                iH = i;
                while (i < iH2) {
                    Object obj = this.b[i];
                    if (elements.contains(obj)) {
                        z6 = true;
                    } else {
                        this.b[iH] = obj;
                        iH++;
                    }
                    i++;
                }
                j.y(this.b, null, iH, iH2);
            } else {
                int length = this.b.length;
                boolean z7 = false;
                int i3 = i;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        z7 = true;
                    } else {
                        this.b[i3] = obj2;
                        i3++;
                    }
                    i++;
                }
                iH = h(i3);
                for (int i4 = 0; i4 < iH2; i4++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (elements.contains(obj3)) {
                        z7 = true;
                    } else {
                        this.b[iH] = obj3;
                        iH = f(iH);
                    }
                }
                z6 = z7;
            }
            if (z6) {
                int length2 = iH - this.f3802a;
                if (length2 < 0) {
                    length2 += this.b.length;
                }
                this.c = length2;
            }
        }
        return z6;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.b;
        int i = this.f3802a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f3802a = f(i);
        this.c = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iH = h(n.x(this) + this.f3802a);
        Object[] objArr = this.b;
        Object obj = objArr[iH];
        objArr[iH] = null;
        this.c = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int iH;
        kotlin.jvm.internal.h.f(elements, "elements");
        boolean z6 = false;
        z6 = false;
        z6 = false;
        if (!isEmpty() && this.b.length != 0) {
            int iH2 = h(this.c + this.f3802a);
            int i = this.f3802a;
            if (i < iH2) {
                iH = i;
                while (i < iH2) {
                    Object obj = this.b[i];
                    if (elements.contains(obj)) {
                        this.b[iH] = obj;
                        iH++;
                    } else {
                        z6 = true;
                    }
                    i++;
                }
                j.y(this.b, null, iH, iH2);
            } else {
                int length = this.b.length;
                boolean z7 = false;
                int i3 = i;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.b[i3] = obj2;
                        i3++;
                    } else {
                        z7 = true;
                    }
                    i++;
                }
                iH = h(i3);
                for (int i4 = 0; i4 < iH2; i4++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (elements.contains(obj3)) {
                        this.b[iH] = obj3;
                        iH = f(iH);
                    } else {
                        z7 = true;
                    }
                }
                z6 = z7;
            }
            if (z6) {
                int length2 = iH - this.f3802a;
                if (length2 < 0) {
                    length2 += this.b.length;
                }
                this.c = length2;
            }
        }
        return z6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("index: ", i, ", size: ", iA));
        }
        int iH = h(this.f3802a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    public i(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = d;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException(B2.b.c(i, "Illegal Capacity: "));
        }
        this.b = objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.h.f(array, "array");
        int length = array.length;
        int i = this.c;
        if (length < i) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), i);
            kotlin.jvm.internal.h.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) objNewInstance;
        }
        int iH = h(this.c + this.f3802a);
        int i3 = this.f3802a;
        if (i3 < iH) {
            j.w(0, i3, this.b, iH, array);
        } else if (!isEmpty()) {
            Object[] objArr = this.b;
            j.w(0, this.f3802a, objArr, objArr.length, array);
            Object[] objArr2 = this.b;
            j.w(objArr2.length - this.f3802a, 0, objArr2, iH, array);
        }
        int length2 = array.length;
        int i4 = this.c;
        if (length2 > i4) {
            array[i4] = null;
        }
        return array;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        d(elements.size() + a());
        c(h(a() + this.f3802a), elements);
        return true;
    }
}
