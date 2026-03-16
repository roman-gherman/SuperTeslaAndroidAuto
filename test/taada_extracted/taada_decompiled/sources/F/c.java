package F;

import B.g;
import B.t;
import B.w;
import B.x;
import O.e;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;

/* JADX INFO: loaded from: classes.dex */
public final class c extends com.google.android.gms.common.api.c implements TelemetryLoggingClient {
    public static final com.google.android.gms.common.api.b i = new com.google.android.gms.common.api.b(new b(), new D.d(1, (byte) 0));

    @Override // com.google.android.gms.common.internal.TelemetryLoggingClient
    public final com.google.android.gms.tasks.b log(TelemetryData telemetryData) {
        g gVar = new g(0, false);
        Feature[] featureArr = {O.c.f1175a};
        gVar.b = new g(telemetryData, 5);
        w wVar = new w(gVar, featureArr, false);
        com.google.android.gms.tasks.c cVar = new com.google.android.gms.tasks.c();
        B.d dVar = this.f1933h;
        dVar.getClass();
        t tVar = new t(new x(wVar, cVar, this.f1932g), dVar.i.get(), this);
        e eVar = dVar.f95m;
        eVar.sendMessage(eVar.obtainMessage(4, tVar));
        return cVar.f2174a;
    }
}
