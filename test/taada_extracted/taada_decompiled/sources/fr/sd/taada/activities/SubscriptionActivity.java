package fr.sd.taada.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.OnBackPressedCallback;
import android.view.View;
import android.view.ViewModelProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.EnvironmentCompat;
import com.android.billingclient.api.C0260k;
import com.android.billingclient.api.l;
import com.android.billingclient.api.m;
import com.android.billingclient.api.n;
import com.google.android.material.card.MaterialCardView;
import fr.sd.taada.R;
import fr.sd.taada.analytics.PaywallAnalyticsManager;
import fr.sd.taada.billing.BillingManager;
import fr.sd.taada.billing.SubscriptionState;
import fr.sd.taada.billing.SubscriptionViewModel;
import fr.sd.taada.config.PaywallConfig;
import fr.sd.taada.config.PaywallConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionActivity extends BaseLocalizedActivity {
    private static final String TAG = "SubscriptionActivity";
    private PaywallConfig activeConfig;
    private PaywallAnalyticsManager analyticsManager;
    private TextView annualDescriptionText;
    private TextView annualPriceText;
    private TextView annualSavingsText;
    private TextView annualStrikethroughText;
    private MaterialCardView cardAnnual;
    private MaterialCardView cardLifetime;
    private MaterialCardView cardMonthly;
    private PaywallConfigManager configManager;
    private Button ctaButton;
    private LinearLayout featureRow1;
    private LinearLayout featureRow2;
    private LinearLayout featureRow3;
    private LinearLayout featureRow4;
    private View iconAnnual;
    private View iconLifetime;
    private View iconMonthly;
    private TextView lifetimeDescriptionText;
    private TextView lifetimeDiscountText;
    private TextView lifetimePriceText;
    private TextView lifetimeStrikethroughText;
    private View loadingIndicator;
    private TextView monthlyDescriptionText;
    private TextView monthlyPriceText;
    private LinearLayout purchaseOptionsContainer;
    private LinearLayout socialProofContainer;
    private SubscriptionViewModel subscriptionViewModel;
    private TextView titleText;
    private String selectedProductId = null;
    private boolean pricesLoaded = false;
    private boolean purchaseInitiatedThisSession = false;
    private final Map<String, String> priceCache = new HashMap();

    /* JADX INFO: renamed from: fr.sd.taada.activities.SubscriptionActivity$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$fr$sd$taada$billing$SubscriptionState;

        static {
            int[] iArr = new int[SubscriptionState.values().length];
            $SwitchMap$fr$sd$taada$billing$SubscriptionState = iArr;
            try {
                iArr[SubscriptionState.SUBSCRIBED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.LIFETIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.FREE_TRIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.CHECKING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void applyConfiguration() {
        TextView textView = this.titleText;
        if (textView != null) {
            textView.setText(safeGet(this.activeConfig.getHeaderTitle(), R.string.choose_taada_premium_plan));
        }
        Button button = this.ctaButton;
        if (button != null) {
            button.setText(getString(R.string.buy_lifetime));
        }
    }

    private void closePaywallSuccess() {
        returnToMainApp();
    }

    private String getCachedPrice(String str) {
        return this.priceCache.get(str);
    }

    private String getPlanType(String str) {
        return str == null ? EnvironmentCompat.MEDIA_UNKNOWN : BillingManager.getAnnualBasePlanId().equals(str) ? "annual" : BillingManager.getMonthlyBasePlanId().equals(str) ? "monthly" : BillingManager.getLifetimeProductId().equals(str) ? "lifetime" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    private Map<String, Object> getRevenueData(String str) {
        HashMap map = new HashMap();
        if (str != null) {
            try {
                if (BillingManager.getLifetimeProductId().equals(str)) {
                    n lifetimeProductDetails = this.subscriptionViewModel.getLifetimeProductDetails();
                    if (lifetimeProductDetails != null && lifetimeProductDetails.a() != null) {
                        C0260k c0260kA = lifetimeProductDetails.a();
                        long j6 = c0260kA.b;
                        String str2 = c0260kA.c;
                        map.put("revenue", Double.valueOf(j6 / 1000000.0d));
                        map.put("currency", str2);
                        return map;
                    }
                } else {
                    m annualOfferDetails = BillingManager.getAnnualBasePlanId().equals(str) ? this.subscriptionViewModel.getAnnualOfferDetails() : BillingManager.getMonthlyBasePlanId().equals(str) ? this.subscriptionViewModel.getMonthlyOfferDetails() : null;
                    if (annualOfferDetails != null) {
                        B.g gVar = annualOfferDetails.c;
                        if (!((ArrayList) gVar.b).isEmpty()) {
                            l lVar = (l) ((ArrayList) gVar.b).get(r9.size() - 1);
                            long j7 = lVar.b;
                            String str3 = lVar.c;
                            map.put("revenue", Double.valueOf(j7 / 1000000.0d));
                            map.put("currency", str3);
                            return map;
                        }
                    }
                }
            } catch (Exception e) {
                Log.w(TAG, "Failed to extract revenue metadata", e);
            }
        }
        return map;
    }

    private int getThemeColor(int i) {
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.data;
        }
        return -7829368;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCloseAction() {
        PaywallAnalyticsManager paywallAnalyticsManager = this.analyticsManager;
        String str = this.selectedProductId;
        paywallAnalyticsManager.logPaywallDismissed(str != null ? str : "none", str != null, this.purchaseInitiatedThisSession);
        if (this.subscriptionViewModel.canAccessApp()) {
            returnToMainApp();
        } else {
            returnToMainApp();
        }
    }

    private void handleSubscriptionState(SubscriptionState subscriptionState) {
        int i = AnonymousClass2.$SwitchMap$fr$sd$taada$billing$SubscriptionState[subscriptionState.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            if (this.purchaseInitiatedThisSession) {
                Map<String, Object> revenueData = getRevenueData(this.selectedProductId);
                Double d = (Double) revenueData.get("revenue");
                String str = (String) revenueData.get("currency");
                PaywallAnalyticsManager paywallAnalyticsManager = this.analyticsManager;
                String str2 = this.selectedProductId;
                paywallAnalyticsManager.logPurchaseComplete(str2, "unknown_order_id", getPlanType(str2), d, str, subscriptionState == SubscriptionState.FREE_TRIAL);
                this.purchaseInitiatedThisSession = false;
            }
            Toast.makeText(this, R.string.paywall_welcome_premium, 1).show();
            closePaywallSuccess();
        }
    }

    private void initializeViews() {
        this.titleText = (TextView) findViewById(R.id.titleText);
        this.loadingIndicator = findViewById(R.id.loadingIndicator);
        this.purchaseOptionsContainer = (LinearLayout) findViewById(R.id.purchaseOptionsContainer);
        this.socialProofContainer = (LinearLayout) findViewById(R.id.socialProofContainer);
        this.featureRow1 = (LinearLayout) findViewById(R.id.featureRow1);
        this.featureRow2 = (LinearLayout) findViewById(R.id.featureRow2);
        this.featureRow3 = (LinearLayout) findViewById(R.id.featureRow3);
        this.featureRow4 = (LinearLayout) findViewById(R.id.featureRow4);
        this.cardLifetime = (MaterialCardView) findViewById(R.id.lifetimeCard);
        this.cardAnnual = (MaterialCardView) findViewById(R.id.annualCard);
        this.cardMonthly = (MaterialCardView) findViewById(R.id.monthlyCard);
        this.iconLifetime = findViewById(R.id.lifetimeCheckIcon);
        this.iconAnnual = findViewById(R.id.annualCheckIcon);
        this.iconMonthly = findViewById(R.id.monthlyCheckIcon);
        this.lifetimePriceText = (TextView) findViewById(R.id.lifetimePriceText);
        this.annualPriceText = (TextView) findViewById(R.id.annualPriceText);
        this.monthlyPriceText = (TextView) findViewById(R.id.monthlyPriceText);
        this.lifetimeDescriptionText = (TextView) findViewById(R.id.lifetimeDescriptionText);
        this.annualDescriptionText = (TextView) findViewById(R.id.annualDescriptionText);
        this.monthlyDescriptionText = (TextView) findViewById(R.id.monthlyDescriptionText);
        this.annualStrikethroughText = (TextView) findViewById(R.id.annualStrikethroughText);
        this.annualSavingsText = (TextView) findViewById(R.id.annualSavingsText);
        this.lifetimeStrikethroughText = (TextView) findViewById(R.id.lifetimeStrikethroughText);
        this.lifetimeDiscountText = (TextView) findViewById(R.id.lifetimeDiscountText);
        runEntranceAnimations();
        TextView textView = this.annualStrikethroughText;
        if (textView != null) {
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        }
        TextView textView2 = this.lifetimeStrikethroughText;
        if (textView2 != null) {
            textView2.setPaintFlags(textView2.getPaintFlags() | 16);
        }
        this.ctaButton = (Button) findViewById(R.id.secondaryActionButton);
        View view = this.loadingIndicator;
        if (view != null) {
            view.setVisibility(0);
        }
        LinearLayout linearLayout = this.purchaseOptionsContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        selectProduct(BillingManager.getAnnualBasePlanId());
    }

    private void initiatePurchase() {
        String str = this.selectedProductId;
        if (str == null) {
            return;
        }
        this.purchaseInitiatedThisSession = true;
        this.analyticsManager.logPurchaseStart(str, getPlanType(str));
        if (BillingManager.getAnnualBasePlanId().equals(this.selectedProductId)) {
            this.subscriptionViewModel.launchAnnualSubscription(this);
        } else if (BillingManager.getMonthlyBasePlanId().equals(this.selectedProductId)) {
            this.subscriptionViewModel.launchMonthlySubscription(this);
        } else if (BillingManager.getLifetimeProductId().equals(this.selectedProductId)) {
            this.subscriptionViewModel.launchLifetimePurchase(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observeViewModel$4(SubscriptionState subscriptionState) {
        View view;
        Objects.toString(subscriptionState);
        if (subscriptionState == SubscriptionState.CHECKING) {
            View view2 = this.loadingIndicator;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        if (this.pricesLoaded && (view = this.loadingIndicator) != null) {
            view.setVisibility(8);
        }
        handleSubscriptionState(subscriptionState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupInteractions$0(View view) {
        selectProduct(BillingManager.getAnnualBasePlanId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupInteractions$1(View view) {
        selectProduct(BillingManager.getMonthlyBasePlanId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupInteractions$2(View view) {
        selectProduct(BillingManager.getLifetimeProductId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupInteractions$3(View view) {
        initiatePurchase();
    }

    private void observeViewModel() {
        this.subscriptionViewModel.getSubscriptionState().observe(this, new k(this, 0));
        this.subscriptionViewModel.getAllProductDetails().observe(this, new k(this, 1));
    }

    private void returnToMainApp() {
        Intent intent = new Intent(this, (Class<?>) HomeActivity.class);
        intent.setFlags(335544320);
        startActivity(intent);
        finish();
    }

    private void runEntranceAnimations() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        Animation animationLoadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        Animation animationLoadAnimation4 = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        Animation animationLoadAnimation5 = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        Animation animationLoadAnimation6 = AnimationUtils.loadAnimation(this, R.anim.pulse);
        animationLoadAnimation.setStartOffset(100L);
        animationLoadAnimation2.setStartOffset(200L);
        animationLoadAnimation3.setStartOffset(300L);
        animationLoadAnimation4.setStartOffset(400L);
        animationLoadAnimation5.setStartOffset(500L);
        LinearLayout linearLayout = this.socialProofContainer;
        if (linearLayout != null) {
            linearLayout.startAnimation(animationLoadAnimation);
        }
        LinearLayout linearLayout2 = this.featureRow1;
        if (linearLayout2 != null) {
            linearLayout2.startAnimation(animationLoadAnimation2);
        }
        LinearLayout linearLayout3 = this.featureRow2;
        if (linearLayout3 != null) {
            linearLayout3.startAnimation(animationLoadAnimation3);
        }
        LinearLayout linearLayout4 = this.featureRow3;
        if (linearLayout4 != null) {
            linearLayout4.startAnimation(animationLoadAnimation4);
        }
        LinearLayout linearLayout5 = this.featureRow4;
        if (linearLayout5 != null) {
            linearLayout5.startAnimation(animationLoadAnimation5);
        }
        animationLoadAnimation6.setStartOffset(1000L);
        TextView textView = (TextView) findViewById(R.id.annualBadgeText);
        TextView textView2 = (TextView) findViewById(R.id.lifetimeBadgeText);
        if (textView != null) {
            textView.startAnimation(animationLoadAnimation6);
        }
        if (textView2 != null) {
            textView2.startAnimation(animationLoadAnimation6);
        }
    }

    private String safeGet(String str, int i) {
        return (str == null || str.isEmpty()) ? getString(i) : str;
    }

    private void selectProduct(String str) {
        this.selectedProductId = str;
        boolean zEquals = BillingManager.getAnnualBasePlanId().equals(str);
        boolean zEquals2 = BillingManager.getMonthlyBasePlanId().equals(str);
        boolean zEquals3 = BillingManager.getLifetimeProductId().equals(str);
        updateCardSelection(this.cardAnnual, this.iconAnnual, zEquals);
        updateCardSelection(this.cardMonthly, this.iconMonthly, zEquals2);
        updateCardSelection(this.cardLifetime, this.iconLifetime, zEquals3);
        this.analyticsManager.logProductSelect(str);
        Button button = this.ctaButton;
        if (button != null) {
            if (zEquals) {
                button.setText(getString(R.string.paywall_cta_annual_trial));
                return;
            }
            if (zEquals3) {
                String cachedPrice = getCachedPrice(str);
                if (cachedPrice != null) {
                    this.ctaButton.setText(String.format(getString(R.string.paywall_cta_lifetime_price), cachedPrice));
                    return;
                } else {
                    this.ctaButton.setText(getString(R.string.buy_lifetime));
                    return;
                }
            }
            String cachedPrice2 = getCachedPrice(str);
            if (cachedPrice2 != null) {
                this.ctaButton.setText(String.format(getString(R.string.paywall_cta_monthly), cachedPrice2));
            } else {
                this.ctaButton.setText(getString(R.string.subscribe));
            }
        }
    }

    private void setupInteractions() {
        MaterialCardView materialCardView = this.cardAnnual;
        if (materialCardView != null) {
            final int i = 0;
            materialCardView.setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.activities.j
                public final /* synthetic */ SubscriptionActivity b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            this.b.lambda$setupInteractions$0(view);
                            break;
                        case 1:
                            this.b.lambda$setupInteractions$1(view);
                            break;
                        case 2:
                            this.b.lambda$setupInteractions$2(view);
                            break;
                        default:
                            this.b.lambda$setupInteractions$3(view);
                            break;
                    }
                }
            });
        }
        MaterialCardView materialCardView2 = this.cardMonthly;
        if (materialCardView2 != null) {
            final int i3 = 1;
            materialCardView2.setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.activities.j
                public final /* synthetic */ SubscriptionActivity b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i3) {
                        case 0:
                            this.b.lambda$setupInteractions$0(view);
                            break;
                        case 1:
                            this.b.lambda$setupInteractions$1(view);
                            break;
                        case 2:
                            this.b.lambda$setupInteractions$2(view);
                            break;
                        default:
                            this.b.lambda$setupInteractions$3(view);
                            break;
                    }
                }
            });
        }
        MaterialCardView materialCardView3 = this.cardLifetime;
        if (materialCardView3 != null) {
            final int i4 = 2;
            materialCardView3.setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.activities.j
                public final /* synthetic */ SubscriptionActivity b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            this.b.lambda$setupInteractions$0(view);
                            break;
                        case 1:
                            this.b.lambda$setupInteractions$1(view);
                            break;
                        case 2:
                            this.b.lambda$setupInteractions$2(view);
                            break;
                        default:
                            this.b.lambda$setupInteractions$3(view);
                            break;
                    }
                }
            });
        }
        Button button = this.ctaButton;
        if (button != null) {
            final int i5 = 3;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: fr.sd.taada.activities.j
                public final /* synthetic */ SubscriptionActivity b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i5) {
                        case 0:
                            this.b.lambda$setupInteractions$0(view);
                            break;
                        case 1:
                            this.b.lambda$setupInteractions$1(view);
                            break;
                        case 2:
                            this.b.lambda$setupInteractions$2(view);
                            break;
                        default:
                            this.b.lambda$setupInteractions$3(view);
                            break;
                    }
                }
            });
        }
    }

    private void updateCardSelection(MaterialCardView materialCardView, View view, boolean z6) {
        if (materialCardView == null) {
            return;
        }
        materialCardView.setChecked(z6);
        materialCardView.setStrokeWidth((int) getResources().getDimension(z6 ? R.dimen.card_stroke_selected : R.dimen.card_stroke_normal));
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            imageView.setVisibility(0);
            if (!z6) {
                imageView.setImageResource(R.drawable.ic_radio_button_unchecked_24);
                imageView.setColorFilter(getThemeColor(R.attr.colorOutline));
                return;
            }
            imageView.setImageResource(R.drawable.ic_check_circle_24);
            if (materialCardView == this.cardLifetime) {
                imageView.setColorFilter(Color.parseColor("#FFC107"));
            } else if (materialCardView == this.cardAnnual) {
                imageView.setColorFilter(getThemeColor(R.attr.colorPrimary));
            } else {
                imageView.setColorFilter(getThemeColor(R.attr.colorPrimary));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updatePrices(java.util.List<com.android.billingclient.api.n> r17) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.activities.SubscriptionActivity.updatePrices(java.util.List):void");
    }

    @Override // fr.sd.taada.activities.BaseLocalizedActivity, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AppCompatDelegate.setDefaultNightMode(2);
        super.onCreate(bundle);
        setContentView(R.layout.activity_subscription);
        this.subscriptionViewModel = (SubscriptionViewModel) new ViewModelProvider(this).get(SubscriptionViewModel.class);
        this.configManager = PaywallConfigManager.getInstance(this);
        this.analyticsManager = PaywallAnalyticsManager.getInstance(this);
        this.activeConfig = this.configManager.getConfig();
        initializeViews();
        applyConfiguration();
        setupInteractions();
        observeViewModel();
        this.analyticsManager.logPaywallView("activity_create");
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: fr.sd.taada.activities.SubscriptionActivity.1
            @Override // android.view.OnBackPressedCallback
            public void handleOnBackPressed() {
                SubscriptionActivity.this.handleCloseAction();
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.subscriptionViewModel.refreshSubscriptionStatus();
    }
}
