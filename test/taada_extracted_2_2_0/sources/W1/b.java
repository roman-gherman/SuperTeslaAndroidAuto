package W1;

import c2.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        h.f(cause, "cause");
        h.f(exception, "exception");
        Method method = a.f1389a;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public f b() {
        return new c2.c();
    }

    public kotlin.text.c c(String str, MatchResult matchResult) {
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
