package g3;

import a3.C0148k;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: g3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0486c extends AbstractC0484a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f3307a;
    public int b;

    @Override // g3.AbstractC0484a
    public final int a() {
        return this.b;
    }

    @Override // g3.AbstractC0484a
    public final void b(int i, C0148k c0148k) {
        Object[] objArr = this.f3307a;
        if (objArr.length <= i) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length * 2);
            kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f3307a = objArrCopyOf;
        }
        Object[] objArr2 = this.f3307a;
        if (objArr2[i] == null) {
            this.b++;
        }
        objArr2[i] = c0148k;
    }

    @Override // g3.AbstractC0484a
    public final Object get(int i) {
        return kotlin.collections.j.D(i, this.f3307a);
    }

    @Override // g3.AbstractC0484a, java.lang.Iterable
    public final Iterator iterator() {
        return new C0485b(this);
    }
}
