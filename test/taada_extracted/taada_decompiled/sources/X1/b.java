package X1;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public class b extends W1.b {
    @Override // W1.b
    public final void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        h.f(cause, "cause");
        h.f(exception, "exception");
        Integer num = a.f1411a;
        if (num == null || num.intValue() >= 19) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
