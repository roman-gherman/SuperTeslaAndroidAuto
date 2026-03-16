package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class M0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f2839a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2839a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f2839a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
