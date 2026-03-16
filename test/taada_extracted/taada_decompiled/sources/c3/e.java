package c3;

import a3.AbstractC0162z;
import a3.Z;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import q2.I;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements PropertyDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f1748a;

    public e() {
        j jVar = j.f1775a;
        C0242a c0242a = j.c;
        Annotations.Companion.getClass();
        I i = I.i(c0242a, EnumC0719k.c, AbstractC0713e.e, true, L2.f.g("<Error property>"), EnumC0709a.f4226a, SourceElement.NO_SOURCE);
        g gVar = j.e;
        u uVar = u.f3804a;
        i.m(gVar, uVar, null, null, uVar);
        this.f1748a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        I i = this.f1748a;
        i.getClass();
        return declarationDescriptorVisitor.visitPropertyDescriptor(i, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, EnumC0709a enumC0709a, boolean z6) {
        return this.f1748a.copy(declarationDescriptor, enumC0719k, abstractC0714f, enumC0709a, z6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final List getAccessors() {
        return this.f1748a.getAccessors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        Annotations annotations = this.f1748a.getAnnotations();
        kotlin.jvm.internal.h.e(annotations, "<get-annotations>(...)");
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final FieldDescriptor getBackingField() {
        return this.f1748a.y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final P2.g getCompileTimeInitializer() {
        return this.f1748a.getCompileTimeInitializer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        return this.f1748a.getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getContextReceiverParameters() {
        return this.f1748a.getContextReceiverParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final FieldDescriptor getDelegateField() {
        return this.f1748a.f4569z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.f1748a.f4566t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.f1748a.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final PropertyGetterDescriptor getGetter() {
        return this.f1748a.f4568w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final EnumC0709a getKind() {
        return this.f1748a.getKind();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        return this.f1748a.getModality();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public final L2.f getName() {
        return this.f1748a.getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final CallableDescriptor getOriginal() {
        return this.f1748a.getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Collection getOverriddenDescriptors() {
        return this.f1748a.getOverriddenDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final AbstractC0162z getReturnType() {
        return this.f1748a.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public final PropertySetterDescriptor getSetter() {
        return this.f1748a.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public final SourceElement getSource() {
        return this.f1748a.getSource();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    public final AbstractC0162z getType() {
        return this.f1748a.getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getTypeParameters() {
        return this.f1748a.getTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Object getUserData(CallableDescriptor.UserDataKey userDataKey) {
        this.f1748a.getClass();
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final List getValueParameters() {
        this.f1748a.getValueParameters();
        return Collections.EMPTY_LIST;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        return this.f1748a.getVisibility();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final boolean hasSynthesizedParameterNames() {
        this.f1748a.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        this.f1748a.getClass();
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final boolean isConst() {
        return this.f1748a.f4562o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public final boolean isDelegated() {
        return this.f1748a.f4564r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExpect() {
        return this.f1748a.f4563p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExternal() {
        return this.f1748a.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final boolean isLateInit() {
        return this.f1748a.f4561n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final boolean isVar() {
        return this.f1748a.f4585f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final void setOverriddenDescriptors(Collection overriddenDescriptors) {
        kotlin.jvm.internal.h.f(overriddenDescriptors, "overriddenDescriptors");
        this.f1748a.f4558k = overriddenDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final PropertyDescriptor substitute(Z substitutor) {
        kotlin.jvm.internal.h.f(substitutor, "substitutor");
        return this.f1748a.substitute(substitutor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final CallableMemberDescriptor getOriginal() {
        return this.f1748a.getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getOriginal() {
        return this.f1748a.getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final PropertyDescriptor getOriginal() {
        return this.f1748a.getOriginal();
    }
}
