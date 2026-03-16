package U2;

import A2.C0022d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements MemberScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1335a = 1;
    public final Object b;

    public j(MemberScope memberScope) {
        this.b = memberScope;
    }

    public final MemberScope a() {
        if (!(e() instanceof j)) {
            return e();
        }
        MemberScope memberScopeE = e();
        kotlin.jvm.internal.h.d(memberScopeE, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((j) memberScopeE).a();
    }

    public final Collection b(f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return e().getContributedDescriptors(kindFilter, nameFilter);
    }

    public final Collection c(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return e().getContributedFunctions(name, location);
    }

    public final Collection d(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return e().getContributedVariables(name, location);
    }

    public final MemberScope e() {
        switch (this.f1335a) {
            case 0:
                return (MemberScope) ((NotNullLazyValue) this.b).invoke();
            default:
                return (MemberScope) this.b;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        return e().getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return e().getContributedClassifier(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection getContributedDescriptors(f kindFilter, Function1 nameFilter) {
        switch (this.f1335a) {
            case 1:
                kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
                kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
                Collection collectionB = b(kindFilter, nameFilter);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : collectionB) {
                    if (((DeclarationDescriptor) obj) instanceof CallableDescriptor) {
                        arrayList.add(obj);
                    } else {
                        arrayList2.add(obj);
                    }
                }
                return kotlin.collections.m.b0(arrayList2, N2.q.o(arrayList, r.f1342a));
            default:
                return b(kindFilter, nameFilter);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection getContributedFunctions(L2.f name, LookupLocation location) {
        switch (this.f1335a) {
            case 1:
                kotlin.jvm.internal.h.f(name, "name");
                kotlin.jvm.internal.h.f(location, "location");
                return N2.q.o(c(name, location), s.f1343a);
            default:
                return c(name, location);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection getContributedVariables(L2.f name, LookupLocation location) {
        switch (this.f1335a) {
            case 1:
                kotlin.jvm.internal.h.f(name, "name");
                kotlin.jvm.internal.h.f(location, "location");
                return N2.q.o(d(name, location), t.f1344a);
            default:
                return d(name, location);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        return e().getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        return e().getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        e().recordLookup(name, location);
    }

    public j(StorageManager storageManager, Function0 function0) {
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        this.b = storageManager.createLazyValue(new C0022d(function0, 5));
    }
}
