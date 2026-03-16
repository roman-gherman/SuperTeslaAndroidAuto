package kotlin.reflect.jvm.internal.impl.descriptors;

import a3.F;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ClassifierDescriptor extends DeclarationDescriptorNonRoot {
    @NotNull
    F getDefaultType();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ClassifierDescriptor getOriginal();

    @NotNull
    TypeConstructor getTypeConstructor();
}
