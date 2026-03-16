package Y2;

import A2.C0031m;
import B.g;
import C0.t;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import k2.p;
import kotlin.collections.o;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.l;
import n2.s;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements BuiltInsLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1483a = new d();

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    public final PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor builtInsModule, Iterable classDescriptorFactories, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z6) {
        h.f(storageManager, "storageManager");
        h.f(builtInsModule, "builtInsModule");
        h.f(classDescriptorFactories, "classDescriptorFactories");
        h.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        h.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        Set<L2.c> packageFqNames = p.f3772p;
        C0031m c0031m = new C0031m(1, 2, this.f1483a);
        h.f(packageFqNames, "packageFqNames");
        ArrayList arrayList = new ArrayList(o.D(packageFqNames));
        for (L2.c cVar : packageFqNames) {
            a.f1482m.getClass();
            String strA = a.a(cVar);
            InputStream inputStream = (InputStream) c0031m.invoke(strA);
            if (inputStream == null) {
                throw new IllegalStateException(androidx.constraintlayout.core.motion.a.p("Resource not found in classpath: ", strA));
            }
            arrayList.add(l.l(cVar, storageManager, builtInsModule, inputStream));
        }
        s sVar = new s(arrayList);
        t tVar = new t(storageManager, builtInsModule);
        g gVar = new g(sVar, 18);
        a aVar = a.f1482m;
        B.h hVar = new B.h(builtInsModule, tVar, aVar);
        ErrorReporter DO_NOTHING = ErrorReporter.DO_NOTHING;
        h.e(DO_NOTHING, "DO_NOTHING");
        X2.h hVar2 = X2.h.b;
        ContractDeserializer.Companion.getClass();
        X2.g gVar2 = new X2.g(storageManager, builtInsModule, gVar, hVar, sVar, DO_NOTHING, hVar2, classDescriptorFactories, tVar, additionalClassPartsProvider, platformDependentDeclarationFilter, aVar.f1392a, null, new g(storageManager), null, 851968);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).g(gVar2);
        }
        return sVar;
    }
}
