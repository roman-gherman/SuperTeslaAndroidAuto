package A2;

import a3.AbstractC0162z;
import a3.b0;
import a3.d0;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import q2.AbstractC0766c;
import w2.EnumC0868b;
import z2.C0941a;
import z2.C0944d;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends AbstractC0766c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0946f f25k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JavaTypeParameter f26l;

    /* JADX WARN: Illegal instructions before constructor call */
    public P(C0946f c0946f, JavaTypeParameter javaTypeParameter, int i, DeclarationDescriptorNonRoot declarationDescriptorNonRoot) {
        kotlin.jvm.internal.h.f(javaTypeParameter, "javaTypeParameter");
        C0941a c0941a = c0946f.f5203a;
        super(c0941a.f5183a, declarationDescriptorNonRoot, new C0944d(c0946f, javaTypeParameter, false), javaTypeParameter.getName(), d0.INVARIANT, false, i, SourceElement.NO_SOURCE, c0941a.f5190m);
        this.f25k = c0946f;
        this.f26l = javaTypeParameter;
    }

    @Override // q2.AbstractC0772i
    public final List g(List list) {
        D2.s sVar;
        C0946f c0946f = this.f25k;
        D2.s sVar2 = c0946f.f5203a.f5194r;
        sVar2.getClass();
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC0162z abstractC0162zA = (AbstractC0162z) it.next();
            D2.r predicate = D2.r.f263a;
            kotlin.jvm.internal.h.f(abstractC0162zA, "<this>");
            kotlin.jvm.internal.h.f(predicate, "predicate");
            if (b0.d(abstractC0162zA, predicate, null)) {
                sVar = sVar2;
            } else {
                sVar = sVar2;
                abstractC0162zA = sVar.a(new D2.u(this, false, c0946f, EnumC0868b.TYPE_PARAMETER_BOUNDS, false), abstractC0162zA, kotlin.collections.u.f3804a, null, false);
                if (abstractC0162zA == null) {
                    abstractC0162zA = abstractC0162zA;
                }
            }
            arrayList.add(abstractC0162zA);
            sVar2 = sVar;
        }
        return arrayList;
    }

    @Override // q2.AbstractC0772i
    public final void h(AbstractC0162z type) {
        kotlin.jvm.internal.h.f(type, "type");
    }

    @Override // q2.AbstractC0772i
    public final List i() {
        Collection<JavaClassifierType> upperBounds = this.f26l.getUpperBounds();
        boolean zIsEmpty = upperBounds.isEmpty();
        C0946f c0946f = this.f25k;
        if (zIsEmpty) {
            a3.F fE = c0946f.f5203a.f5192o.d.e();
            kotlin.jvm.internal.h.e(fE, "c.module.builtIns.anyType");
            return Z.p(a3.C.a(fE, c0946f.f5203a.f5192o.d.n()));
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(upperBounds));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(c0946f.e.s((JavaClassifierType) it.next(), kotlin.reflect.l.f0(2, false, this, 3)));
        }
        return arrayList;
    }
}
