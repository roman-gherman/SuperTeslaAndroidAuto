package fr.sd.taada.helpers.service;

import R0.a;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import fr.sd.taada.R;
import fr.sd.taada.activities.SubscriptionActivity;
import fr.sd.taada.billing.SubscriptionViewModel;
import fr.sd.taada.helpers.DemoModeManager;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.permissions.PermissionFlowManager;
import fr.sd.taada.viewmodels.HomeViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceStartHandler {
    private static final String TAG = "ServiceStartHandler";
    private final Activity activity;
    private final DemoModeManager demoModeManager;
    private final LogManager logManager;
    private PermissionFlowManager permissionFlowManager;
    private final SubscriptionViewModel subscriptionViewModel;
    private final HomeViewModel viewModel;

    public ServiceStartHandler(@NonNull Activity activity, @NonNull LogManager logManager, @NonNull HomeViewModel homeViewModel, @NonNull SubscriptionViewModel subscriptionViewModel, @NonNull DemoModeManager demoModeManager) {
        this.activity = activity;
        this.logManager = logManager;
        this.viewModel = homeViewModel;
        this.subscriptionViewModel = subscriptionViewModel;
        this.demoModeManager = demoModeManager;
    }

    private void handleServiceStart() {
        Boolean value = this.subscriptionViewModel.getHasActiveSubscription().getValue();
        boolean z6 = this.demoModeManager.getRemainingDemoTime() > 0;
        this.logManager.logDebug(TAG, "🚀 Start button clicked - Subscription: " + value + ", Demo time remaining: " + this.demoModeManager.getRemainingDemoTime() + "ms");
        if (!Boolean.TRUE.equals(value) && !z6) {
            redirectToSubscription();
            return;
        }
        if (this.viewModel.areAllPermissionsGranted()) {
            startServiceAfterPermissions();
            return;
        }
        PermissionFlowManager permissionFlowManager = this.permissionFlowManager;
        if (permissionFlowManager != null) {
            permissionFlowManager.startPermissionFlow(new a(this, 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleServiceStart$0(boolean z6) {
        if (z6) {
            startServiceAfterPermissions();
        }
    }

    private void redirectToSubscription() {
        Toast.makeText(this.activity, R.string.subscription_required_to_start, 0).show();
        this.activity.startActivity(new Intent(this.activity, (Class<?>) SubscriptionActivity.class));
    }

    public void handleStartStopButtonClick() {
        if (this.viewModel.isServiceRunning()) {
            this.viewModel.stopService(this.activity);
        } else {
            handleServiceStart();
        }
    }

    public void setPermissionFlowManager(@NonNull PermissionFlowManager permissionFlowManager) {
        this.permissionFlowManager = permissionFlowManager;
    }

    public void startServiceAfterPermissions() {
        this.viewModel.startService(this.activity);
    }
}
