package U2;

import c4.AbstractC0246d;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements MemberScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1316a;
    public final MemberScope[] b;

    public a(String str, MemberScope[] memberScopeArr) {
        this.f1316a = str;
        this.b = memberScopeArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        MemberScope[] memberScopeArr = this.b;
        kotlin.jvm.internal.h.f(memberScopeArr, "<this>");
        return AbstractC0246d.L(memberScopeArr.length == 0 ? u.f3804a : new k3.q(memberScopeArr, 1));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope memberScope : this.b) {
            ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(name, location);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return u.f3804a;
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedDescriptors(kindFilter, nameFilter);
        }
        Collection collectionM = null;
        for (MemberScope memberScope : memberScopeArr) {
            collectionM = AbstractC0246d.m(collectionM, memberScope.getContributedDescriptors(kindFilter, nameFilter));
        }
        return collectionM == null ? w.f3806a : collectionM;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return u.f3804a;
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedFunctions(name, location);
        }
        Collection collectionM = null;
        for (MemberScope memberScope : memberScopeArr) {
            collectionM = AbstractC0246d.m(collectionM, memberScope.getContributedFunctions(name, location));
        }
        return collectionM == null ? w.f3806a : collectionM;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        MemberScope[] memberScopeArr = this.b;
        int length = memberScopeArr.length;
        if (length == 0) {
            return u.f3804a;
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedVariables(name, location);
        }
        Collection collectionM = null;
        for (MemberScope memberScope : memberScopeArr) {
            collectionM = AbstractC0246d.m(collectionM, memberScope.getContributedVariables(name, location));
        }
        return collectionM == null ? w.f3806a : collectionM;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : this.b) {
            kotlin.collections.s.F(memberScope.getFunctionNames(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : this.b) {
            kotlin.collections.s.F(memberScope.getVariableNames(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        for (MemberScope memberScope : this.b) {
            memberScope.recordLookup(name, location);
        }
    }

    public final String toString() {
        return this.f1316a;
    }
}
