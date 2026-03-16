package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class T extends A {
    public final transient Object[] c;
    public final transient int d;
    public final transient int e;

    public T(Object[] objArr, int i, int i3) {
        this.c = objArr;
        this.d = i;
        this.e = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final boolean e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC0263a1.f(i, this.e);
        Object obj = this.c[i + i + this.d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
