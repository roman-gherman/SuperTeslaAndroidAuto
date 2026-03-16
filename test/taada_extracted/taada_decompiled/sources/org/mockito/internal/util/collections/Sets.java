package org.mockito.internal.util.collections;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class Sets {
    public static Set<Object> newMockSafeHashSet(Iterable<Object> iterable) {
        return HashCodeAndEqualsSafeSet.of(iterable);
    }

    public static <T> Set<T> newSet(T... tArr) {
        if (tArr != null) {
            return new LinkedHashSet(Arrays.asList(tArr));
        }
        throw new IllegalArgumentException("Expected an array of elements (or empty array) but received a null.");
    }

    public static Set<Object> newMockSafeHashSet(Object... objArr) {
        return HashCodeAndEqualsSafeSet.of(objArr);
    }
}
