package i2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.jvm.internal.y;
import kotlin.reflect.jvm.internal.calls.BoundCaller;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends m implements BoundCaller {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f3474g;

    /* JADX WARN: Illegal instructions before constructor call */
    public p(Object obj, Method method) {
        kotlin.jvm.internal.h.f(method, "method");
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        kotlin.jvm.internal.h.e(genericParameterTypes, "method.genericParameterTypes");
        super(method, false, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : kotlin.collections.j.x(genericParameterTypes, 1, genericParameterTypes.length)));
        this.f3474g = obj;
    }

    @Override // i2.m, kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        kotlin.jvm.internal.h.f(args, "args");
        kotlin.reflect.l.f(this, args);
        y yVar = new y(2);
        yVar.a(this.f3474g);
        yVar.b(args);
        ArrayList arrayList = yVar.f3818a;
        return c(null, arrayList.toArray(new Object[arrayList.size()]));
    }
}
