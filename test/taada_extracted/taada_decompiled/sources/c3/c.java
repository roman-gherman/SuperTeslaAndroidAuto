package c3;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import q2.L;
import q2.v;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends L {
    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, EnumC0709a enumC0709a, boolean z6) {
        copy(declarationDescriptor, enumC0719k, abstractC0714f, enumC0709a, z6);
        return this;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Object getUserData(CallableDescriptor.UserDataKey key) {
        kotlin.jvm.internal.h.f(key, "key");
        return null;
    }

    @Override // q2.v
    /* JADX INFO: renamed from: h */
    public final SimpleFunctionDescriptor copy(DeclarationDescriptor newOwner, EnumC0719k modality, AbstractC0714f visibility, EnumC0709a kind, boolean z6) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(modality, "modality");
        kotlin.jvm.internal.h.f(visibility, "visibility");
        kotlin.jvm.internal.h.f(kind, "kind");
        return this;
    }

    @Override // q2.L, q2.v
    public final v i(L2.f fVar, DeclarationDescriptor newOwner, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a kind) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(annotations, "annotations");
        return this;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isSuspend() {
        return false;
    }

    @Override // q2.L, q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor
    public final FunctionDescriptor.CopyBuilder newCopyBuilder() {
        return new b(this);
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final void setOverriddenDescriptors(Collection overriddenDescriptors) {
        kotlin.jvm.internal.h.f(overriddenDescriptors, "overriddenDescriptors");
    }
}
