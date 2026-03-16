package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E extends io.ktor.utils.io.internal.t {
    public static LinkedHashSet u(Set set, Object obj) {
        kotlin.jvm.internal.h.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(B.F(set.size()));
        boolean z6 = false;
        for (Object obj2 : set) {
            boolean z7 = true;
            if (!z6 && kotlin.jvm.internal.h.a(obj2, obj)) {
                z6 = true;
                z7 = false;
            }
            if (z7) {
                linkedHashSet.add(obj2);
            }
        }
        return linkedHashSet;
    }

    public static LinkedHashSet v(Set set, Object obj) {
        kotlin.jvm.internal.h.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(B.F(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }

    public static LinkedHashSet w(Set set, Collection elements) {
        kotlin.jvm.internal.h.f(set, "<this>");
        kotlin.jvm.internal.h.f(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(B.F(set.size() + Integer.valueOf(elements.size()).intValue()));
        linkedHashSet.addAll(set);
        s.F(elements, linkedHashSet);
        return linkedHashSet;
    }

    public static Set x(Object... objArr) {
        return objArr.length > 0 ? j.N(objArr) : w.f3806a;
    }
}
