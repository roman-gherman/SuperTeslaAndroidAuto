package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import C0.t;
import G2.C0111k;
import a3.AbstractC0162z;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import v2.EnumC0851b;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b3.d f3891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NotNullLazyValue f3892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NotNullLazyValue f3893h;
    public final /* synthetic */ g i;

    public e(g gVar, b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.i = gVar;
        X2.i iVar = gVar.f3900l;
        C0111k c0111k = gVar.e;
        List list = c0111k.q;
        kotlin.jvm.internal.h.e(list, "classProto.functionList");
        List list2 = c0111k.f638r;
        kotlin.jvm.internal.h.e(list2, "classProto.propertyList");
        List list3 = c0111k.f639s;
        kotlin.jvm.internal.h.e(list3, "classProto.typeAliasList");
        List list4 = c0111k.f632k;
        kotlin.jvm.internal.h.e(list4, "classProto.nestedClassNameList");
        NameResolver nameResolver = gVar.f3900l.b;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list4));
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.l.I(nameResolver, ((Number) it.next()).intValue()));
        }
        super(iVar, list, list2, list3, new k(arrayList, 1));
        this.f3891f = kotlinTypeRefiner;
        X2.g gVar2 = iVar.f1433a;
        this.f3892g = gVar2.f1418a.createLazyValue(new c(this, 0));
        this.f3893h = gVar2.f1418a.createLazyValue(new c(this, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.collections.u] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList] */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final void a(ArrayList arrayList, Function1 nameFilter) {
        ?? arrayList2;
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        t tVar = this.i.f3904p;
        if (tVar != null) {
            Set<L2.f> setKeySet = ((LinkedHashMap) tVar.b).keySet();
            arrayList2 = new ArrayList();
            for (L2.f name : setKeySet) {
                kotlin.jvm.internal.h.f(name, "name");
                ClassDescriptor classDescriptor = (ClassDescriptor) ((MemoizedFunctionToNullable) tVar.c).invoke(name);
                if (classDescriptor != null) {
                    arrayList2.add(classDescriptor);
                }
            }
        } else {
            arrayList2 = 0;
        }
        if (arrayList2 == 0) {
            arrayList2 = u.f3805a;
        }
        arrayList.addAll(arrayList2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final void c(L2.f name, ArrayList arrayList) {
        kotlin.jvm.internal.h.f(name, "name");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((Collection) this.f3893h.invoke()).iterator();
        while (it.hasNext()) {
            arrayList2.addAll(((AbstractC0162z) it.next()).getMemberScope().getContributedFunctions(name, EnumC0851b.c));
        }
        X2.i iVar = this.f3918a;
        arrayList.addAll(iVar.f1433a.f1426n.getFunctions(name, this.i));
        ArrayList arrayList3 = new ArrayList(arrayList);
        iVar.f1433a.q.getOverridingUtil().h(name, arrayList2, arrayList3, this.i, new d(arrayList));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final void d(L2.f name, ArrayList arrayList) {
        kotlin.jvm.internal.h.f(name, "name");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((Collection) this.f3893h.invoke()).iterator();
        while (it.hasNext()) {
            arrayList2.addAll(((AbstractC0162z) it.next()).getMemberScope().getContributedVariables(name, EnumC0851b.c));
        }
        ArrayList arrayList3 = new ArrayList(arrayList);
        this.f3918a.f1433a.q.getOverridingUtil().h(name, arrayList2, arrayList3, this.i, new d(arrayList));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final L2.b e(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return this.i.f3897h.d(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final Set g() {
        List supertypes = this.i.f3902n.getSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = supertypes.iterator();
        while (it.hasNext()) {
            Set<L2.f> classifierNames = ((AbstractC0162z) it.next()).getMemberScope().getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            s.F(classifierNames, linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l, U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        ClassDescriptor classDescriptor;
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        t tVar = this.i.f3904p;
        return (tVar == null || (classDescriptor = (ClassDescriptor) ((MemoizedFunctionToNullable) tVar.c).invoke(name)) == null) ? super.getContributedClassifier(name, location) : classDescriptor;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(U2.f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return (Collection) this.f3892g.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l, U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        return super.getContributedFunctions(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l, U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        return super.getContributedVariables(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final Set h() {
        g gVar = this.i;
        List supertypes = gVar.f3902n.getSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = supertypes.iterator();
        while (it.hasNext()) {
            s.F(((AbstractC0162z) it.next()).getMemberScope().getFunctionNames(), linkedHashSet);
        }
        linkedHashSet.addAll(this.f3918a.f1433a.f1426n.getFunctionsNames(gVar));
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final Set i() {
        List supertypes = this.i.f3902n.getSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = supertypes.iterator();
        while (it.hasNext()) {
            s.F(((AbstractC0162z) it.next()).getMemberScope().getVariableNames(), linkedHashSet);
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final boolean k(o oVar) {
        return this.f3918a.f1433a.f1427o.isFunctionAvailable(this.i, oVar);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        Z.t(this.f3918a.f1433a.i, location, this.i, name);
    }
}
