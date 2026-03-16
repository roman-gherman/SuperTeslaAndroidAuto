package kotlin.reflect.jvm.internal.impl.descriptors;

import L2.f;
import a3.AbstractC0162z;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ValueParameterDescriptor extends ParameterDescriptor, VariableDescriptor {
    @NotNull
    ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull f fVar, int i);

    boolean declaresDefaultValue();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    CallableDescriptor getContainingDeclaration();

    int getIndex();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ValueParameterDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    Collection<ValueParameterDescriptor> getOverriddenDescriptors();

    @Nullable
    AbstractC0162z getVarargElementType();

    boolean isCrossinline();

    boolean isNoinline();
}
