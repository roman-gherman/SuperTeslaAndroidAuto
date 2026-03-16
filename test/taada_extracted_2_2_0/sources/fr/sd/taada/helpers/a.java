package fr.sd.taada.helpers;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3275a;
    public final /* synthetic */ LogManager b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(LogManager logManager, String str, String str2, int i) {
        this.f3275a = i;
        this.b = logManager;
        this.c = str;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3275a) {
            case 0:
                this.b.lambda$logWarning$3(this.c, this.d);
                break;
            case 1:
                this.b.lambda$logDebug$2(this.c, this.d);
                break;
            default:
                this.b.lambda$logInfo$1(this.c, this.d);
                break;
        }
    }
}
