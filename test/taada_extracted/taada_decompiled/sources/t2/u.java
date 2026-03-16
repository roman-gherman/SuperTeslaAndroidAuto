package t2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends F implements JavaClassifierType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f4817a;
    public final w b;

    public u(Type reflectType) {
        w sVar;
        kotlin.jvm.internal.h.f(reflectType, "reflectType");
        this.f4817a = reflectType;
        if (reflectType instanceof Class) {
            sVar = new s((Class) reflectType);
        } else if (reflectType instanceof TypeVariable) {
            sVar = new G((TypeVariable) reflectType);
        } else {
            if (!(reflectType instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + reflectType.getClass() + "): " + reflectType);
            }
            Type rawType = ((ParameterizedType) reflectType).getRawType();
            kotlin.jvm.internal.h.d(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            sVar = new s((Class) rawType);
        }
        this.b = sVar;
    }

    @Override // t2.F
    public final Type a() {
        return this.f4817a;
    }

    @Override // t2.F, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final JavaAnnotation findAnnotation(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final Collection getAnnotations() {
        return kotlin.collections.u.f3804a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier, t2.w] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final JavaClassifier getClassifier() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final String getClassifierQualifiedName() {
        throw new UnsupportedOperationException("Type not found: " + this.f4817a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final String getPresentableText() {
        return this.f4817a.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List getTypeArguments() {
        /*
            r6 = this;
            java.lang.reflect.Type r0 = r6.f4817a
            java.util.List r0 = t2.AbstractC0823e.c(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.collections.o.D(r0)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L13:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L64
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
            java.lang.String r3 = "type"
            kotlin.jvm.internal.h.f(r2, r3)
            boolean r3 = r2 instanceof java.lang.Class
            if (r3 == 0) goto L37
            r4 = r2
            java.lang.Class r4 = (java.lang.Class) r4
            boolean r5 = r4.isPrimitive()
            if (r5 == 0) goto L37
            t2.D r2 = new t2.D
            r2.<init>(r4)
            goto L60
        L37:
            boolean r4 = r2 instanceof java.lang.reflect.GenericArrayType
            if (r4 != 0) goto L5a
            if (r3 == 0) goto L47
            r3 = r2
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r3 = r3.isArray()
            if (r3 == 0) goto L47
            goto L5a
        L47:
            boolean r3 = r2 instanceof java.lang.reflect.WildcardType
            if (r3 == 0) goto L54
            t2.I r3 = new t2.I
            java.lang.reflect.WildcardType r2 = (java.lang.reflect.WildcardType) r2
            r3.<init>(r2)
        L52:
            r2 = r3
            goto L60
        L54:
            t2.u r3 = new t2.u
            r3.<init>(r2)
            goto L52
        L5a:
            t2.j r3 = new t2.j
            r3.<init>(r2)
            goto L52
        L60:
            r1.add(r2)
            goto L13
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.u.getTypeArguments():java.util.List");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final boolean isRaw() {
        Type type = this.f4817a;
        if (type instanceof Class) {
            TypeVariable[] typeParameters = ((Class) type).getTypeParameters();
            kotlin.jvm.internal.h.e(typeParameters, "getTypeParameters()");
            if (!(typeParameters.length == 0)) {
                return true;
            }
        }
        return false;
    }
}
