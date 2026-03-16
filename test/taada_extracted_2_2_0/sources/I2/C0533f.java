package i2;

import java.lang.reflect.Field;
import kotlin.reflect.jvm.internal.calls.BoundCaller;

/* JADX INFO: renamed from: i2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0533f extends i implements BoundCaller {
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0533f(Field field, Object obj) {
        super(field, false);
        kotlin.jvm.internal.h.f(field, "field");
        this.e = obj;
    }

    @Override // i2.i, kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        kotlin.jvm.internal.h.f(args, "args");
        kotlin.reflect.l.f(this, args);
        return ((Field) this.f3477a).get(this.e);
    }
}
