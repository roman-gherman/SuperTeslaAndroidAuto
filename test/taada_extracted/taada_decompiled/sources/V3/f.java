package v3;

import A2.q;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends kotlin.jvm.internal.i implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f4944a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar) {
        super(3);
        this.f4944a = gVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return new q(11, this.f4944a, obj2);
    }
}
