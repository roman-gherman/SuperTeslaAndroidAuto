package kotlin.reflect.jvm.internal.impl.descriptors;

import L2.c;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageFragmentProviderOptimized extends PackageFragmentProvider {
    void collectPackageFragments(@NotNull c cVar, @NotNull Collection<PackageFragmentDescriptor> collection);

    boolean isEmpty(@NotNull c cVar);
}
