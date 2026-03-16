package kotlin.reflect.jvm.internal.impl.load.kotlin;

import P2.p;
import P2.r;
import j2.AbstractC0565b;
import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import o2.C0738b;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends j {
    public final HashMap b;
    public final /* synthetic */ l c;
    public final /* synthetic */ ClassDescriptor d;
    public final /* synthetic */ L2.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f3839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SourceElement f3840g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, ClassDescriptor classDescriptor, L2.b bVar, List list, SourceElement sourceElement) {
        super(lVar);
        this.c = lVar;
        this.d = classDescriptor;
        this.e = bVar;
        this.f3839f = list;
        this.f3840g = sourceElement;
        this.b = new HashMap();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public final void visitEnd() {
        HashMap arguments = this.b;
        l lVar = this.c;
        lVar.getClass();
        L2.b bVar = this.e;
        kotlin.jvm.internal.h.f(arguments, "arguments");
        boolean zE = false;
        if (bVar.equals(AbstractC0565b.b)) {
            Object obj = arguments.get(L2.f.e("value"));
            r rVar = obj instanceof r ? (r) obj : null;
            if (rVar != null) {
                Object obj2 = rVar.f1217a;
                p pVar = obj2 instanceof p ? (p) obj2 : null;
                if (pVar != null) {
                    zE = lVar.e(pVar.f1222a.f1216a);
                }
            }
        }
        if (zE || lVar.e(bVar)) {
            return;
        }
        this.f3839f.add(new C0738b(this.d.getDefaultType(), arguments, this.f3840g));
    }
}
