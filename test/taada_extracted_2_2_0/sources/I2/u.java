package i2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends v {
    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        kotlin.jvm.internal.h.f(args, "args");
        kotlin.reflect.l.f(this, args);
        Object obj = args[0];
        Object[] objArrX = args.length <= 1 ? new Object[0] : kotlin.collections.j.x(args, 1, args.length);
        return this.f3479a.invoke(obj, Arrays.copyOf(objArrX, objArrX.length));
    }
}
