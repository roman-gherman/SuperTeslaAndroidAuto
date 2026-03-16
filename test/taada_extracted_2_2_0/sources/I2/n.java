package i2;

import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.calls.BoundCaller;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends m implements BoundCaller {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f3474g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Object obj, Method method) {
        super(method, false, 4);
        kotlin.jvm.internal.h.f(method, "method");
        this.f3474g = obj;
    }

    @Override // i2.m, kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        kotlin.jvm.internal.h.f(args, "args");
        kotlin.reflect.l.f(this, args);
        return c(this.f3474g, args);
    }
}
