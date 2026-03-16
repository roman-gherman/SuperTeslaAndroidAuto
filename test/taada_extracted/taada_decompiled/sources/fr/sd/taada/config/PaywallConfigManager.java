package fr.sd.taada.config;

import android.content.Context;
import fr.sd.taada.helpers.LogManager;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PaywallConfigManager {
    private static final String CONFIG_FILE_NAME = "paywall_config.json";
    private static final String TAG = "PaywallConfigManager";
    private static PaywallConfigManager instance;
    private final Context context;
    private PaywallConfig currentConfig;
    private final LogManager logManager;

    private PaywallConfigManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.logManager = LogManager.getInstance(applicationContext);
        this.currentConfig = new PaywallConfig();
        loadLocalConfig();
    }

    public static synchronized PaywallConfigManager getInstance(Context context) {
        try {
            if (instance == null) {
                instance = new PaywallConfigManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private void loadLocalConfig() {
        try {
            this.logManager.logDebug(TAG, "Loading local config from assets: paywall_config.json");
            InputStream inputStreamOpen = this.context.getAssets().open(CONFIG_FILE_NAME);
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            parseConfigJson(new String(bArr, StandardCharsets.UTF_8));
            this.logManager.logInfo(TAG, "✅ Config loaded successfully. Variant: " + this.currentConfig.getVariantId());
        } catch (Exception e) {
            this.logManager.logError(TAG, "❌ Error loading local config. Using defaults.", e);
        }
    }

    private void parseConfigJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            PaywallConfig paywallConfig = new PaywallConfig();
            paywallConfig.setVariantId(jSONObject.optString("variant_id", "default"));
            paywallConfig.setHeaderTitle(jSONObject.optString("header_title", paywallConfig.getHeaderTitle()));
            paywallConfig.setHeaderSubtitle(jSONObject.optString("header_subtitle", paywallConfig.getHeaderSubtitle()));
            paywallConfig.setMonthlyTitle(jSONObject.optString("monthly_title", paywallConfig.getMonthlyTitle()));
            paywallConfig.setMonthlyBadge(jSONObject.optString("monthly_badge", paywallConfig.getMonthlyBadge()));
            paywallConfig.setMonthlySubtitle(jSONObject.optString("monthly_subtitle", paywallConfig.getMonthlySubtitle()));
            paywallConfig.setAnnualTitle(jSONObject.optString("annual_title", paywallConfig.getAnnualTitle()));
            paywallConfig.setAnnualBadge(jSONObject.optString("annual_badge", paywallConfig.getAnnualBadge()));
            paywallConfig.setAnnualSubtitle(jSONObject.optString("annual_subtitle", paywallConfig.getAnnualSubtitle()));
            paywallConfig.setAnnualCallToAction(jSONObject.optString("annual_call_to_action", paywallConfig.getAnnualCallToAction()));
            paywallConfig.setLifetimeTitle(jSONObject.optString("lifetime_title", paywallConfig.getLifetimeTitle()));
            paywallConfig.setLifetimeBadge(jSONObject.optString("lifetime_badge", paywallConfig.getLifetimeBadge()));
            paywallConfig.setLifetimeSubtitle(jSONObject.optString("lifetime_subtitle", paywallConfig.getLifetimeSubtitle()));
            paywallConfig.setShowLifetimeOption(jSONObject.optBoolean("show_lifetime_option", true));
            paywallConfig.setHighlightAnnualPlan(jSONObject.optBoolean("highlight_annual_plan", true));
            paywallConfig.setShowTrustBadges(jSONObject.optBoolean("show_trust_badges", true));
            this.currentConfig = paywallConfig;
        } catch (Exception e) {
            this.logManager.logError(TAG, "❌ Error parsing config JSON", e);
        }
    }

    public void fetchConfig() {
        this.logManager.logInfo(TAG, "Fetching config (Simulated from local assets)...");
        loadLocalConfig();
    }

    public PaywallConfig getConfig() {
        return this.currentConfig;
    }
}
