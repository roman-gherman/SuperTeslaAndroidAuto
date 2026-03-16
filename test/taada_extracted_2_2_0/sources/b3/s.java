package b3;

import A2.C0022d;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import a3.C;
import a3.C0142e;
import a3.C0148k;
import a3.C0161y;
import a3.F;
import a3.M;
import a3.c0;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.u;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f1711a = new s();

    public static ArrayList a(AbstractCollection abstractCollection, Function2 function2) {
        ArrayList arrayList = new ArrayList(abstractCollection);
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.h.e(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            F upper = (F) it.next();
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    F lower = (F) it2.next();
                    if (lower != upper) {
                        kotlin.jvm.internal.h.e(lower, "lower");
                        kotlin.jvm.internal.h.e(upper, "upper");
                        if (((Boolean) function2.mo5invoke(lower, upper)).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [a3.M] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [a3.M, g3.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v16, types: [a3.F] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [a3.F, a3.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.Set] */
    public final F b(ArrayList arrayList) {
        F f6;
        F fA;
        arrayList.size();
        ArrayList<F> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            F f7 = (F) it.next();
            if (f7.c() instanceof C0161y) {
                Collection<AbstractC0162z> supertypes = f7.c().getSupertypes();
                kotlin.jvm.internal.h.e(supertypes, "type.constructor.supertypes");
                ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(supertypes));
                for (AbstractC0162z it2 : supertypes) {
                    kotlin.jvm.internal.h.e(it2, "it");
                    F fJ0 = AbstractC0132a.j0(it2);
                    if (f7.d()) {
                        fJ0 = fJ0.g(true);
                    }
                    arrayList3.add(fJ0);
                }
                arrayList2.addAll(arrayList3);
            } else {
                arrayList2.add(f7);
            }
        }
        q qVarA = q.f1709a;
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            qVarA = qVarA.a((c0) it3.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (F fG : arrayList2) {
            if (qVarA == q.d) {
                if (fG instanceof f) {
                    f fVar = (f) fG;
                    kotlin.jvm.internal.h.f(fVar, "<this>");
                    fG = new f(fVar.b, fVar.c, fVar.d, fVar.e, fVar.f1701f, true);
                }
                kotlin.jvm.internal.h.f(fG, "<this>");
                F fO = C0142e.o(fG, false);
                fG = (fO == null && (fO = C5.f.T(fG)) == null) ? fG.g(false) : fO;
            }
            linkedHashSet.add(fG);
        }
        ArrayList arrayList4 = new ArrayList(kotlin.collections.o.D(arrayList));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((F) it4.next()).b());
        }
        Iterator it5 = arrayList4.iterator();
        if (!it5.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        ?? next = it5.next();
        while (it5.hasNext()) {
            M other = (M) it5.next();
            next = (M) next;
            next.getClass();
            kotlin.jvm.internal.h.f(other, "other");
            if (!next.isEmpty() || !other.isEmpty()) {
                ArrayList arrayList5 = new ArrayList();
                Collection collectionValues = ((ConcurrentHashMap) M.b.b).values();
                kotlin.jvm.internal.h.e(collectionValues, "idPerType.values");
                Iterator it6 = collectionValues.iterator();
                while (it6.hasNext()) {
                    int iIntValue = ((Number) it6.next()).intValue();
                    C0148k c0148k = (C0148k) next.f3309a.get(iIntValue);
                    C0148k c0148k2 = (C0148k) other.f3309a.get(iIntValue);
                    if (c0148k != null) {
                        if (!kotlin.jvm.internal.h.a(c0148k2, c0148k)) {
                            c0148k = null;
                        }
                        c0148k2 = c0148k;
                    } else if (c0148k2 == null || !kotlin.jvm.internal.h.a(c0148k, c0148k2)) {
                        c0148k2 = null;
                    }
                    if (c0148k2 != null) {
                        arrayList5.add(c0148k2);
                    }
                }
                next = B.h.b(arrayList5);
            }
        }
        M m6 = (M) next;
        if (linkedHashSet.size() == 1) {
            fA = (F) kotlin.collections.m.f0(linkedHashSet);
        } else {
            new C0022d(linkedHashSet, 14);
            ArrayList arrayListA = a(linkedHashSet, new r(2, 0, this));
            arrayListA.isEmpty();
            if (arrayListA.isEmpty()) {
                f6 = null;
            } else {
                Iterator it7 = arrayListA.iterator();
                if (!it7.hasNext()) {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
                ?? next2 = it7.next();
                while (it7.hasNext()) {
                    F f8 = (F) it7.next();
                    next2 = (F) next2;
                    if (next2 != 0 && f8 != null) {
                        TypeConstructor typeConstructorC = next2.c();
                        TypeConstructor typeConstructorC2 = f8.c();
                        boolean z6 = typeConstructorC instanceof P2.m;
                        if (z6 && (typeConstructorC2 instanceof P2.m)) {
                            Set set = ((P2.m) typeConstructorC).f1220a;
                            Set other2 = ((P2.m) typeConstructorC2).f1220a;
                            kotlin.jvm.internal.h.f(set, "<this>");
                            kotlin.jvm.internal.h.f(other2, "other");
                            Set setR0 = kotlin.collections.m.r0(set);
                            kotlin.collections.s.F(other2, setR0);
                            P2.m mVar = new P2.m(setR0);
                            M.b.getClass();
                            M attributes = M.c;
                            kotlin.jvm.internal.h.f(attributes, "attributes");
                            next2 = C.d(attributes, u.f3805a, c3.j.a(2, true, "unknown integer literal type"), mVar, false);
                        } else if (z6) {
                            if (!((P2.m) typeConstructorC).f1220a.contains(f8)) {
                                f8 = null;
                            }
                            next2 = f8;
                        } else if (!(typeConstructorC2 instanceof P2.m) || !((P2.m) typeConstructorC2).f1220a.contains(next2)) {
                        }
                    }
                    next2 = 0;
                }
                f6 = (F) next2;
            }
            if (f6 != null) {
                fA = f6;
            } else {
                NewKotlinTypeChecker.Companion.getClass();
                ArrayList arrayListA2 = a(arrayListA, new r(2, 1, i.b));
                arrayListA2.isEmpty();
                fA = arrayListA2.size() < 2 ? (F) kotlin.collections.m.f0(arrayListA2) : new C0161y(linkedHashSet).a();
            }
        }
        return fA.i(m6);
    }
}
