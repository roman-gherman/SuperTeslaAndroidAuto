package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E2.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {
    @Nullable
    m findKotlinClassOrContent(@NotNull L2.b bVar, @NotNull K2.f fVar);

    @Nullable
    m findKotlinClassOrContent(@NotNull JavaClass javaClass, @NotNull K2.f fVar);
}
