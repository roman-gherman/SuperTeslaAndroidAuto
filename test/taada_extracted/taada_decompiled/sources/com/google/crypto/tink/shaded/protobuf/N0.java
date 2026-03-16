package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class N0 extends AbstractList implements LazyStringList, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y f2841a;

    public N0(Y y) {
        this.f2841a = y;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void add(AbstractC0381o abstractC0381o) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final boolean addAllByteArray(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final boolean addAllByteString(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final List asByteArrayList() {
        return Collections.unmodifiableList(this.f2841a.asByteArrayList());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ProtocolStringList
    public final List asByteStringList() {
        return Collections.unmodifiableList(this.f2841a.asByteStringList());
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f2841a.get(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final byte[] getByteArray(int i) {
        return this.f2841a.getByteArray(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final AbstractC0381o getByteString(int i) {
        return this.f2841a.getByteString(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final Object getRaw(int i) {
        return this.f2841a.getRaw(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final List getUnderlyingElements() {
        return this.f2841a.getUnderlyingElements();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        M0 m02 = new M0();
        m02.f2839a = this.f2841a.iterator();
        return m02;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        L0 l02 = new L0();
        l02.f2838a = this.f2841a.listIterator(i);
        return l02;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void set(int i, AbstractC0381o abstractC0381o) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2841a.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
