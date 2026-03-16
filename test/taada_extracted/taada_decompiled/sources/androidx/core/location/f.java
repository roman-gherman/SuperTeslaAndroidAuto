package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1607a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(Object obj, Executor executor, int i, int i3) {
        this.f1607a = i3;
        this.d = obj;
        this.b = executor;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1607a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.d).lambda$onStatusChanged$1(this.b, this.c);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.d).lambda$onGpsStatusChanged$2(this.b, this.c);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.d).lambda$onFirstFix$2(this.b, this.c);
                break;
        }
    }
}
