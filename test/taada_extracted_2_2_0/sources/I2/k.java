package i2;

import java.lang.reflect.Field;
import kotlin.reflect.jvm.internal.calls.BoundCaller;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends m implements BoundCaller {
    @Override // i2.m, kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) throws IllegalAccessException {
        kotlin.jvm.internal.h.f(args, "args");
        a(args);
        ((Field) this.f3477a).set(null, kotlin.collections.j.H(args));
        return N1.m.f1129a;
    }
}
