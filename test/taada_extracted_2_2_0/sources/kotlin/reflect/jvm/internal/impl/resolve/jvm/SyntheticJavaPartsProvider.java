package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import L2.f;
import S2.c;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public interface SyntheticJavaPartsProvider {

    @NotNull
    public static final c Companion = c.f1295a;

    void generateConstructors(@NotNull C0946f c0946f, @NotNull ClassDescriptor classDescriptor, @NotNull List<ClassConstructorDescriptor> list);

    void generateMethods(@NotNull C0946f c0946f, @NotNull ClassDescriptor classDescriptor, @NotNull f fVar, @NotNull Collection<SimpleFunctionDescriptor> collection);

    void generateNestedClass(@NotNull C0946f c0946f, @NotNull ClassDescriptor classDescriptor, @NotNull f fVar, @NotNull List<ClassDescriptor> list);

    void generateStaticFunctions(@NotNull C0946f c0946f, @NotNull ClassDescriptor classDescriptor, @NotNull f fVar, @NotNull Collection<SimpleFunctionDescriptor> collection);

    @NotNull
    List<f> getMethodNames(@NotNull C0946f c0946f, @NotNull ClassDescriptor classDescriptor);

    @NotNull
    List<f> getNestedClassNames(@NotNull C0946f c0946f, @NotNull ClassDescriptor classDescriptor);

    @NotNull
    List<f> getStaticFunctionNames(@NotNull C0946f c0946f, @NotNull ClassDescriptor classDescriptor);
}
