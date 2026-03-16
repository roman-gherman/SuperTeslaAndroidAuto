package M2;

import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements DescriptorRenderer$ValueParametersHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f1059a = new m();

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler
    public final void appendAfterValueParameter(ValueParameterDescriptor parameter, int i, int i3, StringBuilder builder) {
        kotlin.jvm.internal.h.f(parameter, "parameter");
        kotlin.jvm.internal.h.f(builder, "builder");
        if (i != i3 - 1) {
            builder.append(", ");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler
    public final void appendAfterValueParameters(int i, StringBuilder builder) {
        kotlin.jvm.internal.h.f(builder, "builder");
        builder.append(")");
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler
    public final void appendBeforeValueParameter(ValueParameterDescriptor parameter, int i, int i3, StringBuilder builder) {
        kotlin.jvm.internal.h.f(parameter, "parameter");
        kotlin.jvm.internal.h.f(builder, "builder");
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler
    public final void appendBeforeValueParameters(int i, StringBuilder builder) {
        kotlin.jvm.internal.h.f(builder, "builder");
        builder.append("(");
    }
}
