package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import X0.h;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.k;
import com.google.android.datatransport.runtime.v;
import k.d;
import s.e;
import s.j;
import v.AbstractC0846a;

/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1894a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        v.b(getApplicationContext());
        if (string == null) {
            throw new NullPointerException("Null backendName");
        }
        d dVarB = AbstractC0846a.b(i);
        byte[] bArrDecode = string2 != null ? Base64.decode(string2, 0) : null;
        j jVar = v.a().d;
        k kVar = new k(string, bArrDecode, dVarB);
        h hVar = new h(19, this, jobParameters);
        jVar.getClass();
        jVar.e.execute(new e(jVar, kVar, i3, hVar));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
