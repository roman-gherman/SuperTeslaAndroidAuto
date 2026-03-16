package fr.sd.taada.activities;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3266a;
    public final /* synthetic */ LogActivity b;

    public /* synthetic */ h(LogActivity logActivity, int i) {
        this.f3266a = i;
        this.b = logActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3266a) {
            case 0:
                this.b.lambda$clearAllLogs$10();
                break;
            case 1:
                this.b.refreshLogContent();
                break;
            case 2:
                this.b.lambda$refreshLogContent$2();
                break;
            case 3:
                this.b.lambda$copyLogsToClipboard$8();
                break;
            default:
                this.b.lambda$refreshLogContent$5();
                break;
        }
    }
}
