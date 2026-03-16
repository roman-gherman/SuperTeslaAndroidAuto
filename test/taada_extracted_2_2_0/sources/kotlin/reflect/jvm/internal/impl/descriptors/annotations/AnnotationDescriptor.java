package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import L2.c;
import L2.f;
import P2.g;
import a3.AbstractC0162z;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface AnnotationDescriptor {
    @NotNull
    Map<f, g> getAllValueArguments();

    @Nullable
    c getFqName();

    @NotNull
    SourceElement getSource();

    @NotNull
    AbstractC0162z getType();
}
