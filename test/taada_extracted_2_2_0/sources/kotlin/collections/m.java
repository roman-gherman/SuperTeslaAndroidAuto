package kotlin.collections;

import A2.C0022d;
import e2.C0430f;
import io.ktor.utils.io.Z;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends s {
    public static final int J(int i, List list) {
        if (new C0430f(0, n.x(list), 1).b(i)) {
            return n.x(list) - i;
        }
        StringBuilder sbJ = B2.b.j(i, "Element index ", " must be in range [");
        sbJ.append(new C0430f(0, n.x(list), 1));
        sbJ.append("].");
        throw new IndexOutOfBoundsException(sbJ.toString());
    }

    public static k3.n K(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        return new k3.n(iterable, 3);
    }

    public static boolean L(Object obj, Iterable iterable) {
        int iIndexOf;
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i < 0) {
                    n.C();
                    throw null;
                }
                if (kotlin.jvm.internal.h.a(obj, next)) {
                    iIndexOf = i;
                    break;
                }
                i++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static List M(List list) {
        int size = list.size() - 1;
        if (size <= 0) {
            return u.f3805a;
        }
        if (size == 1) {
            return Z.p(W(list));
        }
        ArrayList arrayList = new ArrayList(size);
        if (list instanceof RandomAccess) {
            int size2 = list.size();
            for (int i = 1; i < size2; i++) {
                arrayList.add(list.get(i));
            }
        } else {
            ListIterator listIterator = list.listIterator(1);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static List N(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        int size = list.size() - 1;
        if (size < 0) {
            size = 0;
        }
        return l0(size, list);
    }

    public static Object O(Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        if (collection instanceof List) {
            return P((List) collection);
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object P(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object Q(Iterable iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object R(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object S(int i, List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (i < 0 || i > n.x(list)) {
            return null;
        }
        return list.get(i);
    }

    public static final void T(Iterable iterable, StringBuilder buffer, CharSequence charSequence, CharSequence prefix, CharSequence postfix, CharSequence charSequence2, Function1 function1) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(buffer, "buffer");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        kotlin.jvm.internal.h.f(postfix, "postfix");
        buffer.append(prefix);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                buffer.append(charSequence);
            }
            k1.j.c(buffer, obj, function1);
        }
        buffer.append(postfix);
    }

    public static /* synthetic */ void U(Collection collection, StringBuilder sb, String str, String str2, String str3, Function1 function1, int i) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            str3 = "";
        }
        if ((i & 64) != 0) {
            function1 = null;
        }
        T(collection, sb, str, str2, str3, "...", function1);
    }

    public static String V(Iterable iterable, String str, String str2, String str3, Function1 function1, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            function1 = null;
        }
        kotlin.jvm.internal.h.f(iterable, "<this>");
        StringBuilder sb = new StringBuilder();
        T(iterable, sb, str4, str5, str6, "...", function1);
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static Object W(Collection collection) {
        if (collection instanceof List) {
            return X((List) collection);
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object X(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(n.x(list));
    }

    public static Object Y(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return B2.b.b(1, list);
    }

    public static Comparable Z(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static ArrayList a0(Iterable iterable, Iterable iterable2) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return b0(iterable2, (Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        s.F(iterable, arrayList);
        s.F(iterable2, arrayList);
        return arrayList;
    }

    public static ArrayList b0(Iterable elements, Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        kotlin.jvm.internal.h.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            s.F(elements, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList c0(Object obj, Iterable iterable) {
        if (iterable instanceof Collection) {
            return d0(obj, (Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        s.F(iterable, arrayList);
        arrayList.add(obj);
        return arrayList;
    }

    public static ArrayList d0(Object obj, Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static List e0(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return o0(iterable);
        }
        List listQ0 = q0(iterable);
        Collections.reverse(listQ0);
        return listQ0;
    }

    public static Object f0(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof List) {
            return g0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static Object g0(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object h0(Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        if (collection instanceof List) {
            List list = (List) collection;
            if (list.size() == 1) {
                return list.get(0);
            }
            return null;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static Object i0(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List j0(AbstractList abstractList) {
        if (abstractList.size() <= 1) {
            return o0(abstractList);
        }
        Object[] array = abstractList.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        kotlin.jvm.internal.h.f(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return j.t(array);
    }

    public static List k0(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listQ0 = q0(iterable);
            r.E(listQ0, comparator);
            return listQ0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return o0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        kotlin.jvm.internal.h.f(array, "<this>");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return j.t(array);
    }

    public static List l0(int i, List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(B2.b.d(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return u.f3805a;
        }
        if (i >= list.size()) {
            return o0(list);
        }
        if (i == 1) {
            return Z.p(O(list));
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i3++;
            if (i3 == i) {
                break;
            }
        }
        return n.B(arrayList);
    }

    public static final void m0(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] n0(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        int[] iArr = new int[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List o0(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n.B(q0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return u.f3805a;
        }
        if (size != 1) {
            return p0(collection);
        }
        return Z.p(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static ArrayList p0(Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final List q0(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return p0((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        m0(iterable, arrayList);
        return arrayList;
    }

    public static Set r0(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m0(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set s0(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        boolean z6 = iterable instanceof Collection;
        w wVar = w.f3807a;
        if (z6) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return io.ktor.utils.io.internal.t.p(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(B.F(collection.size()));
                m0(iterable, linkedHashSet);
                return linkedHashSet;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            m0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                return size2 != 1 ? linkedHashSet2 : io.ktor.utils.io.internal.t.p(linkedHashSet2.iterator().next());
            }
        }
        return wVar;
    }

    public static k3.q t0(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        return new k3.q(new C0022d(list, 24));
    }

    public static ArrayList u0(Collection collection, Collection other) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        Iterator it = collection.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(o.D(collection), o.D(other)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new N1.e(it.next(), it2.next()));
        }
        return arrayList;
    }
}
