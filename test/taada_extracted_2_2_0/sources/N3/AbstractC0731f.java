package n3;

import N1.g;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: n3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0731f {

    @Nullable
    private static volatile Choreographer choreographer;

    static {
        Object objN;
        try {
            objN = new C0729d(a(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            objN = l.n(th);
        }
        if (objN instanceof g) {
            objN = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            h.d(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) objInvoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
