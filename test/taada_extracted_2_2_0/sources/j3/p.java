package j3;

import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;
import kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p implements DFS$NodeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f3675a = new n();

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static final List b(ArrayList arrayList) {
        kotlin.jvm.internal.h.f(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return u.f3805a;
        }
        if (size == 1) {
            return Z.p(kotlin.collections.m.P(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static Object c(List list, DFS$Neighbors dFS$Neighbors, p pVar) {
        B.g gVar = new B.g(29);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d(it.next(), dFS$Neighbors, gVar, pVar);
        }
        return pVar.result();
    }

    public static void d(Object obj, DFS$Neighbors dFS$Neighbors, B.g gVar, p pVar) {
        if (obj == null) {
            a(22);
            throw null;
        }
        if (((HashSet) gVar.b).add(obj) && pVar.beforeChildren(obj)) {
            Iterator it = dFS$Neighbors.getNeighbors(obj).iterator();
            while (it.hasNext()) {
                d(it.next(), dFS$Neighbors, gVar, pVar);
            }
            pVar.afterChildren(obj);
        }
    }

    public static Boolean e(List list, DFS$Neighbors dFS$Neighbors, Function1 function1) {
        if (function1 != null) {
            return (Boolean) c(list, dFS$Neighbors, new R2.c(function1, new boolean[1]));
        }
        a(9);
        throw null;
    }

    public static final boolean f(Throwable th) {
        Class<?> superclass = th.getClass();
        while (!kotlin.jvm.internal.h.a(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final K2.f g(X2.h hVar) {
        kotlin.jvm.internal.h.f(hVar, "<this>");
        return K2.f.f938g;
    }

    public static void h(Object obj) throws Throwable {
        if (obj instanceof o) {
            throw ((o) obj).f3674a;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler
    public void afterChildren(Object obj) {
    }
}
