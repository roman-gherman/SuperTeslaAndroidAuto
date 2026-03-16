package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import k.C0568a;
import k.C0569b;
import l.C0614a;

/* JADX INFO: loaded from: classes.dex */
public final class v implements TransportInternal {
    public static volatile w e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Clock f1908a;
    public final Clock b;
    public final Scheduler c;
    public final s.j d;

    public v(Clock clock, Clock clock2, Scheduler scheduler, s.j jVar, s.k kVar) {
        this.f1908a = clock;
        this.b = clock2;
        this.c = scheduler;
        this.d = jVar;
        kVar.getClass();
        kVar.f4753a.execute(new androidx.constraintlayout.helper.widget.a(kVar, 16));
    }

    public static v a() {
        w wVar = e;
        if (wVar != null) {
            return (v) ((m) wVar).f1887g.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (v.class) {
                try {
                    if (e == null) {
                        l lVar = new l();
                        context.getClass();
                        lVar.f1884a = context;
                        e = lVar.build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final B2.d c(C0614a c0614a) {
        Set setUnmodifiableSet = c0614a != null ? Collections.unmodifiableSet(c0614a.getSupportedEncodings()) : Collections.singleton(new C0569b("proto"));
        k.d dVar = k.d.f3678a;
        c0614a.getClass();
        return new B2.d(setUnmodifiableSet, new k("cct", c0614a.getExtras(), dVar), this, 6);
    }

    @Override // com.google.android.datatransport.runtime.TransportInternal
    public final void send(t tVar, TransportScheduleCallback transportScheduleCallback) {
        j jVar = (j) tVar;
        k kVar = jVar.f1882a;
        C0568a c0568a = (C0568a) jVar.c;
        k.d dVar = k.d.f3678a;
        String str = kVar.f1883a;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        k kVar2 = new k(str, kVar.b, dVar);
        h hVar = new h();
        hVar.f1879f = new HashMap();
        hVar.d = Long.valueOf(this.f1908a.getTime());
        hVar.e = Long.valueOf(this.b.getTime());
        String str2 = jVar.b;
        if (str2 == null) {
            throw new NullPointerException("Null transportName");
        }
        hVar.f1878a = str2;
        hVar.c = new n(jVar.e, (byte[]) jVar.d.apply(c0568a.f3676a));
        hVar.b = null;
        this.c.schedule(kVar2, hVar.b(), transportScheduleCallback);
    }
}
