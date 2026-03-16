package com.google.crypto.tink.shaded.protobuf;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0373k implements ByteString$ByteIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2884a = 0;
    public final int b;
    public final /* synthetic */ C0379n c;

    public C0373k(C0379n c0379n) {
        this.c = c0379n;
        this.b = c0379n.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2884a < this.b;
    }

    @Override // java.util.Iterator
    public final Byte next() {
        return Byte.valueOf(nextByte());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString$ByteIterator
    public final byte nextByte() {
        int i = this.f2884a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f2884a = i + 1;
        return this.c.f(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
