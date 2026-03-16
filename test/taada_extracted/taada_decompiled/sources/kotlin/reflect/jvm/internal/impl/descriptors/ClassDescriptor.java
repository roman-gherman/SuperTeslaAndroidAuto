package kotlin.reflect.jvm.internal.impl.descriptors;

import a3.F;
import a3.W;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import n2.AbstractC0714f;
import n2.EnumC0711c;
import n2.EnumC0719k;
import n2.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ClassDescriptor extends ClassOrPackageFragmentDescriptor, ClassifierDescriptorWithTypeParameters {
    @Nullable
    ClassDescriptor getCompanionObjectDescriptor();

    @NotNull
    Collection<ClassConstructorDescriptor> getConstructors();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    DeclarationDescriptor getContainingDeclaration();

    @NotNull
    List<ReceiverParameterDescriptor> getContextReceivers();

    @NotNull
    List<TypeParameterDescriptor> getDeclaredTypeParameters();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    F getDefaultType();

    @NotNull
    EnumC0711c getKind();

    @NotNull
    MemberScope getMemberScope(@NotNull W w5);

    @NotNull
    EnumC0719k getModality();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ClassDescriptor getOriginal();

    @NotNull
    Collection<ClassDescriptor> getSealedSubclasses();

    @NotNull
    MemberScope getStaticScope();

    @NotNull
    ReceiverParameterDescriptor getThisAsReceiverParameter();

    @NotNull
    MemberScope getUnsubstitutedInnerClassesScope();

    @NotNull
    MemberScope getUnsubstitutedMemberScope();

    @Nullable
    ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor();

    @Nullable
    z getValueClassRepresentation();

    @NotNull
    AbstractC0714f getVisibility();

    boolean isCompanionObject();

    boolean isData();

    boolean isFun();

    boolean isInline();

    boolean isValue();
}
