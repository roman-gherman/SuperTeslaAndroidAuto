package F2;

import java.util.HashMap;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import w2.D;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements KotlinJvmBinaryClass.AnnotationVisitor {
    public static final boolean i = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f359j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f360a;
    public String b;
    public int c;
    public String[] d;
    public String[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String[] f361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f363h;

    static {
        HashMap map = new HashMap();
        f359j = map;
        map.put(L2.b.j(new L2.c("kotlin.jvm.internal.KotlinClass")), a.CLASS);
        map.put(L2.b.j(new L2.c("kotlin.jvm.internal.KotlinFileFacade")), a.FILE_FACADE);
        map.put(L2.b.j(new L2.c("kotlin.jvm.internal.KotlinMultifileClass")), a.MULTIFILE_CLASS);
        map.put(L2.b.j(new L2.c("kotlin.jvm.internal.KotlinMultifileClassPart")), a.MULTIFILE_CLASS_PART);
        map.put(L2.b.j(new L2.c("kotlin.jvm.internal.KotlinSyntheticClass")), a.SYNTHETIC_CLASS);
    }

    public static /* synthetic */ void a(int i3) {
        Object[] objArr = new Object[3];
        if (i3 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.b bVar, SourceElement sourceElement) {
        a aVar;
        if (bVar == null) {
            a(0);
            throw null;
        }
        if (sourceElement == null) {
            a(1);
            throw null;
        }
        L2.c cVarB = bVar.b();
        if (cVarB.equals(D.f4964a)) {
            return new f(this);
        }
        if (cVarB.equals(D.f4973o)) {
            return new h(this);
        }
        if (i || this.f362g != null || (aVar = (a) f359j.get(bVar)) == null) {
            return null;
        }
        this.f362g = aVar;
        return new k(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public final void visitEnd() {
    }
}
