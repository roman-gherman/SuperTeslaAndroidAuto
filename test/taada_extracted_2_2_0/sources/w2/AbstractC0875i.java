package w2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: w2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0875i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5013a;
    public static final LinkedHashMap b;
    public static final Set c;
    public static final Set d;

    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, java.util.Map] */
    static {
        L2.e eVar = k2.o.f3750j;
        L2.c cVarG = eVar.b(L2.f.e("name")).g();
        kotlin.jvm.internal.h.e(cVarG, "child(Name.identifier(name)).toSafe()");
        N1.e eVar2 = new N1.e(cVarG, L2.f.e("name"));
        L2.c cVarG2 = eVar.b(L2.f.e("ordinal")).g();
        kotlin.jvm.internal.h.e(cVarG2, "child(Name.identifier(name)).toSafe()");
        N1.e eVar3 = new N1.e(cVarG2, L2.f.e("ordinal"));
        N1.e eVar4 = new N1.e(k2.o.f3726B.c(L2.f.e("size")), L2.f.e("size"));
        L2.c cVar = k2.o.f3728F;
        N1.e eVar5 = new N1.e(cVar.c(L2.f.e("size")), L2.f.e("size"));
        L2.c cVarG3 = k2.o.e.b(L2.f.e("length")).g();
        kotlin.jvm.internal.h.e(cVarG3, "child(Name.identifier(name)).toSafe()");
        Map mapI = kotlin.collections.A.I(eVar2, eVar3, eVar4, eVar5, new N1.e(cVarG3, L2.f.e("length")), new N1.e(cVar.c(L2.f.e("keys")), L2.f.e("keySet")), new N1.e(cVar.c(L2.f.e("values")), L2.f.e("values")), new N1.e(cVar.c(L2.f.e("entries")), L2.f.e("entrySet")));
        f5013a = mapI;
        Set<Map.Entry> setEntrySet = mapI.entrySet();
        ArrayList<N1.e> arrayList = new ArrayList(kotlin.collections.o.D(setEntrySet));
        for (Map.Entry entry : setEntrySet) {
            arrayList.add(new N1.e(((L2.c) entry.getKey()).f(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (N1.e eVar6 : arrayList) {
            L2.f fVar = (L2.f) eVar6.b;
            Object arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            ((List) arrayList2).add((L2.f) eVar6.f1121a);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.collections.B.F(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Iterable iterable = (Iterable) entry2.getValue();
            kotlin.jvm.internal.h.f(iterable, "<this>");
            linkedHashMap2.put(key, kotlin.collections.m.o0(kotlin.collections.m.r0(iterable)));
        }
        b = linkedHashMap2;
        Set setKeySet = f5013a.keySet();
        c = setKeySet;
        ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(setKeySet));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList3.add(((L2.c) it.next()).f());
        }
        d = kotlin.collections.m.s0(arrayList3);
    }
}
