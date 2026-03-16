package t2;

import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class F implements JavaType {
    public abstract Type a();

    public final boolean equals(Object obj) {
        return (obj instanceof F) && kotlin.jvm.internal.h.a(a(), ((F) obj).a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(L2.c fqName) {
        Object obj;
        kotlin.jvm.internal.h.f(fqName, "fqName");
        Iterator<T> it = getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            L2.b classId = ((JavaAnnotation) next).getClassId();
            if (kotlin.jvm.internal.h.a(classId != null ? classId.b() : null, fqName)) {
                obj = next;
                break;
            }
        }
        return (JavaAnnotation) obj;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return getClass().getName() + ": " + a();
    }
}
