package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class I extends Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2036a;
    public boolean b;

    public I(Object obj) {
        this.f2036a = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b) {
            throw new NoSuchElementException();
        }
        this.b = true;
        return this.f2036a;
    }
}
