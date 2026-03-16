package n2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4256a;
    public final /* synthetic */ L2.c b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(L2.c cVar, int i) {
        super(1);
        this.f4256a = i;
        this.b = cVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f4256a) {
            case 0:
                L2.c it = (L2.c) obj;
                kotlin.jvm.internal.h.f(it, "it");
                return Boolean.valueOf(!it.d() && kotlin.jvm.internal.h.a(it.e(), this.b));
            default:
                Annotations it2 = (Annotations) obj;
                kotlin.jvm.internal.h.f(it2, "it");
                return it2.findAnnotation(this.b);
        }
    }
}
