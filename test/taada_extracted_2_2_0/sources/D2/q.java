package D2;

import a3.AbstractC0162z;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f262a = new q(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CallableMemberDescriptor it = (CallableMemberDescriptor) obj;
        kotlin.jvm.internal.h.f(it, "it");
        AbstractC0162z returnType = it.getReturnType();
        kotlin.jvm.internal.h.c(returnType);
        return returnType;
    }
}
