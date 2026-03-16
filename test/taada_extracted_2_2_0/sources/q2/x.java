package q2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import n2.AbstractC0718j;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4645a;
    public final /* synthetic */ y b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(y yVar, int i) {
        super(0);
        this.f4645a = i;
        this.b = yVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f4645a) {
            case 0:
                y yVar = this.b;
                C0763B c0763b = yVar.c;
                c0763b.f();
                return Boolean.valueOf(AbstractC0718j.h((C0776m) c0763b.f4536k.getValue(), yVar.d));
            case 1:
                y yVar2 = this.b;
                C0763B c0763b2 = yVar2.c;
                c0763b2.f();
                return AbstractC0718j.i((C0776m) c0763b2.f4536k.getValue(), yVar2.d);
            default:
                y yVar3 = this.b;
                if (yVar3.isEmpty()) {
                    return U2.m.f1338a;
                }
                List fragments = yVar3.getFragments();
                ArrayList arrayList = new ArrayList(kotlin.collections.o.D(fragments));
                Iterator it = fragments.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PackageFragmentDescriptor) it.next()).getMemberScope());
                }
                C0763B c0763b3 = yVar3.c;
                L2.c cVar = yVar3.d;
                return E1.k.r("package view scope for " + cVar + " in " + c0763b3.getName(), kotlin.collections.m.d0(new M(c0763b3, cVar), arrayList));
        }
    }
}
