package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void stopForeground(Service service, int i) {
            service.stopForeground(i);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void startForeground(Service service, int i, Notification notification, int i3) {
            if (i3 == 0 || i3 == -1) {
                service.startForeground(i, notification, i3);
            } else {
                service.startForeground(i, notification, i3 & 255);
            }
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static void startForeground(Service service, int i, Notification notification, int i3) {
            if (i3 == 0 || i3 == -1) {
                service.startForeground(i, notification, i3);
            } else {
                service.startForeground(i, notification, i3 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void startForeground(Service service, int i, Notification notification, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 34) {
            Api34Impl.startForeground(service, i, notification, i3);
        } else if (i4 >= 29) {
            Api29Impl.startForeground(service, i, notification, i3);
        } else {
            service.startForeground(i, notification);
        }
    }

    public static void stopForeground(Service service, int i) {
        Api24Impl.stopForeground(service, i);
    }
}
