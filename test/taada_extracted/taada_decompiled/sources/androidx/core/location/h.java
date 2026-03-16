package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1609a;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport b;
    public final /* synthetic */ String c;

    public /* synthetic */ h(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i) {
        this.f1609a = i;
        this.b = locationListenerTransport;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1609a) {
            case 0:
                this.b.lambda$onProviderEnabled$4(this.c);
                break;
            default:
                this.b.lambda$onProviderDisabled$5(this.c);
                break;
        }
    }
}
