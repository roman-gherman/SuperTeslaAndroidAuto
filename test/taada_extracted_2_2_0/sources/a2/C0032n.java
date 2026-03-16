package A2;

import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: A2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0032n extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f54a;
    public final /* synthetic */ r b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0032n(r rVar, int i) {
        super(1);
        this.f54a = i;
        this.b = rVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f54a) {
            case 0:
                L2.f it = (L2.f) obj;
                kotlin.jvm.internal.h.f(it, "it");
                return r.o(this.b, it);
            default:
                L2.f it2 = (L2.f) obj;
                kotlin.jvm.internal.h.f(it2, "it");
                return r.p(this.b, it2);
        }
    }
}
