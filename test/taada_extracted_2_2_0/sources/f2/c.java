package F2;

import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f355a = new ArrayList();

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "enumEntryName";
        } else if (i == 2) {
            objArr[0] = "classLiteralValue";
        } else if (i != 3) {
            objArr[0] = "enumClassId";
        } else {
            objArr[0] = "classId";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
        if (i == 2) {
            objArr[2] = "visitClassLiteral";
        } else if (i != 3) {
            objArr[2] = "visitEnum";
        } else {
            objArr[2] = "visitAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public abstract void b(String[] strArr);

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final void visit(Object obj) {
        if (obj instanceof String) {
            this.f355a.add((String) obj);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.b bVar) {
        if (bVar != null) {
            return null;
        }
        a(3);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final void visitClassLiteral(P2.f fVar) {
        if (fVar != null) {
            return;
        }
        a(2);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final void visitEnd() {
        b((String[]) this.f355a.toArray(new String[0]));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final void visitEnum(L2.b bVar, L2.f fVar) {
        if (bVar == null) {
            a(0);
            throw null;
        }
        if (fVar != null) {
            return;
        }
        a(1);
        throw null;
    }
}
