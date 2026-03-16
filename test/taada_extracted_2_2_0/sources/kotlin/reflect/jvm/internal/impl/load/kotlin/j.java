package kotlin.reflect.jvm.internal.impl.load.kotlin;

import P2.p;
import P2.r;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f3838a;

    public j(l lVar) {
        this.f3838a = lVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visit(L2.f fVar, Object obj) {
        P2.g gVarJ = l.j(this.f3838a, fVar, obj);
        k kVar = (k) this;
        if (fVar != null) {
            kVar.b.put(fVar, gVarJ);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.f fVar, L2.b classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        ArrayList arrayList = new ArrayList();
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
        return new g(this.f3838a.f(classId, NO_SOURCE, arrayList), this, fVar, arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(L2.f fVar) {
        return new i(this.f3838a, fVar, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitClassLiteral(L2.f fVar, P2.f value) {
        kotlin.jvm.internal.h.f(value, "value");
        r rVar = new r(new p(value));
        k kVar = (k) this;
        if (fVar != null) {
            kVar.b.put(fVar, rVar);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitEnum(L2.f fVar, L2.b enumClassId, L2.f enumEntryName) {
        kotlin.jvm.internal.h.f(enumClassId, "enumClassId");
        kotlin.jvm.internal.h.f(enumEntryName, "enumEntryName");
        P2.i iVar = new P2.i(enumClassId, enumEntryName);
        k kVar = (k) this;
        if (fVar != null) {
            kVar.b.put(fVar, iVar);
        }
    }
}
