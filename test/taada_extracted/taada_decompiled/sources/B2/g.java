package B2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f126a = new g(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        kotlin.jvm.internal.h.f(it, "it");
        return "(raw) ".concat(it);
    }
}
