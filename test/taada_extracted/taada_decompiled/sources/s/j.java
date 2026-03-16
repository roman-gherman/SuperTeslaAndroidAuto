package s;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.n;
import com.google.android.datatransport.runtime.q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import io.ktor.utils.io.b0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import k.C0569b;
import n.C0694a;
import p.C0751a;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4748a;
    public final BackendRegistry b;
    public final EventStore c;
    public final WorkScheduler d;
    public final Executor e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SynchronizationGuard f4749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Clock f4750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Clock f4751h;
    public final ClientHealthMetricsStore i;

    public j(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f4748a = context;
        this.b = backendRegistry;
        this.c = eventStore;
        this.d = workScheduler;
        this.e = executor;
        this.f4749f = synchronizationGuard;
        this.f4750g = clock;
        this.f4751h = clock2;
        this.i = clientHealthMetricsStore;
    }

    public final void a(final com.google.android.datatransport.runtime.k kVar, int i) {
        Iterable iterable;
        n.e eVarSend;
        final j jVar = this;
        TransportBackend transportBackend = jVar.b.get(kVar.f1883a);
        final long jMax = 0;
        while (true) {
            final int i3 = 0;
            SynchronizationGuard.CriticalSection criticalSection = new SynchronizationGuard.CriticalSection(jVar) { // from class: s.g
                public final /* synthetic */ j b;

                {
                    this.b = jVar;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    switch (i3) {
                        case 0:
                            return Boolean.valueOf(this.b.c.hasPendingEventsFor(kVar));
                        default:
                            return this.b.c.loadBatch(kVar);
                    }
                }
            };
            SynchronizationGuard synchronizationGuard = jVar.f4749f;
            if (!((Boolean) synchronizationGuard.runCriticalSection(criticalSection)).booleanValue()) {
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: s.i
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        j jVar2 = this.f4747a;
                        long time = jVar2.f4750g.getTime() + jMax;
                        jVar2.c.recordNextCallTime(kVar, time);
                        return null;
                    }
                });
                return;
            }
            final int i4 = 1;
            Iterable iterable2 = (Iterable) synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection(jVar) { // from class: s.g
                public final /* synthetic */ j b;

                {
                    this.b = jVar;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    switch (i4) {
                        case 0:
                            return Boolean.valueOf(this.b.c.hasPendingEventsFor(kVar));
                        default:
                            return this.b.c.loadBatch(kVar);
                    }
                }
            });
            if (!iterable2.iterator().hasNext()) {
                return;
            }
            byte[] bArr = kVar.b;
            if (transportBackend == null) {
                b0.j(kVar, "Uploader", "Unknown backend for %s, deleting event batch for it...");
                eVarSend = new n.b(3, -1L);
                iterable = iterable2;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.google.android.datatransport.runtime.scheduling.persistence.b) ((com.google.android.datatransport.runtime.scheduling.persistence.d) it.next())).c);
                }
                if (bArr != null) {
                    ClientHealthMetricsStore clientHealthMetricsStore = jVar.i;
                    Objects.requireNonNull(clientHealthMetricsStore);
                    C0751a c0751a = (C0751a) synchronizationGuard.runCriticalSection(new R0.a(clientHealthMetricsStore, 12));
                    com.google.android.datatransport.runtime.h hVar = new com.google.android.datatransport.runtime.h();
                    hVar.f1879f = new HashMap();
                    hVar.d = Long.valueOf(jVar.f4750g.getTime());
                    hVar.e = Long.valueOf(jVar.f4751h.getTime());
                    hVar.f1878a = "GDT_CLIENT_METRICS";
                    C0569b c0569b = new C0569b("proto");
                    c0751a.getClass();
                    B2.d dVar = q.f1890a;
                    dVar.getClass();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        HashMap map = (HashMap) dVar.c;
                        iterable = iterable2;
                        try {
                            new L0.d(byteArrayOutputStream, (HashMap) dVar.b, map, (K0.a) dVar.d).g(c0751a);
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        iterable = iterable2;
                    }
                    hVar.c = new n(c0569b, byteArrayOutputStream.toByteArray());
                    arrayList.add(transportBackend.decorate(hVar.b()));
                } else {
                    iterable = iterable2;
                }
                eVarSend = transportBackend.send(new C0694a(arrayList, bArr));
            }
            n.b bVar = (n.b) eVarSend;
            if (bVar.f4158a == 2) {
                final Iterable iterable3 = iterable;
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: s.h
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        j jVar2 = this.f4746a;
                        EventStore eventStore = jVar2.c;
                        eventStore.recordFailure(iterable3);
                        eventStore.recordNextCallTime(kVar, jVar2.f4750g.getTime() + jMax);
                        return null;
                    }
                });
                this.d.schedule(kVar, i + 1, true);
                return;
            }
            jVar = this;
            Iterable iterable4 = iterable;
            synchronizationGuard.runCriticalSection(new R0.d(6, jVar, iterable4));
            int i5 = bVar.f4158a;
            if (i5 == 1) {
                jMax = Math.max(jMax, bVar.b);
                if (bArr != null) {
                    synchronizationGuard.runCriticalSection(new R0.a(jVar, 14));
                }
            } else if (i5 == 4) {
                HashMap map2 = new HashMap();
                Iterator it2 = iterable4.iterator();
                while (it2.hasNext()) {
                    String str = ((com.google.android.datatransport.runtime.i) ((com.google.android.datatransport.runtime.scheduling.persistence.b) ((com.google.android.datatransport.runtime.scheduling.persistence.d) it2.next())).c).f1880a;
                    if (map2.containsKey(str)) {
                        map2.put(str, Integer.valueOf(((Integer) map2.get(str)).intValue() + 1));
                    } else {
                        map2.put(str, 1);
                    }
                }
                synchronizationGuard.runCriticalSection(new R0.d(7, jVar, map2));
            }
        }
    }
}
