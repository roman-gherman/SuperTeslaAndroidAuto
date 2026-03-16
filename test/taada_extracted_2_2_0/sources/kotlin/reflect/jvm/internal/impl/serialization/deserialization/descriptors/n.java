package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import G2.H;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import q2.I;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends I implements DeserializedCallableMemberDescriptor {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final H f3922A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final NameResolver f3923B;
    public final I2.f C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final I2.g f3924D;
    public final E2.g E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(DeclarationDescriptor containingDeclaration, PropertyDescriptor propertyDescriptor, Annotations annotations, EnumC0719k modality, AbstractC0714f visibility, boolean z6, L2.f name, EnumC0709a kind, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, H proto, NameResolver nameResolver, I2.f typeTable, I2.g versionRequirementTable, E2.g gVar) {
        super(containingDeclaration, propertyDescriptor, annotations, modality, visibility, z6, name, kind, SourceElement.NO_SOURCE, z7, z8, z11, z9, z10);
        kotlin.jvm.internal.h.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.h.f(annotations, "annotations");
        kotlin.jvm.internal.h.f(modality, "modality");
        kotlin.jvm.internal.h.f(visibility, "visibility");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        kotlin.jvm.internal.h.f(versionRequirementTable, "versionRequirementTable");
        this.f3922A = proto;
        this.f3923B = nameResolver;
        this.C = typeTable;
        this.f3924D = versionRequirementTable;
        this.E = gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final DeserializedContainerSource getContainerSource() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final NameResolver getNameResolver() {
        return this.f3923B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final MessageLite getProto() {
        return this.f3922A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final I2.f getTypeTable() {
        return this.C;
    }

    @Override // q2.I, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExternal() {
        return I2.e.f767D.c(this.f3922A.d).booleanValue();
    }

    @Override // q2.I
    public final I j(DeclarationDescriptor newOwner, EnumC0719k newModality, AbstractC0714f newVisibility, PropertyDescriptor propertyDescriptor, EnumC0709a kind, L2.f newName, SourceElement sourceElement) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(newModality, "newModality");
        kotlin.jvm.internal.h.f(newVisibility, "newVisibility");
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(newName, "newName");
        return new n(newOwner, propertyDescriptor, getAnnotations(), newModality, newVisibility, this.f4586f, newName, kind, this.f4562n, this.f4563o, isExternal(), this.f4565r, this.f4564p, this.f3922A, this.f3923B, this.C, this.f3924D, this.E);
    }
}
