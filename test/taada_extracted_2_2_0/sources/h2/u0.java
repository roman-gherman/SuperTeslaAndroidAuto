package h2;

import a3.AbstractC0162z;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final M2.s f3434a = M2.n.f1060a;

    public static void a(StringBuilder sb, CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor receiverParameterDescriptorG = x0.g(callableMemberDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        if (receiverParameterDescriptorG != null) {
            AbstractC0162z type = receiverParameterDescriptorG.getType();
            kotlin.jvm.internal.h.e(type, "receiver.type");
            sb.append(d(type));
            sb.append(".");
        }
        boolean z6 = (receiverParameterDescriptorG == null || extensionReceiverParameter == null) ? false : true;
        if (z6) {
            sb.append("(");
        }
        if (extensionReceiverParameter != null) {
            AbstractC0162z type2 = extensionReceiverParameter.getType();
            kotlin.jvm.internal.h.e(type2, "receiver.type");
            sb.append(d(type2));
            sb.append(".");
        }
        if (z6) {
            sb.append(")");
        }
    }

    public static String b(FunctionDescriptor descriptor) {
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        a(sb, descriptor);
        L2.f name = descriptor.getName();
        kotlin.jvm.internal.h.e(name, "descriptor.name");
        sb.append(f3434a.a(name, true));
        List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
        kotlin.jvm.internal.h.e(valueParameters, "descriptor.valueParameters");
        kotlin.collections.m.U(valueParameters, sb, ", ", "(", ")", C0499b.f3395k, 48);
        sb.append(": ");
        AbstractC0162z returnType = descriptor.getReturnType();
        kotlin.jvm.internal.h.c(returnType);
        sb.append(d(returnType));
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static String c(PropertyDescriptor descriptor) {
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(descriptor.isVar() ? "var " : "val ");
        a(sb, descriptor);
        L2.f name = descriptor.getName();
        kotlin.jvm.internal.h.e(name, "descriptor.name");
        sb.append(f3434a.a(name, true));
        sb.append(": ");
        AbstractC0162z type = descriptor.getType();
        kotlin.jvm.internal.h.e(type, "descriptor.type");
        sb.append(d(type));
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static String d(AbstractC0162z type) {
        kotlin.jvm.internal.h.f(type, "type");
        return f3434a.M(type);
    }
}
