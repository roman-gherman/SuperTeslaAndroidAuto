package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.reflect.l;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes.dex */
public final class a extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f2789a;
    public final int b;
    public final int c;

    public a(int i, int i3, int[] iArr) {
        this.f2789a = iArr;
        this.b = i;
        this.c = i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.b;
        while (true) {
            if (i >= this.c) {
                i = -1;
                break;
            }
            if (this.f2789a[i] == iIntValue) {
                break;
            }
            i++;
        }
        return i != -1;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return super.equals(obj);
        }
        a aVar = (a) obj;
        int size = size();
        if (aVar.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.f2789a[this.b + i] != aVar.f2789a[aVar.b + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        l.g(i, size());
        return Integer.valueOf(this.f2789a[this.b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i3 = this.b; i3 < this.c; i3++) {
            i = (i * 31) + this.f2789a[i3];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i = this.b;
            int i3 = i;
            while (true) {
                if (i3 >= this.c) {
                    i3 = -1;
                    break;
                }
                if (this.f2789a[i3] == iIntValue) {
                    break;
                }
                i3++;
            }
            if (i3 >= 0) {
                return i3 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i3 = this.c;
            while (true) {
                i3--;
                i = this.b;
                if (i3 < i) {
                    i3 = -1;
                    break;
                }
                if (this.f2789a[i3] == iIntValue) {
                    break;
                }
            }
            if (i3 >= 0) {
                return i3 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Integer num = (Integer) obj;
        l.g(i, size());
        int i3 = this.b + i;
        int[] iArr = this.f2789a;
        int i4 = iArr[i3];
        num.getClass();
        iArr[i3] = num.intValue();
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c - this.b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i3) {
        l.h(i, i3, size());
        if (i == i3) {
            return Collections.EMPTY_LIST;
        }
        int i4 = this.b;
        return new a(i + i4, i4 + i3, this.f2789a);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        int[] iArr = this.f2789a;
        int i = this.b;
        sb.append(iArr[i]);
        while (true) {
            i++;
            if (i >= this.c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i]);
        }
    }
}
