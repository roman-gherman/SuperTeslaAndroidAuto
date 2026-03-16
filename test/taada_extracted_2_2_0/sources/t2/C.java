package t2;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends w implements JavaPackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.c f4795a;

    public C(L2.c cVar) {
        this.f4795a = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C) {
            return kotlin.jvm.internal.h.a(this.f4795a, ((C) obj).f4795a);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final JavaAnnotation findAnnotation(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final /* bridge */ /* synthetic */ Collection getAnnotations() {
        return kotlin.collections.u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public final Collection getClasses(Function1 nameFilter) {
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return kotlin.collections.u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public final L2.c getFqName() {
        return this.f4795a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public final Collection getSubPackages() {
        return kotlin.collections.u.f3805a;
    }

    public final int hashCode() {
        return this.f4795a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.motion.a.u(C.class, sb, ": ");
        sb.append(this.f4795a);
        return sb.toString();
    }
}
