package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0395v0 extends AbstractC0359d implements RandomAccess {
    public static final C0395v0 d;
    public Object[] b;
    public int c;

    static {
        C0395v0 c0395v0 = new C0395v0(new Object[0], 0);
        d = c0395v0;
        c0395v0.f2868a = false;
    }

    public C0395v0(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0359d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.c;
        Object[] objArr = this.b;
        if (i == objArr.length) {
            this.b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.c) {
            StringBuilder sbJ = B2.b.j(i, "Index:", ", Size:");
            sbJ.append(this.c);
            throw new IndexOutOfBoundsException(sbJ.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.b[i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    public final Internal$ProtobufList mutableCopyWithCapacity2(int i) {
        if (i >= this.c) {
            return new C0395v0(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0359d, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        b(i);
        Object[] objArr = this.b;
        Object obj = objArr[i];
        if (i < this.c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        b(i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        a();
        if (i >= 0 && i <= (i3 = this.c)) {
            Object[] objArr = this.b;
            if (i3 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i3 - i);
            } else {
                Object[] objArr2 = new Object[androidx.constraintlayout.core.motion.a.y(i3, 3, 2, 1)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(this.b, i, objArr2, i + 1, this.c - i);
                this.b = objArr2;
            }
            this.b[i] = obj;
            this.c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbJ = B2.b.j(i, "Index:", ", Size:");
        sbJ.append(this.c);
        throw new IndexOutOfBoundsException(sbJ.toString());
    }
}
