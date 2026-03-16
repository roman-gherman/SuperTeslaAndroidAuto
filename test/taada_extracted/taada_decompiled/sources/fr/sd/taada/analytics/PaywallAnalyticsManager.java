package fr.sd.taada.analytics;

import B2.b;
import android.content.Context;
import android.os.Bundle;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.config.PaywallConfigManager;
import fr.sd.taada.helpers.LogManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PaywallAnalyticsManager {
    private static final String TAG = "PaywallAnalyticsManager";
    private static PaywallAnalyticsManager instance;
    private final PaywallConfigManager configManager;
    private final Context context;
    private final LogManager logManager;

    private PaywallAnalyticsManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.logManager = LogManager.getInstance(applicationContext);
        this.configManager = PaywallConfigManager.getInstance(applicationContext);
        initAnalytics();
    }

    private Map<String, Object> bundleToMap(Bundle bundle) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            map.put(str, bundle.get(str));
        }
        return map;
    }

    private Bundle createBaseParams() {
        Bundle bundle = new Bundle();
        bundle.putString("variant_id", this.configManager.getConfig().getVariantId());
        return bundle;
    }

    public static synchronized PaywallAnalyticsManager getInstance(Context context) {
        try {
            if (instance == null) {
                instance = new PaywallAnalyticsManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private void initAnalytics() {
        try {
            this.logManager.logInfo(TAG, "Analytics initialized (Mode: LOGGING_ONLY - Firebase pending)");
        } catch (Exception e) {
            this.logManager.logError(TAG, "Error initializing Analytics", e);
        }
    }

    private void logEvent(String str, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            sb.append(str2);
            sb.append("=");
            sb.append(bundle.get(str2));
            sb.append(", ");
        }
        LogManager logManager = this.logManager;
        StringBuilder sbM = b.m("📊 EVENT: ", str, " [");
        sbM.append(sb.toString());
        sbM.append("]");
        logManager.logInfo(TAG, sbM.toString());
    }

    public void logPaywallDismissed(String str, boolean z6, boolean z7) {
        Bundle bundleCreateBaseParams = createBaseParams();
        bundleCreateBaseParams.putString("selected_product", str);
        bundleCreateBaseParams.putBoolean("had_selection", z6);
        bundleCreateBaseParams.putBoolean("purchase_attempted", z7);
        logEvent("paywall_dismissed", bundleCreateBaseParams);
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                TelemetryManager.getInstance().log(FunnelEvent.PAYWALL_DISMISSED, bundleToMap(bundleCreateBaseParams));
            }
        } catch (Exception unused) {
            this.logManager.logWarning(TAG, "Failed to send PAYWALL_DISMISSED telemetry");
        }
    }

    public void logPaywallView(String str) {
        Bundle bundleCreateBaseParams = createBaseParams();
        bundleCreateBaseParams.putString("source", str);
        logEvent("paywall_view", bundleCreateBaseParams);
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                TelemetryManager.getInstance().logAndSync(FunnelEvent.PAYWALL_VIEWED, bundleToMap(bundleCreateBaseParams));
            }
        } catch (Exception unused) {
            this.logManager.logWarning(TAG, "Failed to send PAYWALL_VIEWED telemetry");
        }
    }

    public void logProductSelect(String str) {
        Bundle bundleCreateBaseParams = createBaseParams();
        bundleCreateBaseParams.putString("product_id", str);
        logEvent("paywall_product_select", bundleCreateBaseParams);
    }

    public void logPurchaseComplete(String str, String str2, String str3, Double d, String str4, boolean z6) {
        Bundle bundleCreateBaseParams = createBaseParams();
        bundleCreateBaseParams.putString("product_id", str);
        bundleCreateBaseParams.putString("order_id", str2);
        bundleCreateBaseParams.putString("plan_type", str3);
        if (d != null) {
            bundleCreateBaseParams.putDouble("revenue", d.doubleValue());
        }
        if (str4 != null) {
            bundleCreateBaseParams.putString("currency", str4);
        }
        logEvent("paywall_purchase_complete", bundleCreateBaseParams);
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                TelemetryManager.getInstance().logAndSync(z6 ? FunnelEvent.TRIAL_STARTED : "lifetime".equals(str3) ? FunnelEvent.PURCHASE_COMPLETED : FunnelEvent.SUBSCRIPTION_STARTED, bundleToMap(bundleCreateBaseParams));
            }
        } catch (Exception unused) {
            this.logManager.logWarning(TAG, "Failed to send purchase telemetry");
        }
    }

    public void logPurchaseError(String str, String str2) {
        Bundle bundleCreateBaseParams = createBaseParams();
        bundleCreateBaseParams.putString("product_id", str);
        bundleCreateBaseParams.putString("error_message", str2);
        logEvent("paywall_purchase_error", bundleCreateBaseParams);
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                TelemetryManager.getInstance().log(FunnelEvent.PURCHASE_FAILED, bundleToMap(bundleCreateBaseParams));
            }
        } catch (Exception unused) {
            this.logManager.logWarning(TAG, "Failed to send PURCHASE_FAILED telemetry");
        }
    }

    public void logPurchaseStart(String str, String str2) {
        Bundle bundleCreateBaseParams = createBaseParams();
        bundleCreateBaseParams.putString("product_id", str);
        bundleCreateBaseParams.putString("plan_type", str2);
        logEvent("paywall_purchase_start", bundleCreateBaseParams);
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                TelemetryManager.getInstance().log(FunnelEvent.PURCHASE_INITIATED, bundleToMap(bundleCreateBaseParams));
            }
        } catch (Exception unused) {
            this.logManager.logWarning(TAG, "Failed to send PURCHASE_INITIATED telemetry");
        }
    }
}
