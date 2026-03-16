package t2;

import io.ktor.utils.io.Z;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends w implements ReflectJavaAnnotationOwner, JavaTypeParameter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeVariable f4798a;

    public G(TypeVariable typeVariable) {
        kotlin.jvm.internal.h.f(typeVariable, "typeVariable");
        this.f4798a = typeVariable;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof G) {
            return kotlin.jvm.internal.h.a(this.f4798a, ((G) obj).f4798a);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public final AnnotatedElement getElement() {
        TypeVariable typeVariable = this.f4798a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public final L2.f getName() {
        return L2.f.e(this.f4798a.getName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public final Collection getUpperBounds() {
        Type[] bounds = this.f4798a.getBounds();
        kotlin.jvm.internal.h.e(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new u(type));
        }
        u uVar = (u) kotlin.collections.m.i0(arrayList);
        return kotlin.jvm.internal.h.a(uVar != null ? uVar.f4818a : null, Object.class) ? kotlin.collections.u.f3805a : arrayList;
    }

    public final int hashCode() {
        return this.f4798a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.motion.a.u(G.class, sb, ": ");
        sb.append(this.f4798a);
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final C0824f findAnnotation(L2.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.h.f(fqName, "fqName");
        AnnotatedElement element = getElement();
        if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
            return null;
        }
        return Z.i(declaredAnnotations, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final List getAnnotations() {
        Annotation[] declaredAnnotations;
        AnnotatedElement element = getElement();
        return (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) ? kotlin.collections.u.f3805a : Z.l(declaredAnnotations);
    }
}
