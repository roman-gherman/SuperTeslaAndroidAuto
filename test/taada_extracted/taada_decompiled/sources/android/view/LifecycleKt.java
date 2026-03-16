package android.view;

import android.view.Lifecycle;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.a;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.flow.Flow;
import m3.AbstractC0690y;
import m3.G;
import m3.t0;
import n3.C0729d;
import p3.c;
import p3.v;
import r3.o;
import t3.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/lifecycle/Lifecycle$Event;", "getEventFlow", "(Landroidx/lifecycle/Lifecycle;)Lkotlinx/coroutines/flow/Flow;", "lifecycle-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        h.f(lifecycle, "<this>");
        while (true) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl != null) {
                return lifecycleCoroutineScopeImpl;
            }
            t0 t0VarB = AbstractC0690y.b();
            d dVar = G.f4104a;
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = new LifecycleCoroutineScopeImpl(lifecycle, a.d(t0VarB, ((C0729d) o.f4718a).c));
            AtomicReference<Object> internalScopeRef = lifecycle.getInternalScopeRef();
            while (!internalScopeRef.compareAndSet(null, lifecycleCoroutineScopeImpl2)) {
                if (internalScopeRef.get() != null) {
                    break;
                }
            }
            lifecycleCoroutineScopeImpl2.register();
            return lifecycleCoroutineScopeImpl2;
        }
    }

    public static final Flow<Lifecycle.Event> getEventFlow(Lifecycle lifecycle) {
        h.f(lifecycle, "<this>");
        c cVarC = v.c(new LifecycleKt$eventFlow$1(lifecycle, null));
        d dVar = G.f4104a;
        return v.g(cVarC, ((C0729d) o.f4718a).c);
    }
}
