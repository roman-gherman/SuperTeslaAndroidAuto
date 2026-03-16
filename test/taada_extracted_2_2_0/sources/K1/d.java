package K1;

import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f932a = new d(e.class, "top", "getTop()J");

    @Override // kotlin.jvm.internal.k, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return Long.valueOf(((e) obj).top);
    }

    @Override // kotlin.jvm.internal.k, kotlin.reflect.KMutableProperty1
    public final void set(Object obj, Object obj2) {
        ((e) obj).top = ((Number) obj2).longValue();
    }
}
