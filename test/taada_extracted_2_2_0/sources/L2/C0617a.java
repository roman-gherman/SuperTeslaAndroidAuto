package l2;

import Z2.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.w;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.text.i;
import kotlin.text.r;
import q2.C0763B;

/* JADX INFO: renamed from: l2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0617a implements ClassDescriptorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f3962a;
    public final C0763B b;

    public C0617a(n nVar, C0763B module) {
        h.f(module, "module");
        this.f3962a = nVar;
        this.b = module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final ClassDescriptor createClass(L2.b classId) {
        h.f(classId, "classId");
        if (classId.c || !classId.b.e().d()) {
            return null;
        }
        String strB = classId.h().b();
        if (!i.D(strB, "Function", false)) {
            return null;
        }
        L2.c cVarG = classId.g();
        h.e(cVarG, "classId.packageFqName");
        EnumC0621e.c.getClass();
        C0620d c0620dA = n0.d.a(strB, cVarG);
        if (c0620dA == null) {
            return null;
        }
        List<PackageFragmentDescriptor> fragments = this.b.getPackage(cVarG).getFragments();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof BuiltInsPackageFragment) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof FunctionInterfacePackageFragment) {
                arrayList2.add(obj2);
            }
        }
        BuiltInsPackageFragment builtInsPackageFragment = (FunctionInterfacePackageFragment) m.R(arrayList2);
        if (builtInsPackageFragment == null) {
            builtInsPackageFragment = (BuiltInsPackageFragment) m.P(arrayList);
        }
        return new C0619c(this.f3962a, builtInsPackageFragment, c0620dA.f3970a, c0620dA.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final Collection getAllContributedClassesIfPossible(L2.c packageFqName) {
        h.f(packageFqName, "packageFqName");
        return w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final boolean shouldCreateClass(L2.c packageFqName, L2.f name) {
        h.f(packageFqName, "packageFqName");
        h.f(name, "name");
        String strB = name.b();
        h.e(strB, "name.asString()");
        if (!r.C(strB, "Function") && !r.C(strB, "KFunction") && !r.C(strB, "SuspendFunction") && !r.C(strB, "KSuspendFunction")) {
            return false;
        }
        EnumC0621e.c.getClass();
        return n0.d.a(strB, packageFqName) != null;
    }
}
