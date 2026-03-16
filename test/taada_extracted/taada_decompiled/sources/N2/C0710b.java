package n2;

import a3.d0;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: renamed from: n2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0710b implements TypeParameterDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeParameterDescriptor f4227a;
    public final ClassifierDescriptorWithTypeParameters b;
    public final int c;

    public C0710b(TypeParameterDescriptor typeParameterDescriptor, ClassifierDescriptorWithTypeParameters declarationDescriptor, int i) {
        kotlin.jvm.internal.h.f(declarationDescriptor, "declarationDescriptor");
        this.f4227a = typeParameterDescriptor;
        this.b = declarationDescriptor;
        this.c = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return this.f4227a.accept(declarationDescriptorVisitor, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        return this.f4227a.getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final a3.F getDefaultType() {
        return this.f4227a.getDefaultType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final int getIndex() {
        return this.f4227a.getIndex() + this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public final L2.f getName() {
        return this.f4227a.getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public final SourceElement getSource() {
        return this.f4227a.getSource();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final StorageManager getStorageManager() {
        return this.f4227a.getStorageManager();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        return this.f4227a.getTypeConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final List getUpperBounds() {
        return this.f4227a.getUpperBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final d0 getVariance() {
        return this.f4227a.getVariance();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final boolean isReified() {
        return this.f4227a.isReified();
    }

    public final String toString() {
        return this.f4227a + "[inner-copy]";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor original = this.f4227a.getOriginal();
        kotlin.jvm.internal.h.e(original, "originalDescriptor.original");
        return original;
    }
}
