package org.mockito.internal.util;

import B2.b;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Checks {
    private Checks() {
    }

    public static <T extends Iterable<?>> T checkItemsNotNull(T t6, String str) {
        checkNotNull(t6, str);
        Iterator it = t6.iterator();
        while (it.hasNext()) {
            checkNotNull(it.next(), "item in " + str);
        }
        return t6;
    }

    public static <T> T checkNotNull(T t6, String str) {
        return (T) checkNotNull(t6, str, null);
    }

    public static <T> T checkNotNull(T t6, String str, String str2) {
        if (t6 != null) {
            return t6;
        }
        String strE = b.e(str, " should not be null");
        if (str2 != null) {
            strE = b.f(strE, ". ", str2);
        }
        throw new IllegalArgumentException(strE);
    }
}
