package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E2.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
    public final /* synthetic */ c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, p pVar) {
        super(cVar, pVar);
        this.d = cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, L2.b classId, SourceElement source) {
        kotlin.jvm.internal.h.f(classId, "classId");
        kotlin.jvm.internal.h.f(source, "source");
        p pVar = new p(this.f3830a.f311a + '@' + i);
        c cVar = this.d;
        HashMap map = cVar.b;
        List arrayList = (List) map.get(pVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(pVar, arrayList);
        }
        return cVar.f3831a.g(classId, source, arrayList);
    }
}
