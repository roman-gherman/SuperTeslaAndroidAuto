package q2;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes2.dex */
public abstract class D extends AbstractC0778o implements PackageFragmentDescriptor {
    public final L2.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4542f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(ModuleDescriptor module, L2.c fqName) {
        super(module, o2.f.b, fqName.g(), SourceElement.NO_SOURCE);
        kotlin.jvm.internal.h.f(module, "module");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        Annotations.Companion.getClass();
        this.e = fqName;
        this.f4542f = "package " + fqName + " of " + module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor visitor, Object obj) {
        kotlin.jvm.internal.h.f(visitor, "visitor");
        return visitor.visitPackageFragmentDescriptor(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public final L2.c getFqName() {
        return this.e;
    }

    @Override // q2.AbstractC0778o, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // q2.AbstractC0777n
    public String toString() {
        return this.f4542f;
    }

    @Override // q2.AbstractC0778o, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ModuleDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = super.getContainingDeclaration();
        kotlin.jvm.internal.h.d(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (ModuleDescriptor) containingDeclaration;
    }
}
