package fr.sd.taada.billing;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3270a;

    public /* synthetic */ b(int i) {
        this.f3270a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3270a) {
            case 0:
                SubscriptionGuard.lambda$checkSubscriptionAccessWithObserver$1();
                break;
            default:
                int i = AlarmManagerSchedulerBroadcastReceiver.f1893a;
                break;
        }
    }
}
