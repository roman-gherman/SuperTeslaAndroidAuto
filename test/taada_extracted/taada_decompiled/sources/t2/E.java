package t2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends A implements JavaRecordComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4796a;

    public E(Object recordComponent) {
        kotlin.jvm.internal.h.f(recordComponent, "recordComponent");
        this.f4796a = recordComponent;
    }

    @Override // t2.A
    public final Member a() throws IllegalAccessException, InvocationTargetException {
        Object recordComponent = this.f4796a;
        kotlin.jvm.internal.h.f(recordComponent, "recordComponent");
        C0819a c0819a = io.ktor.utils.io.jvm.javaio.q.f3615a;
        Method method = null;
        if (c0819a == null) {
            Class<?> cls = recordComponent.getClass();
            try {
                c0819a = new C0819a(cls.getMethod("getType", new Class[0]), cls.getMethod("getAccessor", new Class[0]));
            } catch (NoSuchMethodException unused) {
                c0819a = new C0819a(null, null);
            }
            io.ktor.utils.io.jvm.javaio.q.f3615a = c0819a;
        }
        Method method2 = c0819a.b;
        if (method2 != null) {
            Object objInvoke = method2.invoke(recordComponent, new Object[0]);
            kotlin.jvm.internal.h.d(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
            method = (Method) objInvoke;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public final JavaType getType() throws IllegalAccessException, InvocationTargetException {
        Object recordComponent = this.f4796a;
        kotlin.jvm.internal.h.f(recordComponent, "recordComponent");
        C0819a c0819a = io.ktor.utils.io.jvm.javaio.q.f3615a;
        Class cls = null;
        if (c0819a == null) {
            Class<?> cls2 = recordComponent.getClass();
            try {
                c0819a = new C0819a(cls2.getMethod("getType", new Class[0]), cls2.getMethod("getAccessor", new Class[0]));
            } catch (NoSuchMethodException unused) {
                c0819a = new C0819a(null, null);
            }
            io.ktor.utils.io.jvm.javaio.q.f3615a = c0819a;
        }
        Method method = c0819a.f4800a;
        if (method != null) {
            Object objInvoke = method.invoke(recordComponent, new Object[0]);
            kotlin.jvm.internal.h.d(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
            cls = (Class) objInvoke;
        }
        if (cls != null) {
            return new u(cls);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public final boolean isVararg() {
        return false;
    }
}
