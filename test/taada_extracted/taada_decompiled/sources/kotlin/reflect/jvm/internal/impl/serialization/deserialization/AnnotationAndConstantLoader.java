package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import G2.H;
import X2.r;
import a3.AbstractC0162z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface AnnotationAndConstantLoader<A, C> extends AnnotationLoader<A> {
    @Nullable
    C loadAnnotationDefaultValue(@NotNull r rVar, @NotNull H h3, @NotNull AbstractC0162z abstractC0162z);

    @Nullable
    C loadPropertyConstant(@NotNull r rVar, @NotNull H h3, @NotNull AbstractC0162z abstractC0162z);
}
