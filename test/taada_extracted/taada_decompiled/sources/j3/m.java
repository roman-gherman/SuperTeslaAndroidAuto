package j3;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.B;
import kotlin.jvm.internal.z;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends AbstractSet {
    public static final /* synthetic */ int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3672a;
    public int b;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        Object obj2;
        int i = this.b;
        if (i == 0) {
            this.f3672a = obj;
        } else if (i == 1) {
            if (kotlin.jvm.internal.h.a(this.f3672a, obj)) {
                return false;
            }
            this.f3672a = new Object[]{this.f3672a, obj};
        } else if (i < 5) {
            Object obj3 = this.f3672a;
            kotlin.jvm.internal.h.d(obj3, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr = (Object[]) obj3;
            if (kotlin.collections.j.v(obj, objArr)) {
                return false;
            }
            int i3 = this.b;
            if (i3 == 4) {
                Object[] elements = Arrays.copyOf(objArr, objArr.length);
                kotlin.jvm.internal.h.f(elements, "elements");
                LinkedHashSet linkedHashSet = new LinkedHashSet(B.F(elements.length));
                kotlin.collections.j.K(elements, linkedHashSet);
                linkedHashSet.add(obj);
                obj2 = linkedHashSet;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, i3 + 1);
                kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = obj;
                obj2 = objArrCopyOf;
            }
            this.f3672a = obj2;
        } else {
            Object obj4 = this.f3672a;
            kotlin.jvm.internal.h.d(obj4, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!z.c(obj4).add(obj)) {
                return false;
            }
        }
        this.b++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f3672a = null;
        this.b = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int i = this.b;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            return kotlin.jvm.internal.h.a(this.f3672a, obj);
        }
        if (i < 5) {
            Object obj2 = this.f3672a;
            kotlin.jvm.internal.h.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return kotlin.collections.j.v(obj, (Object[]) obj2);
        }
        Object obj3 = this.f3672a;
        kotlin.jvm.internal.h.d(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.b;
        if (i == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (i == 1) {
            return new l(this.f3672a);
        }
        if (i < 5) {
            Object obj = this.f3672a;
            kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new k((Object[]) obj);
        }
        Object obj2 = this.f3672a;
        kotlin.jvm.internal.h.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return z.c(obj2).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b;
    }
}
