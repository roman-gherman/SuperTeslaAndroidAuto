package D;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f206a;
    public boolean b;
    public final /* synthetic */ c c;
    public final int d;
    public final Bundle e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f207f;

    public h(c cVar, int i, Bundle bundle) {
        this.f207f = cVar;
        Boolean bool = Boolean.TRUE;
        this.c = cVar;
        this.f206a = bool;
        this.b = false;
        this.d = i;
        this.e = bundle;
    }

    public abstract void a(ConnectionResult connectionResult);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.f206a = null;
        }
        synchronized (this.c.f195p) {
            this.c.f195p.remove(this);
        }
    }
}
