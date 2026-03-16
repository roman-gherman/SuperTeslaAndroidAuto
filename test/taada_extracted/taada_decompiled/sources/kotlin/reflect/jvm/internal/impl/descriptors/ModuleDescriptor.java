package kotlin.reflect.jvm.internal.impl.descriptors;

import L2.c;
import L2.f;
import java.util.Collection;
import java.util.List;
import k2.i;
import kotlin.jvm.functions.Function1;
import n2.C0720l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ModuleDescriptor extends DeclarationDescriptor {
    @NotNull
    i getBuiltIns();

    @Nullable
    <T> T getCapability(@NotNull C0720l c0720l);

    @NotNull
    List<ModuleDescriptor> getExpectedByModules();

    @NotNull
    PackageViewDescriptor getPackage(@NotNull c cVar);

    @NotNull
    Collection<c> getSubPackagesOf(@NotNull c cVar, @NotNull Function1<? super f, Boolean> function1);

    boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor);
}
