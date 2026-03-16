package kotlin.reflect.jvm.internal.impl.types;

import a3.AbstractC0162z;
import b3.d;
import java.util.Collection;
import java.util.List;
import k2.i;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeConstructor extends TypeConstructorMarker {
    @NotNull
    i getBuiltIns();

    @Nullable
    ClassifierDescriptor getDeclarationDescriptor();

    @NotNull
    List<TypeParameterDescriptor> getParameters();

    @NotNull
    Collection<AbstractC0162z> getSupertypes();

    boolean isDenotable();

    @NotNull
    TypeConstructor refine(@NotNull d dVar);
}
