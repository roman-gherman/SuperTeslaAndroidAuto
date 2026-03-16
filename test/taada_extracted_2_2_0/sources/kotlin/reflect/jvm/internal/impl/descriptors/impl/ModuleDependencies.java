package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import q2.C0763B;

/* JADX INFO: loaded from: classes2.dex */
public interface ModuleDependencies {
    @NotNull
    List<C0763B> getAllDependencies();

    @NotNull
    List<C0763B> getDirectExpectedByDependencies();

    @NotNull
    Set<C0763B> getModulesWhoseInternalsAreVisible();
}
