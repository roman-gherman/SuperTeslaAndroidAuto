package c3;

import a3.AbstractC0162z;
import a3.W;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements FunctionDescriptor.CopyBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f1746a;

    public b(c cVar) {
        this.f1746a = cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor build() {
        return this.f1746a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder putUserData(CallableDescriptor.UserDataKey userDataKey, Object obj) {
        kotlin.jvm.internal.h.f(userDataKey, "userDataKey");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setAdditionalAnnotations(Annotations additionalAnnotations) {
        kotlin.jvm.internal.h.f(additionalAnnotations, "additionalAnnotations");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setCopyOverrides(boolean z6) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setDropOriginalInContainingParts() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setHiddenForResolutionEverywhereBesideSupercalls() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setHiddenToOvercomeSignatureClash() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setKind(EnumC0709a kind) {
        kotlin.jvm.internal.h.f(kind, "kind");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setModality(EnumC0719k modality) {
        kotlin.jvm.internal.h.f(modality, "modality");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setName(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setOwner(DeclarationDescriptor owner) {
        kotlin.jvm.internal.h.f(owner, "owner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setPreserveSourceElement() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setReturnType(AbstractC0162z type) {
        kotlin.jvm.internal.h.f(type, "type");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setSignatureChange() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setSubstitution(W substitution) {
        kotlin.jvm.internal.h.f(substitution, "substitution");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setTypeParameters(List parameters) {
        kotlin.jvm.internal.h.f(parameters, "parameters");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setValueParameters(List parameters) {
        kotlin.jvm.internal.h.f(parameters, "parameters");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
    public final FunctionDescriptor.CopyBuilder setVisibility(AbstractC0714f visibility) {
        kotlin.jvm.internal.h.f(visibility, "visibility");
        return this;
    }
}
