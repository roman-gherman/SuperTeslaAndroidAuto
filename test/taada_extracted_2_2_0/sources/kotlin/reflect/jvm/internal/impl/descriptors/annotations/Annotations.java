package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import L2.c;
import kotlin.jvm.internal.markers.KMappedMarker;
import o2.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {

    @NotNull
    public static final f Companion = f.f4289a;

    @Nullable
    AnnotationDescriptor findAnnotation(@NotNull c cVar);

    boolean hasAnnotation(@NotNull c cVar);

    boolean isEmpty();
}
