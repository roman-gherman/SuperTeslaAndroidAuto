package h2;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: h2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0498a {
    static {
        Object objN;
        try {
            objN = Class.forName("java.lang.ClassValue");
        } catch (Throwable th) {
            objN = kotlin.reflect.l.n(th);
        }
        if (!(objN instanceof N1.g)) {
            objN = Boolean.TRUE;
        }
        Object obj = Boolean.FALSE;
        if (objN instanceof N1.g) {
            objN = obj;
        }
    }

    public static final B.h a(Function1 compute) {
        kotlin.jvm.internal.h.f(compute, "compute");
        return new B.h(compute);
    }
}
