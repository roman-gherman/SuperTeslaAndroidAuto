package kotlin.reflect.jvm.internal.impl.types.checker;

import a3.AbstractC0162z;
import b3.i;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT;

    public interface TypeConstructorEquality {
        boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2);
    }

    static {
        NewKotlinTypeChecker.Companion.getClass();
        DEFAULT = i.b;
    }

    boolean equalTypes(@NotNull AbstractC0162z abstractC0162z, @NotNull AbstractC0162z abstractC0162z2);

    boolean isSubtypeOf(@NotNull AbstractC0162z abstractC0162z, @NotNull AbstractC0162z abstractC0162z2);
}
