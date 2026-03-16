package kotlin.reflect.jvm.internal.impl.load.java.structure;

import L2.c;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaAnnotationOwner extends JavaElement {
    @Nullable
    JavaAnnotation findAnnotation(@NotNull c cVar);

    @NotNull
    Collection<JavaAnnotation> getAnnotations();

    boolean isDeprecatedInJavaDoc();
}
