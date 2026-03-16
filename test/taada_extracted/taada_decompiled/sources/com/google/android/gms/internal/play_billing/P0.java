package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class P0 implements zzgg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2048a = 0;
    public final int b;
    public final /* synthetic */ S0 c;

    public P0(S0 s02) {
        this.c = s02;
        this.b = s02.c();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2048a < this.b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(zza());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgg
    public final byte zza() {
        int i = this.f2048a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f2048a = i + 1;
        return this.c.b(i);
    }
}
