package kotlin.reflect.jvm.internal.impl.load.java.structure;

import L2.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaValueParameter extends JavaAnnotationOwner {
    @Nullable
    f getName();

    @NotNull
    JavaType getType();

    boolean isVararg();
}
