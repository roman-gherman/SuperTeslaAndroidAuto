package w2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: w2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0881o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f5017a;
    public static final Map b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f5017a = linkedHashMap;
        b(L2.i.q, a("java.util.ArrayList", "java.util.LinkedList"));
        b(L2.i.f978r, a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        b(L2.i.f979s, a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b(L2.b.j(new L2.c("java.util.function.Function")), a("java.util.function.UnaryOperator"));
        b(L2.b.j(new L2.c("java.util.function.BiFunction")), a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(new N1.e(((L2.b) entry.getKey()).b(), ((L2.b) entry.getValue()).b()));
        }
        b = kotlin.collections.A.L(arrayList);
    }

    public static ArrayList a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(L2.b.j(new L2.c(str)));
        }
        return arrayList;
    }

    public static void b(L2.b bVar, ArrayList arrayList) {
        for (Object obj : arrayList) {
            f5017a.put(obj, bVar);
        }
    }
}
