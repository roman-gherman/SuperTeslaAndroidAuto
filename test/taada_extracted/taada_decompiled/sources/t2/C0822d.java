package t2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: t2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0822d extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0822d f4803a = new C0822d(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ParameterizedType it = (ParameterizedType) obj;
        kotlin.jvm.internal.h.f(it, "it");
        Type[] actualTypeArguments = it.getActualTypeArguments();
        kotlin.jvm.internal.h.e(actualTypeArguments, "it.actualTypeArguments");
        return kotlin.collections.j.u(actualTypeArguments);
    }
}
