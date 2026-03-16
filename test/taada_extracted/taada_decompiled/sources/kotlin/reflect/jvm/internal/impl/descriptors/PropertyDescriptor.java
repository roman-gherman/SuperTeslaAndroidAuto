package kotlin.reflect.jvm.internal.impl.descriptors;

import a3.Z;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface PropertyDescriptor extends CallableMemberDescriptor, VariableDescriptorWithAccessors {
    @NotNull
    List<PropertyAccessorDescriptor> getAccessors();

    @Nullable
    FieldDescriptor getBackingField();

    @Nullable
    FieldDescriptor getDelegateField();

    @Nullable
    PropertyGetterDescriptor getGetter();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    PropertyDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    Collection<? extends PropertyDescriptor> getOverriddenDescriptors();

    @Nullable
    PropertySetterDescriptor getSetter();

    PropertyDescriptor substitute(@NotNull Z z6);
}
