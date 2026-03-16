package F2;

import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f356a;

    public f(l lVar) {
        this.f356a = lVar;
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
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
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
        boolean zEquals = "k".equals(strB);
        l lVar = this.f356a;
        if (zEquals) {
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                num.getClass();
                a aVar = (a) a.b.get(num);
                if (aVar == null) {
                    aVar = a.UNKNOWN;
                }
                lVar.f362g = aVar;
                return;
            }
            return;
        }
        if ("mv".equals(strB)) {
            if (obj instanceof int[]) {
                lVar.f360a = (int[]) obj;
                return;
            }
            return;
        }
        if ("xs".equals(strB)) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.isEmpty()) {
                    return;
                }
                lVar.b = str;
                return;
            }
            return;
        }
        if ("xi".equals(strB)) {
            if (obj instanceof Integer) {
                lVar.c = ((Integer) obj).intValue();
            }
        } else if ("pn".equals(strB) && (obj instanceof String)) {
            ((String) obj).isEmpty();
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
        if ("d1".equals(strB)) {
            return new d(this);
        }
        if ("d2".equals(strB)) {
            return new e(this);
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
