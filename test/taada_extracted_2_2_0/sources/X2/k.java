package X2;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1439a;
    public final /* synthetic */ o b;
    public final /* synthetic */ AbstractC0612m c;
    public final /* synthetic */ a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(o oVar, AbstractC0612m abstractC0612m, a aVar, int i) {
        super(0);
        this.f1439a = i;
        this.b = oVar;
        this.c = abstractC0612m;
        this.d = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f1439a) {
            case 0:
                o oVar = this.b;
                r rVarA = oVar.a(oVar.f1444a.c);
                List listO0 = rVarA != null ? kotlin.collections.m.o0(oVar.f1444a.f1433a.e.loadCallableAnnotations(rVarA, this.c, this.d)) : null;
                if (listO0 == null) {
                }
                break;
            default:
                o oVar2 = this.b;
                r rVarA2 = oVar2.a(oVar2.f1444a.c);
                List listLoadExtensionReceiverParameterAnnotations = rVarA2 != null ? oVar2.f1444a.f1433a.e.loadExtensionReceiverParameterAnnotations(rVarA2, this.c, this.d) : null;
                if (listLoadExtensionReceiverParameterAnnotations == null) {
                }
                break;
        }
        return kotlin.collections.u.f3805a;
    }
}
