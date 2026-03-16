package fr.sd.taada.billing;

import E1.h;
import R0.d;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LiveData;
import android.view.MutableLiveData;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.android.billingclient.api.AbstractC0252c;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.C0251b;
import com.android.billingclient.api.C0253d;
import com.android.billingclient.api.C0255f;
import com.android.billingclient.api.C0256g;
import com.android.billingclient.api.C0257h;
import com.android.billingclient.api.D;
import com.android.billingclient.api.F;
import com.android.billingclient.api.I;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.l;
import com.android.billingclient.api.m;
import com.android.billingclient.api.n;
import com.android.billingclient.api.o;
import com.google.android.gms.internal.play_billing.A;
import fr.sd.taada.analytics.attribution.AttributionManager;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.ReviewRequestManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BillingManager implements PurchasesUpdatedListener, BillingClientStateListener {
    private static final String ANNUAL_BASE_PLAN_ID = "annual";
    private static final String LIFETIME_PRODUCT_ID = "lifetime";
    private static final String MONTHLY_BASE_PLAN_ID = "monthly";
    private static final String MONTHLY_SUBSCRIPTION_ID = "taada_premium_monthly";
    private static final String TAG = "BillingManager";
    private static final long TRIAL_DURATION_MS = 604800000;
    private static BillingManager instance;
    private final MutableLiveData<List<n>> allProductDetails;
    private AbstractC0252c billingClient;
    private final MutableLiveData<Boolean> billingClientReady;
    private final Context context;
    private boolean isConnecting;
    private LogManager logManager;
    private final MutableLiveData<Boolean> needsSubscriptionCancellation;
    private final Map<String, n> productDetailsMap;
    private final MutableLiveData<SubscriptionState> subscriptionState;

    private BillingManager(Context context) {
        MutableLiveData<SubscriptionState> mutableLiveData = new MutableLiveData<>();
        this.subscriptionState = mutableLiveData;
        Boolean bool = Boolean.FALSE;
        this.billingClientReady = new MutableLiveData<>(bool);
        this.allProductDetails = new MutableLiveData<>();
        this.needsSubscriptionCancellation = new MutableLiveData<>(bool);
        this.productDetailsMap = new HashMap();
        this.isConnecting = false;
        this.context = context;
        getLogManager().logDebug(TAG, "🚀 Initialisation du BillingManager (3 produits : mensuel, annuel, à vie)");
        mutableLiveData.postValue(SubscriptionState.CHECKING);
        initializeBillingClient();
    }

    private void acknowledgePurchase(Purchase purchase) {
        getLogManager().logDebug(TAG, "✅ Confirmation de l'achat: " + purchase.a());
        JSONObject jSONObject = purchase.c;
        String strOptString = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        if (strOptString == null) {
            throw new IllegalArgumentException("Purchase token must be set");
        }
        h hVar = new h(1);
        hVar.b = strOptString;
        this.billingClient.a(hVar, new d(2, this, purchase));
    }

    private void checkExistingPurchases() {
        getLogManager().logDebug(TAG, "🔍 Vérification de tous les achats existants");
        if (!this.billingClient.c()) {
            getLogManager().logError(TAG, "❌ BillingClient n'est pas prêt pour checkExistingPurchases");
            return;
        }
        h hVar = new h(2);
        hVar.b = "subs";
        this.billingClient.f(new h(hVar), new a(this));
    }

    private void connectToBillingService() {
        if (this.billingClient.c() || this.isConnecting) {
            if (this.isConnecting) {
                getLogManager().logDebug(TAG, "🔄 Connexion déjà en cours - Ignorer la demande");
            }
        } else {
            getLogManager().logDebug(TAG, "📡 Connexion au service de facturation Google Play");
            this.isConnecting = true;
            this.billingClient.g(this);
        }
    }

    public static String getAnnualBasePlanId() {
        return ANNUAL_BASE_PLAN_ID;
    }

    public static String getAnnualSubscriptionId() {
        return ANNUAL_BASE_PLAN_ID;
    }

    public static synchronized BillingManager getInstance(Context context) {
        try {
            if (instance == null) {
                instance = new BillingManager(context.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    public static String getLifetimeProductId() {
        return LIFETIME_PRODUCT_ID;
    }

    private LogManager getLogManager() {
        if (this.logManager == null) {
            this.logManager = LogManager.getInstance(this.context);
        }
        return this.logManager;
    }

    public static String getMonthlyBasePlanId() {
        return MONTHLY_BASE_PLAN_ID;
    }

    public static String getMonthlySubscriptionId() {
        return MONTHLY_SUBSCRIPTION_ID;
    }

    private void initializeBillingClient() {
        AbstractC0252c d;
        getLogManager().logDebug(TAG, "🔧 Initialisation du client de facturation");
        n0.d dVar = new n0.d(3);
        Context context = this.context;
        C0251b c0251b = new C0251b(context);
        c0251b.c = this;
        c0251b.f1825a = dVar;
        if (context == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        if (c0251b.c == null) {
            throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
        }
        if (c0251b.f1825a == null) {
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }
        c0251b.f1825a.getClass();
        if (c0251b.c != null) {
            n0.d dVar2 = c0251b.f1825a;
            BillingManager billingManager = c0251b.c;
            d = c0251b.a() ? new D(dVar2, context, billingManager) : new C0253d(dVar2, context, billingManager);
        } else {
            n0.d dVar3 = c0251b.f1825a;
            d = c0251b.a() ? new D(dVar3, context) : new C0253d(dVar3, context);
        }
        this.billingClient = d;
        connectToBillingService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$acknowledgePurchase$5(Purchase purchase, C0257h c0257h) {
        if (c0257h.f1844a == 0) {
            getLogManager().logDebug(TAG, "✅ Achat confirmé avec succès");
            logPurchaseToMMP(purchase);
        } else {
            getLogManager().logError(TAG, "❌ Erreur lors de la confirmation de l'achat: " + c0257h.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkExistingPurchases$3(List list, C0257h c0257h, List list2) {
        LogManager logManager = getLogManager();
        StringBuilder sb = new StringBuilder("🛒 Produits uniques trouvés: ");
        sb.append(list2 != null ? list2.size() : 0);
        logManager.logDebug(TAG, sb.toString());
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        updateSubscriptionState(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$checkExistingPurchases$4(C0257h c0257h, List list) {
        LogManager logManager = getLogManager();
        StringBuilder sb = new StringBuilder("🛒 Abonnements trouvés: ");
        sb.append(list != null ? list.size() : 0);
        logManager.logDebug(TAG, sb.toString());
        h hVar = new h(2);
        hVar.b = "inapp";
        this.billingClient.f(new h(hVar), new d(3, this, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$getProductDetails$6(MutableLiveData mutableLiveData, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (MONTHLY_SUBSCRIPTION_ID.equals(nVar.c)) {
                    mutableLiveData.setValue(nVar);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$queryAllProductDetails$1(C0257h c0257h, List list) {
        int i = c0257h.f1844a;
        getLogManager().logDebug(TAG, "📱 Réponse query produits uniques - Code: " + i);
        if (i == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                this.productDetailsMap.put(nVar.c, nVar);
                getLogManager().logDebug(TAG, "✅ Produit unique chargé: " + nVar.c + " - " + nVar.f1850f);
            }
        }
        this.allProductDetails.postValue(new ArrayList(this.productDetailsMap.values()));
        getLogManager().logDebug(TAG, "📦 Total produits chargés: " + this.productDetailsMap.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$queryAllProductDetails$2(List list, C0257h c0257h, List list2) {
        int i = c0257h.f1844a;
        getLogManager().logDebug(TAG, "📱 Réponse query abonnements - Code: " + i);
        if (i != 0 || list2 == null) {
            getLogManager().logError(TAG, "❌ Erreur lors du chargement des abonnements: " + c0257h.b);
        } else {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                this.productDetailsMap.put(nVar.c, nVar);
                getLogManager().logDebug(TAG, "✅ Abonnement chargé: " + nVar.c + " - " + nVar.f1850f);
                ArrayList<m> arrayList = nVar.i;
                if (arrayList != null) {
                    for (m mVar : arrayList) {
                        getLogManager().logDebug(TAG, "  📋 Plan de base trouvé: " + mVar.f1848a);
                    }
                }
            }
        }
        o oVar = new o();
        oVar.a(list);
        if (oVar.f1854a == null) {
            throw new IllegalArgumentException("Product list must be set to a non empty list.");
        }
        this.billingClient.e(new o(oVar), new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleAutomaticReconnection$0() {
        getLogManager().logInfo(TAG, "🔄 Tentative de reconnexion automatique...");
        if (this.billingClient.c()) {
            getLogManager().logDebug(TAG, "✅ Client déjà reconnecté - annulation de la reconnexion automatique");
        } else {
            getLogManager().logInfo(TAG, "🔗 Reconnexion automatique en cours...");
            connectToBillingService();
        }
    }

    private void logPurchaseCancelled() {
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                HashMap map = new HashMap();
                map.put("reason", "user_cancelled_billing_dialog");
                TelemetryManager.getInstance().logAndSync(FunnelEvent.PURCHASE_CANCELLED, map);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to log PURCHASE_CANCELLED", e);
        }
    }

    private void logPurchaseFailed(int i, String str) {
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                HashMap map = new HashMap();
                map.put("error_code", String.valueOf(i));
                if (str == null) {
                    str = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                map.put("error_message", str);
                TelemetryManager.getInstance().logAndSync(FunnelEvent.PURCHASE_FAILED, map);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to log PURCHASE_FAILED", e);
        }
    }

    private void logPurchaseToMMP(Purchase purchase) {
        String str;
        double d;
        n nVar;
        ArrayList arrayList;
        String str2;
        try {
            if (AttributionManager.isInitialized()) {
                String str3 = purchase.a().isEmpty() ? EnvironmentCompat.MEDIA_UNKNOWN : (String) purchase.a().get(0);
                if (LIFETIME_PRODUCT_ID.equals(str3)) {
                    n nVar2 = this.productDetailsMap.get(LIFETIME_PRODUCT_ID);
                    if (nVar2 == null || nVar2.a() == null) {
                        str2 = "EUR";
                        d = 0.0d;
                    } else {
                        d = nVar2.a().b / 1000000.0d;
                        str2 = nVar2.a().c;
                    }
                    str = str2;
                } else if (!str3.equals(MONTHLY_SUBSCRIPTION_ID) || (nVar = this.productDetailsMap.get(MONTHLY_SUBSCRIPTION_ID)) == null || (arrayList = nVar.i) == null) {
                    str = "EUR";
                    d = 0.0d;
                } else {
                    Iterator it = arrayList.iterator();
                    str = "EUR";
                    d = 0.0d;
                    while (it.hasNext()) {
                        Iterator it2 = ((ArrayList) ((m) it.next()).c.b).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            l lVar = (l) it2.next();
                            long j6 = lVar.b;
                            if (j6 > 0) {
                                d = j6 / 1000000.0d;
                                str = lVar.c;
                                break;
                            }
                        }
                        if (d > 0.0d) {
                            break;
                        }
                    }
                }
                if (d <= 0.0d) {
                    getLogManager().logWarning(TAG, "⚠️ MMP: Could not extract price for " + str3);
                    return;
                }
                AttributionManager.logPurchase(d, str, str3);
                getLogManager().logDebug(TAG, "📤 MMP: Logged purchase " + str3 + " = " + d + " " + str);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to log purchase to MMP", e);
        }
    }

    private void notifySubscriptionCancellationNeeded() {
        getLogManager().logInfo(TAG, "🔔 Notification: L'utilisateur devrait annuler ses abonnements");
        this.needsSubscriptionCancellation.postValue(Boolean.TRUE);
    }

    private void queryAllProductDetails() {
        getLogManager().logDebug(TAG, "🔍 Recherche de tous les produits");
        if (!this.billingClient.c()) {
            getLogManager().logError(TAG, "❌ BillingClient n'est pas prêt pour queryAllProductDetails");
            return;
        }
        ArrayList arrayList = new ArrayList();
        I i = new I();
        i.f1819a = MONTHLY_SUBSCRIPTION_ID;
        i.b = "subs";
        arrayList.add(i.a());
        ArrayList arrayList2 = new ArrayList();
        I i3 = new I();
        i3.f1819a = LIFETIME_PRODUCT_ID;
        i3.b = "inapp";
        arrayList2.add(i3.a());
        o oVar = new o();
        oVar.a(arrayList);
        if (oVar.f1854a == null) {
            throw new IllegalArgumentException("Product list must be set to a non empty list.");
        }
        this.billingClient.e(new o(oVar), new d(1, this, arrayList2));
    }

    private void scheduleAutomaticReconnection() {
        getLogManager().logInfo(TAG, "🔄 Programmation de la reconnexion automatique dans 2 secondes...");
        new Handler(Looper.getMainLooper()).postDelayed(new androidx.constraintlayout.helper.widget.a(this, 13), 2000L);
    }

    private void updateSubscriptionState(List<Purchase> list) {
        LogManager logManager = getLogManager();
        StringBuilder sb = new StringBuilder("🔄 Mise à jour de l'état d'abonnement avec ");
        sb.append(list != null ? list.size() : 0);
        sb.append(" achats");
        logManager.logDebug(TAG, sb.toString());
        if (list == null || list.isEmpty()) {
            getLogManager().logDebug(TAG, "❌ Aucun achat trouvé");
            this.subscriptionState.postValue(SubscriptionState.NO_SUBSCRIPTION);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Purchase purchase = null;
        for (Purchase purchase2 : list) {
            boolean zContains = purchase2.a().contains(LIFETIME_PRODUCT_ID);
            JSONObject jSONObject = purchase2.c;
            if (zContains && jSONObject.optInt("purchaseState", 1) != 4) {
                getLogManager().logDebug(TAG, "🎉 Produit à vie détecté !");
                purchase = purchase2;
            } else if (purchase2.a().contains(MONTHLY_SUBSCRIPTION_ID) && jSONObject.optInt("purchaseState", 1) != 4 && jSONObject.optBoolean("autoRenewing")) {
                arrayList.add(purchase2);
                getLogManager().logDebug(TAG, "📱 Abonnement actif trouvé: " + purchase2.a());
            }
        }
        if (purchase != null) {
            this.subscriptionState.postValue(SubscriptionState.LIFETIME);
            ReviewRequestManager.getInstance(this.context).onPremiumPurchaseCompleted();
            if (!purchase.c.optBoolean("acknowledged", true)) {
                acknowledgePurchase(purchase);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            getLogManager().logWarning(TAG, "⚠️ ATTENTION: L'utilisateur a un accès à vie mais aussi " + arrayList.size() + " abonnement(s) actif(s)");
            getLogManager().logWarning(TAG, "💡 L'utilisateur devrait annuler ses abonnements pour éviter les charges inutiles");
            notifySubscriptionCancellationNeeded();
            return;
        }
        for (Purchase purchase3 : list) {
            if (purchase3.a().contains(MONTHLY_SUBSCRIPTION_ID)) {
                JSONObject jSONObject2 = purchase3.c;
                if (jSONObject2.optInt("purchaseState", 1) != 4) {
                    getLogManager().logDebug(TAG, "📱 Abonnement trouvé: " + purchase3.a());
                    long jOptLong = jSONObject2.optLong("purchaseTime");
                    long jCurrentTimeMillis = System.currentTimeMillis() - jOptLong;
                    getLogManager().logDebug(TAG, "📅 Date d'achat: " + new Date(jOptLong));
                    getLogManager().logDebug(TAG, "📅 Temps écoulé: " + (jCurrentTimeMillis / 86400000) + " jours");
                    getLogManager().logDebug(TAG, "🔄 Auto-renouvelé: " + jSONObject2.optBoolean("autoRenewing"));
                    if (jCurrentTimeMillis >= TRIAL_DURATION_MS || !jSONObject2.optBoolean("autoRenewing")) {
                        getLogManager().logDebug(TAG, "✅ Abonnement payant actif");
                        this.subscriptionState.postValue(SubscriptionState.SUBSCRIBED);
                    } else {
                        getLogManager().logDebug(TAG, "✅ Essai gratuit détecté");
                        this.subscriptionState.postValue(SubscriptionState.FREE_TRIAL);
                    }
                    ReviewRequestManager.getInstance(this.context).onPremiumPurchaseCompleted();
                    if (jSONObject2.optBoolean("acknowledged", true)) {
                        return;
                    }
                    acknowledgePurchase(purchase3);
                    return;
                }
            }
        }
        getLogManager().logDebug(TAG, "❌ Aucun achat actif trouvé");
        this.subscriptionState.postValue(SubscriptionState.NO_SUBSCRIPTION);
    }

    public void destroy() {
        getLogManager().logDebug(TAG, "🗑️ Destruction du BillingManager");
        AbstractC0252c abstractC0252c = this.billingClient;
        if (abstractC0252c != null) {
            abstractC0252c.b();
        }
    }

    public LiveData<List<n>> getAllProductDetails() {
        return this.allProductDetails;
    }

    public m getAnnualOfferDetails() {
        ArrayList<m> arrayList;
        n nVar = this.productDetailsMap.get(MONTHLY_SUBSCRIPTION_ID);
        if (nVar == null || (arrayList = nVar.i) == null) {
            return null;
        }
        for (m mVar : arrayList) {
            if (ANNUAL_BASE_PLAN_ID.equals(mVar.f1848a)) {
                return mVar;
            }
        }
        return null;
    }

    public LiveData<Boolean> getBillingClientReady() {
        return this.billingClientReady;
    }

    public m getMonthlyOfferDetails() {
        ArrayList<m> arrayList;
        n nVar = this.productDetailsMap.get(MONTHLY_SUBSCRIPTION_ID);
        if (nVar == null || (arrayList = nVar.i) == null) {
            return null;
        }
        for (m mVar : arrayList) {
            if (MONTHLY_BASE_PLAN_ID.equals(mVar.f1848a)) {
                return mVar;
            }
        }
        return null;
    }

    public LiveData<Boolean> getNeedsSubscriptionCancellation() {
        return this.needsSubscriptionCancellation;
    }

    public n getProductDetails(String str) {
        return this.productDetailsMap.get(str);
    }

    public LiveData<SubscriptionState> getSubscriptionState() {
        return this.subscriptionState;
    }

    public boolean isProductAvailable(String str) {
        if (ANNUAL_BASE_PLAN_ID.equals(str) || MONTHLY_BASE_PLAN_ID.equals(str)) {
            return (ANNUAL_BASE_PLAN_ID.equals(str) ? getAnnualOfferDetails() : getMonthlyOfferDetails()) != null;
        }
        return this.productDetailsMap.containsKey(str);
    }

    public void launchPurchaseFlow(Activity activity, String str) {
        String str2;
        String str3;
        m mVar;
        getLogManager().logDebug(TAG, "🚀 Lancement du flux d'achat pour: " + str);
        if (ANNUAL_BASE_PLAN_ID.equals(str) || MONTHLY_BASE_PLAN_ID.equals(str)) {
            getLogManager().logDebug(TAG, "🔄 Plan de base détecté: " + str + " pour le produit: taada_premium_monthly");
            str2 = MONTHLY_SUBSCRIPTION_ID;
            str3 = str;
        } else {
            str2 = str;
            str3 = null;
        }
        n nVar = this.productDetailsMap.get(str2);
        if (nVar == null) {
            getLogManager().logError(TAG, "❌ Détails du produit non disponibles pour: " + str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (LIFETIME_PRODUCT_ID.equals(str2)) {
            I i = new I();
            i.f1819a = nVar;
            if (nVar.a() != null) {
                nVar.a().getClass();
                String str4 = nVar.a().d;
                if (str4 != null) {
                    i.b = str4;
                }
            }
            n nVar2 = (n) i.f1819a;
            if (nVar2 == null) {
                throw new NullPointerException("ProductDetails is required for constructing ProductDetailsParams.");
            }
            if (nVar2.i != null && ((String) i.b) == null) {
                throw new NullPointerException("offerToken is required for constructing ProductDetailsParams for subscriptions.");
            }
            arrayList.add(new C0255f(i));
        } else {
            ArrayList arrayList2 = nVar.i;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                getLogManager().logError(TAG, "❌ Aucune offre d'abonnement disponible pour: " + str2);
                return;
            }
            if (str3 != null) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        mVar = null;
                        break;
                    }
                    mVar = (m) it.next();
                    getLogManager().logDebug(TAG, "🔍 Vérification du plan de base: " + mVar.f1848a + " vs " + str3);
                    if (str3.equals(mVar.f1848a)) {
                        getLogManager().logDebug(TAG, "✅ Plan de base trouvé: ".concat(str3));
                        break;
                    }
                }
            } else {
                mVar = (m) arrayList2.get(0);
            }
            if (mVar == null) {
                getLogManager().logError(TAG, "❌ Plan de base non trouvé: " + str3);
                return;
            }
            I i3 = new I();
            i3.f1819a = nVar;
            if (nVar.a() != null) {
                nVar.a().getClass();
                String str5 = nVar.a().d;
                if (str5 != null) {
                    i3.b = str5;
                }
            }
            String str6 = mVar.b;
            if (TextUtils.isEmpty(str6)) {
                throw new IllegalArgumentException("offerToken can not be empty");
            }
            i3.b = str6;
            n nVar3 = (n) i3.f1819a;
            if (nVar3 == null) {
                throw new NullPointerException("ProductDetails is required for constructing ProductDetailsParams.");
            }
            if (nVar3.i != null && str6 == null) {
                throw new NullPointerException("offerToken is required for constructing ProductDetailsParams for subscriptions.");
            }
            arrayList.add(new C0255f(i3));
        }
        ArrayList arrayList3 = new ArrayList(arrayList);
        boolean zIsEmpty = arrayList3.isEmpty();
        if (zIsEmpty) {
            throw new IllegalArgumentException("Details of the products must be provided.");
        }
        arrayList3.forEach(new F());
        C0256g c0256g = new C0256g();
        c0256g.f1843a = (zIsEmpty || ((C0255f) arrayList3.get(0)).f1842a.b.optString("packageName").isEmpty()) ? false : true;
        boolean z6 = (TextUtils.isEmpty(null) && TextUtils.isEmpty(null)) ? false : true;
        boolean zIsEmpty2 = TextUtils.isEmpty(null);
        if (z6 && !zIsEmpty2) {
            throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
        }
        c0256g.b = new D.d(3, (byte) 0);
        c0256g.d = new ArrayList();
        c0256g.c = A.j(arrayList3);
        C0257h c0257hD = this.billingClient.d(activity, c0256g);
        if (c0257hD.f1844a != 0) {
            getLogManager().logError(TAG, "❌ Erreur lors du lancement du flux de facturation: " + c0257hD.b);
            return;
        }
        getLogManager().logDebug(TAG, "✅ Flux de facturation lancé avec succès pour: " + str + " (produit: " + str2 + ", plan: " + str3 + ")");
    }

    public void launchSubscriptionFlow(Activity activity) {
        launchPurchaseFlow(activity, MONTHLY_SUBSCRIPTION_ID);
    }

    public void markCancellationNotificationSeen() {
        this.needsSubscriptionCancellation.postValue(Boolean.FALSE);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        getLogManager().logWarning(TAG, "⚠️ Service de facturation déconnecté");
        this.billingClientReady.postValue(Boolean.FALSE);
        this.isConnecting = false;
        scheduleAutomaticReconnection();
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(@NonNull C0257h c0257h) {
        int i = c0257h.f1844a;
        getLogManager().logDebug(TAG, "=== BILLING SETUP FINISHED ===");
        getLogManager().logDebug(TAG, "Response code: " + i);
        getLogManager().logDebug(TAG, "Debug message: " + c0257h.b);
        this.isConnecting = false;
        if (i == 0) {
            getLogManager().logDebug(TAG, "✅ Connexion au service de facturation réussie");
            this.billingClientReady.postValue(Boolean.TRUE);
            queryAllProductDetails();
            checkExistingPurchases();
            return;
        }
        getLogManager().logError(TAG, "❌ Erreur lors de la connexion au service de facturation: " + c0257h.b + " (Code: " + i + ")");
        this.billingClientReady.postValue(Boolean.FALSE);
        this.subscriptionState.postValue(SubscriptionState.NO_SUBSCRIPTION);
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(@NonNull C0257h c0257h, @Nullable List<Purchase> list) {
        int i = c0257h.f1844a;
        getLogManager().logDebug(TAG, "🛒 Mise à jour des achats - Code: " + i);
        if (i == 0) {
            if (list != null) {
                getLogManager().logDebug(TAG, "✅ " + list.size() + " achat(s) mis à jour");
                updateSubscriptionState(list);
                return;
            }
            return;
        }
        if (i == 1) {
            getLogManager().logDebug(TAG, "👤 Achat annulé par l'utilisateur");
            logPurchaseCancelled();
            return;
        }
        getLogManager().logError(TAG, "❌ Erreur lors de la mise à jour des achats: " + c0257h.b);
        logPurchaseFailed(i, c0257h.b);
    }

    public void refreshSubscriptionStatus() {
        getLogManager().logDebug(TAG, "🔄 Actualisation forcée de l'état d'abonnement");
        if (this.billingClient.c()) {
            getLogManager().logDebug(TAG, "🔄 Client prêt - Rechargement des achats");
            checkExistingPurchases();
        } else {
            getLogManager().logDebug(TAG, "🔄 Client non prêt - Reconnexion en cours");
            connectToBillingService();
        }
    }

    public LiveData<n> getProductDetails() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.allProductDetails.observeForever(new fr.sd.taada.activities.l(mutableLiveData, 2));
        return mutableLiveData;
    }
}
