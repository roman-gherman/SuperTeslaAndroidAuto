package D2;

import a3.c0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.RawType;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f263a = new r(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        c0 it = (c0) obj;
        kotlin.jvm.internal.h.f(it, "it");
        return Boolean.valueOf(it instanceof RawType);
    }
}
