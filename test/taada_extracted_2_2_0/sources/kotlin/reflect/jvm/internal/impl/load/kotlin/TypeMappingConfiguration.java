package kotlin.reflect.jvm.internal.impl.load.kotlin;

import a3.AbstractC0162z;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeMappingConfiguration<T> {
    @NotNull
    AbstractC0162z commonSupertype(@NotNull Collection<AbstractC0162z> collection);

    @Nullable
    String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    String getPredefinedInternalNameForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    T getPredefinedTypeForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    AbstractC0162z preprocessType(@NotNull AbstractC0162z abstractC0162z);

    void processErrorType(@NotNull AbstractC0162z abstractC0162z, @NotNull ClassDescriptor classDescriptor);
}
