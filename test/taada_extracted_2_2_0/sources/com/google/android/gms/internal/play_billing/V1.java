package com.google.android.gms.internal.play_billing;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class V1 extends AbstractC0263a1 {
    public final AtomicReferenceFieldUpdater b;
    public final AtomicReferenceFieldUpdater c;
    public final AtomicReferenceFieldUpdater d;
    public final AtomicReferenceFieldUpdater e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f2060f;

    public V1(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(10);
        this.b = atomicReferenceFieldUpdater;
        this.c = atomicReferenceFieldUpdater2;
        this.d = atomicReferenceFieldUpdater3;
        this.e = atomicReferenceFieldUpdater4;
        this.f2060f = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void h(i2 i2Var, i2 i2Var2) {
        this.c.lazySet(i2Var, i2Var2);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void q(i2 i2Var, Thread thread) {
        this.b.lazySet(i2Var, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean s(j2 j2Var, C0328w1 c0328w1, C0328w1 c0328w12) {
        return AbstractC0263a1.k(this.e, j2Var, c0328w1, c0328w12);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean u(j2 j2Var, Object obj, Object obj2) {
        return AbstractC0263a1.k(this.f2060f, j2Var, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean z(j2 j2Var, i2 i2Var, i2 i2Var2) {
        return AbstractC0263a1.k(this.d, j2Var, i2Var, i2Var2);
    }
}
