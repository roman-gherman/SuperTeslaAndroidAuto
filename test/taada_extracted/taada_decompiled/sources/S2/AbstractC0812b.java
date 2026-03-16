package s2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import k2.k;
import k2.o;
import kotlin.collections.j;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import m2.C0652d;
import t2.AbstractC0823e;

/* JADX INFO: renamed from: s2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0812b {
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object, kotlin.Lazy] */
    public static P2.f a(Class cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            kotlin.jvm.internal.h.e(cls, "currentClass.componentType");
        }
        if (cls.isPrimitive()) {
            if (cls.equals(Void.TYPE)) {
                return new P2.f(L2.b.j(o.d.g()), i);
            }
            k kVarD = S2.b.b(cls.getName()).d();
            kotlin.jvm.internal.h.e(kVarD, "get(currentClass.name).primitiveType");
            return i > 0 ? new P2.f(L2.b.j((L2.c) kVarD.d.getValue()), i - 1) : new P2.f(L2.b.j((L2.c) kVarD.c.getValue()), i);
        }
        L2.b bVarA = AbstractC0823e.a(cls);
        String str = C0652d.f4074a;
        L2.b bVar = (L2.b) C0652d.f4077h.get(bVarA.b().i());
        if (bVar != null) {
            bVarA = bVar;
        }
        return new P2.f(bVarA, i);
    }

    public static void b(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) throws InvocationTargetException {
        Class clsH = E1.k.H(E1.k.E(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitAnnotation = annotationVisitor.visitAnnotation(AbstractC0823e.a(clsH), new C0811a(annotation));
        if (annotationArgumentVisitorVisitAnnotation != null) {
            c(annotationArgumentVisitorVisitAnnotation, annotation, clsH);
        }
    }

    public static void c(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class cls) throws InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        kotlin.jvm.internal.h.e(declaredMethods, "annotationType.declaredMethods");
        for (Method method : declaredMethods) {
            try {
                Object objInvoke = method.invoke(annotation, new Object[0]);
                kotlin.jvm.internal.h.c(objInvoke);
                L2.f fVarE = L2.f.e(method.getName());
                Class<?> enclosingClass = objInvoke.getClass();
                if (enclosingClass.equals(Class.class)) {
                    annotationArgumentVisitor.visitClassLiteral(fVarE, a((Class) objInvoke));
                } else if (f.f4769a.contains(enclosingClass)) {
                    annotationArgumentVisitor.visit(fVarE, objInvoke);
                } else {
                    List list = AbstractC0823e.f4804a;
                    if (Enum.class.isAssignableFrom(enclosingClass)) {
                        if (!enclosingClass.isEnum()) {
                            enclosingClass = enclosingClass.getEnclosingClass();
                        }
                        kotlin.jvm.internal.h.e(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                        annotationArgumentVisitor.visitEnum(fVarE, AbstractC0823e.a(enclosingClass), L2.f.e(((Enum) objInvoke).name()));
                    } else if (Annotation.class.isAssignableFrom(enclosingClass)) {
                        Class<?>[] interfaces = enclosingClass.getInterfaces();
                        kotlin.jvm.internal.h.e(interfaces, "clazz.interfaces");
                        Class annotationClass = (Class) j.I(interfaces);
                        kotlin.jvm.internal.h.e(annotationClass, "annotationClass");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitAnnotation = annotationArgumentVisitor.visitAnnotation(fVarE, AbstractC0823e.a(annotationClass));
                        if (annotationArgumentVisitorVisitAnnotation != null) {
                            c(annotationArgumentVisitorVisitAnnotation, (Annotation) objInvoke, annotationClass);
                        }
                    } else {
                        if (!enclosingClass.isArray()) {
                            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + objInvoke);
                        }
                        KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor annotationArrayArgumentVisitorVisitArray = annotationArgumentVisitor.visitArray(fVarE);
                        if (annotationArrayArgumentVisitorVisitArray != null) {
                            Class<?> componentType = enclosingClass.getComponentType();
                            if (componentType.isEnum()) {
                                L2.b bVarA = AbstractC0823e.a(componentType);
                                for (Object obj : (Object[]) objInvoke) {
                                    kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                                    annotationArrayArgumentVisitorVisitArray.visitEnum(bVarA, L2.f.e(((Enum) obj).name()));
                                }
                            } else if (componentType.equals(Class.class)) {
                                for (Object obj2 : (Object[]) objInvoke) {
                                    kotlin.jvm.internal.h.d(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                                    annotationArrayArgumentVisitorVisitArray.visitClassLiteral(a((Class) obj2));
                                }
                            } else if (Annotation.class.isAssignableFrom(componentType)) {
                                for (Object obj3 : (Object[]) objInvoke) {
                                    KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitAnnotation2 = annotationArrayArgumentVisitorVisitArray.visitAnnotation(AbstractC0823e.a(componentType));
                                    if (annotationArgumentVisitorVisitAnnotation2 != null) {
                                        kotlin.jvm.internal.h.d(obj3, "null cannot be cast to non-null type kotlin.Annotation");
                                        c(annotationArgumentVisitorVisitAnnotation2, (Annotation) obj3, componentType);
                                    }
                                }
                            } else {
                                for (Object obj4 : (Object[]) objInvoke) {
                                    annotationArrayArgumentVisitorVisitArray.visit(obj4);
                                }
                            }
                            annotationArrayArgumentVisitorVisitArray.visitEnd();
                        }
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }
}
