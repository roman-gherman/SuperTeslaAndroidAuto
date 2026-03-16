package Z2;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1498a;
    public final Function0 b;

    public h(Object obj, Function0 function0) {
        this.f1498a = obj;
        this.b = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && h.class == obj.getClass() && this.f1498a.equals(((h) obj).f1498a);
    }

    public final int hashCode() {
        return this.f1498a.hashCode();
    }
}
