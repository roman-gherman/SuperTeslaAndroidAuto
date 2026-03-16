package kotlin.reflect.jvm.internal.impl.load.kotlin;

import P2.p;
import P2.r;
import P2.w;
import a3.AbstractC0162z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3837a = new ArrayList();
    public final /* synthetic */ l b;
    public final /* synthetic */ L2.f c;
    public final /* synthetic */ j d;

    public i(l lVar, L2.f fVar, j jVar) {
        this.b = lVar;
        this.c = fVar;
        this.d = jVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final void visit(Object obj) {
        this.f3837a.add(l.j(this.b, this.c, obj));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(L2.b classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        ArrayList arrayList = new ArrayList();
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
        return new h(this.b.f(classId, NO_SOURCE, arrayList), this, arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final void visitClassLiteral(P2.f value) {
        kotlin.jvm.internal.h.f(value, "value");
        this.f3837a.add(new r(new p(value)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final void visitEnd() {
        ArrayList elements = this.f3837a;
        k kVar = (k) this.d;
        kotlin.jvm.internal.h.f(elements, "elements");
        L2.f fVar = this.c;
        if (fVar == null) {
            return;
        }
        ValueParameterDescriptor valueParameterDescriptorI = k1.j.i(fVar, kVar.d);
        if (valueParameterDescriptorI != null) {
            HashMap map = kVar.b;
            List listB = j3.p.b(elements);
            AbstractC0162z type = valueParameterDescriptorI.getType();
            kotlin.jvm.internal.h.e(type, "parameter.type");
            map.put(fVar, new w(listB, type));
            return;
        }
        if (kVar.c.e(kVar.e) && kotlin.jvm.internal.h.a(fVar.b(), "value")) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : elements) {
                if (obj instanceof P2.a) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                kVar.f3839f.add((AnnotationDescriptor) ((P2.a) it.next()).f1217a);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public final void visitEnum(L2.b enumClassId, L2.f enumEntryName) {
        kotlin.jvm.internal.h.f(enumClassId, "enumClassId");
        kotlin.jvm.internal.h.f(enumEntryName, "enumEntryName");
        this.f3837a.add(new P2.i(enumClassId, enumEntryName));
    }
}
