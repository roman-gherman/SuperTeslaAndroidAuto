package F;

import D.e;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import fr.sd.taada.proto.KeyCode;

/* JADX INFO: loaded from: classes.dex */
public final class d extends D.c {
    public final e E;

    public d(Context context, Looper looper, D.b bVar, e eVar, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        super(context, looper, KeyCode.KEYCODE_DPAD_UP_RIGHT_VALUE, bVar, googleApiClient$ConnectionCallbacks, googleApiClient$OnConnectionFailedListener);
        this.E = eVar;
    }

    @Override // D.c
    public final IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // D.c
    public final Feature[] b() {
        return O.c.b;
    }

    @Override // D.c
    public final Bundle c() {
        this.E.getClass();
        return new Bundle();
    }

    @Override // D.c
    public final String d() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // D.c
    public final String e() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // D.c
    public final boolean f() {
        return true;
    }

    @Override // D.c, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 203400000;
    }
}
