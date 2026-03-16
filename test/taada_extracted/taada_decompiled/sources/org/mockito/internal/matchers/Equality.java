package org.mockito.internal.matchers;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public final class Equality {
    private Equality() {
    }

    public static boolean areArrayElementsEqual(Object obj, Object obj2) {
        for (int i = 0; i < Array.getLength(obj); i++) {
            if (!areEqual(Array.get(obj, i), Array.get(obj2, i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean areArrayLengthsEqual(Object obj, Object obj2) {
        return Array.getLength(obj) == Array.getLength(obj2);
    }

    public static boolean areArraysEqual(Object obj, Object obj2) {
        return areArrayLengthsEqual(obj, obj2) && areArrayElementsEqual(obj, obj2);
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return isArray(obj) ? isArray(obj2) && areArraysEqual(obj, obj2) : obj.equals(obj2);
    }

    public static boolean isArray(Object obj) {
        return obj.getClass().isArray();
    }
}
