package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E2.p;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public class b implements KotlinJvmBinaryClass.AnnotationVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f3830a;
    public final ArrayList b = new ArrayList();
    public final /* synthetic */ c c;

    public b(c cVar, p pVar) {
        this.c = cVar;
        this.f3830a = pVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.b classId, SourceElement source) {
        kotlin.jvm.internal.h.f(classId, "classId");
        kotlin.jvm.internal.h.f(source, "source");
        c cVar = this.c;
        return cVar.f3831a.g(classId, source, this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public final void visitEnd() {
        ArrayList arrayList = this.b;
        if (arrayList.isEmpty()) {
            return;
        }
        this.c.b.put(this.f3830a, arrayList);
    }
}
