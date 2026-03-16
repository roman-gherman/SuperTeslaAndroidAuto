package androidx.appcompat.app;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1579a;
    public final /* synthetic */ Context b;

    public /* synthetic */ a(Context context, int i) {
        this.f1579a = i;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1579a) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(this.b);
                break;
            default:
                AppCompatDelegate.syncRequestedAndStoredLocales(this.b);
                break;
        }
    }
}
