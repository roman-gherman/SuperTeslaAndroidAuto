package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import L2.f;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ResolutionScope {
    @Nullable
    ClassifierDescriptor getContributedClassifier(@NotNull f fVar, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull U2.f fVar, @NotNull Function1<? super f, Boolean> function1);

    @NotNull
    Collection<? extends FunctionDescriptor> getContributedFunctions(@NotNull f fVar, @NotNull LookupLocation lookupLocation);

    void recordLookup(@NotNull f fVar, @NotNull LookupLocation lookupLocation);
}
