package i2;

import e2.C0430f;
import h2.x0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.reflect.jvm.internal.calls.Caller;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements Caller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Caller f3478a;
    public final boolean b;
    public final B2.d c;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s(kotlin.reflect.jvm.internal.calls.Caller r9, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.s.<init>(kotlin.reflect.jvm.internal.calls.Caller, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, boolean):void");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        kotlin.jvm.internal.h.f(args, "args");
        B2.d dVar = this.c;
        C0430f c0430f = (C0430f) dVar.b;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, size)");
        int i = c0430f.f3132a;
        int i3 = c0430f.b;
        if (i <= i3) {
            while (true) {
                Method method = ((Method[]) dVar.c)[i];
                Object objE = args[i];
                if (method != null) {
                    if (objE != null) {
                        objE = method.invoke(objE, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        kotlin.jvm.internal.h.e(returnType, "method.returnType");
                        objE = x0.e(returnType);
                    }
                }
                objArrCopyOf[i] = objE;
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        Object objCall = this.f3478a.call(objArrCopyOf);
        Method method2 = (Method) dVar.d;
        return (method2 == null || (objInvoke = method2.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Member getMember() {
        return this.f3478a.getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final List getParameterTypes() {
        return this.f3478a.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        return this.f3478a.getReturnType();
    }
}
