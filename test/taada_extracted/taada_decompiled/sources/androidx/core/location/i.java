package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1610a;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport b;
    public final /* synthetic */ Object c;

    public /* synthetic */ i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Object obj, int i) {
        this.f1610a = i;
        this.b = locationListenerTransport;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1610a) {
            case 0:
                this.b.lambda$onLocationChanged$1((List) this.c);
                break;
            default:
                this.b.lambda$onLocationChanged$0((Location) this.c);
                break;
        }
    }
}
