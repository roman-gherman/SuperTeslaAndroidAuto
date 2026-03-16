package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
public final class AlarmManagerCompat {

    public static class Api19Impl {
        private Api19Impl() {
        }

        public static void setExact(AlarmManager alarmManager, int i, long j6, PendingIntent pendingIntent) {
            alarmManager.setExact(i, j6, pendingIntent);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static AlarmManager.AlarmClockInfo createAlarmClockInfo(long j6, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j6, pendingIntent);
        }

        public static void setAlarmClock(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void setAndAllowWhileIdle(AlarmManager alarmManager, int i, long j6, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i, j6, pendingIntent);
        }

        public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i, long j6, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i, j6, pendingIntent);
        }
    }

    private AlarmManagerCompat() {
    }

    public static void setAlarmClock(AlarmManager alarmManager, long j6, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Api21Impl.setAlarmClock(alarmManager, Api21Impl.createAlarmClockInfo(j6, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int i, long j6, PendingIntent pendingIntent) {
        Api23Impl.setAndAllowWhileIdle(alarmManager, i, j6, pendingIntent);
    }

    public static void setExact(AlarmManager alarmManager, int i, long j6, PendingIntent pendingIntent) {
        Api19Impl.setExact(alarmManager, i, j6, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i, long j6, PendingIntent pendingIntent) {
        Api23Impl.setExactAndAllowWhileIdle(alarmManager, i, j6, pendingIntent);
    }
}
