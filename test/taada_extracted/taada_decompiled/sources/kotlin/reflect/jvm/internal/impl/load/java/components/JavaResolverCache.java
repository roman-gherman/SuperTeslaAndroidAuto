package kotlin.reflect.jvm.internal.impl.load.java.components;

import L2.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.C0921h;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaResolverCache {
    public static final JavaResolverCache EMPTY = new C0921h();

    @Nullable
    ClassDescriptor getClassResolvedFromSource(@NotNull c cVar);

    void recordClass(@NotNull JavaClass javaClass, @NotNull ClassDescriptor classDescriptor);

    void recordConstructor(@NotNull JavaElement javaElement, @NotNull ConstructorDescriptor constructorDescriptor);

    void recordField(@NotNull JavaField javaField, @NotNull PropertyDescriptor propertyDescriptor);

    void recordMethod(@NotNull JavaMember javaMember, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor);
}
