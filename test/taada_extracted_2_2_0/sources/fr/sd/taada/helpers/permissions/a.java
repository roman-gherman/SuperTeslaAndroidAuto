package fr.sd.taada.helpers.permissions;

import android.content.DialogInterface;
import fr.sd.taada.activities.LogActivity;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3282a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f3282a = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f3282a) {
            case 0:
                PermissionDialogFactory.lambda$showCustomOsPopupDialog$8((Runnable) this.b, dialogInterface, i);
                break;
            case 1:
                PermissionDialogFactory.lambda$showCustomOsLockScreenDialog$7((Runnable) this.b, dialogInterface, i);
                break;
            case 2:
                PermissionDialogFactory.lambda$showCustomOsAutoStartDialog$11((Runnable) this.b, dialogInterface, i);
                break;
            case 3:
                PermissionDialogFactory.lambda$showCustomOsAutoStartDialog$13((Runnable) this.b, dialogInterface, i);
                break;
            case 4:
                PermissionDialogFactory.lambda$showCustomOsPopupDialog$10((Runnable) this.b, dialogInterface, i);
                break;
            case 5:
                PermissionDialogFactory.lambda$showBatteryOptimizationDialog$2((Runnable) this.b, dialogInterface, i);
                break;
            case 6:
                PermissionDialogFactory.lambda$showBatteryOptimizationDialog$4((Runnable) this.b, dialogInterface, i);
                break;
            case 7:
                PermissionDialogFactory.lambda$showSystemPermissionDialog$0((Runnable) this.b, dialogInterface, i);
                break;
            case 8:
                PermissionDialogFactory.lambda$showSystemPermissionDialog$1((Runnable) this.b, dialogInterface, i);
                break;
            case 9:
                PermissionDialogFactory.lambda$showCustomOsLockScreenDialog$5((Runnable) this.b, dialogInterface, i);
                break;
            default:
                ((LogActivity) this.b).lambda$showClearLogsDialog$9(dialogInterface, i);
                break;
        }
    }
}
