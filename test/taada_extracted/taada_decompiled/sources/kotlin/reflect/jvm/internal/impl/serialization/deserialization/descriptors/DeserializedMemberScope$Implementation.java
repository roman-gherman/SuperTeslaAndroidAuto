package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
interface DeserializedMemberScope$Implementation {
    void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull U2.f fVar, @NotNull Function1<? super L2.f, Boolean> function1, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull L2.f fVar, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<PropertyDescriptor> getContributedVariables(@NotNull L2.f fVar, @NotNull LookupLocation lookupLocation);

    @NotNull
    Set<L2.f> getFunctionNames();

    @Nullable
    TypeAliasDescriptor getTypeAliasByName(@NotNull L2.f fVar);

    @NotNull
    Set<L2.f> getTypeAliasNames();

    @NotNull
    Set<L2.f> getVariableNames();
}
