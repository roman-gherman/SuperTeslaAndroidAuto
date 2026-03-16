package o3;

import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i extends kotlin.jvm.internal.f implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f4328a = new i(3, n.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ((n) obj).x((SelectInstance) obj2, obj3);
        return N1.m.f1129a;
    }
}
