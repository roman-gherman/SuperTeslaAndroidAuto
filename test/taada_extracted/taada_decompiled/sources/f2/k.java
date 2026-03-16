package F2;

import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f358a;

    public k(l lVar) {
        this.f358a = lVar;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "enumClassId";
        } else if (i == 2) {
            objArr[0] = "enumEntryName";
        } else if (i != 3) {
            objArr[0] = "classLiteralValue";
        } else {
            objArr[0] = "classId";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
        if (i == 1 || i == 2) {
            objArr[2] = "visitEnum";
        } else if (i != 3) {
            objArr[2] = "visitClassLiteral";
        } else {
            objArr[2] = "visitAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visit(L2.f fVar, Object obj) {
        if (fVar == null) {
            return;
        }
        String strB = fVar.b();
        boolean zEquals = "version".equals(strB);
        l lVar = this.f358a;
        if (zEquals) {
            if (obj instanceof int[]) {
                lVar.f360a = (int[]) obj;
            }
        } else if ("multifileClassName".equals(strB)) {
            lVar.b = obj instanceof String ? (String) obj : null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.f fVar, L2.b bVar) {
        if (bVar != null) {
            return null;
        }
        a(3);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(L2.f fVar) {
        String strB = fVar != null ? fVar.b() : null;
        if ("data".equals(strB) || "filePartClassNames".equals(strB)) {
            return new i(this);
        }
        if ("strings".equals(strB)) {
            return new j(this);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitClassLiteral(L2.f fVar, P2.f fVar2) {
        if (fVar2 != null) {
            return;
        }
        a(0);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitEnd() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitEnum(L2.f fVar, L2.b bVar, L2.f fVar2) {
        if (bVar == null) {
            a(1);
            throw null;
        }
        if (fVar2 != null) {
            return;
        }
        a(2);
        throw null;
    }
}
