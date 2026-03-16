package U2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemberScope f1334a;

    public i(MemberScope workerScope) {
        kotlin.jvm.internal.h.f(workerScope, "workerScope");
        this.f1334a = workerScope;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        return this.f1334a.getClassifierNames();
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        ClassifierDescriptor contributedClassifier = this.f1334a.getContributedClassifier(name, location);
        if (contributedClassifier != null) {
            ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
            if (classDescriptor != null) {
                return classDescriptor;
            }
            if (contributedClassifier instanceof TypeAliasDescriptor) {
                return (TypeAliasDescriptor) contributedClassifier;
            }
        }
        return null;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        int i = f.f1325l & kindFilter.b;
        f fVar = i == 0 ? null : new f(i, kindFilter.f1332a);
        if (fVar == null) {
            return u.f3804a;
        }
        Collection<DeclarationDescriptor> contributedDescriptors = this.f1334a.getContributedDescriptors(fVar, nameFilter);
        ArrayList arrayList = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        return this.f1334a.getFunctionNames();
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        return this.f1334a.getVariableNames();
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        this.f1334a.recordLookup(name, location);
    }

    public final String toString() {
        return "Classes from " + this.f1334a;
    }
}
