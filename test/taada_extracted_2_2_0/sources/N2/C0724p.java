package n2;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import m2.C0659k;

/* JADX INFO: renamed from: n2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0724p extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4254a;
    public final /* synthetic */ C0.t b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0724p(C0.t tVar, int i) {
        super(1);
        this.f4254a = i;
        this.b = tVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptorG;
        switch (this.f4254a) {
            case 0:
                C0722n c0722n = (C0722n) obj;
                kotlin.jvm.internal.h.f(c0722n, "<name for destructuring parameter 0>");
                L2.b bVar = c0722n.f4251a;
                if (bVar.c) {
                    throw new UnsupportedOperationException("Unresolved local class: " + bVar);
                }
                L2.b bVarF = bVar.f();
                List list = c0722n.b;
                C0.t tVar = this.b;
                if (bVarF == null || (classOrPackageFragmentDescriptorG = tVar.g(bVarF, kotlin.collections.m.M(list))) == null) {
                    MemoizedFunctionToNotNull memoizedFunctionToNotNull = (MemoizedFunctionToNotNull) tVar.d;
                    L2.c cVarG = bVar.g();
                    kotlin.jvm.internal.h.e(cVarG, "classId.packageFqName");
                    classOrPackageFragmentDescriptorG = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(cVarG);
                }
                ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor = classOrPackageFragmentDescriptorG;
                boolean z6 = !bVar.b.e().d();
                StorageManager storageManager = (StorageManager) tVar.b;
                L2.f fVarI = bVar.i();
                kotlin.jvm.internal.h.e(fVarI, "classId.shortClassName");
                Integer num = (Integer) kotlin.collections.m.R(list);
                return new C0723o(storageManager, classOrPackageFragmentDescriptor, fVarI, z6, num != null ? num.intValue() : 0);
            default:
                L2.c fqName = (L2.c) obj;
                kotlin.jvm.internal.h.f(fqName, "fqName");
                return new C0659k((ModuleDescriptor) this.b.c, fqName, 1);
        }
    }
}
