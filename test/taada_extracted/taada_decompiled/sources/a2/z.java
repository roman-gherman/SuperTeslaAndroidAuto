package A2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends O {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JavaPackage f76m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t f77n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NullableLazyValue f78o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MemoizedFunctionToNullable f79p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(C0946f c0946f, JavaPackage javaPackage, t ownerDescriptor) {
        super(c0946f, null);
        kotlin.jvm.internal.h.f(ownerDescriptor, "ownerDescriptor");
        this.f76m = javaPackage;
        this.f77n = ownerDescriptor;
        Z2.n nVar = c0946f.f5203a.f5183a;
        this.f78o = nVar.createNullableLazyValue(new y(0, c0946f, this));
        this.f79p = nVar.createMemoizedFunctionWithNullableValues(new q(2, this, c0946f));
    }

    public static final K2.f o(z zVar) {
        return j3.p.g(zVar.f11a.f5203a.d.c().c);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // A2.G
    public final Set a(U2.f kindFilter, U2.k kVar) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        if (!kindFilter.a(U2.f.e)) {
            return kotlin.collections.w.f3806a;
        }
        Set set = (Set) this.f78o.invoke();
        Function1<? super L2.f, Boolean> function1 = kVar;
        if (set != null) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(L2.f.e((String) it.next()));
            }
            return hashSet;
        }
        if (kVar == null) {
            function1 = j3.g.f3666a;
        }
        Collection<JavaClass> classes = this.f76m.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaClass javaClass : classes) {
            L2.f name = javaClass.getLightClassOriginKind() == C2.a.f166a ? null : javaClass.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // A2.G
    public final Set b(U2.f kindFilter, U2.k kVar) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        return kotlin.collections.w.f3806a;
    }

    @Override // A2.G
    public final DeclaredMemberIndex d() {
        return C0021c.f30a;
    }

    @Override // A2.G
    public final void f(LinkedHashSet linkedHashSet, L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return p(name, null);
    }

    @Override // A2.G, U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(U2.f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        z.e eVar = U2.f.c;
        if (!kindFilter.a(U2.f.f1325l | U2.f.e)) {
            return kotlin.collections.u.f3804a;
        }
        Iterable iterable = (Iterable) this.c.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
            if (declarationDescriptor instanceof ClassDescriptor) {
                L2.f name = ((ClassDescriptor) declarationDescriptor).getName();
                kotlin.jvm.internal.h.e(name, "it.name");
                if (((Boolean) nameFilter.invoke(name)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // A2.G, U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return kotlin.collections.u.f3804a;
    }

    @Override // A2.G
    public final Set h(U2.f kindFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        return kotlin.collections.w.f3806a;
    }

    @Override // A2.G
    public final DeclarationDescriptor j() {
        return this.f77n;
    }

    public final ClassDescriptor p(L2.f name, JavaClass javaClass) {
        L2.f fVar = L2.h.f964a;
        kotlin.jvm.internal.h.f(name, "name");
        String strB = name.b();
        kotlin.jvm.internal.h.e(strB, "name.asString()");
        if (strB.length() <= 0 || name.b) {
            return null;
        }
        Set set = (Set) this.f78o.invoke();
        if (javaClass == null && set != null && !set.contains(name.b())) {
            return null;
        }
        return (ClassDescriptor) this.f79p.invoke(new u(name, javaClass));
    }
}
