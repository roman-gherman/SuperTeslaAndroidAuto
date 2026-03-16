package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0332y extends A {
    public final transient A c;

    public C0332y(A a6) {
        this.c = a6;
    }

    @Override // com.google.android.gms.internal.play_billing.A, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.c.contains(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final boolean e() {
        return this.c.e();
    }

    @Override // com.google.android.gms.internal.play_billing.A
    public final A g() {
        return this.c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        A a6 = this.c;
        AbstractC0263a1.f(i, a6.size());
        return a6.get((a6.size() - 1) - i);
    }

    @Override // com.google.android.gms.internal.play_billing.A, java.util.List
    /* JADX INFO: renamed from: h */
    public final A subList(int i, int i3) {
        A a6 = this.c;
        AbstractC0263a1.w(i, i3, a6.size());
        return a6.subList(a6.size() - i3, a6.size() - i).g();
    }

    @Override // com.google.android.gms.internal.play_billing.A, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.c.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return (r0.size() - 1) - iLastIndexOf;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.A, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.c.indexOf(obj);
        if (iIndexOf >= 0) {
            return (r0.size() - 1) - iIndexOf;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.size();
    }
}
