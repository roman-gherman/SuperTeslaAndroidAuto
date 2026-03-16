package N1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f1123a;

    public g(Throwable exception) {
        kotlin.jvm.internal.h.f(exception, "exception");
        this.f1123a = exception;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return kotlin.jvm.internal.h.a(this.f1123a, ((g) obj).f1123a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1123a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f1123a + ')';
    }
}
