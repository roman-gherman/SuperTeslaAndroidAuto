package fr.sd.taada;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.multidex.MultiDex;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import fr.sd.taada.analytics.attribution.AttributionManager;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.analytics.telemetry.TelemetrySyncWorker;
import fr.sd.taada.core.PreferencesHelper;
import fr.sd.taada.core.auth.AuthManager;
import fr.sd.taada.helpers.LocaleHelper;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.ssl.SslUpdateWorker;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class TaaDaApplication extends Application {
    private static final String TAG = "TaaDaApplication";

    private void dispatchAttributionAsync() {
        AttributionManager.fetchAndDispatchAsync();
    }

    private void initializeAnalytics() {
        try {
            PreferencesHelper.initialize(this);
            AuthManager.INSTANCE.initialize(this, "https://telemetry.taada.top");
            AttributionManager.initialize(this);
            TelemetryManager.initialize(this);
            TelemetryManager.getInstance().log(FunnelEvent.APP_OPENED, null);
            TelemetrySyncWorker.INSTANCE.schedule(this);
            dispatchAttributionAsync();
        } catch (Exception e) {
            Log.e(TAG, "❌ Analytics initialization failed (non-fatal)", e);
        }
        scheduleSslUpdate();
    }

    private void scheduleSslUpdate() {
        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresCharging(false).build();
        WorkManager.getInstance(this).enqueue(new OneTimeWorkRequest.Builder(SslUpdateWorker.class).setConstraints(constraintsBuild).build());
        WorkManager.getInstance(this).enqueueUniquePeriodicWork("SslUpdateWork", ExistingPeriodicWorkPolicy.KEEP, new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) SslUpdateWorker.class, 1L, TimeUnit.DAYS).setConstraints(constraintsBuild).build());
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleHelper.initializeLocale(context));
        MultiDex.install(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        LogManager logManager = LogManager.getInstance(this);
        logManager.logDebug(TAG, "TaaDa Application started");
        logManager.logDebug(TAG, "Current language: " + LocaleHelper.getCurrentLanguage(this));
        try {
            LogManager logManager2 = LogManager.getInstance(this);
            logManager2.logInfo(TAG, "Application TaaDa démarrée");
            logManager2.logInfo(TAG, "Langue actuelle: " + LocaleHelper.getCurrentLanguage(this));
        } catch (Exception e) {
            Log.e(TAG, "Erreur lors de l'initialisation du LogManager", e);
            try {
                LogManager.getInstance(this).logError(TAG, "Erreur lors de l'initialisation du LogManager", e);
            } catch (Exception e6) {
                Log.e(TAG, "Erreur secondaire du LogManager", e6);
            }
        }
        initializeAnalytics();
    }
}
