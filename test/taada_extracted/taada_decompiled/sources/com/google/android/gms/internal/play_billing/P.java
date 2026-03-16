package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class P extends A {
    public final /* synthetic */ Q c;

    public P(Q q) {
        this.c = q;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final boolean e() {
        return true;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        Q q = this.c;
        AbstractC0263a1.f(i, q.e);
        int i3 = i + i;
        Object[] objArr = q.d;
        Object obj = objArr[i3];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i3 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.e;
    }
}
