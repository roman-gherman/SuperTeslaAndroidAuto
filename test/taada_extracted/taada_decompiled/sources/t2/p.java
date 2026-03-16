package t2;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f4813a = new p(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String simpleName = ((Class) obj).getSimpleName();
        if (!L2.f.f(simpleName)) {
            simpleName = null;
        }
        if (simpleName != null) {
            return L2.f.e(simpleName);
        }
        return null;
    }
}
