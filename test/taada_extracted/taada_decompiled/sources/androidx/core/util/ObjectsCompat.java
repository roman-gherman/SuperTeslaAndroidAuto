package androidx.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {

    public static class Api19Impl {
        private Api19Impl() {
        }

        public static boolean equals(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        public static int hash(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(Object obj, Object obj2) {
        return Api19Impl.equals(obj, obj2);
    }

    public static int hash(Object... objArr) {
        return Api19Impl.hash(objArr);
    }

    public static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static <T> T requireNonNull(T t6) {
        t6.getClass();
        return t6;
    }

    public static String toString(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> T requireNonNull(T t6, String str) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(str);
    }
}
