package m3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l0 extends kotlin.jvm.internal.f implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f4136a = new l0(3, o0.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        o0 o0Var = (o0) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o0.f4142a;
        while (true) {
            Object objP = o0Var.p();
            if (!(objP instanceof Incomplete)) {
                if (!(objP instanceof C0677k)) {
                    objP = AbstractC0690y.l(objP);
                }
                selectInstance.selectInRegistrationPhase(objP);
            } else if (o0Var.B(objP) >= 0) {
                selectInstance.disposeOnCompletion(o0Var.invokeOnCompletion(false, true, new i0(o0Var, selectInstance, 0)));
                break;
            }
        }
        return N1.m.f1129a;
    }
}
