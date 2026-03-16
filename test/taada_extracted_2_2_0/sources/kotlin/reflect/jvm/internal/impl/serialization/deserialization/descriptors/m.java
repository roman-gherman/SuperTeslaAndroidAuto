package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import G2.D;
import G2.b0;
import G2.j0;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.s;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PackageFragmentDescriptor f3919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final L2.c f3921h;

    public m(PackageFragmentDescriptor packageDescriptor, D proto, NameResolver nameResolver, I2.a metadataVersion, E2.g gVar, X2.g components, String debugName, Function0 classNames) {
        kotlin.jvm.internal.h.f(packageDescriptor, "packageDescriptor");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.h.f(components, "components");
        kotlin.jvm.internal.h.f(debugName, "debugName");
        kotlin.jvm.internal.h.f(classNames, "classNames");
        b0 b0Var = proto.f430g;
        kotlin.jvm.internal.h.e(b0Var, "proto.typeTable");
        I2.f fVar = new I2.f(b0Var);
        I2.g gVar2 = I2.g.b;
        j0 j0Var = proto.f431h;
        kotlin.jvm.internal.h.e(j0Var, "proto.versionRequirementTable");
        X2.i iVarA = components.a(packageDescriptor, nameResolver, fVar, C5.f.q(j0Var), metadataVersion, gVar);
        List list = proto.d;
        kotlin.jvm.internal.h.e(list, "proto.functionList");
        List list2 = proto.e;
        kotlin.jvm.internal.h.e(list2, "proto.propertyList");
        List list3 = proto.f429f;
        kotlin.jvm.internal.h.e(list3, "proto.typeAliasList");
        super(iVarA, list, list2, list3, classNames);
        this.f3919f = packageDescriptor;
        this.f3920g = debugName;
        this.f3921h = packageDescriptor.getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final void a(ArrayList arrayList, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final L2.b e(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return new L2.b(this.f3921h, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final Set g() {
        return w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l, U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        recordLookup(name, location);
        return super.getContributedClassifier(name, location);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(U2.f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        List listB = b(kindFilter, nameFilter);
        Iterable iterable = this.f3918a.f1433a.f1423k;
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            s.F(((ClassDescriptorFactory) it.next()).getAllContributedClassesIfPossible(this.f3921h), arrayList);
        }
        return kotlin.collections.m.b0(arrayList, listB);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final Set h() {
        return w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final Set i() {
        return w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l
    public final boolean j(L2.f fVar) {
        if (f().contains(fVar)) {
            return true;
        }
        Iterable iterable = this.f3918a.f1433a.f1423k;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (((ClassDescriptorFactory) it.next()).shouldCreateClass(this.f3921h, fVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        Z.u(this.f3918a.f1433a.i, location, this.f3919f, name);
    }

    public final String toString() {
        return this.f3920g;
    }
}
