package fr.sd.taada.helpers;

import p060j2.ControlSocketServer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3276a;
    public final /* synthetic */ LogManager b;

    public /* synthetic */ b(LogManager logManager, int i) {
        this.f3276a = i;
        this.b = logManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3276a) {
            case 0:
                this.b.lambda$stopLogging$0();
                break;
            case 1:
                this.b.lambda$clearAllLogs$12();
                break;
            case 2:
                this.b.lambda$setupUncaughtExceptionHandler$5();
                break;
            default:
                ControlSocketServer.lambda$handleRequestKeyframeAction$0(this.b);
                break;
        }
    }
}
