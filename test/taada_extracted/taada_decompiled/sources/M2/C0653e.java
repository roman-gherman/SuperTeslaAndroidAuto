package m2;

import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;

/* JADX INFO: renamed from: m2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0653e implements DFS$Neighbors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0653e f4083a = new C0653e();

    public static ClassDescriptor a(ClassDescriptor classDescriptor) {
        L2.e eVarG = N2.f.g(classDescriptor);
        String str = C0652d.f4074a;
        L2.c cVar = (L2.c) C0652d.f4079k.get(eVarG);
        if (cVar != null) {
            return R2.e.e(classDescriptor).i(cVar);
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a read-only collection");
    }

    public static ClassDescriptor b(L2.c cVar, k2.i builtIns) {
        kotlin.jvm.internal.h.f(builtIns, "builtIns");
        String str = C0652d.f4074a;
        L2.b bVar = (L2.b) C0652d.f4077h.get(cVar.i());
        if (bVar != null) {
            return builtIns.i(bVar.b());
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors
    public Iterable getNeighbors(Object obj) {
        KProperty[] kPropertyArr = C0661m.f4095g;
        return ((CallableMemberDescriptor) obj).getOriginal().getOverriddenDescriptors();
    }
}
