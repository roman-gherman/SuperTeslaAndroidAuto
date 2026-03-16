package fr.sd.taada.helpers.demo;

import android.content.Context;
import android.view.LifecycleOwner;
import android.view.Observer;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.work.PeriodicWorkRequest;
import com.google.android.material.card.MaterialCardView;
import fr.sd.taada.R;
import fr.sd.taada.helpers.DemoModeManager;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.demo.DemoModeUiHandler;

/* JADX INFO: loaded from: classes2.dex */
public class DemoModeUiHandler {
    private static final String TAG = "DemoModeUiHandler";
    private final Context context;
    private MaterialCardView demoModeCard;
    private TextView demoModeInfoText;
    private final DemoModeManager demoModeManager;
    private TextView demoTimeRemainingText;
    private final LogManager logManager;
    private Button rearmDemoButton;
    private final ServiceStateProvider serviceStateProvider;

    public interface ServiceStateProvider {
        Boolean isServiceRunning();
    }

    public DemoModeUiHandler(@NonNull Context context, @NonNull LogManager logManager, @NonNull DemoModeManager demoModeManager, @NonNull ServiceStateProvider serviceStateProvider) {
        this.context = context;
        this.logManager = logManager;
        this.demoModeManager = demoModeManager;
        this.serviceStateProvider = serviceStateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observe$0(Boolean bool) {
        updateRearmButtonState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observe$1(Long l6) {
        updateRearmButtonState();
    }

    private void setRearmButtonDisabled(String str) {
        this.rearmDemoButton.setEnabled(false);
        this.rearmDemoButton.setText(str);
    }

    private void setRearmButtonEnabled(String str) {
        this.rearmDemoButton.setEnabled(true);
        this.rearmDemoButton.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDemoModeActiveState(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.demoModeInfoText.setText(this.context.getString(R.string.demo_mode_active_description));
            } else {
                this.demoModeInfoText.setText(this.context.getString(R.string.demo_mode_default_description));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDemoModeAvailability(Boolean bool) {
        if (bool != null) {
            this.demoModeCard.setVisibility(bool.booleanValue() ? 0 : 8);
            this.logManager.logDebug(TAG, "Mode démo disponible: " + bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDemoTimeRemaining(Long l6) {
        if (l6 != null) {
            this.demoTimeRemainingText.setText(DemoModeManager.formatTime(l6.longValue()));
            this.demoTimeRemainingText.setTextColor(this.context.getResources().getColor(l6.longValue() <= 60000 ? R.color.error_color : l6.longValue() <= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS ? R.color.warning_color : R.color.tesla_orange_accent));
            updateRearmButtonState();
        }
    }

    private void updateRearmButtonState() {
        Boolean boolIsServiceRunning = this.serviceStateProvider.isServiceRunning();
        Long value = this.demoModeManager.getRearmTimeRemaining().getValue();
        boolean zEquals = Boolean.TRUE.equals(boolIsServiceRunning);
        long remainingDemoTime = this.demoModeManager.getRemainingDemoTime();
        boolean zCanRearmNow = this.demoModeManager.canRearmNow();
        this.logManager.logDebug(TAG, "🎮 Mise à jour bouton réarmement - Services: " + zEquals + ", CanRearm: " + zCanRearmNow + ", DemoTime: " + remainingDemoTime + ", RearmTime: " + value);
        if (zEquals) {
            setRearmButtonDisabled(this.context.getString(R.string.demo_mode_rearm_running));
            return;
        }
        if (remainingDemoTime > 0) {
            setRearmButtonDisabled(this.context.getString(R.string.demo_mode_rearm_when_zero));
            return;
        }
        if (value == null || value.longValue() <= 0) {
            setRearmButtonEnabled(this.context.getString(R.string.demo_mode_rearm_button));
            this.logManager.logDebug(TAG, "🎮 Bouton de réarmement ACTIVÉ");
        } else {
            setRearmButtonDisabled(this.context.getString(R.string.demo_mode_rearm_in, DemoModeManager.formatTime(value.longValue())));
        }
    }

    public void bindViews(@NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button) {
        this.demoModeCard = materialCardView;
        this.demoTimeRemainingText = textView;
        this.demoModeInfoText = textView2;
        this.rearmDemoButton = button;
    }

    public void observe(@NonNull LifecycleOwner lifecycleOwner) {
        final int i = 0;
        this.demoModeManager.getIsDemoModeAvailable().observe(lifecycleOwner, new Observer(this) { // from class: c1.a
            public final /* synthetic */ DemoModeUiHandler b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i) {
                    case 0:
                        this.b.updateDemoModeAvailability((Boolean) obj);
                        break;
                    case 1:
                        this.b.updateDemoTimeRemaining((Long) obj);
                        break;
                    case 2:
                        this.b.updateDemoModeActiveState((Boolean) obj);
                        break;
                    case 3:
                        this.b.lambda$observe$0((Boolean) obj);
                        break;
                    default:
                        this.b.lambda$observe$1((Long) obj);
                        break;
                }
            }
        });
        final int i3 = 1;
        this.demoModeManager.getDemoTimeRemaining().observe(lifecycleOwner, new Observer(this) { // from class: c1.a
            public final /* synthetic */ DemoModeUiHandler b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i3) {
                    case 0:
                        this.b.updateDemoModeAvailability((Boolean) obj);
                        break;
                    case 1:
                        this.b.updateDemoTimeRemaining((Long) obj);
                        break;
                    case 2:
                        this.b.updateDemoModeActiveState((Boolean) obj);
                        break;
                    case 3:
                        this.b.lambda$observe$0((Boolean) obj);
                        break;
                    default:
                        this.b.lambda$observe$1((Long) obj);
                        break;
                }
            }
        });
        final int i4 = 2;
        this.demoModeManager.getIsDemoModeActive().observe(lifecycleOwner, new Observer(this) { // from class: c1.a
            public final /* synthetic */ DemoModeUiHandler b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i4) {
                    case 0:
                        this.b.updateDemoModeAvailability((Boolean) obj);
                        break;
                    case 1:
                        this.b.updateDemoTimeRemaining((Long) obj);
                        break;
                    case 2:
                        this.b.updateDemoModeActiveState((Boolean) obj);
                        break;
                    case 3:
                        this.b.lambda$observe$0((Boolean) obj);
                        break;
                    default:
                        this.b.lambda$observe$1((Long) obj);
                        break;
                }
            }
        });
        final int i5 = 3;
        this.demoModeManager.getCanRearmDemo().observe(lifecycleOwner, new Observer(this) { // from class: c1.a
            public final /* synthetic */ DemoModeUiHandler b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i5) {
                    case 0:
                        this.b.updateDemoModeAvailability((Boolean) obj);
                        break;
                    case 1:
                        this.b.updateDemoTimeRemaining((Long) obj);
                        break;
                    case 2:
                        this.b.updateDemoModeActiveState((Boolean) obj);
                        break;
                    case 3:
                        this.b.lambda$observe$0((Boolean) obj);
                        break;
                    default:
                        this.b.lambda$observe$1((Long) obj);
                        break;
                }
            }
        });
        final int i6 = 4;
        this.demoModeManager.getRearmTimeRemaining().observe(lifecycleOwner, new Observer(this) { // from class: c1.a
            public final /* synthetic */ DemoModeUiHandler b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i6) {
                    case 0:
                        this.b.updateDemoModeAvailability((Boolean) obj);
                        break;
                    case 1:
                        this.b.updateDemoTimeRemaining((Long) obj);
                        break;
                    case 2:
                        this.b.updateDemoModeActiveState((Boolean) obj);
                        break;
                    case 3:
                        this.b.lambda$observe$0((Boolean) obj);
                        break;
                    default:
                        this.b.lambda$observe$1((Long) obj);
                        break;
                }
            }
        });
    }

    public void onServiceStateChanged() {
        updateRearmButtonState();
    }
}
