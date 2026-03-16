package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.t1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0319t1 extends L0 implements RandomAccess {
    public static final Object[] d;
    public static final C0319t1 e;
    public Object[] b;
    public int c;

    static {
        Object[] objArr = new Object[0];
        d = objArr;
        e = new C0319t1(objArr, 0, false);
    }

    public C0319t1(Object[] objArr, int i, boolean z6) {
        super(z6);
        this.b = objArr;
        this.c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        a();
        if (i < 0 || i > (i3 = this.c)) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("Index:", i, ", Size:", this.c));
        }
        int i4 = i + 1;
        Object[] objArr = this.b;
        int length = objArr.length;
        if (i3 < length) {
            System.arraycopy(objArr, i, objArr, i4, i3 - i);
        } else {
            Object[] objArr2 = new Object[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.b, 0, objArr2, 0, i);
            System.arraycopy(this.b, i, objArr2, i4, this.c - i);
            this.b = objArr2;
        }
        this.b[i] = obj;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("Index:", i, ", Size:", this.c));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.play_billing.L0, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        b(i);
        Object[] objArr = this.b;
        Object obj = objArr[i];
        if (i < this.c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        b(i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.play_billing.zzho
    public final /* bridge */ /* synthetic */ zzho zzd(int i) {
        if (i >= this.c) {
            return new C0319t1(i == 0 ? d : Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.c;
        int length = this.b.length;
        if (i == length) {
            this.b = Arrays.copyOf(this.b, Math.max(((length * 3) / 2) + 1, 10));
        }
        Object[] objArr = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
