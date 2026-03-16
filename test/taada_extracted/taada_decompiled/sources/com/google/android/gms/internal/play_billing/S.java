package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class S extends F {
    public final transient U c;
    public final transient T d;

    public S(U u, T t6) {
        this.c = u;
        this.d = t6;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int a(Object[] objArr) {
        return this.d.a(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.c.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.play_billing.F, com.google.android.gms.internal.play_billing.AbstractC0323v
    public final A d() {
        return this.d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.c.f2056f;
    }
}
