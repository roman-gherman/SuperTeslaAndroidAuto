package kotlin.reflect.jvm.internal.impl.descriptors;

import L2.f;
import a3.AbstractC0162z;
import a3.W;
import a3.Z;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface FunctionDescriptor extends CallableMemberDescriptor {

    public interface CopyBuilder<D extends FunctionDescriptor> {
        @Nullable
        D build();

        @NotNull
        <V> CopyBuilder<D> putUserData(@NotNull CallableDescriptor.UserDataKey<V> userDataKey, V v6);

        @NotNull
        CopyBuilder<D> setAdditionalAnnotations(@NotNull Annotations annotations);

        @NotNull
        CopyBuilder<D> setCopyOverrides(boolean z6);

        @NotNull
        CopyBuilder<D> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor);

        @NotNull
        CopyBuilder<D> setDropOriginalInContainingParts();

        @NotNull
        CopyBuilder<D> setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor);

        @NotNull
        CopyBuilder<D> setHiddenForResolutionEverywhereBesideSupercalls();

        @NotNull
        CopyBuilder<D> setHiddenToOvercomeSignatureClash();

        @NotNull
        CopyBuilder<D> setKind(@NotNull EnumC0709a enumC0709a);

        @NotNull
        CopyBuilder<D> setModality(@NotNull EnumC0719k enumC0719k);

        @NotNull
        CopyBuilder<D> setName(@NotNull f fVar);

        @NotNull
        CopyBuilder<D> setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor);

        @NotNull
        CopyBuilder<D> setOwner(@NotNull DeclarationDescriptor declarationDescriptor);

        @NotNull
        CopyBuilder<D> setPreserveSourceElement();

        @NotNull
        CopyBuilder<D> setReturnType(@NotNull AbstractC0162z abstractC0162z);

        @NotNull
        CopyBuilder<D> setSignatureChange();

        @NotNull
        CopyBuilder<D> setSubstitution(@NotNull W w5);

        @NotNull
        CopyBuilder<D> setTypeParameters(@NotNull List<TypeParameterDescriptor> list);

        @NotNull
        CopyBuilder<D> setValueParameters(@NotNull List<ValueParameterDescriptor> list);

        @NotNull
        CopyBuilder<D> setVisibility(@NotNull AbstractC0714f abstractC0714f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    DeclarationDescriptor getContainingDeclaration();

    @Nullable
    FunctionDescriptor getInitialSignatureDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    FunctionDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    Collection<? extends FunctionDescriptor> getOverriddenDescriptors();

    boolean isHiddenForResolutionEverywhereBesideSupercalls();

    boolean isHiddenToOvercomeSignatureClash();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    boolean isTailrec();

    @NotNull
    CopyBuilder<? extends FunctionDescriptor> newCopyBuilder();

    @Nullable
    FunctionDescriptor substitute(@NotNull Z z6);
}
