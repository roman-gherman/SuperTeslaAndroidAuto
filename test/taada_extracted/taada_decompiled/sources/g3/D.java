package g3;

import c4.AbstractC0246d;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* JADX INFO: loaded from: classes2.dex */
public abstract class D implements Check {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlin.jvm.internal.i f3305a;
    public final String b;

    /* JADX WARN: Multi-variable type inference failed */
    public D(String str, Function1 function1) {
        this.f3305a = (kotlin.jvm.internal.i) function1;
        this.b = "must return ".concat(str);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final boolean check(FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
        return kotlin.jvm.internal.h.a(functionDescriptor.getReturnType(), this.f3305a.invoke(R2.e.e(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final String getDescription() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final String invoke(FunctionDescriptor functionDescriptor) {
        return AbstractC0246d.X(this, functionDescriptor);
    }
}
