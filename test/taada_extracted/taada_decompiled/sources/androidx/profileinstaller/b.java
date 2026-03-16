package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1661a;
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj, int i3) {
        this.f1661a = i3;
        this.b = diagnosticsCallback;
        this.c = i;
        this.d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1661a) {
            case 0:
                this.b.onResultReceived(this.c, this.d);
                break;
            default:
                this.b.onDiagnosticReceived(this.c, this.d);
                break;
        }
    }
}
