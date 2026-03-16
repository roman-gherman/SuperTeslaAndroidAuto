package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class O extends A {
    public static final O e = new O(new Object[0], 0);
    public final transient Object[] c;
    public final transient int d;

    public O(Object[] objArr, int i) {
        this.c = objArr;
        this.d = i;
    }

    @Override // com.google.android.gms.internal.play_billing.A, com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.c;
        int i = this.d;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int b() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int c() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final boolean e() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final Object[] f() {
        return this.c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC0263a1.f(i, this.d);
        Object obj = this.c[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }
}
