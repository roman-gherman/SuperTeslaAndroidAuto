package h2;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import t2.AbstractC0823e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z.e f3430a = new z.e(8);

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0113  */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object, kotlin.Lazy] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.reflect.jvm.internal.calls.Caller a(h2.e0 r7, boolean r8) throws java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.s0.a(h2.e0, boolean):kotlin.reflect.jvm.internal.calls.Caller");
    }

    public static final String b(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.h.e(parameterTypes, "parameterTypes");
        sb.append(kotlin.collections.j.G(parameterTypes, "(", ")", C0499b.f3396m, 24));
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.h.e(returnType, "returnType");
        sb.append(AbstractC0823e.b(returnType));
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final i2.r d(h2.e0 r4, boolean r5, java.lang.reflect.Field r6) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.s0.d(h2.e0, boolean, java.lang.reflect.Field):i2.r");
    }

    public static final boolean e(e0 e0Var) {
        return !a3.b0.f(e0Var.i().e().getType());
    }

    public static final Object f(e0 e0Var) {
        kotlin.jvm.internal.h.f(e0Var, "<this>");
        k0 k0VarI = e0Var.i();
        return E1.k.l(k0VarI.i, k0VarI.e());
    }

    public static q0 g(CallableMemberDescriptor callableMemberDescriptor, Function0 function0) {
        if (function0 != null) {
            return new q0(callableMemberDescriptor, function0);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
    }

    public abstract String c();
}
