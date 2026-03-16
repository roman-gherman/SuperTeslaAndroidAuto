package kotlin.reflect.jvm.internal.impl.descriptors;

import a3.Z;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ReceiverParameterDescriptor extends ParameterDescriptor {
    @NotNull
    ReceiverValue getValue();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @Nullable
    ReceiverParameterDescriptor substitute(@NotNull Z z6);
}
