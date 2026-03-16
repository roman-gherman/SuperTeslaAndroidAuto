package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import L2.b;
import L2.c;
import L2.f;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ClassDescriptorFactory {
    @Nullable
    ClassDescriptor createClass(@NotNull b bVar);

    @NotNull
    Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull c cVar);

    boolean shouldCreateClass(@NotNull c cVar, @NotNull f fVar);
}
