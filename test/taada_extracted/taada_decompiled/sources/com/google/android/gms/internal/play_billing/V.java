package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class V extends F {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f2057h;
    public static final V i;
    public final transient Object[] c;
    public final transient int d;
    public final transient Object[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f2058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f2059g;

    static {
        Object[] objArr = new Object[0];
        f2057h = objArr;
        i = new V(0, 0, objArr, 0, objArr);
    }

    public V(int i3, int i4, Object[] objArr, int i5, Object[] objArr2) {
        this.c = objArr;
        this.d = i3;
        this.e = objArr2;
        this.f2058f = i4;
        this.f2059g = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.c;
        int i3 = this.f2059g;
        System.arraycopy(objArr2, 0, objArr, 0, i3);
        return i3;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int b() {
        return this.f2059g;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int c() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.e;
            if (objArr.length != 0) {
                int iA = AbstractC0263a1.a(obj.hashCode());
                while (true) {
                    int i3 = iA & this.f2058f;
                    Object obj2 = objArr[i3];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iA = i3 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final Object[] f() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.play_billing.F
    public final A h() {
        return A.i(this.f2059g, this.c);
    }

    @Override // com.google.android.gms.internal.play_billing.F, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return d().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f2059g;
    }
}
