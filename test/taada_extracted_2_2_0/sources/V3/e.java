package v3;

import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e extends kotlin.jvm.internal.f implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f4944a = new e(3, g.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        g gVar = (g) obj;
        gVar.getClass();
        if (!kotlin.jvm.internal.h.a(obj3, h.b)) {
            return gVar;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj2).toString());
    }
}
