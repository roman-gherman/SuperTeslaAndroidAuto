package Q;

import kotlin.reflect.l;

/* JADX INFO: loaded from: classes.dex */
public final class g extends f {
    public static final g e = new g(new Object[0], 0);
    public final transient Object[] c;
    public final transient int d;

    public g(Object[] objArr, int i) {
        this.c = objArr;
        this.d = i;
    }

    @Override // Q.c
    public final Object[] a() {
        return this.c;
    }

    @Override // Q.c
    public final int b() {
        return 0;
    }

    @Override // Q.c
    public final int c() {
        return this.d;
    }

    @Override // Q.c
    public final boolean d() {
        return false;
    }

    @Override // Q.f, Q.c
    public final int e(Object[] objArr) {
        Object[] objArr2 = this.c;
        int i = this.d;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        l.o0(i, this.d);
        return this.c[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }
}
