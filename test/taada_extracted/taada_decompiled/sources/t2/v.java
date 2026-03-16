package t2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends A implements JavaConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Constructor f4818a;

    public v(Constructor member) {
        kotlin.jvm.internal.h.f(member, "member");
        this.f4818a = member;
    }

    @Override // t2.A
    public final Member a() {
        return this.f4818a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public final List getTypeParameters() {
        TypeVariable[] typeParameters = this.f4818a.getTypeParameters();
        kotlin.jvm.internal.h.e(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new G(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public final List getValueParameters() {
        Constructor constructor = this.f4818a;
        Type[] types = constructor.getGenericParameterTypes();
        kotlin.jvm.internal.h.e(types, "types");
        if (types.length == 0) {
            return kotlin.collections.u.f3804a;
        }
        Class declaringClass = constructor.getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            types = (Type[]) kotlin.collections.j.x(types, 1, types.length);
        }
        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
        if (parameterAnnotations.length >= types.length) {
            if (parameterAnnotations.length > types.length) {
                parameterAnnotations = (Annotation[][]) kotlin.collections.j.x(parameterAnnotations, parameterAnnotations.length - types.length, parameterAnnotations.length);
            }
            return b(types, parameterAnnotations, constructor.isVarArgs());
        }
        throw new IllegalStateException("Illegal generic signature: " + constructor);
    }
}
