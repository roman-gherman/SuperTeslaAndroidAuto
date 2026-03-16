package fr.sd.taada.helpers.permissions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.VpnService;
import android.util.Log;
import android.view.result.ActivityResultLauncher;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fr.sd.taada.R;
import fr.sd.taada.helpers.CustomOsPermissionHelper;
import fr.sd.taada.helpers.permissions.PermissionItem;
import fr.sd.taada.viewmodels.HomeViewModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionFlowManager {
    private static final String TAG = "PermissionFlowManager";
    private final Context context;

    @Nullable
    private PermissionCallback currentCallback;
    private final PermissionDialogFactory dialogFactory;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private final ActivityResultLauncher<Intent> settingsLauncher;
    private final HomeViewModel viewModel;
    private final ActivityResultLauncher<Intent> vpnLauncher;
    private boolean isFlowActive = false;

    @Nullable
    private PermissionItem.PermissionType lastRequestedPermission = null;
    private final Set<PermissionItem.PermissionType> skippedPermissions = new HashSet();

    /* JADX INFO: renamed from: fr.sd.taada.helpers.permissions.PermissionFlowManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType;

        static {
            int[] iArr = new int[PermissionItem.PermissionType.values().length];
            $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType = iArr;
            try {
                iArr[PermissionItem.PermissionType.BATTERY_OPTIMIZATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.CUSTOM_OS_LOCK_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.CUSTOM_OS_POPUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.CUSTOM_OS_AUTO_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.BLUETOOTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.MICROPHONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.NOTIFICATIONS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.OVERLAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.WRITE_SETTINGS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[PermissionItem.PermissionType.VPN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public PermissionFlowManager(@NonNull Context context, @NonNull HomeViewModel homeViewModel, @NonNull ActivityResultLauncher<String[]> activityResultLauncher, @NonNull ActivityResultLauncher<Intent> activityResultLauncher2, @NonNull ActivityResultLauncher<Intent> activityResultLauncher3) {
        this.context = context;
        this.viewModel = homeViewModel;
        this.dialogFactory = new PermissionDialogFactory(context);
        this.permissionLauncher = activityResultLauncher;
        this.settingsLauncher = activityResultLauncher2;
        this.vpnLauncher = activityResultLauncher3;
    }

    private void completeFlow(boolean z6) {
        this.isFlowActive = false;
        if (z6) {
            Toast.makeText(this.context, R.string.all_permissions_granted, 0).show();
        }
        PermissionCallback permissionCallback = this.currentCallback;
        if (permissionCallback != null) {
            permissionCallback.onFlowComplete(z6);
        }
        this.currentCallback = null;
    }

    private boolean isCustomOsPermissionAlreadyConfirmed(PermissionItem.PermissionType permissionType) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("custom_os_permissions", 0);
        int i = AnonymousClass1.$SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[permissionType.ordinal()];
        if (i == 1) {
            return sharedPreferences.getBoolean("battery_optimization_granted", false);
        }
        if (i == 2) {
            return sharedPreferences.getBoolean("miui_lock_screen_granted", false);
        }
        if (i == 3) {
            return sharedPreferences.getBoolean("miui_popup_granted", false);
        }
        if (i != 4) {
            return false;
        }
        return sharedPreferences.getBoolean("auto_start_granted", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$10() {
        this.lastRequestedPermission = PermissionItem.PermissionType.CUSTOM_OS_LOCK_SCREEN;
        openCustomOsSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$11() {
        this.viewModel.checkAllPermissions(this.context);
        requestNextSystemPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$12() {
        this.skippedPermissions.add(PermissionItem.PermissionType.CUSTOM_OS_LOCK_SCREEN);
        this.viewModel.checkAllPermissions(this.context);
        requestNextSystemPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$13() {
        this.lastRequestedPermission = PermissionItem.PermissionType.CUSTOM_OS_POPUP;
        openCustomOsSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$14() {
        this.viewModel.checkAllPermissions(this.context);
        requestNextSystemPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$15() {
        this.skippedPermissions.add(PermissionItem.PermissionType.CUSTOM_OS_POPUP);
        this.viewModel.checkAllPermissions(this.context);
        requestNextSystemPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$16() {
        this.lastRequestedPermission = PermissionItem.PermissionType.CUSTOM_OS_AUTO_START;
        openCustomOsSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$17() {
        this.viewModel.checkAllPermissions(this.context);
        requestNextSystemPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$18() {
        this.skippedPermissions.add(PermissionItem.PermissionType.CUSTOM_OS_AUTO_START);
        this.viewModel.checkAllPermissions(this.context);
        requestNextSystemPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$7() {
        this.lastRequestedPermission = PermissionItem.PermissionType.BATTERY_OPTIMIZATION;
        openBatterySettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$8() {
        this.viewModel.checkAllPermissions(this.context);
        requestNextSystemPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestNextSystemPermission$9() {
        this.skippedPermissions.add(PermissionItem.PermissionType.BATTERY_OPTIMIZATION);
        this.viewModel.checkAllPermissions(this.context);
        requestNextSystemPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogForPermission$0() {
        this.viewModel.checkAllPermissions(this.context);
        if (this.isFlowActive) {
            requestNextSystemPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogForPermission$1() {
        this.lastRequestedPermission = PermissionItem.PermissionType.CUSTOM_OS_LOCK_SCREEN;
        openCustomOsSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogForPermission$2() {
        this.viewModel.checkAllPermissions(this.context);
        if (this.isFlowActive) {
            requestNextSystemPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogForPermission$3() {
        this.lastRequestedPermission = PermissionItem.PermissionType.CUSTOM_OS_POPUP;
        openCustomOsSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogForPermission$4() {
        this.viewModel.checkAllPermissions(this.context);
        if (this.isFlowActive) {
            requestNextSystemPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogForPermission$5() {
        this.lastRequestedPermission = PermissionItem.PermissionType.CUSTOM_OS_AUTO_START;
        openCustomOsSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogForPermission$6() {
        this.viewModel.checkAllPermissions(this.context);
        if (this.isFlowActive) {
            requestNextSystemPermission();
        }
    }

    private void launchFallbackSettings() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + this.context.getPackageName()));
            this.settingsLauncher.launch(intent);
            Toast.makeText(this.context, R.string.unable_to_open_settings_manual, 1).show();
        } catch (Exception e) {
            Log.e(TAG, "Failed to open fallback settings", e);
            Toast.makeText(this.context, R.string.unable_to_open_settings_manual, 1).show();
        }
    }

    private void openAppDetailsSettings() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + this.context.getPackageName()));
            this.context.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(this.context, R.string.unable_to_open_settings_manual, 1).show();
        }
    }

    private void openBluetoothSettings() {
        try {
            this.context.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
        } catch (Exception unused) {
            Toast.makeText(this.context, R.string.unable_to_open_settings_manual, 1).show();
        }
    }

    private void openCustomOsSettings() {
        try {
            Intent permissionSettingsIntent = CustomOsPermissionHelper.getPermissionSettingsIntent(this.context);
            if (permissionSettingsIntent == null || permissionSettingsIntent.resolveActivity(this.context.getPackageManager()) == null) {
                launchFallbackSettings();
            } else {
                this.settingsLauncher.launch(permissionSettingsIntent);
            }
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "ActivityNotFoundException when opening custom OS settings", e);
            launchFallbackSettings();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openOverlaySettings() {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
        this.settingsLauncher.launch(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWriteSettings() {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
        this.settingsLauncher.launch(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestVpnPermission() {
        Intent intentPrepare = VpnService.prepare(this.context);
        if (intentPrepare != null) {
            this.vpnLauncher.launch(intentPrepare);
            return;
        }
        Toast.makeText(this.context, R.string.vpn_configuration_successful, 0).show();
        if (this.isFlowActive) {
            this.viewModel.checkAllPermissions(this.context);
            requestNextSystemPermission();
        }
    }

    private boolean requiresManualConfirmation(PermissionItem.PermissionType permissionType) {
        int i = AnonymousClass1.$SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[permissionType.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public void cancelFlow() {
        PermissionCallback permissionCallback = this.currentCallback;
        if (permissionCallback != null) {
            permissionCallback.onFlowCancelled();
        }
        this.isFlowActive = false;
        this.currentCallback = null;
    }

    public void continueFlowAfterSettingsReturn() {
        this.viewModel.checkAllPermissions(this.context);
        PermissionItem.PermissionType permissionType = this.lastRequestedPermission;
        if (permissionType != null && requiresManualConfirmation(permissionType)) {
            PermissionItem.PermissionType permissionType2 = this.lastRequestedPermission;
            this.lastRequestedPermission = null;
            showDialogForPermission(permissionType2);
        } else {
            this.lastRequestedPermission = null;
            if (this.viewModel.areAllPermissionsGranted()) {
                completeFlow(true);
            } else {
                requestNextSystemPermission();
            }
        }
    }

    public boolean isFlowActive() {
        return this.isFlowActive;
    }

    public void onRuntimePermissionsResult() {
        if (this.isFlowActive) {
            this.viewModel.checkAllPermissions(this.context);
            if (this.viewModel.areAllPermissionsGranted()) {
                completeFlow(true);
            } else {
                requestNextSystemPermission();
            }
        }
    }

    public void openBatterySettings() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            if (intent.resolveActivity(this.context.getPackageManager()) == null) {
                intent.setAction("android.settings.BATTERY_SAVER_SETTINGS");
            }
            if (intent.resolveActivity(this.context.getPackageManager()) != null) {
                this.settingsLauncher.launch(intent);
            } else {
                intent.setAction("android.settings.SETTINGS");
                this.settingsLauncher.launch(intent);
            }
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.parse("package:" + this.context.getPackageName()));
            this.settingsLauncher.launch(intent2);
        }
    }

    public void requestNextSystemPermission() {
        if (this.viewModel.isOverlayPermissionRequired()) {
            this.dialogFactory.showOverlayPermissionDialog(new c(this, 0));
            return;
        }
        if (this.viewModel.isWriteSettingsPermissionRequired()) {
            this.dialogFactory.showWriteSettingsPermissionDialog(new c(this, 19));
            return;
        }
        if (this.viewModel.isVpnPermissionRequired()) {
            this.dialogFactory.showVpnPermissionDialog(new c(this, 20));
            return;
        }
        if (this.viewModel.isBatteryOptimizationRequired()) {
            Set<PermissionItem.PermissionType> set = this.skippedPermissions;
            PermissionItem.PermissionType permissionType = PermissionItem.PermissionType.BATTERY_OPTIMIZATION;
            if (!set.contains(permissionType)) {
                if (!isCustomOsPermissionAlreadyConfirmed(permissionType)) {
                    this.dialogFactory.showBatteryOptimizationDialog(new c(this, 21), new c(this, 22), new c(this, 1));
                    return;
                } else {
                    this.viewModel.checkAllPermissions(this.context);
                    requestNextSystemPermission();
                    return;
                }
            }
        }
        if (this.viewModel.isCustomOsLockScreenPermissionRequired()) {
            Set<PermissionItem.PermissionType> set2 = this.skippedPermissions;
            PermissionItem.PermissionType permissionType2 = PermissionItem.PermissionType.CUSTOM_OS_LOCK_SCREEN;
            if (!set2.contains(permissionType2)) {
                if (!isCustomOsPermissionAlreadyConfirmed(permissionType2)) {
                    this.dialogFactory.showCustomOsLockScreenDialog(new c(this, 2), new c(this, 3), new c(this, 4));
                    return;
                } else {
                    this.viewModel.checkAllPermissions(this.context);
                    requestNextSystemPermission();
                    return;
                }
            }
        }
        if (this.viewModel.isCustomOsPopupPermissionRequired()) {
            Set<PermissionItem.PermissionType> set3 = this.skippedPermissions;
            PermissionItem.PermissionType permissionType3 = PermissionItem.PermissionType.CUSTOM_OS_POPUP;
            if (!set3.contains(permissionType3)) {
                if (!isCustomOsPermissionAlreadyConfirmed(permissionType3)) {
                    this.dialogFactory.showCustomOsPopupDialog(new c(this, 5), new c(this, 11), new c(this, 15));
                    return;
                } else {
                    this.viewModel.checkAllPermissions(this.context);
                    requestNextSystemPermission();
                    return;
                }
            }
        }
        if (this.viewModel.isCustomOsAutoStartPermissionRequired()) {
            Set<PermissionItem.PermissionType> set4 = this.skippedPermissions;
            PermissionItem.PermissionType permissionType4 = PermissionItem.PermissionType.CUSTOM_OS_AUTO_START;
            if (!set4.contains(permissionType4)) {
                if (!isCustomOsPermissionAlreadyConfirmed(permissionType4)) {
                    this.dialogFactory.showCustomOsAutoStartDialog(new c(this, 16), new c(this, 17), new c(this, 18));
                    return;
                } else {
                    this.viewModel.checkAllPermissions(this.context);
                    requestNextSystemPermission();
                    return;
                }
            }
        }
        completeFlow(this.viewModel.areAllPermissionsGranted());
    }

    public void showDialogForPermission(PermissionItem.PermissionType permissionType) {
        switch (AnonymousClass1.$SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$PermissionType[permissionType.ordinal()]) {
            case 1:
                this.dialogFactory.showBatteryOptimizationDialog(new c(this, 7), new c(this, 8), null);
                break;
            case 2:
                this.dialogFactory.showCustomOsLockScreenDialog(new c(this, 9), new c(this, 10), null);
                break;
            case 3:
                this.dialogFactory.showCustomOsPopupDialog(new c(this, 12), new c(this, 13), null);
                break;
            case 4:
                this.dialogFactory.showCustomOsAutoStartDialog(new c(this, 14), new c(this, 6), null);
                break;
            case 5:
                openBluetoothSettings();
                break;
            case 6:
            case 7:
                openAppDetailsSettings();
                break;
            case 8:
                this.dialogFactory.showOverlayPermissionDialog(new c(this, 0));
                break;
            case 9:
                this.dialogFactory.showWriteSettingsPermissionDialog(new c(this, 19));
                break;
            case 10:
                this.dialogFactory.showVpnPermissionDialog(new c(this, 20));
                break;
        }
    }

    public void startPermissionFlow(@Nullable PermissionCallback permissionCallback) {
        this.currentCallback = permissionCallback;
        this.isFlowActive = true;
        List<String> missingRuntimePermissions = this.viewModel.getMissingRuntimePermissions();
        if (missingRuntimePermissions.isEmpty()) {
            requestNextSystemPermission();
        } else {
            this.permissionLauncher.launch((String[]) missingRuntimePermissions.toArray(new String[0]));
        }
    }
}
