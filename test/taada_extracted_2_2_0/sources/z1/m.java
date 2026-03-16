package z1;

import java.util.List;
import kotlin.jvm.functions.Function2;
import o2.AbstractC0737a;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5182a;
    public final /* synthetic */ AbstractC0737a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(AbstractC0737a abstractC0737a, int i) {
        super(2);
        this.f5182a = i;
        this.b = abstractC0737a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        switch (this.f5182a) {
            case 0:
                String name = (String) obj;
                List values = (List) obj2;
                kotlin.jvm.internal.h.f(name, "name");
                kotlin.jvm.internal.h.f(values, "values");
                this.b.appendAll(name, values);
                break;
            default:
                String name2 = (String) obj;
                List values2 = (List) obj2;
                kotlin.jvm.internal.h.f(name2, "name");
                kotlin.jvm.internal.h.f(values2, "values");
                this.b.appendMissing(name2, values2);
                break;
        }
        return N1.m.f1129a;
    }
}
