package k2;

import a3.AbstractC0162z;
import a3.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.A;
import kotlin.collections.B;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f3777a;
    public static final HashMap b;
    public static final HashMap c;
    public static final LinkedHashSet d;

    static {
        s[] sVarArrValues = s.values();
        ArrayList arrayList = new ArrayList(sVarArrValues.length);
        for (s sVar : sVarArrValues) {
            arrayList.add(sVar.b);
        }
        f3777a = kotlin.collections.m.s0(arrayList);
        r[] rVarArrValues = r.values();
        ArrayList arrayList2 = new ArrayList(rVarArrValues.length);
        for (r rVar : rVarArrValues) {
            arrayList2.add(rVar.f3775a);
        }
        kotlin.collections.m.s0(arrayList2);
        b = new HashMap();
        c = new HashMap();
        A.J(new HashMap(B.F(4)), new N1.e[]{new N1.e(r.UBYTEARRAY, L2.f.e("ubyteArrayOf")), new N1.e(r.USHORTARRAY, L2.f.e("ushortArrayOf")), new N1.e(r.UINTARRAY, L2.f.e("uintArrayOf")), new N1.e(r.ULONGARRAY, L2.f.e("ulongArrayOf"))});
        s[] sVarArrValues2 = s.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (s sVar2 : sVarArrValues2) {
            linkedHashSet.add(sVar2.c.i());
        }
        d = linkedHashSet;
        for (s sVar3 : s.values()) {
            HashMap map = b;
            L2.b bVar = sVar3.c;
            L2.b bVar2 = sVar3.f3776a;
            map.put(bVar, bVar2);
            c.put(bVar2, sVar3.c);
        }
    }

    public static final boolean a(AbstractC0162z abstractC0162z) {
        ClassifierDescriptor declarationDescriptor;
        if (b0.m(abstractC0162z) || (declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor()) == null) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && kotlin.jvm.internal.h.a(((PackageFragmentDescriptor) containingDeclaration).getFqName(), p.f3767k) && f3777a.contains(declarationDescriptor.getName());
    }
}
