package fr.sd.taada.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.Observer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewModelProvider;
import android.view.result.ActivityResult;
import android.view.result.ActivityResultLauncher;
import android.view.result.contract.ActivityResultContracts;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.preference.PreferenceManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.card.MaterialCardView;
import fr.sd.taada.MainActivity;
import fr.sd.taada.R;
import fr.sd.taada.billing.SubscriptionViewModel;
import fr.sd.taada.helpers.DeltaHotspotManager;
import fr.sd.taada.helpers.DemoModeManager;
import fr.sd.taada.helpers.LocaleHelper;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.ReviewRequestManager;
import fr.sd.taada.helpers.bluetooth.BluetoothDeviceManager;
import fr.sd.taada.helpers.demo.DemoModeUiHandler;
import fr.sd.taada.helpers.dialogs.FeedbackDialogHelper;
import fr.sd.taada.helpers.permissions.PermissionFlowManager;
import fr.sd.taada.helpers.permissions.PermissionItem;
import fr.sd.taada.helpers.permissions.PermissionStatusManager;
import fr.sd.taada.helpers.resolution.ResolutionUiHandler;
import fr.sd.taada.helpers.service.ServiceRestartScheduler;
import fr.sd.taada.helpers.service.ServiceStartHandler;
import fr.sd.taada.helpers.subscription.SubscriptionUiHandler;
import fr.sd.taada.helpers.zoom.ZoomControlManager;
import fr.sd.taada.viewmodels.HomeViewModel;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class HomeActivity extends BaseLocalizedActivity {
    private static final long CLICK_TIMEOUT = 2000;
    private static final int DEVELOPER_MODE_CLICKS = 7;
    private static final String PREF_DEVELOPER_MODE = "developer_mode_enabled";
    private static final String PREF_STEERING_WHEEL_RIGHT = "rhd";
    public static final boolean SHOW_LOGS_BUTTON = false;
    private static final String TAG = "HomeActivity";
    private MaterialCardView bluetoothCard;
    private BluetoothDeviceManager bluetoothDeviceManager;
    private ImageButton bluetoothInfoButton;
    private BottomNavigationView bottomNavigationView;
    private TextView btStatusText;
    private NestedScrollView containerGuide;
    private NestedScrollView containerHome;
    private NestedScrollView containerInfo;
    private NestedScrollView containerSettings;
    private NestedScrollView containerSubscription;
    private String currentLanguage;
    private MaterialCardView demoModeCard;
    private TextView demoModeInfoText;
    private DemoModeManager demoModeManager;
    private DemoModeUiHandler demoModeUiHandler;
    private TextView demoTimeRemainingText;
    private ImageButton facebookButton;
    private ImageButton feedbackButton;
    private FeedbackDialogHelper feedbackDialogHelper;
    private ImageButton githubButton;
    private Button grantPermissionsButton;
    private Button guideBatteryButton;
    private Button guideWifiButton;
    private LogManager homeLogManager;
    private ImageButton linkedinButton;
    private ImageButton logsButton;
    private PermissionFlowManager permissionFlowManager;
    private ActivityResultLauncher<String[]> permissionRequestLauncher;
    private MaterialCardView permissionsCard;
    private LinearLayout permissionsDetailContainer;
    private ImageView permissionsExpandIcon;
    private TextView permissionsStatusText;
    private Button rearmDemoButton;
    private ImageView recommendedIndicator;
    private ResolutionUiHandler resolutionUiHandler;
    private ServiceStartHandler serviceStartHandler;
    private BroadcastReceiver serviceStateReceiver;
    private TextView serviceStatusText;
    private View settingsButton;
    private ActivityResultLauncher<Intent> settingsLauncher;
    private MaterialCardView startStopButton;
    private ImageView startStopIcon;
    private TextView startStopText;
    private MaterialButtonToggleGroup steeringWheelToggleGroup;
    private Button subscriptionButton;
    private MaterialCardView subscriptionCard;
    private ImageView subscriptionIcon;
    private TextView subscriptionStatusText;
    private SubscriptionUiHandler subscriptionUiHandler;
    private SubscriptionViewModel subscriptionViewModel;
    private Button unlockFullAccessButton;
    private TextView versionText;
    private HomeViewModel viewModel;
    private ActivityResultLauncher<Intent> vpnLauncher;
    private ImageButton youtubeButton;
    private MaterialCardView zoomCard;
    private ZoomControlManager zoomControlManager;
    private MaterialButton zoomDecreaseButton;
    private MaterialButton zoomIncreaseButton;
    private AppCompatSeekBar zoomSeekBar;
    private TextView zoomValueText;
    private int versionClickCount = 0;
    private long lastVersionClickTime = 0;
    private boolean isPermissionsExpanded = false;

    private void handleVersionClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastVersionClickTime > CLICK_TIMEOUT) {
            this.versionClickCount = 0;
        }
        int i = this.versionClickCount + 1;
        this.versionClickCount = i;
        this.lastVersionClickTime = jCurrentTimeMillis;
        if (i >= 7) {
            setDeveloperModeEnabled(!isDeveloperModeEnabled());
            this.versionClickCount = 0;
            Toast.makeText(this, isDeveloperModeEnabled() ? getString(R.string.developer_mode_enabled) : getString(R.string.developer_mode_disabled), 0).show();
            updateDeveloperModeUI();
            if (isDeveloperModeEnabled()) {
                ReviewRequestManager.getInstance(this).logCurrentStatus();
                return;
            }
            return;
        }
        int i3 = 7 - i;
        if (i3 <= 3) {
            Toast.makeText(this, i3 + " more clicks", 0).show();
        }
    }

    private void initializeLogManager() {
        try {
            LogManager logManager = LogManager.getInstance(this);
            this.homeLogManager = logManager;
            logManager.logInfo(TAG, "LogManager initialized");
        } catch (Exception e) {
            Log.e(TAG, "Error initializing LogManager", e);
            this.homeLogManager = LogManager.getInstance(this);
        }
    }

    private void initializeManagers() {
        ZoomControlManager zoomControlManager = new ZoomControlManager(this, this.homeLogManager, new ZoomControlManager.ZoomControlCallback() { // from class: fr.sd.taada.activities.HomeActivity.1
            @Override // fr.sd.taada.helpers.zoom.ZoomControlManager.ZoomControlCallback
            public boolean areAllPermissionsGranted() {
                return HomeActivity.this.viewModel.areAllPermissionsGranted();
            }

            @Override // fr.sd.taada.helpers.zoom.ZoomControlManager.ZoomControlCallback
            public boolean isServiceRunning() {
                return HomeActivity.this.viewModel.isServiceRunning();
            }

            @Override // fr.sd.taada.helpers.zoom.ZoomControlManager.ZoomControlCallback
            public void onServiceRestartRequired() {
                HomeActivity.this.performServiceRestart();
            }
        });
        this.zoomControlManager = zoomControlManager;
        zoomControlManager.bindViews(this.zoomValueText, this.zoomSeekBar, this.zoomDecreaseButton, this.zoomIncreaseButton, this.recommendedIndicator);
        this.zoomControlManager.initialize();
        ResolutionUiHandler resolutionUiHandler = new ResolutionUiHandler(this, this.homeLogManager, new ServiceRestartScheduler.RestartCallback() { // from class: fr.sd.taada.activities.HomeActivity.2
            @Override // fr.sd.taada.helpers.service.ServiceRestartScheduler.RestartCallback
            public boolean areAllPermissionsGranted() {
                return HomeActivity.this.viewModel.areAllPermissionsGranted();
            }

            @Override // fr.sd.taada.helpers.service.ServiceRestartScheduler.RestartCallback
            public boolean isServiceRunning() {
                return HomeActivity.this.viewModel.isServiceRunning();
            }

            @Override // fr.sd.taada.helpers.service.ServiceRestartScheduler.RestartCallback
            public void onServiceRestartRequired() {
                HomeActivity.this.performServiceRestart();
            }
        });
        this.resolutionUiHandler = resolutionUiHandler;
        resolutionUiHandler.bindViews((MaterialButtonToggleGroup) findViewById(R.id.resolutionToggleGroup), (TextView) findViewById(R.id.experimentalLabel), (ImageButton) findViewById(R.id.resolutionInfoButton));
        this.resolutionUiHandler.initialize();
        this.bluetoothDeviceManager = new BluetoothDeviceManager(this, this.homeLogManager, new BluetoothDeviceManager.BluetoothDeviceCallback() { // from class: fr.sd.taada.activities.HomeActivity.3
            @Override // fr.sd.taada.helpers.bluetooth.BluetoothDeviceManager.BluetoothDeviceCallback
            public List<String> getSelectedDeviceAddresses() {
                return HomeActivity.this.viewModel.getSelectedDeviceAddresses();
            }

            @Override // fr.sd.taada.helpers.bluetooth.BluetoothDeviceManager.BluetoothDeviceCallback
            public void onDevicesSelected(Set<String> set) {
                HomeActivity.this.viewModel.saveSelectedBluetoothDevices(HomeActivity.this, set);
            }
        });
        this.feedbackDialogHelper = new FeedbackDialogHelper(this, this.homeLogManager);
        this.serviceStartHandler = new ServiceStartHandler(this, this.homeLogManager, this.viewModel, this.subscriptionViewModel, this.demoModeManager);
        DemoModeUiHandler demoModeUiHandler = new DemoModeUiHandler(this, this.homeLogManager, this.demoModeManager, new d(this, 1));
        this.demoModeUiHandler = demoModeUiHandler;
        demoModeUiHandler.bindViews(this.demoModeCard, this.demoTimeRemainingText, this.demoModeInfoText, this.rearmDemoButton);
        SubscriptionUiHandler subscriptionUiHandler = new SubscriptionUiHandler(this, this.homeLogManager, this.subscriptionViewModel, this.demoModeManager);
        this.subscriptionUiHandler = subscriptionUiHandler;
        subscriptionUiHandler.bindViews(this.subscriptionCard, this.subscriptionStatusText, this.subscriptionButton, this.subscriptionIcon, this.startStopButton, this.bluetoothCard);
    }

    private void initializeViews() {
        this.startStopButton = (MaterialCardView) findViewById(R.id.startStopButton);
        this.startStopText = (TextView) findViewById(R.id.startStopText);
        this.startStopIcon = (ImageView) findViewById(R.id.startStopIcon);
        this.serviceStatusText = (TextView) findViewById(R.id.serviceStatusText);
        this.btStatusText = (TextView) findViewById(R.id.btStatusText);
        this.bluetoothCard = (MaterialCardView) findViewById(R.id.bluetoothCard);
        this.bluetoothInfoButton = (ImageButton) findViewById(R.id.bluetoothInfoButton);
        this.permissionsCard = (MaterialCardView) findViewById(R.id.permissionsCard);
        this.permissionsStatusText = (TextView) findViewById(R.id.permissionsStatusText);
        this.grantPermissionsButton = (Button) findViewById(R.id.grantPermissionsButton);
        this.permissionsExpandIcon = (ImageView) findViewById(R.id.permissionsExpandIcon);
        this.permissionsDetailContainer = (LinearLayout) findViewById(R.id.permissionsDetailContainer);
        this.settingsButton = findViewById(R.id.settingsButton);
        this.logsButton = (ImageButton) findViewById(R.id.logsButton);
        this.versionText = (TextView) findViewById(R.id.versionText);
        this.versionText = (TextView) findViewById(R.id.versionText);
        View viewFindViewById = findViewById(R.id.android16WarningContainer);
        TextView textView = (TextView) findViewById(R.id.android16LinkText);
        if (viewFindViewById != null && DeltaHotspotManager.isDeltaRequired()) {
            viewFindViewById.setVisibility(0);
            if (textView != null) {
                textView.setOnClickListener(new c(this, 12));
            }
        } else if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        this.guideWifiButton = (Button) findViewById(R.id.guideWifiButton);
        this.guideBatteryButton = (Button) findViewById(R.id.guideBatteryButton);
        this.subscriptionCard = (MaterialCardView) findViewById(R.id.subscriptionCard);
        this.subscriptionStatusText = (TextView) findViewById(R.id.subscriptionStatusText);
        this.subscriptionButton = (Button) findViewById(R.id.subscriptionButton);
        this.subscriptionIcon = (ImageView) findViewById(R.id.subscriptionIcon);
        this.feedbackButton = (ImageButton) findViewById(R.id.feedbackButton);
        this.demoModeCard = (MaterialCardView) findViewById(R.id.demoModeCard);
        this.demoTimeRemainingText = (TextView) findViewById(R.id.demoTimeRemainingText);
        this.demoModeInfoText = (TextView) findViewById(R.id.demoModeInfoText);
        this.rearmDemoButton = (Button) findViewById(R.id.rearmDemoButton);
        this.unlockFullAccessButton = (Button) findViewById(R.id.unlockFullAccessButton);
        this.zoomCard = (MaterialCardView) findViewById(R.id.zoomCard);
        this.zoomValueText = (TextView) findViewById(R.id.zoomValueText);
        this.zoomSeekBar = (AppCompatSeekBar) findViewById(R.id.zoomSeekBar);
        this.zoomDecreaseButton = (MaterialButton) findViewById(R.id.zoomDecreaseButton);
        this.zoomIncreaseButton = (MaterialButton) findViewById(R.id.zoomIncreaseButton);
        this.recommendedIndicator = (ImageView) findViewById(R.id.recommendedIndicator);
        this.githubButton = (ImageButton) findViewById(R.id.githubButton);
        this.facebookButton = (ImageButton) findViewById(R.id.facebookButton);
        this.linkedinButton = (ImageButton) findViewById(R.id.linkedinButton);
        this.youtubeButton = (ImageButton) findViewById(R.id.youtubeButton);
        setupVersionText();
        this.steeringWheelToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.steeringWheelToggleGroup);
        setupSteeringWheelControl();
        setupNavigation();
    }

    private boolean isDeveloperModeEnabled() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean(PREF_DEVELOPER_MODE, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$initializeManagers$3() {
        Boolean value = this.viewModel.getServiceRunning().getValue();
        return Boolean.valueOf(value != null && value.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeViews$0(View view) {
        openUrl("https://github.com/taada-official/TaaDa/blob/main/Android_16_hotspot_tuto.md");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populatePermissionsDropdown$27(PermissionItem permissionItem, View view) {
        PermissionFlowManager permissionFlowManager = this.permissionFlowManager;
        if (permissionFlowManager != null) {
            permissionFlowManager.showDialogForPermission(permissionItem.getType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerPermissionLauncher$23(Map map) {
        this.viewModel.checkAllPermissions(this);
        PermissionFlowManager permissionFlowManager = this.permissionFlowManager;
        if (permissionFlowManager != null) {
            permissionFlowManager.onRuntimePermissionsResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerSettingsLauncher$24(ActivityResult activityResult) {
        PermissionFlowManager permissionFlowManager = this.permissionFlowManager;
        if (permissionFlowManager != null) {
            permissionFlowManager.continueFlowAfterSettingsReturn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerVpnActivityResultLauncher$25(ActivityResult activityResult) {
        this.viewModel.checkAllPermissions(this);
        if (activityResult.getResultCode() != -1) {
            Toast.makeText(this, R.string.vpn_permission_denied, 1).show();
            return;
        }
        Toast.makeText(this, R.string.vpn_configuration_successful, 0).show();
        PermissionFlowManager permissionFlowManager = this.permissionFlowManager;
        if (permissionFlowManager != null) {
            permissionFlowManager.continueFlowAfterSettingsReturn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$10(View view) {
        startActivity(new Intent(this, (Class<?>) LogActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$11(View view) {
        openWifiHotspotSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$12(View view) {
        PermissionFlowManager permissionFlowManager = this.permissionFlowManager;
        if (permissionFlowManager != null) {
            permissionFlowManager.openBatterySettings();
            return;
        }
        try {
            try {
                startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
            } catch (Exception unused) {
                Toast.makeText(this, "Impossible d'ouvrir les paramètres", 0).show();
            }
        } catch (Exception unused2) {
            startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$13(View view) {
        startActivity(new Intent(this, (Class<?>) SubscriptionActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$14(View view) {
        handleVersionClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$15(View view) {
        openUrl("https://github.com/taada-official/TaaDa");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$16(View view) {
        openUrl("https://www.facebook.com/people/TaaDa-Android-Auto-for-Tesla/61577677031488/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$17(View view) {
        openUrl("https://www.linkedin.com/company/107762736/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$18(View view) {
        openUrl("https://www.youtube.com/@TaaDaAndroidAutoTesla");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$19(View view) {
        if (!this.demoModeManager.canRearmNow()) {
            Toast.makeText(this, "Réarmement non possible pour le moment", 0).show();
            return;
        }
        this.demoModeManager.rearmDemoMode();
        Toast.makeText(this, getString(R.string.demo_mode_rearmed_toast), 0).show();
        this.homeLogManager.logInfo(TAG, "🎮 Mode démo réarmé par l'utilisateur");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$20(View view) {
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_guide);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$21(View view) {
        startActivity(new Intent(this, (Class<?>) SubscriptionActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$22(View view) {
        this.feedbackDialogHelper.showFeedbackDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$4(View view) {
        this.serviceStartHandler.handleStartStopButtonClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$5(View view) {
        this.bluetoothDeviceManager.showBluetoothDeviceSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$6(View view) {
        this.bluetoothDeviceManager.showBluetoothInfoDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$7(View view) {
        togglePermissionsDropdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$8(View view) {
        PermissionFlowManager permissionFlowManager = this.permissionFlowManager;
        if (permissionFlowManager != null) {
            permissionFlowManager.startPermissionFlow(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupClickListeners$9(View view) {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setupNavigation$1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        NestedScrollView nestedScrollView = this.containerHome;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        NestedScrollView nestedScrollView2 = this.containerGuide;
        if (nestedScrollView2 != null) {
            nestedScrollView2.setVisibility(8);
        }
        NestedScrollView nestedScrollView3 = this.containerSettings;
        if (nestedScrollView3 != null) {
            nestedScrollView3.setVisibility(8);
        }
        NestedScrollView nestedScrollView4 = this.containerSubscription;
        if (nestedScrollView4 != null) {
            nestedScrollView4.setVisibility(8);
        }
        NestedScrollView nestedScrollView5 = this.containerInfo;
        if (nestedScrollView5 != null) {
            nestedScrollView5.setVisibility(8);
        }
        if (itemId == R.id.navigation_home) {
            NestedScrollView nestedScrollView6 = this.containerHome;
            if (nestedScrollView6 != null) {
                nestedScrollView6.setVisibility(0);
            }
            return true;
        }
        if (itemId == R.id.navigation_guide) {
            NestedScrollView nestedScrollView7 = this.containerGuide;
            if (nestedScrollView7 != null) {
                nestedScrollView7.setVisibility(0);
            }
            return true;
        }
        if (itemId == R.id.navigation_settings) {
            NestedScrollView nestedScrollView8 = this.containerSettings;
            if (nestedScrollView8 != null) {
                nestedScrollView8.setVisibility(0);
            }
            return true;
        }
        if (itemId != R.id.navigation_subscription) {
            if (itemId != R.id.navigation_info) {
                return false;
            }
            NestedScrollView nestedScrollView9 = this.containerInfo;
            if (nestedScrollView9 != null) {
                nestedScrollView9.setVisibility(0);
            }
            return true;
        }
        if (!this.subscriptionViewModel.canAccessApp()) {
            startActivity(new Intent(this, (Class<?>) SubscriptionActivity.class));
            return false;
        }
        NestedScrollView nestedScrollView10 = this.containerSubscription;
        if (nestedScrollView10 != null) {
            nestedScrollView10.setVisibility(0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupSteeringWheelControl$2(SharedPreferences sharedPreferences, MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z6) {
        if (z6) {
            boolean z7 = i == R.id.steeringWheelRight;
            sharedPreferences.edit().putBoolean(PREF_STEERING_WHEEL_RIGHT, z7).apply();
            this.homeLogManager.logInfo(TAG, "Steering wheel position changed to: ".concat(z7 ? "Right" : "Left"));
            if (this.viewModel.isServiceRunning()) {
                performServiceRestart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$togglePermissionsDropdown$26() {
        this.permissionsDetailContainer.setVisibility(8);
    }

    private void observeViewModelState() {
        final int i = 0;
        this.viewModel.getServiceRunning().observe(this, new Observer(this) { // from class: fr.sd.taada.activities.b
            public final /* synthetic */ HomeActivity b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i) {
                    case 0:
                        this.b.updateServiceUI(((Boolean) obj).booleanValue());
                        break;
                    case 1:
                        this.b.updatePermissionsUI(((Boolean) obj).booleanValue());
                        break;
                    default:
                        this.b.updateBluetoothUI((List) obj);
                        break;
                }
            }
        });
        final int i3 = 1;
        this.viewModel.getAllPermissionsGranted().observe(this, new Observer(this) { // from class: fr.sd.taada.activities.b
            public final /* synthetic */ HomeActivity b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i3) {
                    case 0:
                        this.b.updateServiceUI(((Boolean) obj).booleanValue());
                        break;
                    case 1:
                        this.b.updatePermissionsUI(((Boolean) obj).booleanValue());
                        break;
                    default:
                        this.b.updateBluetoothUI((List) obj);
                        break;
                }
            }
        });
        final int i4 = 2;
        this.viewModel.getSelectedDeviceNames().observe(this, new Observer(this) { // from class: fr.sd.taada.activities.b
            public final /* synthetic */ HomeActivity b;

            {
                this.b = this;
            }

            @Override // android.view.Observer
            public final void onChanged(Object obj) {
                switch (i4) {
                    case 0:
                        this.b.updateServiceUI(((Boolean) obj).booleanValue());
                        break;
                    case 1:
                        this.b.updatePermissionsUI(((Boolean) obj).booleanValue());
                        break;
                    default:
                        this.b.updateBluetoothUI((List) obj);
                        break;
                }
            }
        });
    }

    private void openUrl(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            this.homeLogManager.logError(TAG, "Error opening URL: " + str, e);
            Toast.makeText(this, "Cannot open URL", 0).show();
        }
    }

    private void openWifiHotspotSettings() {
        Intent intent;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                intent = new Intent("android.settings.WIFI_SETTINGS");
            } else {
                intent = new Intent();
                intent.setAction("android.settings.TETHER_SETTINGS");
            }
            startActivity(intent);
            this.homeLogManager.logInfo(TAG, "Opened Wi-Fi settings");
        } catch (Exception unused) {
            this.homeLogManager.logWarning(TAG, "Wi-Fi settings not found, trying fallback");
            try {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            } catch (Exception e) {
                this.homeLogManager.logError(TAG, "Could not open any settings", e);
                Toast.makeText(this, "Paramètres Wi-Fi non disponibles", 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performServiceRestart() {
        if (this.viewModel.isServiceRunning()) {
            this.viewModel.stopService(this);
            this.serviceStartHandler.startServiceAfterPermissions();
        }
    }

    private void populatePermissionsDropdown() {
        this.permissionsDetailContainer.removeAllViews();
        List<PermissionItem> permissionsList = new PermissionStatusManager(this).getPermissionsList();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        for (PermissionItem permissionItem : permissionsList) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.item_permission_detail, (ViewGroup) this.permissionsDetailContainer, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.permissionStatusIcon);
            imageView.setImageResource(permissionItem.getIconRes());
            imageView.setColorFilter(ContextCompat.getColor(this, permissionItem.getIconTint()));
            ((TextView) viewInflate.findViewById(R.id.permissionNameText)).setText(permissionItem.getName());
            ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.permissionSettingsButton);
            imageButton.setVisibility(0);
            imageButton.setOnClickListener(new androidx.navigation.ui.b(3, this, permissionItem));
            this.permissionsDetailContainer.addView(viewInflate);
        }
    }

    private void refreshPermissionsDropdownIfNeeded() {
        if (this.isPermissionsExpanded) {
            populatePermissionsDropdown();
        }
    }

    private void registerPermissionLauncher() {
        this.permissionRequestLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new d(this, 2));
    }

    private void registerServiceStateReceiver() {
        this.serviceStateReceiver = new BroadcastReceiver() { // from class: fr.sd.taada.activities.HomeActivity.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(HomeViewModel.ACTION_SERVICE_STATE_CHANGED)) {
                    HomeActivity.this.viewModel.checkServiceState(HomeActivity.this);
                    HomeActivity.this.demoModeUiHandler.onServiceStateChanged();
                }
            }
        };
        ContextCompat.registerReceiver(this, this.serviceStateReceiver, new IntentFilter(HomeViewModel.ACTION_SERVICE_STATE_CHANGED), 4);
    }

    private void registerSettingsLauncher() {
        this.settingsLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d(this, 3));
    }

    private void registerVpnActivityResultLauncher() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d(this, 4));
        this.vpnLauncher = activityResultLauncherRegisterForActivityResult;
        PermissionFlowManager permissionFlowManager = new PermissionFlowManager(this, this.viewModel, this.permissionRequestLauncher, this.settingsLauncher, activityResultLauncherRegisterForActivityResult);
        this.permissionFlowManager = permissionFlowManager;
        this.serviceStartHandler.setPermissionFlowManager(permissionFlowManager);
    }

    private void setDeveloperModeEnabled(boolean z6) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean(PREF_DEVELOPER_MODE, z6).apply();
    }

    private void setupClickListeners() {
        this.startStopButton.setOnClickListener(new c(this, 13));
        this.bluetoothCard.setOnClickListener(new c(this, 3));
        this.bluetoothInfoButton.setOnClickListener(new c(this, 4));
        this.permissionsCard.setOnClickListener(new c(this, 5));
        this.grantPermissionsButton.setOnClickListener(new c(this, 6));
        this.settingsButton.setOnClickListener(new c(this, 7));
        this.logsButton.setOnClickListener(new c(this, 8));
        Button button = this.guideWifiButton;
        if (button != null) {
            button.setOnClickListener(new c(this, 9));
        }
        Button button2 = this.guideBatteryButton;
        if (button2 != null) {
            button2.setOnClickListener(new c(this, 10));
        }
        this.subscriptionButton.setOnClickListener(new c(this, 11));
        this.versionText.setOnClickListener(new c(this, 14));
        this.githubButton.setOnClickListener(new c(this, 15));
        this.facebookButton.setOnClickListener(new c(this, 16));
        this.linkedinButton.setOnClickListener(new c(this, 17));
        this.youtubeButton.setOnClickListener(new c(this, 18));
        this.rearmDemoButton.setOnClickListener(new c(this, 19));
        Button button3 = (Button) findViewById(R.id.btnHomeToGuide);
        if (button3 != null) {
            button3.setOnClickListener(new c(this, 0));
        }
        Button button4 = this.unlockFullAccessButton;
        if (button4 != null) {
            button4.setOnClickListener(new c(this, 1));
        }
        this.feedbackButton.setOnClickListener(new c(this, 2));
    }

    private void setupNavigation() {
        this.bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        this.containerHome = (NestedScrollView) findViewById(R.id.container_home);
        this.containerGuide = (NestedScrollView) findViewById(R.id.container_guide);
        this.containerSettings = (NestedScrollView) findViewById(R.id.container_settings);
        this.containerSubscription = (NestedScrollView) findViewById(R.id.container_subscription);
        this.containerInfo = (NestedScrollView) findViewById(R.id.container_info);
        this.bottomNavigationView.setOnItemSelectedListener(new d(this, 0));
        this.bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }

    private void setupSteeringWheelControl() {
        if (this.steeringWheelToggleGroup == null) {
            return;
        }
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.steeringWheelToggleGroup.b(defaultSharedPreferences.getBoolean(PREF_STEERING_WHEEL_RIGHT, false) ? R.id.steeringWheelRight : R.id.steeringWheelLeft, true);
        this.steeringWheelToggleGroup.c.add(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: fr.sd.taada.activities.e
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z6) {
                this.f3263a.lambda$setupSteeringWheelControl$2(defaultSharedPreferences, materialButtonToggleGroup, i, z6);
            }
        });
    }

    private void setupVersionText() {
        try {
            this.versionText.setText(getString(R.string.app_version_format, getPackageManager().getPackageInfo(getPackageName(), 0).versionName));
        } catch (PackageManager.NameNotFoundException e) {
            this.homeLogManager.logError(TAG, "Error getting package info", e);
        }
    }

    private void togglePermissionsDropdown() {
        boolean z6 = this.isPermissionsExpanded;
        this.isPermissionsExpanded = !z6;
        this.permissionsExpandIcon.animate().rotation(!z6 ? 180.0f : 0.0f).setDuration(200L).start();
        if (!this.isPermissionsExpanded) {
            this.permissionsDetailContainer.animate().alpha(0.0f).setDuration(150L).withEndAction(new androidx.constraintlayout.helper.widget.a(this, 12)).start();
            return;
        }
        populatePermissionsDropdown();
        this.permissionsDetailContainer.setVisibility(0);
        this.permissionsDetailContainer.setAlpha(0.0f);
        this.permissionsDetailContainer.animate().alpha(1.0f).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBluetoothUI(List<String> list) {
        if (list.isEmpty()) {
            this.btStatusText.setText(R.string.no_device_selected);
        } else {
            this.btStatusText.setText(String.join(", ", list));
        }
    }

    private void updateDeveloperModeUI() {
        this.settingsButton.setVisibility(isDeveloperModeEnabled() ? 0 : 8);
        this.logsButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePermissionsUI(boolean z6) {
        if (z6) {
            this.permissionsStatusText.setText(R.string.all_permissions_granted);
            this.permissionsStatusText.setTextColor(getResources().getColor(R.color.permission_granted));
            this.grantPermissionsButton.setVisibility(8);
        } else {
            this.permissionsStatusText.setText(R.string.permissions_missing);
            this.permissionsStatusText.setTextColor(getResources().getColor(R.color.permission_denied));
            this.grantPermissionsButton.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateServiceUI(boolean z6) {
        if (z6) {
            this.startStopText.setText(R.string.stop);
            this.startStopIcon.setImageResource(R.drawable.ic_stop);
            this.serviceStatusText.setText(R.string.active);
            this.startStopButton.setStrokeColor(getResources().getColor(R.color.service_active));
            return;
        }
        this.startStopText.setText(R.string.start);
        this.startStopIcon.setImageResource(R.drawable.ic_play);
        this.serviceStatusText.setText(R.string.inactive);
        this.startStopButton.setStrokeColor(getResources().getColor(R.color.service_inactive));
    }

    @Override // fr.sd.taada.activities.BaseLocalizedActivity, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AppCompatDelegate.setDefaultNightMode(2);
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);
        initializeLogManager();
        this.viewModel = (HomeViewModel) new ViewModelProvider(this).get(HomeViewModel.class);
        this.subscriptionViewModel = (SubscriptionViewModel) new ViewModelProvider(this).get(SubscriptionViewModel.class);
        this.demoModeManager = DemoModeManager.getInstance(this);
        initializeViews();
        initializeManagers();
        setupClickListeners();
        registerPermissionLauncher();
        registerSettingsLauncher();
        registerServiceStateReceiver();
        registerVpnActivityResultLauncher();
        observeViewModelState();
        this.subscriptionUiHandler.observe(this);
        this.demoModeUiHandler.observe(this);
        this.currentLanguage = LocaleHelper.getCurrentLanguage(this);
        updateDeveloperModeUI();
        this.homeLogManager.logInfo(TAG, "HomeActivity created");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ZoomControlManager zoomControlManager = this.zoomControlManager;
        if (zoomControlManager != null) {
            zoomControlManager.onDestroy();
        }
        BroadcastReceiver broadcastReceiver = this.serviceStateReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.serviceStateReceiver = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String currentLanguage = LocaleHelper.getCurrentLanguage(this);
        if (currentLanguage.equals(this.currentLanguage)) {
            this.viewModel.checkAllPermissions(this);
            this.viewModel.checkServiceState(this);
            this.viewModel.loadSelectedBluetoothDevices(this);
            updateDeveloperModeUI();
            ReviewRequestManager.getInstance(this).processPendingReviewRequest(this);
            refreshPermissionsDropdownIfNeeded();
            return;
        }
        this.homeLogManager.logDebug(TAG, "Language changed from " + this.currentLanguage + " to " + currentLanguage);
        this.currentLanguage = currentLanguage;
        onLanguageChanged();
    }
}
