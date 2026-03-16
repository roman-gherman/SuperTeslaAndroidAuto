package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2020a;
    public final Object b;
    public final Object c;

    public B(Object obj, Object obj2, Object obj3) {
        this.f2020a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f2020a;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj) + "=" + String.valueOf(this.b) + " and " + String.valueOf(obj) + "=" + String.valueOf(this.c));
    }
}
