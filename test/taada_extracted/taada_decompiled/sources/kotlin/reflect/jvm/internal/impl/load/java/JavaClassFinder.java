package kotlin.reflect.jvm.internal.impl.load.java;

import L2.c;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w2.q;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaClassFinder {
    @Nullable
    JavaClass findClass(@NotNull q qVar);

    @Nullable
    JavaPackage findPackage(@NotNull c cVar, boolean z6);

    @Nullable
    Set<String> knownClassNamesInPackage(@NotNull c cVar);
}
