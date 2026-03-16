package L2;

import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.B;
import kotlin.collections.E;
import kotlin.collections.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f967a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f970h;
    public static final b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f975n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Set f976o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set f977p;
    public static final b q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b f978r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b f979s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final b f980t;

    static {
        c cVar = new c("kotlin");
        f967a = cVar;
        c cVarC = cVar.c(f.e("reflect"));
        b = cVarC;
        c cVarC2 = cVar.c(f.e("collections"));
        c = cVarC2;
        c cVarC3 = cVar.c(f.e("ranges"));
        d = cVarC3;
        cVar.c(f.e("jvm")).c(f.e("internal"));
        c cVarC4 = cVar.c(f.e("annotation"));
        e = cVarC4;
        c cVarC5 = cVar.c(f.e("internal"));
        cVarC5.c(f.e("ir"));
        c cVarC6 = cVar.c(f.e("coroutines"));
        f968f = cVarC6;
        f969g = cVar.c(f.e("enums"));
        E.x(cVar, cVarC2, cVarC3, cVarC4, cVarC, cVarC5, cVarC6);
        j.a("Nothing");
        j.a("Unit");
        j.a("Any");
        j.a("Enum");
        j.a("Annotation");
        f970h = j.a("Array");
        b bVarA = j.a("Boolean");
        b bVarA2 = j.a("Char");
        b bVarA3 = j.a("Byte");
        b bVarA4 = j.a("Short");
        b bVarA5 = j.a("Int");
        b bVarA6 = j.a("Long");
        b bVarA7 = j.a("Float");
        b bVarA8 = j.a("Double");
        i = j.f(bVarA3);
        f971j = j.f(bVarA4);
        f972k = j.f(bVarA5);
        f973l = j.f(bVarA6);
        j.a("CharSequence");
        f974m = j.a("String");
        j.a("Throwable");
        j.a("Cloneable");
        j.e("KProperty");
        j.e("KMutableProperty");
        j.e("KProperty0");
        j.e("KMutableProperty0");
        j.e("KProperty1");
        j.e("KMutableProperty1");
        j.e("KProperty2");
        j.e("KMutableProperty2");
        f975n = j.e("KFunction");
        j.e("KClass");
        j.e("KCallable");
        j.a("Comparable");
        j.a("Number");
        j.a("Function");
        Set setN = kotlin.collections.j.N(new b[]{bVarA, bVarA2, bVarA3, bVarA4, bVarA5, bVarA6, bVarA7, bVarA8});
        f976o = setN;
        int iF = B.F(o.D(setN));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        for (Object obj : setN) {
            f fVarI = ((b) obj).i();
            kotlin.jvm.internal.h.e(fVarI, "id.shortClassName");
            linkedHashMap.put(obj, j.d(fVarI));
        }
        j.c(linkedHashMap);
        Set setN2 = kotlin.collections.j.N(new b[]{i, f971j, f972k, f973l});
        f977p = setN2;
        int iF2 = B.F(o.D(setN2));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iF2 >= 16 ? iF2 : 16);
        for (Object obj2 : setN2) {
            f fVarI2 = ((b) obj2).i();
            kotlin.jvm.internal.h.e(fVarI2, "id.shortClassName");
            linkedHashMap2.put(obj2, j.d(fVarI2));
        }
        j.c(linkedHashMap2);
        E.v(E.w(f976o, f977p), f974m);
        c cVar2 = f968f;
        f fVarE = f.e("Continuation");
        if (cVar2 == null) {
            b.a(3);
            throw null;
        }
        c.j(fVarE);
        j.b("Iterator");
        j.b("Iterable");
        j.b("Collection");
        j.b("List");
        j.b("ListIterator");
        j.b("Set");
        b bVarB = j.b("Map");
        j.b("MutableIterator");
        j.b("CharIterator");
        j.b("MutableIterable");
        j.b("MutableCollection");
        q = j.b("MutableList");
        j.b("MutableListIterator");
        f978r = j.b("MutableSet");
        b bVarB2 = j.b("MutableMap");
        f979s = bVarB2;
        bVarB.d(f.e("Entry"));
        bVarB2.d(f.e("MutableEntry"));
        j.a("Result");
        c cVar3 = d;
        f fVarE2 = f.e("IntRange");
        if (cVar3 == null) {
            b.a(3);
            throw null;
        }
        c.j(fVarE2);
        c.j(f.e("LongRange"));
        c.j(f.e("CharRange"));
        c cVar4 = e;
        f fVarE3 = f.e("AnnotationRetention");
        if (cVar4 == null) {
            b.a(3);
            throw null;
        }
        c.j(fVarE3);
        c.j(f.e("AnnotationTarget"));
        f980t = new b(f969g, f.e("EnumEntries"));
    }
}
