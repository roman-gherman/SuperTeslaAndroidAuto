package com.google.android.gms.internal.play_billing;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0268c0 extends AbstractC0263a1 {
    public final AtomicReferenceFieldUpdater b;
    public final AtomicReferenceFieldUpdater c;
    public final AtomicReferenceFieldUpdater d;
    public final AtomicReferenceFieldUpdater e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f2072f;

    public C0268c0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(8);
        this.b = atomicReferenceFieldUpdater;
        this.c = atomicReferenceFieldUpdater2;
        this.d = atomicReferenceFieldUpdater3;
        this.e = atomicReferenceFieldUpdater4;
        this.f2072f = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean C(AbstractC0286i0 abstractC0286i0, Object obj, Object obj2) {
        return AbstractC0263a1.j(this.f2072f, abstractC0286i0, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean E(AbstractC0286i0 abstractC0286i0, C0283h0 c0283h0, C0283h0 c0283h02) {
        return AbstractC0263a1.j(this.d, abstractC0286i0, c0283h0, c0283h02);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final C0265b0 c(AbstractC0286i0 abstractC0286i0) {
        return (C0265b0) this.e.getAndSet(abstractC0286i0, C0265b0.d);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final C0283h0 n(AbstractC0286i0 abstractC0286i0) {
        return (C0283h0) this.d.getAndSet(abstractC0286i0, C0283h0.c);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void r(C0283h0 c0283h0, C0283h0 c0283h02) {
        this.c.lazySet(c0283h0, c0283h02);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final void t(C0283h0 c0283h0, Thread thread) {
        this.b.lazySet(c0283h0, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0263a1
    public final boolean y(AbstractC0286i0 abstractC0286i0, C0265b0 c0265b0, C0265b0 c0265b02) {
        return AbstractC0263a1.j(this.e, abstractC0286i0, c0265b0, c0265b02);
    }
}
