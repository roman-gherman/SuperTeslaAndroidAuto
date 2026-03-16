package m2;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;

/* JADX INFO: renamed from: m2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0654f extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0654f f4085a = new C0654f(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ModuleDescriptor module = (ModuleDescriptor) obj;
        kotlin.jvm.internal.h.f(module, "module");
        List<PackageFragmentDescriptor> fragments = module.getPackage(C0655g.f4086f).getFragments();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : fragments) {
            if (obj2 instanceof BuiltInsPackageFragment) {
                arrayList.add(obj2);
            }
        }
        return (BuiltInsPackageFragment) kotlin.collections.m.P(arrayList);
    }
}
