package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface DescriptorRenderer$ValueParametersHandler {
    void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i3, @NotNull StringBuilder sb);

    void appendAfterValueParameters(int i, @NotNull StringBuilder sb);

    void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i3, @NotNull StringBuilder sb);

    void appendBeforeValueParameters(int i, @NotNull StringBuilder sb);
}
