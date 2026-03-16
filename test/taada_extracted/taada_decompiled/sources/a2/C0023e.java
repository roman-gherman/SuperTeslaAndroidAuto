package A2;

import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import z2.C0941a;
import z2.C0946f;

/* JADX INFO: renamed from: A2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0023e implements MemberScope {
    public static final /* synthetic */ KProperty[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0946f f32a;
    public final t b;
    public final z c;
    public final NotNullLazyValue d;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3817a;
        e = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(C0023e.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    public C0023e(C0946f c0946f, JavaPackage javaPackage, t packageFragment) {
        kotlin.jvm.internal.h.f(packageFragment, "packageFragment");
        this.f32a = c0946f;
        this.b = packageFragment;
        this.c = new z(c0946f, javaPackage, packageFragment);
        this.d = c0946f.f5203a.f5183a.createLazyValue(new C0022d(this, 0));
    }

    public final MemberScope[] a() {
        return (MemberScope[]) AbstractC0246d.T(this.d, e[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        MemberScope[] memberScopeArrA = a();
        kotlin.jvm.internal.h.f(memberScopeArrA, "<this>");
        HashSet hashSetL = AbstractC0246d.L(memberScopeArrA.length == 0 ? kotlin.collections.u.f3804a : new k3.q(memberScopeArrA, 1));
        if (hashSetL == null) {
            return null;
        }
        hashSetL.addAll(this.c.getClassifierNames());
        return hashSetL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        z zVar = this.c;
        zVar.getClass();
        ClassifierDescriptor classifierDescriptor = null;
        ClassDescriptor classDescriptorP = zVar.p(name, null);
        if (classDescriptorP != null) {
            return classDescriptorP;
        }
        for (MemberScope memberScope : a()) {
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
    public final Collection getContributedDescriptors(U2.f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        MemberScope[] memberScopeArrA = a();
        Collection<DeclarationDescriptor> contributedDescriptors = this.c.getContributedDescriptors(kindFilter, nameFilter);
        for (MemberScope memberScope : memberScopeArrA) {
            contributedDescriptors = AbstractC0246d.m(contributedDescriptors, memberScope.getContributedDescriptors(kindFilter, nameFilter));
        }
        return contributedDescriptors == null ? kotlin.collections.w.f3806a : contributedDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        MemberScope[] memberScopeArrA = a();
        Collection contributedFunctions = this.c.getContributedFunctions(name, location);
        for (MemberScope memberScope : memberScopeArrA) {
            contributedFunctions = AbstractC0246d.m(contributedFunctions, memberScope.getContributedFunctions(name, location));
        }
        return contributedFunctions == null ? kotlin.collections.w.f3806a : contributedFunctions;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        MemberScope[] memberScopeArrA = a();
        this.c.getContributedVariables(name, location);
        Collection collectionM = kotlin.collections.u.f3804a;
        for (MemberScope memberScope : memberScopeArrA) {
            collectionM = AbstractC0246d.m(collectionM, memberScope.getContributedVariables(name, location));
        }
        return collectionM == null ? kotlin.collections.w.f3806a : collectionM;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        MemberScope[] memberScopeArrA = a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArrA) {
            kotlin.collections.s.F(memberScope.getFunctionNames(), linkedHashSet);
        }
        linkedHashSet.addAll(this.c.getFunctionNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        MemberScope[] memberScopeArrA = a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArrA) {
            kotlin.collections.s.F(memberScope.getVariableNames(), linkedHashSet);
        }
        linkedHashSet.addAll(this.c.getVariableNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        C0941a c0941a = this.f32a.f5203a;
        Z.u(c0941a.f5191n, location, this.b, name);
    }

    public final String toString() {
        return "scope for " + this.b;
    }
}
