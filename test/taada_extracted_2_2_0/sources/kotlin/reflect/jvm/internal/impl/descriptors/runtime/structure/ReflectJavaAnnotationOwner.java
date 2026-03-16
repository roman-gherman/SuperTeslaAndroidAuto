package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import L2.c;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t2.C0824f;

/* JADX INFO: loaded from: classes2.dex */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    C0824f findAnnotation(@NotNull c cVar);

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    List<C0824f> getAnnotations();

    @Nullable
    AnnotatedElement getElement();
}
