package k2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.protobuf.v;
import m2.C0656h;
import q2.C0763B;
import q2.C0776m;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3722a;
    public final /* synthetic */ C0763B b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(C0763B c0763b, int i) {
        super(0);
        this.f3722a = i;
        this.b = c0763b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3722a) {
            case 0:
                return this.b.getPackage(p.f3765h).getMemberScope();
            case 1:
                return new C0656h(this.b);
            default:
                C0763B c0763b = this.b;
                v vVar = c0763b.f4532g;
                if (vVar == null) {
                    StringBuilder sb = new StringBuilder("Dependencies of module ");
                    String str = c0763b.getName().f962a;
                    kotlin.jvm.internal.h.e(str, "name.toString()");
                    sb.append(str);
                    sb.append(" were not set before querying module content");
                    throw new AssertionError(sb.toString());
                }
                List list = (List) vVar.f3877a;
                c0763b.f();
                list.contains(c0763b);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((C0763B) it.next()).getClass();
                }
                ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    PackageFragmentProvider packageFragmentProvider = ((C0763B) it2.next()).f4533h;
                    kotlin.jvm.internal.h.c(packageFragmentProvider);
                    arrayList.add(packageFragmentProvider);
                }
                return new C0776m("CompositeProvider@ModuleDescriptor for " + c0763b.getName(), arrayList);
        }
    }
}
