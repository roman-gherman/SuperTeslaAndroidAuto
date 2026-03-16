package kotlin.reflect.jvm.internal.impl.load.java;

import L2.b;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaModuleAnnotationsProvider {
    @Nullable
    List<JavaAnnotation> getAnnotationsForModuleOwnerOfClass(@NotNull b bVar);
}
