package s2;

import E1.k;
import com.android.multidex.ClassPathElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.text.r;
import net.bytebuddy.pool.TypePool;
import t2.AbstractC0823e;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements KotlinJvmBinaryClass {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f4768a;
    public final F2.b b;

    public e(Class cls, F2.b bVar) {
        this.f4768a = cls;
        this.b = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return kotlin.jvm.internal.h.a(this.f4768a, ((e) obj).f4768a);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public final F2.b getClassHeader() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public final L2.b getClassId() {
        return AbstractC0823e.a(this.f4768a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public final String getLocation() {
        return r.A(this.f4768a.getName(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR).concat(".class");
    }

    public final int hashCode() {
        return this.f4768a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public final void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor visitor, byte[] bArr) throws InvocationTargetException {
        kotlin.jvm.internal.h.f(visitor, "visitor");
        Class klass = this.f4768a;
        kotlin.jvm.internal.h.f(klass, "klass");
        Annotation[] declaredAnnotations = klass.getDeclaredAnnotations();
        kotlin.jvm.internal.h.e(declaredAnnotations, "klass.declaredAnnotations");
        for (Annotation annotation : declaredAnnotations) {
            kotlin.jvm.internal.h.e(annotation, "annotation");
            AbstractC0812b.b(visitor, annotation);
        }
        visitor.visitEnd();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.motion.a.u(e.class, sb, ": ");
        sb.append(this.f4768a);
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public final void visitMembers(KotlinJvmBinaryClass.MemberVisitor visitor, byte[] bArr) throws InvocationTargetException {
        Constructor<?>[] constructorArr;
        int i;
        int i3;
        Class cls;
        kotlin.jvm.internal.h.f(visitor, "visitor");
        Class klass = this.f4768a;
        kotlin.jvm.internal.h.f(klass, "klass");
        Method[] declaredMethods = klass.getDeclaredMethods();
        kotlin.jvm.internal.h.e(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i4 = 0;
        while (i4 < length) {
            Method method = declaredMethods[i4];
            L2.f fVarE = L2.f.e(method.getName());
            StringBuilder sb = new StringBuilder("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            kotlin.jvm.internal.h.e(parameterTypes, "method.parameterTypes");
            for (Class<?> parameterType : parameterTypes) {
                kotlin.jvm.internal.h.e(parameterType, "parameterType");
                sb.append(AbstractC0823e.b(parameterType));
            }
            sb.append(")");
            Class<?> returnType = method.getReturnType();
            kotlin.jvm.internal.h.e(returnType, "method.returnType");
            sb.append(AbstractC0823e.b(returnType));
            String string = sb.toString();
            kotlin.jvm.internal.h.e(string, "sb.toString()");
            KotlinJvmBinaryClass.MethodAnnotationVisitor methodAnnotationVisitorVisitMethod = visitor.visitMethod(fVarE, string);
            if (methodAnnotationVisitorVisitMethod == null) {
                cls = klass;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                kotlin.jvm.internal.h.e(declaredAnnotations, "method.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    kotlin.jvm.internal.h.e(annotation, "annotation");
                    AbstractC0812b.b(methodAnnotationVisitorVisitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                kotlin.jvm.internal.h.e(parameterAnnotations, "method.parameterAnnotations");
                Annotation[][] annotationArr = parameterAnnotations;
                int length2 = annotationArr.length;
                for (int i5 = 0; i5 < length2; i5++) {
                    Annotation[] annotations = annotationArr[i5];
                    kotlin.jvm.internal.h.e(annotations, "annotations");
                    int length3 = annotations.length;
                    int i6 = 0;
                    while (i6 < length3) {
                        Annotation annotation2 = annotations[i6];
                        Class clsH = k.H(k.E(annotation2));
                        Class cls2 = klass;
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitParameterAnnotation = methodAnnotationVisitorVisitMethod.visitParameterAnnotation(i5, AbstractC0823e.a(clsH), new C0811a(annotation2));
                        if (annotationArgumentVisitorVisitParameterAnnotation != null) {
                            AbstractC0812b.c(annotationArgumentVisitorVisitParameterAnnotation, annotation2, clsH);
                        }
                        i6++;
                        klass = cls2;
                    }
                }
                cls = klass;
                methodAnnotationVisitorVisitMethod.visitEnd();
            }
            i4++;
            klass = cls;
        }
        Class cls3 = klass;
        Constructor<?>[] declaredConstructors = cls3.getDeclaredConstructors();
        kotlin.jvm.internal.h.e(declaredConstructors, "klass.declaredConstructors");
        int length4 = declaredConstructors.length;
        int i7 = 0;
        while (i7 < length4) {
            Constructor<?> constructor = declaredConstructors[i7];
            L2.f fVar = L2.h.e;
            kotlin.jvm.internal.h.e(constructor, "constructor");
            StringBuilder sb2 = new StringBuilder("(");
            Class<?>[] parameterTypes2 = constructor.getParameterTypes();
            kotlin.jvm.internal.h.e(parameterTypes2, "constructor.parameterTypes");
            for (Class<?> parameterType2 : parameterTypes2) {
                kotlin.jvm.internal.h.e(parameterType2, "parameterType");
                sb2.append(AbstractC0823e.b(parameterType2));
            }
            sb2.append(")V");
            String string2 = sb2.toString();
            kotlin.jvm.internal.h.e(string2, "sb.toString()");
            KotlinJvmBinaryClass.MethodAnnotationVisitor methodAnnotationVisitorVisitMethod2 = visitor.visitMethod(fVar, string2);
            if (methodAnnotationVisitorVisitMethod2 == null) {
                constructorArr = declaredConstructors;
                i = length4;
                i3 = i7;
            } else {
                Annotation[] declaredAnnotations2 = constructor.getDeclaredAnnotations();
                kotlin.jvm.internal.h.e(declaredAnnotations2, "constructor.declaredAnnotations");
                for (Annotation annotation3 : declaredAnnotations2) {
                    kotlin.jvm.internal.h.e(annotation3, "annotation");
                    AbstractC0812b.b(methodAnnotationVisitorVisitMethod2, annotation3);
                }
                Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
                kotlin.jvm.internal.h.e(parameterAnnotations2, "parameterAnnotations");
                if (parameterAnnotations2.length != 0) {
                    int length5 = constructor.getParameterTypes().length - parameterAnnotations2.length;
                    int length6 = parameterAnnotations2.length;
                    int i8 = 0;
                    while (i8 < length6) {
                        Annotation[] annotations2 = parameterAnnotations2[i8];
                        kotlin.jvm.internal.h.e(annotations2, "annotations");
                        int length7 = annotations2.length;
                        Constructor<?>[] constructorArr2 = declaredConstructors;
                        int i9 = 0;
                        while (i9 < length7) {
                            int i10 = i9;
                            Annotation annotation4 = annotations2[i10];
                            int i11 = length4;
                            Class clsH2 = k.H(k.E(annotation4));
                            int i12 = i7;
                            int i13 = length5;
                            Annotation[][] annotationArr2 = parameterAnnotations2;
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorVisitParameterAnnotation2 = methodAnnotationVisitorVisitMethod2.visitParameterAnnotation(i8 + length5, AbstractC0823e.a(clsH2), new C0811a(annotation4));
                            if (annotationArgumentVisitorVisitParameterAnnotation2 != null) {
                                AbstractC0812b.c(annotationArgumentVisitorVisitParameterAnnotation2, annotation4, clsH2);
                            }
                            i9 = i10 + 1;
                            i7 = i12;
                            length4 = i11;
                            length5 = i13;
                            parameterAnnotations2 = annotationArr2;
                        }
                        i8++;
                        declaredConstructors = constructorArr2;
                    }
                }
                constructorArr = declaredConstructors;
                i = length4;
                i3 = i7;
                methodAnnotationVisitorVisitMethod2.visitEnd();
            }
            i7 = i3 + 1;
            declaredConstructors = constructorArr;
            length4 = i;
        }
        Field[] declaredFields = cls3.getDeclaredFields();
        kotlin.jvm.internal.h.e(declaredFields, "klass.declaredFields");
        for (Field field : declaredFields) {
            L2.f fVarE2 = L2.f.e(field.getName());
            Class<?> type = field.getType();
            kotlin.jvm.internal.h.e(type, "field.type");
            KotlinJvmBinaryClass.AnnotationVisitor annotationVisitorVisitField = visitor.visitField(fVarE2, AbstractC0823e.b(type), null);
            if (annotationVisitorVisitField != null) {
                Annotation[] declaredAnnotations3 = field.getDeclaredAnnotations();
                kotlin.jvm.internal.h.e(declaredAnnotations3, "field.declaredAnnotations");
                for (Annotation annotation5 : declaredAnnotations3) {
                    kotlin.jvm.internal.h.e(annotation5, "annotation");
                    AbstractC0812b.b(annotationVisitorVisitField, annotation5);
                }
                annotationVisitorVisitField.visitEnd();
            }
        }
    }
}
