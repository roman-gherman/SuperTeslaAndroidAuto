package kotlin.reflect.jvm.internal.impl.load.java.components;

import a3.AbstractC0162z;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.C0921h;
import x2.C0924k;

/* JADX INFO: loaded from: classes2.dex */
public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = new C0921h();

    void reportSignatureErrors(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list);

    @NotNull
    C0924k resolvePropagatedSignature(@NotNull JavaMethod javaMethod, @NotNull ClassDescriptor classDescriptor, @NotNull AbstractC0162z abstractC0162z, @Nullable AbstractC0162z abstractC0162z2, @NotNull List<ValueParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2);
}
