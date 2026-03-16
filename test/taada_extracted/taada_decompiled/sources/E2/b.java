package E2;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f298a = new b(2);

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        a loadConstantFromProperty = (a) obj;
        p it = (p) obj2;
        kotlin.jvm.internal.h.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
        kotlin.jvm.internal.h.f(it, "it");
        return loadConstantFromProperty.c.get(it);
    }
}
