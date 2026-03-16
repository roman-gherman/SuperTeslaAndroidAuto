package t2;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends A implements JavaField {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f4820a;

    public y(Field member) {
        kotlin.jvm.internal.h.f(member, "member");
        this.f4820a = member;
    }

    @Override // t2.A
    public final Member a() {
        return this.f4820a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public final boolean getHasConstantNotNullInitializer() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public final JavaType getType() {
        Type genericType = this.f4820a.getGenericType();
        kotlin.jvm.internal.h.e(genericType, "member.genericType");
        boolean z6 = genericType instanceof Class;
        if (z6) {
            Class cls = (Class) genericType;
            if (cls.isPrimitive()) {
                return new D(cls);
            }
        }
        return ((genericType instanceof GenericArrayType) || (z6 && ((Class) genericType).isArray())) ? new j(genericType) : genericType instanceof WildcardType ? new I((WildcardType) genericType) : new u(genericType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public final boolean isEnumEntry() {
        return this.f4820a.isEnumConstant();
    }
}
