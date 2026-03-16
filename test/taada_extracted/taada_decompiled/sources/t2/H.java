package t2;

import io.ktor.utils.io.Z;
import java.lang.annotation.Annotation;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends w implements JavaValueParameter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f4798a;
    public final Annotation[] b;
    public final String c;
    public final boolean d;

    public H(F f6, Annotation[] reflectAnnotations, String str, boolean z6) {
        kotlin.jvm.internal.h.f(reflectAnnotations, "reflectAnnotations");
        this.f4798a = f6;
        this.b = reflectAnnotations;
        this.c = str;
        this.d = z6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final JavaAnnotation findAnnotation(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        return Z.i(this.b, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final Collection getAnnotations() {
        return Z.l(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public final L2.f getName() {
        String str = this.c;
        if (str != null) {
            return L2.f.d(str);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public final JavaType getType() {
        return this.f4798a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public final boolean isVararg() {
        return this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.motion.a.u(H.class, sb, ": ");
        sb.append(this.d ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(this.f4798a);
        return sb.toString();
    }
}
