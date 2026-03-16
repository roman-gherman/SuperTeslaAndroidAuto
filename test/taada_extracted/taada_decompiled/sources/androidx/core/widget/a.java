package androidx.core.widget;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1626a;
    public final /* synthetic */ ContentLoadingProgressBar b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar, int i) {
        this.f1626a = i;
        this.b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1626a) {
            case 0:
                this.b.lambda$new$0();
                break;
            case 1:
                this.b.lambda$new$1();
                break;
            case 2:
                this.b.showOnUiThread();
                break;
            default:
                this.b.hideOnUiThread();
                break;
        }
    }
}
