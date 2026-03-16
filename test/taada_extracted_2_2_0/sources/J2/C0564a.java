package j2;

import L2.c;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.s;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import w2.C;

/* JADX INFO: renamed from: j2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0564a implements KotlinJvmBinaryClass.AnnotationVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f3659a;

    public C0564a(s sVar) {
        this.f3659a = sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.b classId, SourceElement source) {
        h.f(classId, "classId");
        h.f(source, "source");
        c cVar = C.f4963a;
        if (!classId.equals(C.b)) {
            return null;
        }
        this.f3659a.f3814a = true;
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public final void visitEnd() {
    }
}
