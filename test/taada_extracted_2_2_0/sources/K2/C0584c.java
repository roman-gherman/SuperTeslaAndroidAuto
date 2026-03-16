package k2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: renamed from: k2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0584c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f3704a;

    static {
        Set<k> set = k.e;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(set));
        for (k primitiveType : set) {
            kotlin.jvm.internal.h.f(primitiveType, "primitiveType");
            arrayList.add(p.f3768k.c(primitiveType.f3721a));
        }
        L2.c cVarG = o.f3747f.g();
        kotlin.jvm.internal.h.e(cVarG, "string.toSafe()");
        ArrayList arrayListD0 = kotlin.collections.m.d0(cVarG, arrayList);
        L2.c cVarG2 = o.f3749h.g();
        kotlin.jvm.internal.h.e(cVarG2, "_boolean.toSafe()");
        ArrayList arrayListD02 = kotlin.collections.m.d0(cVarG2, arrayListD0);
        L2.c cVarG3 = o.f3750j.g();
        kotlin.jvm.internal.h.e(cVarG3, "_enum.toSafe()");
        ArrayList arrayListD03 = kotlin.collections.m.d0(cVarG3, arrayListD02);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayListD03.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(L2.b.j((L2.c) it.next()));
        }
        f3704a = linkedHashSet;
    }
}
