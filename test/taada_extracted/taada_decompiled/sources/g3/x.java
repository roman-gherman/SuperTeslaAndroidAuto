package g3;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f3337a = new x(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        k2.i iVar = (k2.i) obj;
        kotlin.jvm.internal.h.f(iVar, "$this$null");
        a3.F fR = iVar.r(k2.k.BOOLEAN);
        if (fR != null) {
            return fR;
        }
        k2.i.a(63);
        throw null;
    }
}
