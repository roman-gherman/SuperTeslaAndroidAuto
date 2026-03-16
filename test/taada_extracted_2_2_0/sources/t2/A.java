package t2;

import io.ktor.utils.io.Z;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import n2.AbstractC0708K;
import n2.C0702E;
import n2.C0705H;
import r2.C0794a;
import r2.C0795b;
import r2.C0796c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A extends w implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public abstract Member a();

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList b(java.lang.reflect.Type[] r13, java.lang.annotation.Annotation[][] r14, boolean r15) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.A.b(java.lang.reflect.Type[], java.lang.annotation.Annotation[][], boolean):java.util.ArrayList");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof A) && kotlin.jvm.internal.h.a(a(), ((A) obj).a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public final JavaClass getContainingClass() {
        Class<?> declaringClass = a().getDeclaringClass();
        kotlin.jvm.internal.h.e(declaringClass, "member.declaringClass");
        return new s(declaringClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public final AnnotatedElement getElement() {
        Member memberA = a();
        kotlin.jvm.internal.h.d(memberA, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) memberA;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public final int getModifiers() {
        return a().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public final L2.f getName() {
        String name = a().getName();
        L2.f fVarE = name != null ? L2.f.e(name) : null;
        return fVarE == null ? L2.h.f964a : fVarE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public final AbstractC0708K getVisibility() {
        int modifiers = getModifiers();
        return Modifier.isPublic(modifiers) ? C0705H.c : Modifier.isPrivate(modifiers) ? C0702E.c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? C0796c.c : C0795b.c : C0794a.c;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public final boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public final boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public final boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public final String toString() {
        return getClass().getName() + ": " + a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final C0824f findAnnotation(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        Annotation[] declaredAnnotations = getElement().getDeclaredAnnotations();
        if (declaredAnnotations != null) {
            return Z.i(declaredAnnotations, fqName);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final List getAnnotations() {
        Annotation[] declaredAnnotations = getElement().getDeclaredAnnotations();
        return declaredAnnotations != null ? Z.l(declaredAnnotations) : kotlin.collections.u.f3805a;
    }
}
