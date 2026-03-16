package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface Check {
    boolean check(@NotNull FunctionDescriptor functionDescriptor);

    @NotNull
    String getDescription();

    @Nullable
    String invoke(@NotNull FunctionDescriptor functionDescriptor);
}
