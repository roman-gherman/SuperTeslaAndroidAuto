package A2;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.f f74a;
    public final JavaClass b;

    public u(L2.f name, JavaClass javaClass) {
        kotlin.jvm.internal.h.f(name, "name");
        this.f74a = name;
        this.b = javaClass;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            return kotlin.jvm.internal.h.a(this.f74a, ((u) obj).f74a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f74a.hashCode();
    }
}
