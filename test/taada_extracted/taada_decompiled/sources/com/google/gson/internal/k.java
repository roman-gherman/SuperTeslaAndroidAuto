package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f3004a;
    public m b = null;
    public int c;
    public final /* synthetic */ n d;
    public final /* synthetic */ int e;

    public k(n nVar, int i) {
        this.e = i;
        this.d = nVar;
        this.f3004a = nVar.f3011f.d;
        this.c = nVar.e;
    }

    public final Object a() {
        return b();
    }

    public final m b() {
        m mVar = this.f3004a;
        n nVar = this.d;
        if (mVar == nVar.f3011f) {
            throw new NoSuchElementException();
        }
        if (nVar.e != this.c) {
            throw new ConcurrentModificationException();
        }
        this.f3004a = mVar.d;
        this.b = mVar;
        return mVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3004a != this.d.f3011f;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.e) {
            case 1:
                return b().f3007f;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        m mVar = this.b;
        if (mVar == null) {
            throw new IllegalStateException();
        }
        n nVar = this.d;
        nVar.c(mVar, true);
        this.b = null;
        this.c = nVar.e;
    }
}
