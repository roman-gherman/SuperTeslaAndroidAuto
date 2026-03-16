package kotlin.collections;

import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends k1.j {
    public static Object A(Object[] objArr) {
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object B(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static Integer C(int i, int[] iArr) {
        kotlin.jvm.internal.h.f(iArr, "<this>");
        if (i < 0 || i > iArr.length - 1) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static Object D(int i, Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        if (i < 0 || i > objArr.length - 1) {
            return null;
        }
        return objArr[i];
    }

    public static int E(Object obj, Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final void F(Object[] objArr, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Function1 function1) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : objArr) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            k1.j.c(sb, obj, function1);
        }
        sb.append(charSequence3);
    }

    public static String G(Object[] objArr, String str, String str2, Function1 function1, int i) {
        String str3 = (i & 1) != 0 ? ", " : "";
        String str4 = (i & 2) != 0 ? "" : str;
        String str5 = (i & 4) != 0 ? "" : str2;
        if ((i & 32) != 0) {
            function1 = null;
        }
        StringBuilder sb = new StringBuilder();
        F(objArr, sb, str3, str4, str5, "...", function1);
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static Object H(Object[] objArr) {
        if (objArr.length != 0) {
            return objArr[objArr.length - 1];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object I(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return objArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List J(Object[] objArr, Comparator comparator) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, objArr.length);
            kotlin.jvm.internal.h.e(objArr, "copyOf(this, size)");
            if (objArr.length > 1) {
                Arrays.sort(objArr, comparator);
            }
        }
        return t(objArr);
    }

    public static final void K(Object[] objArr, LinkedHashSet linkedHashSet) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
    }

    public static List L(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new h(objArr, false)) : Z.p(objArr[0]) : u.f3805a;
    }

    public static ArrayList M(int[] iArr) {
        kotlin.jvm.internal.h.f(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static Set N(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return w.f3807a;
        }
        if (length == 1) {
            return io.ktor.utils.io.internal.t.p(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(B.F(objArr.length));
        K(objArr, linkedHashSet);
        return linkedHashSet;
    }

    public static List t(Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        kotlin.jvm.internal.h.e(listAsList, "asList(this)");
        return listAsList;
    }

    public static Sequence u(Object[] objArr) {
        return objArr.length == 0 ? k3.d.f3782a : new k3.n(objArr, 2);
    }

    public static boolean v(Object obj, Object[] objArr) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        return E(obj, objArr) >= 0;
    }

    public static void w(int i, int i3, Object[] objArr, int i4, Object[] destination) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        System.arraycopy(objArr, i3, destination, i, i4 - i3);
    }

    public static Object[] x(Object[] objArr, int i, int i3) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        int length = objArr.length;
        if (i3 <= length) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i3);
            kotlin.jvm.internal.h.e(objArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
            return objArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + length + ").");
    }

    public static final void y(Object[] objArr, E1.h hVar, int i, int i3) {
        kotlin.jvm.internal.h.f(objArr, "<this>");
        Arrays.fill(objArr, i, i3, hVar);
    }

    public static ArrayList z(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
