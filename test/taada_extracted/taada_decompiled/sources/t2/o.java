package t2;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f4812a = new o(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(((Class) obj).getSimpleName().length() == 0);
    }
}
