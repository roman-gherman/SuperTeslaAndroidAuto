package o3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j extends kotlin.jvm.internal.f implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4329a = new j(3, n.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws Throwable {
        n nVar = (n) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = n.b;
        nVar.getClass();
        if (obj3 != p.f4344l) {
            return nVar;
        }
        throw nVar.m();
    }
}
