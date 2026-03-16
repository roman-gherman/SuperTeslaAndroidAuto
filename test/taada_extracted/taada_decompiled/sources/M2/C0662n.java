package m2;

import A2.C0019a;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import q2.C0763B;
import s2.C0813c;

/* JADX INFO: renamed from: m2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0662n implements PackageFragmentProviderOptimized {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z2.n f4098a;
    public final C0813c b;
    public final C0763B c;
    public X2.g d;
    public final MemoizedFunctionToNullable e;

    public C0662n(Z2.n nVar, C0813c c0813c, C0763B c0763b) {
        this.f4098a = nVar;
        this.b = c0813c;
        this.c = c0763b;
        this.e = nVar.createMemoizedFunctionWithNullableValues(new C0019a(this, 9));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public final void collectPackageFragments(L2.c fqName, Collection packageFragments) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(packageFragments, "packageFragments");
        R rInvoke = this.e.invoke(fqName);
        if (rInvoke != 0) {
            packageFragments.add(rInvoke);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public final List getPackageFragments(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        return kotlin.collections.n.z(this.e.invoke(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public final Collection getSubPackagesOf(L2.c fqName, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return w.f3806a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public final boolean isEmpty(L2.c fqName) {
        DeclarationDescriptorWithSource declarationDescriptorWithSourceL;
        kotlin.jvm.internal.h.f(fqName, "fqName");
        MemoizedFunctionToNullable memoizedFunctionToNullable = this.e;
        if (memoizedFunctionToNullable.isComputed(fqName)) {
            declarationDescriptorWithSourceL = (PackageFragmentDescriptor) memoizedFunctionToNullable.invoke(fqName);
        } else {
            InputStream inputStreamFindBuiltInsData = this.b.findBuiltInsData(fqName);
            declarationDescriptorWithSourceL = inputStreamFindBuiltInsData != null ? kotlin.reflect.l.l(fqName, this.f4098a, this.c, inputStreamFindBuiltInsData) : null;
        }
        return declarationDescriptorWithSourceL == null;
    }
}
