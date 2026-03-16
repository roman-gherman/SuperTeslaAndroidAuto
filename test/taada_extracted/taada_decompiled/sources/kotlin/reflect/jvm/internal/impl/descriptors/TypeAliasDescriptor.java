package kotlin.reflect.jvm.internal.impl.descriptors;

import a3.F;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeAliasDescriptor extends ClassifierDescriptorWithTypeParameters {
    @Nullable
    ClassDescriptor getClassDescriptor();

    @NotNull
    F getExpandedType();

    @NotNull
    F getUnderlyingType();
}
