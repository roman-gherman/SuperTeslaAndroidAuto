package kotlin.reflect.jvm.internal.impl.renderer;

import L2.c;
import M2.B;
import M2.EnumC0126a;
import M2.F;
import M2.t;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface DescriptorRendererOptions {
    @NotNull
    EnumC0126a getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    @NotNull
    Set<c> getExcludedTypeAnnotationClasses();

    void setAnnotationArgumentsRenderingPolicy(@NotNull EnumC0126a enumC0126a);

    void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy);

    void setDebugMode(boolean z6);

    void setExcludedTypeAnnotationClasses(@NotNull Set<c> set);

    void setModifiers(@NotNull Set<? extends t> set);

    void setParameterNameRenderingPolicy(@NotNull B b);

    void setReceiverAfterName(boolean z6);

    void setRenderCompanionObjectName(boolean z6);

    void setStartFromName(boolean z6);

    void setTextFormat(@NotNull F f6);

    void setVerbose(boolean z6);

    void setWithDefinedIn(boolean z6);

    void setWithoutSuperTypes(boolean z6);

    void setWithoutTypeParameters(boolean z6);
}
