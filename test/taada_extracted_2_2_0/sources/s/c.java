package s;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.u;
import io.ktor.utils.io.b0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;
import v.AbstractC0846a;

/* JADX INFO: loaded from: classes.dex */
public final class c implements WorkScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4742a;
    public final EventStore b;
    public final a c;

    public c(Context context, EventStore eventStore, a aVar) {
        this.f4742a = context;
        this.b = eventStore;
        this.c = aVar;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public final void schedule(u uVar, int i) {
        schedule(uVar, i, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public final void schedule(u uVar, int i, boolean z6) {
        Context context = this.f4742a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        com.google.android.datatransport.runtime.k kVar = (com.google.android.datatransport.runtime.k) uVar;
        adler32.update(kVar.f1883a.getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(AbstractC0846a.a(kVar.c)).array());
        byte[] bArr = kVar.b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z6) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i3 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i3 >= i) {
                        b0.j(uVar, "JobInfoScheduler", "Upload for context %s is already scheduled. Returning...");
                        return;
                    }
                }
            }
        }
        long nextCallTime = this.b.getNextCallTime(uVar);
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        k.d dVar = kVar.c;
        a aVar = this.c;
        builder.setMinimumLatency(aVar.a(dVar, nextCallTime, i));
        Set set = ((b) aVar.b.get(dVar)).c;
        if (set.contains(d.f4743a)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(d.c)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(d.b)) {
            builder.setRequiresDeviceIdle(true);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", kVar.f1883a);
        persistableBundle.putInt("priority", AbstractC0846a.a(dVar));
        byte[] bArr2 = kVar.b;
        if (bArr2 != null) {
            persistableBundle.putString("extras", Base64.encodeToString(bArr2, 0));
        }
        builder.setExtras(persistableBundle);
        Object[] objArr = {uVar, Integer.valueOf(value), Long.valueOf(aVar.a(dVar, nextCallTime, i)), Long.valueOf(nextCallTime), Integer.valueOf(i)};
        if (Log.isLoggable("TRuntime.".concat("JobInfoScheduler"), 3)) {
            String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
        }
        jobScheduler.schedule(builder.build());
    }
}
