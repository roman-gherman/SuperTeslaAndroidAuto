package m3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n0 extends kotlin.jvm.internal.f implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f4140a = new n0(3, o0.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z6;
        int i = 1;
        o0 o0Var = (o0) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o0.f4142a;
        while (true) {
            Object objP = o0Var.p();
            if (!(objP instanceof Incomplete)) {
                z6 = false;
                break;
            }
            if (o0Var.B(objP) >= 0) {
                z6 = true;
                break;
            }
        }
        N1.m mVar = N1.m.f1129a;
        if (z6) {
            selectInstance.disposeOnCompletion(o0Var.invokeOnCompletion(false, true, new i0(o0Var, selectInstance, i)));
            return mVar;
        }
        selectInstance.selectInRegistrationPhase(mVar);
        return mVar;
    }
}
