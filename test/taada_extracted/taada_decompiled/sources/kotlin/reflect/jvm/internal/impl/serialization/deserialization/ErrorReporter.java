package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import X2.h;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ErrorReporter {
    public static final ErrorReporter DO_NOTHING = new h();

    void reportCannotInferVisibility(@NotNull CallableMemberDescriptor callableMemberDescriptor);

    void reportIncompleteHierarchy(@NotNull ClassDescriptor classDescriptor, @NotNull List<String> list);
}
