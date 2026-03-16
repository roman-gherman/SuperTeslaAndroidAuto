package i2;

import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.reflect.jvm.internal.calls.BoundCaller;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends v implements BoundCaller {
    public final Object d;

    public t(Object obj, Method method) {
        super(method, kotlin.collections.u.f3804a);
        this.d = obj;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        kotlin.jvm.internal.h.f(args, "args");
        kotlin.reflect.l.f(this, args);
        return this.f3478a.invoke(this.d, Arrays.copyOf(args, args.length));
    }
}
