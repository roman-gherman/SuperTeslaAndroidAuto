package N1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1124a;

    public static final Throwable a(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).f1123a;
        }
        return null;
    }

    public static String b(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return kotlin.jvm.internal.h.a(this.f1124a, ((h) obj).f1124a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f1124a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return b(this.f1124a);
    }
}
