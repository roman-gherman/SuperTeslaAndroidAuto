package r3;

import a.AbstractC0132a;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4721a = 0;

    static {
        Object objN;
        Object objN2;
        Exception exc = new Exception();
        String simpleName = AbstractC0132a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), JavaConstant.Dynamic.DEFAULT_NAME, stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objN = U1.a.class.getCanonicalName();
        } catch (Throwable th) {
            objN = kotlin.reflect.l.n(th);
        }
        if (N1.h.a(objN) != null) {
            objN = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objN2 = v.class.getCanonicalName();
        } catch (Throwable th2) {
            objN2 = kotlin.reflect.l.n(th2);
        }
        if (N1.h.a(objN2) != null) {
            objN2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
