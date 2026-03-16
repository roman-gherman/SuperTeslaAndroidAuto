package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements KotlinJvmBinaryClass.AnnotationVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3833a;
    public final /* synthetic */ ArrayList b;

    public e(f fVar, ArrayList arrayList) {
        this.f3833a = fVar;
        this.b = arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.b classId, SourceElement source) {
        kotlin.jvm.internal.h.f(classId, "classId");
        kotlin.jvm.internal.h.f(source, "source");
        return this.f3833a.g(classId, source, this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public final void visitEnd() {
    }
}
