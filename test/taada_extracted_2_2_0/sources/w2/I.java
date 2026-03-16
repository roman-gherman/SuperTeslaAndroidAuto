package w2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final I f4989a = new I(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CallableMemberDescriptor it = (CallableMemberDescriptor) obj;
        kotlin.jvm.internal.h.f(it, "it");
        int i = AbstractC0871e.f5009l;
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) it;
        return Boolean.valueOf(k2.i.y(simpleFunctionDescriptor) && R2.e.b(simpleFunctionDescriptor, new t2.q(simpleFunctionDescriptor, 3)) != null);
    }
}
