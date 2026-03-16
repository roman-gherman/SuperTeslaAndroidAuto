package fr.sd.taada.activities;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3265a;
    public final /* synthetic */ LogActivity b;
    public final /* synthetic */ Exception c;

    public /* synthetic */ g(LogActivity logActivity, Exception exc, int i) {
        this.f3265a = i;
        this.b = logActivity;
        this.c = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3265a) {
            case 0:
                this.b.lambda$copyLogsToClipboard$7(this.c);
                break;
            default:
                this.b.lambda$refreshLogContent$4(this.c);
                break;
        }
    }
}
