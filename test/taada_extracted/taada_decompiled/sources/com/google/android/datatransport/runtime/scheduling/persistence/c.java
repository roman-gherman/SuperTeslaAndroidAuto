package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1898a;
    public final com.google.android.material.snackbar.f b;

    public /* synthetic */ c(com.google.android.material.snackbar.f fVar, int i) {
        this.f1898a = i;
        this.b = fVar;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        switch (this.f1898a) {
            case 0:
                String packageName = ((Context) this.b.f2591a).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
            case 1:
                return new m((Context) this.b.f2591a, Integer.valueOf(m.d).intValue(), "com.google.android.datatransport.events");
            default:
                return new n.g((Context) this.b.f2591a, new D.d(11, (byte) 0), new z5.b(10));
        }
    }
}
