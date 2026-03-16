package c3;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends f {
    @Override // c3.f
    /* JADX INFO: renamed from: a */
    public final Set getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        throw new IllegalStateException(this.f1749a + ", required name: " + name);
    }

    @Override // c3.f
    /* JADX INFO: renamed from: b */
    public final Set getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        throw new IllegalStateException(this.f1749a + ", required name: " + name);
    }

    @Override // c3.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        throw new IllegalStateException();
    }

    @Override // c3.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        throw new IllegalStateException(this.f1749a + ", required name: " + name);
    }

    @Override // c3.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(U2.f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        throw new IllegalStateException(this.f1749a);
    }

    @Override // c3.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final /* bridge */ /* synthetic */ Collection getContributedFunctions(L2.f fVar, LookupLocation lookupLocation) {
        getContributedFunctions(fVar, lookupLocation);
        throw null;
    }

    @Override // c3.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final /* bridge */ /* synthetic */ Collection getContributedVariables(L2.f fVar, LookupLocation lookupLocation) {
        getContributedVariables(fVar, lookupLocation);
        throw null;
    }

    @Override // c3.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        throw new IllegalStateException();
    }

    @Override // c3.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        throw new IllegalStateException();
    }

    @Override // c3.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        throw new IllegalStateException();
    }

    @Override // c3.f
    public final String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("ThrowingScope{"), this.f1749a, '}');
    }
}
