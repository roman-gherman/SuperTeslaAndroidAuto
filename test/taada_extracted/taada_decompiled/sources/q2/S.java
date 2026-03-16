package q2;

import a3.AbstractC0162z;
import a3.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0709a;

/* JADX INFO: loaded from: classes2.dex */
public class S extends T implements ValueParameterDescriptor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4582h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AbstractC0162z f4583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ValueParameterDescriptor f4584k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(CallableDescriptor containingDeclaration, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations annotations, L2.f name, AbstractC0162z outType, boolean z6, boolean z7, boolean z8, AbstractC0162z abstractC0162z, SourceElement source) {
        super(containingDeclaration, annotations, name, outType, source);
        kotlin.jvm.internal.h.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.h.f(annotations, "annotations");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(outType, "outType");
        kotlin.jvm.internal.h.f(source, "source");
        this.f4580f = i;
        this.f4581g = z6;
        this.f4582h = z7;
        this.i = z8;
        this.f4583j = abstractC0162z;
        this.f4584k = valueParameterDescriptor == null ? this : valueParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor visitor, Object obj) {
        kotlin.jvm.internal.h.f(visitor, "visitor");
        return visitor.visitValueParameterDescriptor(this, obj);
    }

    public ValueParameterDescriptor copy(CallableDescriptor newOwner, L2.f newName, int i) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(newName, "newName");
        Annotations annotations = getAnnotations();
        kotlin.jvm.internal.h.e(annotations, "annotations");
        AbstractC0162z type = getType();
        kotlin.jvm.internal.h.e(type, "type");
        boolean zDeclaresDefaultValue = declaresDefaultValue();
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
        return new S(newOwner, null, i, annotations, newName, type, zDeclaresDefaultValue, this.f4582h, this.i, this.f4583j, NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public final boolean declaresDefaultValue() {
        if (!this.f4581g) {
            return false;
        }
        EnumC0709a kind = ((CallableMemberDescriptor) getContainingDeclaration()).getKind();
        kind.getClass();
        return kind != EnumC0709a.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final /* bridge */ /* synthetic */ P2.g getCompileTimeInitializer() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public final int getIndex() {
        return this.f4580f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Collection getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        kotlin.jvm.internal.h.e(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(overriddenDescriptors));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(((CallableDescriptor) it.next()).getValueParameters().get(this.f4580f));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public final AbstractC0162z getVarargElementType() {
        return this.f4583j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        C0712d LOCAL = AbstractC0713e.f4233f;
        kotlin.jvm.internal.h.e(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public final boolean isCrossinline() {
        return this.f4582h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final boolean isLateInit() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public final boolean isNoinline() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final boolean isVar() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final DeclarationDescriptorNonRoot substitute(Z substitutor) {
        kotlin.jvm.internal.h.f(substitutor, "substitutor");
        if (substitutor.f1542a.e()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // q2.AbstractC0778o, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final CallableDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = super.getContainingDeclaration();
        kotlin.jvm.internal.h.d(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (CallableDescriptor) containingDeclaration;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.f4584k;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final VariableDescriptor substitute(Z substitutor) {
        kotlin.jvm.internal.h.f(substitutor, "substitutor");
        if (substitutor.f1542a.e()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }
}
