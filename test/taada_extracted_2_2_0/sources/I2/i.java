package i2;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends r {
    /* JADX WARN: Illegal instructions before constructor call */
    public i(Field field, boolean z6) {
        Type genericType = field.getGenericType();
        kotlin.jvm.internal.h.e(genericType, "field.genericType");
        super(field, genericType, z6 ? field.getDeclaringClass() : null, new Type[0]);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] args) {
        kotlin.jvm.internal.h.f(args, "args");
        a(args);
        return ((Field) this.f3477a).get(this.c != null ? kotlin.collections.j.A(args) : null);
    }
}
