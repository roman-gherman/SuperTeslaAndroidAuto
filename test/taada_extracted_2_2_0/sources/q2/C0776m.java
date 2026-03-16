package q2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import n2.AbstractC0718j;

/* JADX INFO: renamed from: q2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0776m implements PackageFragmentProviderOptimized {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4604a;
    public final String b;

    public C0776m(String debugName, List list) {
        kotlin.jvm.internal.h.f(debugName, "debugName");
        this.f4604a = list;
        this.b = debugName;
        list.size();
        kotlin.collections.m.s0(list).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public final void collectPackageFragments(L2.c fqName, Collection packageFragments) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(packageFragments, "packageFragments");
        Iterator it = this.f4604a.iterator();
        while (it.hasNext()) {
            AbstractC0718j.b((PackageFragmentProvider) it.next(), fqName, packageFragments);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public final List getPackageFragments(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f4604a.iterator();
        while (it.hasNext()) {
            AbstractC0718j.b((PackageFragmentProvider) it.next(), fqName, arrayList);
        }
        return kotlin.collections.m.o0(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public final Collection getSubPackagesOf(L2.c fqName, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator it = this.f4604a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((PackageFragmentProvider) it.next()).getSubPackagesOf(fqName, nameFilter));
        }
        return hashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public final boolean isEmpty(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        List list = this.f4604a;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!AbstractC0718j.h((PackageFragmentProvider) it.next(), fqName)) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return this.b;
    }
}
