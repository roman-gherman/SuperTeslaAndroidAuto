package z;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c4.AbstractC0246d;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    public static final Object b = new Object();
    public static final b c = new b();

    public static AlertDialog d(Activity activity, int i, D.g gVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(D.f.b(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(fr.sd.taada.R.string.common_google_play_services_enable_button) : resources.getString(fr.sd.taada.R.string.common_google_play_services_update_button) : resources.getString(fr.sd.taada.R.string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, gVar);
        }
        String strC = D.f.c(activity, i);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", B2.b.c(i, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                f fVar = new f();
                D.j.d(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                fVar.f5162a = alertDialog;
                if (onCancelListener != null) {
                    fVar.b = onCancelListener;
                }
                fVar.show(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        DialogFragmentC0939a dialogFragmentC0939a = new DialogFragmentC0939a();
        D.j.d(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        dialogFragmentC0939a.f5158a = alertDialog;
        if (onCancelListener != null) {
            dialogFragmentC0939a.b = onCancelListener;
        }
        dialogFragmentC0939a.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogD = d(googleApiActivity, i, new D.g(super.a(googleApiActivity, i, "d"), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogD == null) {
            return;
        }
        e(googleApiActivity, alertDialogD, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Context context, int i, PendingIntent pendingIntent) {
        int i3;
        Log.w("GoogleApiAvailability", B2.b.d(i, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new g(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i == 6 ? D.f.e(context, "common_google_play_services_resolution_required_title") : D.f.c(context, i);
        if (strE == null) {
            strE = context.getResources().getString(fr.sd.taada.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i == 6 || i == 19) ? D.f.d(context, "common_google_play_services_resolution_required_text", D.f.a(context)) : D.f.b(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        D.j.c(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strE).setStyle(new NotificationCompat.BigTextStyle().bigText(strD));
        PackageManager packageManager = context.getPackageManager();
        if (AbstractC0246d.d == null) {
            AbstractC0246d.d = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (AbstractC0246d.d.booleanValue()) {
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (AbstractC0246d.b0(context)) {
                style.addAction(2131230854, resources.getString(fr.sd.taada.R.string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(fr.sd.taada.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strD);
        }
        synchronized (b) {
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String string = context.getResources().getString(fr.sd.taada.R.string.common_google_play_services_notification_channel_name);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
        } else if (!string.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(string);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        style.setChannelId("com.google.android.gms.availability");
        Notification notificationBuild = style.build();
        if (i == 1 || i == 2 || i == 3) {
            d.f5160a.set(false);
            i3 = 10436;
        } else {
            i3 = 39789;
        }
        notificationManager.notify(i3, notificationBuild);
    }

    public final void g(Activity activity, LifecycleFragment lifecycleFragment, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i, new D.g(super.a(activity, i, "d"), lifecycleFragment, 1), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
