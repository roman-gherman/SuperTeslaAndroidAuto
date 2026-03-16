package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import org.jetbrains.annotations.NotNull;
import z2.C0942b;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaResolverSettings {

    @NotNull
    public static final C0942b Companion = C0942b.f5199a;

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getEnhancePrimitiveArrays();

    boolean getIgnoreNullabilityForErasedValueParameters();

    boolean getTypeEnhancementImprovementsInStrictMode();
}
