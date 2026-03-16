package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import L2.f;
import U2.l;
import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface MemberScope extends ResolutionScope {

    @NotNull
    public static final l Companion = l.f1337a;

    @Nullable
    Set<f> getClassifierNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull f fVar, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull f fVar, @NotNull LookupLocation lookupLocation);

    @NotNull
    Set<f> getFunctionNames();

    @NotNull
    Set<f> getVariableNames();
}
