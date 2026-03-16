package fr.sd.taada.helpers.permissions;

import android.content.DialogInterface;
import fr.sd.taada.fragments.MainPreferenceFragment;
import fr.sd.taada.helpers.MemoryTestRunner;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3283a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f3283a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f3283a) {
            case 0:
                ((PermissionDialogFactory) this.b).lambda$showCustomOsAutoStartDialog$12((Runnable) this.c, dialogInterface, i);
                break;
            case 1:
                ((PermissionDialogFactory) this.b).lambda$showCustomOsPopupDialog$9((Runnable) this.c, dialogInterface, i);
                break;
            case 2:
                ((PermissionDialogFactory) this.b).lambda$showBatteryOptimizationDialog$3((Runnable) this.c, dialogInterface, i);
                break;
            case 3:
                ((PermissionDialogFactory) this.b).lambda$showCustomOsLockScreenDialog$6((Runnable) this.c, dialogInterface, i);
                break;
            default:
                ((MainPreferenceFragment) this.b).lambda$setupMemoryDiagnosticPreferences$1((MemoryTestRunner.TestCallback) this.c, dialogInterface, i);
                break;
        }
    }
}
