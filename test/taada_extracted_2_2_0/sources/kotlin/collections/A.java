package kotlin.collections;

import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A extends B {
    public static Object H(Map map, Comparable comparable) {
        kotlin.jvm.internal.h.f(map, "<this>");
        if (map instanceof MapWithDefault) {
            return ((MapWithDefault) map).getOrImplicitDefault(comparable);
        }
        Object obj = map.get(comparable);
        if (obj != null || map.containsKey(comparable)) {
            return obj;
        }
        throw new NoSuchElementException("Key " + comparable + " is missing in the map.");
    }

    public static Map I(N1.e... eVarArr) {
        if (eVarArr.length <= 0) {
            return v.f3806a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(B.F(eVarArr.length));
        J(linkedHashMap, eVarArr);
        return linkedHashMap;
    }

    public static final void J(HashMap map, N1.e[] eVarArr) {
        for (N1.e eVar : eVarArr) {
            map.put(eVar.f1121a, eVar.b);
        }
    }

    public static List K(Map map) {
        kotlin.jvm.internal.h.f(map, "<this>");
        int size = map.size();
        u uVar = u.f3805a;
        if (size == 0) {
            return uVar;
        }
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return uVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (!it.hasNext()) {
            return Z.p(new N1.e(entry.getKey(), entry.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new N1.e(entry.getKey(), entry.getValue()));
        do {
            Map.Entry entry2 = (Map.Entry) it.next();
            arrayList.add(new N1.e(entry2.getKey(), entry2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    public static Map L(List list) {
        v vVar = v.f3806a;
        int size = list.size();
        if (size == 0) {
            return vVar;
        }
        if (size == 1) {
            return B.G((N1.e) list.get(0));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(B.F(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            N1.e eVar = (N1.e) it.next();
            linkedHashMap.put(eVar.f1121a, eVar.b);
        }
        return linkedHashMap;
    }

    public static Map M(Map map) {
        kotlin.jvm.internal.h.f(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return v.f3806a;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        kotlin.jvm.internal.h.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.h.e(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
