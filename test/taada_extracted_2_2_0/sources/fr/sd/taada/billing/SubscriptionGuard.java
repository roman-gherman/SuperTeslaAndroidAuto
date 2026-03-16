package fr.sd.taada.billing;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Observer;
import fr.sd.taada.activities.SubscriptionActivity;
import fr.sd.taada.helpers.DemoModeManager;
import fr.sd.taada.services.SubscriptionCheckService;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionGuard {
    private static final String TAG = "SubscriptionGuard";

    public interface SubscriptionCheckCallback {
        void onAccessDenied(String str);

        void onAccessGranted();

        void onTimeout();
    }

    public static boolean canAccessServices(Context context, String str) {
        return checkSubscriptionAccess(context, str, true);
    }

    public static boolean canAccessServicesSync(Context context, String str) {
        return checkSubscriptionAccess(context, str, false);
    }

    public static boolean canAutoStartServices(Context context, String str) {
        BillingManager billingManager = BillingManager.getInstance(context);
        if (billingManager == null) {
            Log.e(TAG, "❌ BillingManager est null - refus d'accès");
            return false;
        }
        SubscriptionState value = billingManager.getSubscriptionState().getValue();
        if (value == null) {
            Log.w(TAG, "❌ État d'abonnement null - vérification du mode démo");
            return checkDemoModeAccess(context, "Auto-start (" + str + ")", false);
        }
        boolean zAllowsAppAccess = value.allowsAppAccess();
        value.toString();
        if (zAllowsAppAccess) {
            return true;
        }
        return checkDemoModeAccess(context, androidx.constraintlayout.core.motion.a.q("Auto-start (", str, ")"), false);
    }

    private static boolean checkDemoModeAccess(Context context, String str, boolean z6) {
        DemoModeManager demoModeManager = DemoModeManager.getInstance(context);
        demoModeManager.checkDemoModeAvailability();
        if (!Boolean.TRUE.equals(demoModeManager.getIsDemoModeAvailable().getValue())) {
            Log.w(TAG, "🚫 Mode démo non disponible pour " + str);
            if (z6) {
                showSubscriptionRequired(context, str);
            }
            return false;
        }
        long remainingDemoTime = demoModeManager.getRemainingDemoTime();
        if (remainingDemoTime <= 0) {
            Log.w(TAG, "🚫 Mode démo épuisé (00:00) - réarmement requis pour " + str);
            if (z6) {
                showSubscriptionRequired(context, str);
            }
            return false;
        }
        if (!demoModeManager.hasAccess()) {
            Log.w(TAG, "🚫 Mode démo non disponible ou expiré pour " + str);
            if (z6) {
                showSubscriptionRequired(context, str);
            }
            return false;
        }
        DemoModeManager.formatTime(remainingDemoTime);
        if (!str.contains("Service") && !str.contains("Start") && !str.contains("Auto-start")) {
            return true;
        }
        demoModeManager.startDemoMode();
        return true;
    }

    private static boolean checkSubscriptionAccess(Context context, String str, boolean z6) {
        BillingManager billingManager = BillingManager.getInstance(context);
        if (billingManager == null) {
            Log.e(TAG, "❌ BillingManager est null - refus d'accès");
            return false;
        }
        SubscriptionState value = billingManager.getSubscriptionState().getValue();
        if (value == null) {
            Log.w(TAG, "❌ État d'abonnement null - vérification du mode démo");
            return checkDemoModeAccess(context, str, z6);
        }
        boolean zAllowsAppAccess = value.allowsAppAccess();
        value.toString();
        if (zAllowsAppAccess) {
            return true;
        }
        return checkDemoModeAccess(context, str, z6);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean checkSubscriptionAccessWithObserver(android.content.Context r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.billing.SubscriptionGuard.checkSubscriptionAccessWithObserver(android.content.Context, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkSubscriptionAccessWithObserver$0(final Object obj, final boolean[] zArr, final BillingManager billingManager, final boolean[] zArr2) {
        Observer<? super Boolean> observer = new Observer<Object>() { // from class: fr.sd.taada.billing.SubscriptionGuard.1
            @Override // android.view.Observer
            public void onChanged(Object obj2) {
                synchronized (obj) {
                    try {
                        if (zArr[0]) {
                            return;
                        }
                        Boolean value = billingManager.getBillingClientReady().getValue();
                        SubscriptionState value2 = billingManager.getSubscriptionState().getValue();
                        Objects.toString(value2);
                        if (value != null && value.booleanValue() && value2 != null && value2 != SubscriptionState.CHECKING) {
                            zArr2[0] = value2.allowsAppAccess();
                            zArr[0] = true;
                            value2.toString();
                            boolean z6 = zArr2[0];
                            billingManager.getBillingClientReady().removeObserver(this);
                            billingManager.getSubscriptionState().removeObserver(this);
                            obj.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        billingManager.getBillingClientReady().observeForever(observer);
        billingManager.getSubscriptionState().observeForever(observer);
        observer.onChanged(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkSubscriptionAccessWithObserver$1() {
    }

    public static void logAccessAttempt(Context context, String str, boolean z6, String str2) {
    }

    private static void showSubscriptionNotification(Context context, String str) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                NotificationChannel notificationChannel = new NotificationChannel("subscription_required", "Subscription Required", 4);
                notificationChannel.setDescription("Notifications when subscription is required");
                notificationManager.createNotificationChannel(notificationChannel);
                Notification.Builder builder = new Notification.Builder(context, "subscription_required");
                Intent intent = new Intent(context, (Class<?>) SubscriptionActivity.class);
                intent.putExtra(SubscriptionCheckService.EXTRA_TRIGGER_SOURCE, str);
                intent.putExtra("auto_triggered", true);
                builder.setContentTitle("Abonnement requis").setContentText("TaaDa ne peut pas démarrer automatiquement sans abonnement").setSmallIcon(R.drawable.ic_dialog_info).setContentIntent(PendingIntent.getActivity(context, 0, intent, 201326592)).setAutoCancel(true);
                notificationManager.notify(1001, builder.build());
            }
        } catch (Exception e) {
            Log.e(TAG, "❌ Erreur lors de l'affichage de la notification", e);
        }
    }

    private static void showSubscriptionRequired(Context context, String str) {
        try {
            Intent intent = new Intent(context, (Class<?>) SubscriptionActivity.class);
            intent.setFlags(335544320);
            intent.putExtra("service_type", str);
            intent.putExtra("auto_triggered", true);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "❌ Erreur lors de l'affichage de l'écran d'abonnement", e);
        }
    }

    public static void showSubscriptionRequiredDialog(Context context, String str) {
        try {
            Intent intent = new Intent(context, (Class<?>) SubscriptionActivity.class);
            intent.setFlags(872415232);
            intent.putExtra("service_type", "Auto-start");
            intent.putExtra(SubscriptionCheckService.EXTRA_TRIGGER_SOURCE, str);
            intent.putExtra("auto_triggered", true);
            intent.putExtra("blocked_auto_start", true);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "❌ Erreur lors de l'affichage de l'écran d'abonnement pour auto-start", e);
            showSubscriptionNotification(context, str);
        }
    }
}
