package t2;

import io.ktor.utils.io.Z;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import n2.AbstractC0708K;
import n2.C0702E;
import n2.C0705H;
import r2.C0794a;
import r2.C0795b;
import r2.C0796c;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends w implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f4816a;

    public s(Class klass) {
        kotlin.jvm.internal.h.f(klass, "klass");
        this.f4816a = klass;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            return kotlin.jvm.internal.h.a(this.f4816a, ((s) obj).f4816a);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final Collection getConstructors() {
        Constructor<?>[] declaredConstructors = this.f4816a.getDeclaredConstructors();
        kotlin.jvm.internal.h.e(declaredConstructors, "klass.declaredConstructors");
        return k3.m.F(k3.m.D(k3.m.x(kotlin.collections.j.u(declaredConstructors), k.f4808a), l.f4809a));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public final AnnotatedElement getElement() {
        return this.f4816a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final Collection getFields() {
        Field[] declaredFields = this.f4816a.getDeclaredFields();
        kotlin.jvm.internal.h.e(declaredFields, "klass.declaredFields");
        return k3.m.F(k3.m.D(k3.m.x(kotlin.collections.j.u(declaredFields), m.f4810a), n.f4811a));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final L2.c getFqName() {
        return AbstractC0823e.a(this.f4816a).b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final Collection getInnerClassNames() {
        Class<?>[] declaredClasses = this.f4816a.getDeclaredClasses();
        kotlin.jvm.internal.h.e(declaredClasses, "klass.declaredClasses");
        return k3.m.F(k3.m.E(k3.m.x(kotlin.collections.j.u(declaredClasses), o.f4812a), p.f4813a));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final C2.a getLightClassOriginKind() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final Collection getMethods() {
        Method[] declaredMethods = this.f4816a.getDeclaredMethods();
        kotlin.jvm.internal.h.e(declaredMethods, "klass.declaredMethods");
        return k3.m.F(k3.m.D(k3.m.w(kotlin.collections.j.u(declaredMethods), new q(this, 0)), r.f4815a));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public final int getModifiers() {
        return this.f4816a.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public final L2.f getName() {
        return L2.f.e(this.f4816a.getSimpleName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final JavaClass getOuterClass() {
        Class<?> declaringClass = this.f4816a.getDeclaringClass();
        if (declaringClass != null) {
            return new s(declaringClass);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final Collection getPermittedTypes() throws IllegalAccessException, InvocationTargetException {
        Class[] clsArr;
        Class clazz = this.f4816a;
        kotlin.jvm.internal.h.f(clazz, "clazz");
        Method method = (Method) k1.j.j().c;
        if (method == null) {
            clsArr = null;
        } else {
            Object objInvoke = method.invoke(clazz, new Object[0]);
            kotlin.jvm.internal.h.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
            clsArr = (Class[]) objInvoke;
        }
        if (clsArr == null) {
            return kotlin.collections.u.f3804a;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class cls : clsArr) {
            arrayList.add(new u(cls));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final Collection getRecordComponents() {
        Class clazz = this.f4816a;
        kotlin.jvm.internal.h.f(clazz, "clazz");
        Method method = (Method) k1.j.j().e;
        Object[] objArr = method == null ? null : (Object[]) method.invoke(clazz, new Object[0]);
        if (objArr == null) {
            objArr = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new E(obj));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final Collection getSupertypes() {
        Class cls;
        Class cls2 = this.f4816a;
        cls = Object.class;
        if (kotlin.jvm.internal.h.a(cls2, cls)) {
            return kotlin.collections.u.f3804a;
        }
        kotlin.jvm.internal.y yVar = new kotlin.jvm.internal.y(2);
        Type genericSuperclass = cls2.getGenericSuperclass();
        yVar.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = cls2.getGenericInterfaces();
        kotlin.jvm.internal.h.e(genericInterfaces, "klass.genericInterfaces");
        yVar.b(genericInterfaces);
        ArrayList arrayList = yVar.f3818a;
        List listY = kotlin.collections.n.y(arrayList.toArray(new Type[arrayList.size()]));
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(listY));
        Iterator it = listY.iterator();
        while (it.hasNext()) {
            arrayList2.add(new u((Type) it.next()));
        }
        return arrayList2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public final List getTypeParameters() {
        TypeVariable[] typeParameters = this.f4816a.getTypeParameters();
        kotlin.jvm.internal.h.e(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new G(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public final AbstractC0708K getVisibility() {
        int modifiers = this.f4816a.getModifiers();
        return Modifier.isPublic(modifiers) ? C0705H.c : Modifier.isPrivate(modifiers) ? C0702E.c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? C0796c.c : C0795b.c : C0794a.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final boolean hasDefaultConstructor() {
        return false;
    }

    public final int hashCode() {
        return this.f4816a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public final boolean isAbstract() {
        return Modifier.isAbstract(this.f4816a.getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final boolean isAnnotationType() {
        return this.f4816a.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final boolean isEnum() {
        return this.f4816a.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public final boolean isFinal() {
        return Modifier.isFinal(this.f4816a.getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final boolean isInterface() {
        return this.f4816a.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final boolean isRecord() throws IllegalAccessException, InvocationTargetException {
        Boolean bool;
        Class clazz = this.f4816a;
        kotlin.jvm.internal.h.f(clazz, "clazz");
        Method method = (Method) k1.j.j().d;
        if (method == null) {
            bool = null;
        } else {
            Object objInvoke = method.invoke(clazz, new Object[0]);
            kotlin.jvm.internal.h.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            bool = (Boolean) objInvoke;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public final boolean isSealed() throws IllegalAccessException, InvocationTargetException {
        Boolean bool;
        Class clazz = this.f4816a;
        kotlin.jvm.internal.h.f(clazz, "clazz");
        Method method = (Method) k1.j.j().b;
        if (method == null) {
            bool = null;
        } else {
            Object objInvoke = method.invoke(clazz, new Object[0]);
            kotlin.jvm.internal.h.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            bool = (Boolean) objInvoke;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public final boolean isStatic() {
        return Modifier.isStatic(this.f4816a.getModifiers());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.motion.a.u(s.class, sb, ": ");
        sb.append(this.f4816a);
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final C0824f findAnnotation(L2.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.h.f(fqName, "fqName");
        Class cls = this.f4816a;
        if (cls == null || (declaredAnnotations = cls.getDeclaredAnnotations()) == null) {
            return null;
        }
        return Z.i(declaredAnnotations, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final List getAnnotations() {
        Annotation[] declaredAnnotations;
        Class cls = this.f4816a;
        return (cls == null || (declaredAnnotations = cls.getDeclaredAnnotations()) == null) ? kotlin.collections.u.f3804a : Z.l(declaredAnnotations);
    }
}
