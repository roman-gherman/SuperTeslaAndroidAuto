package kotlin.reflect.jvm.internal.impl.load.java.structure;

import C2.a;
import L2.c;
import L2.f;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface JavaClass extends JavaClassifier, JavaModifierListOwner, JavaTypeParameterListOwner {
    @NotNull
    Collection<JavaConstructor> getConstructors();

    @NotNull
    Collection<JavaField> getFields();

    @Nullable
    c getFqName();

    @NotNull
    Collection<f> getInnerClassNames();

    @Nullable
    a getLightClassOriginKind();

    @NotNull
    Collection<JavaMethod> getMethods();

    @Nullable
    JavaClass getOuterClass();

    @NotNull
    Collection<JavaClassifierType> getPermittedTypes();

    @NotNull
    Collection<JavaRecordComponent> getRecordComponents();

    @NotNull
    Collection<JavaClassifierType> getSupertypes();

    boolean hasDefaultConstructor();

    boolean isAnnotationType();

    boolean isEnum();

    boolean isInterface();

    boolean isRecord();

    boolean isSealed();
}
