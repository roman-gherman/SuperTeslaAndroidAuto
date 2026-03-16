package s;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Objects;
import t.C0817a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f4744a;
    public final /* synthetic */ com.google.android.datatransport.runtime.k b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Runnable d;

    public /* synthetic */ e(j jVar, com.google.android.datatransport.runtime.k kVar, int i, Runnable runnable) {
        this.f4744a = jVar;
        this.b = kVar;
        this.c = i;
        this.d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final com.google.android.datatransport.runtime.k kVar = this.b;
        final int i = this.c;
        Runnable runnable = this.d;
        final j jVar = this.f4744a;
        SynchronizationGuard synchronizationGuard = jVar.f4750f;
        try {
            EventStore eventStore = jVar.c;
            Objects.requireNonNull(eventStore);
            synchronizationGuard.runCriticalSection(new R0.a(eventStore, 13));
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) jVar.f4749a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: s.f
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        jVar.d.schedule(kVar, i + 1);
                        return null;
                    }
                });
            } else {
                jVar.a(kVar, i);
            }
        } catch (C0817a unused) {
            jVar.d.schedule(kVar, i + 1);
        } finally {
            runnable.run();
        }
    }
}
