package i2;

import java.lang.reflect.Field;
import kotlin.reflect.jvm.internal.calls.BoundCaller;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends m implements BoundCaller {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f3470g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Object obj, Field field, boolean z6) {
        super(field, z6, false);
        kotlin.jvm.internal.h.f(field, "field");
        this.f3470g = obj;
    }

    @Override // i2.m, kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) throws IllegalAccessException {
        kotlin.jvm.internal.h.f(args, "args");
        a(args);
        ((Field) this.f3476a).set(this.f3470g, kotlin.collections.j.A(args));
        return N1.m.f1129a;
    }
}
