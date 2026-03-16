package z2;

import A2.t;
import A2.y;
import java.util.Collection;
import java.util.List;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;

/* JADX INFO: renamed from: z2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0945e implements PackageFragmentProviderOptimized {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0946f f5203a;
    public final CacheWithNotNullValues b;

    public C0945e(C0941a c0941a) {
        this.f5203a = new C0946f(c0941a, C0943c.b, new N1.b(null));
        this.b = c0941a.f5184a.createCacheWithNotNullValues();
    }

    public final t a(L2.c cVar) {
        return (t) this.b.computeIfAbsent(cVar, new y(17, this, this.f5203a.f5204a.b.findPackage(cVar, true)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public final void collectPackageFragments(L2.c fqName, Collection packageFragments) {
        h.f(fqName, "fqName");
        h.f(packageFragments, "packageFragments");
        t tVarA = a(fqName);
        if (tVarA != null) {
            packageFragments.add(tVarA);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public final List getPackageFragments(L2.c fqName) {
        h.f(fqName, "fqName");
        return n.z(a(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public final Collection getSubPackagesOf(L2.c fqName, Function1 nameFilter) {
        h.f(fqName, "fqName");
        h.f(nameFilter, "nameFilter");
        t tVarA = a(fqName);
        List list = tVarA != null ? (List) tVarA.f71l.invoke() : null;
        return list == null ? u.f3805a : list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public final boolean isEmpty(L2.c fqName) {
        h.f(fqName, "fqName");
        this.f5203a.f5204a.b.findPackage(fqName, true);
        return false;
    }

    public final String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.f5203a.f5204a.f5193o;
    }
}
