package i2;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3476g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i, Method method) {
        super(method, false, 6);
        this.f3476g = i;
        switch (i) {
            case 1:
                kotlin.jvm.internal.h.f(method, "method");
                super(method, true, 4);
                break;
            case 2:
                kotlin.jvm.internal.h.f(method, "method");
                super(method, false, 6);
                break;
            default:
                kotlin.jvm.internal.h.f(method, "method");
                break;
        }
    }

    @Override // i2.m, kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        switch (this.f3476g) {
            case 0:
                kotlin.jvm.internal.h.f(args, "args");
                kotlin.reflect.l.f(this, args);
                return c(args[0], args.length <= 1 ? new Object[0] : kotlin.collections.j.x(args, 1, args.length));
            case 1:
                kotlin.jvm.internal.h.f(args, "args");
                kotlin.reflect.l.f(this, args);
                b(kotlin.collections.j.B(args));
                return c(null, args.length <= 1 ? new Object[0] : kotlin.collections.j.x(args, 1, args.length));
            default:
                kotlin.jvm.internal.h.f(args, "args");
                kotlin.reflect.l.f(this, args);
                return c(null, args);
        }
    }
}
