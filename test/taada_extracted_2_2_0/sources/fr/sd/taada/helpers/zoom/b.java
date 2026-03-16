package fr.sd.taada.helpers.zoom;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3287a;
    public final /* synthetic */ ZoomControlManager b;

    public /* synthetic */ b(ZoomControlManager zoomControlManager, int i) {
        this.f3287a = i;
        this.b = zoomControlManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3287a) {
            case 0:
                this.b.positionRecommendedIndicator();
                break;
            default:
                this.b.lambda$scheduleDeferredPositioning$2();
                break;
        }
    }
}
