package D;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class o extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f214g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(c cVar, int i) {
        super(cVar, i, null);
        this.f214g = cVar;
    }

    @Override // D.h
    public final void a(ConnectionResult connectionResult) {
        c cVar = this.f214g;
        cVar.getClass();
        cVar.f193n.onReportServiceBinding(connectionResult);
        cVar.d = connectionResult.b;
        cVar.e = System.currentTimeMillis();
    }

    @Override // D.h
    public final boolean b() {
        this.f214g.f193n.onReportServiceBinding(ConnectionResult.e);
        return true;
    }
}
