package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import L2.f;
import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface DeclaredMemberIndex {
    @Nullable
    JavaField findFieldByName(@NotNull f fVar);

    @NotNull
    Collection<JavaMethod> findMethodsByName(@NotNull f fVar);

    @Nullable
    JavaRecordComponent findRecordComponentByName(@NotNull f fVar);

    @NotNull
    Set<f> getFieldNames();

    @NotNull
    Set<f> getMethodNames();

    @NotNull
    Set<f> getRecordComponentNames();
}
