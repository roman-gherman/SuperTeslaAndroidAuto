package com.google.android.material.snackbar;

import D.s;
import android.os.Handler;
import android.os.Looper;
import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Factory, Lazy {
    public static f b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2591a;

    public f() {
        this.f2591a = new Object();
        new Handler(Looper.getMainLooper(), new s(this, 1));
    }

    @Override // javax.inject.Provider
    public Object get() {
        return this.f2591a;
    }

    public f(Object obj) {
        this.f2591a = obj;
    }
}
