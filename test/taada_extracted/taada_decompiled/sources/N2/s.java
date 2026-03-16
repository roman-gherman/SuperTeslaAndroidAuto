package n2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements PackageFragmentProviderOptimized {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4256a;

    public s(ArrayList arrayList) {
        this.f4256a = arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public final void collectPackageFragments(L2.c fqName, Collection packageFragments) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(packageFragments, "packageFragments");
        for (Object obj : this.f4256a) {
            if (kotlin.jvm.internal.h.a(((PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public final List getPackageFragments(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f4256a) {
            if (kotlin.jvm.internal.h.a(((PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public final Collection getSubPackagesOf(L2.c fqName, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return k3.m.F(k3.m.w(k3.m.D(kotlin.collections.m.K(this.f4256a), C0725q.f4254a), new r(fqName, 0)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public final boolean isEmpty(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        ArrayList arrayList = this.f4256a;
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.h.a(((PackageFragmentDescriptor) it.next()).getFqName(), fqName)) {
                return false;
            }
        }
        return true;
    }
}
