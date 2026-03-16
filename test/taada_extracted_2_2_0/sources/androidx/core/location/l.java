package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1613a;
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport b;
    public final /* synthetic */ Executor c;

    public /* synthetic */ l(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i) {
        this.f1613a = i;
        this.b = preRGnssStatusTransport;
        this.c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1613a) {
            case 0:
                this.b.lambda$onStopped$1(this.c);
                break;
            default:
                this.b.lambda$onStarted$0(this.c);
                break;
        }
    }
}
