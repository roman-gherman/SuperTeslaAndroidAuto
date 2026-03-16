package fr.sd.taada.helpers.permissions;

import android.content.Context;
import android.content.DialogInterface;
import f0.C0440b;
import fr.sd.taada.R;
import fr.sd.taada.helpers.CustomOsPermissionHelper;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionDialogFactory {
    private final Context context;

    public PermissionDialogFactory(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBatteryOptimizationDialog$2(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBatteryOptimizationDialog$3(Runnable runnable, DialogInterface dialogInterface, int i) {
        this.context.getSharedPreferences("custom_os_permissions", 0).edit().putBoolean("battery_optimization_granted", true).apply();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBatteryOptimizationDialog$4(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showCustomOsAutoStartDialog$11(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCustomOsAutoStartDialog$12(Runnable runnable, DialogInterface dialogInterface, int i) {
        CustomOsPermissionHelper.setCustomOsAutoStartPermissionGranted(this.context, true);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showCustomOsAutoStartDialog$13(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showCustomOsLockScreenDialog$5(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCustomOsLockScreenDialog$6(Runnable runnable, DialogInterface dialogInterface, int i) {
        CustomOsPermissionHelper.setMiuiLockScreenPermissionGranted(this.context, true);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showCustomOsLockScreenDialog$7(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showCustomOsPopupDialog$10(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showCustomOsPopupDialog$8(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCustomOsPopupDialog$9(Runnable runnable, DialogInterface dialogInterface, int i) {
        CustomOsPermissionHelper.setMiuiPopupPermissionGranted(this.context, true);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showSystemPermissionDialog$0(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showSystemPermissionDialog$1(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public void showBatteryOptimizationDialog(Runnable runnable, Runnable runnable2, Runnable runnable3) {
        new C0440b(this.context).i(R.string.battery_optimization_title).b(R.string.battery_optimization_message).g(R.string.open_settings, new a(runnable, 5)).f(R.string.custom_os_confirm_enabled, new b(2, this, runnable2)).e(R.string.remind_later, new a(runnable3, 6)).a(false).show();
    }

    public void showCustomOsAutoStartDialog(Runnable runnable, Runnable runnable2, Runnable runnable3) {
        new C0440b(this.context).i(R.string.auto_start_title).c(this.context.getString(R.string.auto_start_message, CustomOsPermissionHelper.getCustomOsDescription())).g(R.string.open_settings, new a(runnable, 2)).f(R.string.custom_os_confirm_enabled, new b(0, this, runnable2)).e(R.string.remind_later, new a(runnable3, 3)).a(false).show();
    }

    public void showCustomOsLockScreenDialog(Runnable runnable, Runnable runnable2, Runnable runnable3) {
        new C0440b(this.context).i(R.string.miui_lock_screen_title).c(this.context.getString(R.string.miui_lock_screen_message, CustomOsPermissionHelper.getCustomOsDescription())).g(R.string.open_settings, new a(runnable, 9)).f(R.string.custom_os_confirm_enabled, new b(3, this, runnable2)).e(R.string.remind_later, new a(runnable3, 1)).a(false).show();
    }

    public void showCustomOsPopupDialog(Runnable runnable, Runnable runnable2, Runnable runnable3) {
        new C0440b(this.context).i(R.string.miui_popup_title).c(this.context.getString(R.string.miui_popup_message, CustomOsPermissionHelper.getCustomOsDescription())).g(R.string.open_settings, new a(runnable, 0)).f(R.string.custom_os_confirm_enabled, new b(1, this, runnable2)).e(R.string.remind_later, new a(runnable3, 4)).a(false).show();
    }

    public void showOverlayPermissionDialog(Runnable runnable) {
        showSystemPermissionDialog(R.string.alert_need_draw_over_other_apps, runnable, null);
    }

    public void showSystemPermissionDialog(int i, Runnable runnable, Runnable runnable2) {
        new C0440b(this.context).i(R.string.permissions_required).b(i).g(R.string.open_settings, new a(runnable, 7)).e(R.string.remind_later, new a(runnable2, 8)).a(false).show();
    }

    public void showVpnPermissionDialog(Runnable runnable) {
        showSystemPermissionDialog(R.string.vpn_service, runnable, null);
    }

    public void showWriteSettingsPermissionDialog(Runnable runnable) {
        showSystemPermissionDialog(R.string.System_settings_desc, runnable, null);
    }
}
