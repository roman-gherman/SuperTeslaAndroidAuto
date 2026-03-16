package kotlin.reflect.jvm.internal.impl.descriptors;

import a3.AbstractC0162z;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface CallableDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility, Substitutable<CallableDescriptor> {

    public interface UserDataKey<V> {
    }

    @NotNull
    List<ReceiverParameterDescriptor> getContextReceiverParameters();

    @Nullable
    ReceiverParameterDescriptor getDispatchReceiverParameter();

    @Nullable
    ReceiverParameterDescriptor getExtensionReceiverParameter();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    CallableDescriptor getOriginal();

    @NotNull
    Collection<? extends CallableDescriptor> getOverriddenDescriptors();

    @Nullable
    AbstractC0162z getReturnType();

    @NotNull
    List<TypeParameterDescriptor> getTypeParameters();

    @Nullable
    <V> V getUserData(UserDataKey<V> userDataKey);

    @NotNull
    List<ValueParameterDescriptor> getValueParameters();

    boolean hasSynthesizedParameterNames();
}
