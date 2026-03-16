package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0275e1 extends L0 implements RandomAccess, zzhn, zzit {
    public static final int[] d;
    public static final C0275e1 e;
    public int[] b;
    public int c;

    static {
        int[] iArr = new int[0];
        d = iArr;
        e = new C0275e1(iArr, 0, false);
    }

    public C0275e1(int[] iArr, int i, boolean z6) {
        super(z6);
        this.b = iArr;
        this.c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i3 = this.c)) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("Index:", i, ", Size:", this.c));
        }
        int i4 = i + 1;
        int[] iArr = this.b;
        int length = iArr.length;
        if (i3 < length) {
            System.arraycopy(iArr, i, iArr, i4, i3 - i);
        } else {
            int[] iArr2 = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.b, 0, iArr2, 0, i);
            System.arraycopy(this.b, i, iArr2, i4, this.c - i);
            this.b = iArr2;
        }
        this.b[i] = iIntValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.L0, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = AbstractC0278f1.f2076a;
        collection.getClass();
        if (!(collection instanceof C0275e1)) {
            return super.addAll(collection);
        }
        C0275e1 c0275e1 = (C0275e1) collection;
        int i = c0275e1.c;
        if (i == 0) {
            return false;
        }
        int i3 = this.c;
        if (Integer.MAX_VALUE - i3 < i) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i;
        int[] iArr = this.b;
        if (i4 > iArr.length) {
            this.b = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(c0275e1.b, 0, this.b, this.c, c0275e1.c);
        this.c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final int b(int i) {
        d(i);
        return this.b[i];
    }

    public final void c(int i) {
        a();
        int i3 = this.c;
        int length = this.b.length;
        if (i3 == length) {
            int[] iArr = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.b, 0, iArr, 0, this.c);
            this.b = iArr;
        }
        int[] iArr2 = this.b;
        int i4 = this.c;
        this.c = i4 + 1;
        iArr2[i4] = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("Index:", i, ", Size:", this.c));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.L0, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0275e1)) {
            return super.equals(obj);
        }
        C0275e1 c0275e1 = (C0275e1) obj;
        if (this.c != c0275e1.c) {
            return false;
        }
        int[] iArr = c0275e1.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        d(i);
        return Integer.valueOf(this.b[i]);
    }

    @Override // com.google.android.gms.internal.play_billing.L0, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i3 = 0; i3 < this.c; i3++) {
            i = (i * 31) + this.b[i3];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.c;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.L0, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        a();
        d(i);
        int[] iArr = this.b;
        int i3 = iArr[i];
        if (i < this.c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i3) {
        a();
        if (i3 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.b;
        System.arraycopy(iArr, i3, iArr, i, this.c - i3);
        this.c -= i3 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        a();
        d(i);
        int[] iArr = this.b;
        int i3 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.play_billing.zzho
    public final /* bridge */ /* synthetic */ zzho zzd(int i) {
        if (i >= this.c) {
            return new C0275e1(i == 0 ? d : Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        c(((Integer) obj).intValue());
        return true;
    }
}
