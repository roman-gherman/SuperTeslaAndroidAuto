package fr.sd.taada.billing;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.preference.PreferenceManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionManager {
    private static final String CACHE_KEY_LAST_CHECK_TIME = "subscription_last_check_time";
    private static final String CACHE_KEY_SUBSCRIPTION_STATUS = "subscription_status_cached";
    private static final String CACHE_KEY_SUBSCRIPTION_TYPE = "subscription_type_cached";
    private static final long CACHE_VALIDITY_DURATION_MS = 0;
    private static volatile SubscriptionManager INSTANCE = null;
    private static final String TAG = "SubscriptionManager";
    private final BillingManager billingManager;
    private final Context context;
    private final SharedPreferences sharedPreferences;

    public interface SubscriptionCheckListener {
        void onResult(boolean z6);
    }

    public enum SubscriptionType {
        NONE,
        SUBSCRIPTION,
        LIFETIME
    }

    private SubscriptionManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        this.billingManager = BillingManager.getInstance(applicationContext);
    }

    private void checkSubscriptionViaBillingManager(SubscriptionCheckListener subscriptionCheckListener, boolean z6) {
        try {
            SubscriptionState value = this.billingManager.getSubscriptionState().getValue();
            Objects.toString(value);
            if (value == null) {
                Log.w(TAG, "⚠️ État d'abonnement null - En cours d'initialisation");
                this.billingManager.refreshSubscriptionStatus();
                boolean cachedSubscriptionStatus = getCachedSubscriptionStatus();
                Log.w(TAG, "📦 Fallback vers cache: " + cachedSubscriptionStatus);
                if (subscriptionCheckListener != null) {
                    subscriptionCheckListener.onResult(cachedSubscriptionStatus);
                    return;
                }
                return;
            }
            boolean zAllowsAppAccess = value.allowsAppAccess();
            SubscriptionType subscriptionType = SubscriptionType.NONE;
            if (zAllowsAppAccess) {
                subscriptionType = value == SubscriptionState.LIFETIME ? SubscriptionType.LIFETIME : SubscriptionType.SUBSCRIPTION;
            }
            value.toString();
            Objects.toString(subscriptionType);
            if (z6) {
                updateCache(zAllowsAppAccess, subscriptionType);
            }
            if (subscriptionCheckListener != null) {
                subscriptionCheckListener.onResult(zAllowsAppAccess);
            }
        } catch (Exception e) {
            Log.e(TAG, "❌ Erreur lors de la vérification via BillingManager", e);
            boolean cachedSubscriptionStatus2 = getCachedSubscriptionStatus();
            Log.w(TAG, "📦 Fallback vers cache après erreur: " + cachedSubscriptionStatus2);
            if (subscriptionCheckListener != null) {
                subscriptionCheckListener.onResult(cachedSubscriptionStatus2);
            }
        }
    }

    private boolean getCachedSubscriptionStatus() {
        boolean z6 = this.sharedPreferences.getBoolean(CACHE_KEY_SUBSCRIPTION_STATUS, false);
        this.sharedPreferences.getString(CACHE_KEY_SUBSCRIPTION_TYPE, SubscriptionType.NONE.name());
        this.sharedPreferences.getLong(CACHE_KEY_LAST_CHECK_TIME, CACHE_VALIDITY_DURATION_MS);
        return z6;
    }

    public static SubscriptionManager getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SubscriptionManager.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new SubscriptionManager(context);
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    private void invalidateCache() {
        this.sharedPreferences.edit().remove(CACHE_KEY_LAST_CHECK_TIME).apply();
    }

    private boolean isCacheValid() {
        return false;
    }

    private void refreshCacheInBackground() {
        checkSubscriptionViaBillingManager(null, true);
    }

    private void updateCache(boolean z6, SubscriptionType subscriptionType) {
        this.sharedPreferences.edit().putBoolean(CACHE_KEY_SUBSCRIPTION_STATUS, z6).putString(CACHE_KEY_SUBSCRIPTION_TYPE, subscriptionType.name()).putLong(CACHE_KEY_LAST_CHECK_TIME, System.currentTimeMillis()).apply();
        subscriptionType.toString();
    }

    public void clearCache() {
        this.sharedPreferences.edit().remove(CACHE_KEY_SUBSCRIPTION_STATUS).remove(CACHE_KEY_SUBSCRIPTION_TYPE).remove(CACHE_KEY_LAST_CHECK_TIME).apply();
    }

    public void destroy() {
    }

    public void forceRefresh() {
        invalidateCache();
        this.billingManager.refreshSubscriptionStatus();
        checkSubscriptionViaBillingManager(null, true);
    }

    public boolean isBillingServiceConnected() {
        Boolean value = this.billingManager.getBillingClientReady().getValue();
        return value != null && value.booleanValue();
    }

    public void isSubscribed(SubscriptionCheckListener subscriptionCheckListener) {
        if (!isCacheValid()) {
            checkSubscriptionViaBillingManager(subscriptionCheckListener, true);
            return;
        }
        boolean cachedSubscriptionStatus = getCachedSubscriptionStatus();
        if (subscriptionCheckListener != null) {
            subscriptionCheckListener.onResult(cachedSubscriptionStatus);
        }
        refreshCacheInBackground();
    }

    public void reconnect() {
        this.billingManager.refreshSubscriptionStatus();
    }
}
