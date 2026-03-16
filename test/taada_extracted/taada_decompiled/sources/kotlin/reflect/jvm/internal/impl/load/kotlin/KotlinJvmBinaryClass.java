package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface KotlinJvmBinaryClass {

    public interface AnnotationArgumentVisitor {
        void visit(@Nullable L2.f fVar, @Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@Nullable L2.f fVar, @NotNull L2.b bVar);

        @Nullable
        AnnotationArrayArgumentVisitor visitArray(@Nullable L2.f fVar);

        void visitClassLiteral(@Nullable L2.f fVar, @NotNull P2.f fVar2);

        void visitEnd();

        void visitEnum(@Nullable L2.f fVar, @NotNull L2.b bVar, @NotNull L2.f fVar2);
    }

    public interface AnnotationArrayArgumentVisitor {
        void visit(@Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull L2.b bVar);

        void visitClassLiteral(@NotNull P2.f fVar);

        void visitEnd();

        void visitEnum(@NotNull L2.b bVar, @NotNull L2.f fVar);
    }

    public interface AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull L2.b bVar, @NotNull SourceElement sourceElement);

        void visitEnd();
    }

    public interface MemberVisitor {
        @Nullable
        AnnotationVisitor visitField(@NotNull L2.f fVar, @NotNull String str, @Nullable Object obj);

        @Nullable
        MethodAnnotationVisitor visitMethod(@NotNull L2.f fVar, @NotNull String str);
    }

    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitParameterAnnotation(int i, @NotNull L2.b bVar, @NotNull SourceElement sourceElement);
    }

    @NotNull
    F2.b getClassHeader();

    @NotNull
    L2.b getClassId();

    @NotNull
    String getLocation();

    void loadClassAnnotations(@NotNull AnnotationVisitor annotationVisitor, @Nullable byte[] bArr);

    void visitMembers(@NotNull MemberVisitor memberVisitor, @Nullable byte[] bArr);
}
