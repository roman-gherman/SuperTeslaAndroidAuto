package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1583a;
    public final /* synthetic */ Toolbar b;

    public /* synthetic */ a(Toolbar toolbar, int i) {
        this.f1583a = i;
        this.b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1583a) {
            case 0:
                this.b.collapseActionView();
                break;
            default:
                this.b.invalidateMenu();
                break;
        }
    }
}
