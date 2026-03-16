package fr.sd.taada.billing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.AndroidViewModel;
import android.view.LiveData;
import android.view.MediatorLiveData;
import android.view.MutableLiveData;
import android.view.Observer;
import androidx.annotation.NonNull;
import com.android.billingclient.api.m;
import com.android.billingclient.api.n;
import fr.sd.taada.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionViewModel extends AndroidViewModel {
    private static final String TAG = "SubscriptionViewModel";
    private final BillingManager billingManager;
    private Context currentContext;
    private final MediatorLiveData<List<n>> filteredProductDetails;
    private final MediatorLiveData<Boolean> hasActiveSubscription;
    private final MutableLiveData<Boolean> showSubscriptionDialog;
    private final MediatorLiveData<String> subscriptionStatusText;
    private final MediatorLiveData<String> trialTimeRemaining;

    /* JADX INFO: renamed from: fr.sd.taada.billing.SubscriptionViewModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$fr$sd$taada$billing$SubscriptionState;

        static {
            int[] iArr = new int[SubscriptionState.values().length];
            $SwitchMap$fr$sd$taada$billing$SubscriptionState = iArr;
            try {
                iArr[SubscriptionState.CHECKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.FREE_TRIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.SUBSCRIBED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.LIFETIME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.EXPIRED_IN_GRACE_PERIOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.SUSPENDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.CANCELLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.EXPIRED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.NO_SUBSCRIPTION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public SubscriptionViewModel(@NonNull Application application) {
        super(application);
        this.hasActiveSubscription = new MediatorLiveData<>();
        this.subscriptionStatusText = new MediatorLiveData<>();
        this.trialTimeRemaining = new MediatorLiveData<>();
        this.showSubscriptionDialog = new MutableLiveData<>(Boolean.FALSE);
        this.filteredProductDetails = new MediatorLiveData<>();
        this.currentContext = application;
        this.billingManager = BillingManager.getInstance(application);
        setupDataObservers();
    }

    private String formatRemainingTrialTime() {
        return formatRemainingTrialTime(getApplication());
    }

    private String generateStatusText(SubscriptionState subscriptionState) {
        return generateStatusText(subscriptionState, getApplication());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupDataObservers$0() {
        this.billingManager.refreshSubscriptionStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupDataObservers$1(List list) {
        if (list == null) {
            this.filteredProductDetails.setValue(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (nVar != null) {
                arrayList.add(nVar);
            } else {
                i++;
            }
        }
        this.filteredProductDetails.setValue(arrayList);
        arrayList.size();
        list.size();
        if (i > 0) {
            Log.w(TAG, "⚠️ " + i + " ProductDetails null détectés - re-requête programmée dans 1.5s");
            new Handler(Looper.getMainLooper()).postDelayed(new androidx.constraintlayout.helper.widget.a(this, 14), 1500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupDataObservers$2(SubscriptionState subscriptionState) {
        Objects.toString(subscriptionState);
        if (subscriptionState == null) {
            Log.w(TAG, "⚠️ État d'abonnement null reçu");
            return;
        }
        this.hasActiveSubscription.setValue(Boolean.valueOf(subscriptionState.allowsAppAccess()));
        subscriptionState.toString();
        subscriptionState.allowsAppAccess();
        subscriptionState.requiresUserAction();
        int i = AnonymousClass1.$SwitchMap$fr$sd$taada$billing$SubscriptionState[subscriptionState.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return;
        }
        subscriptionState.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupDataObservers$3(SubscriptionState subscriptionState) {
        Objects.toString(subscriptionState);
        if (subscriptionState != null) {
            this.subscriptionStatusText.setValue(generateStatusText(subscriptionState, this.currentContext));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupDataObservers$4(SubscriptionState subscriptionState) {
        Objects.toString(subscriptionState);
        if (subscriptionState != SubscriptionState.FREE_TRIAL) {
            this.trialTimeRemaining.setValue(null);
        } else {
            this.trialTimeRemaining.setValue(formatRemainingTrialTime(this.currentContext));
        }
    }

    private void setupDataObservers() {
        final int i = 0;
        this.filteredProductDetails.addSource(this.billingManager.getAllProductDetails(), new Observer(this) { // from class: fr.sd.taada.billing.c
            public final /* synthetic */ SubscriptionViewModel b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i) {
                    case 0:
                        this.b.lambda$setupDataObservers$1((List) obj);
                        break;
                    case 1:
                        this.b.lambda$setupDataObservers$2((SubscriptionState) obj);
                        break;
                    case 2:
                        this.b.lambda$setupDataObservers$3((SubscriptionState) obj);
                        break;
                    default:
                        this.b.lambda$setupDataObservers$4((SubscriptionState) obj);
                        break;
                }
            }
        });
        final int i3 = 1;
        this.hasActiveSubscription.addSource(this.billingManager.getSubscriptionState(), new Observer(this) { // from class: fr.sd.taada.billing.c
            public final /* synthetic */ SubscriptionViewModel b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i3) {
                    case 0:
                        this.b.lambda$setupDataObservers$1((List) obj);
                        break;
                    case 1:
                        this.b.lambda$setupDataObservers$2((SubscriptionState) obj);
                        break;
                    case 2:
                        this.b.lambda$setupDataObservers$3((SubscriptionState) obj);
                        break;
                    default:
                        this.b.lambda$setupDataObservers$4((SubscriptionState) obj);
                        break;
                }
            }
        });
        final int i4 = 2;
        this.subscriptionStatusText.addSource(this.billingManager.getSubscriptionState(), new Observer(this) { // from class: fr.sd.taada.billing.c
            public final /* synthetic */ SubscriptionViewModel b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i4) {
                    case 0:
                        this.b.lambda$setupDataObservers$1((List) obj);
                        break;
                    case 1:
                        this.b.lambda$setupDataObservers$2((SubscriptionState) obj);
                        break;
                    case 2:
                        this.b.lambda$setupDataObservers$3((SubscriptionState) obj);
                        break;
                    default:
                        this.b.lambda$setupDataObservers$4((SubscriptionState) obj);
                        break;
                }
            }
        });
        final int i5 = 3;
        this.trialTimeRemaining.addSource(this.billingManager.getSubscriptionState(), new Observer(this) { // from class: fr.sd.taada.billing.c
            public final /* synthetic */ SubscriptionViewModel b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i5) {
                    case 0:
                        this.b.lambda$setupDataObservers$1((List) obj);
                        break;
                    case 1:
                        this.b.lambda$setupDataObservers$2((SubscriptionState) obj);
                        break;
                    case 2:
                        this.b.lambda$setupDataObservers$3((SubscriptionState) obj);
                        break;
                    default:
                        this.b.lambda$setupDataObservers$4((SubscriptionState) obj);
                        break;
                }
            }
        });
    }

    public boolean canAccessApp() {
        SubscriptionState value = this.billingManager.getSubscriptionState().getValue();
        return value != null && value.allowsAppAccess();
    }

    public void dismissSubscriptionDialog() {
        this.showSubscriptionDialog.setValue(Boolean.FALSE);
    }

    public LiveData<List<n>> getAllProductDetails() {
        return this.filteredProductDetails;
    }

    public m getAnnualOfferDetails() {
        return this.billingManager.getAnnualOfferDetails();
    }

    public n getAnnualSubscriptionDetails() {
        return getProductDetails(BillingManager.getMonthlySubscriptionId());
    }

    public LiveData<Boolean> getBillingClientReady() {
        return this.billingManager.getBillingClientReady();
    }

    public BillingManager getBillingManager() {
        return this.billingManager;
    }

    public LiveData<Boolean> getHasActiveSubscription() {
        return this.hasActiveSubscription;
    }

    public n getLifetimeProductDetails() {
        return getProductDetails(BillingManager.getLifetimeProductId());
    }

    public m getMonthlyOfferDetails() {
        return this.billingManager.getMonthlyOfferDetails();
    }

    public n getMonthlySubscriptionDetails() {
        return getProductDetails(BillingManager.getMonthlySubscriptionId());
    }

    public LiveData<Boolean> getNeedsSubscriptionCancellation() {
        return this.billingManager.getNeedsSubscriptionCancellation();
    }

    public n getProductDetails(String str) {
        return this.billingManager.getProductDetails(str);
    }

    public LiveData<Boolean> getShowSubscriptionDialog() {
        return this.showSubscriptionDialog;
    }

    public LiveData<SubscriptionState> getSubscriptionState() {
        return this.billingManager.getSubscriptionState();
    }

    public LiveData<String> getSubscriptionStatusText() {
        return this.subscriptionStatusText;
    }

    public LiveData<String> getTrialTimeRemaining() {
        return this.trialTimeRemaining;
    }

    public boolean hasActivePaymentSubscription() {
        return this.billingManager.getSubscriptionState().getValue() == SubscriptionState.SUBSCRIBED;
    }

    public boolean hasLifetimeAccess() {
        return this.billingManager.getSubscriptionState().getValue() == SubscriptionState.LIFETIME;
    }

    public boolean isInFreeTrial() {
        return this.billingManager.getSubscriptionState().getValue() == SubscriptionState.FREE_TRIAL;
    }

    public boolean isProductAvailable(String str) {
        return this.billingManager.isProductAvailable(str);
    }

    public boolean isTrialAvailable() {
        return this.billingManager.getSubscriptionState().getValue() == SubscriptionState.NO_SUBSCRIPTION;
    }

    public void launchAnnualSubscription(Activity activity) {
        launchPurchase(activity, BillingManager.getAnnualSubscriptionId());
    }

    public void launchLifetimePurchase(Activity activity) {
        launchPurchase(activity, BillingManager.getLifetimeProductId());
    }

    public void launchMonthlySubscription(Activity activity) {
        launchPurchase(activity, BillingManager.getMonthlySubscriptionId());
    }

    public void launchPurchase(Activity activity, String str) {
        this.billingManager.launchPurchaseFlow(activity, str);
    }

    public void markCancellationNotificationSeen() {
        this.billingManager.markCancellationNotificationSeen();
    }

    @Override // android.view.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public void refreshStatusTexts() {
        refreshStatusTexts(getApplication());
    }

    public void refreshSubscriptionStatus() {
        this.billingManager.refreshSubscriptionStatus();
    }

    public void requestShowSubscriptionDialog() {
        this.showSubscriptionDialog.setValue(Boolean.TRUE);
    }

    public boolean shouldShowSubscriptionScreen() {
        SubscriptionState value = this.billingManager.getSubscriptionState().getValue();
        return value != null && value.requiresUserAction();
    }

    private String formatRemainingTrialTime(Context context) {
        return context.getString(R.string.trial_managed_by_google);
    }

    private String generateStatusText(SubscriptionState subscriptionState, Context context) {
        if (subscriptionState == null) {
            return context.getString(R.string.subscription_status_unknown);
        }
        switch (AnonymousClass1.$SwitchMap$fr$sd$taada$billing$SubscriptionState[subscriptionState.ordinal()]) {
        }
        return context.getString(R.string.subscription_status_unknown);
    }

    public LiveData<n> getProductDetails() {
        return this.billingManager.getProductDetails();
    }

    public void refreshStatusTexts(Context context) {
        context.getClass();
        this.currentContext = context;
        SubscriptionState value = this.billingManager.getSubscriptionState().getValue();
        if (value != null) {
            this.subscriptionStatusText.setValue(generateStatusText(value, context));
            if (value != SubscriptionState.FREE_TRIAL) {
                this.trialTimeRemaining.setValue(null);
            } else {
                this.trialTimeRemaining.setValue(formatRemainingTrialTime(context));
            }
        }
    }
}
