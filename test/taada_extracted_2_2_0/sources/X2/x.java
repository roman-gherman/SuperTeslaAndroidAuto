package X2;

import G2.U;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f1454a = new x(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        U it = (U) obj;
        kotlin.jvm.internal.h.f(it, "it");
        return Integer.valueOf(it.d.size());
    }
}
