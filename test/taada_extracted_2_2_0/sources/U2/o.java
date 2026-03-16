package U2;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1339a;
    public final /* synthetic */ p b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(p pVar, int i) {
        super(0);
        this.f1339a = i;
        this.b = pVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        p pVar = this.b;
        switch (this.f1339a) {
            case 0:
                return kotlin.collections.n.y(N2.q.i(pVar.f1340a), N2.q.j(pVar.f1340a));
            default:
                return kotlin.collections.n.z(N2.q.h(pVar.f1340a));
        }
    }
}
