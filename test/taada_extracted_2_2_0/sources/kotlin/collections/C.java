package kotlin.collections;

import e2.C0430f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3797a;

    public C(ArrayList arrayList) {
        this.f3797a = arrayList;
    }

    @Override // kotlin.collections.f
    public final int a() {
        return this.f3797a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        if (new C0430f(0, a(), 1).b(i)) {
            this.f3797a.add(a() - i, obj);
        } else {
            StringBuilder sbJ = B2.b.j(i, "Position index ", " must be in range [");
            sbJ.append(new C0430f(0, a(), 1));
            sbJ.append("].");
            throw new IndexOutOfBoundsException(sbJ.toString());
        }
    }

    @Override // kotlin.collections.f
    public final Object b(int i) {
        return this.f3797a.remove(m.J(i, this));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f3797a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f3797a.get(m.J(i, this));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        return this.f3797a.set(m.J(i, this), obj);
    }
}
