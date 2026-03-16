package androidx.work.impl;

import android.content.Context;
import android.os.Handler;
import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.k;
import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.u;
import fr.sd.taada.billing.BillingManager;
import fr.sd.taada.billing.SubscriptionGuard;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.MemoryHelper;
import fr.sd.taada.helpers.MemoryTestRunner;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1681a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f1681a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1681a) {
            case 0:
                Schedulers.lambda$registerRescheduling$0((List) this.b, (WorkGenerationalId) this.c, (Configuration) this.d, (WorkDatabase) this.e);
                break;
            case 1:
                SubscriptionGuard.lambda$checkSubscriptionAccessWithObserver$0(this.b, (boolean[]) this.c, (BillingManager) this.d, (boolean[]) this.e);
                break;
            case 2:
                ((LogManager) this.b).lambda$logError$4((String) this.c, (String) this.d, (Throwable) this.e);
                break;
            case 3:
                MemoryTestRunner.lambda$runMemoryCleanup$11((Context) this.b, (MemoryHelper.MemoryInfo) this.c, (Handler) this.d, (MemoryTestRunner.TestCallback) this.e);
                break;
            default:
                u uVar = (u) this.c;
                TransportScheduleCallback transportScheduleCallback = (TransportScheduleCallback) this.d;
                o oVar = (o) this.e;
                r.a aVar = (r.a) this.b;
                Logger logger = r.a.f4677f;
                try {
                    TransportBackend transportBackend = aVar.c.get(((k) uVar).f1883a);
                    if (transportBackend == null) {
                        String str = "Transport backend '" + ((k) uVar).f1883a + "' is not registered";
                        logger.warning(str);
                        transportScheduleCallback.onSchedule(new IllegalArgumentException(str));
                    } else {
                        aVar.e.runCriticalSection(new q5.a(aVar, uVar, transportBackend.decorate(oVar)));
                        transportScheduleCallback.onSchedule(null);
                    }
                } catch (Exception e) {
                    logger.warning("Error scheduling event " + e.getMessage());
                    transportScheduleCallback.onSchedule(e);
                    return;
                }
                break;
        }
    }
}
