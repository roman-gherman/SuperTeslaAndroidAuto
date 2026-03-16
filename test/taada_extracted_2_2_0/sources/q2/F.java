package q2;

import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes2.dex */
public final class F implements PackageViewDescriptorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f4545a = new F();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory
    public final PackageViewDescriptor compute(C0763B module, L2.c fqName, StorageManager storageManager) {
        kotlin.jvm.internal.h.f(module, "module");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        return new y(module, fqName, storageManager);
    }
}
