package i2;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.reflect.jvm.internal.calls.Caller;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v implements Caller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f3479a;
    public final List b;
    public final Class c;

    public v(Method method, List list) {
        this.f3479a = method;
        this.b = list;
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.h.e(returnType, "unboxMethod.returnType");
        this.c = returnType;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final /* bridge */ /* synthetic */ Member getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final List getParameterTypes() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        return this.c;
    }
}
