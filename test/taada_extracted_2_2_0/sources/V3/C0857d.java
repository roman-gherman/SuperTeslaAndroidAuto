package v3;

import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;

/* JADX INFO: renamed from: v3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0857d extends kotlin.jvm.internal.f implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0857d f4943a = new C0857d(3, g.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int andDecrement;
        g gVar = (g) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        N1.m mVar = N1.m.f1129a;
        if (obj3 == null) {
            gVar.getClass();
        } else if (gVar.holdsLock(obj3)) {
            selectInstance.selectInRegistrationPhase(h.b);
            return mVar;
        }
        kotlin.jvm.internal.h.d(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        C0856c c0856c = new C0856c(gVar, (SelectInstanceInternal) selectInstance, obj3);
        do {
            gVar.getClass();
            do {
                andDecrement = k.f4951f.getAndDecrement(gVar);
            } while (andDecrement > 1);
            if (andDecrement > 0) {
                c0856c.selectInRegistrationPhase(mVar);
                return mVar;
            }
        } while (!gVar.a(c0856c));
        return mVar;
    }
}
