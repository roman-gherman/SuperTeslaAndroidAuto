package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface JvmTypeFactory<T> {
    @NotNull
    T boxType(@NotNull T t6);

    @NotNull
    T createFromString(@NotNull String str);

    @NotNull
    T createObjectType(@NotNull String str);

    @NotNull
    T createPrimitiveType(@NotNull k2.k kVar);

    @NotNull
    T getJavaLangClassType();

    @NotNull
    String toString(@NotNull T t6);
}
