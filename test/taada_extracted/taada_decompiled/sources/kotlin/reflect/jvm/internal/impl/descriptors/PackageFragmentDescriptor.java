package kotlin.reflect.jvm.internal.impl.descriptors;

import L2.c;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageFragmentDescriptor extends ClassOrPackageFragmentDescriptor {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ModuleDescriptor getContainingDeclaration();

    @NotNull
    c getFqName();

    @NotNull
    MemberScope getMemberScope();
}
