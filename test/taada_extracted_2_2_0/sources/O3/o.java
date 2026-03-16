package o3;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o extends kotlin.jvm.internal.f implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f4338a = new o(2, p.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        long jLongValue = ((Number) obj).longValue();
        w wVar = (w) obj2;
        w wVar2 = p.f4339a;
        n nVar = wVar.e;
        kotlin.jvm.internal.h.c(nVar);
        return new w(jLongValue, wVar, nVar, 0);
    }
}
