package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import L2.f;
import a3.AbstractC0162z;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface AdditionalClassPartsProvider {
    @NotNull
    Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<SimpleFunctionDescriptor> getFunctions(@NotNull f fVar, @NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<f> getFunctionsNames(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<AbstractC0162z> getSupertypes(@NotNull ClassDescriptor classDescriptor);
}
