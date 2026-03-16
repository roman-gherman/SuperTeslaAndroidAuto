package kotlin.reflect.jvm.internal.impl.load.java.structure;

import L2.c;
import L2.f;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaPackage extends JavaAnnotationOwner, JavaElement {
    @NotNull
    Collection<JavaClass> getClasses(@NotNull Function1<? super f, Boolean> function1);

    @NotNull
    c getFqName();

    @NotNull
    Collection<JavaPackage> getSubPackages();
}
