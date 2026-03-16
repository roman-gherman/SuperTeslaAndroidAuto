package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class X extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2863a;
    public final Y b;

    public /* synthetic */ X(Y y, int i) {
        this.f2863a = i;
        this.b = y;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        switch (this.f2863a) {
            case 0:
                Y.b(this.b, i, (byte[]) obj);
                ((AbstractList) this).modCount++;
                break;
            default:
                Y.c(this.b, i, (AbstractC0381o) obj);
                ((AbstractList) this).modCount++;
                break;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        switch (this.f2863a) {
            case 0:
                return this.b.getByteArray(i);
            default:
                return this.b.getByteString(i);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        switch (this.f2863a) {
            case 0:
                String strF = this.b.f(i);
                ((AbstractList) this).modCount++;
                return Y.d(strF);
            default:
                String strF2 = this.b.f(i);
                ((AbstractList) this).modCount++;
                return Y.e(strF2);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Y y = this.b;
        switch (this.f2863a) {
            case 0:
                int i3 = Y.c;
                y.a();
                Object obj2 = y.b.set(i, (byte[]) obj);
                ((AbstractList) this).modCount++;
                return Y.d(obj2);
            default:
                int i4 = Y.c;
                y.a();
                Object obj3 = y.b.set(i, (AbstractC0381o) obj);
                ((AbstractList) this).modCount++;
                return Y.e(obj3);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        switch (this.f2863a) {
        }
        return this.b.b.size();
    }
}
