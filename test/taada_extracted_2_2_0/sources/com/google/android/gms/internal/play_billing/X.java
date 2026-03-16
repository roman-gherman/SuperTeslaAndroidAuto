package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class X extends F {
    public final transient Object c;

    public X(Object obj) {
        this.c = obj;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int a(Object[] objArr) {
        objArr[0] = this.c;
        return 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.c.equals(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.F, com.google.android.gms.internal.play_billing.AbstractC0323v
    public final A d() {
        Object[] objArr = {this.c};
        for (int i = 0; i < 1; i++) {
            C0329x c0329x = A.b;
            if (objArr[i] == null) {
                throw new NullPointerException(B2.b.c(i, "at index "));
            }
        }
        return A.i(1, objArr);
    }

    @Override // com.google.android.gms.internal.play_billing.F, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new I(this.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return androidx.constraintlayout.core.motion.a.q("[", this.c.toString(), "]");
    }
}
