package kotlin.jvm.internal;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3812a;

    public m(Class jClass, String str) {
        h.f(jClass, "jClass");
        this.f3812a = jClass;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return h.a(this.f3812a, ((m) obj).f3812a);
        }
        return false;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.f3812a;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public final Collection getMembers() {
        throw new N1.d();
    }

    public final int hashCode() {
        return this.f3812a.hashCode();
    }

    public final String toString() {
        return this.f3812a.toString() + " (Kotlin reflection is not available)";
    }
}
