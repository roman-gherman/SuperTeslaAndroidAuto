package kotlin.reflect.jvm.internal.impl.descriptors;

import a3.AbstractC0162z;
import a3.d0;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeParameterDescriptor extends ClassifierDescriptor, TypeParameterMarker {
    int getIndex();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    TypeParameterDescriptor getOriginal();

    @NotNull
    StorageManager getStorageManager();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    TypeConstructor getTypeConstructor();

    @NotNull
    List<AbstractC0162z> getUpperBounds();

    @NotNull
    d0 getVariance();

    boolean isCapturedFromOuterDeclaration();

    boolean isReified();
}
