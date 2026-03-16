package w2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f4993a;
    public static final ArrayList b;
    public static final Object c;
    public static final LinkedHashMap d;
    public static final Set e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f4994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final K f4995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f4996h;
    public static final LinkedHashMap i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArrayList f4997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final LinkedHashMap f4998k;

    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Object, java.util.Map] */
    static {
        Set<String> setN = kotlin.collections.j.N(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(setN));
        for (String str : setN) {
            String strC = S2.b.BOOLEAN.c();
            kotlin.jvm.internal.h.e(strC, "BOOLEAN.desc");
            arrayList.add(r.a("java/util/Collection", str, "Ljava/util/Collection;", strC));
        }
        f4993a = arrayList;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((K) it.next()).b);
        }
        b = arrayList2;
        ArrayList arrayList3 = f4993a;
        ArrayList arrayList4 = new ArrayList(kotlin.collections.o.D(arrayList3));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((K) it2.next()).f4990a.b());
        }
        String strConcat = "java/util/".concat("Collection");
        S2.b bVar = S2.b.BOOLEAN;
        String strC2 = bVar.c();
        kotlin.jvm.internal.h.e(strC2, "BOOLEAN.desc");
        K kA = r.a(strConcat, "contains", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, strC2);
        M m6 = M.d;
        N1.e eVar = new N1.e(kA, m6);
        String strConcat2 = "java/util/".concat("Collection");
        String strC3 = bVar.c();
        kotlin.jvm.internal.h.e(strC3, "BOOLEAN.desc");
        N1.e eVar2 = new N1.e(r.a(strConcat2, "remove", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, strC3), m6);
        String strConcat3 = "java/util/".concat("Map");
        String strC4 = bVar.c();
        kotlin.jvm.internal.h.e(strC4, "BOOLEAN.desc");
        N1.e eVar3 = new N1.e(r.a(strConcat3, "containsKey", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, strC4), m6);
        String strConcat4 = "java/util/".concat("Map");
        String strC5 = bVar.c();
        kotlin.jvm.internal.h.e(strC5, "BOOLEAN.desc");
        N1.e eVar4 = new N1.e(r.a(strConcat4, "containsValue", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, strC5), m6);
        String strConcat5 = "java/util/".concat("Map");
        String strC6 = bVar.c();
        kotlin.jvm.internal.h.e(strC6, "BOOLEAN.desc");
        N1.e eVar5 = new N1.e(r.a(strConcat5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", strC6), m6);
        N1.e eVar6 = new N1.e(r.a("java/util/".concat("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR), M.e);
        K kA2 = r.a("java/util/".concat("Map"), "get", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR);
        M m7 = M.b;
        N1.e eVar7 = new N1.e(kA2, m7);
        N1.e eVar8 = new N1.e(r.a("java/util/".concat("Map"), "remove", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR), m7);
        String strConcat6 = "java/util/".concat("List");
        S2.b bVar2 = S2.b.INT;
        String strC7 = bVar2.c();
        kotlin.jvm.internal.h.e(strC7, "INT.desc");
        K kA3 = r.a(strConcat6, "indexOf", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, strC7);
        M m8 = M.c;
        N1.e eVar9 = new N1.e(kA3, m8);
        String strConcat7 = "java/util/".concat("List");
        String strC8 = bVar2.c();
        kotlin.jvm.internal.h.e(strC8, "INT.desc");
        Map mapI = kotlin.collections.A.I(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, new N1.e(r.a(strConcat7, "lastIndexOf", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, strC8), m8));
        c = mapI;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.B.F(mapI.size()));
        for (Map.Entry entry : mapI.entrySet()) {
            linkedHashMap.put(((K) entry.getKey()).b, entry.getValue());
        }
        d = linkedHashMap;
        LinkedHashSet linkedHashSetW = kotlin.collections.E.w(c.keySet(), f4993a);
        ArrayList arrayList5 = new ArrayList(kotlin.collections.o.D(linkedHashSetW));
        Iterator it3 = linkedHashSetW.iterator();
        while (it3.hasNext()) {
            arrayList5.add(((K) it3.next()).f4990a);
        }
        e = kotlin.collections.m.s0(arrayList5);
        ArrayList arrayList6 = new ArrayList(kotlin.collections.o.D(linkedHashSetW));
        Iterator it4 = linkedHashSetW.iterator();
        while (it4.hasNext()) {
            arrayList6.add(((K) it4.next()).b);
        }
        f4994f = kotlin.collections.m.s0(arrayList6);
        S2.b bVar3 = S2.b.INT;
        String strC9 = bVar3.c();
        kotlin.jvm.internal.h.e(strC9, "INT.desc");
        K kA4 = r.a("java/util/List", "removeAt", strC9, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR);
        f4995g = kA4;
        String strConcat8 = "java/lang/".concat("Number");
        String strC10 = S2.b.BYTE.c();
        kotlin.jvm.internal.h.e(strC10, "BYTE.desc");
        N1.e eVar10 = new N1.e(r.a(strConcat8, "toByte", "", strC10), L2.f.e("byteValue"));
        String strConcat9 = "java/lang/".concat("Number");
        String strC11 = S2.b.SHORT.c();
        kotlin.jvm.internal.h.e(strC11, "SHORT.desc");
        N1.e eVar11 = new N1.e(r.a(strConcat9, "toShort", "", strC11), L2.f.e("shortValue"));
        String strConcat10 = "java/lang/".concat("Number");
        String strC12 = bVar3.c();
        kotlin.jvm.internal.h.e(strC12, "INT.desc");
        N1.e eVar12 = new N1.e(r.a(strConcat10, "toInt", "", strC12), L2.f.e("intValue"));
        String strConcat11 = "java/lang/".concat("Number");
        String strC13 = S2.b.LONG.c();
        kotlin.jvm.internal.h.e(strC13, "LONG.desc");
        N1.e eVar13 = new N1.e(r.a(strConcat11, "toLong", "", strC13), L2.f.e("longValue"));
        String strConcat12 = "java/lang/".concat("Number");
        String strC14 = S2.b.FLOAT.c();
        kotlin.jvm.internal.h.e(strC14, "FLOAT.desc");
        N1.e eVar14 = new N1.e(r.a(strConcat12, "toFloat", "", strC14), L2.f.e("floatValue"));
        String strConcat13 = "java/lang/".concat("Number");
        String strC15 = S2.b.DOUBLE.c();
        kotlin.jvm.internal.h.e(strC15, "DOUBLE.desc");
        N1.e eVar15 = new N1.e(r.a(strConcat13, "toDouble", "", strC15), L2.f.e("doubleValue"));
        N1.e eVar16 = new N1.e(kA4, L2.f.e("remove"));
        String strConcat14 = "java/lang/".concat("CharSequence");
        String strC16 = bVar3.c();
        kotlin.jvm.internal.h.e(strC16, "INT.desc");
        String strC17 = S2.b.CHAR.c();
        kotlin.jvm.internal.h.e(strC17, "CHAR.desc");
        Map mapI2 = kotlin.collections.A.I(eVar10, eVar11, eVar12, eVar13, eVar14, eVar15, eVar16, new N1.e(r.a(strConcat14, "get", strC16, strC17), L2.f.e("charAt")));
        f4996h = mapI2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.collections.B.F(mapI2.size()));
        for (Map.Entry entry2 : mapI2.entrySet()) {
            linkedHashMap2.put(((K) entry2.getKey()).b, entry2.getValue());
        }
        i = linkedHashMap2;
        Set setKeySet = f4996h.keySet();
        ArrayList arrayList7 = new ArrayList(kotlin.collections.o.D(setKeySet));
        Iterator it5 = setKeySet.iterator();
        while (it5.hasNext()) {
            arrayList7.add(((K) it5.next()).f4990a);
        }
        f4997j = arrayList7;
        Set<Map.Entry> setEntrySet = f4996h.entrySet();
        ArrayList<N1.e> arrayList8 = new ArrayList(kotlin.collections.o.D(setEntrySet));
        for (Map.Entry entry3 : setEntrySet) {
            arrayList8.add(new N1.e(((K) entry3.getKey()).f4990a, entry3.getValue()));
        }
        int iF = kotlin.collections.B.F(kotlin.collections.o.D(arrayList8));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iF);
        for (N1.e eVar17 : arrayList8) {
            linkedHashMap3.put((L2.f) eVar17.b, (L2.f) eVar17.f1121a);
        }
        f4998k = linkedHashMap3;
    }
}
