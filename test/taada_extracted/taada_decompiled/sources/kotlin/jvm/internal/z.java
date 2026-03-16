package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    public static Collection a(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableCollection)) {
            f(obj, "kotlin.collections.MutableCollection");
            throw null;
        }
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            h.l(e, z.class.getName());
            throw e;
        }
    }

    public static Map b(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableMap)) {
            f(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            h.l(e, z.class.getName());
            throw e;
        }
    }

    public static Set c(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableSet)) {
            f(obj, "kotlin.collections.MutableSet");
            throw null;
        }
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            h.l(e, z.class.getName());
            throw e;
        }
    }

    public static void d(int i, Object obj) {
        if (obj == null || e(i, obj)) {
            return;
        }
        f(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static boolean e(int i, Object obj) {
        if (obj instanceof Function) {
            if ((obj instanceof FunctionBase ? ((FunctionBase) obj).getArity() : obj instanceof Function0 ? 0 : obj instanceof Function1 ? 1 : obj instanceof Function2 ? 2 : obj instanceof Function3 ? 3 : obj instanceof Function4 ? 4 : obj instanceof Function5 ? 5 : obj instanceof Function6 ? 6 : obj instanceof Function7 ? 7 : obj instanceof Function8 ? 8 : obj instanceof Function9 ? 9 : obj instanceof Function10 ? 10 : obj instanceof Function11 ? 11 : obj instanceof Function12 ? 12 : obj instanceof Function13 ? 13 : obj instanceof Function14 ? 14 : obj instanceof Function15 ? 15 : obj instanceof Function16 ? 16 : obj instanceof Function17 ? 17 : obj instanceof Function18 ? 18 : obj instanceof Function19 ? 19 : obj instanceof Function20 ? 20 : obj instanceof Function21 ? 21 : obj instanceof Function22 ? 22 : -1) == i) {
                return true;
            }
        }
        return false;
    }

    public static void f(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(B2.b.f(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        h.l(classCastException, z.class.getName());
        throw classCastException;
    }
}
