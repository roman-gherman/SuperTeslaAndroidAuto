package z;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class g extends O.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5163a;
    public final /* synthetic */ b b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.b = bVar;
        this.f5163a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        int i3 = c.f5159a;
        b bVar = this.b;
        Context context = this.f5163a;
        int iB = bVar.b(context, i3);
        AtomicBoolean atomicBoolean = d.f5160a;
        if (iB == 1 || iB == 2 || iB == 3 || iB == 9) {
            Intent intentA = bVar.a(context, iB, "n");
            bVar.f(context, iB, intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, 201326592));
        }
    }
}
