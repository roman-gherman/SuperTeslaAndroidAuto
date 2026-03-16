package A2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import v2.EnumC0851b;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19a;
    public final /* synthetic */ L2.f b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ J(L2.f fVar, int i) {
        super(1);
        this.f19a = i;
        this.b = fVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f19a) {
            case 0:
                MemberScope it = (MemberScope) obj;
                kotlin.jvm.internal.h.f(it, "it");
                return it.getContributedVariables(this.b, EnumC0851b.e);
            default:
                MemberScope it2 = (MemberScope) obj;
                kotlin.jvm.internal.h.f(it2, "it");
                return it2.getContributedFunctions(this.b, EnumC0851b.f4934a);
        }
    }
}
