package com.google.android.datatransport.runtime;

import android.content.Context;
import javax.inject.Provider;
import o.C0734a;

/* JADX INFO: loaded from: classes.dex */
public final class l implements TransportRuntimeComponent$Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1884a;

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent$Builder
    public final w build() {
        Context context = this.f1884a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        m mVar = new m();
        mVar.f1885a = C0734a.a(p.f1889a);
        com.google.android.material.snackbar.f fVar = new com.google.android.material.snackbar.f(context);
        mVar.b = fVar;
        mVar.c = C0734a.a(new B.h(fVar, new com.google.android.datatransport.runtime.scheduling.persistence.c(fVar, 2), 24, false));
        com.google.android.material.snackbar.f fVar2 = mVar.b;
        mVar.d = new com.google.android.datatransport.runtime.scheduling.persistence.c(fVar2, 1);
        Provider providerA = C0734a.a(new com.google.android.datatransport.runtime.scheduling.persistence.c(fVar2, 0));
        mVar.e = providerA;
        Provider providerA2 = C0734a.a(new B.h(mVar.d, providerA, 15, false));
        mVar.f1886f = providerA2;
        n0.d dVar = new n0.d(10);
        com.google.android.material.snackbar.f fVar3 = mVar.b;
        B2.d dVar2 = new B2.d(fVar3, providerA2, dVar, 13);
        Provider provider = mVar.f1885a;
        Provider provider2 = mVar.c;
        D.b bVar = new D.b(provider, provider2, dVar2, providerA2, providerA2);
        B0.a aVar = new B0.a();
        aVar.b = fVar3;
        aVar.f115a = provider2;
        aVar.c = providerA2;
        aVar.d = dVar2;
        aVar.e = provider;
        aVar.f116f = providerA2;
        aVar.f117g = providerA2;
        mVar.f1887g = C0734a.a(new B2.d(bVar, aVar, new C0.t(provider, providerA2, dVar2, providerA2, 16), 7));
        return mVar;
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent$Builder
    public final TransportRuntimeComponent$Builder setApplicationContext(Context context) {
        context.getClass();
        this.f1884a = context;
        return this;
    }
}
