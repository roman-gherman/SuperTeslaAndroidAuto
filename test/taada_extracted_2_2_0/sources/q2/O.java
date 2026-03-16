package q2;

import a3.AbstractC0162z;
import a3.Z;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;

/* JADX INFO: loaded from: classes2.dex */
public final class O extends v implements TypeAliasConstructorDescriptor {
    public static final N I;
    public static final /* synthetic */ KProperty[] J;
    public final StorageManager E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p f4576F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final NullableLazyValue f4577G;
    public ClassConstructorDescriptor H;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        J = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(O.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
        I = new N();
    }

    public O(StorageManager storageManager, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p pVar, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, EnumC0709a enumC0709a, SourceElement sourceElement) {
        super(L2.h.e, pVar, typeAliasConstructorDescriptor, sourceElement, annotations, enumC0709a);
        this.E = storageManager;
        this.f4576F = pVar;
        this.f4640s = false;
        this.f4577G = storageManager.createNullableLazyValue(new A2.y(13, this, classConstructorDescriptor));
        this.H = classConstructorDescriptor;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public final CallableMemberDescriptor copy(DeclarationDescriptor newOwner, EnumC0719k modality, AbstractC0714f visibility, EnumC0709a kind, boolean z6) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(modality, "modality");
        kotlin.jvm.internal.h.f(visibility, "visibility");
        kotlin.jvm.internal.h.f(kind, "kind");
        C0783u c0783uM = m(Z.b);
        c0783uM.b = newOwner;
        c0783uM.c = modality;
        c0783uM.d = visibility;
        c0783uM.f4611f = kind;
        c0783uM.f4617m = z6;
        CallableDescriptor callableDescriptorJ = c0783uM.x.j(c0783uM);
        kotlin.jvm.internal.h.d(callableDescriptorJ, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) callableDescriptorJ;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public final ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = this.H.getConstructedClass();
        kotlin.jvm.internal.h.e(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @Override // q2.AbstractC0778o, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return this.f4576F;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final AbstractC0162z getReturnType() {
        AbstractC0162z abstractC0162z = this.f4630g;
        kotlin.jvm.internal.h.c(abstractC0162z);
        return abstractC0162z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor
    public final ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.H;
    }

    @Override // q2.v
    public final v i(L2.f fVar, DeclarationDescriptor newOwner, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a kind) {
        kotlin.jvm.internal.h.f(newOwner, "newOwner");
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(annotations, "annotations");
        EnumC0709a enumC0709a = EnumC0709a.f4227a;
        if (kind != enumC0709a) {
            EnumC0709a enumC0709a2 = EnumC0709a.d;
        }
        return new O(this.E, this.f4576F, this.H, this, annotations, enumC0709a, sourceElement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public final boolean isPrimary() {
        return this.H.isPrimary();
    }

    @Override // q2.v, q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor original = super.getOriginal();
        kotlin.jvm.internal.h.d(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) original;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final O substitute(Z substitutor) {
        kotlin.jvm.internal.h.f(substitutor, "substitutor");
        FunctionDescriptor functionDescriptorSubstitute = super.substitute(substitutor);
        kotlin.jvm.internal.h.d(functionDescriptorSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        O o6 = (O) functionDescriptorSubstitute;
        AbstractC0162z abstractC0162z = o6.f4630g;
        kotlin.jvm.internal.h.c(abstractC0162z);
        ClassConstructorDescriptor classConstructorDescriptorSubstitute = this.H.getOriginal().substitute(Z.d(abstractC0162z));
        if (classConstructorDescriptorSubstitute == null) {
            return null;
        }
        o6.H = classConstructorDescriptorSubstitute;
        return o6;
    }

    @Override // q2.AbstractC0778o, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        return this.f4576F;
    }
}
