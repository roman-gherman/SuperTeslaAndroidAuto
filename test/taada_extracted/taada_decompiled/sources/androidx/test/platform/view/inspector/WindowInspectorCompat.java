package androidx.test.platform.view.inspector;

import android.os.Build;
import android.view.View;
import android.view.inspector.WindowInspector;
import androidx.test.internal.platform.reflect.ReflectionException;
import androidx.test.internal.platform.reflect.ReflectiveField;
import androidx.test.internal.platform.reflect.ReflectiveMethod;
import androidx.test.internal.util.Checks;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WindowInspectorCompat {
    private static final ReflectiveMethod<Object> getWindowManagerImplReflectiveCall = new ReflectiveMethod<>("android.view.WindowManagerImpl", "getDefault", new Class[0]);
    private static final ReflectiveMethod<Object> getWindowManagerGlobalReflectiveCall = new ReflectiveMethod<>("android.view.WindowManagerGlobal", "getInstance", new Class[0]);
    private static final ReflectiveField<List<View>> windowViewsReflectiveField = new ReflectiveField<>("android.view.WindowManagerGlobal", "mViews");
    private static final ReflectiveField<View[]> windowViewsPreKitkatReflectiveField = new ReflectiveField<>("android.view.WindowManagerGlobal", "mViews");
    private static final ReflectiveField<View[]> windowViewsPreJBReflectiveField = new ReflectiveField<>("android.view.WindowManagerImpl", "mViews");

    public static class ViewRetrievalException extends Exception {
        public ViewRetrievalException(Throwable th) {
            super("failed to retrieve window views", th);
        }
    }

    private WindowInspectorCompat() {
    }

    public static List<View> getGlobalWindowViews() throws ViewRetrievalException {
        Checks.checkMainThread();
        if (Build.VERSION.SDK_INT >= 29) {
            return WindowInspector.getGlobalWindowViews();
        }
        try {
            return getViews(getWindowManager());
        } catch (ReflectionException e) {
            throw new ViewRetrievalException(e.getCause());
        }
    }

    private static List<View> getViews(Object obj) {
        return windowViewsReflectiveField.get(obj);
    }

    private static Object getWindowManager() {
        return getWindowManagerGlobalReflectiveCall.invokeStatic(new Object[0]);
    }
}
