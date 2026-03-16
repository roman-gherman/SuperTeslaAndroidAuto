package fr.sd.taada.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.LiveData;
import android.view.MutableLiveData;
import androidx.preference.PreferenceManager;
import fr.sd.taada.activities.SubscriptionActivity;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.billing.BillingManager;
import fr.sd.taada.billing.SubscriptionState;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class DemoModeManager {
    private static final long DEMO_DURATION_MS = 600000;
    private static volatile DemoModeManager INSTANCE = null;
    private static final String PREF_DEMO_IS_ACTIVE = "demo_is_active";
    private static final String PREF_DEMO_LAST_USED = "demo_last_used_time";
    private static final String PREF_DEMO_PAUSED_REMAINING = "demo_paused_remaining_time";
    private static final String PREF_DEMO_SERVICES_STARTED = "demo_services_started";
    private static final String PREF_DEMO_START_TIME = "demo_start_time";
    private static final long REARM_DELAY_MS = 1000;
    private static final String TAG = "DemoModeManager";
    private final MutableLiveData<Boolean> canRearmDemo;
    private final Context context;
    private DemoModeListener demoModeListener;
    private final MutableLiveData<Long> demoTimeRemaining;
    private final MutableLiveData<Boolean> isDemoModeActive;
    private final MutableLiveData<Boolean> isDemoModeAvailable;
    private boolean isTimerRunning;
    private final LogManager logManager;
    private final Handler mainHandler;
    private final SharedPreferences preferences;
    private final MutableLiveData<Long> rearmTimeRemaining;
    private Runnable updateTimerRunnable;

    public interface DemoModeListener {
        void onDemoModeExpired();

        void onDemoModeReady();

        void onDemoModeStarted();
    }

    private DemoModeManager(Context context) {
        Boolean bool = Boolean.FALSE;
        this.isDemoModeAvailable = new MutableLiveData<>(bool);
        this.isDemoModeActive = new MutableLiveData<>(bool);
        MutableLiveData<Long> mutableLiveData = new MutableLiveData<>(0L);
        this.demoTimeRemaining = mutableLiveData;
        this.rearmTimeRemaining = new MutableLiveData<>(0L);
        this.canRearmDemo = new MutableLiveData<>(Boolean.TRUE);
        this.isTimerRunning = false;
        this.context = context;
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mainHandler = new Handler(Looper.getMainLooper());
        LogManager logManager = LogManager.getInstance(context);
        this.logManager = logManager;
        checkDemoModeAvailability();
        restoreDemoState();
        long remainingDemoTime = getRemainingDemoTime();
        mutableLiveData.postValue(Long.valueOf(remainingDemoTime));
        logManager.logInfo(TAG, "🎮 DemoModeManager initialisé - Compteur: " + formatTime(remainingDemoTime));
    }

    public static String formatTime(long j6) {
        long j7 = j6 / REARM_DELAY_MS;
        return String.format(Locale.ROOT, "%02d:%02d", Long.valueOf(j7 / 60), Long.valueOf(j7 % 60));
    }

    public static DemoModeManager getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (DemoModeManager.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new DemoModeManager(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDemoExpired$0() {
        updateRearmAvailability();
        this.logManager.logInfo(TAG, "🎮 Délai de réarmement écoulé - Bouton maintenant disponible");
    }

    private void logSessionEnd(String str) {
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                HashMap map = new HashMap();
                map.put("reason", str);
                map.put("demo_duration_used_ms", Long.valueOf(DEMO_DURATION_MS - getRemainingDemoTime()));
                TelemetryManager.getInstance().log(FunnelEvent.SESSION_END, map);
                this.logManager.logDebug(TAG, "📊 Telemetry: SESSION_END logged (" + str + ")");
            }
        } catch (Exception e) {
            this.logManager.logError(TAG, "Error logging SESSION_END", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDemoExpired() {
        this.logManager.logInfo(TAG, "🎮 Mode démo expiré - Arrêt des services");
        logSessionEnd("demo_expired");
        this.preferences.edit().putBoolean(PREF_DEMO_IS_ACTIVE, false).putBoolean(PREF_DEMO_SERVICES_STARTED, false).putLong(PREF_DEMO_LAST_USED, System.currentTimeMillis()).remove(PREF_DEMO_PAUSED_REMAINING).apply();
        this.isDemoModeActive.postValue(Boolean.FALSE);
        this.demoTimeRemaining.postValue(0L);
        stopUpdateTimer();
        this.mainHandler.postDelayed(new androidx.constraintlayout.helper.widget.a(this, 15), REARM_DELAY_MS);
        startUpdateTimer();
        DemoModeListener demoModeListener = this.demoModeListener;
        if (demoModeListener != null) {
            demoModeListener.onDemoModeExpired();
        }
    }

    private void restoreDemoState() {
        boolean z6 = this.preferences.getBoolean(PREF_DEMO_IS_ACTIVE, false);
        long j6 = this.preferences.getLong(PREF_DEMO_START_TIME, 0L);
        long remainingDemoTime = getRemainingDemoTime();
        if (!z6 || j6 <= 0 || remainingDemoTime <= 0) {
            if (j6 <= 0 || remainingDemoTime > 0) {
                this.logManager.logInfo(TAG, "🎮 Mode démo dans l'état initial");
                updateRearmAvailability();
                return;
            } else {
                this.logManager.logInfo(TAG, "🎮 Mode démo était expiré - Restauration de l'état expiré");
                onDemoExpired();
                return;
            }
        }
        this.isDemoModeActive.postValue(Boolean.TRUE);
        this.demoTimeRemaining.postValue(Long.valueOf(remainingDemoTime));
        startUpdateTimer();
        this.logManager.logInfo(TAG, "🎮 Mode démo restauré en cours d'exécution - " + formatTime(remainingDemoTime) + " restantes");
    }

    private void startUpdateTimer() {
        if (this.isTimerRunning) {
            return;
        }
        this.isTimerRunning = true;
        Runnable runnable = new Runnable() { // from class: fr.sd.taada.helpers.DemoModeManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (Boolean.TRUE.equals(DemoModeManager.this.isDemoModeActive.getValue())) {
                    long remainingDemoTime = DemoModeManager.this.getRemainingDemoTime();
                    DemoModeManager.this.demoTimeRemaining.postValue(Long.valueOf(remainingDemoTime));
                    if (remainingDemoTime <= 0) {
                        DemoModeManager.this.onDemoExpired();
                        return;
                    } else {
                        DemoModeManager.this.mainHandler.postDelayed(this, DemoModeManager.REARM_DELAY_MS);
                        return;
                    }
                }
                DemoModeManager.this.updateRearmAvailability();
                if (DemoModeManager.this.getTimeUntilRearm() > 0) {
                    DemoModeManager.this.mainHandler.postDelayed(this, DemoModeManager.REARM_DELAY_MS);
                } else {
                    DemoModeManager.this.isTimerRunning = false;
                    DemoModeManager.this.logManager.logDebug(DemoModeManager.TAG, "🎮 Timer de réarmement terminé - Bouton disponible");
                }
            }
        };
        this.updateTimerRunnable = runnable;
        this.mainHandler.post(runnable);
    }

    private void stopUpdateTimer() {
        Runnable runnable = this.updateTimerRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
            this.updateTimerRunnable = null;
        }
        this.isTimerRunning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearmAvailability() {
        long timeUntilRearm = getTimeUntilRearm();
        boolean zCanRearmNow = canRearmNow();
        this.canRearmDemo.postValue(Boolean.valueOf(zCanRearmNow));
        this.rearmTimeRemaining.postValue(Long.valueOf(timeUntilRearm));
        LogManager logManager = this.logManager;
        StringBuilder sb = new StringBuilder("Réarmement possible: ");
        sb.append(zCanRearmNow);
        sb.append(" (Compteur à zéro: ");
        sb.append(getRemainingDemoTime() <= 0);
        sb.append(", Délai écoulé: ");
        sb.append(timeUntilRearm <= 0);
        sb.append(", Services arrêtés: ");
        sb.append(!Boolean.TRUE.equals(this.isDemoModeActive.getValue()));
        sb.append(")");
        logManager.logDebug(TAG, sb.toString());
    }

    public boolean canRearmNow() {
        boolean zEquals = Boolean.TRUE.equals(this.isDemoModeActive.getValue());
        boolean z6 = !zEquals;
        boolean z7 = false;
        boolean z8 = getRemainingDemoTime() <= 0;
        boolean z9 = getTimeUntilRearm() <= 0;
        if (!zEquals && z8 && z9) {
            z7 = true;
        }
        this.logManager.logDebug(TAG, "🎮 canRearmNow() - NotActive: " + z6 + ", TimeZero: " + z8 + " (" + getRemainingDemoTime() + "ms), DelayPassed: " + z9 + " (" + getTimeUntilRearm() + "ms) → Result: " + z7);
        return z7;
    }

    public boolean canUseDemoMode() {
        if (this.isDemoModeAvailable.getValue().booleanValue()) {
            return !this.isDemoModeActive.getValue().booleanValue() || getRemainingDemoTime() > 0;
        }
        return false;
    }

    public void checkDemoModeAvailability() {
        SubscriptionState value = BillingManager.getInstance(this.context).getSubscriptionState().getValue();
        boolean z6 = false;
        boolean z7 = true ^ (value != null && value.allowsAppAccess());
        if (value != SubscriptionState.FREE_TRIAL && value != SubscriptionState.SUBSCRIBED && value != SubscriptionState.LIFETIME) {
            z6 = z7;
        }
        this.isDemoModeAvailable.postValue(Boolean.valueOf(z6));
        this.logManager.logDebug(TAG, "Mode démo disponible: " + z6 + " (État abonnement: " + value + ")");
    }

    public LiveData<Boolean> getCanRearmDemo() {
        return this.canRearmDemo;
    }

    public LiveData<Long> getDemoTimeRemaining() {
        return this.demoTimeRemaining;
    }

    public LiveData<Boolean> getIsDemoModeActive() {
        return this.isDemoModeActive;
    }

    public LiveData<Boolean> getIsDemoModeAvailable() {
        return this.isDemoModeAvailable;
    }

    public LiveData<Long> getRearmTimeRemaining() {
        return this.rearmTimeRemaining;
    }

    public long getRemainingDemoTime() {
        long j6 = this.preferences.getLong(PREF_DEMO_START_TIME, 0L);
        long j7 = this.preferences.getLong(PREF_DEMO_LAST_USED, 0L);
        long j8 = this.preferences.getLong(PREF_DEMO_PAUSED_REMAINING, 0L);
        if (!Boolean.TRUE.equals(this.isDemoModeActive.getValue()) && j8 > 0) {
            return j8;
        }
        if (j7 > 0) {
            return 0L;
        }
        return j6 == 0 ? DEMO_DURATION_MS : Math.max(0L, DEMO_DURATION_MS - (System.currentTimeMillis() - j6));
    }

    public long getTimeUntilRearm() {
        long j6 = this.preferences.getLong(PREF_DEMO_LAST_USED, 0L);
        if (j6 == 0) {
            return 0L;
        }
        return Math.max(0L, REARM_DELAY_MS - (System.currentTimeMillis() - j6));
    }

    public boolean hasAccess() {
        SubscriptionState value = BillingManager.getInstance(this.context).getSubscriptionState().getValue();
        if (value == null || !value.allowsAppAccess()) {
            return canUseDemoMode();
        }
        return true;
    }

    public void rearmDemoMode() {
        if (!canRearmNow()) {
            this.logManager.logWarning(TAG, "Tentative de réarmement du mode démo non autorisée - conditions non remplies");
            return;
        }
        this.preferences.edit().remove(PREF_DEMO_START_TIME).remove(PREF_DEMO_LAST_USED).remove(PREF_DEMO_PAUSED_REMAINING).putBoolean(PREF_DEMO_IS_ACTIVE, false).putBoolean(PREF_DEMO_SERVICES_STARTED, false).apply();
        this.isDemoModeActive.postValue(Boolean.FALSE);
        this.demoTimeRemaining.postValue(Long.valueOf(DEMO_DURATION_MS));
        this.canRearmDemo.postValue(Boolean.TRUE);
        this.rearmTimeRemaining.postValue(0L);
        stopUpdateTimer();
        this.logManager.logInfo(TAG, "🎮 Mode démo réarmé - prêt pour utilisation");
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                TelemetryManager.getInstance().logAndSync(FunnelEvent.DEMO_REARMED);
            }
        } catch (Exception e) {
            this.logManager.logError(TAG, "Error logging DEMO_REARMED", e);
        }
        DemoModeListener demoModeListener = this.demoModeListener;
        if (demoModeListener != null) {
            demoModeListener.onDemoModeReady();
        }
    }

    public void setDemoModeListener(DemoModeListener demoModeListener) {
        this.demoModeListener = demoModeListener;
    }

    public void showSubscriptionActivity() {
        Intent intent = new Intent(this.context, (Class<?>) SubscriptionActivity.class);
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    public void startDemoMode() {
        if (!this.isDemoModeAvailable.getValue().booleanValue()) {
            this.logManager.logWarning(TAG, "Tentative de démarrage du mode démo alors qu'il n'est pas disponible");
            return;
        }
        if (this.isDemoModeActive.getValue().booleanValue()) {
            this.logManager.logWarning(TAG, "Mode démo déjà actif");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j6 = this.preferences.getLong(PREF_DEMO_START_TIME, 0L);
        long j7 = this.preferences.getLong(PREF_DEMO_PAUSED_REMAINING, 0L);
        if (j7 > 0) {
            this.preferences.edit().putLong(PREF_DEMO_START_TIME, jCurrentTimeMillis - (DEMO_DURATION_MS - j7)).putBoolean(PREF_DEMO_IS_ACTIVE, true).putBoolean(PREF_DEMO_SERVICES_STARTED, true).remove(PREF_DEMO_PAUSED_REMAINING).apply();
            this.demoTimeRemaining.postValue(Long.valueOf(j7));
            this.logManager.logInfo(TAG, "🎮 Mode démo repris - " + formatTime(j7) + " restantes");
        } else if (j6 == 0) {
            this.preferences.edit().putLong(PREF_DEMO_START_TIME, jCurrentTimeMillis).putBoolean(PREF_DEMO_IS_ACTIVE, true).putBoolean(PREF_DEMO_SERVICES_STARTED, true).apply();
            this.demoTimeRemaining.postValue(Long.valueOf(DEMO_DURATION_MS));
            this.logManager.logInfo(TAG, "🎮 Mode démo démarré - 10 minutes disponibles (nouveau)");
        } else {
            this.preferences.edit().putBoolean(PREF_DEMO_IS_ACTIVE, true).putBoolean(PREF_DEMO_SERVICES_STARTED, true).apply();
            long remainingDemoTime = getRemainingDemoTime();
            this.demoTimeRemaining.postValue(Long.valueOf(remainingDemoTime));
            this.logManager.logInfo(TAG, "🎮 Mode démo redémarré - " + formatTime(remainingDemoTime) + " restantes");
        }
        this.isDemoModeActive.postValue(Boolean.TRUE);
        startUpdateTimer();
        DemoModeListener demoModeListener = this.demoModeListener;
        if (demoModeListener != null) {
            demoModeListener.onDemoModeStarted();
        }
    }

    public void stopDemoMode() {
        if (Boolean.TRUE.equals(this.isDemoModeActive.getValue())) {
            long remainingDemoTime = getRemainingDemoTime();
            this.preferences.edit().putBoolean(PREF_DEMO_IS_ACTIVE, false).putBoolean(PREF_DEMO_SERVICES_STARTED, false).putLong(PREF_DEMO_PAUSED_REMAINING, remainingDemoTime).apply();
            this.isDemoModeActive.postValue(Boolean.FALSE);
            stopUpdateTimer();
            updateRearmAvailability();
            this.logManager.logInfo(TAG, "🎮 Mode démo arrêté manuellement - Temps sauvegardé: " + formatTime(remainingDemoTime));
        }
    }
}
