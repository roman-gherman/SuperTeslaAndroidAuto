package fr.sd.taada.helpers.permissions;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3283a;
    public final /* synthetic */ PermissionFlowManager b;

    public /* synthetic */ c(PermissionFlowManager permissionFlowManager, int i) {
        this.f3283a = i;
        this.b = permissionFlowManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3283a) {
            case 0:
                this.b.openOverlaySettings();
                break;
            case 1:
                this.b.lambda$requestNextSystemPermission$9();
                break;
            case 2:
                this.b.lambda$requestNextSystemPermission$10();
                break;
            case 3:
                this.b.lambda$requestNextSystemPermission$11();
                break;
            case 4:
                this.b.lambda$requestNextSystemPermission$12();
                break;
            case 5:
                this.b.lambda$requestNextSystemPermission$13();
                break;
            case 6:
                this.b.lambda$showDialogForPermission$6();
                break;
            case 7:
                this.b.openBatterySettings();
                break;
            case 8:
                this.b.lambda$showDialogForPermission$0();
                break;
            case 9:
                this.b.lambda$showDialogForPermission$1();
                break;
            case 10:
                this.b.lambda$showDialogForPermission$2();
                break;
            case 11:
                this.b.lambda$requestNextSystemPermission$14();
                break;
            case 12:
                this.b.lambda$showDialogForPermission$3();
                break;
            case 13:
                this.b.lambda$showDialogForPermission$4();
                break;
            case 14:
                this.b.lambda$showDialogForPermission$5();
                break;
            case 15:
                this.b.lambda$requestNextSystemPermission$15();
                break;
            case 16:
                this.b.lambda$requestNextSystemPermission$16();
                break;
            case 17:
                this.b.lambda$requestNextSystemPermission$17();
                break;
            case 18:
                this.b.lambda$requestNextSystemPermission$18();
                break;
            case 19:
                this.b.openWriteSettings();
                break;
            case 20:
                this.b.requestVpnPermission();
                break;
            case 21:
                this.b.lambda$requestNextSystemPermission$7();
                break;
            default:
                this.b.lambda$requestNextSystemPermission$8();
                break;
        }
    }
}
