package U2;

import A2.C0022d;
import a.AbstractC0132a;
import a3.W;
import a3.Z;
import c4.AbstractC0246d;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements MemberScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemberScope f1341a;
    public final Z b;
    public HashMap c;
    public final N1.j d;

    public q(MemberScope workerScope, Z givenSubstitutor) {
        kotlin.jvm.internal.h.f(workerScope, "workerScope");
        kotlin.jvm.internal.h.f(givenSubstitutor, "givenSubstitutor");
        this.f1341a = workerScope;
        AbstractC0132a.M(new C0022d(givenSubstitutor, 7));
        W wG = givenSubstitutor.g();
        kotlin.jvm.internal.h.e(wG, "givenSubstitutor.substitution");
        this.b = Z.e(AbstractC0246d.N0(wG));
        this.d = AbstractC0132a.M(new C0022d(this, 6));
    }

    public final Collection a(Collection collection) {
        if (this.b.f1542a.e() || collection.isEmpty()) {
            return collection;
        }
        int size = collection.size();
        LinkedHashSet linkedHashSet = new LinkedHashSet(size >= 3 ? (size / 3) + size + 1 : 3);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(b((DeclarationDescriptor) it.next()));
        }
        return linkedHashSet;
    }

    public final DeclarationDescriptor b(DeclarationDescriptor declarationDescriptor) {
        Z z6 = this.b;
        if (z6.f1542a.e()) {
            return declarationDescriptor;
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        HashMap map = this.c;
        kotlin.jvm.internal.h.c(map);
        Object objSubstitute = map.get(declarationDescriptor);
        if (objSubstitute == null) {
            if (!(declarationDescriptor instanceof Substitutable)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + declarationDescriptor).toString());
            }
            objSubstitute = ((Substitutable) declarationDescriptor).substitute(z6);
            if (objSubstitute == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + declarationDescriptor + " substitution fails");
            }
            map.put(declarationDescriptor, objSubstitute);
        }
        return (DeclarationDescriptor) objSubstitute;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        return this.f1341a.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        ClassifierDescriptor contributedClassifier = this.f1341a.getContributedClassifier(name, location);
        if (contributedClassifier != null) {
            return (ClassifierDescriptor) b(contributedClassifier);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return (Collection) this.d.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return a(this.f1341a.getContributedFunctions(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return a(this.f1341a.getContributedVariables(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        return this.f1341a.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        return this.f1341a.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        getContributedFunctions(name, location);
    }
}
