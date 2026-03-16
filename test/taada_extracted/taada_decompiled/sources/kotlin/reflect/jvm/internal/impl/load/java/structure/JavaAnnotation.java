package kotlin.reflect.jvm.internal.impl.load.java.structure;

import L2.b;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaAnnotation extends JavaElement {
    @NotNull
    Collection<JavaAnnotationArgument> getArguments();

    @Nullable
    b getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    @Nullable
    JavaClass resolve();
}
