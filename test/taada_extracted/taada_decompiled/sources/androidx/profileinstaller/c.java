package androidx.profileinstaller;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1662a;
    public final /* synthetic */ Context b;

    public /* synthetic */ c(Context context, int i) {
        this.f1662a = i;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1662a) {
            case 0:
                ProfileInstallerInitializer.writeInBackground(this.b);
                break;
            default:
                ProfileInstaller.writeProfile(this.b);
                break;
        }
    }
}
