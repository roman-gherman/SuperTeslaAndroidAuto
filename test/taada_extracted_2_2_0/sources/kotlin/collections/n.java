package kotlin.collections;

import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n extends Z {
    public static ArrayList A(Object... elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new h(elements, true));
    }

    public static List B(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : Z.p(list.get(0)) : u.f3805a;
    }

    public static void C() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static int x(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        return list.size() - 1;
    }

    public static List y(Object... elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return elements.length > 0 ? j.t(elements) : u.f3805a;
    }

    public static List z(Object obj) {
        return obj != null ? Z.p(obj) : u.f3805a;
    }
}
