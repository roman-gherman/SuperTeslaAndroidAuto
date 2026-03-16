package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0335z extends A {
    public final transient int c;
    public final transient int d;
    public final /* synthetic */ A e;

    public C0335z(A a6, int i, int i3) {
        this.e = a6;
        this.c = i;
        this.d = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int b() {
        return this.e.c() + this.c + this.d;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final int c() {
        return this.e.c() + this.c;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final boolean e() {
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0323v
    public final Object[] f() {
        return this.e.f();
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC0263a1.f(i, this.d);
        return this.e.get(i + this.c);
    }

    @Override // com.google.android.gms.internal.play_billing.A, java.util.List
    /* JADX INFO: renamed from: h */
    public final A subList(int i, int i3) {
        AbstractC0263a1.w(i, i3, this.d);
        int i4 = this.c;
        return this.e.subList(i + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }
}
