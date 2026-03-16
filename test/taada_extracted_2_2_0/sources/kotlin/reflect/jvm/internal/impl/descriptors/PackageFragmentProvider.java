package kotlin.reflect.jvm.internal.impl.descriptors;

import L2.c;
import L2.f;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageFragmentProvider {
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    List<PackageFragmentDescriptor> getPackageFragments(@NotNull c cVar);

    @NotNull
    Collection<c> getSubPackagesOf(@NotNull c cVar, @NotNull Function1<? super f, Boolean> function1);
}
