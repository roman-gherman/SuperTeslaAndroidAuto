package com.google.android.gms.internal.play_billing;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class F extends AbstractC0323v implements Set {
    public transient A b;

    public static int g(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return BasicMeasure.EXACTLY;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static F i(int i, Object... objArr) {
        if (i == 0) {
            return V.i;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new X(obj);
        }
        int iG = g(i);
        Object[] objArr2 = new Object[iG];
        int i3 = iG - 1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj2 = objArr[i6];
            if (obj2 == null) {
                throw new NullPointerException(B2.b.c(i6, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iA = AbstractC0263a1.a(iHashCode);
            while (true) {
                int i7 = iA & i3;
                Object obj3 = objArr2[i7];
                if (obj3 == null) {
                    objArr[i5] = obj2;
                    objArr2[i7] = obj2;
                    i4 += iHashCode;
                    i5++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iA++;
                }
            }
        }
        Arrays.fill(objArr, i5, i, (Object) null);
        if (i5 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new X(obj4);
        }
        if (g(i5) < iG / 2) {
            return i(i5, objArr);
        }
        int length = objArr.length;
        if (i5 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new V(i4, i3, objArr, i5, objArr2);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public A d() {
        A a6 = this.b;
        if (a6 != null) {
            return a6;
        }
        A aH = h();
        this.b = aH;
        return aH;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof F) && (this instanceof V)) {
            F f6 = (F) obj;
            f6.getClass();
            if ((f6 instanceof V) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public A h() {
        Object[] array = toArray(AbstractC0323v.f2129a);
        C0329x c0329x = A.b;
        return A.i(array.length, array);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}
