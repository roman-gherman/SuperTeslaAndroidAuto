package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class Y extends AbstractC0359d implements LazyStringList, RandomAccess {
    public static final /* synthetic */ int c = 0;
    public final ArrayList b;

    static {
        new Y(10).f2868a = false;
    }

    public Y(int i) {
        this(new ArrayList(i));
    }

    public static void b(Y y, int i, byte[] bArr) {
        y.a();
        y.b.add(i, bArr);
        ((AbstractList) y).modCount++;
    }

    public static void c(Y y, int i, AbstractC0381o abstractC0381o) {
        y.a();
        y.b.add(i, abstractC0381o);
        ((AbstractList) y).modCount++;
    }

    public static byte[] d(Object obj) {
        return obj instanceof byte[] ? (byte[]) obj : obj instanceof String ? ((String) obj).getBytes(T.f2849a) : ((AbstractC0381o) obj).k();
    }

    public static AbstractC0381o e(Object obj) {
        if (obj instanceof AbstractC0381o) {
            return (AbstractC0381o) obj;
        }
        if (obj instanceof String) {
            return AbstractC0381o.d((String) obj);
        }
        byte[] bArr = (byte[]) obj;
        C0379n c0379n = AbstractC0381o.b;
        return AbstractC0381o.c(bArr, 0, bArr.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        a();
        this.b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0359d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.b.size(), collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final boolean addAllByteArray(Collection collection) {
        a();
        boolean zAddAll = this.b.addAll(collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final boolean addAllByteString(Collection collection) {
        a();
        boolean zAddAll = this.b.addAll(collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final List asByteArrayList() {
        return new X(this, 0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ProtocolStringList
    public final List asByteStringList() {
        return new X(this, 1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0359d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0359d, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final String remove(int i) {
        a();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof AbstractC0381o)) {
            return new String((byte[]) objRemove, T.f2849a);
        }
        AbstractC0381o abstractC0381o = (AbstractC0381o) objRemove;
        abstractC0381o.getClass();
        return abstractC0381o.size() == 0 ? "" : abstractC0381o.l(T.f2849a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ArrayList arrayList = this.b;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC0381o) {
            AbstractC0381o abstractC0381o = (AbstractC0381o) obj;
            abstractC0381o.getClass();
            String strL = abstractC0381o.size() == 0 ? "" : abstractC0381o.l(T.f2849a);
            if (abstractC0381o.g()) {
                arrayList.set(i, strL);
            }
            return strL;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, T.f2849a);
        AbstractC0369i abstractC0369i = V0.f2851a;
        if (V0.f2851a.u(bArr, 0, bArr.length)) {
            arrayList.set(i, str);
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final byte[] getByteArray(int i) {
        ArrayList arrayList = this.b;
        Object obj = arrayList.get(i);
        byte[] bArrD = d(obj);
        if (bArrD != obj) {
            arrayList.set(i, bArrD);
        }
        return bArrD;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final AbstractC0381o getByteString(int i) {
        ArrayList arrayList = this.b;
        Object obj = arrayList.get(i);
        AbstractC0381o abstractC0381oE = e(obj);
        if (abstractC0381oE != obj) {
            arrayList.set(i, abstractC0381oE);
        }
        return abstractC0381oE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final Object getRaw(int i) {
        return this.b.get(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final LazyStringList getUnmodifiableView() {
        return this.f2868a ? new N0(this) : this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void mergeFrom(LazyStringList lazyStringList) {
        a();
        for (Object obj : lazyStringList.getUnderlyingElements()) {
            boolean z6 = obj instanceof byte[];
            ArrayList arrayList = this.b;
            if (z6) {
                byte[] bArr = (byte[]) obj;
                arrayList.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                arrayList.add(obj);
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public final Internal$ProtobufList mutableCopyWithCapacity2(int i) {
        ArrayList arrayList = this.b;
        if (i < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i);
        arrayList2.addAll(arrayList);
        return new Y(arrayList2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        Object obj2 = this.b.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof AbstractC0381o)) {
            return new String((byte[]) obj2, T.f2849a);
        }
        AbstractC0381o abstractC0381o = (AbstractC0381o) obj2;
        abstractC0381o.getClass();
        return abstractC0381o.size() == 0 ? "" : abstractC0381o.l(T.f2849a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.size();
    }

    public Y(ArrayList arrayList) {
        this.b = arrayList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0359d, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        a();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void add(AbstractC0381o abstractC0381o) {
        a();
        this.b.add(abstractC0381o);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void add(byte[] bArr) {
        a();
        this.b.add(bArr);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void set(int i, AbstractC0381o abstractC0381o) {
        a();
        this.b.set(i, abstractC0381o);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void set(int i, byte[] bArr) {
        a();
        this.b.set(i, bArr);
    }
}
