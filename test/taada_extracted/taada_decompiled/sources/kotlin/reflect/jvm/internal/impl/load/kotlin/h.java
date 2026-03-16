package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3835a;
    public final /* synthetic */ k b;
    public final /* synthetic */ i c;
    public final /* synthetic */ ArrayList d;

    public h(k kVar, i iVar, ArrayList arrayList) {
        this.b = kVar;
        this.c = iVar;
        this.d = arrayList;
        this.f3835a = kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visit(L2.f fVar, Object obj) {
        this.f3835a.visit(fVar, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.f fVar, L2.b classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        return this.f3835a.visitAnnotation(fVar, classId);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(L2.f fVar) {
        return this.f3835a.visitArray(fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitClassLiteral(L2.f fVar, P2.f value) {
        kotlin.jvm.internal.h.f(value, "value");
        this.f3835a.visitClassLiteral(fVar, value);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitEnd() {
        this.b.visitEnd();
        this.c.f3836a.add(new P2.a((AnnotationDescriptor) m.g0(this.d)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitEnum(L2.f fVar, L2.b enumClassId, L2.f enumEntryName) {
        kotlin.jvm.internal.h.f(enumClassId, "enumClassId");
        kotlin.jvm.internal.h.f(enumEntryName, "enumEntryName");
        this.f3835a.visitEnum(fVar, enumClassId, enumEntryName);
    }
}
