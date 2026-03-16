package D2;

import a3.AbstractC0162z;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f261a = new p(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CallableMemberDescriptor it = (CallableMemberDescriptor) obj;
        kotlin.jvm.internal.h.f(it, "it");
        ReceiverParameterDescriptor extensionReceiverParameter = it.getExtensionReceiverParameter();
        kotlin.jvm.internal.h.c(extensionReceiverParameter);
        AbstractC0162z type = extensionReceiverParameter.getType();
        kotlin.jvm.internal.h.e(type, "it.extensionReceiverParameter!!.type");
        return type;
    }
}
