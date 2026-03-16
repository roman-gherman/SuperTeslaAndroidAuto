package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.k;
import com.google.android.datatransport.runtime.v;
import fr.sd.taada.billing.b;
import k.d;
import s.e;
import s.j;
import v.AbstractC0846a;

/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1893a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        v.b(context);
        if (queryParameter == null) {
            throw new NullPointerException("Null backendName");
        }
        d dVarB = AbstractC0846a.b(iIntValue);
        byte[] bArrDecode = queryParameter2 != null ? Base64.decode(queryParameter2, 0) : null;
        j jVar = v.a().d;
        k kVar = new k(queryParameter, bArrDecode, dVarB);
        b bVar = new b(1);
        jVar.getClass();
        jVar.e.execute(new e(jVar, kVar, i, bVar));
    }
}
