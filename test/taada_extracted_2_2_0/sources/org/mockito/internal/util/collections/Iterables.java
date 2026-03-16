package org.mockito.internal.util.collections;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Iterables {
    private Iterables() {
    }

    public static <T> T firstOf(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new IllegalArgumentException("Cannot provide 1st element from empty iterable: " + iterable);
    }

    public static <T> Iterable<T> toIterable(Enumeration<T> enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }
}
