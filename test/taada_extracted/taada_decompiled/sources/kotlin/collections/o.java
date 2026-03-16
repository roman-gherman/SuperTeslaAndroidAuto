package kotlin.collections;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends n {
    public static int D(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
