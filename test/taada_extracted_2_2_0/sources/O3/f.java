package o3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f extends kotlin.jvm.internal.f implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f4326a = new f(3, n.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        n nVar = (n) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = n.b;
        nVar.getClass();
        if (obj3 == p.f4345l) {
            obj3 = new t(nVar.k());
        }
        return new v(obj3);
    }
}
