package fr.sd.taada.helpers.subscription;

import android.content.Context;
import android.view.LifecycleOwner;
import android.view.Observer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.card.MaterialCardView;
import fr.sd.taada.R;
import fr.sd.taada.billing.SubscriptionState;
import fr.sd.taada.billing.SubscriptionViewModel;
import fr.sd.taada.helpers.DemoModeManager;
import fr.sd.taada.helpers.LogManager;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionUiHandler {
    private static final String TAG = "SubscriptionUiHandler";
    private MaterialCardView bluetoothCard;
    private final Context context;
    private final DemoModeManager demoModeManager;
    private final LogManager logManager;
    private MaterialCardView startStopButton;
    private Button subscriptionButton;
    private MaterialCardView subscriptionCard;
    private ImageView subscriptionIcon;
    private TextView subscriptionStatusText;
    private final SubscriptionViewModel subscriptionViewModel;

    /* JADX INFO: renamed from: fr.sd.taada.helpers.subscription.SubscriptionUiHandler$1, reason: invalid class name */
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
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.NO_SUBSCRIPTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.EXPIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.CANCELLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.SUSPENDED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$fr$sd$taada$billing$SubscriptionState[SubscriptionState.EXPIRED_IN_GRACE_PERIOD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public SubscriptionUiHandler(@NonNull Context context, @NonNull LogManager logManager, @NonNull SubscriptionViewModel subscriptionViewModel, @NonNull DemoModeManager demoModeManager) {
        this.context = context;
        this.logManager = logManager;
        this.subscriptionViewModel = subscriptionViewModel;
        this.demoModeManager = demoModeManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observe$0(String str) {
        if (str != null) {
            this.subscriptionStatusText.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observe$1(Boolean bool) {
        if (bool != null) {
            updateMainFunctionsAccess(bool.booleanValue());
        }
    }

    private void updateMainFunctionsAccess(boolean z6) {
        this.startStopButton.setAlpha(1.0f);
        this.bluetoothCard.setAlpha(1.0f);
        this.logManager.logDebug(TAG, "État d'abonnement: ".concat(z6 ? "Accès autorisé" : "Abonnement requis"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubscriptionUI(SubscriptionState subscriptionState) {
        if (subscriptionState == null) {
            return;
        }
        this.demoModeManager.checkDemoModeAvailability();
        switch (AnonymousClass1.$SwitchMap$fr$sd$taada$billing$SubscriptionState[subscriptionState.ordinal()]) {
            case 1:
                this.subscriptionIcon.setImageResource(R.drawable.ic_sync_24);
                this.subscriptionButton.setText(R.string.checking_status);
                this.subscriptionButton.setEnabled(false);
                break;
            case 2:
                this.subscriptionIcon.setImageResource(R.drawable.ic_schedule_24);
                this.subscriptionButton.setText(R.string.manage_trial);
                this.subscriptionButton.setEnabled(true);
                break;
            case 3:
                this.subscriptionIcon.setImageResource(R.drawable.ic_check_circle_24);
                this.subscriptionButton.setText(R.string.manage_subscription);
                this.subscriptionButton.setEnabled(true);
                break;
            case 4:
                this.subscriptionIcon.setImageResource(R.drawable.ic_star_24);
                this.subscriptionButton.setText(R.string.lifetime_access);
                this.subscriptionButton.setEnabled(true);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                this.subscriptionIcon.setImageResource(R.drawable.ic_error_24);
                this.subscriptionButton.setText(R.string.subscribe);
                this.subscriptionButton.setEnabled(true);
                break;
        }
    }

    public void bindViews(@NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull Button button, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull MaterialCardView materialCardView3) {
        this.subscriptionCard = materialCardView;
        this.subscriptionStatusText = textView;
        this.subscriptionButton = button;
        this.subscriptionIcon = imageView;
        this.startStopButton = materialCardView2;
        this.bluetoothCard = materialCardView3;
    }

    public void observe(@NonNull LifecycleOwner lifecycleOwner) {
        final int i = 0;
        this.subscriptionViewModel.getSubscriptionStatusText().observe(lifecycleOwner, new Observer(this) { // from class: fr.sd.taada.helpers.subscription.a
            public final /* synthetic */ SubscriptionUiHandler b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i) {
                    case 0:
                        this.b.lambda$observe$0((String) obj);
                        break;
                    case 1:
                        this.b.updateSubscriptionUI((SubscriptionState) obj);
                        break;
                    default:
                        this.b.lambda$observe$1((Boolean) obj);
                        break;
                }
            }
        });
        final int i3 = 1;
        this.subscriptionViewModel.getSubscriptionState().observe(lifecycleOwner, new Observer(this) { // from class: fr.sd.taada.helpers.subscription.a
            public final /* synthetic */ SubscriptionUiHandler b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i3) {
                    case 0:
                        this.b.lambda$observe$0((String) obj);
                        break;
                    case 1:
                        this.b.updateSubscriptionUI((SubscriptionState) obj);
                        break;
                    default:
                        this.b.lambda$observe$1((Boolean) obj);
                        break;
                }
            }
        });
        final int i4 = 2;
        this.subscriptionViewModel.getHasActiveSubscription().observe(lifecycleOwner, new Observer(this) { // from class: fr.sd.taada.helpers.subscription.a
            public final /* synthetic */ SubscriptionUiHandler b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i4) {
                    case 0:
                        this.b.lambda$observe$0((String) obj);
                        break;
                    case 1:
                        this.b.updateSubscriptionUI((SubscriptionState) obj);
                        break;
                    default:
                        this.b.lambda$observe$1((Boolean) obj);
                        break;
                }
            }
        });
    }
}
