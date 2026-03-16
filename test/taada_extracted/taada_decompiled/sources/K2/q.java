package k2;

import a3.C0150m;
import a3.d0;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import m2.C0659k;
import n2.AbstractC0713e;
import n2.C0712d;
import n2.EnumC0719k;
import q2.C;
import q2.C0773j;
import q2.P;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C f3773a;

    static {
        c3.j jVar = c3.j.f1775a;
        C0659k c0659k = new C0659k(c3.j.b, p.e, 1);
        L2.f fVarF = p.f3763f.f();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Z2.b bVar = Z2.n.e;
        C c = new C(c0659k, fVarF, sourceElement, bVar);
        c.f4537h = EnumC0719k.d;
        C0712d c0712d = AbstractC0713e.e;
        if (c0712d == null) {
            C.c(9);
            throw null;
        }
        c.i = c0712d;
        Annotations.Companion.getClass();
        List listP = Z.p(P.k(c, d0.IN_VARIANCE, L2.f.e("T"), 0, bVar));
        if (c.f4539k != null) {
            throw new IllegalStateException("Type parameters are already set for " + c.getName());
        }
        ArrayList arrayList = new ArrayList(listP);
        c.f4539k = arrayList;
        c.f4538j = new C0150m(c, arrayList, c.f4540l, c.f4541m);
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            C.c(13);
            throw null;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((C0773j) ((FunctionDescriptor) it.next())).q(c.getDefaultType());
        }
        f3773a = c;
    }
}
