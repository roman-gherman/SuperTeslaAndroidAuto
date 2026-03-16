package B;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f101a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ l(int i, int i3, Object obj) {
        this.f101a = i3;
        this.c = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f101a) {
            case 0:
                ((m) this.c).f(this.b);
                break;
            default:
                ((com.google.android.material.navigation.e) this.c).h(this.b);
                break;
        }
    }
}
