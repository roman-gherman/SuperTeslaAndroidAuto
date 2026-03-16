package t2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;

/* JADX INFO: renamed from: t2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0824f extends w implements JavaAnnotation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Annotation f4806a;

    public C0824f(Annotation annotation) {
        kotlin.jvm.internal.h.f(annotation, "annotation");
        this.f4806a = annotation;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0824f) {
            return this.f4806a == ((C0824f) obj).f4806a;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public final Collection getArguments() throws IllegalAccessException, InvocationTargetException {
        Annotation annotation = this.f4806a;
        Method[] declaredMethods = E1.k.H(E1.k.E(annotation)).getDeclaredMethods();
        kotlin.jvm.internal.h.e(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            Object objInvoke = method.invoke(annotation, new Object[0]);
            kotlin.jvm.internal.h.e(objInvoke, "method.invoke(annotation)");
            L2.f fVarE = L2.f.e(method.getName());
            Class<?> cls = objInvoke.getClass();
            List list = AbstractC0823e.f4805a;
            arrayList.add(Enum.class.isAssignableFrom(cls) ? new x(fVarE, (Enum) objInvoke) : objInvoke instanceof Annotation ? new C0826h(fVarE, (Annotation) objInvoke) : objInvoke instanceof Object[] ? new C0827i(fVarE, (Object[]) objInvoke) : objInvoke instanceof Class ? new t(fVarE, (Class) objInvoke) : new z(fVarE, objInvoke));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public final L2.b getClassId() {
        return AbstractC0823e.a(E1.k.H(E1.k.E(this.f4806a)));
    }

    public final int hashCode() {
        return System.identityHashCode(this.f4806a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public final boolean isIdeExternalAnnotation() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public final JavaClass resolve() {
        return new s(E1.k.H(E1.k.E(this.f4806a)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.motion.a.u(C0824f.class, sb, ": ");
        sb.append(this.f4806a);
        return sb.toString();
    }
}
