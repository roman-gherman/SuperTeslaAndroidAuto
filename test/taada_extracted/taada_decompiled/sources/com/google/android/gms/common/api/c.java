package com.google.android.gms.common.api;

import D.e;
import D.j;
import android.content.Context;
import android.os.Build;
import n0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements HasApiKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1930a;
    public final String b;
    public final b c;
    public final e d;
    public final B.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f1932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final B.d f1933h;

    public c(Context context, b bVar, A.c cVar) {
        e eVar = e.f203a;
        j.d(context, "Null context is not permitted.");
        j.d(bVar, "Api must not be null.");
        j.d(cVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        j.d(applicationContext, "The provided context did not have an application context.");
        this.f1930a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.b = attributionTag;
        this.c = bVar;
        this.d = eVar;
        this.e = new B.a(bVar, attributionTag);
        B.d dVarD = B.d.d(applicationContext);
        this.f1933h = dVarD;
        this.f1931f = dVarD.f91h.getAndIncrement();
        this.f1932g = cVar.f0a;
        O.e eVar2 = dVarD.f95m;
        eVar2.sendMessage(eVar2.obtainMessage(7, this));
    }

    @Override // com.google.android.gms.common.api.HasApiKey
    public final B.a getApiKey() {
        return this.e;
    }
}
