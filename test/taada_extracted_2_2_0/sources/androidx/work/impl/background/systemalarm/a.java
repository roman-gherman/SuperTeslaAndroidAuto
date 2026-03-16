package androidx.work.impl.background.systemalarm;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1679a;
    public final /* synthetic */ DelayMetCommandHandler b;

    public /* synthetic */ a(DelayMetCommandHandler delayMetCommandHandler, int i) {
        this.f1679a = i;
        this.b = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1679a) {
            case 0:
                this.b.stopWork();
                break;
            default:
                this.b.startWork();
                break;
        }
    }
}
