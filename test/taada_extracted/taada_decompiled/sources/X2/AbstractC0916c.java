package x2;

import A2.C0025g;
import k2.o;
import kotlin.collections.A;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import w2.D;
import z2.C0946f;

/* JADX INFO: renamed from: x2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0916c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L2.f f5112a = L2.f.e("message");
    public static final L2.f b = L2.f.e("allowedTargets");
    public static final L2.f c = L2.f.e("value");
    public static final Object d = A.I(new N1.e(o.f3758t, D.c), new N1.e(o.f3760w, D.d), new N1.e(o.x, D.f4964f));

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.Map] */
    public static PossiblyExternalAnnotationDescriptor a(L2.c kotlinName, JavaAnnotationOwner annotationOwner, C0946f c6) {
        JavaAnnotation javaAnnotationFindAnnotation;
        kotlin.jvm.internal.h.f(kotlinName, "kotlinName");
        kotlin.jvm.internal.h.f(annotationOwner, "annotationOwner");
        kotlin.jvm.internal.h.f(c6, "c");
        if (kotlinName.equals(o.f3752m)) {
            L2.c DEPRECATED_ANNOTATION = D.e;
            kotlin.jvm.internal.h.e(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            JavaAnnotation javaAnnotationFindAnnotation2 = annotationOwner.findAnnotation(DEPRECATED_ANNOTATION);
            if (javaAnnotationFindAnnotation2 != null || annotationOwner.isDeprecatedInJavaDoc()) {
                return new C0920g(javaAnnotationFindAnnotation2, c6);
            }
        }
        L2.c cVar = (L2.c) d.get(kotlinName);
        if (cVar == null || (javaAnnotationFindAnnotation = annotationOwner.findAnnotation(cVar)) == null) {
            return null;
        }
        return b(javaAnnotationFindAnnotation, c6, false);
    }

    public static PossiblyExternalAnnotationDescriptor b(JavaAnnotation annotation, C0946f c6, boolean z6) {
        kotlin.jvm.internal.h.f(annotation, "annotation");
        kotlin.jvm.internal.h.f(c6, "c");
        L2.b classId = annotation.getClassId();
        if (kotlin.jvm.internal.h.a(classId, L2.b.j(D.c))) {
            return new C0923j(annotation, c6);
        }
        if (kotlin.jvm.internal.h.a(classId, L2.b.j(D.d))) {
            return new C0922i(annotation, c6);
        }
        if (kotlin.jvm.internal.h.a(classId, L2.b.j(D.f4964f))) {
            return new C0915b(c6, annotation, o.x);
        }
        if (kotlin.jvm.internal.h.a(classId, L2.b.j(D.e))) {
            return null;
        }
        return new C0025g(annotation, c6, z6);
    }
}
