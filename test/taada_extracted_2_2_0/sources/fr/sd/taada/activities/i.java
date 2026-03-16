package fr.sd.taada.activities;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3267a;
    public final /* synthetic */ LogActivity b;
    public final /* synthetic */ String c;

    public /* synthetic */ i(LogActivity logActivity, String str, int i) {
        this.f3267a = i;
        this.b = logActivity;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3267a) {
            case 0:
                this.b.lambda$refreshLogContent$3(this.c);
                break;
            default:
                this.b.lambda$copyLogsToClipboard$6(this.c);
                break;
        }
    }
}
